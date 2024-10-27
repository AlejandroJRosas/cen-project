package com.github.AlejandroJRosas.client;

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
  public LinkedList<Tile> base, objects;
  private Texture hill, water, grass, player;
  private String[][] map;

  public Tilemap() {
    hill = new Texture(Gdx.files.internal("sprites/grass.png"));
    water = new Texture(Gdx.files.internal("sprites/void.png"));
    grass = new Texture(Gdx.files.internal("sprites/grass.png"));
    player = new Texture(Gdx.files.internal("sprites/player.png"));
    base = new LinkedList<Tile>();
    objects = new LinkedList<Tile>();
    map = new String[10][10];
    try {
      fillMap();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void render(SpriteBatch batch) {
    for (Tile tile : base) {
      tile.render(batch);
    }
    for (Tile tile : objects) {
      tile.render(batch);
    }
  }

  public void fillMap() throws IOException {
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

    for (int row = map.length - 1; row >= 0; row--) {
      for (int col = map[row].length - 1; col >= 0; col--) {
        float x = (row * (grass.getWidth() / 2)) - (col * (grass.getWidth() / 2));
        float y = (row * (grass.getHeight() / 4)) + (col * (grass.getHeight() / 4));

        if (map[row][col].equals("g")) {
          base.add(new Tile(grass, new Vector2(col, row), new Vector2(x, y)));
        } else if (map[row][col].equals("w")) {
          base.add(new Tile(water, new Vector2(col, row), new Vector2(x, y)));
        } else if (map[row][col].equals("h")) {
          base.add(new Tile(hill, new Vector2(col, row), new Vector2(x, y)));
        } else if (map[row][col].equals("p")) {
          objects.add(new Tile(player, new Vector2(col, row), new Vector2(x, y)));

        }
      }

    }
  }

}
