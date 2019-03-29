/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.pieces;

import javafx.util.Pair;
import main.board.ChessBoard;
import main.board.Tile;

/**
 * DONE
 * @author Eero
 */
public class Rook extends ChessPiece {

    public Rook(int color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Pair<Integer, Integer> from, Pair<Integer, Integer> to) {
        
        Tile toTile = ChessBoard.getTile(to);
        
        int xFrom = from.getKey();
        int yFrom = from.getValue();
        int xTo = to.getKey();
        int yTo = to.getValue();
        
        if(xTo > 7 || xTo < 0 || yTo > 7 || yTo < 0) return false;
   
        int xNegative;
        int yNegative;

        int xMovement;
        if(xFrom > xTo) {
            xMovement = xFrom - xTo;
            xNegative = -1;
        } else {
            xMovement = xTo - xFrom;
            xNegative = 1;
        }
        int yMovement;
        if (yFrom < yTo) {
            yMovement = yTo - yFrom;
            yNegative = 1;
        } else {
            yMovement = yFrom - yTo;
            yNegative = -1;
        }
        
        // vertical movement
        if (xMovement == 0 && yMovement > 0) {
            for (int i = 1; i < yMovement; i++) {
                if (ChessBoard.getTile(new Pair<>(xFrom, yFrom + i * yNegative)).isReserved()) {
                    return false;
                }
            }
            if (!ChessBoard.getTile(new Pair<>(xTo, yTo)).isReserved()
                    || toTile.getPiece().getColor() != this.getColor()) {
                return true;
            }

        }
        
        // horizontal movement
        if (xMovement > 0 && yMovement == 0) {
            for (int i = 1; i < xMovement; i++) {                
                if (ChessBoard.getTile(new Pair<>(xFrom + i * xNegative, yFrom)).isReserved()) {
                    return false;
                }
            }
            if (!ChessBoard.getTile(new Pair<>(xTo, yTo)).isReserved()
                    || toTile.getPiece().getColor() != this.getColor()) {
                return true;
            }
        } 
        return false;
    }

    @Override
    public String toString() {
        return "R";
    }
}
