package io.github.lucasduete.sgd.gererateWordlist;

import io.github.lucasduete.sgd.gererateWordlist.filters.FilterAccentuation;
import io.github.lucasduete.sgd.gererateWordlist.filters.FilterLowerCase;
import io.github.lucasduete.sgd.gererateWordlist.filters.FilterSpecial;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
	
	private static String readFileContent(InputStream in) throws IOException {

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
	
	private static String[] generateWordlist() throws IOException {

		File rawFile = new File("raw.txt");
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

	public static void main(String[] args) throws IOException {
		String[] wordlist1 = generateWordlist();
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
