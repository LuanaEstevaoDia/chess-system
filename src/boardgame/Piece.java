
package boardgame;

public  abstract class Piece {
    protected Position position;//posição simples de matriz, não é ainda a posição de xadrez.
    private Board board;

    public Piece(Board board) {
        this.board = board;
        //A posição não entrou porque a peça inicia como nula.
    }

    protected Board getBoard() {
        return board;
        //Protegido para ser acessado só pelas peças
    }
    public abstract boolean[][] possibleMoves();
    public boolean possibleMove(Position position){    

        /*Observar que o método concreto está utilizando um método abstrato.
         hook method. è um método que faz um gancho com uma subclasse.*/
        return possibleMoves()[position.getRow()][position.getColumn()];
        
    }
     public boolean isThereAnyPossibleMove(){
         //mais um exemplo de uma implementação padrão concreta que depende de um método abstrato.
         boolean [][] mat = possibleMoves();
         
         for(int i= 0; i < mat.length; i++){
             for(int j = 0; j < mat.length; j++){
                 if(mat[i][j]){
                     return true;
                 }
             }
                 
         }
         return false;
     }
        
    

    }
    
    
    
    

