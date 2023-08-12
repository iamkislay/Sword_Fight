package com.kislay.gaming.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ichigo_slash extends Sprite{
	private BufferedImage slashPowerImages[]= new BufferedImage[4];
	private BufferedImage getsugaTenshouPowerImages[]=new BufferedImage[8];
	
	@Override
	public BufferedImage defaultImage() {
		// TODO Auto-generated method stub
		if(currentMove==SLASH) {
			
			//return printSlashPower();
			return printGetsugaTenshouPower();
		}
		return null;
	}
	public ichigo_slash() throws IOException{
		x = 230;
		h = 200;
		w = 200;
		y = FLOOR - h-50;
		speed = 0;
		image=ImageIO.read(ichigo.class.getResource(ICHIGO_IMAGE));
		loadSlashPower();
		loadGetsugaTenshouPower();
	}
	private void loadSlashPower() {
		slashPowerImages[0]=image.getSubimage(8, 4163, 120, 76);
		slashPowerImages[1]=image.getSubimage(134, 4163, 152, 142);
		slashPowerImages[2]=image.getSubimage(292, 4163, 84, 142);
		slashPowerImages[3]=image.getSubimage(382, 4200, 76, 105);
	}
	private void loadGetsugaTenshouPower() {
		getsugaTenshouPowerImages[0]=image.getSubimage(8, 6819, 144, 259);
		getsugaTenshouPowerImages[1]=image.getSubimage(158, 6827, 81, 251);
		getsugaTenshouPowerImages[2]=image.getSubimage(245, 6901, 77, 177);
		getsugaTenshouPowerImages[3]=image.getSubimage(327, 7030, 76, 48);
		getsugaTenshouPowerImages[4]=image.getSubimage(485, 6898, 63, 141);
		getsugaTenshouPowerImages[5]=image.getSubimage(554, 6900, 60, 139);
		getsugaTenshouPowerImages[6]=image.getSubimage(620, 6891, 60, 163);
		getsugaTenshouPowerImages[7]=image.getSubimage(686, 6891, 55, 163);
	}

	private BufferedImage printSlashPower() {
		if(imageIndex>3) {
			imageIndex=0;
			currentMove=STANCE;
			isAttacking=false;
		}
		isAttacking=true;
		BufferedImage img=slashPowerImages[imageIndex];
		imageIndex++;
		return img;
	}
	private BufferedImage printGetsugaTenshouPower() {
		if(imageIndex>7) {
			imageIndex=0;
			currentMove=STANCE;
			isAttacking=false;
		}
		//fire();
		isAttacking=true;
		BufferedImage img=getsugaTenshouPowerImages[imageIndex];
		imageIndex++;
		return img;
	}
	
}
