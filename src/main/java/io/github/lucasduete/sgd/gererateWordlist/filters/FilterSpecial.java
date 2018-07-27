package io.github.lucasduete.sgd.gererateWordlist.filters;

import io.github.lucasduete.sgd.gererateWordlist.Filter;

public class FilterSpecial implements Filter {

    // \n - new line
    // \r - return carrier
    // \t - tab
    // \s - space
	public String[] filtering(String[] words) {

		int countEmpty = 0;

		for (int i = 0; i < words.length; i++) {

			String word = words[i];

			word = word
					.replaceAll("\n", "")
					.replaceAll("\r", "")
					.replaceAll("\t", "");

			if (word.isEmpty()) {

				words[i] = null;
				countEmpty++;
			} else {

				words[i] = word;
			}
		}

		int i = 0;
		String[] result = new String[words.length - countEmpty];

		for (String word : words) {

			if (word == null) continue;

			result[i++] = word;
		}

		return result;
	}

}
