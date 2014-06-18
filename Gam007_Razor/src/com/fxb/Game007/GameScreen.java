package com.fxb.Game007;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateByAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;
import com.fxb.Game007.*;

public class GameScreen extends ScreenAdapter{
	
	public GameRazor game;
	//Stage stage;
	public Player player;
	GameStage stage;
		
//	Image imgBack1, imgBack2;
//	Image imgLeft, imgRight;	
//	Image imgExit, imgAgain;
	
	float leftX = 0;	
//	Window windowOver;
	
	Group group, groupBulletPlayer, groupBulletEnemy, groupAirforce, groupArcher;
	//final Pool<Enemy> poolEnemy = Pools.get( Enemy.class );
	final Pool<BulletPlayer> poolBulletPlayer = Pools.get( BulletPlayer.class );
	final Pool<BulletEnemy> poolBulletEnemy = Pools.get( BulletEnemy.class );
	final Pool<Airforce> poolAirforce = Pools.get( Airforce.class );
	final Pool<Archer> poolArcher = Pools.get( Archer.class );
	
	float currentTime, lastEnemyTime;
		
	//enum State{ Game_On, Game_Pause, Game_Over };
	//State state = State.Game_On;
	
	//Airforce Airforce;
	
	
	ShapeRenderer rend;
	
			
	public GameScreen( GameRazor game0 ){
		game = game0;
		init();
	}
	
	private void init(){
		//stage = new Stage();
		stage = new GameStage( this );
		player = new Player();
		
		//Airforce = new Airforce(  );
		//archer = new Archer( stage );
		
//		imgBack1 = new Image( new Texture( Gdx.files.internal( "data/back1.png" ) ) );
//		imgBack2 = new Image( new Texture( Gdx.files.internal( "data/back2.png" ) ) );
//		//imgOver = new Image( Asserts.textureOver );
//		imgExit = new Image( Asserts.textureExit );
//		imgAgain = new Image( Asserts.textureAgain );
//		
//		imgBack1.setPosition( 0, 0 );
//		imgBack2.setPosition( imgBack1.getWidth(), 0 );
//		imgLeft = imgBack1;
//		imgRight = imgBack2;
//		
//		stage.addActor( imgBack1 );
//		stage.addActor( imgBack2 );
		//stage.addActor( imgOver );
		//Constant.CenterStage( stage, imgOver );
		
//		windowOver = new Window( "", Asserts.windowStyle );
//		windowOver.addActor( imgExit );
//		windowOver.addActor( imgAgain );
//		imgExit.setSize( Asserts.textureExit.getWidth(), Asserts.textureExit.getHeight()  );
//		imgAgain.setSize( Asserts.textureAgain.getWidth(), Asserts.textureAgain.getHeight() );
//		windowOver.setSize( Asserts.textureOver.getWidth(), Asserts.textureOver.getHeight() );
//		imgAgain.setPosition( windowOver.getWidth()/5, 10 );
//		imgExit.setPosition( windowOver.getWidth()*4/5-imgExit.getWidth(), 10 );
//		
//		imgExit.addListener( new InputListener(){
//			@Override
//			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//				// TODO Auto-generated method stub
//				Gdx.app.exit();
//				//return super.touchDown(event, x, y, pointer, button);
//				return true;
//			}
//			
//		});
//	
//		imgAgain.addListener( new InputListener(){
//			@Override
//			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//				// TODO Auto-generated method stub
//				//Gdx.app.exit();
//				Clear();
//				//return super.touchDown(event, x, y, pointer, button);
//				return true;
//			}
//			
//		});
		
		//stage.addActor( Airforce );
		//stage.addActor( archer );
		stage.addActor( player );
		
		group = new Group();
		groupBulletPlayer = new Group();
		groupBulletEnemy = new Group();
		groupAirforce = new Group();
		groupArcher = new Group();
		
		stage.addActor( group );
		stage.addActor( groupBulletPlayer );
		stage.addActor( groupBulletEnemy );
		stage.addActor( groupAirforce );
		stage.addActor( groupArcher );
		
		AddEnemyAirforce();
		AddEnemyArcher();
		
		
		rend = new ShapeRenderer();
						
	}
	
