package com.github.AlejandroJRosas.client;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;

public class IsometricRenderer {
	public static final int TILE_WIDTH = 32;
	public static final int TILE_HEIGHT = 32;

	private int[][] map;

	private Texture grass;
	private Texture space;

	public IsometricRenderer() {
		grass = new Texture(Gdx.files.internal("sprites/grass.png"));
		space = new Texture(Gdx.files.internal("sprites/void.png"));
		map = generateMap();
	}

	public void drawGround(SpriteBatch batch) {
		for (int row = map.length - 1; row >= 0; row--) {
			for (int col = map[row].length - 1; col >= 0; col--) {
				float x = (col - row) * (TILE_WIDTH / 2f);
				float y = (col + row) * (TILE_HEIGHT / 4f);

				if (map[row][col] == 1) {
					batch.draw(grass, x, y, TILE_WIDTH, TILE_HEIGHT);
				} else {
					batch.draw(space, x, y, TILE_WIDTH, TILE_HEIGHT);
				}

			}
		}

		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			map = generateMap();
		}
	}

	private int[][] generateMap() {
		Random r = new Random();
		int width = r.nextInt(5, 20);
		int height = r.nextInt(5, 20);

		int[][] map = new int[width][height];

		Random random = new Random();

		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				map[row][col] = random.nextInt(2);
			}
		}

		map[0][0] = 1;

		return map;
	}
}
