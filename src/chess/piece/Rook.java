package chess.piece;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

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
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        //para facilitar criar uma posição e atribuir 0 como valor inicial.
        Position p = new Position(0, 0);
        //Por enquanto vai retornar uma matriz do mov do Rook valendo false.

        //above(uma lógica para vericar posições à cima da minha peça)
        p.setValues(position.getRow() - 1, position.getColumn());
        while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
            //Enquanto a posição p existir e não estiver uma peça lá, marca como true
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);
        }
        if (getBoard().positionExists(p) && isthereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            //essa condição é para saber se tem uma peça adversária no final.
        }

        //left(Verificar para esquerda, analisando a mesma linha, mas decrementando a coluna)
        p.setValues(position.getRow(), position.getColumn() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
            //Enquanto a posição p existir e não estivr uma peça lá, marca como true
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1);
        }
        if (getBoard().positionExists(p) && isthereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //right(Verificar se tem posições disponíveis para a direita)
        p.setValues(position.getRow(), position.getColumn() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
            //Enquanto a posição p existir e não estivr uma peça lá, marca como true
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);
        }
        if (getBoard().positionExists(p) && isthereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //below(Para baixo, lógica parecida com para cima)
        p.setValues(position.getRow() + 1, position.getColumn());
        while (getBoard().positionExists(p) && !getBoard().thereIsApiece(p)) {
            //Enquanto a posição p existir e não estivr uma peça lá, marca como true
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);
        }
        if (getBoard().positionExists(p) && isthereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;

        }
        return mat;

    }
}
