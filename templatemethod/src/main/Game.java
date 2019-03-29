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
public abstract class Game {
    protected int players;
    
    abstract void init();
    
    abstract void makePlay(int player);
    
    abstract boolean endOfGame();
    
    abstract void printWinner();
    
    public final void playOneGame(int players) {
        this.players = players;
        init();
        
        int p = 0;
        while(!endOfGame()) {
            makePlay(p);
            p = (p + 1) % players;
        }
        printWinner();
    }    
}
