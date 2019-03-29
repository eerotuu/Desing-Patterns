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
public class Knight extends ChessPiece {

    public Knight(int color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Pair<Integer, Integer> from, Pair<Integer, Integer> to) {
        int xFrom = from.getKey();
        int yFrom = from.getValue();
        int xTo = to.getKey();
        int yTo = to.getValue();

        if (xTo > 7 || xTo < 0 || yTo > 7 || yTo < 0) {
            return false;
        }

        int movingColor = ChessBoard.getTile(new Pair<>(xFrom, yFrom)).getPiece().getColor();

        int xMovement;
        if (xFrom > xTo) {
            xMovement = xFrom - xTo;
        } else {
            xMovement = xTo - xFrom;
        }
        int yMovement;
        if (yFrom < yTo) {
            yMovement = yTo - yFrom;
        } else {
            yMovement = yFrom - yTo;
        }
        // right
        if ((xMovement == 2 && yMovement == 1) || (xMovement == 2 && yMovement == -1)
                // left
                || (xMovement == -2 && yMovement == -1) || (xMovement == -2 && yMovement == 1)
                // up
                || (xMovement == 1 && yMovement == 2) || (xMovement == -1 && yMovement == 2)
                // down
                || (xMovement == 1 && yMovement == -2) || (xMovement == -1 && yMovement == -2)) {

            if (!ChessBoard.getTile(new Pair<>(xTo, yTo)).isReserved()
                    || ChessBoard.getTile(new Pair<>(xTo, yTo)).getPiece().getColor() != movingColor) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "N";
    }

}
