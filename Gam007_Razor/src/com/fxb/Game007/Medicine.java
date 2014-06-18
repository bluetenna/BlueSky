package com.fxb.Game007;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Medicine extends Actor{
	
	int addNum;
	TextureRegion region;
	
	public Medicine(){
		init();
	}
	
	private void init(){
		addNum = 5;
		region = Asserts.regionHp;
		setSize( region.getRegionWidth(), region.getRegionHeight() );
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
		batch.draw( region, getX(), getY(), getWidth(), getHeight() );
		
		super.draw(batch, parentAlpha);
	}
	
}
