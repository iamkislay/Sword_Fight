package com.kislay.gaming.sprites;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.kislay.gaming.utils.GameConstants;


public  abstract class ichigo extends Sprite{
	//protected BufferedImage image;
	protected  abstract BufferedImage printIntro();
	protected  abstract BufferedImage printStance();
	protected  abstract BufferedImage printBankaiStance();
	protected  abstract BufferedImage printJump();
	protected abstract BufferedImage printSlash();
	protected abstract BufferedImage printRun();
	protected abstract BufferedImage printDashForward() ;
	protected abstract BufferedImage printUpSlash();
	protected abstract BufferedImage printDashAttackForward() ;
	protected abstract BufferedImage printBankaiSlash();
	protected abstract BufferedImage printBankaiDashAttack();
	protected abstract BufferedImage printDamage();
	protected abstract BufferedImage printWinning();
	protected abstract BufferedImage printLose();
	protected abstract BufferedImage printTransforming();
	protected abstract BufferedImage printBankaiRun();
	
	protected BufferedImage introImages[]=new BufferedImage[16];
	protected BufferedImage stanceImages[]=new BufferedImage[9];
	protected BufferedImage jumpImages[]=new BufferedImage[16];
	protected BufferedImage slashImage[]=new BufferedImage[8];
	protected BufferedImage runImages[]=new BufferedImage[6];
	protected BufferedImage dashForwardImages[]=new BufferedImage[5];
	protected BufferedImage upSlashImage[]=new BufferedImage[10];
	protected BufferedImage dashAttackForwardImages[]=new BufferedImage[4];
	protected BufferedImage bankaiStanceImages[]=new BufferedImage[8];
	protected BufferedImage bankaiSlashImages[]=new BufferedImage[8];
	protected BufferedImage bankaiDashAttackImages[]=new BufferedImage[5];
	protected BufferedImage damageImages[]=new BufferedImage[3];
	protected BufferedImage winningImages[]= new BufferedImage[5];
	protected BufferedImage loseImages[]=new BufferedImage[2];
	protected BufferedImage transformImages[] =new BufferedImage[19]; 
	protected BufferedImage bankaiRunImages[]=new BufferedImage[6];
	
	
	public ichigo() throws IOException{
		image=ImageIO.read(ichigo.class.getResource("Ichigo Kurosaki (1).png"));
		image1=ImageIO.read(ichigo.class.getResource("Ichigo Kurosaki _removed(2).png"));
		//transforming=false;
		loadStance();
		loadSlash();
		loadJump();
		loadRun();
		loadDashForward();
		loadUpSlash();
		loadDashAttackForward();
		loadBankaiStance();
		loadIntro();
		loadBankaiSlash();
		loadBankaiDashAttack();
		loadDamage();
		loadWinning();
		loadLose();
		loadTransform();
		loadBankaiRun();
		currentMove=STANCE;
	}
	protected void loadIntro() {
		introImages[0]=image1.getSubimage(12, 748, 60, 93);
		introImages[1]=image1.getSubimage(93, 712, 69, 129);
		introImages[2]=image1.getSubimage(186, 700, 90, 141);
//		introImages[3]=image.getSubimage(259, 2763, 78, 99);
//		introImages[4]=image.getSubimage(343, 2763, 77, 99);
//		introImages[5]=image.getSubimage(426, 2763, 77, 99);
//		introImages[6]=image.getSubimage(509, 2763, 77, 99);
//		introImages[7]=image.getSubimage(592, 2759, 76, 103);
//		introImages[8]=image.getSubimage(674, 2745, 78, 117);
//		introImages[9]=image.getSubimage(8, 2893, 79, 128);
//		introImages[10]=image.getSubimage(93, 2894, 87, 127);
//		introImages[11]=image.getSubimage(186, 2894, 85, 127);
//		introImages[12]=image.getSubimage(277, 2875, 93, 146);
//		introImages[13]=image.getSubimage(374, 2948, 112, 73);
//		introImages[14]=image.getSubimage(492, 2944, 113, 77);
//		introImages[15]=image.getSubimage(611, 2913, 89, 108);
	}
	protected void loadStance() {
		stanceImages[0]=image1.getSubimage(12, 887, 82, 109);
		stanceImages[1]=image1.getSubimage(111, 887, 82, 109);
		stanceImages[2]=image1.getSubimage(212, 888, 82, 108);
		stanceImages[3]=image1.getSubimage(305, 889, 82, 107);
		stanceImages[4]=image1.getSubimage(408, 889, 83, 107);
		stanceImages[5]=image1.getSubimage(512, 889, 83, 107);
		stanceImages[6]=image1.getSubimage(608, 889, 82, 107);
		stanceImages[7]=image1.getSubimage(702, 888, 83, 108);
		stanceImages[8]=image1.getSubimage(803, 887, 82, 109);
		
	}
	protected void loadSlash() {
		slashImage[0]=image1.getSubimage(17, 2339, 84, 83);
		slashImage[1]=image1.getSubimage(113, 2339, 100, 83);
		slashImage[2]=image1.getSubimage(225, 2343, 143, 79);
		slashImage[3]=image1.getSubimage(376, 2327, 144, 95);
		slashImage[4]=image1.getSubimage(536, 2326, 97, 96);
		slashImage[5]=image1.getSubimage(643, 2326, 83, 96);
		slashImage[6]=image1.getSubimage(743, 2327, 83, 95);
		slashImage[7]=image1.getSubimage(839, 2329, 83, 93);
	}
	