	public void Clear(){
		
		//state = State.Game_On;
		Constant.gameState = Constant.GameState.Game_On;

		Constant.medicineNum = Constant.Initial_Medincine_Num;
		
		currentTime = 0;
		lastEnemyTime = 0;

		player.Clear();
		
		groupBulletPlayer.clear();
		groupBulletEnemy.clear();
		groupAirforce.clear();
		groupArcher.clear();
		
//		if( stage.getRoot().getChildren().contains( windowOver, true ) ){
//			stage.getRoot().removeActor( windowOver );
//		}
//						
//		imgLeft = imgBack1;
//		imgRight = imgBack2;
//		imgLeft.setPosition( 0, 0 );
//		imgRight.setPosition( imgLeft.getWidth(), 0 );
//		stage.getCamera().translate( -leftX, 0, 0 );
		
		stage.Clear();
		
		//player.translate( -leftX, 0 );
		leftX = 0;
		
	}
	
	public void AddEnemyAirforce(){
		Airforce enemy = poolAirforce.obtain();
		
		float height = enemy.getHeight();
		float minY = stage.getHeight()/2;
		float maxY = stage.getHeight()-height;
		
		//ShowXY(enemy.getWidth(), enemy.getHeight());
				
		boolean bIsOverlap;
		float positionX, positionY;
		do 
		{
			bIsOverlap = false;
			positionY = MathUtils.random(minY, maxY);	
			positionX = MathUtils.random(stage.getWidth()*4/5, stage.getWidth()-10) + leftX;
			enemy.setPosition( positionX, positionY );
			for( int i=0; i<groupAirforce.getChildren().size; ++i )
			{
				Airforce tempEnemy = (Airforce)groupAirforce.getChildren().items[i];
				if( Constant.IsCollision( enemy, tempEnemy ) )
				{
					bIsOverlap = true;
					break;
				}
			}
		} while( bIsOverlap );
										
		//enemy.getActions().clear();
		enemy.Clear();
		
		MoveToAction actionMove = Actions.moveTo(leftX, positionY, MathUtils.random(8, 10));
		enemy.addAction(actionMove);		
		//enemy.currentHp = Airforce.maxHp;		
		groupAirforce.addActor( enemy );
	}
	
	public void AddEnemyArcher(){
		Archer enemy = poolArcher.obtain();
		
		//float height = enemy.getHeight();
		float minY = 15;
		float maxY = 20;
				
		boolean bIsOverlap;
		float positionX, positionY;
		do{	
			bIsOverlap = false;
			positionY = MathUtils.random(minY, maxY);	
			positionX = MathUtils.random(stage.getWidth()*4/5, stage.getWidth()-10) + leftX;
			enemy.setPosition( positionX, positionY );
			for( int i=0; i<groupArcher.getChildren().size; ++i )
			{
				Archer tempEnemy = (Archer)groupArcher.getChildren().items[i];
				if( Constant.IsCollision( enemy, tempEnemy ) )
				{
					bIsOverlap = true;
					break;
				}
			}
		} while( bIsOverlap );
										
		//enemy.getActions().clear();	
		enemy.Clear();
		MoveToAction actionMove = Actions.moveTo(leftX, positionY, MathUtils.random(10, 12));
		enemy.addAction(actionMove);
		
		//enemy.currentHp = Archer.maxHp;		
		groupArcher.addActor( enemy );		
	}
	
