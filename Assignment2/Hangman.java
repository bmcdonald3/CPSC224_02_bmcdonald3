import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mcdob
 */
public class Hangman {
    public static void main(String[] args)
    {
        String[] words = {"hello","pizza","apple","sauce","horse"};
        menu(words);
    }
    
    public static void menu(String[] words)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu:" + "\n" + "1. Random Word\n" +
                "2. User entered word\n3. Exit game");
        int response = scanner.nextInt();
        if(response == 1)
        {
            playRandom(words);
        }
        else if(response == 2)
        {
        
        }
        else if (response == 3)
        {
            
        }
    }
    
    public static void playRandom(String[] words)
    {
        Scanner scanner = new Scanner(System.in);
        boolean isLetter = false;
        boolean isSolved = false;
        String input;
        char guess;
        int strikes = 0;
        Random R1 = new Random();
        int number = R1.nextInt(4) + 1; //Index of random word
        String wordToGuess = words[number];
        char[] userWord = {'-','-','-','-','-'};
        while(!isSolved && strikes < 6)
        {
            System.out.print("Word to guess:");
            printArr(userWord);
            System.out.println("Strikes: " + strikes);
            System.out.print("Enter letter:");
            input = scanner.next();
            guess = input.charAt(0);
            guess = Character.toLowerCase(guess);
            for(int i = 0; i < 5; i++)
            {
                if(guess == wordToGuess.charAt(i))
                {
                    userWord[i] = wordToGuess.charAt(i);
                    isLetter = true;
                }
            }
            if(!isLetter)
                strikes++;
            isLetter = false;
            isSolved = checkWin(wordToGuess, userWord);
        }
        if(isSolved)
            System.out.println("You win");
        else
            System.out.println("You lose.");
        System.out.println("The word to guess was: " + wordToGuess);
    }
    
    public static void printArr(char[] arr)
    {
        for(int i = 0; i < 5; i++)
            System.out.print(arr[i]);
        System.out.println();
    }
    
    public static boolean checkWin(String word, char[] guess)
    {
        for(int i = 0; i < 5; i++)
        {
            if(word.charAt(i) != guess[i])
                return false;
        }
        return true;
    }
}