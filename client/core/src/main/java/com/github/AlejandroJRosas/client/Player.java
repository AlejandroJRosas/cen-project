package com.github.AlejandroJRosas.client;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Player implements Entity {
	private static final int FRAME_COLS = 8, FRAME_ROWS = 16;
	private static final float X_SPEED = 1.5f, Y_SPEED = X_SPEED * 0.5f;
	private static final float FRAME_DURATION = 0.1f;

	private Vector2 position;
	private OrthographicCamera camera;
	private float stateTime;

	private Texture sheet;
	private Animation<TextureRegion> currentAnimation;

	// Directions
	private TextureRegion[][] movementFrames = new TextureRegion[FRAME_ROWS][FRAME_COLS];

	// Animations
	private Animation<TextureRegion> upAnimation, downAnimation, leftAnimation, rightAnimation;
	private Animation<TextureRegion> bottomLeftAnimation, bottomRightAnimation, topLeftAnimation, topRightAnimation;
	private Animation<TextureRegion> idleUpAnimation, idleDownAnimation, idleLeftAnimation, idleRightAnimation;
	private Animation<TextureRegion> idleBottomLeftAnimation, idleBottomRightAnimation, idleTopLeftAnimation,
			idleTopRightAnimation;

	public Player(OrthographicCamera camera) {
		this.camera = camera;
		sheet = new Texture(Gdx.files.internal("sprites/PlayerMove.png"));
		TextureRegion[][] tmp = TextureRegion.split(sheet, sheet.getWidth() / FRAME_COLS, sheet.getHeight() / FRAME_ROWS);

		// Populate movement frames
		for (int row = 0; row < FRAME_ROWS; row++) {
			for (int col = 0; col < FRAME_COLS; col++) {
				movementFrames[row][col] = tmp[row][col];
			}
		}

		// Initialize animations
		upAnimation = new Animation<>(FRAME_DURATION, movementFrames[3]);
		downAnimation = new Animation<>(FRAME_DURATION, movementFrames[7]);
		leftAnimation = new Animation<>(FRAME_DURATION, movementFrames[1]);
		rightAnimation = new Animation<>(FRAME_DURATION, movementFrames[5]);
		bottomLeftAnimation = new Animation<>(FRAME_DURATION, movementFrames[0]);
		bottomRightAnimation = new Animation<>(FRAME_DURATION, movementFrames[6]);
		topLeftAnimation = new Animation<>(FRAME_DURATION, movementFrames[2]);
		topRightAnimation = new Animation<>(FRAME_DURATION, movementFrames[4]);

		// Initialize idle animations
		idleUpAnimation = new Animation<>(FRAME_DURATION, movementFrames[14][0]);
		idleDownAnimation = new Animation<>(FRAME_DURATION, movementFrames[15][0]);
		idleLeftAnimation = new Animation<>(FRAME_DURATION, movementFrames[8][0]);
		idleRightAnimation = new Animation<>(FRAME_DURATION, movementFrames[8][0]);
		idleBottomLeftAnimation = new Animation<>(FRAME_DURATION, movementFrames[11][0]);
		idleBottomRightAnimation = new Animation<>(FRAME_DURATION, movementFrames[12][0]);
		idleTopLeftAnimation = new Animation<>(FRAME_DURATION, movementFrames[10][0]);
		idleTopRightAnimation = new Animation<>(FRAME_DURATION, movementFrames[9][0]);

		// Set initial position and animation
		position = new Vector2(0, 14);
		stateTime = 0;
		currentAnimation = idleDownAnimation; // Set to a default animation
	}

	@Override
	public void render(SpriteBatch batch) {
		TextureRegion currentFrame = currentAnimation.getKeyFrame(stateTime, true);
		batch.draw(currentFrame, position.x, position.y);
		camera.position.set(position.x + 32, position.y + 32, 10);
	}

	@Override
	public void update(float delta) {
		stateTime += delta;
		move();
	}

	public Vector2 getPosition() {
		return position;
	}

	// TODO: Implement player collisions with map
	private void move() {
		Vector2 movement = new Vector2(0, 0);
		boolean isMoveUpKeyPressed = Gdx.input.isKeyPressed(Input.Keys.W);
		boolean isMoveLeftKeyPressed = Gdx.input.isKeyPressed(Input.Keys.A);
		boolean isMoveDownKeyPressed = Gdx.input.isKeyPressed(Input.Keys.S);
		boolean isMoveRightKeyPressed = Gdx.input.isKeyPressed(Input.Keys.D);

		if (isMoveUpKeyPressed) {
			movement.y += Y_SPEED;
		}
		if (isMoveDownKeyPressed) {
			movement.y -= Y_SPEED;
		}
		if (isMoveLeftKeyPressed) {
			movement.x -= X_SPEED;
		}
		if (isMoveRightKeyPressed) {
			movement.x += X_SPEED;
		}

		if (movement.len() > 0) {
			movement.nor();
			movement.scl(X_SPEED);

			if (isMoveUpKeyPressed && isMoveLeftKeyPressed) {
				currentAnimation = topLeftAnimation;
			} else if (isMoveUpKeyPressed && isMoveRightKeyPressed) {
				currentAnimation = topRightAnimation;
			} else if (isMoveDownKeyPressed && isMoveLeftKeyPressed) {
				currentAnimation = bottomLeftAnimation;
			} else if (isMoveDownKeyPressed && isMoveRightKeyPressed) {
				currentAnimation = bottomRightAnimation;
			} else if (isMoveUpKeyPressed) {
				currentAnimation = upAnimation;
			} else if (isMoveLeftKeyPressed) {
				currentAnimation = leftAnimation;
			} else if (isMoveRightKeyPressed) {
				currentAnimation = rightAnimation;
			} else if (isMoveDownKeyPressed) {
				currentAnimation = downAnimation;
			}
		} else {
			if (currentAnimation == upAnimation) {
				currentAnimation = idleUpAnimation;
			} else if (currentAnimation == downAnimation) {
				currentAnimation = idleDownAnimation;
			} else if (currentAnimation == leftAnimation) {
				currentAnimation = idleLeftAnimation;
			} else if (currentAnimation == rightAnimation) {
				currentAnimation = idleRightAnimation;
			} else if (currentAnimation == bottomLeftAnimation) {
				currentAnimation = idleBottomLeftAnimation;
			} else if (currentAnimation == bottomRightAnimation) {
				currentAnimation = idleBottomRightAnimation;
			} else if (currentAnimation == topLeftAnimation) {
				currentAnimation = idleTopLeftAnimation;
			} else if (currentAnimation == topRightAnimation) {
				currentAnimation = idleTopRightAnimation;
			}
		}

		position.add(movement);
		stateTime += Gdx.graphics.getDeltaTime();
	}
}
