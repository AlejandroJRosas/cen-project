package com.github.AlejandroJRosas.client.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class LoginScreen implements Screen {
    private Core game;
    private Stage stage;
    private TextField nameField;
    private TextButton startButton;
    private Texture backgroundTexture;
    private SpriteBatch batch;

    // Variable para controlar el desplazamiento horizontal del fondo
    private float backgroundOffsetX = 0f; // Offset inicial
    private float cloudSpeed = 50; // Velocidad del desplazamiento

    public LoginScreen(Core game) {
        this.game = game;
        this.batch = game.getBatch();

        // Cargar la imagen de fondo (nubes)
        backgroundTexture = new Texture("C:\\Users\\Usuario\\Documents\\GitHub\\cen-project\\client\\assets\\background.png");

        stage = new Stage();

        // Fuente para los elementos de UI
        BitmapFont font = new BitmapFont();
        font.getData().setScale(1.5f);

        // Estilo del campo de texto
        TextField.TextFieldStyle textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = font;
        textFieldStyle.fontColor = Color.WHITE;
        textFieldStyle.messageFontColor = Color.LIGHT_GRAY;
        textFieldStyle.background = createRoundedDrawable(Color.DARK_GRAY, 300, 60, 15);
        textFieldStyle.cursor = createDrawable(Color.WHITE);
        textFieldStyle.selection = createDrawable(Color.LIGHT_GRAY);

        nameField = new TextField("", textFieldStyle);
        nameField.setMessageText("Enter your name");

        // Configuración del botón
        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = font;
        buttonStyle.up = createRoundedDrawable(Color.DARK_GRAY, 300, 60, 15); // Fondo normal
        buttonStyle.down = createRoundedDrawable(Color.LIGHT_GRAY, 300, 60, 15); // Fondo presionado
        buttonStyle.over = createRoundedDrawable(Color.FOREST, 300, 60, 15); // Fondo al pasar el cursor

        startButton = new TextButton("Start Game", buttonStyle);

        // Etiqueta de instrucciones
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont(); // Usa la fuente predeterminada
        labelStyle.font.getData().setScale(4.0f); // Aumenta el tamaño de la fuente solo para este Label
        labelStyle.fontColor = Color.FOREST;

        Label instructionLabel = new Label("Enter your name:", labelStyle);

        // Disposición en una tabla
        Table table = new Table();
        table.setFillParent(true);
        table.add(instructionLabel).padBottom(20);
        table.row();
        table.add(nameField).width(300).height(50).padBottom(20);
        table.row();
        table.add(startButton).width(300).height(50).padBottom(20);
        stage.addActor(table);

        // Listener para el botón
        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String playerName = nameField.getText();
                game.setScreen(new GameScreen(game.getBatch())); // Cambia a la pantalla del juego
            }
        });

        Gdx.input.setInputProcessor(stage);
    }

    // Método para crear un Drawable sólido
    private Drawable createDrawable(Color color) {
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();
        Texture texture = new Texture(pixmap);
        pixmap.dispose(); // Liberar recursos
        return new TextureRegionDrawable(texture);
    }

    // Método para crear un Drawable con bordes redondeados
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
        // Actualizar el desplazamiento de las nubes
        backgroundOffsetX -= cloudSpeed * delta; // Desplaza hacia la izquierda
        if (backgroundOffsetX <= -backgroundTexture.getWidth()) {
            backgroundOffsetX = 0; // Reinicia el desplazamiento cuando llegue al final
        }

        // Dibujar la imagen de fondo desplazada
        batch.begin();
        batch.draw(backgroundTexture, backgroundOffsetX, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(backgroundTexture, backgroundOffsetX + backgroundTexture.getWidth(), 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
        backgroundTexture.dispose();
    }
}
