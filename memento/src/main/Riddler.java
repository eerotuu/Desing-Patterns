/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Eero
 */
public class Riddler {

    static final int GUESS_SIZE = 100;

    public Object joinGame() {
        return new Answer((int) Math.floor(Math.random() * GUESS_SIZE));
    }

    public boolean guess(int guess, Object a) {
        Answer answer = (Answer) a;
        return guess == answer.randomInt;
    }

    private class Answer {

        int randomInt;

        public Answer(int r) {
            randomInt = r;
        }
    }
}
