/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.pieces;

import javafx.util.Pair;

/**
 *
 * @author Eero
 */
public abstract class ChessPiece {
    
    public static final int BLACK = 1, WHITE = 0;
    
    private int color;
    
    public ChessPiece(int color) {
        this.color = color;
    }
    
    public abstract boolean isValidMove(Pair<Integer, Integer> from, Pair<Integer, Integer> to);
    
    public int getColor() {
        return this.color;
    }
    
    
    public String getName() {
        return this.toString();
    }
}
