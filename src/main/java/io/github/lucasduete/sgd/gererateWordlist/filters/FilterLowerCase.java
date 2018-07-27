package io.github.lucasduete.sgd.gererateWordlist.filters;

import io.github.lucasduete.sgd.gererateWordlist.Filter;

public class FilterLowerCase implements Filter {

	public String[] filtering(String[] words) {

		for (int i = 0; i < words.length; i++) {

			String word = words[i];
			words[i] = word.toLowerCase();
		}

		return words;
	}

}
