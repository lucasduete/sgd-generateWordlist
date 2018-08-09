package io.github.lucasduete.sgd.gererateWordlist.core;

import io.github.lucasduete.sgd.gererateWordlist.factories.WordlistFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TechniqueColapseWordlistsWithPadding implements GenerateTechnique {

    @Override
    public List<String> generateWordlist() {
        WordlistFactory wordlistFactory = new WordlistFactory();

        String[] tempWordlist;

        try {

            tempWordlist = wordlistFactory.generateWordlist();
        } catch (IOException ex) {

            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }

        List<String> wordlist1 = new ArrayList<>();

        for (int i = 0; i < tempWordlist.length; i++)
            wordlist1.add(tempWordlist[i]);

        List<String> wordlist2 = new ArrayList<>(wordlist1);
        List<String> finalWordlist = new ArrayList<>();

        for (String word1: wordlist1) {
            if (word1.length() > 3) {
                for (int i = 3; (i < word1.length() && i <= 6); i++) {
                    for(String word2 : wordlist2)
                        finalWordlist.add(String.copyValueOf(word1.toCharArray(), 0, i) + word2);
                }

            } else {
                for(String word2 : wordlist2)
                    finalWordlist.add(word1 + word2);
            }
        }

        return finalWordlist;
    }

}
