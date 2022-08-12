package org.example;

import java.util.Random;

public class WordSelector {

    Random r = new Random();
    final private String[] words = {"pigeon", "turtle", "bucket", "potato", "diorama"};
    public String getRandomWord() {
        int randomWordIndex = r.nextInt(words.length);
        return words[randomWordIndex];
    }




}
