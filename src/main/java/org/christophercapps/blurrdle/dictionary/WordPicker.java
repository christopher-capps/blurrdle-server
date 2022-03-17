package org.christophercapps.blurrdle.dictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordPicker {

    public String pickWord(List<String> dictionary) {
        Collections.shuffle(dictionary);
        String pickedWord = dictionary.get(0);
        return pickedWord;
    }

    public String pickWordBySize(List<String> dictionary, int wordLength) {
        String pickedWord = null;
        boolean isTheRightSize = false;
        while (!isTheRightSize) {
            pickedWord = pickWord(dictionary);
            if (pickedWord.length() == wordLength) {
                isTheRightSize = true;
            }
        }
        return pickedWord;
    }

    public List<String> buildDictionary(List<String> dictionary) {

        List<String> builtDictionary = new ArrayList<>();
        String word = null;

        while (dictionary.size() > 500) {
            word = pickWordBySize(dictionary, 4);
            builtDictionary.add(word);
            dictionary.remove(word);

            word = pickWordBySize(dictionary, 4);
            builtDictionary.add(word);
            dictionary.remove(word);

            word = pickWordBySize(dictionary, 5);
            builtDictionary.add(word);
            dictionary.remove(word);

            word = pickWordBySize(dictionary, 5);
            builtDictionary.add(word);
            dictionary.remove(word);

            word = pickWordBySize(dictionary, 6);
            builtDictionary.add(word);
            dictionary.remove(word);

            word = pickWordBySize(dictionary, 6);
            builtDictionary.add(word);
            dictionary.remove(word);

            word = pickWordBySize(dictionary, 7);
            builtDictionary.add(word);
            dictionary.remove(word);
        }

        return builtDictionary;
    }

}
