package com.kislay.gaming.sprites;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.kislay.gaming.utils.GameConstants;

public abstract class Sprite implements GameConstants{
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected int speed;
	protected BufferedImage image1;
	protected BufferedImage image;
	protected boolean transform;
	protected boolean transforming;
	protected boolean intro;
	protected boolean win;
	protected boolean lost;
	protected boolean fire;
	protected int imageIndex;
	protected int currentMove;
	protected int force;
	protected boolean isJump ;
	protected boolean isCollide;
	protected boolean isAttacking;
	protected int health;
	protected int bankaiPower;
	protected boolean toggle;
	
	
	public abstract BufferedImage defaultImage();
	
	public Sprite() {
		health = MAX_HEALTH;
		bankaiPower=MAX_BANKAI;
		
	}
	
	public boolean getToggle() {
		return toggle;
	}
	public void setToogle(boolean value) {
		toggle=value;
	}
	
	public int getHealth() {
		return health;		
	}
	public void setHealth() {
		this.health=(int)(this.health-MAX_HEALTH*0.05);		
	}
	public void setHealth(double q) {
		this.health=(int)(this.health-MAX_HEALTH*q);		
	}
	
	public int getBankaiStatus() {
		return bankaiPower;		
	}
	public void setBankaiStatus(boolean b) {
		if(b)
			this.bankaiPower=(int)(this.bankaiPower-MAX_BANKAI*0.07);		
		else
			this.bankaiPower=(int)(this.bankaiPower+MAX_BANKAI*0.04);	
	}
	
	public boolean isAttacking() {
		return isAttacking;		
	}
	public void setAttacking(boolean isAttacking) {
		
		this.isAttacking=isAttacking;		
	}
	public boolean isCollide() {
		return isCollide;
	}
	public void setCollide(boolean isCollide) {
		this.isCollide=isCollide;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getCurrentMove() {
		return currentMove;
	}

	public void setCurrentMove(int currentMove) {
		this.currentMove = currentMove;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public boolean getTransforming() {
		return transforming;
	}
	public void setTransforming(boolean transforming) {
		this.transforming=transforming;
	}
	
	public boolean getTransform() {
		return transform;
	}
	public void setTransform(boolean transform) {
		this.transform=transform;
	}
	public void setIntro(boolean intro) {
		this.intro=intro;
	}
	public void setLost(boolean lost) {
		this.lost=lost;
	}
	public boolean getLost() {
		return lost;
	}
	
	public void setWin(boolean win) {
		this.win=win;
	}
	public boolean getWin() {
		return win;
	}
	
	public void move() {
		if(!isCollide) {
			x=x+speed;
		}
	}
	
	public boolean getFire() {
		return fire;
	}
	public void setFire(boolean fire) {
		this.fire=fire;
	}
	public void fire() {
		if(!isCollide && fire) {
			x= x + 100;
			//force = force + GRAVITY;
		}
	}
	public void printPlayer(Graphics pen) {
		pen.drawImage(defaultImage(),x,y,w,h, null);

	}

	
}
