package chess.piece;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook  extends ChessPiece {
    
    public Rook(Board board, Color color) {
        super(board, color);
    }
  

    @Override
    public String toString() {
        //Método que retornará a letra que representa a peça "Torre"
        return "R";
        
       
    }
     @Override
    public boolean[][] possibleMoves() {
        //implementação provisória.Matriz que terá o mesmo n linha e colunas do tabuleiro
        boolean [][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
        //Por enquanto vai retornar uma matriz do mov do Rook valendo false.
        
    }
    

    
}
