package com.kislay.gaming.canvas;


import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;

import com.kislay.gaming.utils.GameConstants;



public class GameFrame extends JFrame implements GameConstants  {
	public Music se = new Music();
	URL url=getClass().getResource("epic-hybrid-logo-157092 (online-audio-converter.com).wav");
	public GameFrame() throws IOException  {
		se.setFile(url);
		se.play();
		setResizable(false);
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(GWIDTH, GHEIGHT);
		setLocationRelativeTo(null);
		Board board = new Board();
		
		add(board); // Board added in Frame.
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
			try {
				GameFrame obj = new GameFrame();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

}
