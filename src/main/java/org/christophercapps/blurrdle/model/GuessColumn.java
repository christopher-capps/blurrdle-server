package org.christophercapps.blurrdle.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GuessColumn {
    List<Character> possibleLetters;

    public GuessColumn() {
        this.possibleLetters = new ArrayList<>();
    }

    public List<Character> getPossibleLetters() {
        return possibleLetters;
    }

    public void setPossibleLetters(List<Character> possibleLetters) {
        this.possibleLetters = possibleLetters;
    }

    public void addLetter(Character letter) {
        if (!possibleLetters.contains(letter)) {
            possibleLetters.add(letter);
        }
    }
}
