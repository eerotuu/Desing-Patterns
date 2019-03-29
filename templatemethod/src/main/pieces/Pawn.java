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
 *
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

        Tile toTile = ChessBoard.getTile(to);

        int xFrom = from.getKey();
        int yFrom = from.getValue();
        int xTo = to.getKey();
        int yTo = to.getValue();

        // out of bounds
        if (xTo > 7 || xTo < 0 || yTo > 7 || yTo < 0) return false;

        int xMovement = xFrom - xTo;
        int yMovement;

        if (this.getColor() == ChessPiece.BLACK) {
            yMovement = yFrom - yTo;
        } else {
            yMovement = yTo - yFrom;
        }

        // forward
        if (xMovement == 0 && yMovement < 3 && yMovement > 0) {
            if (!toTile.isReserved()) {
                if (yMovement == 2 && hasMoved) {
                    return false;
                }
                hasMoved = true;
                return true;
            }
        }

        // attack move 
        if ((xMovement == -1 || xMovement == 1) && yMovement == 1) {
            if (toTile.isReserved() && toTile.getPiece().getColor() != this.getColor()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "P";
    }
}
