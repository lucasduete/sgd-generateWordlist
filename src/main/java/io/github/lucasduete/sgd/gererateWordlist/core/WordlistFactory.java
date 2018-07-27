package io.github.lucasduete.sgd.gererateWordlist.core;

import io.github.lucasduete.sgd.gererateWordlist.Filter;
import io.github.lucasduete.sgd.gererateWordlist.filters.FilterAccentuation;
import io.github.lucasduete.sgd.gererateWordlist.filters.FilterLowerCase;
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

        return wordlist;
    }

    private String readFileContent(InputStream in) throws IOException {

        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        int readed = 0;

        do {

            byte[] byteArray = new byte[1];
            readed = in.read(byteArray);
            byteOutputStream.write(byteArray);
        } while(readed != -1);

        byte[] resulting = byteOutputStream.toByteArray();

        return new String(resulting);
    }
}
