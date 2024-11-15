/*
 * Essa classe será o oração do nosso sistema de xadrez. Aqui serão implemantadas 
as regras do nosso jogo.
 */
package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
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
    public boolean [][] possibleMoves(ChessPosition sourcePosition){//para imprimir as posições a partir da posição de origem
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece) capturedPiece;

    }

    private Piece makeMove(Position source, Position target) {
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        return capturedPiece;

    }

    private void validateSourcePosition(Position position) {
        if (!board.thereIsApiece(position)) {
            throw new ChessException("There is no piece on source position");

        }
        if (!board.piece(position).isThereAnyPossibleMove()) {
            throw new ChessException("There is no possible moves for the chosen piece");

        }

    }

    private void validateTargetPosition(Position source, Position target) {
        //Se para a peça de origem  a posição de destino não é um movimento possível, não pode mover pra lá
        if (!board.piece(source).possibleMove(target)) {
            throw new ChessException("The chosen piece can't move to target position");

        }
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());

    }

    private void initialSetup() {
        /*método responsávem para iniciar a partida de xadrez
        colocando as peças npo tabuleiro*/

        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }

}
