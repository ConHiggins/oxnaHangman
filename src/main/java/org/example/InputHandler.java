package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InputHandler {

    public ArrayList<String> userWord = new ArrayList<>();

    public ArrayList sortGuess(ArrayList<String> wordGuess, char[] correctWord) {
        String guessString = String.join(",", wordGuess);
        char[] guessChars = guessString.toCharArray();
        ArrayList guessSorted = new ArrayList<>();
        for (char guessChar : guessChars) {
            guessSorted.add(guessChar);
        }
        return guessSorted;
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess lowercase letter/word: ");
        String input = scanner.nextLine();
        char[] inputArr = input.toCharArray();
        for(char c: inputArr) {
            if(c < 97 || c > 122) {
                input = "";
                System.out.println("ERROR: Invalid character, please guess using lowercase letters");
            }
        }
        return input;
    }

    public ArrayList<String> getUserGuess() {
        return userWord;
    }

    public char[] addCorrectGuess(ArrayList<String> guess, String input, char[] wordArr, char[] correctGuessed) {
        guess.add(input.toLowerCase());
        ArrayList sortGuess = sortGuess(guess, wordArr);
        for (int i = 0; i < correctGuessed.length; i++) {
            if (sortGuess.contains(wordArr[i])) {
                correctGuessed[i] = wordArr[i];
            }
        }
        return correctGuessed;
    }

    public char[] addWrongGuess(String input, char[] wrongGuessed, String word) {
        char[] inputChar = input.toLowerCase().toCharArray();
        for (int i = 0; i < inputChar.length; i++) {
            boolean newWrongGuess = (!word.contains(Character.toString(inputChar[i])) && (Arrays.toString(wrongGuessed).indexOf(inputChar[i]) == -1));
            if (newWrongGuess) {
                int emptyIndex = 0;
                ///Find next empty index
                for (int j = wrongGuessed.length - 1; j > -1; j--) {
                    if (wrongGuessed[j] == '_') {
                        emptyIndex = j;
                    }
                }
                wrongGuessed[emptyIndex] = inputChar[i];

            }
        }
        return wrongGuessed;
    }

}
