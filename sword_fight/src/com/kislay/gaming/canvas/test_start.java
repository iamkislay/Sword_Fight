package com.kislay.gaming.canvas;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

public class test_start extends JFrame {
	
	URL url=getClass().getResource("Bleach OST - Number One (TYBW Remix) Extended Edition (1).wav");
    Music se = new Music();
	private myPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test_start frame = new test_start();
					frame.setVisible(true);
					frame.setSize(new Dimension(800,700));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test_start() {
		System.out.println(url);
		//sound_track="epic-hybrid-logo-157092 (online-audio-converter.com).wav";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 618);
		contentPane=new myPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(null);
		add(contentPane);
//		
		
		myJLabel lblNewLabel = new myJLabel("Start Game");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(Color.blue);
		lblNewLabel.setBorder(new EmptyBorder(5,5,5,5));
		//lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(340, 323, 126, 28);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setBackground(new Color(60,92,198));
				lblNewLabel.validate();
			}
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBackground(Color.blue);
				lblNewLabel.validate();
			}
			public void mouseClicked(MouseEvent e) {
				try {
					new GameFrame();
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				se.setFile(null);
				try {
					se.stop();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
			
		});
		
		contentPane.add(lblNewLabel);
		
		myJLabel lblNewLabel2 = new myJLabel("Exit");
		lblNewLabel2.setForeground(new Color(255, 255, 255));
		lblNewLabel2.setBackground(Color.blue);
		lblNewLabel2.setBorder(new EmptyBorder(5,5,5,5));
		//lblNewLabel.setOpaque(true);
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setBounds(340, 356, 126, 28);
		lblNewLabel2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				lblNewLabel2.setBackground(new Color(60,92,198));
				lblNewLabel2.validate();
			}
			public void mouseExited(MouseEvent e) {
				lblNewLabel2.setBackground(Color.blue);
				lblNewLabel2.validate();
			}
			public void mouseClicked(MouseEvent e) {
				System.exit(ABORT);
			}
			
		});
		contentPane.add(lblNewLabel2);
		se.setFile(url);
        se.play();
		
		ImageIcon sound_open=new ImageIcon(new ImageIcon(test_start.class.getResource("speaker_open.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
		ImageIcon sound_close=new ImageIcon(new ImageIcon(test_start.class.getResource("speaker_close.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        //ImageIcon sound_open=new ImageIcon(ClassLoader.getSystemResource("speaker_open.png"));
		JLabel sound=new JLabel(sound_open);
		sound.setBounds(700,50,40,40);
		sound.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	if(sound.getIcon()==sound_open) {
            		se.setFile(null);
                    try {
    					se.stop();
    				} catch (IOException ee) {
    					// TODO Auto-generated catch block
    					ee.printStackTrace();
    				}
                    sound.setIcon(sound_close);
                    sound.validate();
            	}
            	else {
            		se.setFile(url);
                    se.play();
                    sound.setIcon(sound_open);
                    sound.validate();
            	}
                
            }

			
        });
		contentPane.add(sound);
	}
	
class myPanel extends JPanel{
	BufferedImage imageBg;
	private void printBackgroundImage(Graphics pen) {
	    
		pen.drawImage(imageBg,0,0, 800,700, null);
	}
	
	
	
	private void loadBackgroundImage() {
		try {
			
			imageBg = ImageIO.read(myPanel.class.getResource("start_screen.png"));
			}
			catch(Exception ex) {
				System.out.println("Background Image Loading Fail...");
				System.exit(0);
			
			}
	}
	public void paintComponent(Graphics pen) {
		
		printBackgroundImage(pen);
		
		
		
		
		
	}
	myPanel(){
		loadBackgroundImage();
		
	}
}


	
	
}

class myJLabel extends javax.swing.JLabel {

    public myJLabel (String text) {
    	super(text);
    	
    	setOpaque(false);	    	
    	
    }
    
    
    
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 19, 19));
        g2.dispose();
        super.paintComponent(grphcs);
    }
}

class Music {
    Clip clip;
    
    AudioInputStream sound;
    public void setFile(URL url) {
        try {
        	
        	System.out.println(url);
            sound = AudioSystem.getAudioInputStream(url);
            System.out.println(sound);
            clip = AudioSystem.getClip();
            System.out.println(url);
            clip.open(sound);
            System.out.println(url);
        } catch (Exception e) {
        }
    }
    public void play() {
        clip.start();
    }
    public void stop() throws IOException {
        sound.close();
        clip.close();
        clip.stop();
    }
}


