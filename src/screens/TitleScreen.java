package screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.SwingConstants;

import main.*;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class TitleScreen {

	private GameEnvironment game;
	private GraphicsEnvironment gameEnv;
	private JFrame frame = new JFrame();
	private JLabel lblGametitle = new JLabel("SPACE JAM");
	private JButton btnEnterSpaceship = new JButton("Enter Spaceship");
	private JLabel lblImg = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TitleScreen window = new TitleScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public TitleScreen(GameEnvironment incomingGame) {
		
		
		gameEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			URL fontPath = TitleScreen.class.getResource("/font/Futura-Bold-03.ttf");
			gameEnv.registerFont(Font.createFont(Font.TRUETYPE_FONT, fontPath.openStream()));
			
			fontPath = TitleScreen.class.getResource("/font/Futura-Medium-01.ttf");
			gameEnv.registerFont(Font.createFont(Font.TRUETYPE_FONT, fontPath.openStream()));
			
			fontPath = TitleScreen.class.getResource("/font/futur.ttf");
			gameEnv.registerFont(Font.createFont(Font.TRUETYPE_FONT, fontPath.openStream()));
			
			fontPath = TitleScreen.class.getResource("/font/Phosphate-Inline-01.ttf");
			gameEnv.registerFont(Font.createFont(Font.TRUETYPE_FONT, fontPath.openStream()));
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeTitleScreen(this);
	}
	
	

	/**
	 * Create the application.
	 */
	public TitleScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setTitle("Title Window");
		frame.setBounds(100, 100, 535, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setLocationRelativeTo(null);

		
		lblGametitle.setForeground(new Color(255, 240, 245));
		lblGametitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblGametitle.setFont(new Font("Phosphate", Font.PLAIN, 79));
		lblGametitle.setBounds(51, 37, 437, 70);
		frame.getContentPane().add(lblGametitle);
		
		btnEnterSpaceship.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnEnterSpaceship.setBounds(19, 356, 496, 45);
		frame.getContentPane().add(btnEnterSpaceship);
		
		lblImg.setIcon(new ImageIcon(TitleScreen.class.getResource("/img/rsz_11astro.jpg")));
		lblImg.setBounds(0, 0, 535, 415);
		frame.getContentPane().add(lblImg);
		
	}
}
