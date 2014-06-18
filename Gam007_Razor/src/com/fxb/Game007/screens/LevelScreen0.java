package com.fxb.Game007.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.fxb.Game007.Asserts;
import com.fxb.Game007.Constant;
import com.fxb.Game007.GameRazor;
import com.fxb.Game007.GameScreen;

public class LevelScreen0 extends ScreenAdapter{

	GameRazor game;
	Stage stage;
	
	Image imgLevel1;
	Image imgLevel2;
	Image imgLevel3;
	Image imgSelect;
	Image[] sImage;
	Image imgEnter;
	
	Skin skin;
	TextButton buttonEnter;
	
	
	
	
	public LevelScreen0( GameRazor game0 ){
		game = game0;
		init();
	}
	
	private void init(){
		
		stage = new Stage();
				
		imgLevel1 = new Image( Asserts.textureLevel1 );
		imgLevel2 = new Image( Asserts.textureLevel2 );
		imgLevel3 = new Image( Asserts.textureLevel3 );
		imgSelect = new Image( Asserts.textureSelect );
		imgEnter = new Image( Asserts.textureEnter );
		
		sImage = new Image[]{ imgLevel1, imgLevel2, imgLevel3 };
		
		imgLevel1.setSize( Asserts.textureLevel1.getWidth(), Asserts.textureLevel1.getHeight() );
		//imgLevel1.setPosition( 20, stage.getHeight()/2-imgLevel1.getHeight()/2 );
		imgLevel1.setPosition( stage.getWidth()/2-imgLevel1.getWidth()/2-20, stage.getHeight()-imgLevel1.getHeight()-50 );
		
		imgLevel2.setSize( Asserts.textureLevel2.getWidth(), Asserts.textureLevel3.getHeight() );
		//imgLevel2.setPosition( imgLevel1.getX()+imgLevel1.getWidth()+20, stage.getHeight()/2-imgLevel2.getHeight()/2 );
		imgLevel2.setPosition( stage.getWidth()/2-imgLevel2.getWidth()/2-20, imgLevel1.getY()-imgLevel2.getHeight()-50 );
		
		imgLevel3.setSize( Asserts.textureLevel2.getWidth(), Asserts.textureLevel3.getHeight() );
		//imgLevel3.setPosition( imgLevel2.getX()+imgLevel2.getWidth()+20, stage.getHeight()/2-imgLevel3.getHeight()/2 );
		imgLevel3.setPosition( stage.getWidth()/2-imgLevel3.getWidth()/2-20, imgLevel2.getY()-imgLevel3.getHeight()-50 );
		
		imgEnter.setSize( Asserts.textureEnter.getWidth(), Asserts.textureEnter.getHeight() );
		imgEnter.setPosition( stage.getWidth()/2-imgEnter.getWidth()/2-20, imgLevel3.getY()-imgEnter.getHeight()-60 );
		
		imgSelect.setSize( Asserts.textureSelect.getWidth(), Asserts.textureSelect.getHeight() );
			
		imgLevel1.addListener( new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// TODO Auto-generated method stub
				Constant.gameLevel = 1;
				SetLevel();
				//game.setScreen( game.gameScreen );
				return true;
			}			
		});		
		imgLevel2.addListener( new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// TODO Auto-generated method stub
				Constant.gameLevel = 2;
				SetLevel();
				//game.setScreen( game.gameScreen );
				return true;
			}			
		});	
		imgLevel3.addListener( new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// TODO Auto-generated method stub
				Constant.gameLevel = 3;
				SetLevel();
				//game.setScreen( game.gameScreen );
				return true;
			}			
		});	
		imgEnter.addListener( new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// TODO Auto-generated method stub
				//game.setScreen( game.gameScreen );
				game.setScreen( new GameScreen(game) );
				return true;
			}			
		});		
		stage.addActor( imgLevel1 );
		stage.addActor( imgLevel2 );
		stage.addActor( imgLevel3 );
		stage.addActor( imgSelect );
		stage.addActor( imgEnter );
		
		skin = new Skin( Gdx.files.internal( "skin/uiskin.json" ) );
		//buttonEnter = new TextButton( "Enter", skin, "default" );
		//stage.addActor( buttonEnter );
		
	}
	
	
	public void SetLevel(){
		int index = Constant.gameLevel - 1;
		
		//System.out.println( sImage.length );
		
		//int index = 1;	
		imgSelect.setPosition( sImage[index].getX()+sImage[index].getWidth()+20, sImage[index].getY() );
		
	}
	

	@Override
	public void show() {
		// TODO Auto-generated method stub
		SetLevel();
		Gdx.input.setInputProcessor( stage );
	}
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor( 0, 1, 1, 1 );
		Gdx.gl.glClear( GL10.GL_COLOR_BUFFER_BIT );
		
		stage.act();
		stage.draw();
	}



	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
		super.dispose();
	}
	
	
}
