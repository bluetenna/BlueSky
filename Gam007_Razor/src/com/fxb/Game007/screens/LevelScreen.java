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
import com.fxb.Game007.GameScreen;

public class LevelScreen extends ScreenAdapter{

	GameRazor game;
	//Texture textureStart;
	//Image imgStart;
	Stage stage;
	TextButton button1;
	TextButton button2;
	TextButton button3;
	TextButton buttonEnter;
	TextButton buttonBack;
	Table table;
	Window windowSet;
	boolean isSet = false;
	SetDialog setWindow;
	TextButton selectButton;
	
	public LevelScreen( GameRazor game0 ){
		game = game0;
		
		init();
	}
	
	private void init(){
		
		stage = new Stage();
		setWindow = new SetDialog( "Setting", Asserts.skin );
		Constant.CenterStage( stage, setWindow );
		
		button1 = new TextButton( "Level1", Asserts.skin );
		button2 = new TextButton( "Level2", Asserts.skin );
		button3 = new TextButton( "Level3", Asserts.skin );		
		buttonEnter = new TextButton( "Enter", Asserts.skin );
		buttonBack = new TextButton( "Back", Asserts.skin );
		
		//table = new Table( Asserts.skin );
		table = new Table();
		//table.setSize( 200, 300 );
		table.pad( 30, 50, 30, 50 );
			
		table.defaults().spaceBottom( 30 );
		
		table.row();
		table.add(button1).minSize(150, 50).expandX();
		table.row();
		table.add(button2).minSize(150, 50).expandX();	
		table.row();
		table.add(button3).minSize(150, 50).expandX();	
		table.row();
		table.add(buttonEnter).minSize(150, 50).expandX();
		table.pack();
		
		buttonBack.setSize( 50, 30 );
		buttonBack.setPosition( 0, stage.getHeight()-buttonBack.getHeight() );
		
		//selectButton = button2;
		SetSelect();
		
		button1.addListener( new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}	
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				//game.setScreen( new LevelScreen0(game) );
				Constant.gameLevel = 1;
				//selectButton = button1;
				SetSelect();
			}
		});
		button2.addListener( new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}	
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				//game.setScreen( new EndlessScreen(game) );
				Constant.gameLevel = 2;
				//selectButton = button2;
				SetSelect();
			}		
		});		
		button3.addListener( new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}	
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				//game.setScreen( new HelpScreen(game) );
				Constant.gameLevel = 3;
				//selectButton = button3;
				SetSelect();
			}		
		});		
		buttonEnter.addListener( new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}	
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				game.setScreen( new GameScreen(game) );
			}		
		});		
		buttonBack.addListener( new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				//game.setScreen( new (game) );			
				return true;
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				game.setScreen( new MainMenuScreen(game) );

			}
		});			
		table.setPosition( stage.getWidth()/2-table.getWidth()/2, stage.getHeight()/2-table.getHeight()/2 );	
		stage.addActor( table );
		stage.addActor( buttonBack );
			
	}
	
	public void SetSelect(){
		TextButton[] buttons = { button1, button2, button3 };
		selectButton = buttons[Constant.gameLevel-1];
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
		
		rend.begin( ShapeType.Line );
		rend.setColor( Color.BLUE );
		rend.rect( table.getX()+selectButton.getX()-1, table.getY()+selectButton.getY()-1, selectButton.getWidth()+3, selectButton.getHeight()+3 );
		rend.end();
		
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
