package io.github.lucasduete.sgd.gererateWordlist;

import io.github.lucasduete.sgd.gererateWordlist.core.GenerateTechnique;
import io.github.lucasduete.sgd.gererateWordlist.core.TechniqueColapseWords;

import java.util.List;

public class Main {

	public static void main(String[] args) {

        GenerateTechnique generateTechnique = new TechniqueColapseWords();

        List<String> wordlist = generateTechnique.generateWordlist();

        System.out.println("Wordlist total: " + wordlist.size());
    }

}
