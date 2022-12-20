package com.game.asteroids.entity.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.signals.Signal;
import com.badlogic.ashley.systems.IteratingSystem;
import com.game.asteroids.controller.Controller;
import com.game.asteroids.entity.components.MovementStatsComponent;
import com.game.asteroids.entity.components.PlayerComponent;
import com.game.asteroids.entity.components.TransformComponent;
import com.game.asteroids.entity.factories.EntityFactory;
import static com.game.asteroids.utils.Utility.calculateVectorialX;
import static com.game.asteroids.utils.Utility.calculateVectorialY;
import static com.game.asteroids.utils.Utility.trimRotationValue;



public class PlayerControlSystemNoPhysics extends IteratingSystem {

	ComponentMapper<PlayerComponent> pcm;
	ComponentMapper<TransformComponent> tcm;
	ComponentMapper<MovementStatsComponent> mc;
	Controller controller;
	EntityFactory efac;
	public Signal<Float> playerRotationSignal;

	@SuppressWarnings("unchecked")
	public PlayerControlSystemNoPhysics(Controller keyCon, EntityFactory efactory) {
		super(Family.all(PlayerComponent.class).get());
		controller = keyCon;
		pcm = ComponentMapper.getFor(PlayerComponent.class);
		tcm = ComponentMapper.getFor(TransformComponent.class);
		mc  = ComponentMapper.getFor(MovementStatsComponent.class);
		efac = efactory;
		playerRotationSignal = new Signal<Float>();
	}

	@Override
	protected void processEntity(Entity entity, float deltaTime) {
		if(controller.left){
			tcm.get(entity).rotation += mc.get(entity).rotationSpeed;
			playerRotationSignal.dispatch(mc.get(entity).rotationSpeed);
		}
		if(controller.right){
			tcm.get(entity).rotation -= mc.get(entity).rotationSpeed;
			playerRotationSignal.dispatch(-mc.get(entity).rotationSpeed);
		}
		if(!controller.left && !controller.right){
		}
		if(controller.up){
			tcm.get(entity).position.y += calculateVectorialY(mc.get(entity).velY,tcm.get(entity).rotation);
			tcm.get(entity).position.x += calculateVectorialX(mc.get(entity).velX,tcm.get(entity).rotation);
		}
        if(controller.down){
			tcm.get(entity).position.y = tcm.get(entity).position.y - 1;
        }
        trimRotationValue(tcm.get(entity).rotation);

	}

}
