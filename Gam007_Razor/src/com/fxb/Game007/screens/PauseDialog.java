package com.fxb.Game007.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.fxb.Game007.Asserts;
import com.fxb.Game007.Constant;
import com.fxb.Game007.GameRazor;

public class PauseDialog extends Dialog{

	TextButton button1, button2, button3;
	GameRazor game;
	Stage stage;
	
	public PauseDialog(String title, Skin skin, GameRazor game0, Stage stage0) {
		super(title, skin);
		game = game0;
		stage = stage0;
		
		button1 = new TextButton( "Continue", Asserts.skin );
		button2 = new TextButton( "Back", Asserts.skin );
		button3 = new TextButton( "Exit", Asserts.skin );
		
		this.defaults().pad( 5, 5, 5, 5 );
		this.defaults().spaceRight(0);
		this.defaults().spaceBottom(0);
		
		this.row();
		this.add(button1).minWidth(100);
		this.row();
		this.add(button2).minWidth(100);
		this.row();
		this.add(button3).minWidth(100);
		
		this.pack();
		
		button1.addListener( new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}	
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				Constant.gameState = Constant.GameState.Game_On;
				//show( stage );
				remove();
			}		
		});
		button2.addListener( new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}	
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				game.setScreen( new LevelScreen(game) );
				remove();
			}		
		});		
		button3.addListener( new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}	
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.exit();
			}		
		});			
		this.pack();
	}

	
	
	
}
