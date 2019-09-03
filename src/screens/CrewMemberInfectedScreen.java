package screens;

import java.awt.EventQueue;

import main.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CrewMemberInfectedScreen {

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
					CrewMemberInfectedScreen window = new CrewMemberInfectedScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CrewMemberInfectedScreen(GameEnvironment incomingGame, CrewMember crewMember) {
		game = incomingGame;
		this.crewMember = crewMember;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeCrewMemberInfectedScreen(this);
	}
	
	/**
	 * Create the application.
	 */
	public CrewMemberInfectedScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 204, 102));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JLabel lblInfected = new JLabel("<html><div style='text-align: center;'>" + crewMember + " got got by the space plague"
									+ " and got infected! This means that " + crewMember + "'s health rate "
									+ " increases from 5% to 10%. "
									+ "<br><br>Cure " + crewMember + " with a cure " + " before it is too late!</divr></html>");
		lblInfected.setForeground(new Color(255, 235, 205));
		lblInfected.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfected.setFont(new Font("Futura", Font.PLAIN, 19));
		lblInfected.setBounds(31, 17, 384, 201);
		frame.getContentPane().add(lblInfected);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnOk.setBounds(164, 230, 117, 29);
		frame.getContentPane().add(btnOk);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(CrewMemberInfectedScreen.class.getResource("/img/rsz_8e200922a5b29a5743315772.png")));
		lblImg.setBounds(0, 0, 450, 272);
		frame.getContentPane().add(lblImg);
	
	}
}
