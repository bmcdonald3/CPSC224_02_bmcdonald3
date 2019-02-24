/*

Homework #3

Due Date: 2/24/2019

Names: Ryan Schoenlein, Ben McDonald

*/

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// main file
public class TicTacToeGUI extends JFrame {
	private GamePanel gPanel; // Game panel
	private PlayerPanel pPanel1; // Player info panel
	private PlayerPanel pPanel2; // Player info panel
	private JLabel status; // Game state status

	JButton exitButton;
	JButton resetButton;
	JButton newGameButton;

	public TicTacToeGUI() {
		// Display a title.
		setTitle("Tic Tac Toe");
		setSize(500, 500);

		// Specify an action for the close button.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a BorderLayout manager.
		setLayout(new BorderLayout());

		// Create the custom panels.
		gPanel = new GamePanel();
		JPanel panel = new JPanel();
		pPanel1 = new PlayerPanel(1, "");
		pPanel2 = new PlayerPanel(2, "");

		// Add the components to the content pane.
		panel.add(pPanel1, BorderLayout.EAST);
		panel.add(pPanel2, BorderLayout.WEST);
		add(panel, BorderLayout.NORTH);
		add(gPanel, BorderLayout.CENTER);

		addGameButtons();

		// Pack the contents of the window and display it.
		//pack();
		setVisible(true);
	}

        // create buttons that arent the 3x3 game board
	public ButtonGroup addGameButtons() {

		newGameButton = new JButton("New Game");
		resetButton = new JButton("Reset");
		exitButton = new JButton("Exit");

		newGameButton.addActionListener(new GameListener());
		resetButton.addActionListener(new GameListener());
		exitButton.addActionListener(new GameListener());

		ButtonGroup bg = new ButtonGroup();
		bg.add(exitButton);
		bg.add(newGameButton);
		bg.add(resetButton);

		JPanel temp = new JPanel();
		temp.setLayout(new BorderLayout());
		temp.add(newGameButton, BorderLayout.LINE_START);
		temp.add(resetButton, BorderLayout.CENTER);
		temp.add(exitButton, BorderLayout.LINE_END);

		status = new JLabel("Welcome to Tic Tac Toe");
		temp.add(status, BorderLayout.SOUTH);
		add(temp, BorderLayout.SOUTH);

		return bg;
	}

        // listener for all buttons except for the game board
	private class GameListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {                  
			pPanel1.setName(pPanel1.getNameField().getText());
			pPanel2.setName(pPanel2.getNameField().getText());
			if (e.getSource() == exitButton) {
				System.exit(0);
			}

			else if (e.getSource() == newGameButton) {
				if(pPanel1.getName()!= "" || pPanel2.getName() != "") {
                                    for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						// gPanel.gameOver = false;
						gPanel.grid[r][c].setEnabled(true);
						gPanel.grid[r][c].setText("");
					}
				}
				}
                                else{                                  
                                    JOptionPane optionPane = new JOptionPane("Illegal Names", JOptionPane.ERROR_MESSAGE);    
                                    JDialog dialog = optionPane.createDialog("Failure");
                                    dialog.setAlwaysOnTop(true);
                                    dialog.setVisible(true);				
                                }
			}

			if (e.getSource() != resetButton) {
				if (gPanel.gameOver) {
					// change status label and PlayerPanel wins/losses
					status.setText("Game Over" + " Winner is " + gPanel.winner);

					if (gPanel.winner == "Player 1") {
						pPanel1.wins++;
						pPanel2.losses++;
					} else {
						pPanel2.wins++;
						pPanel1.losses++;

					}

					gPanel.gameOver = false;
				}

				if (gPanel.turn == 1) {
					status.setText(pPanel1.getName() + " 's turn");
				} else {
					status.setText(pPanel2.getName() + " 's turn");
				}
			}

			// reset stats and gameboard
			else if (e.getSource() == resetButton) {
				
				// output text box to ask user to confirm reset
				JOptionPane jop = new JOptionPane();
				int dialog = 0;
			

				if (jop.showConfirmDialog(null, "Are you sure you want to set win/loss stats to 0?", "WARNING",
						jop.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						pPanel1.wins = 0;
						pPanel1.losses = 0;
						pPanel2.wins = 0;
						pPanel2.losses = 0;
						pPanel1.winLoss.setText("Wins: " + pPanel1.wins + "\nLosses: " + pPanel1.losses);
						pPanel2.winLoss.setText("Wins: " + pPanel2.wins + "\nLosses: " + pPanel2.losses);
						pPanel1.setName(pPanel1.getNameField().getText());
						pPanel2.setName(pPanel2.getNameField().getText());
					
					//change game grid
					for (int r = 0; r < 3; r++) {
						for (int c = 0; c < 3; c++) {

								gPanel.grid[r][c].setEnabled(false);
								gPanel.grid[r][c].setText("");
						
						}
					}
					

					if(!(jop == null)) {
						jop.setVisible(false);
					}
						
				} 
				else {
					if(!(jop == null)) {
						jop.setVisible(false);

					}
				}

			}
			
			// update wins and losses
			pPanel1.winLoss.setText("Wins: " + pPanel1.wins + "\nLosses: " + pPanel1.losses);
			pPanel2.winLoss.setText("Wins: " + pPanel2.wins + "\nLosses: " + pPanel2.losses);
		}
	}

	public static void main(String[] args) {
		new TicTacToeGUI();

	}
}