	public void AddPlayerBullet( float inputX, float inputY ){ 
		
		BulletPlayer bullet = poolBulletPlayer.obtain();
		//MoveToAction action = Actions.moveTo( 600, 400, 2 );
		//bullet.addAction( action );
		
		bullet.clearActions();
		bullet.SetBulletType();
		//bullet.target = Bullet.Target_Enemy;
		//bullet.Clear();
		
		float marginLeft = 50;
		//float leftX = player.getX() - marginLeft;
		
		inputX += leftX;
		//inputY = stage.getHeight() - inputY;
		
		//float startX = player.getX() + player.getWidth()/2;
		//float startY = player.getY() + player.getHeight()/2 - bullet.getHeight()/2;
		float startX = player.getX() + player.getWidth() -10;
		float startY = player.getY() + player.getHeight() - 25;
				
		bullet.setPosition(startX, startY);
		bullet.setOrigin(startX+bullet.getWidth()/2, startY+bullet.getHeight()/2);
				
		float rate = (inputY-startY)/(inputX-startX);
		
		float targetX = startX + stage.getWidth() - 50;
		if( inputX < startX )
		{
			targetX = startX - marginLeft - player.getWidth()/2;
		}
		//float targetY = stage.getHeight()/2 - ( targetX-mario.getX() )*rate;
		float targetY = startY + ( targetX-startX )*rate;
		
		float disX = targetX - bullet.getX();
		float disY = targetY - bullet.getY();
		float dis = (float)Math.sqrt( disX*disX + disY*disY );
		float time = dis/Constant.Bullet_Player_Speed;
		
		
		//MoveToAction actionMove = Actions.moveTo(x, Gdx.graphics.getHeight()-y, time);
		MoveToAction actionMove = Actions.moveTo(targetX, targetY, time);
		RepeatAction actionRepeat = Actions.repeat(50, Actions.rotateBy(-360, time));
		bullet.addAction(actionMove);
		bullet.addAction(actionRepeat);
		//groupBullet.addActor(bullet);
		
		groupBulletPlayer.addActor( bullet );
					
		AddGunRecoil();
	}
	
	//when player attack enemy, cause recoil
	public void AddGunRecoil(){
		RotateByAction action1 = Actions.rotateBy( 10, 0.075f );
		MoveByAction action2 = Actions.moveBy( -10, 0,  0.075f );
		RotateByAction action3 = Actions.rotateBy( -10, 0.075f );
		MoveByAction action4 = Actions.moveBy( 10, 0, 0.075f );
		
		SequenceAction sequenceAction = Actions.sequence( Actions.parallel( action1, action2 ), Actions.parallel( action3, action4 ) );
		player.addAction( sequenceAction );
	}
	
	
	public void AddEnemyBullet( Enemy enemy0 ){
		float startX = enemy0.getX() + enemy0.getWidth()/2;
		float startY = enemy0.getY() + enemy0.getHeight()/2;
		
		float tempX = player.getX() + (0.5f + MathUtils.random( -1, 1 ))*player.getWidth();
		float tempY = player.getY() + (0.5f + MathUtils.random( -1, 1 ))*player.getHeight();
		//float tempX = player.getX() + 0.5f*player.getWidth();
		//float tempY = player.getY()	+ 0.5f*player.getHeight();
		
		Bullet bullet = poolBulletEnemy.obtain();
		bullet.getActions().clear();
		//bullet.target = Bullet.Tartet_Player;
		
		bullet.setPosition(startX, startY);
		bullet.setOrigin(startX+bullet.getWidth()/2, startY+bullet.getHeight()/2);
		
		float rate = (tempY-startY)/(tempX-startX);
		
		float targetX = this.leftX;
		float targetY = startY + ( targetX-startX )*rate;
		
		float disX = targetX - bullet.getX();
		float disY = targetY - bullet.getY();
		float dis = (float)Math.sqrt( disX*disX + disY*disY );
		float time = dis/Constant.Bullet_Enemy_Speed;
		
		MoveToAction actionMove = Actions.moveTo(targetX, targetY, time);
		RepeatAction actionRepeat = Actions.repeat(50, Actions.rotateBy(360, time));
		bullet.addAction(actionMove);
		bullet.addAction(actionRepeat);
		//groupBullet.addActor(bullet);
		groupBulletEnemy.addActor( bullet );
	}
	

