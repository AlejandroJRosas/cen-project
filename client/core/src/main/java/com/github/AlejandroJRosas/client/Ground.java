package com.github.AlejandroJRosas.client;

import com.badlogic.gdx.graphics.Texture;

public class Ground {
	private float x, y;
	private Texture tile;

	public Ground(float x, float y, Texture tile) {
		this.x = x;
		this.y = y;
		this.tile = tile;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public Texture getTile() {
		return tile;
	}
}
