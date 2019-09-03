package screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;

import main.*;

public class ScorpiusStrikesScreen {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScorpiusStrikesScreen window = new ScorpiusStrikesScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ScorpiusStrikesScreen(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeScorpiusStrikesScreen(this);
	}
	

	/**
	 * Create the application.
	 */
	public ScorpiusStrikesScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setTitle("Scorpius Strikes Back!");
		frame.setBounds(100, 100, 639, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		
		JLabel lblStrike = new JLabel("<html><center>Oh no!"
								+ "<br><br>The surviving citizens of Scorpius have bamboozled your ship with a space tank!"
								+ "<br>The blast has caused your " + game.getNumberOfPieces() + " transporter pieces to fall off your spaceship!"
								+ "<br><br>This is bad news since you cannot return home without them!"
								+ "<br><br>You also have " + game.getNumberOfDays() + " days until your spaceship malfunctions!"
								+ " <br>If your spaceship malfunctions, then your crew members will be lost in space FOREVER!"
								+ "<br><br>Your crew must find the transporter pieces, <br>scattered throughout the surrounding planets of Scorpius to get home!"
								+ "<br><br>OR you can crash land your spaceship to Scorpius' parliament building to get revenge!</center></html>");
		lblStrike.setForeground(new Color(255, 255, 255));
		lblStrike.setHorizontalAlignment(SwingConstants.CENTER);
		lblStrike.setFont(new Font("Futura", Font.PLAIN, 14));
		lblStrike.setBounds(27, 58, 587, 312);
		frame.getContentPane().add(lblStrike);
		
		JButton btnDestroy = new JButton("Crash On Scorpius");
		btnDestroy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchScorpiusDeathScreen();
			}
		});
		btnDestroy.setBounds(27, 373, 234, 44);
		frame.getContentPane().add(btnDestroy);
		
		JButton btnFind = new JButton("Find Pieces");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchSpaceshipScreen();
			}
		});
		btnFind.setBounds(367, 373, 236, 44);
		frame.getContentPane().add(btnFind);
		
		JLabel lblScorpiusStrikes = new JLabel("SCORPIUS STRIKES BACK");
		lblScorpiusStrikes.setForeground(new Color(250, 128, 114));
		lblScorpiusStrikes.setHorizontalAlignment(SwingConstants.CENTER);
		lblScorpiusStrikes.setFont(new Font("Phosphate", Font.PLAIN, 26));
		lblScorpiusStrikes.setBounds(6, 16, 627, 33);
		frame.getContentPane().add(lblScorpiusStrikes);
		
		JPanel panelBackground = new JPanel();
		panelBackground.setBackground(new Color(0, 0, 0, 100));
		panelBackground.setBounds(27, 58, 587, 315);
		frame.getContentPane().add(panelBackground);
		
		JLabel lblImg = new JLabel("New label");
		lblImg.setIcon(new ImageIcon(ScorpiusStrikesScreen.class.getResource("/img/rsz_spaceship-spaceship-burning-bright.png")));
		lblImg.setBounds(0, 0, 639, 442);
		frame.getContentPane().add(lblImg);
		
	
//		JLabel lblImg = new JLabel("");
//		lblImg.setIcon(new ImageIcon(ScorpiusStrikesScreen.class.getResource("/img/rsz_spaceship-spaceship-burning-bright.png")));
//		lblImg.setBounds(0, 0, 639, 460);
//		frame.getContentPane().add(lblImg);
//	
		
		
		
	}
}
