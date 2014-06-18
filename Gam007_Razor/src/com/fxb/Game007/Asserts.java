package com.fxb.Game007;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Asserts {
		
	public static TextureAtlas atlas;
	public static TextureRegion regionPlayer;
	public static TextureRegion regionArcher;
	public static TextureRegion regionAirforce;
		
	public static Texture textureBulletBlue;
	public static Texture textureBulletGray;
	public static Texture textureBulletRed;
	public static Texture textureBulletCycn;

	public static TextureRegion regionBulletBlue;
	public static TextureRegion regionBulletGray;
	public static TextureRegion regionBulletRed;
	public static TextureRegion regionBulletCycn;

	
	public static Texture textureBulletBlue32;
	public static Texture textureBulletGray32;
	public static Texture textureBulletRed32;
	public static Texture textureBulletCycn32;

	public static TextureRegion regionBulletBlue32;
	public static TextureRegion regionBulletGray32;
	public static TextureRegion regionBulletRed32;
	public static TextureRegion regionBulletCycn32;
	
	public static Texture textureOver;
	public static Texture textureExit;
	public static Texture textureAgain;
	
	public static Texture textureHp;
	public static TextureRegion regionHp;
	
	public static TextureRegionDrawable drawOver;
	
	public static BitmapFont font;
	public static WindowStyle windowStyle;
	public static ButtonStyle buttonStyle;	
	
	public static Texture textureIndicator;
		
	public static Texture textureLevel1;
	public static Texture textureLevel2;
	public static Texture textureLevel3;
	public static Texture textureSelect;
	public static Texture textureEnter;
	
	public static Skin skin;
	
	public static ShapeRenderer shapeRender;
	
	public static void Init(){
		
		atlas = new TextureAtlas( Gdx.files.internal( "razor0/razor.pack" ) );
		regionPlayer = atlas.findRegion( "player" );
		regionArcher = atlas.findRegion( "archer" );
		regionAirforce = atlas.findRegion( "airforce" );
		
		
		textureBulletBlue = new Texture( Gdx.files.internal( "bullet/bullet_blue_16.png" ) );
		textureBulletGray = new Texture( Gdx.files.internal( "bullet/bullet_gray_16.png" ) );
		textureBulletRed = new Texture( Gdx.files.internal( "bullet/bullet_red_16.png" ) );
		textureBulletCycn = new Texture( Gdx.files.internal( "bullet/bullet_cycn_16.png" ) );
					
		regionBulletBlue = new TextureRegion( textureBulletBlue );
		regionBulletGray = new TextureRegion( textureBulletGray );
		regionBulletRed = new TextureRegion( textureBulletRed );
		regionBulletCycn = new TextureRegion( textureBulletCycn );
		
		textureBulletBlue32 = new Texture( Gdx.files.internal( "bullet/bullet_blue_32.png" ) );
		textureBulletGray32 = new Texture( Gdx.files.internal( "bullet/bullet_gray_32.png" ) );
		textureBulletRed32 = new Texture( Gdx.files.internal( "bullet/bullet_red_32.png" ) );
		textureBulletCycn32 = new Texture( Gdx.files.internal( "bullet/bullet_cycn_32.png" ) );

		regionBulletBlue32 = new TextureRegion( textureBulletBlue32 );
		regionBulletGray32 = new TextureRegion( textureBulletGray32 );
		regionBulletRed32 = new TextureRegion( textureBulletRed32 );
		regionBulletCycn32 = new TextureRegion( textureBulletCycn32 );
		
		textureOver = new Texture( Gdx.files.internal( "data/over.png" ) );
		textureExit = new Texture( Gdx.files.internal( "data1/exit.png" ) );
		textureAgain = new Texture( Gdx.files.internal( "data1/again.png" ) );
		
		textureHp = new Texture( Gdx.files.internal( "data1/hp.png" ) );	
		regionHp = new TextureRegion( textureHp );
		
		drawOver = new TextureRegionDrawable( new TextureRegion( textureOver ) );
		
		font = new BitmapFont( Gdx.files.internal( "font/default.fnt" ), Gdx.files.internal( "font/default.png" ), false );
		windowStyle = new WindowStyle( font, font.getColor(), drawOver );
		buttonStyle = new ButtonStyle( drawOver, drawOver, null );	
		
		textureIndicator = new Texture( Gdx.files.internal( "data1/indicator2.png" ) );
		
		
		textureLevel1 = new Texture( Gdx.files.internal( "level/level1.png" ) );
		textureLevel2 = new Texture( Gdx.files.internal( "level/level2.png" ) );
		textureLevel3 = new Texture( Gdx.files.internal( "level/level3.png" ) );
		textureSelect = new Texture( Gdx.files.internal( "level/select.png" ) );
		textureEnter = new Texture( Gdx.files.internal( "level/enter.png" ) );
		
		skin = new Skin( Gdx.files.internal( "skin/uiskin.json" ) );
		shapeRender = new ShapeRenderer();
	}
	
	public static void Dispose(){

		if( textureBulletBlue != null ) textureBulletBlue.dispose();
		if( textureBulletGray != null ) textureBulletGray.dispose();
		if( textureOver != null ) textureOver.dispose();
		if( textureExit != null ) textureExit.dispose();
		if( textureAgain != null ) textureAgain.dispose();
		if( font != null ) font.dispose();
				
		if( textureBulletBlue != null ) textureBulletBlue.dispose();
		if( textureBulletGray != null ) textureBulletGray.dispose();
		if( textureBulletRed != null ) textureBulletRed.dispose();
		if( textureBulletCycn != null ) textureBulletCycn.dispose();
		
		if( textureBulletBlue32 != null ) textureBulletBlue32.dispose();
		if( textureBulletGray32 != null ) textureBulletGray32.dispose();
		if( textureBulletRed32 != null ) textureBulletRed32.dispose();
		if( textureBulletCycn32 != null ) textureBulletCycn32.dispose();
		
		textureLevel1 = new Texture( Gdx.files.internal( "level/level1.png" ) );
		textureLevel2 = new Texture( Gdx.files.internal( "level/level2.png" ) );
		textureLevel3 = new Texture( Gdx.files.internal( "level/level3.png" ) );
		textureSelect = new Texture( Gdx.files.internal( "level/select.png" ) );
		textureEnter = new Texture( Gdx.files.internal( "level/enter.png" ) );
		
		if( textureLevel1 != null ) textureLevel1.dispose();
		if( textureLevel2 != null ) textureLevel2.dispose();
		if( textureLevel3 != null ) textureLevel3.dispose();
		if( textureSelect != null ) textureSelect.dispose();
		if( textureEnter != null ) textureEnter.dispose();
		
		if( textureIndicator != null ) textureIndicator.dispose();
		
		textureOver = new Texture( Gdx.files.internal( "data/over.png" ) );
		textureExit = new Texture( Gdx.files.internal( "data1/exit.png" ) );
		textureAgain = new Texture( Gdx.files.internal( "data1/again.png" ) );
		
		textureHp = new Texture( Gdx.files.internal( "data1/hp.png" ) );
		
		if( textureOver != null ) textureOver.dispose();
		if( textureExit != null ) textureExit.dispose();
		if( textureAgain != null ) textureAgain.dispose();
		if( textureHp != null ) textureHp.dispose();
		
		if( atlas != null ) atlas.dispose();
		if( skin != null ) skin.dispose();
		if( shapeRender != null ) shapeRender.dispose();
	}

}
