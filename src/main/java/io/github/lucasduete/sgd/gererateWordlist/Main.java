package io.github.lucasduete.sgd.gererateWordlist;

import io.github.lucasduete.sgd.gererateWordlist.core.GenerateTechnique;
import io.github.lucasduete.sgd.gererateWordlist.core.TechniqueColapseWordlists;
import io.github.lucasduete.sgd.gererateWordlist.core.TechniqueFixedLetter;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

        GenerateTechnique generateTechnique = new TechniqueColapseWordlists();
        List<String> wordlistColapsed = generateTechnique.generateWordlist();

        generateTechnique = new TechniqueFixedLetter();
        List<String> wordlistFixedLetter = generateTechnique.generateWordlist();

        List<String> finalWordlist = new ArrayList<>();
        finalWordlist.addAll(wordlistColapsed);
        finalWordlist.addAll(wordlistFixedLetter);

        System.out.println("Wordlist total: " + finalWordlist.size());
    }

}
