package io.github.lucasduete.sgd.gererateWordlist;

import io.github.lucasduete.sgd.gererateWordlist.core.GenerateTechnique;
import io.github.lucasduete.sgd.gererateWordlist.core.TechniqueColapseWordlists;

public class Main {

	public static void main(String[] args) {

        GenerateTechnique generateTechnique = new TechniqueColapseWordlists();
        generateTechnique.generateWordlist();
	}
	
}
