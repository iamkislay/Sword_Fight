package com.kislay.gaming.canvas;



import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.kislay.gaming.sprites.Hitsugaya;
import com.kislay.gaming.sprites.Player1;
import com.kislay.gaming.sprites.SoulEnergy;
import com.kislay.gaming.sprites.bankaiEnengy;
import com.kislay.gaming.sprites.ice_bankai;
import com.kislay.gaming.sprites.ichigo;
import com.kislay.gaming.sprites.ichigo_slash;
//import com.kislay.gaming.sprites.Power;
import com.kislay.gaming.utils.GameConstants;



public class Board extends JPanel implements GameConstants,Runnable {
	Music se = new Music();
	Music se2 = new Music();
	URL urlbackground=getClass().getResource("yt1s.com-Bleach-OST-1-Track-16-Heat-of-the-Battle (mp3cut.net).wav");
	URL urlslash=getClass().getResource("slash-21834.wav");
	URL urlslash1=getClass().getResource("clean-fast-swooshaiff-14784.wav");
	BufferedImage imageBg;
	private Timer timer;
	private Player1 player1;
	private Hitsugaya captain10;
	//private ichigo_slash s1;
	//private bankaiEnengy be;
	//private ice_bankai ib;
	private SoulEnergy ichigoFullPower;
	private SoulEnergy hitsugayaFullPower;
	private boolean gameOver;
	Painting p;
	Thread th2;
	private void gameLoop() {
		     p=new Painting(this);
		     th2=new Thread(p,"Paint Thread");
		     th2.start();
		timer = new Timer(GAME_LOOP,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//repaint();
				if(gameOver) {
					//captain10.setIntro(true);
		
					//timer.stop();
				}
				player1.fall();
				//s1.fire();
				collision();
				//concentrate();
				isGameOver();
				
			}
		});
		timer.start();
	}
	
	private void loadPower() {
		ichigoFullPower = new SoulEnergy(30, "Ichigo");
		hitsugayaFullPower = new SoulEnergy(GWIDTH - 550, "Hitsugaya");
	}
	
	private void printFullPower(Graphics g) {
		ichigoFullPower.printRectanglenew(g);
		hitsugayaFullPower.printRectanglenew(g);
		ichigoFullPower.printRectangle(g);
		hitsugayaFullPower.printRectangle(g);
	}
	
	private boolean isCollide() {
		int xDistance = Math.abs(player1.getX() - captain10.getX());
		int yDistance = Math.abs(player1.getY()- captain10.getY());
		int maxH = Math.max(player1.getH(), captain10.getH());
		int maxW = Math.max(player1.getW(), -captain10.getW());
		return xDistance<=(maxW+100)  ;
		
				//yDistance<=(maxH-50);
		
	}
	
