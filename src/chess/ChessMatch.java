/*
 * Essa classe será o oração do nosso sistema de xadrez. Aqui serão implemantadas 
as regras do nosso jogo.
 */
package chess;

import boardgame.Board;

/**
 *
 * @author luana
 */
public class ChessMatch {
    private Board board;
    
    public ChessMatch(){
       board = new Board(8, 8);
        //Quem tem que saber a dimensão do xadrex é a clase 
        
    }
    public ChessPiece[][]getPieces(){
        /*Como está sendo um desenvolvimento em camadas
        vai ser liberado as peças do tipo chessPiece e não do tipo
        piece. Então o program não enxerga aquela peça interna
        do tabuleiro(board) só a camada de Xadrez.*/
        ChessPiece[][]mat = new ChessPiece[board.getRows()][board.getColumns()];
        for(int i = 1; i < board.getRows();i++){
            for(int j = 1; j < board.getColumns();j++){
                mat[i][j] = (ChessPiece)board.piece(i,j);
                //Feito DownCasting
            }
            
        }
        return mat;
    }
        
        
    }
    

