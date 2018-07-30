package io.github.lucasduete.sgd.gererateWordlist.exports;

import java.io.*;
import java.util.List;

public class ExportFile implements ExportManager {

    private final String FILE_NAME = "export.txt";

    public ExportFile() throws IOException {
        File file = new File(FILE_NAME);

        if (!file.exists())
            file.createNewFile();
    }

    public ExportFile(String userFileName) throws IOException {
        File file = new File(userFileName);

        if (!file.exists())
            file.createNewFile();
    }

    @Override
    public void export(List<String> wordlist) {

        try(PrintStream printStream = new PrintStream((this.FILE_NAME))) {

            wordlist.forEach(word -> printStream.println(word));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
