package screens;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import main.*;

public class InventoryScreen {

	private JFrame frame;
	private GameEnvironment game;
//	private JLabel lblInventory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryScreen window = new InventoryScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public InventoryScreen(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeInventoryScreen(this);
	}

	/**
	 * Create the application.
	 */
	public InventoryScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Crew Inventory");
		frame.setBounds(100, 100, 667, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setLocationRelativeTo(null);

		
		JLabel lblInventory = new JLabel("INVENTORY");
		lblInventory.setFont(new Font("Phosphate", Font.PLAIN, 27));
		lblInventory.setForeground(new Color(255, 245, 238));
		lblInventory.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventory.setBounds(204, 10, 258, 25);
		frame.getContentPane().add(lblInventory);
		
		JPanel panelMember = new JPanel();
		panelMember.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		panelMember.setBounds(204, 45, 258, 133);
		frame.getContentPane().add(panelMember);
		panelMember.setOpaque(false);
		panelMember.setLayout(null);
		
		JLabel lblMbrName = new JLabel("#1 " + game.getCrewMembers().get(0).getName());
		lblMbrName.setFont(new Font("Futura", Font.BOLD, 15));
		lblMbrName.setForeground(new Color(255, 245, 238));
		lblMbrName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMbrName.setBounds(6, 6, 246, 35);
		panelMember.add(lblMbrName);
		
		JLabel lblMbrHealth = new JLabel("Health: " + game.getCrewMembers().get(0).getHealth() + "%");
		lblMbrHealth.setFont(new Font("Futura", Font.PLAIN, 13));
		lblMbrHealth.setForeground(new Color(255, 245, 238));
		lblMbrHealth.setBounds(15, 54, 114, 16);
		panelMember.add(lblMbrHealth);
		
		JLabel lblMbrHunger = new JLabel("Hunger: " + game.getCrewMembers().get(0).getHunger() + "%");
		lblMbrHunger.setFont(new Font("Futura", Font.PLAIN, 13));
		lblMbrHunger.setForeground(new Color(255, 245, 238));
		lblMbrHunger.setBounds(15, 74, 114, 16);
		panelMember.add(lblMbrHunger);
		
		JLabel lblMbrTiredness = new JLabel("Tiredness: " + game.getCrewMembers().get(0).getTiredness() + "%");
		lblMbrTiredness.setFont(new Font("Futura", Font.PLAIN, 13));
		lblMbrTiredness.setForeground(new Color(255, 245, 238));
		lblMbrTiredness.setBounds(15, 94, 114, 16);
		panelMember.add(lblMbrTiredness);
		
		JLabel lblInfected = new JLabel("Infected: " + game.getCrewMembers().get(0).isInfected());
		lblInfected.setFont(new Font("Futura", Font.PLAIN, 13));
		lblInfected.setForeground(new Color(255, 245, 238));
		lblInfected.setBounds(129, 54, 114, 16);
		panelMember.add(lblInfected);
		
		JLabel lblActions = new JLabel("Actions: ");
		lblActions.setFont(new Font("Futura", Font.PLAIN, 13));
		lblActions.setForeground(new Color(255, 245, 238));
		lblActions.setBounds(129, 74, 114, 16);
		panelMember.add(lblActions);
		
		JLabel lblRemaining = new JLabel((2 - game.getCrewMembers().get(0).getActions()) + " Remaining");
		lblRemaining.setFont(new Font("Futura", Font.PLAIN, 13));
		lblRemaining.setForeground(new Color(255, 245, 238));
		lblRemaining.setBounds(129, 94, 114, 16);
		panelMember.add(lblRemaining);
		
		JButton btnMember0 = new JButton("Empty");
		btnMember0.setFont(new Font("Futura", Font.PLAIN, 14));
		btnMember0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnMember0.getText() != "Empty") {
					String chosenMember = btnMember0.getText();
					int index = (Integer.parseInt(chosenMember.substring(40, 41)) - 1);
					CrewMember member = game.getCrewMembers().get(index);
					lblMbrName.setText("#" + (index + 1) + " " + member.getName());
					lblMbrHealth.setText("Health: " + member.getHealth() + "%");
					lblMbrHunger.setText("Hunger: " + member.getHunger() + "%");
					lblMbrTiredness.setText("Tiredness: " + member.getTiredness() + "%");
					lblInfected.setText("Infected: " + member.isInfected());
					lblRemaining.setText((2 - member.getActions()) + " Remaining");
				}
			}
		});
		btnMember0.setBounds(204, 188, 125, 58);
		frame.getContentPane().add(btnMember0);
		
		JButton btnMember1 = new JButton("Empty");
		btnMember1.setFont(new Font("Futura", Font.PLAIN, 14));
		btnMember1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnMember1.getText() != "Empty") {
					String chosenMember = btnMember1.getText();
					int index = (Integer.parseInt(chosenMember.substring(40, 41)) - 1);
					CrewMember member = game.getCrewMembers().get(index);
					lblMbrName.setText("#" + (index + 1) + " " + member.getName());
					lblMbrHealth.setText("Health: " + member.getHealth() + "%");
					lblMbrHunger.setText("Hunger: " + member.getHunger() + "%");
					lblMbrTiredness.setText("Tiredness: " + member.getTiredness() + "%");
					lblInfected.setText("Infected: " + member.isInfected());
					lblRemaining.setText((2 - member.getActions()) + " Remaining");
				}
			}
		});
		btnMember1.setBounds(337, 188, 125, 58);
		frame.getContentPane().add(btnMember1);
		
		JButton btnMember2 = new JButton("Empty");
		btnMember2.setFont(new Font("Futura", Font.PLAIN, 14));
		btnMember2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnMember2.getText() != "Empty") {
					String chosenMember = btnMember2.getText();
					int index = (Integer.parseInt(chosenMember.substring(40, 41)) - 1);
					CrewMember member = game.getCrewMembers().get(index);
					lblMbrName.setText("#" + (index + 1) + " " + member.getName());
					lblMbrHealth.setText("Health: " + member.getHealth() + "%");
					lblMbrHunger.setText("Hunger: " + member.getHunger() + "%");
					lblMbrTiredness.setText("Tiredness: " + member.getTiredness() + "%");
					lblInfected.setText("Infected: " + member.isInfected());
					lblRemaining.setText((2 - member.getActions()) + " Remaining");
				}
			}
		});
		btnMember2.setBounds(204, 251, 125, 58);
		frame.getContentPane().add(btnMember2);
		
		JButton btnMember3 = new JButton("Empty");
		btnMember3.setFont(new Font("Futura", Font.PLAIN, 14));
		btnMember3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnMember3.getText() != "Empty") {
					String chosenMember = btnMember3.getText();
					int index = (Integer.parseInt(chosenMember.substring(40, 41)) - 1);
					CrewMember member = game.getCrewMembers().get(index);
					lblMbrName.setText("#" + (index + 1) + " " + member.getName());
					lblMbrHealth.setText("Health: " + member.getHealth() + "%");
					lblMbrHunger.setText("Hunger: " + member.getHunger() + "%");
					lblMbrTiredness.setText("Tiredness: " + member.getTiredness() + "%");
					lblInfected.setText("Infected: " + member.isInfected());
					lblRemaining.setText((2 - member.getActions()) + " Remaining");
				}
			}
		});
		btnMember3.setBounds(337, 251, 125, 58);
		frame.getContentPane().add(btnMember3);
		
		for (CrewMember member: game.getCrewMembers()) {
			int index = game.getCrewMembers().indexOf(member);
			switch(index) {
				case 0:
					btnMember0.setText("<html><div style='text-align: center;'>#1 " + member.getName() + "</div></html>");
					break;
				case 1:
					btnMember1.setText("<html><div style='text-align: center;'>#2 " + member.getName() + "</div></html>");
					break;
				case 2:
					btnMember2.setText("<html><div style='text-align: center;'>#3 " + member.getName() + "</div></html>");
					break;
				case 3:
					btnMember3.setText("<html><div style='text-align: center;'>#4 " + member.getName() + "</div></html>");
					break;	
			}						
		}
		
		JPanel panelFoodItem = new JPanel();
		panelFoodItem.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		panelFoodItem.setBounds(18, 104, 174, 202);
		frame.getContentPane().add(panelFoodItem);
		panelFoodItem.setLayout(null);
		panelFoodItem.setOpaque(false);
		
		JLabel lblFood = new JLabel();
		lblFood.setForeground(new Color(255, 245, 238));
		lblFood.setHorizontalAlignment(SwingConstants.CENTER);
		lblFood.setFont(new Font("Futura", Font.BOLD, 19));
		lblFood.setBounds(10, 17, 154, 45);
		panelFoodItem.add(lblFood);
		
		JLabel lblHealth = new JLabel("Health:");
		lblHealth.setFont(new Font("Futura", Font.BOLD, 14));
		lblHealth.setForeground(new Color(255, 245, 238));
		lblHealth.setBounds(20, 72, 144, 16);
		panelFoodItem.add(lblHealth);
		
		JLabel lblHunger = new JLabel("Hunger:");
		lblHunger.setFont(new Font("Futura", Font.BOLD, 14));
		lblHunger.setForeground(new Color(255, 245, 238));
		lblHunger.setBounds(20, 95, 158, 18);
		panelFoodItem.add(lblHunger);
		
		JLabel lblFoodItems = new JLabel("Food Items:");
		lblFoodItems.setFont(new Font("Futura", Font.BOLD, 14));
		lblFoodItems.setForeground(new Color(255, 245, 238));
		lblFoodItems.setBounds(20, 45, 172, 16);
		frame.getContentPane().add(lblFoodItems);
		
		JComboBox<FoodItem> comboBoxFood = new JComboBox<FoodItem>(game.getCrewFoodItems().toArray(new FoodItem[0]));
		comboBoxFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = comboBoxFood.getSelectedIndex();
				FoodItem foodItem = game.getCrewFoodItems().get(index);
				lblFood.setText(foodItem.getName());
				lblHealth.setText("Health: " + foodItem.getHealth() + "%");
				lblHunger.setText("Hunger: " + foodItem.getHunger() + "%");
			}
		});
		comboBoxFood.setBounds(13, 65, 185, 27);		
		frame.getContentPane().add(comboBoxFood);
		
		JButton btnFeed = new JButton("Feed");
		btnFeed.setFont(new Font("Futura", Font.BOLD, 14));
		btnFeed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblFood.getText() != "") {
					int memberIndex = Integer.parseInt(lblMbrName.getText().substring(1, 2)) - 1;
					int foodIndex = comboBoxFood.getSelectedIndex();
					CrewMember crewMember = game.getCrewMembers().get(memberIndex);
					FoodItem foodItem = game.getCrewFoodItems().get(foodIndex);
					if (crewMember.getActions() < 2) {
						game.feedCrewMember(crewMember, foodItem);			
						DefaultComboBoxModel<FoodItem> model = new DefaultComboBoxModel<FoodItem>(game.getCrewFoodItems().toArray(new FoodItem[0]));
						comboBoxFood.setModel(model);
						lblMbrHealth.setText("Health: " + crewMember.getHealth() + "%");
						lblMbrHunger.setText("Hunger: " + crewMember.getHunger() + "%");
						lblRemaining.setText((2 - crewMember.getActions() + " Remaining"));
						lblFood.setText("");
						lblHealth.setText("Health: ");
						lblHunger.setText("Hunger: ");
					} else {
						JOptionPane.showMessageDialog(btnFeed, "Choose a member with sufficient actions.");
					}
				}
			}
		});
		btnFeed.setBounds(10, 148, 154, 45);
		panelFoodItem.add(btnFeed);
		
		
		JPanel panelMedicalItem = new JPanel();
		panelMedicalItem.setBorder(BorderFactory.createLineBorder(Color.lightGray));
		panelMedicalItem.setBounds(474, 104, 174, 202);
		frame.getContentPane().add(panelMedicalItem);
		panelMedicalItem.setLayout(null);
		panelMedicalItem.setOpaque(false);
		
		JLabel lblMedical = new JLabel();
		lblMedical.setFont(new Font("Futura", Font.BOLD, 14));
		lblMedical.setForeground(new Color(255, 245, 238));
		lblMedical.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedical.setFont(new Font("Futura", Font.BOLD, 19));
		lblMedical.setBounds(10, 17, 154, 45);
		panelMedicalItem.add(lblMedical);
		
		JLabel lblMedHealth = new JLabel("Health:");
		lblMedHealth.setFont(new Font("Futura", Font.BOLD, 14));
		lblMedHealth.setForeground(new Color(255, 245, 238));
		lblMedHealth.setBounds(20, 72, 144, 16);
		panelMedicalItem.add(lblMedHealth);
		
		JLabel lblCure = new JLabel("Cure:");
		lblCure.setFont(new Font("Futura", Font.BOLD, 14));
		lblCure.setForeground(new Color(255, 245, 238));
		lblCure.setBounds(20, 95, 158, 18);
		panelMedicalItem.add(lblCure);
		
		JLabel lblMedicalItems = new JLabel("Medical Items:");
		lblMedicalItems.setFont(new Font("Futura", Font.BOLD, 14));
		lblMedicalItems.setForeground(new Color(255, 245, 238));
		lblMedicalItems.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMedicalItems.setBounds(464, 45, 184, 16);
		frame.getContentPane().add(lblMedicalItems);
		
		JComboBox<MedicalItem> comboBoxMedical = new JComboBox<MedicalItem>(game.getCrewMedicalItems().toArray(new MedicalItem[0]));
		comboBoxMedical.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = comboBoxMedical.getSelectedIndex();
				MedicalItem medicalItem = game.getCrewMedicalItems().get(index);
				lblMedical.setText(medicalItem.getName());
				lblMedHealth.setText("Health: " + medicalItem.getHealth() + "%");
				lblCure.setText("Cure: " + medicalItem.getCure());
			}
		});
		comboBoxMedical.setBounds(469, 65, 185, 27);
		frame.getContentPane().add(comboBoxMedical);
		
		JButton btnHeal = new JButton("Heal");
		btnHeal.setFont(new Font("Futura", Font.BOLD, 14));
		btnHeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblMedical.getText() != "") {
					int memberIndex = Integer.parseInt(lblMbrName.getText().substring(1, 2)) - 1;
					int medicalIndex = comboBoxMedical.getSelectedIndex();
					CrewMember crewMember = game.getCrewMembers().get(memberIndex);
					MedicalItem medicalItem = game.getCrewMedicalItems().get(medicalIndex);
					if (crewMember.getActions() < 2) {
						game.healCrewMember(crewMember, medicalItem);
						DefaultComboBoxModel<MedicalItem> model = new DefaultComboBoxModel<MedicalItem>(game.getCrewMedicalItems().toArray(new MedicalItem[0]));
						comboBoxMedical.setModel(model);
						lblMbrHealth.setText("Health: " + crewMember.getHealth() + "%");
						lblInfected.setText("Infected: " + crewMember.isInfected());
						lblRemaining.setText((2 - crewMember.getActions() + " Remaining"));
						lblMedical.setText("");
						lblMedHealth.setText("Health: ");
						lblCure.setText("Cure: ");
					} else {
						JOptionPane.showMessageDialog(btnHeal, "Choose a member with sufficient actions.");
					}
				}
			}
		});
		btnHeal.setBounds(10, 148, 154, 45);
		panelMedicalItem.add(btnHeal);
		
		JButton btnOutpost = new JButton("Visit Outpost");
		btnOutpost.setFont(new Font("Futura", Font.BOLD, 12));
		btnOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchOutpostScreen();
			}
		});
		btnOutpost.setBounds(176, 314, 153, 39);
		frame.getContentPane().add(btnOutpost);
		
		JButton btnSpaceship = new JButton("Return to Spaceship");
		btnSpaceship.setFont(new Font("Futura", Font.BOLD, 11));
		btnSpaceship.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchSpaceshipScreen();
			}
		});
		btnSpaceship.setBounds(337, 314, 153, 39);
		frame.getContentPane().add(btnSpaceship);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(InventoryScreen.class.getResource("/img/rsz_21alieninventory.jpg")));
		lblImg.setBounds(0, 0, 667, 371);
		frame.getContentPane().add(lblImg);
		
		
		
		
	}
}
