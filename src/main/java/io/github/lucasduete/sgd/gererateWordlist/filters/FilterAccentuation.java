package io.github.lucasduete.sgd.gererateWordlist.filters;

import io.github.lucasduete.sgd.gererateWordlist.Filter;

public class FilterAccentuation implements Filter {

	public String[] filtering(String[] words) {
		for (int i = 0; i < words.length; i++) {

			String word = words[i];

			word = word.replaceAll("\\.", "")
					.replaceAll(":", "").replaceAll(",", "")
					.replaceAll("-", "").replaceAll("!", "")
					.replaceAll("ç", "c").replaceAll("é", "e")
					.replaceAll("É", "e")
					.replaceAll("ô", "o").replaceAll("ú", "u")
					.replaceAll("â", "a").replaceAll("ã", "a");

			words[i] = word;
		}

		return words;
	}

}
