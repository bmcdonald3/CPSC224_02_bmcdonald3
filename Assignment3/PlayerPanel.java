/*

Homework #3

Due Date: 2/24/2019

Names: Ryan Schoenlein, Ben McDonald

*/

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.*;

// top panel with game statistics
public class PlayerPanel extends JPanel {
	private JLabel nameLabel, title; // To display labels and player info
	public JTextArea winLoss;
	private JTextField nameField; // player name
	public int wins, losses;
	private String name;
	private int playerNumber;// to determine if player one or tow

	/**
	 * Constructor
	 */

	public PlayerPanel(int playerNumber, String name) {
		
		setLayout(new BorderLayout());

		this.playerNumber = playerNumber;
		this.name = name;
		wins = 0;
		losses = 0;

		if (playerNumber == 1) {
			title = new JLabel("Player 1(X)");
		} else {
			title = new JLabel("Player 2(0)");
		}

		// create panel objects
		nameField = new JTextField(name, 8);
		nameLabel = new JLabel("Name: ");

		winLoss = new JTextArea("Wins: " + wins + "\nLosses: " + losses);
		winLoss.setEditable(false);

		// add objects to panel
		add(winLoss, BorderLayout.SOUTH);
		add(nameLabel, BorderLayout.WEST);
		add(getNameField(), BorderLayout.CENTER);

		add(title, BorderLayout.NORTH);
	}

	//getters and setters for name and nameField
	public String getName() {
		return name;
	}

	public void setName(String s) {
		this.name = s;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}
}
