/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess.piece;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

/**
 *
 * @author luana
 */
public class King extends ChessPiece{
    
    public King(Board board, Color color) {
        super(board, color);
    }
    @Override
    public String toString(){
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        //implementação provisória.Matriz que terá o mesmo n linha e colunas do tabuleiro
        boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
        //Por enquanto vai retornar uma matriz do mov do King valendo false.
        
    }
    
    
}
