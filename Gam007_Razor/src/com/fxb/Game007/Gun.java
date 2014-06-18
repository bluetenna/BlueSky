package com.fxb.Game007;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Gun extends Actor{
	
	//BulletPlayer bullet;
	
	public enum GunType{ Gun_Blue, Gun_Red, Gun_Cycn };
	public enum WorkState{ State_Ready, State_Work, State_Rest };
	
	GunType gunType = GunType.Gun_Blue;		
	TextureRegion region;
	int durability;
	int duraAvailable;
	public WorkState workState = WorkState.State_Ready;
	float totalResumeTime;
	float resumeTime;
	float rate; //rate that can attack
	
	public Gun(){
		init();
	}
	
	private void init(){
		UpdateType();
		Clear();
	}
	
	public void SetType( GunType type ){		
		gunType = type;
		
		UpdateType();
	}
	
	public void UpdateType(){
		switch( gunType ){	
		case Gun_Blue:
			region = Asserts.regionBulletBlue32;
			durability = 100;
			totalResumeTime = 5;
			break;
		
		case Gun_Red:
			region = Asserts.regionBulletRed32;
			durability = 60;
			totalResumeTime = 5;
			break;
			
		case Gun_Cycn:
			region = Asserts.regionBulletCycn32;
			durability = 40;
			totalResumeTime = 5;
			break;
			
		default:
			break;
		}
		
		setSize( region.getRegionWidth(), region.getRegionHeight() );
	}
	
	public void StartWork(){
		workState = WorkState.State_Work;
	}
	
	public void StartRest(){
		workState = WorkState.State_Rest;
		resumeTime = 0;
		rate = ((float)duraAvailable)/durability;
	}
	
	public void Clear(){
		workState = WorkState.State_Ready;
		duraAvailable = durability;
		rate = 1;
	}

	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
		batch.draw( region, getX(), getY(), getWidth(), getHeight() );
		
		super.draw(batch, parentAlpha);
	}
	
	
	
	
}
