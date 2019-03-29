/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.board;

import javafx.util.Pair;
import main.pieces.*;

/**
 *
 * @author Eero
 */
public class ChessBoard {
    
    private int winner = -1;
    
    static Tile[][] board = new Tile[8][8];

    public void createBoard() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                board[y][x] = new Tile();
            }
        }
        addPieces();
    }

    public void addPieces() {
        board[0][0].setPiece(new Rook(ChessPiece.WHITE));
        board[0][1].setPiece(new Knight(ChessPiece.WHITE));
        board[0][2].setPiece(new Bishop(ChessPiece.WHITE));
        board[0][3].setPiece(new Queen(ChessPiece.WHITE));
        board[0][4].setPiece(new King(ChessPiece.WHITE));
        board[0][5].setPiece(new Bishop(ChessPiece.WHITE));
        board[0][6].setPiece(new Knight(ChessPiece.WHITE));
        board[0][7].setPiece(new Rook(ChessPiece.WHITE));
        for (int i = 0; i < 8; i++) {
            board[1][i].setPiece(new Pawn(ChessPiece.WHITE));
        }

        for (int i = 0; i < 8; i++) {
            board[6][i].setPiece(new Pawn(ChessPiece.BLACK));
        }
        board[7][0].setPiece(new Rook(ChessPiece.BLACK));
        board[7][1].setPiece(new Knight(ChessPiece.BLACK));
        board[7][2].setPiece(new Bishop(ChessPiece.BLACK));
        board[7][3].setPiece(new Queen(ChessPiece.BLACK));
        board[7][4].setPiece(new King(ChessPiece.BLACK));
        board[7][5].setPiece(new Bishop(ChessPiece.BLACK));
        board[7][6].setPiece(new Knight(ChessPiece.BLACK));
        board[7][7].setPiece(new Rook(ChessPiece.BLACK));    
    }
    
    public boolean movePiece(Pair<Integer, Integer> from, Pair<Integer, Integer> to, int player) {
        int xFrom = from.getKey();
        int yFrom = from.getValue();
        
        int xTo = to.getKey();
        int yTo = to.getValue();
         
        Tile tile = board[yFrom][xFrom];
  
        if(tile.isReserved() && tile.getPiece().getColor() == player && tile.getPiece().isValidMove(from, to)) {
            
            // cba to do alogrithm for checkmate -> whoever eats king wins.
            ChessPiece occupiedPiece = board[yTo][xTo].getPiece(); 
            if(occupiedPiece != null && occupiedPiece.getClass() == King.class) {
                winner = tile.getPiece().getColor();
            }
            
            board[yTo][xTo].setPiece(tile.getPiece());
            tile.setPiece(null);
            return true;
        }
        return false;
    }
    
    public static Tile getTile(Pair<Integer, Integer> c) {
        int x = c.getKey();
        int y = c.getValue();
        return board[y][x];
    }
    
    public void print() {
        System.out.println("  0 1 2 3 4 5 6 7");
        for (int y = 7; y >= 0; y--) {
            System.out.print(y + " ");
            for (int x = 0; x < 8; x++) {
                System.out.print(board[y][x] + " ");
            }
            System.out.println(y);
        }
        System.out.println("  0 1 2 3 4 5 6 7");
    }
    
    public int checkMate() {
        return winner;
    }
}
