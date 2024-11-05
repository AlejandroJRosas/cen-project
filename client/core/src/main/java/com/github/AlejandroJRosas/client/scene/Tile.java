package com.github.AlejandroJRosas.client.scene;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Tile {
    private Texture texture;
    public Vector2 isoWorldPosition;
    private boolean walkable; // Indica si el tile es transitable

    public Tile(Texture texture, Vector2 isoWorldPosition, Vector2 worldPosition, boolean isWalkable) {
        this.texture = texture;
        this.isoWorldPosition = isoWorldPosition;
        this.walkable = isWalkable; // Asigna el valor de walkable
    }

    public boolean isWalkable() {
        return walkable; // Devuelve si el tile es transitable
    }

    // Implementar la lógica para renderizar el tile
    public void render(SpriteBatch batch, float delta) {
        batch.draw(texture, isoWorldPosition.x, isoWorldPosition.y);
    }

    // Implementar la lógica para detectar colisiones
    public Vector2 isColliding(Vector2 point) {
        // Lógica de colisión con el punto
        // Devuelve la posición de colisión si hay colisión
        return null; // Cambia esto según tu lógica de colisión
    }
}
