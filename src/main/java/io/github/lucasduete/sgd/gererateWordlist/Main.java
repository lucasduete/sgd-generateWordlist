package io.github.lucasduete.sgd.gererateWordlist;

import io.github.lucasduete.sgd.gererateWordlist.core.GenerateTechnique;
import io.github.lucasduete.sgd.gererateWordlist.core.TechniqueColapseWordlistsWithPadding;
import io.github.lucasduete.sgd.gererateWordlist.core.TechniqueColapseWords;
import io.github.lucasduete.sgd.gererateWordlist.exports.ExportFile;
import io.github.lucasduete.sgd.gererateWordlist.exports.ExportManager;

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) {

        GenerateTechnique generateTechnique = new TechniqueColapseWordlistsWithPadding();

        List<String> wordlist = generateTechnique.generateWordlist();

        try {

            ExportManager exportManager = new ExportFile();
            exportManager.export(wordlist);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("Wordlist total: " + wordlist.size());
    }

}
