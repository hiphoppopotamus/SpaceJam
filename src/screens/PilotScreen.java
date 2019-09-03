package screens;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import main.*;

public class PilotScreen {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PilotScreen window = new PilotScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PilotScreen(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closePilotScreen(this);
	}

	/**
	 * Create the application.
	 */
	public PilotScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Pilot Spaceship Window");
		frame.setBounds(100, 100, 667, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setLocationRelativeTo(null);

		
		JLabel lblCockpit = new JLabel("COCKPIT");
		lblCockpit.setFont(new Font("Phosphate", Font.PLAIN, 27));
		lblCockpit.setForeground(new Color(255, 255, 204));
		lblCockpit.setHorizontalAlignment(SwingConstants.CENTER);
		lblCockpit.setBounds(6, 14, 655, 25);
		frame.getContentPane().add(lblCockpit);
	
		JLabel lblPilot1 = new JLabel("Empty");
		lblPilot1.setFont(new Font("Futura", Font.BOLD, 16));
		lblPilot1.setForeground(new Color(255, 250, 240));
		lblPilot1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPilot1.setBounds(78, 71, 227, 59);
		frame.getContentPane().add(lblPilot1);
		
		JButton btnRemove1 = new JButton("Remove");
		btnRemove1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPilot1.setText("Empty");
			}
		});
		btnRemove1.setBounds(143, 150, 99, 41);
		frame.getContentPane().add(btnRemove1);
		
		JLabel lblPilot2 = new JLabel("Empty");
		lblPilot2.setFont(new Font("Futura", Font.BOLD, 16));
		lblPilot2.setForeground(new Color(255, 250, 240));
		lblPilot2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPilot2.setBounds(361, 71, 227, 59);
		frame.getContentPane().add(lblPilot2);
		
		
		JButton btnRemove2 = new JButton("Remove");
		btnRemove2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPilot2.setText("Empty");
			}
		});
		btnRemove2.setBounds(424, 150, 99, 41);
		frame.getContentPane().add(btnRemove2);
		
		JButton btnMember0 = new JButton("Empty");
		btnMember0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnMember0.getText() != "Empty") {
					String chosenMember = btnMember0.getText();
					int index = (Integer.parseInt(chosenMember.substring(40, 41)) - 1);
					CrewMember member = game.getCrewMembers().get(index);
					if (member.getActions() < 2) {
						if (lblPilot1.getText() == "Empty"  && lblPilot2.getText().contains(String.valueOf(index + 1)) == false) {
							lblPilot1.setText("<html><div style='text-align: center;'>#1 " + member.getName() + "<br>The " + member.getType() + "</div></html>");
						} else if (lblPilot2.getText() == "Empty" && lblPilot1.getText().contains(String.valueOf(index + 1)) == false) {
							lblPilot2.setText("<html><div style='text-align: center;'>#1 " + member.getName() + "<br>The " + member.getType() + "</div></html>");
						}
					}
				}
			}
		});
		btnMember0.setBounds(64, 279, 125, 53);
		frame.getContentPane().add(btnMember0);
		
		JButton btnMember1 = new JButton("Empty");
		btnMember1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnMember1.getText() != "Empty") {
					String chosenMember = btnMember1.getText();
					int index = (Integer.parseInt(chosenMember.substring(40, 41)) - 1);
					CrewMember member = game.getCrewMembers().get(index);
					if (member.getActions() < 2) {
						if (lblPilot1.getText() == "Empty"  && lblPilot2.getText().contains(String.valueOf(index + 1)) == false) {
							lblPilot1.setText("<html><div style='text-align: center;'>#2 " + member.getName() + "<br>The " + member.getType() + "</div></html>");
						} else if (lblPilot2.getText() == "Empty" && lblPilot1.getText().contains(String.valueOf(index + 1)) == false) {
							lblPilot2.setText("<html><div style='text-align: center;'>#2 " + member.getName() + "<br>The " + member.getType() + "</div></html>");
						}
					}
				}
			}
		});
		btnMember1.setBounds(196, 279, 125, 53);
		frame.getContentPane().add(btnMember1);
		
		JButton btnMember2 = new JButton("Empty");
		btnMember2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnMember2.getText() != "Empty") {
					String chosenMember = btnMember2.getText();
					int index = (Integer.parseInt(chosenMember.substring(40, 41)) - 1);
					CrewMember member = game.getCrewMembers().get(index);
					if (member.getActions() < 2) {
						if (lblPilot1.getText() == "Empty"  && lblPilot2.getText().contains(String.valueOf(index + 1)) == false) {
							lblPilot1.setText("<html><div style='text-align: center;'>#3 " + member.getName() + "<br>The " + member.getType() + "</div></html>");
						} else if (lblPilot2.getText() == "Empty" && lblPilot1.getText().contains(String.valueOf(index + 1)) == false) {
							lblPilot2.setText("<html><div style='text-align: center;'>#3 " + member.getName() + "<br>The " + member.getType() + "</div></html>");
						}
					}
				}
			}
		});
		btnMember2.setBounds(346, 279, 125, 53);
		frame.getContentPane().add(btnMember2);
		
		JButton btnMember3 = new JButton("Empty");
		btnMember3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnMember3.getText() != "Empty") {
					String chosenMember = btnMember3.getText();
					int index = (Integer.parseInt(chosenMember.substring(40, 41)) - 1);
					CrewMember member = game.getCrewMembers().get(index);
					if (member.getActions() < 2) {
						if (lblPilot1.getText() == "Empty"  && lblPilot2.getText().contains(String.valueOf(index + 1)) == false) {
							lblPilot1.setText("<html><div style='text-align: center;'>#4 " + member.getName() + "<br>The " + member.getType() + "</div></html>");
						} else if (lblPilot2.getText() == "Empty" && lblPilot1.getText().contains(String.valueOf(index + 1)) == false) {
							lblPilot2.setText("<html><div style='text-align: center;'>#4 " + member.getName() + "<br>The " + member.getType() + "</div></html>");
						}
					} 
				}
			}
		});
		btnMember3.setBounds(478, 279, 125, 53);
		frame.getContentPane().add(btnMember3);
		
		for (CrewMember member: game.getCrewMembers()) {
			int index = game.getCrewMembers().indexOf(member);
			switch(index) {
				case 0:
					btnMember0.setText("<html><div style='text-align: center;'>#1 " + member.getName() 
									+ "<br>" + (2 - member.getActions()) + " actions left</div></html>");
					break;
				case 1:
					btnMember1.setText("<html><div style='text-align: center;'>#2 " + member.getName() 
									+ "<br>" + (2 - member.getActions()) + " actions left</div></html>");
					break;
				case 2:
					btnMember2.setText("<html><div style='text-align: center;'>#3 " + member.getName() 
									+ "<br>" + (2 - member.getActions()) + " actions left</div></html>");
					break;
				case 3:
					btnMember3.setText("<html><div style='text-align: center;'>#4 " + member.getName() 
									+ "<br>" + (2 - member.getActions()) + " actions left</div></html>");
					break;	
			}						
		}
		
		JPanel panelAction = new JPanel();
		panelAction.setBackground(new Color(0, 0, 0, 100));
		panelAction.setBounds(64, 211, 539, 59);
		frame.getContentPane().add(panelAction);
		panelAction.setLayout(null);
		
		JLabel lblAction = new JLabel("<html><div style='text-align: center;'>Choose two crew members to pilot the spaceship."
									+ "<br>Each member must have at least 1 action remaining to fly the ship.</div></html>");
		lblAction.setBackground(new Color(255, 255, 255));
		lblAction.setFont(new Font("Futura", Font.BOLD, 13));
		lblAction.setForeground(new Color(255, 250, 250));
		lblAction.setHorizontalAlignment(SwingConstants.CENTER);
		lblAction.setBounds(0, 5, 533, 48);
		panelAction.add(lblAction);		
		
		JButton btnBack = new JButton("Return to Spaceship");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchSpaceshipScreen();
			}
		});
		btnBack.setBounds(12, 343, 187, 40);
		frame.getContentPane().add(btnBack);
		
		JButton btnFly = new JButton("Fly to Planet");
		btnFly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblPilot1.getText() != "Empty" && lblPilot2.getText() != "Empty") {
					Planet planet = game.getPlanets().get(game.getPlanetCounter());
					int memberIndex1 = (Integer.parseInt(lblPilot1.getText().substring(40, 41)) - 1);
					int memberIndex2 = (Integer.parseInt(lblPilot2.getText().substring(40, 41)) - 1);
					CrewMember member1 = game.getCrewMembers().get(memberIndex1);
					CrewMember member2 = game.getCrewMembers().get(memberIndex2);
					Spaceship spaceship = game.getSpaceship();
					game.flyToPlanet(planet, member1, member2, spaceship);
					if (game.isExploded()) {
						finishedWindow();
						game.launchGameOverScreen();
					} else {
						if (game.isAsteroid()) {
							game.setAsteroid(false);
							finishedWindow();
							game.launchAsteroidScreen();
						} else {
							finishedWindow();
							game.launchPlanetIntroScreen();
						}
					}
				}
				
				
			}
		});
		btnFly.setBounds(468, 343, 187, 40);
		frame.getContentPane().add(btnFly);

		JPanel panelPilot1 = new JPanel();
		panelPilot1.setBackground(new Color(51, 153, 204, 20));
		panelPilot1.setBounds(64, 50, 257, 149);
		frame.getContentPane().add(panelPilot1);
		panelPilot1.setLayout(null);
		panelPilot1.setOpaque(true);
		
		JPanel panelPilot2 = new JPanel();
		panelPilot2.setBackground(new Color(51, 153, 204, 20));
		panelPilot2.setBounds(346, 51, 257, 148);
		frame.getContentPane().add(panelPilot2);
		panelPilot2.setLayout(null);
		frame.getContentPane().setLayout(null);

		JLabel lblCockpitImg = new JLabel("");
		lblCockpitImg.setIcon(new ImageIcon(PilotScreen.class.getResource("/img/rsz_2rsz_246145.jpg")));
		lblCockpitImg.setBounds(0, 0, 667, 401);
		frame.getContentPane().add(lblCockpitImg);
		
		
		
		
		
		
		
		
	}
}
