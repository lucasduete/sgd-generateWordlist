package io.github.lucasduete.sgd.gererateWordlist.factories;

import io.github.lucasduete.sgd.gererateWordlist.Filter;
import io.github.lucasduete.sgd.gererateWordlist.filters.FilterAccentuation;
import io.github.lucasduete.sgd.gererateWordlist.filters.FilterLowerCase;
import io.github.lucasduete.sgd.gererateWordlist.filters.FilterRepeatedWords;
import io.github.lucasduete.sgd.gererateWordlist.filters.FilterSpecial;

import java.io.*;

public class WordlistFactory {

    public String[] generateWordlist() throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        File rawFile = new File(classLoader.getResource("raw.txt").getFile());

        FileInputStream fileInputStream = new FileInputStream(rawFile);

        // Read file
        String fileContent = readFileContent(fileInputStream);
        fileInputStream.close();

        // Define filter
        Filter filter;

        // Filtering - remove \n\r\t
        filter = new FilterSpecial();
        String[] wordlist = filter.filtering(fileContent.split("\\s"));

        // Filtering - remove àèìòù...
        filter = new FilterAccentuation();
        wordlist = filter.filtering(wordlist);

        // Filtering - replace ABC.. by abc...
        filter = new FilterLowerCase();
        wordlist = filter.filtering(wordlist);

        filter = new FilterRepeatedWords();
        wordlist = filter.filtering(wordlist);

        return wordlist;
    }

    private String readFileContent(InputStream in) throws IOException {

        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        byte[] byteArray = new byte[1];

        while(in.read(byteArray) != -1) {
            byteOutputStream.write(byteArray);
            byteArray = new byte[1];
        }

        byte[] resulting = byteOutputStream.toByteArray();

        return new String(resulting);
    }
}
