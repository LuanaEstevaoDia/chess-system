/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boardgame;

/**
 *
 * @author luana
 */
public class Piece {
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

    }
    
    
    
    

