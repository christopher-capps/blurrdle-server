package org.christophercapps.blurrdle.model;

import org.springframework.stereotype.Component;

@Component
public class GuessChecker {

    public GuessTracker checkGuess(GuessTracker tracker, String answer){

        if(tracker.getGuess() == null || tracker.getGuess().length() != answer.length()) {
            return tracker;
        }

        tracker.addToHistory(tracker.getGuess());

        if (tracker.getGuess().equalsIgnoreCase(answer)) {
            tracker.setCorrect(true);
            return tracker;
        }

        updateTracker(tracker, answer);

        return tracker;
    }

    public GuessTracker updateTracker(GuessTracker tracker, String answer) {

        for (int i = 0; i < answer.length(); i++) {

            Character answerCharLeft = '?';
            Character answerCharRight = '?';
            Character answerCharCenter = Character.toUpperCase(answer.charAt(i));


            if (i != 0) {
                answerCharLeft = Character.toUpperCase(answer.charAt(i - 1));
            }

            if (i != answer.length() - 1) {
                answerCharRight = Character.toUpperCase(answer.charAt(i + 1));
            }

            if (tracker.guessChar(i) == answerCharLeft ||
                tracker.guessChar(i) == answerCharCenter ||
                tracker.guessChar(i) == answerCharRight) {

                if (i != 0) {
                    tracker.addLetter(i - 1, tracker.guessChar(i));
                }

                if (i != answer.length() - 1) {
                    tracker.addLetter(i + 1, tracker.guessChar(i));
                }

                tracker.addLetter(i, tracker.guessChar(i));
            }
        }

        return tracker;
    }

    public char[] wordToArray(String word) {
        char[] wordArray = new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
            wordArray[i] = Character.toUpperCase(word.charAt(i));
        }
        return wordArray;
    }
}