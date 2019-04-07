/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Eero
 */
public class Client implements Runnable {

    private Riddler riddler;
    private Object answer;
    private String name;

    public Client( Riddler r, String n) {
        answer = (riddler = r).joinGame();
        name = n;   
    }

    public boolean guessNum(int num) {
        return riddler.guess(num, answer);
    }

    @Override
    public void run() {

        // client has good memory and don't guess same number twice
        Set<Integer> guessedNumbers = new HashSet<>(Riddler.GUESS_SIZE);

        int nextGuess = -1;
        
        // while wrong guess
        do {
            // while number is already guessed
            do {
                nextGuess = (int) Math.floor(Math.random() * Riddler.GUESS_SIZE);
            } while (!guessedNumbers.add(nextGuess));           
        } while (!guessNum(nextGuess)); 
        
        ResultLogger.INSTANCE.logResult(name, nextGuess, guessedNumbers.size());
    }
}
