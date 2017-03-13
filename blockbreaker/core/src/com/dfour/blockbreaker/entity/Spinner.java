package com.dfour.blockbreaker.entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.dfour.blockbreaker.BBModel;

public class Spinner extends Entity {
	
	public Spinner(Body bod, AtlasRegion atlasRegion, boolean clockwise){
		this.body = bod;
		if(null == atlasRegion){
			Pixmap pmap = new Pixmap(20,100, Pixmap.Format.RGBA8888);
			pmap.setColor(Color.FIREBRICK);
			pmap.fill();
			sprite = new Sprite(new Texture(pmap));
			pmap.dispose();
			
		}else{
			sprite = new Sprite(atlasRegion);
		}
		sprite.setX(bod.getPosition().x);
		sprite.setY(bod.getPosition().y);
		
		sprite.setOriginCenter();
		sprite.setScale(0.35f);
		sprite.setPosition(
				(body.getPosition().x) * BBModel.BOX_TO_WORLD -(20/2), 
				(body.getPosition().y)* BBModel.BOX_TO_WORLD -(100/2));
		if(clockwise){
			this.body.setAngularVelocity(2f);
		}else{
			this.body.setAngularVelocity(-2f);
		}
	}

	@Override
	public void update(){
		sprite.setRotation(body.getAngle() * 57.2958f);
	}
}