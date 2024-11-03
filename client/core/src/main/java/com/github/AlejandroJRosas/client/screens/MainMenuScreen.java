package com.github.AlejandroJRosas.client.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.github.AlejandroJRosas.client.Core;

public class MainMenuScreen implements Screen {
    private final Core game;
    private final Stage stage;
    private final SpriteBatch batch;
    
    // Texturas y variables para el fondo en movimiento
    private final Texture cloudTexture;
    private float backgroundOffsetX;
    private final float cloudSpeed = 50; // Velocidad de movimiento de las nubes
    
    public MainMenuScreen(Core game) {
        this.game = game;
        this.batch = game.getBatch();

        // Configuración de la textura de fondo de nubes
        cloudTexture = new Texture("C:\\Users\\Usuario\\Documents\\GitHub\\cen-project\\client\\assets\\background.png"); // Ruta de la imagen de nubes
        backgroundOffsetX = 0; // Posición inicial en X

        stage = new Stage();

        // Configuración de la fuente
        BitmapFont font = new BitmapFont();
        font.getData().setScale(2f);

        // Estilo del botón
        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = font;
        buttonStyle.up = createRoundedDrawable(Color.DARK_GRAY, 300, 60, 15);
        buttonStyle.down = createRoundedDrawable(Color.LIGHT_GRAY, 300, 60, 15);
        buttonStyle.over = createRoundedDrawable(Color.FOREST, 300, 60, 15);

        // Botones
        TextButton playButton = new TextButton("Play", buttonStyle);
        TextButton howToPlayButton = new TextButton("How to Play", buttonStyle);
        TextButton exitButton = new TextButton("Exit", buttonStyle);

        // Listener de botón para iniciar el juego
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new LoginScreen(game)); // Cambia a la pantalla de Login
            }
        });

        howToPlayButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Aquí puedes implementar una pantalla de instrucciones
            }
        });

        // Listener de botón para salir del juego
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

        // Etiqueta de título
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont(); // Usa la fuente predeterminada
        labelStyle.font.getData().setScale(4.0f); // Aumenta el tamaño de la fuente solo para este Label
        labelStyle.fontColor = Color.FOREST;
        Label titleLabel = new Label("ECO TRAILS", labelStyle);

        // Tabla de disposición
        Table table = new Table();
        table.setFillParent(true);
        table.add(titleLabel).padBottom(20);
        table.row();
        table.add(playButton).width(300).height(60).padBottom(20);
        table.row();
        table.add(howToPlayButton).width(300).height(60).padBottom(20);
        table.row();
        table.add(exitButton).width(300).height(60).padBottom(20);

        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);
    }

    // Método para crear el fondo de los botones con esquinas redondeadas
    private Drawable createRoundedDrawable(Color color, int width, int height, int radius) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fillRectangle(radius, 0, width - 2 * radius, height);
        pixmap.fillRectangle(0, radius, width, height - 2 * radius);
        pixmap.fillCircle(radius, radius, radius);
        pixmap.fillCircle(width - radius - 1, radius, radius);
        pixmap.fillCircle(radius, height - radius - 1, radius);
        pixmap.fillCircle(width - radius - 1, height - radius - 1, radius);

        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return new TextureRegionDrawable(new TextureRegion(texture));
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        // Actualizar la posición de las nubes
        backgroundOffsetX -= cloudSpeed * delta;
        if (backgroundOffsetX <= -cloudTexture.getWidth()) {
            backgroundOffsetX = 0;
        }

        // Dibujar el fondo animado de nubes
        batch.begin();
        batch.draw(cloudTexture, backgroundOffsetX, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(cloudTexture, backgroundOffsetX + cloudTexture.getWidth(), 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();

        // Dibujar la UI
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
        cloudTexture.dispose();
    }
}

