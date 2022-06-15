package Pieces;

import UI.Square;

import java.awt.*;

public class Bishop extends Piece{
    public Bishop(int x, int y, boolean iswhite, Image image, String name) {
        super(x, y, iswhite, image, name);
        if(iswhite){
            values = 30;
        }
        else {
            values = -30;
        }
    }

    @Override
    public void calculateLegalMove(Square[][] boardState) {
        super.calculateLegalMove(boardState);
        //right up
        for(int i=1; i<8; i++){
            if((x+i)>7 || (y-i)<0){
                break;
            }

            try{
                if(!boardState[x+i][y-i].isOccupy()){
                    this.legal_move.add(boardState[x+i][y-i]);
                }
                else if(boardState[x+i][y-i].isOccupy()){
                    if(boardState[x+i][y-i].getPieceOccupy().isWhite != this.isWhite){
                        this.legal_move.add(boardState[x+i][y-i]);
                    }
                    break;
                }
            }
            catch (IndexOutOfBoundsException e){
                break;
            }
        }
        //left up
        for(int i=1; i<8; i++){
            if((x-i)<0 || (y-i)<0){
                break;
            }

            try {
                if(!boardState[x-i][y-i].isOccupy()){
                    this.legal_move.add(boardState[x-i][y-i]);
                }
                else if(boardState[x-i][y-i].isOccupy()){
                    if(boardState[x-i][y-i].getPieceOccupy().isWhite != this.isWhite){
                        this.legal_move.add(boardState[x-i][y-i]);
                    }
                    break;
                }
            }
            catch (IndexOutOfBoundsException e){
                break;
            }
        }
        //right down
        for(int i=1; i<8; i++){
            if((x+i)>7 || (y+i)>7){
                break;
            }

            try{
                if(!boardState[x+i][y+i].isOccupy()){
                    this.legal_move.add(boardState[x+i][y+i]);
                }
                else if(boardState[x+i][y+i].isOccupy()){
                    if(boardState[x+i][y+i].getPieceOccupy().isWhite != this.isWhite){
                        this.legal_move.add(boardState[x+i][y+i]);
                    }
                    break;
                }
            }
            catch (IndexOutOfBoundsException e){
                break;
            }
        }
        //left down
        for(int i=1; i<8; i++){
            if((x-i)<0 || (y+i)>7){
                break;
            }

            try{
                if(!boardState[x-i][y+i].isOccupy()){
                    this.legal_move.add(boardState[x-i][y+i]);
                }
                else if(boardState[x-i][y+i].isOccupy()){
                    if(boardState[x-i][y+i].getPieceOccupy().isWhite != this.isWhite){
                        this.legal_move.add(boardState[x-i][y+i]);
                    }
                    break;
                }
            }
            catch (IndexOutOfBoundsException e){
                break;
            }
        }
    }
}
