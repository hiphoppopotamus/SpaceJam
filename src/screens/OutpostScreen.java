package screens;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import main.*;

public class OutpostScreen {

	private JFrame frame;
	private GameEnvironment game;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OutpostScreen window = new OutpostScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public OutpostScreen(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeOutpostScreen(this);
	}

	/**
	 * Create the application.
	 */
	public OutpostScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Space Outpost Window");
		frame.setBounds(100, 100, 667, 411);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setLocationRelativeTo(null);

		
		JLabel lblSpaceOutpost = new JLabel("SPACE OUPOST");
		lblSpaceOutpost.setFont(new Font("Phosphate", Font.PLAIN, 27));
		lblSpaceOutpost.setForeground(Color.PINK);
		lblSpaceOutpost.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpaceOutpost.setBounds(6, 14, 655, 20);
		frame.getContentPane().add(lblSpaceOutpost);
		
		JLabel lblWallet = new JLabel("Wallet: $" + game.getCrewFunds());
		lblWallet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWallet.setFont(new Font("Futura", Font.BOLD, 13));
		lblWallet.setForeground(new Color(255, 228, 225));
		lblWallet.setBounds(242, 51, 117, 16);
		frame.getContentPane().add(lblWallet);
		
		
		
		JLabel lblName = new JLabel(game.getOutpostFoodItems().get(0).getName());
		lblName.setForeground(new Color(255, 228, 225));
		lblName.setFont(new Font("Futura", Font.BOLD, 19));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(375, 82, 275, 45);
		frame.getContentPane().add(lblName);
		
		JLabel lblHealth = new JLabel("Health: " + game.getOutpostFoodItems().get(0).getHealth() + "%");
		lblHealth.setHorizontalAlignment(SwingConstants.CENTER);
		lblHealth.setFont(new Font("Futura", Font.BOLD, 13));
		lblHealth.setForeground(new Color(255, 228, 225));
		lblHealth.setBounds(375, 130, 275, 27);
		frame.getContentPane().add(lblHealth);
		
		JLabel lblAttribute = new JLabel("Hunger: "  + game.getOutpostFoodItems().get(0).getHunger() + "%");
		lblAttribute.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttribute.setFont(new Font("Futura", Font.BOLD, 13));
		lblAttribute.setForeground(new Color(255, 228, 225));
		lblAttribute.setBounds(375, 160, 275, 27);
		frame.getContentPane().add(lblAttribute);
		
		JLabel lblPrice = new JLabel("Price: $"  + game.getOutpostFoodItems().get(0).getPrice());
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Futura", Font.BOLD, 13));
		lblPrice.setForeground(new Color(255, 228, 225));
		lblPrice.setBounds(375, 190, 275, 27);
		frame.getContentPane().add(lblPrice);
		
