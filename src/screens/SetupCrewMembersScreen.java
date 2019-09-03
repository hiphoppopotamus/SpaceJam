package screens;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.GameEnvironment;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

import main.*;

public class SetupCrewMembersScreen {

	private GameEnvironment game;
	private JFrame frame;
	private JTextField textName;
	private int crewCount = 0;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupCrewMembersScreen window = new SetupCrewMembersScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public SetupCrewMembersScreen(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeSetupCrewMembersScreen(this);
	}
	

	/**
	 * Create the application.
	 */
	public SetupCrewMembersScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Crew Members Setup Window");
		frame.setBounds(100, 100, 695, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		
		JLabel lblAddMember = new JLabel("ADD YOUR CREW MEMBERS");
		lblAddMember.setForeground(new Color(255, 255, 255));
		lblAddMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddMember.setFont(new Font("Phosphate", Font.PLAIN, 26));
		lblAddMember.setBounds(6, 16, 683, 33);
		frame.getContentPane().add(lblAddMember);
		
		JLabel lblCrewCount = new JLabel("Crew Count: " + game.getCrewCount());
		lblCrewCount.setForeground(new Color(245, 222, 179));
		lblCrewCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrewCount.setFont(new Font("Futura", Font.PLAIN, 18));
		lblCrewCount.setBounds(194, 100, 148, 36);
		frame.getContentPane().add(lblCrewCount);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(new Color(245, 222, 179));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Futura", Font.PLAIN, 18));
		lblName.setBounds(16, 61, 64, 36);
		frame.getContentPane().add(lblName);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setForeground(new Color(245, 222, 179));
		lblType.setFont(new Font("Futura", Font.PLAIN, 18));
		lblType.setBounds(32, 100, 48, 36);
		frame.getContentPane().add(lblType);
		
		textName = new JTextField();
		textName.setForeground(new Color(245, 222, 179));
		textName.setBackground(new Color(204, 102, 102));
		textName.setFont(new Font("Futura", Font.PLAIN, 18));
		textName.setBounds(92, 61, 261, 40);
		frame.getContentPane().add(textName);
		textName.setColumns(10);

				
		JLabel lblTypeName = new JLabel("Superhuman");
		lblTypeName.setForeground(new Color(245, 222, 179));
		lblTypeName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypeName.setFont(new Font("Futura", Font.PLAIN, 18));
		lblTypeName.setBounds(26, 295, 311, 36);
		frame.getContentPane().add(lblTypeName);
		
		JLabel lblTypeDescription = new JLabel("<html><div style='text-align: center;'>"
									+ "An increased maximum health of 120%.</div></html>", SwingConstants.CENTER);
		lblTypeDescription.setForeground(new Color(245, 222, 179));
		lblTypeDescription.setFont(new Font("Futura", Font.PLAIN, 13));
		lblTypeDescription.setBounds(28, 332, 311, 69);
		frame.getContentPane().add(lblTypeDescription);
		
		
		JButton btnTypeSuper = new JButton("Superhuman");
		btnTypeSuper.setFont(new Font("URW Gothic L", Font.BOLD, 12));
		btnTypeSuper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTypeName.setText("Superhuman");
				lblTypeDescription.setText("<html><div style='text-align: center;'>"
									+ "An increased maximum health of 120%."
									+ "Default is obviously 100%.</div></html>");
			}
		});
		btnTypeSuper.setBounds(16, 140, 110, 69);
		frame.getContentPane().add(btnTypeSuper);
		
		JButton btnTypeHunger = new JButton("Hunger Buster");
		btnTypeHunger.setFont(new Font("URW Gothic L", Font.BOLD, 12));
		btnTypeHunger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTypeName.setText("Hunger Buster");
				lblTypeDescription.setText("<html><div style='text-align: center;'>"
									+ "Hunger increases by 5% per day."
									+ "Default is 8%</div></html>");
			}
		});
		btnTypeHunger.setBounds(127, 140, 114, 69);
		frame.getContentPane().add(btnTypeHunger);
		
		JButton btnTypeFresher = new JButton("Fresher");
		btnTypeFresher.setFont(new Font("URW Gothic L", Font.BOLD, 12));
		btnTypeFresher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTypeName.setText("Fresher");
				lblTypeDescription.setText("<html><div style='text-align: center;'>"
									+ "Tiredness increases by 5% per day."
									+ "Default is 8%.</div></html>");
			}
		});
		btnTypeFresher.setBounds(242, 140, 110, 69);
		frame.getContentPane().add(btnTypeFresher);

		JButton btnTypeBuilder = new JButton("Builder");
		btnTypeBuilder.setFont(new Font("URW Gothic L", Font.BOLD, 12));
		btnTypeBuilder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTypeName.setText("Builder");
				lblTypeDescription.setText("<html><div style='text-align: center;'>"
									+ "Repairing spaceship shield rate is 15%. "
									+ "<br>Default is 5%.</div></html>");
			}
		});
		btnTypeBuilder.setBounds(16, 210, 110, 69);
		frame.getContentPane().add(btnTypeBuilder);
		
		JButton btnTypeImmune = new JButton("Immune");
		btnTypeImmune.setFont(new Font("URW Gothic L", Font.BOLD, 12));
		btnTypeImmune.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTypeName.setText("Immune");
				lblTypeDescription.setText("<html><div style='text-align: center;'>"
									+ "Immunity from the space plague. Don't want to get got by those viruses!</div></html>");
			}
		});
		btnTypeImmune.setBounds(127, 210, 114, 69);
		frame.getContentPane().add(btnTypeImmune);
		
		JButton btnTypeKiller = new JButton("Terminator");
		btnTypeKiller.setFont(new Font("URW Gothic L", Font.BOLD, 12));
		btnTypeKiller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTypeName.setText("Terminator");
				lblTypeDescription.setText("<html><div style='text-align: center;'>"
									+ "Ability to kill and prevent those rat bastards from stealing your items." +
									" Killing aliens is a lot of work so it decreases health by 10%.</div></html>");
			}
		});
		btnTypeKiller.setBounds(242, 210, 110, 69);
		frame.getContentPane().add(btnTypeKiller);
		
		JLabel lblMember0 = new JLabel();
		lblMember0.setForeground(new Color(255, 222, 173));
		lblMember0.setHorizontalAlignment(SwingConstants.CENTER);
		lblMember0.setBounds(385, 105, 127, 145);
		frame.getContentPane().add(lblMember0);
		lblMember0.setFont(new Font("Futura", Font.PLAIN, 13));
		lblMember0.setVerticalAlignment(SwingConstants.TOP);
				
		JLabel lblMember1 = new JLabel();
		lblMember1.setForeground(new Color(255, 222, 173));
		lblMember1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMember1.setBounds(526, 105, 127, 145);
		frame.getContentPane().add(lblMember1);
		lblMember1.setFont(new Font("Futura", Font.PLAIN, 13));
		lblMember1.setVerticalAlignment(SwingConstants.TOP);
		
		JLabel lblMember2 = new JLabel();
		lblMember2.setForeground(new Color(255, 222, 173));
		lblMember2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMember2.setBounds(385, 224, 127, 145);
		frame.getContentPane().add(lblMember2);
		lblMember2.setFont(new Font("Futura", Font.PLAIN, 13));
		lblMember2.setVerticalAlignment(SwingConstants.TOP);
		
		JLabel lblMember3 = new JLabel();
		lblMember3.setForeground(new Color(255, 222, 173));
		lblMember3.setHorizontalAlignment(SwingConstants.CENTER);
		lblMember3.setBounds(526, 224, 127, 145);
		frame.getContentPane().add(lblMember3);
		lblMember3.setFont(new Font("Futura", Font.PLAIN, 13));
		lblMember3.setVerticalAlignment(SwingConstants.TOP);
	
		
		JButton btnAdd = new JButton("Add Member");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (crewCount < game.getCrewCount()) {
					if (lblTypeName.getText() != "Choose a type") {
						game.addCrewMember(textName.getText(), lblTypeName.getText());
						CrewMember crewMember = game.getCrewMembers().get(crewCount);
						switch(crewCount) {
							case 0:
								lblMember0.setText("<html><div style='text-align: center;'>" + crewMember.getName()
								+ "<br>The " + crewMember.getType()
								+ "<br>Health: " + crewMember.getHealth() + "%"
								+ "<br>Health Rate: " + crewMember.getHealthRate() + "%"
								+ "<br>Hunger Rate: " + crewMember.getHungerRate() + "%"
								+ "<br>Tiredness Rate: " + crewMember.getTirednessRate() + "%</div></html>");
								break;
							case 1:
								lblMember1.setText("<html><div style='text-align: center;'>" + crewMember.getName()
								+ "<br>The " + crewMember.getType()
								+ "<br>Health: " + crewMember.getHealth() + "%"
								+ "<br>Health Rate: " + crewMember.getHealthRate() + "%"
								+ "<br>Hunger Rate: " + crewMember.getHungerRate() + "%"
								+ "<br>Tiredness Rate: " + crewMember.getTirednessRate() + "%</div></html>");
								break;
							case 2:
								lblMember2.setText("<html><div style='text-align: center;'>" + crewMember.getName()
								+ "<br>The " + crewMember.getType()
								+ "<br>Health: " + crewMember.getHealth() + "%"
								+ "<br>Health Rate: " + crewMember.getHealthRate() + "%"
								+ "<br>Hunger Rate: " + crewMember.getHungerRate() + "%"
								+ "<br>Tiredness Rate: " + crewMember.getTirednessRate() + "%</div></html>");
								break;
							case 3:
								lblMember3.setText("<html><div style='text-align: center;'>" + crewMember.getName()
								+ "<br>The " + crewMember.getType()
								+ "<br>Health: " + crewMember.getHealth() + "%"
								+ "<br>Health Rate: " + crewMember.getHealthRate() + "%"
								+ "<br>Hunger Rate: " + crewMember.getHungerRate() + "%"
								+ "<br>Tiredness Rate: " + crewMember.getTirednessRate() + "%</div></html>");
								break;
						} 
						crewCount += 1;	
						textName.setText("");
					}
				}
			}
		});
		btnAdd.setBounds(365, 360, 151, 55);
		frame.getContentPane().add(btnAdd);
		
		
		
		
		
	
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (crewCount == game.getCrewCount()) {
					finishedWindow();
				}
			}
		});
		btnContinue.setBounds(524, 360, 151, 55);
		frame.getContentPane().add(btnContinue);
		
		JLabel lblCrewMembers = new JLabel("CREW MEMBERS", SwingConstants.CENTER);
		lblCrewMembers.setForeground(new Color(255, 222, 173));
		lblCrewMembers.setBounds(385, 68, 272, 30);
		frame.getContentPane().add(lblCrewMembers);
		lblCrewMembers.setFont(new Font("Futura", Font.BOLD, 18));
		
		
	
		
	
		JPanel panelCrewMembers = new JPanel();
		panelCrewMembers.setBackground(new Color(205, 92, 92, 150));
		panelCrewMembers.setBounds(365, 61, 310, 291);
		frame.getContentPane().add(panelCrewMembers);
		panelCrewMembers.setLayout(null);
		
		JPanel panelType = new JPanel();
		panelType.setBackground(new Color(205, 92, 92, 150));
		panelType.setBounds(16, 288, 337, 124);
		frame.getContentPane().add(panelType);
		panelType.setLayout(null);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(SetupCrewMembersScreen.class.getResource("/img/rsz_e9jetnrbece6cht9ga6ni.jpg")));
		lblImg.setBounds(0, 0, 695, 430);
		frame.getContentPane().add(lblImg);
	
		
//		
		

		
		
	}
}