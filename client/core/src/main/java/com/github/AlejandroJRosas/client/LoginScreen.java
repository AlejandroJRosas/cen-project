package com.github.AlejandroJRosas.client;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class LoginScreen implements Screen {
    private Core game;
    private Stage stage;
    private TextField nameField;
    private TextButton startButton;

    public LoginScreen(Core game) {
        this.game = game;
        stage = new Stage();

        // Font for UI elements
        BitmapFont font = new BitmapFont();
        font.getData().setScale(1.5f); // Optional: Increase font size if needed

        // Style for the TextField
        TextFieldStyle textFieldStyle = new TextFieldStyle();
        textFieldStyle.font = font;
        textFieldStyle.fontColor = Color.WHITE;
        textFieldStyle.background = createDrawable(Color.DARK_GRAY); // Background color of TextField

        // TextField with basic style
        nameField = new TextField("", textFieldStyle);
        nameField.setMessageText(" Enter your name"); // Placeholder text

        // Create button styles
        TextButtonStyle buttonStyle = new TextButtonStyle();
        buttonStyle.font = font;
        buttonStyle.fontColor = Color.WHITE;

        // Create solid color textures for button states
        buttonStyle.up = createDrawable(Color.DARK_GRAY); // Default button color
        buttonStyle.down = createDrawable(Color.LIGHT_GRAY); // Color when pressed
        buttonStyle.over = createDrawable(Color.YELLOW); // Color when hovered

        // Create TextButton with the defined style
        startButton = new TextButton("Start Game", buttonStyle);

        // Label for instructions
        LabelStyle labelStyle = new LabelStyle();
        labelStyle.font = font;
        labelStyle.fontColor = Color.WHITE;
        Label instructionLabel = new Label("Enter your name:", labelStyle);

        // Arrange elements in a table
        Table table = new Table();
        table.setFillParent(true);
        table.add(instructionLabel).padBottom(20);
        table.row();
        table.add(nameField).width(200).padBottom(20);
        table.row();
        table.add(startButton).width(200).padBottom(20);
        stage.addActor(table);

        // Button click listener to switch screens
        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String playerName = nameField.getText();
                game.setScreen(new GameScreen(game.getBatch())); // Change to GameScreen
            }
        });

        Gdx.input.setInputProcessor(stage);
    }

    private Drawable createDrawable(Color color) {
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();
        Texture texture = new Texture(pixmap);
        pixmap.dispose(); // Dispose of the pixmap to free resources
        return new TextureRegionDrawable(texture);
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
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
    }
}
