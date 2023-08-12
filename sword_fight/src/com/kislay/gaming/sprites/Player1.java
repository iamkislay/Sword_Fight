package com.kislay.gaming.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Player1 extends ichigo{
	public Player1() throws IOException{
		x = 100;
		h = 200;
		w = 150;
		y = FLOOR - h;
		speed = 0;
		transform=false;
		intro=true;
		isAttacking=false;
		
		
	}

	
	protected BufferedImage printStance() {
		isAttacking=false;
		if(imageIndex>8) {
			imageIndex=0;
			
		}
		BufferedImage img=stanceImages[imageIndex];
		imageIndex++;
		return img;
	}
	protected BufferedImage printSlash() {
		if(imageIndex>7) {
			imageIndex=0;
			currentMove=STANCE;
			isAttacking=false;
		}
		isAttacking=true;
		
		BufferedImage img=slashImage[imageIndex];
		imageIndex++;
		return img;
	}
	public void jump() {
		if(!isJump) {
		isJump = true;
		force = -20;
		y = y + force;
		
		}
		isJump=false;
	}
	
	@Override
	protected BufferedImage printJump() {
		jump();
		if(imageIndex>5) {
			imageIndex=0;
			currentMove=STANCE;
			isJump=false;
			
		}
		
		
		BufferedImage img=jumpImages[imageIndex];
		imageIndex++;
		return img;
	}
	public void fall() {
		if(y>=(FLOOR-h)) {
			isJump = false;
			return ;
		}
		y = y + force;
		force = force + GRAVITY;
	}


	@Override
	protected BufferedImage printRun() {
		// TODO Auto-generated method stub
		if(imageIndex>5) {
			imageIndex=0;
			currentMove=STANCE;

		}
		
		BufferedImage img=runImages[imageIndex];
		imageIndex++;
		return img;
		
	}


	@Override
	protected BufferedImage printDashForward() {
		// TODO Auto-generated method stub
		if(imageIndex>4) {
			imageIndex=0;
			currentMove=STANCE;

		}
		
		BufferedImage img=dashForwardImages[imageIndex];
		imageIndex++;
		return img;
	}


	@Override
	protected BufferedImage printUpSlash() {
		// TODO Auto-generated method stub
		if(imageIndex>9) {
			imageIndex=0;
			currentMove=STANCE;
			isAttacking=false;
		}
		isAttacking=true;
		BufferedImage img=upSlashImage[imageIndex];
		
		imageIndex++;
		return img;

		
	}


	@Override
	protected BufferedImage printDashAttackForward() {
		// TODO Auto-generated method stub
		if(imageIndex>3) {
			imageIndex=0;
			currentMove=STANCE;
			isAttacking=false;
		}
		isAttacking=true;
		BufferedImage img=dashAttackForwardImages[imageIndex];
		imageIndex++;
		try {
			Thread.sleep(150);}catch(Exception e) {};
		
		return img;
	}
   

	@Override
	protected BufferedImage printBankaiStance() {
		// TODO Auto-generated method stub
		isAttacking=false;
		if(imageIndex>6) {
			imageIndex=0;
		}
		BufferedImage img=bankaiStanceImages[imageIndex];
		imageIndex++;
		return img;
		
	}


	@Override
	protected BufferedImage printIntro() {
		// TODO Auto-generated method stub
		isAttacking=false;
		if(imageIndex>2) {
			intro=false;
			imageIndex=15;
			currentMove=STANCE;
			
		}
		BufferedImage img=introImages[imageIndex];
		if(imageIndex==1) {
			try {
				Thread.sleep(500);}catch(Exception e) {};
		}
		imageIndex++;
		
		try {
			Thread.sleep(70);}catch(Exception e) {};
		return img;
		
	}

	protected BufferedImage printTransforming() {
		// TODO Auto-generated method stub
		if(imageIndex>18) {
			imageIndex=0;
			currentMove=STANCE;
			isAttacking=false;
			transforming=false;
		}
		//isAttacking=true;
		BufferedImage img= transformImages[imageIndex];
		imageIndex++;
		return img;
		
	}
	
	protected BufferedImage printBankaiRun() {
		if(imageIndex>5) {
			imageIndex=0;
			currentMove=STANCE;

		}
		
		BufferedImage img=bankaiRunImages[imageIndex];
		imageIndex++;
		return img;
	}
	
	@Override
	protected BufferedImage printBankaiSlash() {
		// TODO Auto-generated method stub
		if(imageIndex>7) {
			imageIndex=0;
			currentMove=STANCE;
			isAttacking=false;
		}
		isAttacking=true;
		BufferedImage img=bankaiSlashImages[imageIndex];
		imageIndex++;
		return img;
		
	}


	@Override
	protected BufferedImage printBankaiDashAttack() {
		// TODO Auto-generated method stub
		if(imageIndex>4) {
			imageIndex=0;
			currentMove=STANCE;
			isAttacking=false;
		}
		isAttacking=true;
		BufferedImage img=bankaiDashAttackImages[imageIndex];
		imageIndex++;
		try {
			Thread.sleep(100);}catch(Exception e) {};
		return img;
		
	}


	@Override
	protected BufferedImage printDamage() {
		// TODO Auto-generated method stub
		if(imageIndex>damageImages.length-1) {
			imageIndex=0;
			currentMove=STANCE;
		}
		BufferedImage img =damageImages[imageIndex];
		imageIndex++;
		try {
			Thread.sleep(100);}catch(Exception e) {};
		return img;
	}
	
	protected  BufferedImage printWinning() {
		if(imageIndex>4) {
			imageIndex=4;
			win=false;
			currentMove=STANCE;

		}
		isAttacking=false;
		BufferedImage img=winningImages[imageIndex];
		imageIndex++;
		
		return img;
		
	}
	protected  BufferedImage printLose() {
		if(imageIndex>1) {
			imageIndex=1;
			//win=false;
			currentMove=STANCE;

		}
		isAttacking=false;
		BufferedImage img=loseImages[imageIndex];
		imageIndex++;
		try {
			Thread.sleep(500);}catch(Exception e) {};
		
		return img;
		
	}
	
	
	
}
