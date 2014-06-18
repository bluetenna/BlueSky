package com.fxb.Game007;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BulletPlayer extends Bullet{
	//Stage stage;
	//TextureRegion region;
	
	public BulletPlayer(){
		init();
	}
	
	private void init(){
		damage = 1;
		region = Asserts.regionBulletBlue;
		setSize( region.getRegionWidth()/1.4f, region.getRegionHeight()/1.4f );		
		setOrigin( getWidth()/2, getHeight()/2 );
	}
	
	public void SetBulletType(){
		switch( Constant.gunType ){
		case Gun_Blue: 
			region = Asserts.regionBulletBlue;
			damage = 1;
			break;
		case Gun_Red: 
			region = Asserts.regionBulletRed;  
			damage = 3;
			break;
		case Gun_Cycn: 
			region = Asserts.regionBulletCycn;  
			damage = 5;
			break;
		default:
			break;
		}
	}
	
}
