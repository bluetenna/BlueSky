package com.fxb.Game007;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;

public class Player extends Actor{
	Stage stage;
	TextureRegion region;
	//TextureAtlas atlas;
	ShapeRenderer rend;

	static final int maxHp = 20;
	int currentHp = maxHp;
	
	public Pixmap pixmapHp;
	Texture textureHpGreen;
	Texture textureHpRed;
	
	public float currentTime = 0;
	public float lastAttackTime = 0;
	
	boolean isAddDieAction = false;
	
	public Player(){
		init();
	}
	
	private void init(){
		//atlas = new TextureAtlas(  );
		region = Asserts.regionPlayer;
		//region = new TextureRegion( new Texture( Gdx.files.internal( "razor0/razor.png" ) ) );
		setPosition( 50, 100 );		
		setSize( region.getRegionWidth()/2, region.getRegionHeight()/2 );
		setOrigin( getWidth()/2, getHeight()/2 );
		
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

	public void Clear(){
		currentTime = 0;
		lastAttackTime = 0;
		clearActions();
		//addAction( Actions.rotateTo( 0 ) );		
		//addAction( Actions.scaleTo( 1, 1 ) );
		this.setRotation( 0 );
		this.setScale( 1, 1 );
		this.setPosition( 50, 100 );
		currentHp = maxHp;
		isAddDieAction = false;
	}
	
	
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		
		currentTime += delta;
		
		super.act(delta);
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		
		/*
		rend.setColor( Color.BLACK );
		rend.begin( ShapeType.Line );
		rend.line( getX(), getY()+getHeight(), getWidth(), 6 );
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
		rend.rect( getX(), getY()+getHeight()+1, getWidth()*currentHp/Max_Hp, 4 );
		rend.end();		
		//batch.draw( region, getX(), getY(), getWidth(), getHeight() );
		*/
		
		if( ((float)currentHp)/maxHp > 0.5 )
		{
			//pixmap.setColor( Color.GREEN );	
			batch.draw( textureHpGreen, this.getX(), this.getY()+this.getHeight()-4, textureHpGreen.getWidth()*currentHp/maxHp, textureHpGreen.getHeight() );
		}
		else
		{
			//pixmap.setColor( Color.RED );
			batch.draw( textureHpRed, this.getX(), this.getY()+this.getHeight()-4, textureHpRed.getWidth()*currentHp/maxHp, textureHpRed.getHeight() );
		}
		
			
		batch.draw( region, getX(), getY(), this.getOriginX(), this.getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation() );
	
		super.draw(batch, parentAlpha);
	}
	
	
	public void Die(){
		currentHp = 0;		

		Action rotateAction = Actions.rotateBy( -360, Constant.Vanish_Time );
		Action moveByAction = Actions.moveBy( 0, 20, Constant.Vanish_Time );
		Action scaleAction = Actions.scaleTo( 0.1f, 0.1f, Constant.Vanish_Time );
		ParallelAction parallelAction = Actions.parallel( rotateAction, scaleAction, moveByAction );
		Action playerDieAction = new Action(){
			@Override
			public boolean act(float delta) {
				Constant.gameState = Constant.GameState.Game_Over;
				return false;
			}						
		};
		
		clearActions();
		isAddDieAction = true;
		addAction( Actions.sequence( parallelAction, playerDieAction ) );			
	}
		
}
