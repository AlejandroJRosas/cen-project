package com.github.AlejandroJRosas.client;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	public static final int WIDTH = 320 * 3;
	public static final int HEIGHT = 180 * 3;

	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Tilemap map;

	private Player player;

	public GameScreen(SpriteBatch batch) {
		this.batch = batch;
		camera = new OrthographicCamera(WIDTH, HEIGHT);
		map = new Tilemap();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);

		cameraInput();
		player.update(delta);
		camera.update();

		batch.begin();

		map.render(batch);
		player.render(batch);

		batch.end();
	}

	@Override
	public void show() {
		camera.position.set(0, 0, 10);
		player = new Player(camera);
	}

	private void cameraInput() {
		if (Gdx.input.isKeyPressed(Input.Keys.X)) {
			camera.zoom -= 0.01f;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
			camera.zoom += 0.01f;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			camera.translate(-3, 0, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			camera.translate(3, 0, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			camera.translate(0, -3, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			camera.translate(0, 3, 0);
		}
	}
}
