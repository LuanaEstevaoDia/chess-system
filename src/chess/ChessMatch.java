/*
 * Essa classe será o oração do nosso sistema de xadrez. Aqui serão implemantadas 
as regras do nosso jogo.
 */
package chess;

import boardgame.Board;
import boardgame.Position;
import chess.piece.King;
import chess.piece.Rook;

/**
 *
 * @author luana
 */
public class ChessMatch {

    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        //Quem tem que saber a dimensão do xadrex é a clase 
        initialSetup();

    }

    public ChessPiece[][] getPieces() {
        /*Como está sendo um desenvolvimento em camadas
        vai ser liberado as peças do tipo chessPiece e não do tipo
        piece. Então o program não enxerga aquela peça interna
        do tabuleiro(board) só a camada de Xadrez.*/
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i =0; i < board.getRows(); i++) {
            for (int j =0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
                //Feito DownCasting
            }

        }
        return mat;
    }

    private void initialSetup() {
        /*método responsávem para iniciar a partida de xadrez
        colocando as peças npo tabuleiro*/
        board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
        board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
        board.placePiece(new King(board, Color.WHITE), new Position(7, 4));

    }

}
