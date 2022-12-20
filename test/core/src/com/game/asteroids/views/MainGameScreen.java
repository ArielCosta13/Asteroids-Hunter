package com.game.asteroids.views;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.asteroids.Asteroids;
import com.game.asteroids.controller.Controller;
import com.game.asteroids.entity.factories.EntityFactory;
import com.game.asteroids.entity.systems.PlayerControlSystemNoPhysics;
import com.game.asteroids.entity.systems.RenderingSystem;


/**
 *
 * @author Ariel Costa
 */
public class MainGameScreen implements Screen {
    
    private SpriteBatch sb;
    private PooledEngine engine;
    private EntityFactory entityFactory;
    private Asteroids parent;
    private Entity player;
    
    private Controller controller;

    public MainGameScreen(Asteroids game){
        parent = game;
        engine = new PooledEngine();
        entityFactory = new EntityFactory(engine, parent.sm);
        sb = new SpriteBatch();
        controller = new Controller();
        addSystems(sb);
        entityFactory.addEntity("BROADSIDE STAR CRUISER VC", true);
    }
    
    @Override
    public void show() {
       Gdx.input.setInputProcessor(controller);
    }

    @Override
    public void render(float delta) {
      Gdx.gl.glClearColor(0f, 0f, 0f, 1);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); 
      engine.update(delta);
    }

    @Override
    public void resize(int i, int i1) {
     
    }

    @Override
    public void pause() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resume() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hide() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void addSystems(SpriteBatch sb){
        RenderingSystem renderingSystem = new RenderingSystem(sb);
        PlayerControlSystemNoPhysics movementSystem = new PlayerControlSystemNoPhysics(controller, entityFactory );
        engine.addSystem(renderingSystem);
        engine.addSystem(movementSystem);
    }
    
      private void setLevel(){
    }
    
}
