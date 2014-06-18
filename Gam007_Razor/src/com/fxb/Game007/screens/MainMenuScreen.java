package com.fxb.Game007.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.fxb.Game007.Asserts;
import com.fxb.Game007.Constant;
import com.fxb.Game007.GameRazor;

public class MainMenuScreen extends ScreenAdapter{

	GameRazor game;
	//Texture textureStart;
	//Image imgStart;
	Stage stage;
	TextButton buttonLevelMode;
	TextButton buttonEndlessMode;
	TextButton buttonHelp;
	TextButton buttonExit;
	TextButton buttonSet;
	Table table;
	Window windowSet;
	boolean isSet = false;
	SetDialog setWindow;
	
	
	public MainMenuScreen( GameRazor game0 ){
		game = game0;
		
		init();
	}
	
	private void init(){
		
		stage = new Stage();
		setWindow = new SetDialog( "Setting", Asserts.skin );
		Constant.CenterStage( stage, setWindow );
		
		/*
		imgStart = new Image( new Texture( Gdx.files.internal( "data/start.png" ) ) );
		imgStart.setPosition( stage.getWidth()/2-imgStart.getWidth()/2, stage.getHeight()/2-imgStart.getHeight()/2 );
		imgStart.addListener( new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// TODO Auto-generated method stub
				//game.setScreen( game.gameScreen );
				game.setScreen( game.levelScreen );
				//MoveToAction moveAction = Actions.moveTo( 600, 200, 2 );
				//imgStart.addAction( moveAction );
				return super.touchDown(event, x, y, pointer, button);
			}
			
		});	
		*/
		
		buttonLevelMode = new TextButton( "Level Mode", Asserts.skin );
		buttonEndlessMode = new TextButton( "Endless Mode", Asserts.skin );
		buttonHelp = new TextButton( "Help", Asserts.skin );		
		buttonExit = new TextButton( "Exit", Asserts.skin );
		buttonSet = new TextButton( "Set", Asserts.skin );
		
		//table = new Table( Asserts.skin );
		table = new Table();
		//table.setSize( 200, 300 );
		table.pad( 30, 50, 30, 50 );
			
		table.defaults().spaceBottom( 30 );
		
		table.row();
		table.add(buttonLevelMode).minSize(150, 50).expandX();
		table.row();
		table.add(buttonEndlessMode).minSize(150, 50).expandX();	
		table.row();
		table.add(buttonHelp).minSize(150, 50).expandX();	
		table.row();
		table.add(buttonExit).minSize(150, 50).expandX();
		table.pack();
		
		buttonSet.setSize( 50, 30 );
		buttonSet.setPosition( 0, stage.getHeight()-buttonSet.getHeight() );
		
		buttonLevelMode.addListener( new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}	
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				game.setScreen( new LevelScreen(game) );
			}
		});
		buttonEndlessMode.addListener( new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}	
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				game.setScreen( new EndlessScreen(game) );
			}		
		});		
		buttonHelp.addListener( new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}	
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				game.setScreen( new HelpScreen(game) );
			}		
		});		
		buttonExit.addListener( new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}	
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.exit();
			}		
		});		
		buttonSet.addListener( new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				//game.setScreen( new (game) );			
				return true;
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				//stage.addActor( setWindow );		
				setWindow.show(stage);
				isSet = true;			

			}
		});			
		table.setPosition( stage.getWidth()/2-table.getWidth()/2, stage.getHeight()/2-table.getHeight()/2 );	
		stage.addActor( table );
		stage.addActor( buttonSet );
			
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
		

		
		ShapeRenderer rend = Asserts.shapeRender;
		rend.begin( ShapeType.Filled );
		rend.setColor( Color.PINK );
		rend.rect( table.getX(), table.getY(), table.getWidth(), table.getHeight() );
		rend.end();
		
		if( isSet ){
			setWindow.act( Gdx.graphics.getDeltaTime() );
			
			
			//stage.draw();
			//SpriteBatch batch = stage.getSpriteBatch();
			//batch.begin();
			//setWindow.draw( batch, 1  );
			//table.draw( batch, 1 );
			//batch.end();
			//setWindow.draw( stage.getSpriteBatch(), 1  );
			/*
	
/*			stage.getCamera().update();
			batch.setProjectionMatrix(stage.getCamera().combined);
			batch.begin();
			stage.getRoot().draw(batch, 0.5f);
			//setWindow.draw( batch, 1  );
			batch.end();*/
			stage.draw();
		}
		else{
			stage.act();
			stage.draw();			
		}

		
	}


	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
		stage.dispose();
		
		super.dispose();
	}

}
