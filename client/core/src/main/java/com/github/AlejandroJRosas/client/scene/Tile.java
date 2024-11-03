package com.github.AlejandroJRosas.client.scene;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Tile {
  private Texture texture;
  public Vector2 worldPosition;
  public Vector2 isoWorldPosition;

  private float animationY, time, animationAux;

  public Tile(Texture texture, Vector2 isoWorldPosition, Vector2 worldPosition) {
    this.texture = texture;
    this.worldPosition = worldPosition;
    this.isoWorldPosition = isoWorldPosition;
    this.animationY = isoWorldPosition.y - 32;
    this.animationAux = 0;
  }

  public void render(SpriteBatch batch, float delta) {
    if (time > 0.01f) {
      if (animationY < isoWorldPosition.y) {
        animationY += 2;
      }
      time = 0;
    } else {
      time += delta;
    }

    batch.draw(texture, isoWorldPosition.x, animationY - animationAux);
  }

  public void changeTexture(Texture texture) {
    this.texture = texture;
  }

  public Vector2 getPosition() {
    return worldPosition;
  }

  /*
   * TODO: Improve the colliding tile detection to only detect the visual part of
   * the tile that is actually colliding with the point
   */
  public Vector2 isColliding(Vector2 point) {
    if (isoWorldPosition.x < point.x && isoWorldPosition.x + texture.getWidth() > point.x
        && isoWorldPosition.y < point.y && isoWorldPosition.y + texture.getHeight() > point.y) {
      animationAux = 1.5f;
      return worldPosition;
    }
    animationAux = 0;
    return null;
  }
}
