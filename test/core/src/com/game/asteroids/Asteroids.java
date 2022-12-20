package com.game.asteroids;

import com.badlogic.gdx.Game;
import com.game.asteroids.assetsmanagment.AssManager;
import com.game.asteroids.views.MainGameScreen;


public class Asteroids extends Game {
    
	public final AssManager sm = new AssManager();
        public MainGameScreen mainScreen;
	
	@Override
	public void create () {
                sm.loadResources();
	        mainScreen = new MainGameScreen(this);
                setScreen(mainScreen);
	}

	@Override
	public void dispose () {
		mainScreen.dispose();
                sm.manager.dispose();
	}
}

