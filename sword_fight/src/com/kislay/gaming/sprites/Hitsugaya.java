package com.kislay.gaming.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Hitsugaya extends Sprite{
	
	protected BufferedImage introImages[]=new BufferedImage[10];
	protected BufferedImage stanceImages[]=new BufferedImage[7];
	protected BufferedImage jumpImages[]=new BufferedImage[16];
	protected BufferedImage slashImage[]=new BufferedImage[11];
	protected BufferedImage slashCrouchImage[]=new BufferedImage[8];
	protected BufferedImage runImages[]=new BufferedImage[6];
	protected BufferedImage dashForwardImages[]=new BufferedImage[5];
	protected BufferedImage upSlashImage[]=new BufferedImage[12];
	protected BufferedImage dashAttackForwardImages[]=new BufferedImage[5];
	protected BufferedImage damageImages[]=new BufferedImage[3];
	protected BufferedImage winningImages[]= new BufferedImage[5];
	protected BufferedImage bankaiStanceImages[]=new BufferedImage[6];
	protected BufferedImage bankaiGuardImages[]=new BufferedImage[6];
	//protected BufferedImage bankaiSlashImages[]=new BufferedImage[8];
	protected BufferedImage loseImages[]=new BufferedImage[2];
	
	protected BufferedImage bankaiRunImages[]=new BufferedImage[6];
	public Hitsugaya() throws IOException{
		currentMove=STANCE;
		w =-170;
		x=GWIDTH-(100);
		h = 160;
		y = FLOOR - h;
		speed = 0;
		transform=false;
		intro=true;
		speed=-SPEED;
		image=ImageIO.read(ichigo.class.getResource(HITSUGAYA_IMAGE));
		image1=ImageIO.read(ichigo.class.getResource("T333shir333 Hitsugaya _removed(1).png"));
		loadStance();
		loadSlash();
		loadSlashCrouch();
		loadRun();
//		loadDashForward();
		loadUpSlash();
		loadDashAttackForward();
		loadIntro();
		loadDamageEffect();
		loadWinning();
		loadBankai();
		loadLose();
		loadBankaiRun();
		loadBankaiGuard();
		isAttacking=false;
	}
	
	protected void loadIntro() {
		introImages[0]=image1.getSubimage(7, 507, 36, 81);
		introImages[1]=image1.getSubimage(52, 508, 41, 80);
		introImages[2]=image1.getSubimage(103, 507, 43, 80);
		introImages[3]=image1.getSubimage(154, 506, 43, 81);
		introImages[4]=image1.getSubimage(205, 507, 62, 80);
		introImages[5]=image1.getSubimage(284, 494, 71, 93);
		introImages[6]=image1.getSubimage(366, 471, 84, 116);
		introImages[7]=image1.getSubimage(459, 471, 83, 116);
		//introImages[8]=image1.getSubimage(574, 2369, 112, 90);
		//introImages[9]=image1.getSubimage(8, 2468, 112, 49);
	}
	protected void loadStance() {
		stanceImages[0]=image1.getSubimage(9, 618, 85, 71);
		stanceImages[1]=image1.getSubimage(101, 618, 85, 71);
		stanceImages[2]=image1.getSubimage(193, 618, 85, 71);
		stanceImages[3]=image1.getSubimage(285, 618, 85, 71);
		stanceImages[4]=image1.getSubimage(378, 618, 85, 71);
		stanceImages[5]=image1.getSubimage(471, 618, 85, 71);
		//stanceImages[6]=image1.getSubimage(563, 618, 85, 71);
	}
	protected void loadSlash() {
		slashImage[0]=image1.getSubimage(6, 1782, 71, 70);
		slashImage[1]=image1.getSubimage(84,1785,78,69);
		slashImage[2]=image1.getSubimage(171,1781,76,74);
		slashImage[3]=image1.getSubimage(254,1778,114,73);
		slashImage[4]=image1.getSubimage(373,1757,120,92);
		slashImage[5]=image1.getSubimage(500,1757,120,92);
		slashImage[6]=image1.getSubimage(630,1757,120,92);
		slashImage[7]=image1.getSubimage(757,1757,120,92);
		slashImage[8]=image1.getSubimage(884,1757,86,92);
		slashImage[9]=image1.getSubimage(979,1763,86,86);
		slashImage[10]=image1.getSubimage(1070,1777,76,72);
	}
	
	protected void loadSlashCrouch() {
		slashCrouchImage[0]=image1.getSubimage(5, 2512, 85, 70);
		slashCrouchImage[1]=image1.getSubimage(95,2518,83,64);
		slashCrouchImage[2]=image1.getSubimage(186,2530,98,52);
		slashCrouchImage[3]=image1.getSubimage(186,2530,98,52);
		slashCrouchImage[4]=image1.getSubimage(186,2530,98,52);
		slashCrouchImage[6]=image1.getSubimage(291,2518,83,64);
		slashCrouchImage[7]=image1.getSubimage(382,2512,85,70);
		
	}
	
	protected void loadRun() {
		runImages[0]=image1.getSubimage(680, 732, 82, 60);
		runImages[1]=image1.getSubimage(768, 735, 87, 60);
		runImages[2]=image1.getSubimage(861, 736, 83, 60);
		runImages[3]=image1.getSubimage(950, 733, 86, 58);
		runImages[4]=image1.getSubimage(1041, 735, 87, 60);
		runImages[5]=image1.getSubimage(1135, 736, 82, 61);
	}
	
	protected void loadDamageEffect() {
		damageImages[0]=image1.getSubimage(329, 1115, 100, 78);
		damageImages[1]=image1.getSubimage(435, 1131, 99, 62);
		damageImages[2]=image1.getSubimage(807, 1130, 82, 65);
	}
	
	
	protected void loadUpSlash() {
		upSlashImage[0]=image1.getSubimage(7, 2271, 76, 7);
		upSlashImage[1]=image1.getSubimage(90, 2272, 84, 68);
		upSlashImage[2]=image1.getSubimage(182, 2270, 82, 69);
		upSlashImage[3]=image1.getSubimage(270, 2273, 80, 67);
		upSlashImage[4]=image1.getSubimage(358, 2272, 78, 67);
		upSlashImage[5]=image1.getSubimage(442, 2271, 76, 75);
		upSlashImage[6]=image1.getSubimage(527, 2250, 121, 102);
		upSlashImage[7]=image1.getSubimage(655, 2250, 113, 102);
		upSlashImage[8]=image1.getSubimage(775, 2250,111, 102);
		upSlashImage[9]=image1.getSubimage(892, 2250, 111, 99);
		upSlashImage[10]=image1.getSubimage(1009, 2250, 96, 88);
		upSlashImage[11]=image1.getSubimage(1111, 2270, 100, 68);
	}
	
	protected void loadDashAttackForward() {
		dashAttackForwardImages[0]=image.getSubimage(8, 5160, 100, 70);
		dashAttackForwardImages[1]=image.getSubimage(114, 5160, 103, 70);
		dashAttackForwardImages[2]=image.getSubimage(223, 5160, 121, 70);
		dashAttackForwardImages[3]=image.getSubimage(350, 5160, 121, 70);
		dashAttackForwardImages[4]=image.getSubimage(477, 5160, 105, 74);
	}
	
	protected void loadWinning() {
		winningImages[0]=image.getSubimage(8, 5567, 96, 76);
		winningImages[1]=image.getSubimage(110, 5564, 90, 89);
		winningImages[2]=image.getSubimage(206, 5563, 95, 79);
		winningImages[3]=image.getSubimage(306, 5563, 69, 79);
		winningImages[4]=image.getSubimage(381, 5563, 66, 79);
	}
	
	
	protected void loadBankai() {
		bankaiStanceImages[0]=image1.getSubimage(4,6057,194,111);
		bankaiStanceImages[1]=image1.getSubimage(204,6054,195,115);
		bankaiStanceImages[2]=image1.getSubimage(398,6050,200,118);
		bankaiStanceImages[3]=image1.getSubimage(600,6050,197,118);
		bankaiStanceImages[4]=image1.getSubimage(796,6052,199,114);
		bankaiStanceImages[5]=image1.getSubimage(998,6054,195,114);
		
	}
	protected void loadBankaiRun() {
		bankaiRunImages[0]=image1.getSubimage(2,6496,169,117);
		bankaiRunImages[1]=image1.getSubimage(176,6498,164,114);
		bankaiRunImages[2]=image1.getSubimage(349,6502,160,113);
		bankaiRunImages[3]=image1.getSubimage(520,6500,161,110);
		bankaiRunImages[4]=image1.getSubimage(690,6501,160,113);
		bankaiRunImages[5]=image1.getSubimage(858,6501,162,115);
		
	}
	protected void loadBankaiGuard() {
		bankaiGuardImages[0]=image1.getSubimage(6,7563,120,108);
		bankaiGuardImages[1]=image1.getSubimage(132,7579,118,92);
		bankaiGuardImages[2]=image1.getSubimage(6,7563,120,108);
		bankaiGuardImages[3]=image1.getSubimage(132,7579,118,92);
		bankaiGuardImages[4]=image1.getSubimage(6,7563,120,108);
		bankaiGuardImages[5]=image1.getSubimage(132,7579,118,92);
		
	}
	
	
	private void loadLose() {
		loseImages[0]=image.getSubimage(541, 5569, 98, 74);
		loseImages[1]=image.getSubimage(645, 5584, 75, 59);
	}
	
	 private BufferedImage printSlash() {
		 if(imageIndex>10) {
			 isAttacking=false;
			 imageIndex=0;
			 currentMove=STANCE;
		 }
		 isAttacking=true;
		 
		 BufferedImage img=slashImage[imageIndex];
		 imageIndex++;
		 return img;
	 }
	 
	 private BufferedImage printSlashCrouch() {
		 if(imageIndex>7) {
			 isAttacking=false;
			 imageIndex=0;
			 currentMove=STANCE;
		 }
		 isAttacking=true;
		 
		 BufferedImage img=slashCrouchImage[imageIndex];
		 imageIndex++;
		 return img;
	 }
	 
	private BufferedImage printIntro() {
		if(imageIndex>7) {
			imageIndex=0;
			intro=false;
			currentMove=STANCE;

		}
		isAttacking=false;
		BufferedImage img=introImages[imageIndex];
		imageIndex++;
		try {
			Thread.sleep(80);
		}catch(Exception e) {};
		return img;
		
	}
	
	private BufferedImage printStance() {
		isAttacking=false;
		if(imageIndex>5) {
			imageIndex=0;
			//currentMove=STANCE;

		}
		BufferedImage img=stanceImages[imageIndex];
		imageIndex++;
		return img;
		
	}
	
	private BufferedImage printRun() {
		isAttacking=false;
		if(imageIndex>5) {
			imageIndex=0;
			currentMove=STANCE;
		}
		BufferedImage img =runImages[imageIndex];
		imageIndex++;
		return img;
	}
	
	private BufferedImage printUpSlash() {
		if(imageIndex>11) {
			imageIndex=0;
			isAttacking=false;
			currentMove=STANCE;
		}
		isAttacking=true;
		BufferedImage img=upSlashImage[imageIndex];
		imageIndex++;
		return img;
	}
	
	private BufferedImage printDashAttackForward() {
		if(imageIndex>4) {
			imageIndex=0;
			isAttacking=false;
			currentMove=STANCE;
		}
		isAttacking=true;
		BufferedImage img=dashAttackForwardImages[imageIndex];
		imageIndex++;
		try {
			Thread.sleep(150);}catch(Exception e) {};
		return img;
	}
	
	public BufferedImage printDamage() {
		if(imageIndex>damageImages.length-1) {
			imageIndex = 0;
			currentMove = STANCE;
		}
		//move();
		BufferedImage img =  damageImages[imageIndex];
		imageIndex++;
		try {
			Thread.sleep(100);}catch(Exception e) {};
		return img;
		
	}
	
	private BufferedImage printWinning() {
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
	
	private BufferedImage printBankai() {
		isAttacking=false;
		if(imageIndex>5) {
			imageIndex=0;
			currentMove=STANCE;
		}
		BufferedImage img=bankaiStanceImages[imageIndex];
		imageIndex++;
		return img;
	}
	
	private BufferedImage printBankaiRun() {
		isAttacking=false;
		if(imageIndex>5) {
			imageIndex=0;
			currentMove=STANCE;
		}
		BufferedImage img=bankaiRunImages[imageIndex];
		imageIndex++;
		return img;
	}
	private BufferedImage printBankaiGuard() {
		isAttacking=false;
		if(imageIndex>5) {
			imageIndex=0;
			//currentMove=STANCE;
		}
		BufferedImage img=bankaiGuardImages[imageIndex];
		imageIndex++;
		return img;
	}
	
	
	
	
	private BufferedImage printLose() {
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
	@Override
	public BufferedImage defaultImage() {
		// TODO Auto-generated method stub
		if(currentMove==SLASH) {
			return printSlash();
		}
		else if(currentMove==CROUCHSLASH) {
			return printSlashCrouch();
		}
		else if(currentMove==UPSLASH) {
			return printUpSlash();
		}
		else if(currentMove==DFATTACK) {
			return printDashAttackForward();
		}
		else if(currentMove==RUN) {
			if(transform) {
				return printBankaiRun();
			}
			else {
				return printRun();}
		}
		else if(currentMove==STANCE){
			if(win) {
				return printWinning();
			}
			else if(transform) {
				return printBankai();
			}
			else if(intro) {
				return printIntro();
			}
			else if(lost) {
				return printLose();
			}
			return printStance();
		}
		else if(currentMove==GUARD && transform) {
			return printBankaiGuard();
		}
		
		else {
			if(currentMove!=GUARD)
			   return printDamage();
			else
				return printStance();
		}  
	}
	
	
	
}
