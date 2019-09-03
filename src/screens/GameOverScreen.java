package screens;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import main.*;

public class GameOverScreen {

	private JFrame frame;
	private GameEnvironment game;
	int deadCount = 0;
	private ArrayList<CrewMember> survivingMembers = new ArrayList<CrewMember>();
	private String survivors;
	private CrewMember soleSurvivor; 


	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOverScreen window = new GameOverScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GameOverScreen(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeGameOverScreen(this);
	}

	public void setSurvivingMembers() {
		for (CrewMember crewMember: game.getCrewMembers()) {
			if (crewMember.isAlive() == false) {
				deadCount += 1;
			} else {
				survivingMembers.add(crewMember);
			}
		}
		survivors = String.join(",", survivingMembers.toString());
		if (survivingMembers.size() == 1) {
			soleSurvivor = survivingMembers.get(0);
		}
	}
	/**
	 * Create the application.
	 */
	public GameOverScreen() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Game Over");
		frame.setBounds(100, 100, 710, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setLocationRelativeTo(null);

		
		setSurvivingMembers();
		
		JLabel lblGameOver = new JLabel("YOU WON");
		lblGameOver.setForeground(new Color(255, 250, 205));
		lblGameOver.setFont(new Font("Phosphate", Font.PLAIN, 55));
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setBounds(6, 14, 698, 56);
		frame.getContentPane().add(lblGameOver);
		if (game.getCrewTransporterPieces() < game.getNumberOfPieces() || (game.isAllDead() || game.isExploded())) {
			lblGameOver.setText("YOU LOST");
		}
		
		JLabel lblDescription = new JLabel("<html><div style='text-align: center;'>It took them " + game.getCurrentDay() + " days but after"
										+ " heroically venturing across the vicious galaxy of Scorpius, the " + game.getSpaceshipName() 
										+ " have succesfully found all " + game.getNumberOfPieces() + " transporter pieces to finally return home."
										+ "<br><br>You now have two options: "
										+ "<br>Return home"
										+ "<br>Rightfully exact your revenge against Scorpius and let your crew members die as martyrs</div></html>");
		lblDescription.setForeground(new Color(255, 255, 255));
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setFont(new Font("Futura", Font.PLAIN, 15));
		lblDescription.setBounds(28, 289, 652, 126);
		frame.getContentPane().add(lblDescription);
		
		if (game.isAllDead()) {
			lblDescription.setText("<html><div style='text-align: center;'>Thus ends the virtual, superficial 'lives' of your crew members,"
								+ " as they have all died of chronic diarrhoea. RIP all.</div></html>");
		} else if (game.isExploded()) {
			lblDescription.setText("<html>Uh oh, the " + game.getSpaceshipName() + " has exploded, deep frying everybody in the process."
					+ "<br>Yum!</html>");
		} else if (game.getCrewTransporterPieces() < game.getNumberOfPieces() && game.getCurrentDay() == game.getNumberOfDays()) {
			if (game.getDeadMembers().size() == (game.getCrewCount() - 1)) {
				lblDescription.setText("<html><div style='text-align: center;'>Looks like you ran out of time and the " + game.getSpaceshipName() 
									+ " has malfunctioned. This means that " + game.getCrewMembers().get(0) + ", the sole survivor of"
									+ " the " + game.getSpaceshipName() + " is lost in space forever. In an act of despair, " + soleSurvivor 
									+ " gets hungry and eats " + soleSurvivor + "'s own leg. Yum!</div></html>");
			} else {
				lblDescription.setText("<html><div style='text-align: center;'>Looks like you ran out of time and the " + game.getSpaceshipName() + " has malfunctioned."
									+ " This means that your crew members are lost in space forever. "
									+ "<br>In an act of despair, " + survivingMembers.get(0) 
									+ " resorts to cannibalism and sautées all of his delicious crew mates. Yum!</div></html>");		
			}
		} 	
		
		JPanel panelStats = new JPanel();
		panelStats.setBackground(new Color(75, 0, 130, 100));
		panelStats.setBounds(172, 82, 362, 177);
		frame.getContentPane().add(panelStats);
		panelStats.setLayout(null);
		
		
		double score = Math.round(game.getNumberOfDays() / game.getCurrentDay() * 100) + (game.getCrewFunds()) + (game.getCrewTransporterPieces() * 100);
		
		JLabel lblScore = new JLabel("Score: " + score);
		lblScore.setForeground(new Color(255, 255, 255));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setFont(new Font("Futura", Font.BOLD, 13));
		lblScore.setBounds(6, 10, 350, 16);
		panelStats.add(lblScore);
		
		JLabel lblCrew = new JLabel("Crew: " + game.getCrewName());
		lblCrew.setForeground(new Color(255, 255, 255));
		lblCrew.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrew.setFont(new Font("Futura", Font.BOLD, 13));
		lblCrew.setBounds(6, 30, 350, 16);
		panelStats.add(lblCrew);
		
		JLabel lblSpaceship = new JLabel("Spaceship: " + game.getSpaceshipName() + " at " + game.getSpaceshipHealth() + "%");
		lblSpaceship.setForeground(new Color(255, 255, 255));
		lblSpaceship.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpaceship.setFont(new Font("Futura", Font.BOLD, 13));
		lblSpaceship.setBounds(6, 50, 350, 16);
		panelStats.add(lblSpaceship);
		
		JLabel lblDays = new JLabel("Days: " + game.getCurrentDay() + "/" + game.getNumberOfDays());
		lblDays.setForeground(new Color(255, 255, 255));
		lblDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblDays.setFont(new Font("Futura", Font.BOLD, 13));
		lblDays.setBounds(6, 70, 350, 16);
		panelStats.add(lblDays);
		
		JLabel lblTransporterPieces = new JLabel("Transporter Pieces: " + game.getCrewTransporterPieces() + "/" + game.getNumberOfPieces());
		lblTransporterPieces.setForeground(new Color(255, 255, 255));
		lblTransporterPieces.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransporterPieces.setFont(new Font("Futura", Font.BOLD, 13));
		lblTransporterPieces.setBounds(6, 90, 350, 16);
		panelStats.add(lblTransporterPieces);
		
		JLabel lblCasualties = new JLabel("Casualties: " + deadCount);
		lblCasualties.setForeground(new Color(255, 255, 255));
		lblCasualties.setFont(new Font("Futura", Font.BOLD, 13));
		lblCasualties.setHorizontalAlignment(SwingConstants.CENTER);
		lblCasualties.setBounds(6, 110, 350, 16);
		panelStats.add(lblCasualties);
		
		JLabel lblCrewMembersRemaining = new JLabel("Crew Members Remaining:");
		lblCrewMembersRemaining.setForeground(new Color(255, 255, 255));
		lblCrewMembersRemaining.setFont(new Font("Futura", Font.BOLD, 13));
		lblCrewMembersRemaining.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewMembersRemaining.setBounds(6, 130, 350, 16);
		panelStats.add(lblCrewMembersRemaining);
		
		JLabel lblSurvivors = new JLabel(survivors);
		lblSurvivors.setForeground(new Color(255, 255, 255));
		lblSurvivors.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurvivors.setFont(new Font("Futura", Font.BOLD, 13));
		lblSurvivors.setBounds(6, 150, 350, 16);
		panelStats.add(lblSurvivors);
		
		if (game.getCrewTransporterPieces() < game.getNumberOfPieces() || game.isAllDead() || game.isExploded()) {
			lblCasualties.setText("Casualties: " + game.getCrewMembers().size());
			lblSurvivors.setText("None because they're all a goner!");
		}
//		
//		JLabel lblImg = new JLabel("");
//		lblImg.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblImg.setBounds(0, 0, 667, 400);
//		frame.getContentPane().add(lblImg);
//		
		if (game.getCrewTransporterPieces() >= game.getNumberOfPieces()) {
			JButton btnCrash = new JButton("<html>Destroy "
										+ "<br>Scorpius</html>");
			btnCrash.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					finishedWindow();
					game.launchScorpiusDeathScreen();
				}
			});
			btnCrash.setBounds(29, 82, 117, 155);
			frame.getContentPane().add(btnCrash);
			
			JButton btnReturn = new JButton("Go Home");
			btnReturn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					finishedWindow();
					//earth screen
				}
			});
			btnReturn.setBounds(561, 82, 117, 155);
			frame.getContentPane().add(btnReturn);
			
		} else {
			JButton btnDie = new JButton("Die");
			btnDie.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					finishedWindow();
					//die screen
				}
			});
			btnDie.setBounds(29, 82, 117, 155);
			frame.getContentPane().add(btnDie);

			JButton btnDieAgain = new JButton("Die");
			btnDieAgain.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					finishedWindow();
					//die screen
				}
			});
			btnDieAgain.setBounds(561, 82, 117, 155);
			frame.getContentPane().add(btnDieAgain);
		}
		
		JPanel panelBackground = new JPanel();
		panelBackground.setBackground(new Color(75, 0, 130, 100));
		panelBackground.setBounds(18, 275, 674, 152);
		frame.getContentPane().add(panelBackground);
		
		JLabel lblImg = new JLabel();
		lblImg.setIcon(new ImageIcon(GameOverScreen.class.getResource("/img/rsz_75d0d835bb3f92f23a947836 (1).png")));
		lblImg.setBounds(0, 0, 710, 449);
		frame.getContentPane().add(lblImg);
		
		if (game.getCrewTransporterPieces() < game.getNumberOfPieces() && game.getCurrentDay() == game.getNumberOfDays()) {
			panelStats.setBackground(new Color(165, 42, 42, 96));
			panelBackground.setBackground(new Color(165, 42, 42, 96));
			lblImg.setIcon(new ImageIcon(GameOverScreen.class.getResource("/img/rsz_saturn_1000.jpg")));
			lblImg.setBounds(0, 0, 710, 1006);
		} 	
	}
}
