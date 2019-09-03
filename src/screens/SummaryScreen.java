package screens;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

import main.*;

public class SummaryScreen {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Launch the application.
	 */
//	
//	public void setMemberLabels() {
//		ArrayList<JLabel> memberLabels = new ArrayList<JLabel>();
//		memberLabels.add(lblMember0);
//		memberLabels.add(lblMember1);
//		memberLabels.add(lblMember2);
//		memberLabels.add(lblMember3);		
//		
//		for (CrewMember crewMember: game.getCrewMembers()) {
//			int index = game.getCrewMembers().indexOf(crewMember);
//			memberLabels.get(index).setText("<html>" + crewMember.getName() + "<br>The " + crewMember.getType() + "</html>");
//		}
//		
//	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SummaryScreen window = new SummaryScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public SummaryScreen(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeSummaryScreen(this);
	}
	
	/**
	 * Create the application.
	 */
	public SummaryScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.setTitle("Summary Window");
		frame.setBounds(100, 100, 357, 411);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);		
		frame.setLocationRelativeTo(null);

		
		JLabel lblSummary = new JLabel("REVIEW YOUR DETAILS");
		lblSummary.setForeground(new Color(255, 255, 224));
		lblSummary.setFont(new Font("Phosphate", Font.PLAIN, 26));
		lblSummary.setHorizontalAlignment(SwingConstants.CENTER);
		lblSummary.setBounds(6, 16, 332, 36);
		frame.getContentPane().add(lblSummary);
		
		JLabel lblCrewName = new JLabel("Crew: " + game.getCrewName());
		lblCrewName.setForeground(new Color(255, 255, 224));
		lblCrewName.setFont(new Font("Futura", Font.PLAIN, 18));
		lblCrewName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewName.setBounds(6, 58, 339, 25);
		frame.getContentPane().add(lblCrewName);
		
		JLabel lblSpaceshipName = new JLabel("Spaceship: " + game.getSpaceshipName());
		lblSpaceshipName.setForeground(new Color(255, 255, 224));
		lblSpaceshipName.setFont(new Font("Futura", Font.PLAIN, 18));
		lblSpaceshipName.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpaceshipName.setBounds(6, 88, 339, 25);
		frame.getContentPane().add(lblSpaceshipName);
		
		JLabel lblDayCount = new JLabel("Days Until Spaceship Malfunction: " + game.getNumberOfDays());
		lblDayCount.setForeground(new Color(255, 255, 224));
		lblDayCount.setFont(new Font("Futura", Font.PLAIN, 18));
		lblDayCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDayCount.setBounds(6, 118, 339, 25);
		frame.getContentPane().add(lblDayCount);
		
		JLabel lblPiecesCount = new JLabel("Transporter Pieces to Find: " + game.getNumberOfPieces());
		lblPiecesCount.setForeground(new Color(255, 255, 224));
		lblPiecesCount.setFont(new Font("Futura", Font.PLAIN, 18));
		lblPiecesCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblPiecesCount.setBounds(6, 148, 339, 25);
		frame.getContentPane().add(lblPiecesCount);
		
		
		JLabel lblCrewMembers = new JLabel("CREW MEMBERS", SwingConstants.CENTER);
		lblCrewMembers.setForeground(new Color(255, 255, 224));
		lblCrewMembers.setBounds(16, 193, 325, 30);
		frame.getContentPane().add(lblCrewMembers);
		lblCrewMembers.setFont(new Font("Futura", Font.BOLD, 18));

		
		
		JLabel lblMember0 = new JLabel();
		lblMember0.setForeground(new Color(255, 255, 224));
		lblMember0.setFont(new Font("Futura", Font.PLAIN, 13));
		lblMember0.setHorizontalAlignment(SwingConstants.CENTER);
		lblMember0.setBounds(16, 227, 159, 40);
		frame.getContentPane().add(lblMember0);
		frame.getContentPane().add(lblMember0);

		JLabel lblMember1 = new JLabel();
		lblMember1.setForeground(new Color(255, 255, 224));
		lblMember1.setFont(new Font("Futura", Font.PLAIN, 13));
		lblMember1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMember1.setBounds(175, 227, 159, 40);
		frame.getContentPane().add(lblMember1);
		frame.getContentPane().add(lblMember1);
		
		JLabel lblMember2 = new JLabel();
		lblMember2.setForeground(new Color(255, 255, 224));
		lblMember2.setFont(new Font("Futura", Font.PLAIN, 13));
		lblMember2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMember2.setBounds(16, 279, 159, 40);
		frame.getContentPane().add(lblMember2);
		frame.getContentPane().add(lblMember2);
		
		JLabel lblMember3 = new JLabel();
		lblMember3.setForeground(new Color(255, 255, 224));
		lblMember3.setFont(new Font("Futura", Font.PLAIN, 13));
		lblMember3.setHorizontalAlignment(SwingConstants.CENTER);
		lblMember3.setBounds(175, 279, 159, 40);
		frame.getContentPane().add(lblMember3);
		frame.getContentPane().add(lblMember3);
		
		ArrayList<JLabel> memberLabels = new ArrayList<JLabel>();
		memberLabels.add(lblMember0);
		memberLabels.add(lblMember1);
		memberLabels.add(lblMember2);
		memberLabels.add(lblMember3);		
		
		for (CrewMember crewMember: game.getCrewMembers()) {
			int index = game.getCrewMembers().indexOf(crewMember);
			memberLabels.get(index).setText("<html><div style='text-align: center;'>" + crewMember.getName() 
										+ "<br>The " + crewMember.getType() + "</div></html>");
		}
		
		
		
		
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnQuit.setBounds(10, 336, 129, 35);
		frame.getContentPane().add(btnQuit);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchPlanetIntroScreen();
			}
		});
		btnConfirm.setBounds(208, 336, 129, 35);
		frame.getContentPane().add(btnConfirm);
	


		JPanel panelCrewMembers = new JPanel();
		panelCrewMembers.setBackground(new Color(0, 0, 51, 100));
		panelCrewMembers.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		panelCrewMembers.setBounds(10, 185, 328, 143);
		frame.getContentPane().add(panelCrewMembers);
		panelCrewMembers.setLayout(null);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(SummaryScreen.class.getResource("/img/rsz_1forbidden-planet_final_seps.jpg")));
		lblImg.setBounds(0, 0, 351, 383);
		frame.getContentPane().add(lblImg);
	
		
		
		
		
	
	}
}
