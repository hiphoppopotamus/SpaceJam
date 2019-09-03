package screens;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.GameEnvironment;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ImageIcon;

import main.*;

public class PlanetScreen {

	private GameEnvironment game;
	private JFrame frame = new JFrame();
	private JLabel lblPlanetName = new JLabel();
	private JLabel lblCrew = new JLabel();
	private JLabel lblSpaceship = new JLabel();
	private JLabel lblChooseMember = new JLabel("CHOOSE A MEMBER:");
	private JLabel lblChosen = new JLabel("#1");
	private JLabel lblDay = new JLabel();
	private JLabel lblTransporterPieces = new JLabel();
	private JButton btnMember0 = new JButton("Empty");
	private JButton btnMember1 = new JButton("Empty");
	private JButton btnMember2 = new JButton("Empty");
	private JButton btnMember3 = new JButton("Empty");
	private JLabel lblActionResult = new JLabel();
	private JButton btnScan = new JButton();
	private JButton btnRansack = new JButton();
	private JButton btnNextDay = new JButton("Go To Next Day");
	private JButton btnLeave = new JButton();
	private JPanel panelPlanet = new JPanel();
	private JLabel lblImg = new JLabel();

	/**
	 * Launch the application.
	 */
	
	public void setChosenMember(JButton btnMember, int index) {
		if (btnMember.getText() == "Empty") {
		lblChosen.setText("");
	} else {
		switch(index) {
			case(0):
				lblChosen.setText("#1");
				break;
			case(1):
				lblChosen.setText("#2");
				break;
			case(2):
				lblChosen.setText("#3");
				break;
			case(3):
				lblChosen.setText("#4");
				break;
			}
		}
	}
	
	public void setButtons() {
		for (CrewMember member: game.getCrewMembers()) {
			int index = game.getCrewMembers().indexOf(member);
			switch(index) {
				case 0:
					btnMember0.setText("<html><div style='text-align: center;'>" + member.getName() 
					+ "<br>" + (2 - member.getActions() + " actions remaining</div></html>"));
					break;
				case 1:
					btnMember1.setText("<html><div style='text-align: center;'>" + member.getName() 
					+ "<br>" + (2 - member.getActions() + " actions remaining</div></html>"));
					break;
				case 2:
					btnMember2.setText("<html><div style='text-align: center;'>" + member.getName() 
					+ "<br>" + (2 - member.getActions() + " actions remaining</div></html>"));
					break;
				case 3:
					btnMember3.setText("<html><div style='text-align: center;'>" + member.getName() 
					+ "<br>" + (2 - member.getActions() + " actions remaining</div></html>"));
					break;
			}			
		}
	}
	
	public void ransackPlanet() {
		if (lblChosen.getText() != "" && game.getCurrentPlanet().isCleansed() == false) {
			String chosenMember = lblChosen.getText();
			int index = (Integer.parseInt(chosenMember.substring(1, 2)) - 1);
			CrewMember member = game.getCrewMembers().get(index);
			if (member.getActions() < 2) {
				game.getPlanetItems(member);
				if (game.getPlanetCounter() == 0) {
					lblActionResult.setText("<html><div style='text-align: center;'>You have decimated " + game.getCurrentPlanet().getName() + ", "
										+ "wiping the planet of its resources."
										+ "<br>All that's left is dust and carcasses."
										+ "<br>Time to get home!"
										+ "<br><br>" + member.getName() + " has " + (2 - member.getActions()) + " action remaining.</div></html>");
				} else {
					lblActionResult.setText("<html><div style='text-align: center;'>You have decimated " + game.getCurrentPlanet().getName() + ", "
										+ "<br>wiping the planet of its resources."
										+ "<br>All that's left is dust and carcasses."
										+ "<br>Time to return to your spaceship!</div></html>");	
					}
				lblTransporterPieces.setText("Transporter Pieces: " + game.getCrewTransporterPieces() + "/" + game.getNumberOfPieces());
				setButtons();								
			} else {
				lblActionResult.setText("<html><div style='text-align: center;'>" + member.getName() 
									+ " has no remaining actions and cannot scour " + game.getCurrentPlanet().getName()
									+ ". Choose a different member with at least 1 action remaining.</div></html>");
			}
		} else if (game.getCurrentPlanet().isCleansed() == true) {
			lblActionResult.setText("<html><div style='text-align: center;'>You've already decimated " + game.getCurrentPlanet().getName() + "!"
								+ "<br>Now leave them be!</div></html>");
			
		} else { 
			lblActionResult.setText("Choose a crew member.");
		}
	}
	
