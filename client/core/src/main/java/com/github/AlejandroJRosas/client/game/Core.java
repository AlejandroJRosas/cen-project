package com.github.AlejandroJRosas.client.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class Core extends Game {
    private SpriteBatch batch;
    private GameScreen gameScreen;

    @Override
    public void create() {
        batch = new SpriteBatch();
        gameScreen = new GameScreen(batch);
        setScreen(gameScreen);
    }

    @Override
    public void render() {
        super.render();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void dispose() {
    }
}
