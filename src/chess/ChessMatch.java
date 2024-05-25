/*
 * Essa classe será o oração do nosso sistema de xadrez. Aqui serão implemantadas 
as regras do nosso jogo.
 */
package chess;

import boardgame.Board;
import chess.piece.King;
import chess.piece.Rook;


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
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
                //Feito DownCasting
            }

        }
        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());

    }

    private void initialSetup() {
        /*método responsávem para iniciar a partida de xadrez
        colocando as peças npo tabuleiro*/
        placeNewPiece('b', 6, new Rook(board, Color.WHITE));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
        placeNewPiece('e', 1, new King(board, Color.WHITE));

    }

}
