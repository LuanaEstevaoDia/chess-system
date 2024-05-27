
package chess;

import boardgame.BoardException;

public class ChessException extends BoardException {
    //ChessException extendendo BoardException dá para capturar
    //Exceções das duas classes.
    public ChessException(String msg){
        super(msg);
        
    }
    
    
}