	protected void loadJump() {
		jumpImages[0]=image.getSubimage(8, 3330, 82, 93);
		jumpImages[1]=image.getSubimage(96, 3330, 82, 93);
		jumpImages[2]=image.getSubimage(185, 3329, 112, 72);
		jumpImages[3]=image.getSubimage(303, 3312, 100, 102);
		jumpImages[4]=image.getSubimage(409, 3307, 98, 107);
		jumpImages[5]=image.getSubimage(513, 3363, 112, 60);
	}
	protected void loadRun() {
		runImages[0]=image1.getSubimage(22, 1204, 82, 90);
		runImages[1]=image1.getSubimage(128, 1206, 80, 88);
		runImages[2]=image1.getSubimage(225, 1214, 80, 80);
		runImages[3]=image1.getSubimage(324, 1211, 84, 82);
		runImages[4]=image1.getSubimage(429, 1213, 82, 82);
		runImages[5]=image1.getSubimage(531, 1214, 83, 82);
	}
	protected void loadDashForward() {
		dashForwardImages[0]=image.getSubimage(8, 3449, 78, 84);
		dashForwardImages[1]=image.getSubimage(92, 3449, 90, 84);
		dashForwardImages[2]=image.getSubimage(188, 3449, 101, 84);
		dashForwardImages[3]=image.getSubimage(295, 3474, 101, 34);
		dashForwardImages[4]=image.getSubimage(402, 3472, 121, 38);
	}
	
	protected void loadUpSlash() {
		upSlashImage[0]=image1.getSubimage(10, 3025, 79, 102);
		upSlashImage[1]=image1.getSubimage(100, 3025, 80, 102);
		upSlashImage[2]=image1.getSubimage(189, 3025, 79,102);
		upSlashImage[3]=image1.getSubimage(276, 2963, 130, 164);
		upSlashImage[4]=image1.getSubimage(414, 2963, 112, 164);
		upSlashImage[5]=image1.getSubimage(530, 2970, 137, 157);
		upSlashImage[6]=image1.getSubimage(675, 3042, 137, 85);
		upSlashImage[7]=image1.getSubimage(820, 3062, 137, 67);
		upSlashImage[8]=image1.getSubimage(965, 3060, 131, 67);
		upSlashImage[9]=image1.getSubimage(1104, 3052, 120, 75);
	}
	
