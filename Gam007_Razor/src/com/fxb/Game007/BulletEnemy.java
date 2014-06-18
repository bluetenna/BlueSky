package com.fxb.Game007;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BulletEnemy extends Bullet{
	//Stage stage;
	//TextureRegion region;
	
	public BulletEnemy(){
		init();
	}
		
	private void init(){
		region = Asserts.regionBulletGray;
		setSize( region.getRegionWidth()/1.5f, region.getRegionHeight()/1.5f );
		//setOrigin( getWidth()/2, getHeight()/2 );
	}
	


}
