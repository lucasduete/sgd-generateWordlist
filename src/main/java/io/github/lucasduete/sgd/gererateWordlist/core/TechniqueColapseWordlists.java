package io.github.lucasduete.sgd.gererateWordlist.core;

import io.github.lucasduete.sgd.gererateWordlist.factories.WordlistFactory;

import java.io.IOException;

public class TechniqueColapseWordlists implements GenerateTechnique {

    @Override
    public String[] generateWordlist() {
        WordlistFactory wordlistFactory = new WordlistFactory();

        String[] wordlist1 = new String[1];

        try {

            wordlist1 = wordlistFactory.generateWordlist();
        } catch (IOException ex) {

            ex.printStackTrace();
            return wordlist1;
        }

        String[] wordlist2 = wordlist1;
        String[] finalWordlist = new String[wordlist1.length*wordlist2.length];

        int c = 0;
        for (int i = 0; i < wordlist1.length; i++) {

            for (int j = 0; j < wordlist2.length; j++) {

                finalWordlist[c] = wordlist1[i] + wordlist2[j];

                if (finalWordlist[c].length() != 8) finalWordlist[c] = null;

                c++;
            }
        }

        int count = 0;
        for (String word : finalWordlist) {
            if (word != null) {
                System.out.println(word);
                count++;
            }
        }

        System.out.println("Wordlist total: " + count);

        return finalWordlist;
    }

}
