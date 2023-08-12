package com.kislay.gaming.sprites;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SoulEnergy extends Sprite{
	String playerName;
	public SoulEnergy(int x, String playerName) {
		this.x = x;
		y = 50;
		h = 20;
		w = 500;
		
		this.playerName = playerName;
	}

	@Override
	public BufferedImage defaultImage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void printRectangle(Graphics pen) {
		pen.setColor(Color.RED);
		pen.fillRect(x,y, w, h);
		pen.setColor(Color.GREEN);
		pen.fillRect(x,y, health, h);
		pen.setColor(Color.WHITE);
		pen.setFont(new Font("Times", Font.BOLD, 30));
		pen.drawString(playerName, x, y + 80 );
	}
	public void printRectanglenew(Graphics pen) {
		pen.setColor(Color.blue);
		pen.fillRect(x,y+35, w, h-10);
		pen.setColor(Color.yellow);
		pen.fillRect(x,y+35, bankaiPower, h-10);
		pen.setColor(Color.WHITE);
		pen.setFont(new Font("Times", Font.BOLD, 30));
		pen.drawString(playerName, x, y + 80 );
	}
}
