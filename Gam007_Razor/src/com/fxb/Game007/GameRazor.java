package com.fxb.Game007;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.fxb.Game007.screens.LevelScreen;
import com.fxb.Game007.screens.LevelScreen0;
import com.fxb.Game007.screens.MainMenuScreen;
import com.fxb.Game007.screens.StoreScreen;

public class GameRazor extends Game{

	GameScreen gameScreen;
	MainMenuScreen mainMenuScreen;
	StoreScreen storeScreen;
	LevelScreen levelScreen;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
		Asserts.Init();
		
		mainMenuScreen = new MainMenuScreen( this );
		gameScreen = new GameScreen( this );
		storeScreen = new StoreScreen( this );
		levelScreen = new LevelScreen( this );
		
		setScreen( mainMenuScreen );
	}

	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
			
		gameScreen.dispose();
		mainMenuScreen.dispose();
		storeScreen.dispose();
		
		Asserts.Dispose();
		
		Gdx.app.log( "razor", "dispose" );
		
		super.dispose();
	}
	

}
