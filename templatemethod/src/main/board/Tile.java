/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.board;

import main.pieces.ChessPiece;

/**
 *
 * @author Eero
 */
public class Tile {
    
    private ChessPiece currentPiece = null;
    
    public boolean isReserved() {
        return currentPiece != null;
    }
    
    public ChessPiece getPiece() {
        return currentPiece;
    }
    
    public void setPiece(ChessPiece p) {
        currentPiece = p;
    }
    @Override
    public String toString() {
        return currentPiece == null ? "-" : currentPiece.toString();
    }
}
