package screens;

import java.awt.EventQueue;

import main.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrewMemberDeathScreen {

	private JFrame frame;
	private GameEnvironment game;
	private CrewMember crewMember;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewMemberDeathScreen window = new CrewMemberDeathScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CrewMemberDeathScreen(GameEnvironment incomingGame, CrewMember crewMember) {
		game = incomingGame;
		this.crewMember = crewMember;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeCrewMemberDeathScreen(this);
	}

	/**
	 * Create the application.
	 */
	public CrewMemberDeathScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 624, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JLabel lblDied = new JLabel("<html><div style='text-align: center;'>RIP"
								+ "<br>" + crewMember.getName() + ","
								+ "<br>The " + crewMember.getType() + ".</div></html>");
		lblDied.setHorizontalAlignment(SwingConstants.CENTER);
		lblDied.setForeground(new Color(102, 0, 0));
		lblDied.setFont(new Font("URW Gothic L", Font.BOLD, 20));
		lblDied.setBounds(60, 145, 296, 109);
		frame.getContentPane().add(lblDied);
		
		JButton btnSpaceship = new JButton("OK");
		btnSpaceship.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnSpaceship.setBounds(181, 257, 57, 41);
		frame.getContentPane().add(btnSpaceship);
		
		JLabel lblDeath = new JLabel("");
		lblDeath.setIcon(new ImageIcon(CrewMemberDeathScreen.class.getResource("/img/rsz_1tumblr_nt726tfrvj1ucd563o1_500.jpg")));
		lblDeath.setBounds(408, 6, 207, 299);
		frame.getContentPane().add(lblDeath);
		
		JLabel lblimg = new JLabel("");
		lblimg.setIcon(new ImageIcon(CrewMemberDeathScreen.class.getResource("/img/rsz_1screen_shot_2019-05-19_at_54104_pm.png")));
		lblimg.setBounds(0, 0, 623, 323);
		frame.getContentPane().add(lblimg);
		
		
	}

}
