package com.fxb.Game007;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Constant {
	
	public static final float Translate_Speed = 0.5f;
	public static final float Bullet_Player_Speed = 2000;
	public static final float Bullet_Enemy_Speed = 300;
	public static final int Max_Enemy_Count = 5;
	public static final float Vanish_Time = 0.5f;
	
	
	
	//public static final int Palyer_Max_Hp = 20;
	//public static final int 
	
	//public static final ShapeRenderer rend = new ShapeRenderer();
	
	public static GameState gameState = GameState.Game_On;
	public enum GameState{ Game_On, Game_Pause, Game_Over, Game_SelectLevel };
	
	
	public static GunType gunType = GunType.Gun_Blue;
	public enum GunType{ Gun_Blue, Gun_Red, Gun_Cycn };
	
	public static final int Initial_Medincine_Num = 2;
	public static int medicineNum = Initial_Medincine_Num;
	
	public static int gameLevel = 1;
	
	
	public static void CenterStage( Stage stage, Actor actor )
	{
		if( stage==null || actor==null )
		{
			return;
		}
		actor.setPosition( stage.getWidth()/2-actor.getWidth()/2, stage.getHeight()/2-actor.getHeight()/2 );
	}
	
	public static void CenterParent( Actor actor )
	{
		if( actor==null || actor.getParent()==null )
		{
			return;
		}
		actor.setPosition( actor.getParent().getWidth()/2-actor.getWidth()/2, actor.getParent().getHeight()/2-actor.getHeight()/2 );
	}
	
	public static boolean IsInside( float x, float y, Actor actor )
	{
		return x>=actor.getX() && x<=actor.getX()+actor.getWidth() && y>=actor.getY() && y<=actor.getY()+actor.getHeight();
	}
	
	public static boolean IsInside( float x, float y, Rectangle rect )
	{
		return x>=rect.x && x<=rect.x+rect.width && y>=rect.y && y<=rect.y+rect.height;
	}
	
	public static boolean IsCollision( Actor actor1, Actor actor2 )
	{
		float x1 = actor1.getX(), y1 = actor1.getY(), w1 = actor1.getWidth(), h1 = actor1.getHeight();
		float x2 = actor2.getX(), y2 = actor2.getY(), w2 = actor2.getWidth(), h2 = actor2.getHeight();
		
		if( x1<x2 && x1+w1<x2 ){
			return false;
		}
		else if( x2<x1 && x2+w2<x1 ){
			return false;
		}
		else if( y1<y2 && y1+h1<y2 ){
			return false;
		}
		else if( y2<y1 && y2+h2<y1 ){
			return false;
		}
		
		return true;
	}

}
