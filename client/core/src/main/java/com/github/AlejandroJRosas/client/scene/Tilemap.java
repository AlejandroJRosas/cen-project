package com.github.AlejandroJRosas.client.scene;

import java.io.IOException;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.github.AlejandroJRosas.client.scene.maps.Maps;
import com.github.AlejandroJRosas.client.utils.CoordsTransformer;

public class Tilemap {
  private float revealDelay = 0.05f;
  private float elapsedTime = 0f;
  private int currentTileX = 0;
  private int currentTileY = 0;

  private Texture block;
  public LinkedList<Tile> tiles;
  private int[][] map;

  public Tilemap() {
    block = new Texture(Gdx.files.internal("sprites/grass.png"));
    tiles = new LinkedList<Tile>();
    try {
      fillMap();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void update(float deltaTime) {
    elapsedTime += deltaTime;

    if (elapsedTime >= revealDelay) {
      if (currentTileY < map.length) {
        currentTileX++;

        if (currentTileX >= map[0].length) {
          currentTileX = 0;
          currentTileY++;
        }
      }

      elapsedTime = 0f;
    }
  }

  public void render(SpriteBatch batch, float delta) {
    for (int i = 0; i < tiles.size(); i++) {
      Tile tile = tiles.get(i);

      tile.render(batch, delta);
    }
  }

  public void fillMap() throws IOException {
    map = Maps.MAP_1;

    for (int yCoord = 0; yCoord < map.length; yCoord++) {
      for (int xCoord = 0; xCoord < map[yCoord].length; xCoord++) {
        Vector2 worldPosition = new Vector2(xCoord, yCoord);
        CoordsTransformer transformer = CoordsTransformer.getInstance();
        Vector2 isoCoords = transformer.convertCartesianToIso(worldPosition);

        if (map[yCoord][xCoord] == Maps.BLOCK_TAG) {
          tiles.add(new Tile(block, isoCoords, worldPosition));
        }
      }
    }
  }

  public LinkedList<Tile> getTiles() {
    return tiles;
  }

  public Vector2[] getCollidingTile(Vector2 point) {
    for (Tile tile : tiles) {
      Vector2 collidingTile = tile.isColliding(point);

      if (collidingTile != null) {
        return new Vector2[] { collidingTile, tile.isoWorldPosition };
      }
    }

    return null;
  }
}
