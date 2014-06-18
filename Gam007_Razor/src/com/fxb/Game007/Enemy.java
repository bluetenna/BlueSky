package com.fxb.Game007;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Enemy extends Actor{
	float lastAttackTime;
	float currentTime;
	
	float currentHp;
	TextureRegion region;
	int maxHp = 3;
	
	Pixmap pixmapHp;
	Texture textureHpGreen;
	Texture textureHpRed;
	
	@Override	
	public void act(float delta) {
		// TODO Auto-generated method stub
		currentTime += delta;
		super.act(delta);
	}
	
	//ShapeRenderer rend = new ShapeRenderer();
	
	//ShapeRenderer rend;
	
	public void Clear(){
		clearActions();
		addAction( Actions.rotateTo( 0 ) );
		addAction( Actions.scaleTo( 1, 1 ) );
		currentHp = maxHp;
	}
	
	
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
		
/*		ShapeRenderer rend = Asserts.shapeRender;
		rend.setColor( Color.BLACK );
		rend.begin( ShapeType.Line );
		rend.line( getX(), getY()+getHeight(), getWidth(), 6 );
		rend.end();
		
		if( (float)(currentHp/maxHp) > 0.5 )
		{
			rend.setColor( Color.GREEN );			
		}
		else
		{
			rend.setColor( Color.RED );
		}
		rend.begin( ShapeType.Filled );
		rend.rect( getX(), getY()+getHeight()+1, getWidth()*currentHp/maxHp, 4 );
		rend.end();	*/	
		
		
		if( ((float)currentHp)/maxHp > 0.5 )
		{
			//pixmap.setColor( Color.GREEN );	
			batch.draw( textureHpGreen, this.getX(), this.getY()+this.getHeight(), textureHpGreen.getWidth()*currentHp/maxHp, textureHpGreen.getHeight() );
		}
		else
		{
			//pixmap.setColor( Color.RED );
			batch.draw( textureHpRed, this.getX(), this.getY()+this.getHeight(), textureHpRed.getWidth()*currentHp/maxHp, textureHpRed.getHeight() );
		}
					
		//batch.draw( region, getX(), getY(), getWidth(), getHeight() );
		batch.draw( region, getX(), getY(), this.getOriginX(), this.getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation() );
		
		
		super.draw(batch, parentAlpha);
	}
	
	
}
