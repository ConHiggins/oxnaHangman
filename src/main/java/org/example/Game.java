package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.example.ConsoleFormatter.*;

public class Game {

    int lives = 8;
    void decrementLives() {
        lives--;
    }
    public void gameplay() {

        final String word = new WordSelector().getRandomWord();
        final char[] wordArr = word.toCharArray();

        char[] correctGuessed = new char[wordArr.length];
        Arrays.fill(correctGuessed, '_');
        long uniqueChars = word.chars().distinct().count();

        char[] wrongGuessed = new char[26-(int)uniqueChars];
        Arrays.fill(wrongGuessed, '_');
        int playerWon = 0;

        ArrayList<String> guess = new InputHandler().getUserGuess();

        while (playerWon == 0) {
            String input = new InputHandler().getInput();

            if (word.contains(input.toLowerCase())) {
                correctGuessed = new InputHandler().addCorrectGuess(guess, input, wordArr, correctGuessed);
            } else {
                wrongGuessed = new InputHandler().addWrongGuess(input, wrongGuessed, word);
                decrementLives();
            }

            correctGuessFormatter(correctGuessed);
            System.out.println(ANSI_BLACK_BG +  hangman(lives) + ANSI_RESET);
            wrongGuessFormatter(wrongGuessed);


            boolean won = Arrays.equals(correctGuessed, wordArr);
            if (won) {
                playerWon = 1;
            }
        }
    }
}