	public void nextDayEvents() {
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
	}
	
	public void setCrewMembersStatus() {
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
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanetScreen window = new PlanetScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public PlanetScreen(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closePlanetScreen(this);
	}
	
	
	/**
	 * Create the application.
	 */
	public PlanetScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setButtons();
		frame.setTitle(game.getCurrentPlanet().getName() + " Window");
		frame.setBounds(100, 100, 747, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		
		lblPlanetName.setText(game.getCurrentPlanet().getName().toUpperCase());
		lblPlanetName.setFont(new Font("Phosphate", Font.PLAIN, 26));
		lblPlanetName.setForeground(new Color(255, 255, 255));
		lblPlanetName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanetName.setBounds(6, 16, 735, 33);
		frame.getContentPane().add(lblPlanetName);
		
		lblCrew.setText("CREW: " + game.getCrewName().toUpperCase());
		lblCrew.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrew.setForeground(new Color(255, 255, 255));
		lblCrew.setFont(new Font("Futura", Font.BOLD, 18));
		lblCrew.setBounds(25, 57, 340, 33);
		frame.getContentPane().add(lblCrew);
		
		lblSpaceship.setText("SPACESHIP: " + game.getSpaceshipName().toUpperCase());
		lblSpaceship.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpaceship.setForeground(new Color(255, 255, 255));
		lblSpaceship.setFont(new Font("Futura", Font.BOLD, 18));
		lblSpaceship.setBounds(25, 97, 340, 33);
		frame.getContentPane().add(lblSpaceship);
		
		lblChooseMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseMember.setForeground(new Color(255, 255, 255));
		lblChooseMember.setFont(new Font("Futura", Font.BOLD, 18));
		lblChooseMember.setBounds(32, 137, 291, 33);
		frame.getContentPane().add(lblChooseMember);
		
		lblChosen.setForeground(Color.WHITE);
		lblChosen.setFont(new Font("Futura", Font.BOLD, 18));
		lblChosen.setBounds(288, 137, 30, 33);
		frame.getContentPane().add(lblChosen);
		
		lblDay.setText("Day: " + game.getCurrentDay() + "/" + game.getNumberOfDays());
		lblDay.setForeground(new Color(255, 255, 255));
		lblDay.setFont(new Font("Futura", Font.BOLD, 18));
		lblDay.setHorizontalAlignment(SwingConstants.LEFT);
		lblDay.setBounds(381, 292, 97, 25);
		frame.getContentPane().add(lblDay);
		
		lblTransporterPieces.setText("Transporter Pieces: " + game.getCrewTransporterPieces() + "/" + game.getNumberOfPieces());
		lblTransporterPieces.setForeground(new Color(255, 255, 255));
		lblTransporterPieces.setFont(new Font("Futura", Font.BOLD, 18));
		lblTransporterPieces.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTransporterPieces.setBounds(474, 292, 242, 25);
		frame.getContentPane().add(lblTransporterPieces);
		
		btnMember0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setChosenMember(btnMember0, 0);
			}
		});
		btnMember0.setBounds(23, 178, 169, 70);
		frame.getContentPane().add(btnMember0);
		
		btnMember1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setChosenMember(btnMember1, 1);
			}
		});
		btnMember1.setBounds(200, 178, 169, 70);
		frame.getContentPane().add(btnMember1);
		
		btnMember2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setChosenMember(btnMember2, 2);
			}
		});
		btnMember2.setBounds(23, 253, 169, 70);
		frame.getContentPane().add(btnMember2);
		
		btnMember3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setChosenMember(btnMember3, 3);
			}
		});
		btnMember3.setBounds(200, 253, 169, 70);
		frame.getContentPane().add(btnMember3);
		
		lblActionResult.setText("<html><div style='text-align: center;'>Welcome to " + game.getCurrentPlanet().getName() + "!"
							+ "<br><br>Scan gives you a list of<br>resources available in a planet."
							+ "<br>Collect the items by ransacking the planet."
							+ "<br><br>A crew member can only ransack a planet if he or she has actions remaining.</div></html>");
		lblActionResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblActionResult.setForeground(new Color(255, 204, 102));
		lblActionResult.setFont(new Font("Futura", Font.PLAIN, 15));
		lblActionResult.setBounds(400, 61, 303, 218);
		frame.getContentPane().add(lblActionResult);

		btnScan.setText("<html><center>Scan<br>" + game.getCurrentPlanet().getName() + "</center></html>");
		btnScan.setMargin(new Insets(0,-30, 0,-30));
		btnScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblActionResult.setText("<html><div style='text-align: center;'>Resources:"
									+ "<br><br>Food Items: "
									+ "<br>—— " + game.getPlanetFoodNames()
									+ "<br>Medical Items: " 
									+ "<br>—— " + game.getPlanetMedicalNames()
									+ "<br>Transporter Pieces: " + game.getCurrentPlanet().getTransporterPiece()
									+ "<br>Money: $" + game.getCurrentPlanet().getMoney() + "</div></html>");
			}
		});
		btnScan.setBounds(200, 333, 169, 90);
		frame.getContentPane().add(btnScan);
		
		btnRansack.setText("<html><center>Ransack<br>" + game.getCurrentPlanet().getName() + "</center></html>");
		btnRansack.setMargin(new Insets(0,-30, 0,-30));
		btnRansack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ransackPlanet();
			}
		});
		btnRansack.setBounds(377, 333, 169, 90);
		frame.getContentPane().add(btnRansack);
		
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getPlanetCounter() == 0) {
					lblActionResult.setText("<html>You can't go to next day yet.</html>");
				} else if (game.getCurrentDay() == game.getNumberOfDays()) {
					finishedWindow();
					game.launchGameOverScreen();
				} else {
					game.nextDay();
					if (game.isAllDead()) {
						finishedWindow();
						game.launchGameOverScreen();
					} else {
						nextDayEvents();
						
						lblDay.setText("Day: " + game.getCurrentDay() + "/" + game.getNumberOfDays());
						setCrewMembersStatus();							
						setButtons();
						
					}				
				}
			}
		});
		btnNextDay.setBounds(23, 333, 169, 90);
		frame.getContentPane().add(btnNextDay);
		
		btnLeave.setText("<html><center>Leave<br>" + game.getCurrentPlanet().getName() + "</center></html>");
		btnLeave.setMargin(new Insets(0,-30, 0,-30));
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getPlanetCounter() == 0) {
					finishedWindow();
					game.leavePlanet();
					game.setCrewTransporterPieces(0);
					game.launchScorpiusStrikesScreen();
				} else {
					finishedWindow();
					game.leavePlanet();	
					game.launchSpaceshipScreen();
				}
			}
		});
		btnLeave.setBounds(554, 333, 169, 90);
		frame.getContentPane().add(btnLeave);
		

		panelPlanet.setBackground(new Color(0, 0, 51, 50));
		panelPlanet.setBounds(381, 61, 337, 219);
		frame.getContentPane().add(panelPlanet);
		panelPlanet.setLayout(null);
		
		lblImg.setIcon(new ImageIcon(PlanetScreen.class.getResource("/img/rsz_surface.jpg")));
		lblImg.setBounds(-49, 0, 867, 452);
		frame.getContentPane().add(lblImg);
		
		
		
		
		
		
	}
}
