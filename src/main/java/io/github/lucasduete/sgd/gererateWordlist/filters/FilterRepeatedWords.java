package io.github.lucasduete.sgd.gererateWordlist.filters;

import io.github.lucasduete.sgd.gererateWordlist.Filter;

import java.util.Arrays;

public class FilterRepeatedWords implements Filter {

    @Override
    public String[] filtering(String[] words) {

        String[] arrayWithouRepetition = new String[words.length];
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            if (!alreadyExists(words[i], arrayWithouRepetition)) {
                arrayWithouRepetition[count++] = words[i];
            }
        }

        return Arrays.copyOfRange(arrayWithouRepetition, 0, count);
    }

    private boolean alreadyExists(String word, String[] arrayWithouRepetition) {

        for (int i = 0; i < arrayWithouRepetition.length; i++)
            if (word.equals(arrayWithouRepetition[i])) return true;


        return false;
    }
}
