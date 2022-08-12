package org.example;

import java.util.Arrays;

public class ConsoleFormatter {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_BG = 	"\u001B[47m";
    public static final String ANSI_GREEN_BG = "\u001B[42m";
    public static final String ANSI_RED_BG = "\u001B[41m";
    public static final String ANSI_BLUE_BG = "\u001B[44m";
    public static final String ANSI_BLACK_BG = "\u001B[40m";
    public static final String ANSI_BLACK = "\u001B[30m";

    public static void correctGuessFormatter(char[] arr) {
        String leftAlignFormat = "| %-10s |%n";
        System.out.format(ANSI_BLACK_BG + "|+-+-+-+-+-+-+-+-+-+-+-+-+-+-+|%n" + ANSI_RESET);
        System.out.format(ANSI_BLACK_BG + leftAlignFormat,ANSI_GREEN_BG + ANSI_BLACK + "Correct: " + Arrays.toString(arr).replace(",", ""), ANSI_RESET);
        System.out.format( ANSI_BLACK_BG + "|+-+-+-+-+-+-+-+-+-+-+-+-+-+-+|%n" + ANSI_RESET);
    }

    public static String hangman(int lives) {
        String hang = "";
//        int count = 0;
//        for(char c : arr) {
//            if(c != '_') count++;
//        }
        switch(lives) {
           case 7:
                hang = "\n" + "\n|" + "\n|" + "\n|" + "\n|" + "\n|" + "\n|_______________________\n";
                break;
            case 6:
                hang = "\n_______________________" + "\n|" + "\n|" + "\n|" + "\n|" + "\n|" + "\n|_______________________\n";
                break;
            case 5:
                hang =  "\n_______________________" + "\n|                   |" + "\n|" + "\n|" + "\n|" + "\n|" + "\n|_______________________\n";
                break;
            case 4:
                hang =  "\n_______________________" + "\n|                   |" + "\n|                  O" + "\n|" + "\n|" + "\n|" + "\n|_______________________\n";
                break;
            case 3:
                hang =  "\n_______________________" + "\n|                   |" + "\n|                  O" + "\n|                   |" + "\n|" + "\n|" + "\n|_______________________\n";
                break;
            case 2:
                hang =  "\n_______________________" + "\n|                   |" + "\n|                  O" + "\n|                 /|" + "\n|" + "\n|" + "\n|_______________________\n";
                break;
            case 1:
                hang =  "\n_______________________" + "\n|                   |" + "\n|                  O" + "\n|                 /|\\" + "\n|" + "\n|" + "\n|_______________________\n";
                break;
            case 0:
                hang = "\n_______________________" + "\n|                   |" + "\n|                  O" + "\n|                 /|\\" + "\n|                  /\\" + "\n|                " + "\n|_______________________\n";
                break;
        }

        return hang;
    }
    public static void wrongGuessFormatter(char[] arr) {
        String leftAlignFormat = "| %-26s |%n";
        System.out.format(ANSI_BLACK_BG + "x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x%n" + ANSI_RESET);
        System.out.format(ANSI_BLACK_BG + leftAlignFormat, ANSI_RED_BG + ANSI_BLACK + "Incorrect: " + Arrays.toString(arr).replace(",", ""), ANSI_RESET);
        System.out.format(ANSI_BLACK_BG + "x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x%n" + ANSI_RESET);
    }

}
