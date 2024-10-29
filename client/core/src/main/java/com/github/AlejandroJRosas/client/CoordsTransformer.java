package com.github.AlejandroJRosas.client;

import com.badlogic.gdx.math.Vector2;

// SINGLETON
public class CoordsTransformer {
  private static final CoordsTransformer instance = new CoordsTransformer();

  private static final float TILE_WIDTH = 32;
  private static final float TILE_HEIGHT = 32;

  private static final float I_X = 1 * (TILE_WIDTH / 2);
  private static final float I_Y = 0.5f * (TILE_HEIGHT / 2);
  private static final float J_X = -1 * (TILE_WIDTH / 2);
  private static final float J_Y = 0.5f * (TILE_HEIGHT / 2);

  private static final float DET = 1 / I_X * J_Y - I_Y * J_X;
  private static final float I_X_INV = DET * J_Y;
  private static final float I_Y_INV = DET * -I_Y;
  private static final float J_X_INV = DET * -J_X;
  private static final float J_Y_INV = DET * I_X;

  public static CoordsTransformer getInstance() {
    return instance;
  }

  public Vector2 convertCartesianToIso(Vector2 coords) {
    float isoX = (coords.x * I_X) + (coords.y * J_X) + TILE_WIDTH / 2;
    float isoY = (coords.x * I_Y) + (coords.y * J_Y);

    return new Vector2(isoX, -isoY);
  }

  public Vector2 convertIsoToCartesian(Vector2 coords) {
    float cartX = (coords.x * I_X_INV) + (coords.y * J_X_INV) + TILE_WIDTH / 2;
    float cartY = (coords.x * I_Y_INV) + (coords.y * J_Y_INV);

    return new Vector2(cartX, -cartY);
  }

}
