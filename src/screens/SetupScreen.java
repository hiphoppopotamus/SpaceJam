package screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;


import main.*;

import javax.swing.event.ChangeEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;

public class SetupScreen {

	private GameEnvironment game;
	private JFrame frame = new JFrame();
	private JLabel lblSetCrew = new JLabel("SET UP YOUR CREW");
	private JLabel lblCrewName = new JLabel("Crew:");
	private JLabel lblSpaceshipName = new JLabel("Spaceship Name:");
	private JLabel lblNumOfPieces = new JLabel("Number of Transporter Pieces:");
	private JLabel lblDayCount = new JLabel("Number of Days:");
	private JLabel lblCrewCount = new JLabel("Number of Crew Members:");
	private JTextField textFieldCrewName = new JTextField();
	private JTextField textFieldSpaceshipName = new JTextField();
	private JSlider sliderDays = new JSlider();
	private JSlider sliderCrewCount = new JSlider();
	private JButton btnNext = new JButton("Next");
	private JPanel panelBackground = new JPanel();
	private final JLabel lblImg = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreen window = new SetupScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SetupScreen(GameEnvironment incomingGame) {
		game = incomingGame;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		game.closeSetupScreen(this);
	}
	
	
	/**
	 * Create the application.
	 */
	public SetupScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setTitle("Setup Window");
		frame.setBounds(100, 100, 601, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

	
		lblSetCrew.setForeground(new Color(255, 160, 122));
		lblSetCrew.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetCrew.setFont(new Font("Phosphate", Font.PLAIN, 26));
		lblSetCrew.setBounds(6, 16, 589, 33);
		frame.getContentPane().add(lblSetCrew);
		
		lblCrewName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrewName.setForeground(new Color(255, 218, 185));	
		lblCrewName.setFont(new Font("Futura", Font.PLAIN, 18));
		lblCrewName.setBounds(65, 61, 148, 36);
		frame.getContentPane().add(lblCrewName);
		
		lblSpaceshipName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSpaceshipName.setForeground(new Color(255, 218, 185));
		lblSpaceshipName.setFont(new Font("Futura", Font.PLAIN, 18));
		lblSpaceshipName.setBounds(40, 94, 173, 42);
		frame.getContentPane().add(lblSpaceshipName);
		
		lblNumOfPieces.setForeground(new Color(255, 218, 185));	
		lblNumOfPieces.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumOfPieces.setFont(new Font("Futura", Font.PLAIN, 18));
		lblNumOfPieces.setBounds(6, 310, 589, 42);
		frame.getContentPane().add(lblNumOfPieces);
		
		lblDayCount.setForeground(new Color(255, 218, 185));
		lblDayCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDayCount.setFont(new Font("Futura", Font.PLAIN, 18));
		lblDayCount.setBounds(6, 221, 589, 42);
		frame.getContentPane().add(lblDayCount);
		
		lblCrewCount.setForeground(new Color(255, 218, 185));
		lblCrewCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewCount.setFont(new Font("Futura", Font.PLAIN, 18));
		lblCrewCount.setBounds(6, 141, 589, 42);
		frame.getContentPane().add(lblCrewCount);
		
		textFieldCrewName.setForeground(new Color(0, 0, 0));
		textFieldCrewName.setFont(new Font("Futura", Font.PLAIN, 18));
		textFieldCrewName.setBackground(new Color(230, 230, 250));
		textFieldCrewName.setBounds(219, 61, 278, 33);
		frame.getContentPane().add(textFieldCrewName);
		textFieldCrewName.setColumns(10);
		
		textFieldSpaceshipName.setForeground(new Color(0, 0, 0));
		textFieldSpaceshipName.setFont(new Font("Futura", Font.PLAIN, 18));
		textFieldSpaceshipName.setBackground(new Color(230, 230, 250));
		textFieldSpaceshipName.setBounds(219, 98, 278, 33);
		frame.getContentPane().add(textFieldSpaceshipName);
		textFieldSpaceshipName.setColumns(10);
		
		sliderDays.setForeground(new Color(255, 255, 255));
		sliderDays.setFont(new Font("Futura", Font.PLAIN, 14));
		sliderDays.setSnapToTicks(true);
		sliderDays.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				String transporterPieces = String.valueOf(sliderDays.getValue() * 2/3);
				lblNumOfPieces.setText("Number of Transporter Pieces: " + transporterPieces);
			}
		});
		sliderDays.setValue(3);
		sliderDays.setPaintLabels(true);
		sliderDays.setPaintTicks(true);
		sliderDays.setMinorTickSpacing(1);
		sliderDays.setMajorTickSpacing(1);
		sliderDays.setMinimum(3);
		sliderDays.setMaximum(10);
		sliderDays.setBounds(197, 254, 213, 50);
		sliderDays.setOpaque(false);
		frame.getContentPane().add(sliderDays);
		
		sliderCrewCount.setFont(new Font("Futura", Font.PLAIN, 14));
		sliderCrewCount.setForeground(new Color(224, 255, 255));
		sliderCrewCount.setSnapToTicks(true);
		sliderCrewCount.setValue(2);
		sliderCrewCount.setPaintLabels(true);
		sliderCrewCount.setPaintTicks(true);
		sliderCrewCount.setMinorTickSpacing(1);
		sliderCrewCount.setMajorTickSpacing(1);
		sliderCrewCount.setMinimum(2);
		sliderCrewCount.setMaximum(4);
		sliderCrewCount.setBounds(197, 175, 213, 50);
		sliderCrewCount.setOpaque(false);
		frame.getContentPane().add(sliderCrewCount);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				game.setCrew(textFieldCrewName.getText());
				game.setSpaceshipName(textFieldSpaceshipName.getText());
				game.setNumberOfDays(sliderDays.getValue());
				game.setCrewCount(sliderCrewCount.getValue());		
				game.setNumberOfPieces();
				game.setPlanets();
				game.setStartPlanet();
				game.setPrologueCrewTransporterPieces();
				finishedWindow();
			}
		});
		btnNext.setBounds(175, 364, 254, 39);
		frame.getContentPane().add(btnNext);
		
	
		panelBackground.setBounds(40, 50, 520, 306);
		panelBackground.setBackground(new Color(0, 0, 0, 100));
		frame.getContentPane().add(panelBackground);
		panelBackground.setLayout(null);
		
		lblImg.setIcon(new ImageIcon(SetupScreen.class.getResource("/img/rsz_crew.jpg")));
		lblImg.setBounds(0, 0, 601, 420);
		frame.getContentPane().add(lblImg);
		
	
	
		
		
	}
}
