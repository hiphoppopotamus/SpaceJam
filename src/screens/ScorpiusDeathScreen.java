package screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import main.*;

public class ScorpiusDeathScreen {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScorpiusDeathScreen window = new ScorpiusDeathScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ScorpiusDeathScreen(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeScorpiusDeathScreen(this);
	}
	

	/**
	 * Create the application.
	 */
	public ScorpiusDeathScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 603, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		
		JLabel lblScorpius = new JLabel();
		lblScorpius.setFont(new Font("Futura", Font.PLAIN, 27));
		lblScorpius.setHorizontalAlignment(SwingConstants.CENTER);
		lblScorpius.setBounds(25, 19, 553, 290);
		frame.getContentPane().add(lblScorpius);
		
		if (game.getCrewTransporterPieces() < game.getNumberOfPieces()) {
			frame.getContentPane().setBackground(new Color(0, 0, 0));
			lblScorpius.setForeground(new Color(165, 42, 42));
			lblScorpius.setText("<html><div style='text-align: center;'>Your spaceship has crashed at Scorpius, <br>killing nobody but your crew members."
							+ "<br>All your crew members died in vain and those "
							+ "stanky rat bastards of Scorpius will reign forever."
							+ "<br><br>Revenge is not worth it without all your transporter pieces!</div></html>");
		} else {
			frame.getContentPane().setBackground(new Color(255, 255, 255));
			lblScorpius.setForeground(new Color(30, 144, 255));
			
			lblScorpius.setText("<html><div style='text-align: center;'>You have succesfully obliterated Scorpius and its dumb faces!"
							+ "<br>Your crew members have all perished as heroes."
							+ "<br><br>Revenge is always worth it with all your transporter pieces!</div></html>");
		}
		
		JButton btnExit = new JButton("Exit Game");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnExit.setBounds(6, 335, 591, 52);
		frame.getContentPane().add(btnExit);
	}

}
