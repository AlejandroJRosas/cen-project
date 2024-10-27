package com.github.AlejandroJRosas.client;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Tile {
  private Texture texture;
  public Vector2 tileMapPosition;
  public Vector2 worldPosition;

  public Tile(Texture texture, Vector2 tileMapPosition, Vector2 worldPosition) {
    this.texture = texture;
    this.tileMapPosition = tileMapPosition;
    this.worldPosition = worldPosition;
  }

  public void render(SpriteBatch batch) {
    batch.draw(texture, worldPosition.x, worldPosition.y);
  }
}
