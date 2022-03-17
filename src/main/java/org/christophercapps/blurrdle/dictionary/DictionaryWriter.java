package org.christophercapps.blurrdle.dictionary;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DictionaryWriter {

    public boolean printDictionary(List<String> dictionary, String logPath) {
        File file = new File(logPath);

        try(FileOutputStream outputStream = new FileOutputStream(file, true);
            PrintWriter writer = new PrintWriter(outputStream)) {

            for (String word : dictionary) {
                writer.println(word);
            }

        } catch(IOException e) {
            return false;
        }

        return true;
    }

}
