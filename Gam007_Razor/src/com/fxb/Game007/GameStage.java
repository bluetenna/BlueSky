package com.fxb.Game007;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.fxb.Game007.Gun.WorkState;
import com.fxb.Game007.screens.LevelScreen0;
import com.fxb.Game007.screens.PauseDialog;

public class GameStage extends Stage{
	
	GameScreen gameScreen;
	
	Image imgBack1, imgBack2;
	Image imgLeft, imgRight;	
	Image imgExit, imgAgain;

	Pixmap pixmapProgress;
	Texture textureProgress;
	Image imgIndicator;
	Image imgProgress;
	
	float leftX = 0;	
	float levelRate = 0;
	float totalWidth; 
	//Window windowOver;
	
	Button buttonOver;
	
	//Button buttonGunSelect;
	//Image imgGunBlue;
	//Image imgGunRed;
	//Image imgGunCycn;
	
	Gun[] sGun;
	Gun gunBlue, gunRed, gunCycn;
	Gun currentGun;
	
	Medicine medicine;
	
	ShapeRenderer shapeRenderer;
	TextButton buttonPause;
	PauseDialog pauseDialog;
	
	public GameStage( GameScreen gameScreen0 ){
		gameScreen = gameScreen0;
		init();
	}
	
	private void init(){
		
		shapeRenderer = new ShapeRenderer();
		
		imgBack1 = new Image( new Texture( Gdx.files.internal( "data/back1.png" ) ) );
		imgBack2 = new Image( new Texture( Gdx.files.internal( "data/back2.png" ) ) );
		//imgOver = new Image( Asserts.textureOver );
		imgExit = new Image( Asserts.textureExit );
		imgAgain = new Image( Asserts.textureAgain );
		
		imgBack1.setPosition( 0, 0 );
		imgBack2.setPosition( imgBack1.getWidth(), 0 );
		imgLeft = imgBack1;
		imgRight = imgBack2;
		totalWidth = imgLeft.getWidth()+imgRight.getWidth();
		
		//imgLeft.setAlign(Align.)
		//imgLeft.setColor( 1, 1, 1, 0.7f );
		//imgRight.setColor( 1, 1, 1, 0.7f );
		
		this.addActor( imgBack1 );
		this.addActor( imgBack2 );
		
		
		pixmapProgress = new Pixmap( 256, 8, Format.RGBA8888 );
		pixmapProgress.setColor( Color.YELLOW );
		pixmapProgress.fillRectangle( 0, 0, 256, 8 );
		textureProgress = new Texture( pixmapProgress );
		imgProgress = new Image( textureProgress );
		imgProgress.setSize( textureProgress.getWidth(), textureProgress.getHeight() );
		
		imgIndicator = new Image( Asserts.textureIndicator );
		imgIndicator.setSize( Asserts.textureIndicator.getWidth()/12, Asserts.textureIndicator.getHeight()/12 );

		//imgIndicator.setAlign( Al );
		imgProgress.setPosition( getWidth()/2-imgProgress.getWidth()/2, getHeight()-imgProgress.getHeight()-10 );
		imgIndicator.setPosition( imgProgress.getX()-imgIndicator.getWidth()/2, imgProgress.getY()-imgIndicator.getHeight()+2 );
		this.addActor( imgIndicator );
		this.addActor( imgProgress );

		//imgIndicator.setAlign( Align.center );
		//imgProgress.setAlign( Align.center );
		
		//buttonOver = new Button( Asserts.buttonStyle );
		buttonOver = new Button( Asserts.drawOver );
		buttonOver.addActor( imgExit );
		buttonOver.addActor( imgAgain );
		
		//windowOver = new Window( "", Asserts.windowStyle );
		//windowOver.addActor( imgExit );
		//windowOver.addActor( imgAgain );
			
		imgExit.setSize( Asserts.textureExit.getWidth(), Asserts.textureExit.getHeight()  );
		imgAgain.setSize( Asserts.textureAgain.getWidth(), Asserts.textureAgain.getHeight() );
		//windowOver.setSize( Asserts.textureOver.getWidth(), Asserts.textureOver.getHeight() );
		buttonOver.setSize( Asserts.textureOver.getWidth(), Asserts.textureOver.getHeight() );
		
		//windowOver.setPosition( getWidth()/2-windowOver.getWidth()/2, getHeight()/2-windowOver.getHeight()/2 );
		buttonOver.setPosition( getWidth()/2-buttonOver.getWidth()/2, getHeight()/2-buttonOver.getHeight()/2 );
		
		//imgAgain.setPosition( windowOver.getWidth()/10, 5 );
		//imgExit.setPosition( windowOver.getWidth()*9/10-imgExit.getWidth(), 5 );
		
		imgAgain.setPosition( buttonOver.getWidth()/10, 5 );
		imgExit.setPosition( buttonOver.getWidth()*9/10-imgExit.getWidth(), 5 );
		
		imgExit.addListener( new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// TODO Auto-generated method stub
				Gdx.app.exit();
				//return super.touchDown(event, x, y, pointer, button);
				return true;
			}
			
		});
	
		imgAgain.addListener( new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// TODO Auto-generated method stub
				//Gdx.app.exit();
				gameScreen.Clear();
				//return super.touchDown(event, x, y, pointer, button);
				return true;
			}		
		});
		
		
		/*
		imgGunBlue = new Image( Asserts.regionBulletBlue32 );
		imgGunRed = new Image( Asserts.regionBulletRed32 );
		imgGunCycn = new Image( Asserts.regionBulletCycn32 );
		
		imgGunBlue.setSize( Asserts.regionBulletBlue32.getRegionWidth(), Asserts.regionBulletBlue32.getRegionHeight() );
		imgGunBlue.setPosition( 5, 5 );
		imgGunRed.setSize( Asserts.regionBulletRed32.getRegionWidth(), Asserts.regionBulletRed32.getRegionHeight() );
		imgGunRed.setPosition( imgGunBlue.getX()+imgGunBlue.getWidth()+10, 5 );
		imgGunCycn.setSize( Asserts.regionBulletCycn32.getRegionWidth(), Asserts.regionBulletCycn32.getRegionHeight() );
		imgGunCycn.setPosition( imgGunRed.getX()+imgGunRed.getWidth()+10, 5 );
		
		
		imgGunBlue.addListener( new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// TODO Auto-generated method stub
				Constant.gunType = Constant.GunType.Gun_Blue;
				return true;
			}			
		});
		
		imgGunRed.addListener( new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// TODO Auto-generated method stub
				Constant.gunType = Constant.GunType.Gun_Red;
				return true;
			}			
		});	
		
		imgGunCycn.addListener( new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// TODO Auto-generated method stub
				Constant.gunType = Constant.GunType.Gun_Cycn;
				return true;
			}			
		});		
		
		this.addActor( imgGunBlue );
		this.addActor( imgGunRed );
		this.addActor( imgGunCycn );
		//addActor( buttonOver );
		*/
		
		
		gunBlue = new Gun();
		gunBlue.SetType( Gun.GunType.Gun_Blue );

		gunRed = new Gun();
		gunRed.SetType( Gun.GunType.Gun_Red );
		
		gunCycn = new Gun();
		gunCycn.SetType( Gun.GunType.Gun_Cycn );
		
		gunBlue.setPosition( 5, 5 );
		gunRed.setPosition( gunBlue.getX()+gunBlue.getWidth()+30, 5 );
		gunCycn.setPosition( gunRed.getX()+gunRed.getWidth()+30, 5 );
		
		
		gunBlue.addListener( new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// TODO Auto-generated method stub
				Gdx.app.log( "blue", "enter" );
				if( currentGun == gunBlue ){
					return true;
				}
				if( gunBlue.workState == Gun.WorkState.State_Rest ){
					Gdx.app.log( "blue", "rest" );
					return true;
				}
				
				Constant.gunType = Constant.GunType.Gun_Blue;
				
				currentGun.StartRest();				
				currentGun = gunBlue;
				currentGun.StartWork();
								
				return true;
			}			
		});
		
		gunRed.addListener( new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// TODO Auto-generated method stub
				//Constant.gunType = Constant.GunType.Gun_Red;
				//currentGun = gunRed;
				
				if( currentGun == gunRed ){
					return true;
				}
				if( gunRed.workState == Gun.WorkState.State_Rest ){
					return true;
				}
				
				Constant.gunType = Constant.GunType.Gun_Red;
				
				currentGun.StartRest();				
				currentGun = gunRed;
				currentGun.StartWork();
								
				return true;
	
			}			
		});	
		
		gunCycn.addListener( new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// TODO Auto-generated method stub
				//Constant.gunType = Constant.GunType.Gun_Cycn;
				//currentGun = gunCycn;
				
				if( currentGun == gunCycn ){
					return true;
				}
				if( gunCycn.workState == WorkState.State_Rest ){
					return true;
				}
				
				Constant.gunType = Constant.GunType.Gun_Cycn;
				
				currentGun.StartRest();				
				currentGun = gunCycn;
				currentGun.StartWork();
								
				return true;
			}			
		});		
		
		this.addActor( gunBlue );
		this.addActor( gunRed );
		this.addActor( gunCycn );	
		currentGun = gunBlue;
		
		sGun = new Gun[]{ gunBlue, gunRed, gunCycn };
				
		medicine = new Medicine();
		medicine.setPosition( gunCycn.getX()+gunCycn.getWidth()+40, 5);
		medicine.addListener( new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				// TODO Auto-generated method stub
				//Constant.gunType = Constant.GunType.Gun_Cycn;
				if( Constant.medicineNum > 0 ){
					Constant.medicineNum--;
					gameScreen.player.currentHp += medicine.addNum;
					if( gameScreen.player.currentHp > Player.maxHp ){
						gameScreen.player.currentHp = Player.maxHp;
					}
				}

				return true;
			}			
		});	
		this.addActor( medicine );
		
		
		buttonPause = new TextButton( "Pause", Asserts.skin );
		buttonPause.setSize(50, 20);
		buttonPause.setPosition( 0, this.getHeight()-buttonPause.getHeight() );
		pauseDialog = new PauseDialog( "", Asserts.skin, gameScreen.game, this );
		pauseDialog.addListener( new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				pauseDialog.show( GameStage.this );
				return true;
			}			
		});
		this.addActor( buttonPause );
	}
	
	public void Clear(){
		if( getRoot().getChildren().contains( buttonOver, true ) ){
			getRoot().removeActor( buttonOver );
		}
						
		imgLeft = imgBack1;
		imgRight = imgBack2;
		imgLeft.setPosition( 0, 0 );
		imgRight.setPosition( imgLeft.getWidth(), 0 );
		this.getCamera().translate( -leftX, 0, 0 );
		
		buttonOver.translate( -leftX, 0 );
		//windowOver.translate( -leftX, 0 );
		
		imgProgress.translate( -leftX, 0 );
		imgIndicator.translate( -leftX, 0 );
		levelRate = 0;
					
		//imgGunBlue.translate( -leftX, 0 );
		//imgGunRed.translate( -leftX, 0 );
		//imgGunCycn.translate( -leftX, 0 );
		
		gunBlue.translate( -leftX, 0 );
		gunRed.translate( -leftX, 0 );
		gunCycn.translate( -leftX, 0 );
		
		gunBlue.Clear();
		gunRed.Clear();
		gunCycn.Clear();
		
		currentGun = gunBlue;
		Constant.gunType = Constant.GunType.Gun_Blue;		
		
		medicine.translate( -leftX, 0 );
		

		
			
		leftX = 0;
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		if( imgLeft.getX()+imgLeft.getWidth() < leftX )
		{			
			imgLeft.setPosition( imgRight.getX()+imgRight.getWidth(), 0 );
			Image imgTemp = imgLeft;
			imgLeft = imgRight;
			imgRight = imgTemp;
		}
		//windowOver.translate( Constant.Translate_Speed, 0 );
		buttonOver.translate( Constant.Translate_Speed, 0 );
		
		imgProgress.translate( Constant.Translate_Speed, 0 );
		//imgIndicator.translate(  );	
		leftX += Constant.Translate_Speed;
		
		
		levelRate = leftX/totalWidth;
		imgIndicator.setX( imgProgress.getX()-imgIndicator.getWidth()/2 + imgProgress.getWidth()*levelRate );
		
		
		//imgGunBlue.translate( Constant.Translate_Speed, 0 );
		//imgGunRed.translate( Constant.Translate_Speed, 0 );
		//imgGunCycn.translate( Constant.Translate_Speed, 0 );
		
		gunBlue.translate( Constant.Translate_Speed, 0 );
		gunRed.translate( Constant.Translate_Speed, 0 );
		gunCycn.translate( Constant.Translate_Speed, 0 );
		
		medicine.translate( Constant.Translate_Speed, 0 );
		buttonPause.translate( Constant.Translate_Speed, 0 );		
		pauseDialog.translate( Constant.Translate_Speed, 0 );
		
		
		if( levelRate > 0.99 ){
			Constant.gameLevel++;
			//gameScreen.game.setScreen( gameScreen.game.levelScreen );
			gameScreen.game.setScreen( new LevelScreen0(gameScreen.game) );
		}
		
					
		for( Gun gun : sGun ){
			if( gun != currentGun && gun.workState==Gun.WorkState.State_Rest )
			{
				//gun.resumeTime += Gdx.graphics.getDeltaTime();			
				//gun.rate += gun.resumeTime/gun.totalResumeTime;
				
				gun.rate += Gdx.graphics.getDeltaTime()/gun.totalResumeTime;
							
				Gdx.app.log( "gun", ""+gun.rate );
				
				if( gun.rate >= 0.99f )
				{
					//gun.workState = Gun.WorkState.State_Ready;
					gun.Clear();
					Gdx.app.log( "gun", "resume over!" );
				}
			}
		}
		
		
		
		super.act();		
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub		
		super.draw();
		
		shapeRenderer.begin( ShapeType.Line );
		shapeRenderer.setColor( Color.YELLOW );
		shapeRenderer.rect( currentGun.getX()-leftX, currentGun.getY(), currentGun.getWidth(), currentGun.getHeight() );
		shapeRenderer.end();
	}

	public void GameOver(){
		//windowOver.setPosition( gameScreen.leftX+getWidth()/2-windowOver.getWidth()/2, getHeight()/2-windowOver.getHeight()/2 );
		//this.addActor( windowOver );
		this.addActor( buttonOver );
	}

	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
				
		super.dispose();
	}
		
}