//	private void wallCollision() {
//		
//	}
	
	private void collision() {
		if(isCollide()) {
			if(player1.isAttacking() && captain10.isAttacking()) {
				
			}
			else if(player1.isAttacking())
			{	
				
				
				if(!(captain10.getCurrentMove()==GUARD)) {
					captain10.setCurrentMove(DAMAGE);
					if(player1.getTransform())
						ichigoFullPower.setBankaiStatus(true);
					else {
						if(ichigoFullPower.getBankaiStatus()<MAX_BANKAI)
							ichigoFullPower.setBankaiStatus(false);
					}
					if(ichigoFullPower.getBankaiStatus()<=0) {
						player1.setTransform(false);
					}
					hitsugayaFullPower.setHealth();}
				else {
					
					hitsugayaFullPower.setHealth(0.008);
				}
				captain10.setCollide(true);
				captain10.setSpeed(0);
				
			}
			else if(captain10.isAttacking()) {
				player1.setCurrentMove(DAMAGE);
				player1.setCollide(true);
				player1.setSpeed(0);
				
				if(captain10.getTransform())
					hitsugayaFullPower.setBankaiStatus(true);
				else {
					if(hitsugayaFullPower.getBankaiStatus()<MAX_BANKAI)
						hitsugayaFullPower.setBankaiStatus(false);
				}
				ichigoFullPower.setHealth();
			}
			
			player1.setCollide(true);
			captain10.setCollide(true);
			//System.out.println("Collision.....");
			captain10.setSpeed(0);
			player1.setSpeed(0);
		}
		else {
			
//			se.setFile(urlmiss);
//			se.play();
			captain10.setCollide(false);
			//captain10.setSpeed(SPEED);
			player1.setCollide(false);
			//player1.setSpeed(SPEED);
		}
	}
	private void concentrate() {
		if(player1.getX()-captain10.getX()>150) {
			captain10.setW(150);
			player1.setW(-200);
			//captain10.setSpeed(SPEED);
		}
		else {
			captain10.setW(-150);
			player1.setW(200);
		}
		
	}
	
	private void isGameOver() {
		if(ichigoFullPower.getHealth()<=0) {
			captain10.setX(player1.getX()+550);
			player1.setLost(true);
			captain10.setWin(true);
		    
			//captain10.setCurrentMove(STANCE);
			gameOver = true;
		}
		if(hitsugayaFullPower.getHealth()<=0) {
			player1.setX(captain10.getX()-550);
			captain10.setLost(true);
			player1.setWin(true);
		    
			//captain10.setCurrentMove(STANCE);
			gameOver = true;
			p.gover=true;
		}
		
	}
	
	private void printGameOver(Graphics pen) {
		if(gameOver) {
			pen.setColor(Color.RED);
		pen.setFont(new Font("times", Font.BOLD, 40));
		pen.drawString("Game Over", GWIDTH/2-100, GHEIGHT/2-100);
		}
	}
	
	
	public Board() throws IOException  {
		se2.setFile(urlbackground);
		se2.play();
		loadBackgroundImage();
		player1 = new Player1();
		captain10=new Hitsugaya();
		Thread th1=new Thread(this,"bindEvents thread");
		
		
		setFocusable(true);
		//bindEvents();
		th1.start();
		gameLoop();
		loadPower();
		
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		bindEvents();
	}
	
	
    
	
	private void bindEvents() {
		System.out.println(Thread.currentThread().getName());
		this.addKeyListener(new KeyAdapter() {
			
			
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				player1.setSpeed(0);
				captain10.setSpeed(0);
				//be.setSpeed(0);
				//ib.setSpeed(0);
				
			}
//			
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if(player1.getY()>=FLOOR-player1.getH()-50 && FLOOR>=player1.getY()) {
						player1.setCurrentMove(JUMP);
						                                                 
					}
				}
				else if(e.getKeyCode() == KeyEvent.VK_S) {
					
					player1.setW(150);
					player1.setCurrentMove(RUN);
					player1.setSpeed(SPEED);
					if(player1.getToggle()) {
						player1.setX(player1.getX()-100);
						player1.setToogle(false);
					}
					player1.move();
					//be.move();
					//be.setSpeed(SPEED);
					//repaint();
				}
				
				else if(e.getKeyCode() == KeyEvent.VK_A) {
					player1.setW(-150);
					player1.setCurrentMove(RUN);
					player1.setSpeed(-SPEED);
					if(!player1.getToggle()) {
						player1.setX(player1.getX()+100);
						player1.setToogle(true);
					}
					player1.setCollide(false);
					player1.move();
					//be.move();
					//be.setSpeed(-SPEED);
					//repaint();
				}
//				
				else if (e.getKeyCode()== KeyEvent.VK_D && e.isControlDown()) {
					player1.setCurrentMove(FDASH);
					player1.setSpeed(100);
					player1.move();
				//	be.move();
					//be.setSpeed(100);
					
				}
//				
			    if (e.getKeyCode()== KeyEvent.VK_P) {
					player1.setCurrentMove(SLASH);
					se.setFile(urlslash);
					se.play();
					//s1.setX(player1.getX()+130);
					//s1.setFire(true);
					//s1.setCurrentMove(SLASH);
				}
//				 
				else if (e.getKeyCode() == KeyEvent.VK_E) {
					player1.setCurrentMove(UPSLASH);
					//repaint();
				}
				else if (e.getKeyCode() == KeyEvent.VK_V) {
					player1.setCurrentMove(DFATTACK);
					player1.setSpeed(player1.getSpeed());
					player1.move();
					//repaint();
				}
				else if(e.getKeyCode()==KeyEvent.VK_1) {
					player1.setTransforming(true);
					player1.setTransform(true);
					//be.setTransform(true);
				}
				else if (e.getKeyCode() == KeyEvent.VK_H) {
					captain10.setCurrentMove(SLASH);					
					//repaint();
				}
				
				else if (e.getKeyCode() == KeyEvent.VK_J) {
					captain10.setCurrentMove(CROUCHSLASH);					
					//repaint();
				}
				
				else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					captain10.setW(-150);
					captain10.setCurrentMove(RUN);
					captain10.setSpeed(-SPEED);
					if(captain10.getToggle()) {
						captain10.setX(captain10.getX()+100);
						captain10.setToogle(false);
					}
					captain10.move();
					//ib.move();
					//ib.setSpeed(-SPEED);
					
				}
				else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					captain10.setW(150);
					
					captain10.setCurrentMove(RUN);
					captain10.setSpeed(SPEED);
					if(!captain10.getToggle()) {
						captain10.setX(captain10.getX()-100);
						captain10.setToogle(true);
					}
				    //captain10.setX(captain10.getX()-100);
					captain10.setCollide(false);
					captain10.move();
					//ib.move();
					//ib.setSpeed(SPEED);
					
				}
				else if(e.getKeyCode()==KeyEvent.VK_U) {
					captain10.setCurrentMove(UPSLASH);
				}
				else if (e.getKeyCode() == KeyEvent.VK_M) {
					captain10.setCurrentMove(DFATTACK);
					captain10.setSpeed(captain10.getSpeed());
					captain10.move();
					//repaint();
				}
				if(e.getKeyCode()==KeyEvent.VK_N ) {
					captain10.setCurrentMove(GUARD);
				}
				else if(e.getKeyCode()==KeyEvent.VK_B) {
					captain10.setCurrentMove(STANCE);
				}
				
				
				else if(e.getKeyCode()==KeyEvent.VK_7) {
					captain10.setTransform(true);
					//ib.setTransform(true);
				}
//				
//				
			}
		});
	}
//	
//	
	
	@Override
	public void paintComponent(Graphics pen) {
		// Rendering / Painting
		super.paintComponent(pen);
		printBackgroundImage(pen);
		//be.printPlayer(pen);
		//ib.printPlayer(pen);
		captain10.printPlayer(pen);
		player1.printPlayer(pen);
		
		//s1.printPlayer(pen);
		
		//kenPlayer.printPlayer(pen);
		printFullPower(pen);
		printGameOver(pen);
		
		
		
		
	}

	
	private void printBackgroundImage(Graphics pen) {
	    
		pen.drawImage(imageBg,0,0, 1400,900, null);
	}
	
	
	
	private void loadBackgroundImage() {
		try {
			//imageBg = ImageIO.read(Board.class.getResource("Karakura Town.png")).getSubimage(0, 2, 1370, 796);
			imageBg = ImageIO.read(Board.class.getResource("wallpaper_1.png"));
			}
			catch(Exception ex) {
				System.out.println("Background Image Loading Fail...");
				System.exit(0);
			
			}
	}

	
}