	public void CheckAndAddObject()
	{
		//add player bullet
		if( player.currentTime - player.lastAttackTime >= 0.15f  &&  Gdx.input.isTouched() )
		{
			float inputX = Gdx.input.getX();
			float inputY = Gdx.input.getY();
			
			inputY = stage.getHeight()-inputY;
			Actor actorMedicine = stage.medicine;
			Actor actorPause = stage.buttonPause;
			if( inputX < actorMedicine.getX()+actorMedicine.getWidth() && inputY < actorMedicine.getHeight() ){				
			}
			//can't attack
			else if( inputX<actorPause.getX()+actorPause.getWidth() && inputY>stage.getHeight()-actorPause.getHeight() ){
				stage.pauseDialog.show( stage );
				//stage.pauseDialog.translate( leftX, 0 );
				Constant.gameState = Constant.GameState.Game_Pause;
			}
			else if( stage.currentGun.duraAvailable <= 0 ){			
			}
			else{
				
				this.AddPlayerBullet( inputX, inputY );	
				stage.currentGun.duraAvailable--;
				stage.currentGun.rate = ((float)stage.currentGun.duraAvailable)/stage.currentGun.durability;
				player.lastAttackTime = player.currentTime;					
			}	
		}
		//add enemy
		if( currentTime - lastEnemyTime >= 1.5f )
		{
			//if( groupEnemy.getChildren().size < GameStage.Max_Enemy_Count )
			if( groupAirforce.getChildren().size + groupArcher.getChildren().size < Constant.Max_Enemy_Count )
			{
				int temp = MathUtils.random( 9 );
				if( temp%2 == 0 ){
					AddEnemyAirforce();
				}else{
					AddEnemyArcher();
				}
				
				//AddEnemyAirforce();
				//AddEnemyArcher();
				lastEnemyTime = currentTime;
			}		
		}
		//add airforce bullet
		for( int i=0; i<groupAirforce.getChildren().size; ++i )
		{
			Enemy tempEnemy = (Enemy)groupAirforce.getChildren().items[i];
			float gapTime = MathUtils.random( 3, 5 );
			if( tempEnemy.currentTime - tempEnemy.lastAttackTime >= gapTime )
			{
				AddEnemyBullet( tempEnemy );
				tempEnemy.lastAttackTime = tempEnemy.currentTime;
			}
		}
		//add archer bullet
		for( int i=0; i<groupArcher.getChildren().size; ++i )
		{
			Enemy tempEnemy = (Enemy)groupArcher.getChildren().items[i];
			float gapTime = MathUtils.random( 4, 6 );
			if( tempEnemy.currentTime - tempEnemy.lastAttackTime >= gapTime )
			{
				AddEnemyBullet( tempEnemy );
				tempEnemy.lastAttackTime = tempEnemy.currentTime;
			}
		}
	}
	
