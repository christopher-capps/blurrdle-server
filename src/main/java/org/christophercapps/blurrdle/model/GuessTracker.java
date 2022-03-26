package org.christophercapps.blurrdle.model;

import org.christophercapps.blurrdle.dictionary.DictionaryReader;
import org.christophercapps.blurrdle.dictionary.DictionaryReader;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GuessTracker {

    boolean isCorrect;
    String guess;
    List<GuessColumn> columns;
    List<String> guessHistory;

    private final DictionaryReader reader = new DictionaryReader();


    public GuessTracker() {
        this.isCorrect = false;
        this.guess = " ";
        columns = new ArrayList<>();
        guessHistory = new ArrayList<>();

        for (int i = 0; i < reader.getAnswer().length(); i++) {
            columns.add(new GuessColumn());
        }
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getGuess() {
        return guess.toUpperCase();
    }

    public void setGuess(String guess) {
        this.guess = guess.toUpperCase();
    }

    public List<GuessColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<GuessColumn> columns) {
        this.columns = columns;
    }

    public List<String> getGuessHistory() {
        return guessHistory;
    }

    public void setGuessHistory(List<String> guessHistory) {
        this.guessHistory = guessHistory;
    }


    public void addLetter(int column, Character letter) {
        columns.get(column).addLetter(letter);
    }

    public Character guessChar(int index) {
        return Character.toUpperCase(guess.charAt(index));
    }

    public void addToHistory(String guess) {
        guessHistory.add(guess);
    }



    @Override
    public String toString() {
        String output = rowsToString();
        for (int i = 0; i < guess.length(); i++) {
            output += "? ";
        }
        output += "\n \n Most recent guess: \n" + guessToString(getGuessHistory().get(getGuessHistory().size()-1));

        return output;
    }

    private String guessToString(String guess) {
        String guessString = "";

        for (int i = 0; i < guess.length(); i++) {
            guessString += Character.toUpperCase(guess.charAt(i)) + " ";
        }

        return guessString;
    }

    private String rowsToString() {
        String output = "";
        int biggestColumn = 0;

        for(GuessColumn column : columns) {
            if (column.possibleLetters.size() > biggestColumn) {
                biggestColumn = column.possibleLetters.size();
            }
        }

        for (int i = biggestColumn; i > 0; i--) {
            for (GuessColumn column : columns) {
                if (column.getPossibleLetters().size() >= i) {
                    output += Character.toUpperCase(column.getPossibleLetters().get(i - 1)) + " ";
                } else {
                    output += "  ";
                }
            }
            output += "\n";
        }

        return output;
    }


}


