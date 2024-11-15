
package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;


public  abstract class ChessPiece extends Piece{
    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    
    //Operação na classe genérica para ser reaproveitada em todas as peças.Será protected para
    //ser acessada no mesmo pacote.
    
    protected boolean isthereOpponentPiece(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p.getColor() != color;
    
        
    }
    
    
}
