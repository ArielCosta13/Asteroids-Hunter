
package com.game.asteroids.entity.components;

import com.badlogic.ashley.core.ComponentMapper;

public class Mapper {
    public static final ComponentMapper<PlayerComponent> playerCom = ComponentMapper.getFor(PlayerComponent.class);
    public static final ComponentMapper<TextureComponent> texCom = ComponentMapper.getFor(TextureComponent.class);
    public static final ComponentMapper<TransformComponent> transCom = ComponentMapper.getFor(TransformComponent.class);
    public static final ComponentMapper<MovementStatsComponent> movestatCom = ComponentMapper.getFor(MovementStatsComponent.class);
 
}