	protected void loadDashAttackForward() {
		dashAttackForwardImages[0]=image.getSubimage(8, 6001, 152, 66);
		dashAttackForwardImages[1]=image.getSubimage(166, 6003, 151, 64);
		dashAttackForwardImages[2]=image.getSubimage(323, 6001, 152, 66);
		dashAttackForwardImages[3]=image.getSubimage(481, 6001, 148, 66);
	}
	
	
	protected void loadBankaiStance() {
		
		bankaiStanceImages[0]=image.getSubimage(8, 7134, 106, 99);
		bankaiStanceImages[1]=image.getSubimage(120, 7134, 106, 99);
		bankaiStanceImages[2]=image.getSubimage(232, 7134, 111, 99);
		bankaiStanceImages[3]=image.getSubimage(349, 7134, 113, 99);
		bankaiStanceImages[4]=image.getSubimage(468, 7134, 112, 99);
		bankaiStanceImages[5]=image.getSubimage(587, 7134, 110, 99);
		bankaiStanceImages[6]=image.getSubimage(8, 7258, 106, 99);
		bankaiStanceImages[7]=image.getSubimage(170, 7260, 73, 97);
		
	}
	
	
	protected void loadTransform() {
		transformImages[0]=image1.getSubimage(9, 6629, 78, 111);
		transformImages[1]=image1.getSubimage(100, 6628, 78, 112);
		transformImages[2]=image1.getSubimage(190, 6632, 74, 108);
		transformImages[3]=image1.getSubimage(281, 6662, 110, 78);
		transformImages[4]=image1.getSubimage(408, 6663, 108, 77);
		transformImages[5]=image1.getSubimage(531, 6661, 108, 79);
		transformImages[6]=image1.getSubimage(649, 6661, 108, 78);
		transformImages[7]=image1.getSubimage(770, 6661, 108, 78);
		transformImages[8]=image1.getSubimage(14, 6782, 71, 94);
		transformImages[9]=image1.getSubimage(95, 6796, 95, 80);
		transformImages[10]=image1.getSubimage(211, 6790, 144, 86);
		transformImages[11]=image1.getSubimage(367, 6797, 151, 79);
		transformImages[12]=image1.getSubimage(532, 6797, 144, 79);
		transformImages[13]=image1.getSubimage(688, 6797, 152, 79);
		transformImages[14]=image1.getSubimage(211, 6790, 144, 86);
		transformImages[15]=image1.getSubimage(367, 6797, 151, 79);
		transformImages[16]=image1.getSubimage(532, 6797, 144, 79);
		transformImages[17]=image1.getSubimage(688, 6797, 152, 79);
		transformImages[18]=image1.getSubimage(920, 6785, 76, 91);
	}
	protected void loadBankaiRun() {
		bankaiRunImages[0]=image.getSubimage(8, 7381, 80, 76);
		bankaiRunImages[1]=image.getSubimage(94, 7380, 81, 75);
		bankaiRunImages[2]=image.getSubimage(181, 7382, 81, 73);
		bankaiRunImages[3]=image.getSubimage(268, 7381, 80, 82);
		bankaiRunImages[4]=image.getSubimage(353, 7380, 81, 80);
		bankaiRunImages[5]=image.getSubimage(440, 7382, 81, 78);
	}
	protected void loadBankaiSlash() {
		bankaiSlashImages[0]=image1.getSubimage(8, 7489, 81, 78);
		bankaiSlashImages[1]=image1.getSubimage(99, 7489, 97, 78);
		bankaiSlashImages[2]=image1.getSubimage(209, 7488, 145, 79);
		bankaiSlashImages[3]=image1.getSubimage(362, 7472, 146, 95);
		bankaiSlashImages[4]=image1.getSubimage(519, 7471, 103, 96);
		bankaiSlashImages[5]=image1.getSubimage(633, 7471, 79, 96);
		bankaiSlashImages[6]=image1.getSubimage(725, 7472, 79, 95);
		bankaiSlashImages[7]=image1.getSubimage(815, 7473, 79, 94);
	}
	protected void loadBankaiDashAttack() {
		bankaiDashAttackImages[0]=image.getSubimage(8, 8636, 136, 71);
		bankaiDashAttackImages[1]=image.getSubimage(150, 8636, 149, 71);
		bankaiDashAttackImages[2]=image.getSubimage(305, 8636, 149, 71);
		bankaiDashAttackImages[3]=image.getSubimage(460, 8636, 148, 71);
		bankaiDashAttackImages[4]=image.getSubimage(614, 8612, 123, 95);
	}
	
	protected void loadDamage() {
		damageImages[0]=image.getSubimage(8,3866,65,113);
		damageImages[1]=image.getSubimage(79,3866,63,108);
		damageImages[2]=image.getSubimage(240,3878,68,101);
	}
	
	protected void loadWinning() {
		winningImages[0]=image.getSubimage(8, 6488, 94, 109);
		winningImages[1]=image.getSubimage(108, 6472, 71, 125);
		winningImages[2]=image.getSubimage(185, 6484, 91, 113);
		winningImages[3]=image.getSubimage(282, 6499, 80, 98);
		winningImages[4]=image.getSubimage(282, 6499, 80, 98);
	}
	
	protected void loadLose() {
		loseImages[0]=image.getSubimage(439, 6519, 121, 78);
		loseImages[1]=image.getSubimage(566, 6528, 65, 69);
	}
	
	@Override
	public BufferedImage defaultImage() {
		// TODO Auto-generated method stub
		if(currentMove==SLASH) {
			if(transform) {
				return printBankaiSlash();
			}
			return printSlash();
		}
		else if(currentMove==JUMP) {
			return printJump();
		}
		else if(currentMove==RUN) {
			if(transform) {
				return printBankaiRun();
			}
			return printRun();
		}
		else if(currentMove==FDASH) {
			return printDashForward();
		}
		else if(currentMove==UPSLASH) {
			return printUpSlash();
		}
		else if(currentMove==DFATTACK) {
			if(transform) {
				return printBankaiDashAttack();
			}
			return printDashAttackForward();
		}
		else if (currentMove==STANCE){
			if(transform) {
				if(transforming)
					return printTransforming();
				return printBankaiStance();
			}
			else if(intro) {
				return printIntro();
			}
			else if(win) {
				return printWinning();
			}
			else if(lost) {
				return printLose();
			}
			return printStance();
		}
		else {
			return printDamage();
		}
	}
	
}
