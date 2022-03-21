package org.christophercapps.blurrdle.dictionary;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.DAYS;

@Component
public class DictionaryReader {
    private final LocalDate START_DATE = LocalDate.of(2022, 3, 13);

    public String getAnswer() {

        String dictionaryPath = "answers.txt";
        File inputFile = new File(dictionaryPath);
        List<String> dictionary = new ArrayList<>();

        try (Scanner inputScanner = new Scanner(inputFile)) {
            while (inputScanner.hasNextLine()) {

                String line = inputScanner.nextLine();
                String[] words = line.split(" ");
                String finalWord = "";
                for (String word: words) {
                    for (int i = 0; i < word.length(); i++) {
                        if (Character.isLetter(word.charAt(i))) {
                            finalWord += word.charAt(i);
                        }
                    }
                    dictionary.add(finalWord);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: DICTIONARY FILE NOT FOUND");
        }

        int puzzleNumber = (int) (DAYS.between(START_DATE, LocalDate.now()) - 1);

        return dictionary.get(puzzleNumber);
    }

}
