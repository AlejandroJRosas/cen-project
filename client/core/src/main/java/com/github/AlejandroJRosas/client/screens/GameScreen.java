package com.github.AlejandroJRosas.client.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.github.AlejandroJRosas.client.entities.Player;
import com.github.AlejandroJRosas.client.scene.Tile;
import com.github.AlejandroJRosas.client.scene.Tilemap;

public class GameScreen extends ScreenAdapter {
    public static final int WIDTH = 320 * 3;
    public static final int HEIGHT = 180 * 3;

    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Tilemap map;
    private Player player;
    Texture voidT = new Texture(Gdx.files.internal("sprites/void.png"));
    Texture block = new Texture(Gdx.files.internal("sprites/grass.png"));

    private static final float START_ZOOM = 0.4f;
    private static final float MIN_ZOOM = 0.4f;
    private static final float MAX_ZOOM = 8.0f;
    private static final float ZOOM_STEP = 0.4f;
    private static final float ZOOM_SPEED = 2.5f;

    private float targetZoom;

    public GameScreen(SpriteBatch batch) {
        this.batch = batch;
        map = new Tilemap(); // Inicializamos el Tilemap

        // Cambiamos el constructor de Player para incluir el Tilemap
        camera = new OrthographicCamera(WIDTH, HEIGHT);
        player = new Player(camera, map); // Pasamos el Tilemap al jugador
        camera.zoom = START_ZOOM;
        targetZoom = camera.zoom;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);

        cameraInput();
        player.update(delta); // Actualizamos al jugador con el tiempo delta

        camera.zoom += (targetZoom - camera.zoom) * ZOOM_SPEED * delta;
        camera.update();
        map.update(delta); // Actualizamos el mapa con el tiempo delta

        // Renderizamos el mapa y el jugador
        batch.begin();
        map.render(batch, delta);
        player.render(batch);
        batch.end();
    }

    @Override
	public void show() {
		camera.position.set(0, 0, 10);
		player = new Player(camera, map); // Asegúrate de pasar el mapa
	}


    private void cameraInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.O)) {
            targetZoom = Math.max(MIN_ZOOM, targetZoom - ZOOM_STEP);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.I)) {
            targetZoom = Math.min(MAX_ZOOM - 5, targetZoom + ZOOM_STEP);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.U)) {
            changeZoom(START_ZOOM);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.Y)) {
            changeZoom(MAX_ZOOM);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            camera.position.y += 5;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            camera.position.y -= 5;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            camera.position.x -= 5;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            camera.position.x += 5;
        }
    }

    public void changeZoom(float zoom) {
        targetZoom = zoom;
    }
}
