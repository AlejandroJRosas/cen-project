package com.github.AlejandroJRosas.client.scene;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Tilemap {
  private static final String BLOCK_TAG = "0";
  // private static final String T1_BLOCK_TAG = "1";
  // private static final String T2_BLOCK_TAG = "2";
  // private static final String T3_BLOCK_TAG = "3";
  // private static final String T4_BLOCK_TAG = "4";

  private float revealDelay = 0.05f;
  private float elapsedTime = 0f;
  private int currentTileX = 0;
  private int currentTileY = 0;

  private Texture block;
  public LinkedList<Tile> tiles;
  private String[][] map;

  public Tilemap() {
    block = new Texture(Gdx.files.internal("sprites/grass.png"));
    tiles = new LinkedList<Tile>();
    map = new String[10][10];
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

      if (i < currentTileY * map[0].length + currentTileX) {
        tile.render(batch, delta);
      }
    }
  }

  public void fillMap() throws IOException {
    // TODO: Read map from file instead of hardcoding it
    FileHandle mapFile = Gdx.files
        .internal("C:\\Users\\Wilme\\Documents\\GitHub\\cen-project\\client\\assets\\data\\mapBase.txt");
    BufferedReader reader = new BufferedReader(new FileReader(mapFile.path()));
    String s = "";

    int count = 0;
    while ((s = reader.readLine()) != null) {
      map[count] = s.split(" ");
      count++;
    }

    reader.close();

    for (int yCoord = 0; yCoord < map.length; yCoord++) {
      for (int xCoord = 0; xCoord < map[yCoord].length; xCoord++) {
        Vector2 worldPosition = new Vector2(xCoord, yCoord);
        CoordsTransformer transformer = CoordsTransformer.getInstance();
        Vector2 isoCoords = transformer.convertCartesianToIso(worldPosition);

        if (map[yCoord][xCoord].equals(BLOCK_TAG)) {
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
