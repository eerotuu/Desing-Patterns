/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;
import javafx.util.Pair;
import main.board.ChessBoard;

/**
 *
 * @author Eero
 */
public class Chess extends Game {

    private ChessBoard board;
    private Scanner input;
    private int winner;

    @Override
    void init() {
        board = new ChessBoard();
        board.createBoard();
        board.print();
        input = new Scanner(System.in);
    }

    @Override
    void makePlay(int player) {
        Boolean validPlay = false;
        System.out.println("Player: " + (player + 1));
        while (!validPlay) {
            
            int[] a = new int[4];
            try {
                for (int i = 0; i < a.length; i++) {
                    a[i] = input.nextInt();
                }

                if (!board.movePiece(new Pair<>(a[0], a[1]), new Pair<>(a[2], a[3]), player)) {
                    System.out.println("not valid move, Player " + (player + 1) + " try again.");
                } else {
                    validPlay = true;
                }
                board.print();
            } catch (Exception e) {
                System.out.println("invalid input pattern, try again");
                input = new Scanner(System.in);
            } 
        }
    }

    @Override
    boolean endOfGame() {
        int w = board.checkMate();
        if(w != -1) {
            winner = w;
            return true;
        }
        return false;
    }

    @Override
    void printWinner() {
        System.out.println("Winner: Player " + (winner + 1));
    }

}
