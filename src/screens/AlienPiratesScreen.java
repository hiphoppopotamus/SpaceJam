package screens;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.GameEnvironment;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AlienPiratesScreen {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlienPiratesScreen window = new AlienPiratesScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AlienPiratesScreen(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeAlienPiratesScreen(this);
	}
	

	/**
	 * Create the application.
	 */
	public AlienPiratesScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(32, 178, 140));
		frame.setBounds(100, 100, 555, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		
		JLabel lblAlien = new JLabel("<htmL><div style='text-align: center;'>As your crew members were fast asleep "
							+ "and waiting for tomorrow to arrive, those rat bastard alien pirates broke "
							+ "into your spaceship and stole some of your items!</div></html>");
		lblAlien.setForeground(new Color(255, 215, 0));
		lblAlien.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlien.setFont(new Font("Futura", Font.PLAIN, 17));
		lblAlien.setBounds(15, -2, 303, 331);
		frame.getContentPane().add(lblAlien);
	
		if (game.isTerminatorPresent() == true) {
			lblAlien.setText("<htmL><div style='text-align: center;'>As your crew members were fast asleep and waiting "
							+ "for tomorrow to arrive, those rat bastard alien pirates broke into your spaceship. "
							+ "<br><br>Fortunately, " + game.getTerminator() 
							+ " is a Terminator and the Terminator managed to slaughter those aliens within no time!"
							+ "<br><br>Unfortunately, " + game.getTerminator() + " suffered 10% damage during the attack.</div></html>");
		}
		
		JPanel panelStolen = new JPanel();
		panelStolen.setBackground(new Color(255, 250, 240, 100));
		panelStolen.setBounds(330, 67, 197, 162);
		frame.getContentPane().add(panelStolen);
		panelStolen.setLayout(null);
		
		JLabel lblStolen = new JLabel("Items Stolen:");
		lblStolen.setForeground(new Color(255, 215, 0));
		lblStolen.setFont(new Font("Futura", Font.BOLD, 22));
		lblStolen.setHorizontalAlignment(SwingConstants.CENTER);
		lblStolen.setBounds(6, 6, 185, 29);
		panelStolen.add(lblStolen);
		
		JLabel lblFood = new JLabel();
		lblFood.setForeground(new Color(255, 215, 0));
		lblFood.setFont(new Font("Futura", Font.BOLD, 14));
		lblFood.setHorizontalAlignment(SwingConstants.CENTER);
		lblFood.setBounds(6, 45, 185, 38);
		panelStolen.add(lblFood);
		
		if (game.getStolenFoodItem() != null) {
			lblFood.setText("<html><div style='text-align: center;'>Foodstuff: "
						+ "<br>" + game.getStolenFoodItem().getName() + "</div></html>");
		} else {
			lblFood.setText("Foodstuff: None");
		}
		
		JLabel lblMedical = new JLabel();
		lblMedical.setForeground(new Color(255, 215, 0));
		lblMedical.setFont(new Font("Futura", Font.BOLD, 14));
		lblMedical.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedical.setBounds(6, 88, 185, 38);
		panelStolen.add(lblMedical);
		
		if (game.getStolenMedicalItem() != null) {
			lblMedical.setText("<html><div style='text-align: center;'>Medical Supply: "
						+ "<br>" + game.getStolenMedicalItem().getName() + "</div></html>");
		} else {
			lblMedical.setText("Medical Supply: None");
		}
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnOk.setBounds(408, 300, 117, 29);
		frame.getContentPane().add(btnOk);
	}
}
