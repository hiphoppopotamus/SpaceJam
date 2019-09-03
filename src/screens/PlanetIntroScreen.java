package screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.GameEnvironment;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;

public class PlanetIntroScreen {

	private GameEnvironment game;
	private JFrame frame = new JFrame();
	private JLabel lblWelcome = new JLabel();
	private JLabel lblPlanetExposition = new JLabel();
	private JLabel lblPlanetInfo = new JLabel();
	private JButton btnNext = new JButton();
	private JPanel panelBackground = new JPanel();
	private JLabel lblImg = new JLabel();

	/**
	 * Launch the application.
	 */
	
	public void setPlanetInfo() {
		if (game.getPlanetCounter() == 0) {
			lblPlanetInfo.setText("<html>Wipe and cleanse the planet of its resources and get home!</html>");
		} else {
			lblPlanetInfo.setText("<html><div style='text-align: center;'>Cleanse and ransack " + game.getCurrentPlanet().getName() + " of its resources to obtain them! "
								+ "<br>Resources may include foodstuffs, medical supplies, money, or even transporter pieces to get home."
								+ "<br>Obtaining resources is considered an action, so be mindful of which crew member you choose"
								+ " to ransack a planet.</div></html>");
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanetIntroScreen window = new PlanetIntroScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public PlanetIntroScreen(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closePlanetIntroScreen(this);
	}

	/**
	 * Create the application.
	 */
	public PlanetIntroScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setTitle(game.getCurrentPlanet().getName() + " Introduction");
		frame.setBounds(100, 100, 608, 403);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		lblWelcome.setForeground(new Color(255, 255, 255));
		lblWelcome.setText("WELCOME TO " + game.getCurrentPlanet().getName().toUpperCase());
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Phosphate", Font.PLAIN, 26));
		lblWelcome.setBounds(6, 16, 596, 42);
		frame.getContentPane().add(lblWelcome);
		lblPlanetExposition.setForeground(new Color(255, 255, 255));
		
		lblPlanetExposition.setText("<html><div style='text-align: center;'>Your spaceship is approaching " + game.getCurrentPlanet().getName()
								+ "<br> with " + game.getCrewTransporterPieces() + " transporter pieces.</div></html>");
		lblPlanetExposition.setFont(new Font("FUTURA", Font.PLAIN, 17));
		lblPlanetExposition.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanetExposition.setBounds(20, 80, 563, 66);
		frame.getContentPane().add(lblPlanetExposition);
		
		setPlanetInfo();
		lblPlanetInfo.setForeground(new Color(255, 255, 255));
		lblPlanetInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanetInfo.setFont(new Font("Futura", Font.PLAIN, 17));
		lblPlanetInfo.setBounds(36, 126, 535, 168);
		frame.getContentPane().add(lblPlanetInfo);
		
		btnNext.setText("Explore " + game.getCurrentPlanet().getName());
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnNext.setBounds(154, 314, 297, 50);
		frame.getContentPane().add(btnNext);
		
		panelBackground.setBackground(new Color(255, 153, 102, 150));
		panelBackground.setBounds(20, 70, 567, 226);
		frame.getContentPane().add(panelBackground);
		
		lblImg.setIcon(new ImageIcon(PlanetIntroScreen.class.getResource("/img/rsz_11elias-stern-leviathan-01-artstation.jpg")));
		lblImg.setBounds(0, -96, 614, 471);
		frame.getContentPane().add(lblImg);
		
		
		
		
		
	}
}
