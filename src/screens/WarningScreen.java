package screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import main.*;

public class WarningScreen {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarningScreen window = new WarningScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public WarningScreen(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeWarningScreen(this);
	}
	
	/**
	 * Create the application.
	 */
	public WarningScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 248, 220));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setLocationRelativeTo(null);
		
		JLabel lblWarning = new JLabel("<html><div style='text-align: center;'>TODAY IS THE DAY YOU DIE UNLESS YOU FIND ALL YOUR TRANSPORTER PIECES!"
							+ " QUICKLY SEARCH FOR THE REMAINING PIECES OR ONE OF YOUR MENTALLY DERANGED CREW MEMBERS" 
							+ " WILL HAVE A SICKENING MEAL!</div></html>");
		lblWarning.setForeground(new Color(255, 255, 153));
		lblWarning.setFont(new Font("Futura", Font.PLAIN, 19));
		lblWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarning.setBounds(31, 17, 384, 201);
		frame.getContentPane().add(lblWarning);
		
		if (game.getCurrentDay() == (game.getNumberOfDays() - 1)) {
			lblWarning.setText("<html><div style='text-align: center;'>TODAY IS THE LAST DAY BEFORE THE " + game.getSpaceshipName().toUpperCase() + " MALFUNCTIONS."
							+ " YOU ARE ONLY " + (game.getNumberOfPieces() - game.getCrewTransporterPieces()) + " SHORT ON FINDING ALL YOUR TRANSPORTER PIECES."
							+ " QUICKLY SEARCH FOR THE REMAINING PIECES OR RISK WITHERING IN THE VAST, VOID OF SPACE FOREVER!</div></html>");
		} else if (game.getCurrentDay() == game.getNumberOfDays()) {
			lblWarning.setText("<html><div style='text-align: center;'>TODAY IS THE DAY YOU DIE UNLESS YOU FIND ALL YOUR TRANSPORTER PIECES!"
							+ " QUICKLY SEARCH FOR THE REMAINING PIECES OR ONE OF YOUR MENTALLY DERANGED CREW MEMBERS" 
							+ " WILL HAVE A SICKENING MEAL!</div></html>");
		}
		
		JButton btnOk = new JButton("Okay");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnOk.setBounds(164, 218, 117, 38);
		frame.getContentPane().add(btnOk);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(WarningScreen.class.getResource("/img/rsz_1starsinthesky.jpg")));
		lblImg.setBounds(0, 0, 450, 272);
		frame.getContentPane().add(lblImg);
		
	}
}
