/*

Homework #3

Due Date: 2/24/2019

Names: Ryan Schoenlein, Ben McDonald

*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

// 3x3 board of buttons
public class GamePanel extends JPanel {

	public JButton[][] grid = new JButton[5][3]; // grid of buttons
	int turn = 1; // keep track of which players turn
	boolean gameOver = false; // keep track of winning board
	String winner = "";

	public GamePanel() {
		buildGameMap();
	}

        // create buttons
	public void buildGameMap() {
		setLayout(new GridLayout(3, 3));
                
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (c == 0 && r == 4) {
					grid[r][c] = new JButton("");
				}

				else {
					grid[r][c] = new JButton("");
                                        grid[r][c].setFont(new Font("Dialog", Font.BOLD, 24));
					grid[r][c].addActionListener(new Gridlistener());
					grid[r][c].setEnabled(false);
					add(grid[r][c]);
				}

			}
		}

	}

        // update buttons with x's or o's
	private class Gridlistener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Some code to change a specific button
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					if (e.getSource() == grid[r][c]) {
					
						if (grid[r][c].getText() == "") {
							if (turn == 2) {
								grid[r][c].setText("O");
								checkForWin(r, c, "O");

								turn = 1;

							}

							else {
								grid[r][c].setText("X");
								checkForWin(r, c, "X");

								turn = 2;

							}
						}
					}
				}
			}
			
			
		}
	}

        // check if 3 x's or o's in a line
	private void checkForWin(int x, int y, String s) {
		

		// check end conditions

		// check col
		for (int i = 0; i < 3; i++) {
			if (grid[x][i].getText() != s)
				break;
			if (i == 3 - 1) {
				gameOver = true;

				if (grid[x][i].getText() == "X")
					winner = "Player 1";
				else
					winner = "Player 2";
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						grid[r][c].setEnabled(false);
					}
				}
			}
		}

		// check row
		for (int i = 0; i < 3; i++) {
			if (grid[i][y].getText() != s)
				break;
			if (i == 3 - 1) {
				gameOver = true;

				if (grid[i][y].getText() == "X")
					winner = "Player 1";
				else
					winner = "Player 2";

				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						grid[r][c].setEnabled(false);
					}
				}

			}
		}

		// check diag
		if (x == y) {
			// we're on a diagonal
			for (int i = 0; i < 3; i++) {
				if (grid[i][i].getText() != s)
					break;
				if (i == 3 - 1) {
					gameOver = true;

					if (grid[i][i].getText() == "X")
						winner = "Player 1";
					else
						winner = "Player 2";
					for (int r = 0; r < 3; r++) {
						for (int c = 0; c < 3; c++) {
							grid[r][c].setEnabled(false);
						}
					}
				}

			}
		}

		// check anti diag (thanks rampion)
		if (x + y == 3 - 1) {
			for (int i = 0; i < 3; i++) {
				if (grid[i][(3 - 1) - i].getText() != s)
					break;
				if (i == 3 - 1) {
					gameOver = true;

					if (grid[i][(3 - 1) - i].getText() == "X")
						winner = "Player 1";
					else
						winner = "Player 2";
					for (int r = 0; r < 3; r++) {
						for (int c = 0; c < 3; c++) {
							grid[r][c].setEnabled(false);
						}
					}
				}
			}
		}
	}

}
