package io.github.lucasduete.sgd.gererateWordlist.exports;

import java.util.List;

public class ExportTerminal implements ExportManager {

    @Override
    public void export(List<String> wordlist) {

        if (wordlist == null || wordlist.size() <= 0) System.out.println("WordList is Empty");
        else wordlist.forEach(System.out::println);
    }
}
