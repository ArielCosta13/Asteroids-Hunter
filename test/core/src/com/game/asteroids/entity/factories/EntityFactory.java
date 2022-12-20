
package com.game.asteroids.entity.factories;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonValue;
import com.game.asteroids.assetsmanagment.AssManager;
import com.game.asteroids.entity.components.MovementStatsComponent;
import com.game.asteroids.entity.components.PlayerComponent;
import com.game.asteroids.entity.components.TextureComponent;
import com.game.asteroids.entity.components.TransformComponent;


/**
 *
 * @author Ariel Costa
 */
public class EntityFactory {
    
    private final PooledEngine engine;
    private final AssManager manager;
    


    public EntityFactory(PooledEngine engine, AssManager manager){
        this.engine = engine;
        this.manager = manager;
    }

    
    public Entity addEntity(String template, boolean isPlayer){
        JsonValue entitytemplate = manager.getTemplate(template);
        Entity entity = engine.createEntity();
        if (isPlayer){
              PlayerComponent playerc = engine.createComponent(PlayerComponent.class);
              entity.add(playerc);
              System.out.println("Added component Player");  
        }
        if(entitytemplate.has("MOVEMENTSTATS")){  
            MovementStatsComponent movementc = engine.createComponent(MovementStatsComponent.class);
              JsonValue movement = entitytemplate.get("MOVEMENTSTATS");
              movementc.baseRotationSpeed = movement.getFloat("baseRotationSpeed");
              movementc.baseVelX = movement.getFloat("baseVelX");
              movementc.baseVelY = movement.getFloat("baseVelY");
              movementc.rotationSpeed = movement.getFloat("rotationSpeed");
              movementc.velX = movement.getFloat("velX");
              movementc.velY = movement.getFloat("velY");
              entity.add(movementc);     
        }
        if(entitytemplate.has("TEXTURE")){
               TextureComponent texturec = engine.createComponent(TextureComponent.class);
               entity.add(texturec);
               String atlas = entitytemplate.get("TEXTURE").getString("atlas");
               String textureRegion = entitytemplate.get("TEXTURE").getString("texture");
               entity.getComponent(TextureComponent.class).setTexture(manager.getTextureRegion(atlas, textureRegion));
               System.out.println("Added component Texture");
               TransformComponent transformc = engine.createComponent(TransformComponent.class);
               entity.add(transformc);
               entity.getComponent(TransformComponent.class).position.set(0, 0 ,0);
               entity.getComponent(TransformComponent.class).rotation = 0;
               entity.getComponent(TransformComponent.class).scale = new Vector2(1.0f, 1.0f);
        }
        engine.addEntity(entity);
        return entity;
    }
    
}
