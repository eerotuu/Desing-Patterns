/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.pieces;

import javafx.util.Pair;
import main.board.ChessBoard;

/**
 * DONE
 * @author Eero
 */
public class Pawn extends ChessPiece {

    // first time a pawn moves, it has option to advance 2
    private boolean hasMoved = false; 

    public Pawn(int color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Pair<Integer, Integer> from, Pair<Integer, Integer> to) {
        int xFrom = from.getKey();
        int yFrom = from.getValue();
        int xTo = to.getKey();
        int yTo = to.getValue();
        
        // out of bounds
        if(xTo > 7 || xTo < 0 || yTo > 7 || yTo < 0) return false;

        if (super.getColor() == ChessPiece.BLACK) {
            int xMovement = xFrom - xTo;
            int yMovement = yFrom - yTo;

            // forward
            if (xMovement == 0 && yMovement < 3 && yMovement > 0) {

                if (!ChessBoard.getTile(to).isReserved()) {

                    if (yMovement == 2 && hasMoved) {
                        return false;
                    }
                    
                    hasMoved = true;
                    return true;
                }
            }

            // attack move 
            if ((xMovement == -1 || xMovement == 1) && yMovement == 1) {
                if (ChessBoard.getTile(to).isReserved() && ChessBoard.getTile(to).getPiece().getColor() == ChessPiece.WHITE) {
                    return true;
                }
            }
        }

        if (super.getColor() == ChessPiece.WHITE) {
            int xMovement = xFrom - xTo;
            int yMovement = yTo - yFrom;

            // forward
            if (xMovement == 0 && yMovement < 3 && yMovement > 0) {

                if (!ChessBoard.getTile(to).isReserved()) {

                    if (yMovement == 2 && hasMoved) {
                        return false;
                    }
                    
                    hasMoved = true;
                    return true;
                }
            }

            // attack move 
            if ((xMovement == -1 || xMovement == 1) && yMovement == 1) {
                if (ChessBoard.getTile(to).isReserved() && ChessBoard.getTile(to).getPiece().getColor() == ChessPiece.BLACK) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "P";
    }

}
