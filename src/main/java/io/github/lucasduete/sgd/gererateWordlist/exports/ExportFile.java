package io.github.lucasduete.sgd.gererateWordlist.exports;

import java.io.*;
import java.util.List;

public class ExportFile implements ExportManager {

    private final String FILE_NAME;

    public ExportFile() throws IOException {
        this.FILE_NAME = "export.txt";

        File file = new File(this.FILE_NAME);

        if (!file.exists())
            file.createNewFile();
    }

    public ExportFile(String fileName) throws IOException {
        this.FILE_NAME = fileName;

        File file = new File(this.FILE_NAME);

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
