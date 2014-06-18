package com.fxb.Game007;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Archer extends Enemy{
	//Stage stage;
	//TextureRegion region;

	//static final int maxHp = 3;
	
	//ShapeRenderer rend;
	
/*	Pixmap pixmapHp;
	Texture textureHpGreen;
	Texture textureHpRed;
	int maxHp = 3;*/
	
	public Archer(){
		init();
	}
		
	private void init(){
		maxHp = 3;
		region = Asserts.regionArcher;
		setSize( region.getRegionWidth()/1.5f, region.getRegionHeight()/1.5f );
		//setPosition( 600, 50 );
		currentHp = maxHp;
		//rend = new ShapeRenderer();
		//rend = Constant.rend;
		
		pixmapHp = new Pixmap( 128, 4, Format.RGBA8888 );
		pixmapHp.setColor( Color.BLACK );
		pixmapHp.drawRectangle( 0, 0, (int)getWidth(), 4 );
		pixmapHp.setColor( Color.GREEN );
		pixmapHp.fillRectangle( 1, 1, (int)getWidth(), 2 );
		textureHpGreen = new Texture( pixmapHp );
		pixmapHp.setColor( Color.RED );
		pixmapHp.fillRectangle( 1, 1, (int)getWidth(), 2 );
		textureHpRed = new Texture( pixmapHp );
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		/*
		rend.setColor( Color.BLACK );
		rend.begin( ShapeType.Line );
		rend.line( getX(), getY()+getHeight(), getWidth(), 6 );
		//rend.line( 200, 200, 50, 50 );
		rend.end();
		
		if( (float)(currentHp/Max_Hp) > 0.5 )
		{
			rend.setColor( Color.GREEN );			
		}
		else
		{
			rend.setColor( Color.RED );
		}
		rend.begin( ShapeType.Filled );
		rend.rect( getX(), getY()+getHeight()+1, getWidth(), 4 );
		rend.end();		
		*/
		
		
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
