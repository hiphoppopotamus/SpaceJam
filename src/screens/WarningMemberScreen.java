package screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

import main.*;

public class WarningMemberScreen {

	private JFrame frame;
	private GameEnvironment game;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarningMemberScreen window = new WarningMemberScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public WarningMemberScreen(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeWarningMemberScreen(this);
	}

	/**
	 * Create the application.
	 */
	public WarningMemberScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 218, 185));
		frame.setTitle("Crew Members Status Window");
		frame.setBounds(100, 100, 572, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setLocationRelativeTo(null);

		
		JLabel lblHealthStatus = new JLabel("<html><div style='text-align: center;'>Your crew members are all healthy.</div></html>");
		lblHealthStatus.setForeground(new Color(219, 112, 147));
		lblHealthStatus.setFont(new Font("Futura", Font.PLAIN, 15));
		lblHealthStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblHealthStatus.setBounds(19, 22, 532, 84);
		frame.getContentPane().add(lblHealthStatus);
		
		JLabel lblHungerStatus = new JLabel("<html><div style='text-align: center;'>Your crew members are all not hungry, "
										+ "but a little snack never killed anyone!</div></html>");
		lblHungerStatus.setForeground(new Color(219, 112, 147));
		lblHungerStatus.setFont(new Font("Futura", Font.PLAIN, 15));
		lblHungerStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblHungerStatus.setBounds(19, 104, 532, 84);
		frame.getContentPane().add(lblHungerStatus);
		
		JLabel lblTirednessStatus = new JLabel("<html><div style='text-align: center;'>Your crew members are all not tired, "
										+ "but a little sleep does not hurt!</div></html>");
		lblTirednessStatus.setForeground(new Color(219, 112, 147));
		lblTirednessStatus.setFont(new Font("Futura", Font.PLAIN, 15));
		lblTirednessStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblTirednessStatus.setBounds(19, 187, 532, 84);
		frame.getContentPane().add(lblTirednessStatus);
		
		JButton btnOk = new JButton("Okay");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnOk.setBounds(230, 283, 117, 29);
		frame.getContentPane().add(btnOk);

		if (game.getUnhealthyMembers().isEmpty() == false) {
			lblHealthStatus.setText("<html><div style='text-align: center;'>These crew member(s) " + game.getUnhealthyMembers().toString() 
								+ " are at critical health!" + "Please heal the immediately with foodstuffs or medical supplies to prevent death!</div></html>");
		} 
		if (game.getHungryMembers().isEmpty() == false) {
			lblHungerStatus.setText("<html><div style='text-align: center;'>Your crew member(s) " 
								+ game.getHungryMembers().toString() + " are too hungry. "+ "Feed them or they will perish!</div></html>");
		}
		if (game.getTiredMembers().isEmpty() == false) {
			lblTirednessStatus.setText("<html><div style='text-align: center;'>Your crew members " + game.getTiredMembers().toString() 
								+ " are too tired! " + "Make them sleep now or they will endure the eternal sleep!</div></html>");
		}
	
	}
	
	

}