	public void CheckBulletAlive(){
		
		for( int i=0; i<groupBulletPlayer.getChildren().size; ++i )
		{
			BulletPlayer tempBullet = (BulletPlayer)groupBulletPlayer.getChildren().items[i];
			if( !tempBullet.IsAlive( leftX ) )
			{
				//groupProject.getChildren().removeIndex(i);
				groupBulletPlayer.removeActor( tempBullet );
				poolBulletPlayer.free( tempBullet );
			}
		}
		
		for( int i=0; i<groupBulletEnemy.getChildren().size; ++i )
		{
			BulletEnemy tempBullet = (BulletEnemy)groupBulletEnemy.getChildren().items[i];
			if( !tempBullet.IsAlive( leftX ) )
			{
				//groupProject.getChildren().removeIndex(i);
				groupBulletEnemy.removeActor( tempBullet );
				poolBulletEnemy.free( tempBullet );
			}
		}

	}
	
	
	public void CheckAttackCollsion(){
		//player attck archer
		for( int i=0; i<groupArcher.getChildren().size; ++i )
		{
			Archer tempEnemy = (Archer)groupArcher.getChildren().items[i];
			if( tempEnemy.currentHp <= 0 )
			{
				continue;
			}
			for( int j=0; j<groupBulletPlayer.getChildren().size; ++j )
			{
				BulletPlayer bullet = (BulletPlayer)groupBulletPlayer.getChildren().items[j];
				if( Constant.IsCollision( tempEnemy, bullet ) )
				{
					groupBulletPlayer.removeActor( bullet );
					poolBulletPlayer.free( bullet );
					
					tempEnemy.currentHp -= bullet.damage;
					if( tempEnemy.currentHp <= 0 )
					{
						tempEnemy.currentHp = 0;
						tempEnemy.setOrigin( tempEnemy.getWidth()/2, tempEnemy.getHeight()/2 );
						//groupArcher.removeActor( tempEnemy );
						//poolArcher.free( tempEnemy );
						Action moveByAction = Actions.moveBy( 0, 10, Constant.Vanish_Time );						
						Action rotateAction = Actions.rotateBy( -360, Constant.Vanish_Time );
						Action scaleAction = Actions.scaleTo( 0.1f, 0.1f, Constant.Vanish_Time );
						ParallelAction parallelAction = Actions.parallel( rotateAction, scaleAction, moveByAction );
						
						Action archerDieAction = new Action(){
							@Override
							public boolean act(float delta) {
								// TODO Auto-generated method stub
								Actor actor = this.getActor();							
								groupArcher.removeActor( actor );
								poolArcher.free( (Archer)actor );							
								return false;
							}						
						};
						
						//tempEnemy.clearActions();
						tempEnemy.getActions().clear();
						tempEnemy.addAction( Actions.sequence( parallelAction, archerDieAction ) );
						
						break;
					}
				}
			}
		}
		//player attack Airforce
		for( int i=0; i<groupAirforce.getChildren().size; ++i )
		{
			Airforce tempEnemy = (Airforce)groupAirforce.getChildren().items[i];
			if( tempEnemy.currentHp <= 0 )
			{
				continue;
			}
			for( int j=0; j<groupBulletPlayer.getChildren().size; ++j )
			{
				BulletPlayer bullet = (BulletPlayer)groupBulletPlayer.getChildren().items[j];
				if( Constant.IsCollision( tempEnemy, bullet ) )
				{
					groupBulletPlayer.removeActor( bullet );
					poolBulletPlayer.free( bullet );
					
					tempEnemy.currentHp -= bullet.damage;
					if( tempEnemy.currentHp <= 0 )
					{
						//groupAirforce.removeActor( tempEnemy );
						//poolAirforce.free( tempEnemy );
						
						//break;
											
						tempEnemy.currentHp = 0;
						tempEnemy.setOrigin( tempEnemy.getWidth()/2, tempEnemy.getHeight()/2 );
						//groupArcher.removeActor( tempEnemy );
						//poolArcher.free( tempEnemy );

						Action moveByAction = Actions.moveBy( 0, 20, Constant.Vanish_Time );						
						Action rotateAction = Actions.rotateBy( -360, Constant.Vanish_Time );
						Action scaleAction = Actions.scaleTo( 0.1f, 0.1f, Constant.Vanish_Time );
						ParallelAction parallelAction = Actions.parallel( rotateAction, scaleAction, moveByAction );
						
						Action AirforceDieAction = new Action(){
							@Override
							public boolean act(float delta) {
								// TODO Auto-generated method stub
								Actor actor = this.getActor();							
								groupAirforce.removeActor( actor );
								poolAirforce.free( (Airforce)actor );							
								return false;
							}						
						};
						
						//tempEnemy.clearActions();
						tempEnemy.getActions().clear();
						tempEnemy.addAction( Actions.sequence( parallelAction, AirforceDieAction ) );
						
						break;
					}
				}
			}
		}
		
		//enemy attack player
		if( player.currentHp > 0 )
		{
			for( int i=0; i<groupBulletEnemy.getChildren().size; ++i )
			{
				BulletEnemy bullet = (BulletEnemy)groupBulletEnemy.getChildren().items[i];
				if( Constant.IsCollision( player, bullet ) )
				{
					groupBulletEnemy.removeActor( bullet );
					poolBulletEnemy.free( bullet );
					
					player.currentHp -= bullet.damage;
					Gdx.app.log( "hp", ""+player.currentHp );
					if( player.currentHp <= 0 )
					{
						player.currentHp = 0;
									
					}
				}
			}			
		}
						
	}
	
