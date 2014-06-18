package com.fxb.Game007.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.fxb.Game007.Asserts;

public class SetDialog extends Dialog{
	Slider slider1, slider2;
	Label label1;
	Label label2;
	TextButton buttonOk, buttonCancel;
	
	public SetDialog(String title, Skin skin) {
		super(title, skin);
		
		slider1 = new Slider( 0, 100, 1, false, Asserts.skin );
		slider2 = new Slider( 0, 100, 1, false, Asserts.skin );
		label1 = new Label( "Voice", Asserts.skin );
		label2 = new Label( "Sound", Asserts.skin );
		buttonOk = new TextButton( "Ok", Asserts.skin );
		buttonCancel = new TextButton( "Cancel", Asserts.skin );
		
		this.defaults().pad( 5, 10, 5, 10 );
		this.defaults().spaceRight(0);
		this.defaults().spaceBottom(0);
		
		this.row();
		this.add(label1).width(100);
		this.add( slider1 ).width(100);
		
		this.row();
		this.add(label2).width(100);
		this.add( slider2 ).width(100);
		
		//this.row().padLeft(60).padRight(60);
		//this.row().align(Align.center);
		this.row();
		this.add(buttonOk).minWidth(60).align(Align.right);
		this.add(buttonCancel).minWidth(60).align(Align.left);
		//this.button("Ok").button("Cancel");
		this.pack();
		
		buttonOk.addListener( new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}	
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				remove();
			}		
		});
		buttonCancel.addListener( new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return true;
			}	
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				remove();
			}		
		});		
		
		this.pack();
	}

	
	
	
}
