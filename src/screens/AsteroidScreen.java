package screens;

import java.awt.EventQueue;

import main.GameEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AsteroidScreen {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsteroidScreen window = new AsteroidScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AsteroidScreen(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeAsteroidScreen(this);
	}

	/**
	 * Create the application.
	 */
	public AsteroidScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 524, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		
		JLabel lblAsteroid = new JLabel("<html><div style='text-align: center;'>On the way to Planet " + game.getCurrentPlanet().getName()
									+ ", The " + game.getSpaceshipName() + " entered an asteroid belt, resulting "
									+ "in several damages to the spaceship's exterior shields."
									+ "<br>You can only repair your spaceship once you have left the planet " + game.getCurrentPlanet().getName() 
									+ ". <br><br>The " + game.getSpaceshipName() + " is now running at " 
									+ game.getSpaceshipHealth() + "%</div></html>");
		lblAsteroid.setForeground(Color.WHITE);
		lblAsteroid.setFont(new Font("Futura", Font.PLAIN, 19));
		lblAsteroid.setBounds(33, 40, 458, 184);
		frame.getContentPane().add(lblAsteroid);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnOk.setBounds(205, 248, 117, 49);
		frame.getContentPane().add(btnOk);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(AsteroidScreen.class.getResource("/img/rsz_adam-frank-mining-spacechip.jpg")));
		lblImg.setBounds(0, 0, 524, 325);
		frame.getContentPane().add(lblImg);
	}

}