	//cause damage when enemy move to the left of player
	public void CheckEnemyPosition(){
		
		if( player.currentHp <=0  ){
			return;
		}
		
		float playerX = player.getX();
		for( int i=0; i<groupArcher.getChildren().size; ++i )
		{
			Archer tempEnemy = (Archer)groupArcher.getChildren().items[i];
			if( tempEnemy.getX() < playerX )
			{
				groupArcher.removeActor( tempEnemy );
				poolArcher.free( tempEnemy );
				player.currentHp--;
				if( player.currentHp <= 0 )
				{
					//isGameRun = false;
					//ConstantData.state = ConstantData.game_over;
					player.currentHp = 0;
					//state = State.Game_Over;
				}
			}
		}
		
		for( int i=0; i<groupAirforce.getChildren().size; ++i )
		{
			Airforce tempEnemy = (Airforce)groupAirforce.getChildren().items[i];
			if( tempEnemy.getX() < playerX )
			{
				groupAirforce.removeActor( tempEnemy );
				poolAirforce.free( tempEnemy );
				player.currentHp--;
				if( player.currentHp <= 0 )
				{
					//isGameRun = false;
					//ConstantData.state = ConstantData.game_over;
					player.currentHp = 0;
					//state = State.Game_Over;
				}
			}
		}
	}
	
	
	public void CheckPlayerHp(){
		
		if( player.isAddDieAction ){
			return;
		}
		if( player.currentHp <= 0 ){			
			player.Die();
		}
	}
		
	public void LogicHandle(){
		currentTime += Gdx.graphics.getDeltaTime();

		CheckAndAddObject();
		CheckBulletAlive();
		CheckAttackCollsion();
		CheckEnemyPosition();
		CheckPlayerHp();
					
	}
	
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
				
		//if( state == State.Game_On )
		if( Constant.gameState == Constant.GameState.Game_On )
		{
			Gdx.gl.glClearColor( 1, 1, 1, 1 );
			Gdx.gl.glClear( GL10.GL_COLOR_BUFFER_BIT );
			
			leftX += Constant.Translate_Speed;
			stage.getCamera().translate( Constant.Translate_Speed, 0, 0 );
			player.translate( Constant.Translate_Speed, 0 );
											
			LogicHandle();
						
			stage.act();
			stage.draw();			
		}
		//else if( state == State.Game_Over )
		else if( Constant.gameState == Constant.GameState.Game_Over )
		{
			//windowOver.setPosition( leftX+stage.getWidth()/2-windowOver.getWidth()/2, stage.getHeight()/2-windowOver.getHeight()/2 );
			//stage.addActor( windowOver );
			//stage.act();
			stage.GameOver();
			stage.draw();
		}
		//else if( state == State.Game_Pause )
		else if( Constant.gameState == Constant.GameState.Game_Pause )	
		{
			//stage.act();
			stage.pauseDialog.act(delta);
			stage.draw();
		}
		
		
		
		rend.begin( ShapeType.Filled );			
		rend.setColor(Color.LIGHT_GRAY );	
		for( Gun gun : stage.sGun ){
			//if( gun.workState == Gun.WorkState.State_Rest || gun.workState == Gun.WorkState.State_Work )
			{
				//float rate = gun.resumeTime/gun.totalResumeTime;
				float centerX = gun.getX()+gun.getWidth()/2;
				float centerY = gun.getY()+gun.getHeight()/2;
				float start = 90;
				float angle = 360 - 360*gun.rate;
				rend.arc( centerX-leftX, centerY, gun.getWidth()/2, start, angle );			
			}
		}	
		rend.end();

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		Clear();
		Gdx.input.setInputProcessor( stage );
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
		poolAirforce.clear();
		poolArcher.clear();
		poolBulletPlayer.clear();
		poolBulletEnemy.clear();
		
		stage.dispose();	
		super.dispose();
	}
	
	

}
