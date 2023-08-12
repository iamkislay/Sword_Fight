package com.kislay.gaming.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ice_bankai extends Sprite{

	private BufferedImage iceImages[]= new BufferedImage[2];
	@Override
	public BufferedImage defaultImage() {
		// TODO Auto-generated method stub
		if(transform) {
			
			return iceImages[0];
		}
		return null;
	}
	public ice_bankai() throws IOException{
		x = GWIDTH-80;
		h = 250;
		w = -200;
		y = FLOOR - h;
		speed = 0;
		image=ImageIO.read(ichigo.class.getResource(HITSUGAYA_IMAGE));
		//loadIce();
		transform=false;
	}
	private void loadIce() {
		iceImages[0]=image.getSubimage(8, 6199, 138, 106);
		iceImages[1]=image.getSubimage(152, 6207, 190, 86);
	
		
	}

}