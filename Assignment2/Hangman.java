import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;

public class Hangman {

	public static void menu() {
		Scanner scanner = new Scanner(System.in);
		String in = JOptionPane.showInputDialog(null,
				"Menu:" + "\n" + "1. Random Word\n" + "2. User entered word\n3. Exit game");
		int response = Integer.parseInt(in);

		// Random word
		if (response == 1) {
			play("");
		}
		// user entered word
		else if (response == 2) {
			// only allow Strings
			String inString = "3";
			while (!inString.matches("[a-zA-Z]+")) {
				inString = JOptionPane.showInputDialog("Enter a word to guess: ");
			}

			play(inString);
		}
		// exit
		else {

		}
	}

	public static void play(String userWord) {
		Scanner scanner = new Scanner(System.in);
		String[] words = { "hello", "pizza", "apple", "sauce", "horse" };
		boolean isLetter = false;
		boolean isSolved = false;
		String input = "3";
		char guess = 0;
		int strikes = 0;
		String wordToGuess;

		// play with random word if no userWord passed in
		if (userWord == "") {
			Random R1 = new Random();
			int number = R1.nextInt(4) + 1; // Index of random word
			wordToGuess = words[number];
		}
		// else play with userWord
		else {
			wordToGuess = userWord;
		}

		char[] userGuesses = { '-', '-', '-', '-', '-' };
		while (!isSolved && strikes < 6) {
			String userGuessesStr = new String(userGuesses);
			JOptionPane.showMessageDialog(null, "Word to guess: " + userGuessesStr + " \nStrikes: " + strikes);

			
			//only allow letters as input
			input = JOptionPane.showInputDialog("Enter Letter: ");
			
			while(!input.matches("[a-zA-Z]+")){
				input = JOptionPane.showInputDialog("Enter Letter: ");
			}
			
			guess = input.charAt(0);

			guess = Character.toLowerCase(guess);
			for (int i = 0; i < 5; i++) {
				if (guess == wordToGuess.charAt(i)) {
					userGuesses[i] = wordToGuess.charAt(i);
					isLetter = true;
				}
			}
			if (!isLetter)
				strikes++;
			isLetter = false;
			isSolved = checkWin(wordToGuess, userGuesses);
		}
		if (isSolved)
			JOptionPane.showMessageDialog(null, "You Win.");
		else
			JOptionPane.showMessageDialog(null, "You Lose. " + "The word to guess was: " + wordToGuess);
	}

	public static boolean checkWin(String word, char[] guess) {
		for (int i = 0; i < 5; i++) {
			if (word.charAt(i) != guess[i])
				return false;
		}
		return true;
	}
}