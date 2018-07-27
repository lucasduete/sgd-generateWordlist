package io.github.lucasduete.sgd.gererateWordlist.core;

import io.github.lucasduete.sgd.gererateWordlist.factories.WordlistFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TechniqueColapseWordlists implements GenerateTechnique {

    @Override
    public List<String> generateWordlist() {
        WordlistFactory wordlistFactory = new WordlistFactory();

        String[] wordlist1;

        try {

            wordlist1 = wordlistFactory.generateWordlist();
        } catch (IOException ex) {

            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }

        String[] wordlist2 = wordlist1;
        List<String> finalWordlist = new ArrayList<>();

        for (int i = 0; i < wordlist1.length; i++) {

            for (int j = 0; j < wordlist2.length; j++) {

                String word = wordlist1[i] + wordlist2[j];
                if (word.length() == 8) finalWordlist.add(word);
            }
        }

        return finalWordlist;
    }

}
