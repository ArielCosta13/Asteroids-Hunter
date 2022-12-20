
package com.game.asteroids.entity.components;


import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class TransformComponent implements Component, Listener<Float> {
    public Vector3 position = new Vector3();
    public Vector2 scale = new Vector2(1.0f, 1.0f);
    public float rotation = 0.0f;
    public boolean isHidden = false;

    @Override
    public void receive(Signal<Float> signal, Float rotationchange) {
        rotation += rotationchange;
    }
}