package io.github.lucasduete.sgd.gererateWordlist;

import io.github.lucasduete.sgd.gererateWordlist.core.WordlistFactory;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

        WordlistFactory wordlistFactory = new WordlistFactory();

		String[] wordlist1 = wordlistFactory.generateWordlist();
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

	}
	
}
