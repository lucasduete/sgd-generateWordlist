package io.github.lucasduete.sgd.gererateWordlist.core;

import io.github.lucasduete.sgd.gererateWordlist.factories.WordlistFactory;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TechniqueColapseWords implements GenerateTechnique {

    @Override
    public List<String> generateWordlist() {
        WordlistFactory wordlistFactory = new WordlistFactory();

        String[] wordlist;

        try {

            wordlist = wordlistFactory.generateWordlist();
        } catch (IOException ex) {

            ex.printStackTrace();
            return Collections.EMPTY_LIST;
        }

        List<String> wordsLength1 = new ArrayList<>();
        List<String> wordsLength2 = new ArrayList<>();
        List<String> wordsLength3 = new ArrayList<>();
        List<String> wordsLength4 = new ArrayList<>();
        List<String> wordsLength5 = new ArrayList<>();
        List<String> wordsLength6 = new ArrayList<>();
        List<String> wordsLength7 = new ArrayList<>();
        List<String> wordsLength8 = new ArrayList<>();

        List<String> finalWordlist = new ArrayList<>();

        for (String word: wordlist) {
            switch (word.length()) {
                case 1:
                    wordsLength1.add(word);
                    break;
                case 2:
                    wordsLength2.add(word);
                    break;
                case 3:
                    wordsLength3.add(word);
                    break;
                case 4:
                    wordsLength4.add(word);
                    break;
                case 5:
                    wordsLength5.add(word);
                    break;
                case 6:
                    wordsLength6.add(word);
                    break;
                case 7:
                    wordsLength7.add(word);
                    break;
                case 8:
                    wordsLength8.add(word);
                    break;
            }
        }

        if (wordsLength8.size() > 0)
            finalWordlist.addAll(wordsLength8);

        if (wordsLength7.size() > 0 && wordsLength1.size() > 0)
            wordsLength7.forEach(word7 ->
                    wordsLength1.forEach(word1 -> {
                        finalWordlist.add(word7 + word1);
                        finalWordlist.add(word1 + word7);
                    })
            );

        if (wordsLength6.size() > 0 && wordsLength2.size() > 0)
            wordsLength6.forEach(word6 ->
                    wordsLength2.forEach(word2 -> {
                        finalWordlist.add(word6 + word2);
                        finalWordlist.add(word2 + word6);
                    })
            );

        if (wordsLength6.size() > 0 && wordsLength1.size() >= 2)
            wordsLength6.forEach(word6 ->
                    wordsLength1.forEach(word1Superior ->
                        wordsLength1.forEach(word1Inferior -> {
                            finalWordlist.add(word6 + word1Superior + word1Inferior);
                            finalWordlist.add(word6 + word1Inferior + word1Superior);
                            finalWordlist.add(word1Superior + word1Inferior + word6);
                            finalWordlist.add(word1Inferior + word1Superior + word6);
                            finalWordlist.add(word1Superior + word6 + word1Inferior);
                            finalWordlist.add(word1Inferior + word6 + word1Superior);
                        })
                    )
            );

        if (wordsLength5.size() > 0 && wordsLength3.size() > 0)
            wordsLength5.forEach(word5 ->
                    wordsLength3.forEach(word3 -> {
                        finalWordlist.add(word5 + word3);
                        finalWordlist.add(word3 + word5);
                    })
            );

        return finalWordlist;
    }
}
