package screens;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import main.*;

public class SpaceshipScreen {

	private JFrame frame;
	private GameEnvironment game;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpaceshipScreen window = new SpaceshipScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SpaceshipScreen(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeSpaceshipScreen(this);
	}
	

	/**
	 * Create the application.
	 */
	public SpaceshipScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle(game.getSpaceshipName() + " Window");
		frame.setBounds(100, 100, 788, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		
		JLabel lblSpaceship = new JLabel("THE " + game.getSpaceshipName().toUpperCase());
		lblSpaceship.setForeground(new Color(255, 99, 71));
		lblSpaceship.setFont(new Font("Phosphate", Font.PLAIN, 27));
		lblSpaceship.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpaceship.setBounds(12, 15, 776, 33);
		frame.getContentPane().add(lblSpaceship);
		
		JLabel lblCrew = new JLabel("CREW: " + game.getCrewName().toUpperCase());
		lblCrew.setForeground(new Color(255, 215, 0));
		lblCrew.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrew.setFont(new Font("Futura", Font.BOLD, 18));
		lblCrew.setBounds(16, 65, 342, 33);
		frame.getContentPane().add(lblCrew);
		
		JLabel lblPieces = new JLabel("TRANSPORTER PIECES: " + game.getCrewTransporterPieces() + "/" + game.getNumberOfPieces());
		lblPieces.setForeground(new Color(255, 215, 0));
		lblPieces.setHorizontalAlignment(SwingConstants.CENTER);
		lblPieces.setFont(new Font("Futura", Font.BOLD, 15));
		lblPieces.setBounds(16, 227, 342, 20);
		frame.getContentPane().add(lblPieces);
		
		JLabel lblNameType = new JLabel("#1 " + game.getCrewMembers().get(0).getName().toUpperCase()
				+ ", THE " + game.getCrewMembers().get(0).getType().toUpperCase());
		lblNameType.setForeground(new Color(255, 215, 0));
		lblNameType.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameType.setFont(new Font("Futura", Font.BOLD, 18));
		lblNameType.setBounds(377, 70, 392, 33);
		frame.getContentPane().add(lblNameType);
		
		JLabel lblHealth = new JLabel("Health: " + game.getCrewMembers().get(0).getHealth() + "%");
		lblHealth.setForeground(new Color(255, 215, 0));
		lblHealth.setHorizontalAlignment(SwingConstants.CENTER);
		lblHealth.setFont(new Font("Futura", Font.PLAIN, 18));
		lblHealth.setBounds(389, 115, 170, 33);
		frame.getContentPane().add(lblHealth);
		
		JLabel lblHunger = new JLabel("Hunger: " + game.getCrewMembers().get(0).getHunger() + "%");
		lblHunger.setForeground(new Color(255, 215, 0));
		lblHunger.setHorizontalAlignment(SwingConstants.CENTER);
		lblHunger.setFont(new Font("Futura", Font.PLAIN, 18));
		lblHunger.setBounds(389, 151, 170, 33);
		frame.getContentPane().add(lblHunger);
		
		JLabel lblTiredness = new JLabel("Tiredness: " + game.getCrewMembers().get(0).getTiredness() + "%");
		lblTiredness.setForeground(new Color(255, 215, 0));
		lblTiredness.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiredness.setFont(new Font("Futura", Font.PLAIN, 18));
		lblTiredness.setBounds(389, 187, 170, 33);
		frame.getContentPane().add(lblTiredness);
		
		JLabel lblInfected = new JLabel("Infected: " + game.getCrewMembers().get(0).isInfected());
		lblInfected.setForeground(new Color(255, 215, 0));
		lblInfected.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfected.setFont(new Font("Futura", Font.PLAIN, 18));
		lblInfected.setBounds(556, 115, 189, 33);
		frame.getContentPane().add(lblInfected);
		
		JLabel lblActions = new JLabel("Actions: " + (2 - game.getCrewMembers().get(0).getActions()) + " Remaining");
		lblActions.setForeground(new Color(255, 215, 0));
		lblActions.setHorizontalAlignment(SwingConstants.CENTER);
		lblActions.setFont(new Font("Futura", Font.PLAIN, 18));
		lblActions.setBounds(556, 151, 189, 33);
		frame.getContentPane().add(lblActions);
		
		JLabel lblAlive = new JLabel("Status: " + game.getCrewMembers().get(0).getStatus());
		lblAlive.setForeground(new Color(255, 215, 0));
		lblAlive.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlive.setFont(new Font("Futura", Font.PLAIN, 18));
		lblAlive.setBounds(556, 187, 189, 33);
		frame.getContentPane().add(lblAlive);
		
		JLabel lblSleepInfo = new JLabel("<html><div style='text-align: center;'>Sleeping lowers tiredness by 12% "
							+ "but maximises their actions up until the next day.</div></html>");
		lblSleepInfo.setForeground(new Color(255, 215, 0));
		lblSleepInfo.setFont(new Font("Futura", Font.PLAIN, 13));
		lblSleepInfo.setBounds(398, 210, 197, 91);
		frame.getContentPane().add(lblSleepInfo);

		
		
		
		
		
		JLabel lblSpaceshipStatus = new JLabel();
		lblSpaceshipStatus.setFont(new Font("Futura", Font.PLAIN, 13));
		lblSpaceshipStatus.setForeground(new Color(255, 215, 0));
		lblSpaceshipStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpaceshipStatus.setBounds(34, 317, 324, 91);
		frame.getContentPane().add(lblSpaceshipStatus);
		if (game.getSpaceshipHealth() > 50) {
			lblSpaceshipStatus.setText("<html><div style='text-align: center;'>The " + game.getSpaceshipName() 
										+  " is functioning normally.</div></html>");
		} else if (game.getSpaceshipHealth() >= 21 && game.getSpaceshipHealth() <= 50) {
			lblSpaceshipStatus.setText("<html><div style='text-align: center;'>The " + game.getSpaceshipName() 
										+  " is running on fumes! "
										+ "Please repair your spaceship or risk roasting everybody on the ship!</div></html>");
		} else {
			lblSpaceshipStatus.setText("<html><div style='text-align: center;'>The " + game.getSpaceshipName() 
										+  " is on fire! " + "Your flaming hot and crispy crew members are in pain! "
										+ "<br>Please repair your spaceship or the blood of your crew will be on your hands!"
										+ "</div></html>");
		}	
		
		
		JLabel lblMemberFix = new JLabel("<html><div style='text-align: center;'>" + game.getCrewMembers().get(0).getName() 
										+ " has a shield repair rate of " + game.getCrewMembers().get(0).getRepairRate() + "%."
										+ "<br>Press 'Repair Shield' to repair shield with " + game.getCrewMembers().get(0).getName() 
										+ ".</div></html>");
		lblMemberFix.setFont(new Font("Futura", Font.PLAIN, 13));
		lblMemberFix.setForeground(new Color(255, 215, 0));
		lblMemberFix.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemberFix.setBounds(34, 404, 324, 48);
		frame.getContentPane().add(lblMemberFix);
		
		JLabel lblActionInstruct = new JLabel("<html><div style='text-align: center;'>Tip: Fixing the shield requires at least 1 action remaining. "
											+ "Builders are more effective in repairing compared to normies.</div></html>");
		lblActionInstruct.setFont(new Font("Futura", Font.PLAIN, 13));
		lblActionInstruct.setHorizontalAlignment(SwingConstants.CENTER);
		lblActionInstruct.setForeground(new Color(255, 215, 0));
		lblActionInstruct.setBounds(34, 454, 324, 62);
		frame.getContentPane().add(lblActionInstruct);
		
		JButton btnMember0 = new JButton("Empty");
		btnMember0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnMember0.getText() != "Empty") {
					lblNameType.setText("#1 " + game.getCrewMembers().get(0).getName().toUpperCase()
										+ ", THE " + game.getCrewMembers().get(0).getType().toUpperCase());
					lblHealth.setText("Health: " + game.getCrewMembers().get(0).getHealth() + "%");
					lblHunger.setText("Hunger: " + game.getCrewMembers().get(0).getHunger() + "%");
					lblTiredness.setText("Tiredness: " + game.getCrewMembers().get(0).getTiredness() + "%");
					lblInfected.setText("Infected: " + game.getCrewMembers().get(0).isInfected());
					lblActions.setText("Actions: " + (2 - game.getCrewMembers().get(0).getActions()) + " Remaining");
					lblAlive.setText("Status: " + game.getCrewMembers().get(0).getStatus());
					lblMemberFix.setText("<html><div style='text-align: center;'>" + game.getCrewMembers().get(0).getName() + " has a shield repair rate of " 
										+ game.getCrewMembers().get(0).getRepairRate() + "%."
										+ "<br>Press 'Repair Shield' to repair shield with " 
										+ game.getCrewMembers().get(0).getName() + ".</div></html>");
					lblSleepInfo.setText("<html><div style='text-align: center;'>Sleeping lowers tiredness by 12% "
							+ "but maximises their actions up until the next day.</div></html>");
				}
			}
		});
		btnMember0.setBounds(16, 104, 169, 58);
		frame.getContentPane().add(btnMember0);
		
		JButton btnMember1 = new JButton("Empty");
		btnMember1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnMember1.getText() != "Empty") {
					lblNameType.setText("#2 " + game.getCrewMembers().get(1).getName().toUpperCase()
										+ ", THE " + game.getCrewMembers().get(1).getType().toUpperCase());
					lblHealth.setText("Health: " + game.getCrewMembers().get(1).getHealth() + "%");
					lblHunger.setText("Hunger: " + game.getCrewMembers().get(1).getHunger() + "%");
					lblTiredness.setText("Tiredness: " + game.getCrewMembers().get(1).getTiredness() + "%");
					lblInfected.setText("Infected: " + game.getCrewMembers().get(1).isInfected());
					lblActions.setText("Actions: " + (2 - game.getCrewMembers().get(1).getActions()) + " Remaining");
					lblAlive.setText("Status: " + game.getCrewMembers().get(1).getStatus());
					lblMemberFix.setText("<html><div style='text-align: center;'>" + game.getCrewMembers().get(1).getName() + " has a shield repair rate of " 
										+ game.getCrewMembers().get(1).getRepairRate() + "%."
										+ "<br>Press 'Repair Shield' to repair shield with " 
										+ game.getCrewMembers().get(1).getName() + ".</div></html>");
					lblSleepInfo.setText("<html><div style='text-align: center;'>Sleeping lowers tiredness by 12% "
							+ "but maximises their actions up until the next day.</div></html>");
				}
			}
		});
		btnMember1.setBounds(189, 104, 169, 58);
		frame.getContentPane().add(btnMember1);
		
		JButton btnMember2 = new JButton("Empty");
		btnMember2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnMember2.getText() != "Empty") {
					lblNameType.setText("#3 " + game.getCrewMembers().get(2).getName().toUpperCase()
										+ ", THE " + game.getCrewMembers().get(2).getType().toUpperCase());
					lblHealth.setText("Health: " + game.getCrewMembers().get(2).getHealth() + "%");
					lblHunger.setText("Hunger: " + game.getCrewMembers().get(2).getHunger() + "%");
					lblTiredness.setText("Tiredness: " + game.getCrewMembers().get(2).getTiredness() + "%");
					lblInfected.setText("Infected: " + game.getCrewMembers().get(2).isInfected());
					lblActions.setText("Actions: " + (2 - game.getCrewMembers().get(2).getActions()) + " Remaining");
					lblAlive.setText("Status: " + game.getCrewMembers().get(2).getStatus());
					lblMemberFix.setText("<html><div style='text-align: center;'>" + game.getCrewMembers().get(2).getName() + " has a shield repair rate of " 
										+ game.getCrewMembers().get(2).getRepairRate() + "%."
										+ "<br>Press 'Repair Shield' to repair shield with " 
										+ game.getCrewMembers().get(2).getName() + ".</div></html>");
					lblSleepInfo.setText("<html><div style='text-align: center;'>Sleeping lowers tiredness by 12% "
							+ "but maximises their actions up until the next day.</div></html>");
				}
			}
		});
		btnMember2.setBounds(16, 164, 169, 58);
		frame.getContentPane().add(btnMember2);
		
		JButton btnMember3 = new JButton("Empty");
		btnMember3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnMember3.getText() != "Empty") {
					lblNameType.setText("#4 " + game.getCrewMembers().get(3).getName().toUpperCase()
										+ ", THE " + game.getCrewMembers().get(3).getType().toUpperCase());
					lblHealth.setText("Health: " + game.getCrewMembers().get(3).getHealth() + "%");
					lblHunger.setText("Hunger: " + game.getCrewMembers().get(3).getHunger() + "%");
					lblTiredness.setText("Tiredness: " + game.getCrewMembers().get(3).getTiredness() + "%");
					lblInfected.setText("Infected: " + game.getCrewMembers().get(3).isInfected());
					lblActions.setText("Actions: " + (2 - game.getCrewMembers().get(3).getActions()) + " Remaining");
					lblAlive.setText("Status: " + game.getCrewMembers().get(3).getStatus());
					lblMemberFix.setText("<html><div style='text-align: center;'>" + game.getCrewMembers().get(3).getName() + " has a shield repair rate of " 
										+ game.getCrewMembers().get(3).getRepairRate() + "%."
										+ "<br>Press 'Repair Shield' to repair shield with " 
										+ game.getCrewMembers().get(3).getName() + ".</div></html>");
					lblSleepInfo.setText("<html><div style='text-align: center;'>Sleeping lowers tiredness by 12% "
							+ "but maximises their actions up until the next day.</div></html>");
				}
			}
		});
		btnMember3.setBounds(189, 164, 169, 58);
		frame.getContentPane().add(btnMember3);
		
		for (CrewMember member: game.getCrewMembers()) {
			int index = game.getCrewMembers().indexOf(member);
			switch(index) {
				case 0:
					btnMember0.setText(member.getName());
					break;
				case 1:
					btnMember1.setText(member.getName());
					break;
				case 2:
					btnMember2.setText(member.getName());
					break;
				case 3:
					btnMember3.setText(member.getName());
					break;
			}			
		}
		
		JLabel lblShieldHealth = new JLabel("Shield Health: " + game.getSpaceshipHealth() + "%");
		lblShieldHealth.setHorizontalAlignment(SwingConstants.CENTER);
		lblShieldHealth.setFont(new Font("Futura", Font.PLAIN, 15));
		lblShieldHealth.setForeground(new Color(255, 215, 0));
		lblShieldHealth.setBounds(16, 254, 189, 33);
		frame.getContentPane().add(lblShieldHealth);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue((int) game.getSpaceshipHealth());
		progressBar.setBounds(24, 285, 171, 20);
		frame.getContentPane().add(progressBar);
		
		JButton btnFixShield = new JButton("Repair Shield");
		btnFixShield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String chosenMember = lblNameType.getText();
				int index = (Integer.parseInt(chosenMember.substring(1, 2)) - 1);
				CrewMember member = game.getCrewMembers().get(index);
				if (member.getActions() < 2) {
					game.repairSpaceship(member);
					lblShieldHealth.setText("Shield Health: " + game.getSpaceshipHealth() + "%");
					progressBar.setValue((int) game.getSpaceshipHealth());
					lblMemberFix.setText("<html><div style='text-align: center;'>Spaceship shield succesfully repaired!"
										+ "<br>" + member.getName() + " has " + (2 - member.getActions()) + " left.</div></html>");
					lblActions.setText("Actions: " + (2 - game.getCrewMembers().get(index).getActions()) + " Remaining");
				} else {
					lblMemberFix.setText("<html><div style='text-align: center;'>Choose a member with sufficient actions."
										+ "<br>If all actions are full go to next day to refresh everyone.</div></html>");
					
				}
				
			}
		});
		btnFixShield.setBounds(205, 254, 153, 50);
		frame.getContentPane().add(btnFixShield);
		
		JLabel lblDaysRemaining = new JLabel("Days Until Spaceship Malfunction: " + (game.getNumberOfDays() - game.getCurrentDay()));
		lblDaysRemaining.setForeground(new Color(255, 215, 0));
		lblDaysRemaining.setHorizontalAlignment(SwingConstants.CENTER);
		lblDaysRemaining.setFont(new Font("Futura", Font.PLAIN, 15));
		lblDaysRemaining.setBounds(380, 340, 260, 33);
		frame.getContentPane().add(lblDaysRemaining);
		
		JLabel lblWallet = new JLabel("Wallet: $" + game.getCrewFunds());
		lblWallet.setForeground(new Color(255, 215, 0));
		lblWallet.setHorizontalAlignment(SwingConstants.CENTER);
		lblWallet.setFont(new Font("Futura", Font.PLAIN, 15));
		lblWallet.setBounds(380, 313, 260, 33);
		frame.getContentPane().add(lblWallet);
		
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if (game.getCurrentDay() == game.getNumberOfDays()) {
					finishedWindow();
					game.launchGameOverScreen();
				} else {					
					game.nextDay();
					if (game.isAllDead()) {
						finishedWindow();
						game.launchGameOverScreen();
					} else {
						if (game.isAlien() && (game.getCrewFoodItems().size() != 0 || game.getCrewMedicalItems().size() != 0)) {
							game.setAlien(false);
							game.launchAlienPiratesScreen();
							game.setTerminatorPresent(false);
							game.setStolenFoodItem(null);
							game.setStolenMedicalItem(null);
						}
			
						if (game.getCurrentDay() >= game.getNumberOfDays() - 1) {
							game.launchWarningScreen();
						}
						
						if (game.getUnhealthyMembers().size() != 0 ||
							game.getHungryMembers().size() != 0 ||
							game.getTiredMembers().size() != 0) {
							game.launchWarningMemberScreen();
						}
						
						lblDaysRemaining.setText("Days Until Spaceship Malfunction: " + (game.getNumberOfDays() - game.getCurrentDay()));
						String chosenMember = lblNameType.getText();
						int index = (Integer.parseInt(chosenMember.substring(1, 2)) - 1);
						lblHealth.setText("Health: " + game.getCrewMembers().get(index).getHealth() + "%");
						lblHunger.setText("Hunger: " + game.getCrewMembers().get(index).getHunger() + "%");
						lblTiredness.setText("Tiredness: " + game.getCrewMembers().get(index).getTiredness() + "%");
						lblInfected.setText("Infected: " + game.getCrewMembers().get(index).isInfected());
						lblActions.setText("Actions: " + (2 - game.getCrewMembers().get(index).getActions()) + " Remaining");
						lblAlive.setText("Status: " + game.getCrewMembers().get(index).getStatus());		
						for (CrewMember member: game.getCrewMembers()) {
							if (member.isAlive() == false && game.getDeadMembers().contains(member) == false) {				
								game.addDeadMember(member);
								game.launchCrewMemberDeathScreen(member);
							}
							if (member.isInfected() && game.getInfectedMembers().contains(member) == false) {
								game.addInfectedMember(member);
								game.launchCrewMemberInfectedScreen(member);
							} else if (member.isInfected() == false && game.getInfectedMembers().contains(member)) {
								game.removeInfectedMember(member);
							}
						} 
					}
							
				}
			}
		});
		btnNextDay.setBounds(647, 313, 115, 60);
		frame.getContentPane().add(btnNextDay);
		
		JButton btnInventory = new JButton("View Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchInventoryScreen();
			}
		});
		btnInventory.setBounds(377, 377, 189, 72);
		frame.getContentPane().add(btnInventory);
		
		JButton btnVisitOutpost = new JButton("Visit Outpost");
		btnVisitOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchOutpostScreen();
			}
		});
		btnVisitOutpost.setBounds(573, 377, 189, 72);
		frame.getContentPane().add(btnVisitOutpost);
		
		JButton btnPilot = new JButton("Pilot Spaceship");
		btnPilot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getPlanetCounter() == game.getPlanets().size()) {
					JOptionPane.showMessageDialog(btnPilot, "No more planets to explore!");
				} else {
					finishedWindow();
					game.launchPilotScreen();
				}
			}
		});
		btnPilot.setBounds(377, 454, 189, 77);
		frame.getContentPane().add(btnPilot);
		
		JButton btnFlyHome = new JButton("Fly Home");
		btnFlyHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getCrewTransporterPieces() >= game.getNumberOfPieces() || 
					game.getCurrentDay() == game.getNumberOfDays()) {
					finishedWindow();
					game.launchGameOverScreen();
				} else if (game.getCurrentDay() != game.getNumberOfDays()) {
					JOptionPane.showMessageDialog(btnFlyHome, "You still have " + (game.getNumberOfDays() - game.getCurrentDay()) 
														+ " days left to find " + game.getNumberOfPieces() + " transporter pieces!");
				}
			}
		});
		btnFlyHome.setBounds(573, 454, 189, 77);
		frame.getContentPane().add(btnFlyHome);
		
	
		
	
		JButton btnSleep = new JButton("Sleep");
		btnSleep.setBounds(609, 234, 134, 50);
		frame.getContentPane().add(btnSleep);
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String chosenMember = lblNameType.getText();
				int index = (Integer.parseInt(chosenMember.substring(1, 2)) - 1);
				CrewMember member = game.getCrewMembers().get(index);
				if (member.getActions() < 2) {
					game.sleep(member);
					lblSleepInfo.setText("<html><div style='text-align: center;'>" + member.getName() + " is having a lovely sleep."
										+ "<br>" + member.getName() + " has " + (2 - member.getActions()) + " left.</div></html>");
					lblTiredness.setText("Tiredness: " + member.getTiredness() + "%");
					lblActions.setText("Actions: " + (2 - game.getCrewMembers().get(index).getActions()) + " Remaining");
				} else {
					lblSleepInfo.setText("<html><div style='text-align: center;'>Choose a member with sufficient actions."
										+ "<br>If all actions are full go to next day to refresh everyone.</div></html>");
				}
			}
		});
		
		JPanel panelMember = new JPanel();
		panelMember.setBackground(new Color(0, 0, 0, 90));
		panelMember.setBounds(377, 55, 390, 250);
		frame.getContentPane().add(panelMember);
		
		JPanel panelSpaceship = new JPanel();
		panelSpaceship.setBackground(new Color(0, 0, 0, 90));
		panelSpaceship.setBounds(20, 313, 345, 215);
		frame.getContentPane().add(panelSpaceship);
		
		JLabel lblImg = new JLabel("Img");
		lblImg.setIcon(new ImageIcon(SpaceshipScreen.class.getResource("/img/rsz_alienspacshipstock.png")));
		lblImg.setBounds(0, 0, 788, 544);
		frame.getContentPane().add(lblImg);
		
		
		
	}
}
