package org.christophercapps.blurrdle.controller;

import org.christophercapps.blurrdle.dictionary.DictionaryReader;
import org.christophercapps.blurrdle.model.GuessChecker;
import org.christophercapps.blurrdle.model.GuessTracker;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/puzzle")
public class GuessTrackerController {

    private final GuessChecker guessChecker = new GuessChecker();
    private final DictionaryReader dictionaryReader = new DictionaryReader();


    public GuessTrackerController(GuessChecker guessChecker) {
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("")
    public GuessTracker getNewTracker() {
        return new GuessTracker();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("")
    public GuessTracker checkGuess(@RequestBody GuessTracker tracker) {
        return guessChecker.checkGuess(tracker, dictionaryReader.getAnswer(), dictionaryReader.getFullDictionary());
    }




}
