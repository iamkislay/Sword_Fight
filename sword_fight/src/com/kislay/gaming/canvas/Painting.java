package com.kislay.gaming.canvas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.kislay.gaming.utils.GameConstants;

public class Painting implements GameConstants,Runnable{
	 boolean gover;
     Board b;
    // private Timer timer;
     Painting(Board b){
    	 this.b=b ;
     }
	@Override
	public void run() {
		// TODO Auto-generated method stub
			while(true) {
				b.repaint();
				//System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(90);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(gover) {
					break;
				}
				
			}
	}

}