		JPanel panelItem = new JPanel();
		panelItem.setBackground(new Color(0, 0, 0, 100));
		panelItem.setBounds(375, 72, 275, 207);
		frame.getContentPane().add(panelItem);
		panelItem.setLayout(null);
		panelItem.setOpaque(true);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double price = Double.parseDouble(lblPrice.getText().substring(8));
				if (game.getCrewFunds() >= price) {
					switch(lblName.getText()) {
						case "Apple":
							FoodItem apple = game.getOutpostFoodItems().get(0);
							game.buyOutpostFoodItem(apple);
							break;
						case "Banana":
							FoodItem banana = game.getOutpostFoodItems().get(1);
							game.buyOutpostFoodItem(banana);
							break;
						case "Burger":
							FoodItem burger = game.getOutpostFoodItems().get(2);
							game.buyOutpostFoodItem(burger);
							break;
						case "Chocolate":
							FoodItem chocolate = game.getOutpostFoodItems().get(3);
							game.buyOutpostFoodItem(chocolate);
							break;
						case "Noodles":
							FoodItem noodles = game.getOutpostFoodItems().get(4);
							game.buyOutpostFoodItem(noodles);
							break;
						case "Steak":
							FoodItem steak = game.getOutpostFoodItems().get(5);
							game.buyOutpostFoodItem(steak);
							break;
						case "Small Bandage":
							MedicalItem smallBandage = game.getOutpostMedicalItems().get(0);
							game.buyOutpostMedicalItem(smallBandage);
							break;
						case "Large Bandage":
							MedicalItem largeBandage = game.getOutpostMedicalItems().get(1);
							game.buyOutpostMedicalItem(largeBandage);
							break;
						case "Cure":
							MedicalItem cure = game.getOutpostMedicalItems().get(2);
							game.buyOutpostMedicalItem(cure);	
							break;
						}
					lblWallet.setText("Wallet: $" + game.getCrewFunds());
					JOptionPane.showMessageDialog(btnPurchase, "Purchase Succesful!");
				} else {
					JOptionPane.showMessageDialog(btnPurchase, "Insufficient Funds!");
				}
			}
		});
		btnPurchase.setBounds(72, 156, 133, 45);
		panelItem.add(btnPurchase);
		
		
		JLabel lblFoodForSale = new JLabel("Food for Sale:");
		lblFoodForSale.setFont(new Font("Futura", Font.BOLD, 13));
		lblFoodForSale.setForeground(new Color(255, 228, 225));
		lblFoodForSale.setBounds(18, 51, 172, 16);
		frame.getContentPane().add(lblFoodForSale);
		
		JButton btnFood0 = new JButton("Apple");
		btnFood0.setFont(new Font("URW Gothic L", Font.BOLD, 13));
		btnFood0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblName.setText(game.getOutpostFoodItems().get(0).getName());
				lblHealth.setText("Health: " + game.getOutpostFoodItems().get(0).getHealth() + "%");
				lblAttribute.setText("Hunger: " + game.getOutpostFoodItems().get(0).getHunger() + "%");
				lblPrice.setText("Price: $"  + game.getOutpostFoodItems().get(0).getPrice());
			}
		});
		btnFood0.setBounds(10, 72, 122, 55);
		frame.getContentPane().add(btnFood0);
		
		JButton btnFood1 = new JButton("Banana");
		btnFood1.setFont(new Font("URW Gothic L", Font.BOLD, 13));
		btnFood1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblName.setText(game.getOutpostFoodItems().get(1).getName());
				lblHealth.setText("Health: " + game.getOutpostFoodItems().get(1).getHealth() + "%");
				lblAttribute.setText("Hunger: " + game.getOutpostFoodItems().get(1).getHunger() + "%");
				lblPrice.setText("Price: $"  + game.getOutpostFoodItems().get(1).getPrice());
			}
		});
		btnFood1.setBounds(134, 72, 124, 55);
		frame.getContentPane().add(btnFood1);
		
		JButton btnFood2 = new JButton("Burger");
		btnFood2.setFont(new Font("URW Gothic L", Font.BOLD, 13));
		btnFood2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblName.setText(game.getOutpostFoodItems().get(2).getName());
				lblHealth.setText("Health: " + game.getOutpostFoodItems().get(2).getHealth() + "%");
				lblAttribute.setText("Hunger: " + game.getOutpostFoodItems().get(2).getHunger() + "%");
				lblPrice.setText("Price: $"  + game.getOutpostFoodItems().get(2).getPrice());
			}
		});
		btnFood2.setBounds(260, 72, 103, 55);
		frame.getContentPane().add(btnFood2);
		
		JButton btnFood3 = new JButton("Chocolate");
		btnFood3.setFont(new Font("URW Gothic L", Font.BOLD, 13));
		btnFood3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblName.setText(game.getOutpostFoodItems().get(3).getName());
				lblHealth.setText("Health: " + game.getOutpostFoodItems().get(3).getHealth() + "%");
				lblAttribute.setText("Hunger: " + game.getOutpostFoodItems().get(3).getHunger() + "%");
				lblPrice.setText("Price: $"  + game.getOutpostFoodItems().get(3).getPrice());
			}
		});
		btnFood3.setBounds(10, 130, 122, 58);
		frame.getContentPane().add(btnFood3);
		
		JButton btnFood4 = new JButton("Noodles");
		btnFood4.setFont(new Font("URW Gothic L", Font.BOLD, 13));
		btnFood4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblName.setText(game.getOutpostFoodItems().get(4).getName());
				lblHealth.setText("Health: " + game.getOutpostFoodItems().get(4).getHealth() + "%");
				lblAttribute.setText("Hunger: " + game.getOutpostFoodItems().get(4).getHunger() + "%");
				lblPrice.setText("Price: $"  + game.getOutpostFoodItems().get(4).getPrice());
			}
		});
		btnFood4.setBounds(134, 130, 124, 58);
		frame.getContentPane().add(btnFood4);
		
		JButton btnFood5 = new JButton("Steak");
		btnFood5.setFont(new Font("URW Gothic L", Font.BOLD, 13));
		btnFood5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblName.setText(game.getOutpostFoodItems().get(5).getName());
				lblHealth.setText("Health: " + game.getOutpostFoodItems().get(5).getHealth() + "%");
				lblAttribute.setText("Hunger: " + game.getOutpostFoodItems().get(5).getHunger() + "%");
				lblPrice.setText("Price: $"  + game.getOutpostFoodItems().get(5).getPrice());
			}
		});
		btnFood5.setBounds(260, 130, 103, 58);
		frame.getContentPane().add(btnFood5);
		
		JLabel lblMedicalForSale = new JLabel("Meds for Sale:");
		lblMedicalForSale.setFont(new Font("Futura", Font.BOLD, 13));
		lblMedicalForSale.setForeground(new Color(255, 228, 225));
		lblMedicalForSale.setBounds(18, 200, 172, 16);
		frame.getContentPane().add(lblMedicalForSale);
		
		JButton btnMedical0 = new JButton("Small Bandage");
		btnMedical0.setFont(new Font("URW Gothic L", Font.BOLD, 12));
		btnMedical0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblName.setText(game.getOutpostMedicalItems().get(0).getName());
				lblHealth.setText("Health: " + game.getOutpostMedicalItems().get(0).getHealth() + "%");
				lblAttribute.setText("Cure: " + game.getOutpostMedicalItems().get(0).getCure());
				lblPrice.setText("Price: $"  + game.getOutpostMedicalItems().get(0).getPrice());
			}
		});
		btnMedical0.setBounds(10, 221, 122, 58);
		frame.getContentPane().add(btnMedical0);
		
		JButton btnMedical1 = new JButton("Large Bandage");
		btnMedical1.setFont(new Font("URW Gothic L", Font.BOLD, 12));
		btnMedical1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblName.setText(game.getOutpostMedicalItems().get(1).getName());
				lblHealth.setText("Health: " + game.getOutpostMedicalItems().get(1).getHealth() + "%");
				lblAttribute.setText("Cure: " + game.getOutpostMedicalItems().get(1).getCure());
				lblPrice.setText("Price: $"  + game.getOutpostMedicalItems().get(1).getPrice());
			}
		});
		btnMedical1.setBounds(134, 221, 124, 58);
		frame.getContentPane().add(btnMedical1);
		
		JButton btnMedical2 = new JButton("Cure");
		btnMedical2.setFont(new Font("URW Gothic L", Font.BOLD, 13));
		btnMedical2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblName.setText(game.getOutpostMedicalItems().get(2).getName());
				lblHealth.setText("Health: " + game.getOutpostMedicalItems().get(2).getHealth() + "%");
				lblAttribute.setText("Cure: " + game.getOutpostMedicalItems().get(2).getCure());
				lblPrice.setText("Price: $"  + game.getOutpostMedicalItems().get(2).getPrice());
			}
		});
		btnMedical2.setBounds(260, 221, 103, 58);
		frame.getContentPane().add(btnMedical2);
		
		JButton btnSpaceship = new JButton("Check Inventory");
		btnSpaceship.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchInventoryScreen();
			}
		});
		btnSpaceship.setBounds(16, 320, 269, 52);
		frame.getContentPane().add(btnSpaceship);
		
		JButton btnInventory = new JButton("Return to Spaceship");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
				game.launchSpaceshipScreen();
			}
		});
		btnInventory.setBounds(373, 320, 269, 52);
		frame.getContentPane().add(btnInventory);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(OutpostScreen.class.getResource("/img/rsz_nicholas-koo-v8.jpg")));
		lblImg.setBounds(0, 0, 667, 389);
		frame.getContentPane().add(lblImg);
		
	
		
	}
}
