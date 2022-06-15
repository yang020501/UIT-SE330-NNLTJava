package Pieces;

import UI.Square;

import java.awt.*;

public class Knight extends Piece{

    public Knight(int x, int y, boolean iswhite, Image image, String name) {
        super(x, y, iswhite, image, name);
        if(iswhite){
            values = 20;
        }
        else {
            values = -20;
        }
    }

    @Override
    public void calculateLegalMove(Square[][] boardState) {
        super.calculateLegalMove(boardState);
        //+2 +1
        try{
            if(!boardState[x+2][y+1].isOccupy() || boardState[x+2][y+1].getPieceOccupy().isWhite != this.isWhite){
                this.legal_move.add(boardState[x+2][y+1]);
            }
        }
        catch (Exception e){}
        //+2-1
        try{
            if(!boardState[x+2][y-1].isOccupy() || boardState[x+2][y-1].getPieceOccupy().isWhite != this.isWhite){
                this.legal_move.add(boardState[x+2][y-1]);
            }
        }
        catch (Exception e){}
        //-2+1
        try{
            if(!boardState[x-2][y+1].isOccupy() || boardState[x-2][y+1].getPieceOccupy().isWhite != this.isWhite){
                this.legal_move.add(boardState[x-2][y+1]);
            }
        }
        catch (Exception e){}
        //-2-1
        try{
            if(!boardState[x-2][y-1].isOccupy() || boardState[x-2][y-1].getPieceOccupy().isWhite != this.isWhite){
                this.legal_move.add(boardState[x-2][y-1]);
            }
        }
        catch (Exception e){}
        //+1+2
        try{
            if(!boardState[x+1][y+2].isOccupy() || boardState[x+1][y+2].getPieceOccupy().isWhite != this.isWhite){
                this.legal_move.add(boardState[x+1][y+2]);
            }
        }
        catch (Exception e){}
        //+1-2
        try{
            if(!boardState[x+1][y-2].isOccupy() || boardState[x+1][y-2].getPieceOccupy().isWhite != this.isWhite){
                this.legal_move.add(boardState[x+1][y-2]);
            }
        }
        catch (Exception e){}
        //-1+2
        try{
            if(!boardState[x-1][y+2].isOccupy() || boardState[x-1][y+2].getPieceOccupy().isWhite != this.isWhite){
                this.legal_move.add(boardState[x-1][y+2]);
            }
        }
        catch (Exception e){}
        //-1-2
        try{
            if(!boardState[x-1][y-2].isOccupy() || boardState[x-1][y-2].getPieceOccupy().isWhite != this.isWhite){
                this.legal_move.add(boardState[x-1][y-2]);
            }
        }
        catch (Exception e){}

        //if(this.getLegal_move() == null){
        //    System.out.println("error");
        //}
        //else{
        //    for (Square legalMove : this.getLegal_move()) {
        //        System.out.println(legalMove.getxS() + " " + legalMove.getyS());
        //    }
        //}

    }
}
