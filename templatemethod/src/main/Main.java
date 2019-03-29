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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // type moving piece and where to place it
        // in format xFrom yFrom xTo yTo each in own line
        
        // winner is whoever eats opponent king, no checkmate implemented
        Game game = new Chess();
        game.playOneGame(2);

    }
    
}
