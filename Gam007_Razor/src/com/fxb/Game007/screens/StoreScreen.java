package com.fxb.Game007.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.fxb.Game007.GameRazor;

public class StoreScreen extends ScreenAdapter{
	
	GameRazor game;
	Stage stage;
	Image imageCancel;
	
	public StoreScreen( GameRazor game0 ){
		game = game0;
		init();
	}
	
	private void init(){
		stage = new Stage();
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		Gdx.input.setInputProcessor( stage );
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor( 0, 1, 1, 1 );
		Gdx.gl.glClear( GL10.GL_COLOR_BUFFER_BIT );
		
		stage.act();
		stage.draw();
		
		super.render(delta);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub		
		stage.dispose();		
		super.dispose();
	}

}
