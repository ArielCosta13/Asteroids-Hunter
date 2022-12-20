/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.asteroids.entity.systems.tools;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.game.asteroids.entity.components.TransformComponent;


import java.util.Comparator;

public class ZComparator implements Comparator<Entity> {
    private ComponentMapper<TransformComponent> transformM;

    public ZComparator(){
        transformM = ComponentMapper.getFor(TransformComponent.class);
    }

    @Override
    public int compare(Entity entityA, Entity entityB) {
        return (int) Math.signum(transformM.get(entityB).position.z -
                transformM.get(entityA).position.z);
    }
}
