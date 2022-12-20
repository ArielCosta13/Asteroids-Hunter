
package com.game.asteroids.entity.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pool.Poolable;

public class TextureComponent implements Component, Poolable {
    public TextureRegion region = null;
    public Vector2 center = new Vector2();


    @Override
    public void reset() {
     // region.getTexture().dispose();
    }

    public void setTexture( TextureRegion tregion ){
        region = tregion;
        center.x = region.getRegionWidth()  / 2.0f;
        center.y = region.getRegionHeight() / 2.0f;
    }


}
