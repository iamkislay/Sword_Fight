package com.kislay.gaming.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class bankaiEnengy extends Sprite{

	private BufferedImage soulPressureImages[]= new BufferedImage[6];
	@Override
	public BufferedImage defaultImage() {
		// TODO Auto-generated method stub
		if(transform) {
			
			return printSoulPressure();
		}
		return null;
	}
	public bankaiEnengy() throws IOException{
		x = 100;
		h = 250;
		w = 200;
		y = FLOOR - h;
		speed = 0;
		image=ImageIO.read(ichigo.class.getResource(ICHIGO_IMAGE));
		loadSoulPressure();
		transform=false;
	}
	private void loadSoulPressure() {
		soulPressureImages[0]=image.getSubimage(14, 10021, 114, 120);
		soulPressureImages[1]=image.getSubimage(128, 10019, 106, 124);
		soulPressureImages[2]=image.getSubimage(240, 10029, 110, 114);
		soulPressureImages[3]=image.getSubimage(356, 10025, 114, 116);
		soulPressureImages[4]=image.getSubimage(476, 10023, 114, 118);
		soulPressureImages[5]=image.getSubimage(596, 10021, 114, 122);
		
	}
	private BufferedImage printSoulPressure() {
		if(imageIndex>5) {
			imageIndex=0;
			//currentMove=STANCE;
			
		}
		
		BufferedImage img=soulPressureImages[imageIndex];
		imageIndex++;
		return img;
	}
}
