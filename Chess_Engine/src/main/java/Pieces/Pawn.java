package Pieces;

import UI.Square;

import java.awt.*;

public class Pawn extends Piece{

    protected boolean isMove;

    public boolean get_isMove() {
        return isMove;
    }

    public void set_isMove(boolean move) {
        isMove = move;
    }


    public Pawn(int x, int y, boolean iswhite, Image image, String name) {
        super(x, y, iswhite, image, name);
        isMove = false;
        if(iswhite){
            values = 5;
        }
        else {
            values = -5;
        }
    }

    @Override
    public void calculateLegalMove(Square[][] boardState) {
        super.calculateLegalMove(boardState);
        int x = this.getX();
        int y = this.getY();
        if(isWhite){
            //Move forward 1 square
            try{
                if(!boardState[x][y-1].isOccupy()){
                    this.legal_move.add(boardState[x][y-1]);
                }
            }
            catch (IndexOutOfBoundsException e){}

            //Move forward 2 square when not moving yet
            try{
                if(!boardState[x][y-1].isOccupy() && !boardState[x][y-2].isOccupy() && !isMove){
                    this.legal_move.add(boardState[x][y-2]);
                }
            }
            catch (IndexOutOfBoundsException e){}

            //Kill a pieces in diagonal lines within 1 square
            try{
                if(boardState[x+1][y-1].isOccupy() && !boardState[x+1][y-1].getPieceOccupy().isWhite){
                    this.legal_move.add(boardState[x+1][y-1]);
                }
            }
            catch (IndexOutOfBoundsException e){}

            try{
                if(boardState[x-1][y-1].isOccupy() && !boardState[x-1][y-1].getPieceOccupy().isWhite){
                    this.legal_move.add(boardState[x-1][y-1]);
                }
            }
            catch (IndexOutOfBoundsException e){}
        }
        else {
            //Move forward 1 square
            try{
                if(!boardState[x][y+1].isOccupy()){
                    this.legal_move.add(boardState[x][y+1]);
                }
            }
            catch (IndexOutOfBoundsException e){}

            //Move forward 2 square when not moving yet
            try{
                if(!boardState[x][y+1].isOccupy() && !boardState[x][y+2].isOccupy() && !isMove){
                    this.legal_move.add(boardState[x][y+2]);
                }
            }
            catch (IndexOutOfBoundsException e){}

            //Kill a pieces in diagonal lines within 1 square
            try{
                if(boardState[x+1][y+1].isOccupy() && boardState[x+1][y+1].getPieceOccupy().isWhite){
                    this.legal_move.add(boardState[x+1][y+1]);
                }
            }
            catch (IndexOutOfBoundsException e){}

            try{
                if(boardState[x-1][y+1].isOccupy() && boardState[x-1][y+1].getPieceOccupy().isWhite){
                    this.legal_move.add(boardState[x-1][y+1]);
                }
            }
            catch (IndexOutOfBoundsException e){}
        }

        //Evolution when go to the border
    }
}
