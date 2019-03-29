/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.pieces;

import javafx.util.Pair;
import main.board.ChessBoard;

/**
 *
 * @author Eero
 */
public class Queen extends ChessPiece {

    public Queen(int color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Pair<Integer, Integer> from, Pair<Integer, Integer> to) {
        int xFrom = from.getKey();
        int yFrom = from.getValue();
        int xTo = to.getKey();
        int yTo = to.getValue();

        int xNegative;
        int yNegative;

        if (xTo > 7 || xTo < 0 || yTo > 7 || yTo < 0) {
            return false;
        }

        int movingColor = ChessBoard.getTile(new Pair<>(xFrom, yFrom)).getPiece().getColor();

        int xMovement;
        if (xFrom > xTo) {
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

        if (xMovement == yMovement) {
            for (int i = 1; i < yMovement - 1; i++) {
                if (ChessBoard.getTile(new Pair<>(xFrom + i * xNegative, yFrom + i * yNegative)).isReserved()) {
                    return false;
                }
            }
            if (!ChessBoard.getTile(new Pair<>(xTo, yTo)).isReserved()
                    || ChessBoard.getTile(new Pair<>(xTo, yTo)).getPiece().getColor() != movingColor) {
                return true;
            }
        }

        if (xMovement == 0 && yMovement > 0) {
            for (int i = 1; i < yMovement; i++) {
                if (ChessBoard.getTile(new Pair<>(xFrom, yFrom + i * yNegative)).isReserved()) {
                    return false;
                }
            }
            if (!ChessBoard.getTile(new Pair<>(xTo, yTo)).isReserved()
                    || ChessBoard.getTile(new Pair<>(xTo, yTo)).getPiece().getColor() != movingColor) {
                return true;
            }

        }

        if (xMovement > 0 && yMovement == 0) {
            for (int i = 1; i < xMovement; i++) {
                if (ChessBoard.getTile(new Pair<>(xFrom + i * xNegative, yFrom)).isReserved()) {
                    return false;
                }
            }

            if (!ChessBoard.getTile(new Pair<>(xTo, yTo)).isReserved()
                    || ChessBoard.getTile(new Pair<>(xTo, yTo)).getPiece().getColor() != movingColor) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Q";
    }

}
