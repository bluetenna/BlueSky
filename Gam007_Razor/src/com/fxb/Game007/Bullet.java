package com.fxb.Game007;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Bullet extends Actor{

	/*
	Stage stage;
	//Texture texture;
	TextureRegion region;
	
	public Bullet( Stage stage0 ){
		stage = stage0;
		init();
	}
	
	private void init(){
		//texture = new Texture( Gdx.files.internal( "" ) );
		region = Asserts.regionBulletBlue;
	}
	*/
	
	//Stage stage;
	TextureRegion region;
	int damage = 1;
	
	/*
	void SetStage( Stage stage0 ){
		stage = stage0;
	}
	*/
	
	public boolean IsAlive( float leftX ){
		if( this.getActions().size == 1 ){
			return false;
		}
		Stage stage = getStage();
		if( getX()<leftX || getX()>leftX+stage.getWidth() || getY()<0 || getY()>stage.getHeight() ){
			return false;
		}
		
		return true;
	} 
	
	
	public void Clear(){
		getActions().clear();
	}
	
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		setOrigin( getWidth()/2, getHeight()/2 );
		//batch.draw( region, getX(), getY(), getWidth(), getHeight() );
		batch.draw( region, getX(), getY(), this.getOriginX(), this.getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation() );
		
		super.draw(batch, parentAlpha);
	}
	
}
