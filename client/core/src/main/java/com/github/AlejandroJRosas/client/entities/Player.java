package com.github.AlejandroJRosas.client.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.github.AlejandroJRosas.client.scene.Tilemap;
import com.github.AlejandroJRosas.client.scene.Tile;

public class Player implements Entity {
    private static final int FRAME_COLS = 8, FRAME_ROWS = 16;
    private static final float X_SPEED = 1.5f, Y_SPEED = X_SPEED * 0.5f;
    private static final float FRAME_DURATION = 0.1f;

    private Vector2 position;
    private OrthographicCamera camera;
    private boolean isCameraAttached;
    private float stateTime;
    private Tilemap tileMap; // Referencia al TileMap

    private Texture sheet;
    private Animation<TextureRegion> currentAnimation;

    // Agregamos las animaciones necesarias
    private Animation<TextureRegion> upAnimation, downAnimation, leftAnimation, rightAnimation;
    private Animation<TextureRegion> bottomLeftAnimation, bottomRightAnimation, topLeftAnimation, topRightAnimation;
    private Animation<TextureRegion> idleUpAnimation, idleDownAnimation, idleLeftAnimation, idleRightAnimation;
    private Animation<TextureRegion> idleBottomLeftAnimation, idleBottomRightAnimation, idleTopLeftAnimation, idleTopRightAnimation;

    public Player(OrthographicCamera camera, Tilemap tileMap) {
        this.camera = camera;
        this.tileMap = tileMap; // Asignar el TileMap al jugador

        sheet = new Texture(Gdx.files.internal("sprites/player-move.png"));
        TextureRegion[][] tmp = TextureRegion.split(sheet, sheet.getWidth() / FRAME_COLS, sheet.getHeight() / FRAME_ROWS);

        // Configurar las animaciones (igual que antes)
        upAnimation = new Animation<>(FRAME_DURATION, tmp[3]);
        downAnimation = new Animation<>(FRAME_DURATION, tmp[7]);
        leftAnimation = new Animation<>(FRAME_DURATION, tmp[1]);
        rightAnimation = new Animation<>(FRAME_DURATION, tmp[5]);
        bottomLeftAnimation = new Animation<>(FRAME_DURATION, tmp[0]);
        bottomRightAnimation = new Animation<>(FRAME_DURATION, tmp[6]);
        topLeftAnimation = new Animation<>(FRAME_DURATION, tmp[2]);
        topRightAnimation = new Animation<>(FRAME_DURATION, tmp[4]);

        // Inicializar animaciones en estado idle
        idleUpAnimation = new Animation<>(FRAME_DURATION, tmp[14][0]);
        idleDownAnimation = new Animation<>(FRAME_DURATION, tmp[15][0]);
        idleLeftAnimation = new Animation<>(FRAME_DURATION, tmp[8][0]);
        idleRightAnimation = new Animation<>(FRAME_DURATION, tmp[8][0]);
        idleBottomLeftAnimation = new Animation<>(FRAME_DURATION, tmp[11][0]);
        idleBottomRightAnimation = new Animation<>(FRAME_DURATION, tmp[12][0]);
        idleTopLeftAnimation = new Animation<>(FRAME_DURATION, tmp[10][0]);
        idleTopRightAnimation = new Animation<>(FRAME_DURATION, tmp[9][0]);

        // Setear posición inicial y animación
        position = new Vector2(0, 0);
        isCameraAttached = true;
        stateTime = 0;
        currentAnimation = idleDownAnimation;
    }

    @Override
    public void render(SpriteBatch batch) {
        TextureRegion currentFrame = currentAnimation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame, position.x, position.y);
    }

    @Override
    public void update(float delta) {
        stateTime += delta;
        move();
        setCameraAttached();
    }

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
            movement.nor(); // Normaliza el vector de movimiento
            movement.scl(X_SPEED); // Escala por la velocidad
    
            // Nueva posición tentativa
            Vector2 newPosition = position.cpy().add(movement);
    
            // Verificar el tile objetivo
            Tile targetTile = tileMap.getTileAt(newPosition.x, newPosition.y);
    
            // Asegúrate de que el tile existe y es transitable
            if (targetTile != null && targetTile.isWalkable()) {
                position.set(newPosition); // Mueve solo si es transitable
                if (isCameraAttached) {
                    camera.position.set(position.x, position.y, 0);
                }
            }
        }
    
        // Actualizar la animación
        updateAnimation(isMoveUpKeyPressed, isMoveDownKeyPressed, isMoveLeftKeyPressed, isMoveRightKeyPressed);
        stateTime += Gdx.graphics.getDeltaTime(); // Actualiza el estado de la animación
    }
    

    private void setCameraAttached() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.C)) {
            this.isCameraAttached = !this.isCameraAttached;
        }
    }

    private void updateAnimation(boolean up, boolean down, boolean left, boolean right) {
        if (up && left) {
            currentAnimation = topLeftAnimation;
        } else if (up && right) {
            currentAnimation = topRightAnimation;
        } else if (down && left) {
            currentAnimation = bottomLeftAnimation;
        } else if (down && right) {
            currentAnimation = bottomRightAnimation;
        } else if (up) {
            currentAnimation = upAnimation;
        } else if (left) {
            currentAnimation = leftAnimation;
        } else if (right) {
            currentAnimation = rightAnimation;
        } else if (down) {
            currentAnimation = downAnimation;
        }
    }

    private void setIdleAnimation() {
        // Cambiar a la animación en estado idle según la dirección actual
        if (currentAnimation == upAnimation) currentAnimation = idleUpAnimation;
        else if (currentAnimation == downAnimation) currentAnimation = idleDownAnimation;
        else if (currentAnimation == leftAnimation) currentAnimation = idleLeftAnimation;
        else if (currentAnimation == rightAnimation) currentAnimation = idleRightAnimation;
        else if (currentAnimation == bottomLeftAnimation) currentAnimation = idleBottomLeftAnimation;
        else if (currentAnimation == bottomRightAnimation) currentAnimation = idleBottomRightAnimation;
        else if (currentAnimation == topLeftAnimation) currentAnimation = idleTopLeftAnimation;
        else if (currentAnimation == topRightAnimation) currentAnimation = idleTopRightAnimation;
    }

    public Vector2 getPosition() {
        return position;
    }
}
