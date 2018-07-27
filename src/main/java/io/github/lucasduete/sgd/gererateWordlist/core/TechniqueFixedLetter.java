package io.github.lucasduete.sgd.gererateWordlist.core;

import io.github.lucasduete.sgd.gererateWordlist.factories.WordlistFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TechniqueFixedLetter implements GenerateTechnique {

    @Override
    public List<String> generateWordlist() {
        char[] textoChar = new char[0];

        try {

            textoChar = wordlistToCharArray();
        } catch (IOException ex) {

            ex.printStackTrace();
            return Collections.emptyList();
        }


        List<String> wordlist = new ArrayList<>();

        for (int i = 0; i < (textoChar.length - 7); i++)
            wordlist.add(generateString(textoChar, i, 8));

        return wordlist;
    }

    private char[] wordlistToCharArray() throws IOException {
        WordlistFactory factory = new WordlistFactory();
        String[] wordlist = factory.generateWordlist();

        return wordlist
                .toString()
                .toCharArray();
    }

    private static String generateString(char[] textoChar, int initialPosition, int quantCaracters) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < quantCaracters; i++)
            stringBuilder.append(textoChar[initialPosition + i]);

        return stringBuilder.toString();
    }

}
