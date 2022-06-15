package Pieces;

import UI.Square;

import java.awt.*;

public class King extends Piece{

    public King(int x, int y, boolean iswhite, Image image, String name) {
        super(x, y, iswhite, image, name);
        if(iswhite){
            values = 1000;
        }
        else {
            values = -1000;
        }
    }

    @Override
    public void calculateLegalMove(Square[][] boardState) {
        super.calculateLegalMove(boardState);
        //right
        if(x+1<=7){
            try{
                if(!boardState[x+1][y].isOccupy()){
                    this.legal_move.add(boardState[x+1][y]);
                }
                else if(boardState[x+1][y].isOccupy()){
                    if(boardState[x+1][y].getPieceOccupy().isWhite != this.isWhite){
                        this.legal_move.add(boardState[x+1][y]);
                    }
                }
            }
            catch (IndexOutOfBoundsException e){}
        }

        //left
        if((x-1)>=0){
            try {
                if(!boardState[x-1][y].isOccupy()){
                    this.legal_move.add(boardState[x-1][y]);
                }
                else if(boardState[x-1][y].isOccupy()){
                    if(boardState[x-1][y].getPieceOccupy().isWhite != this.isWhite){
                        this.legal_move.add(boardState[x-1][y]);
                    }

                }
            }
            catch (IndexOutOfBoundsException e){}
        }

        //up
        if((y-1)>=0){
            try {
                if(!boardState[x][y-1].isOccupy()){
                    this.legal_move.add(boardState[x][y-1]);
                }
                else if(boardState[x][y-1].isOccupy()){
                    if(boardState[x][y-1].getPieceOccupy().isWhite != this.isWhite){
                        this.legal_move.add(boardState[x][y-1]);
                    }

                }
            }
            catch (IndexOutOfBoundsException e){}
        }

        //down
        if((y+1)<=7){
            try {
                if(!boardState[x][y+1].isOccupy()){
                    this.legal_move.add(boardState[x][y+1]);
                }
                else if(boardState[x][y+1].isOccupy()){
                    if(boardState[x][y+1].getPieceOccupy().isWhite != this.isWhite){
                        this.legal_move.add(boardState[x][y+1]);
                    }

                }
            }
            catch (IndexOutOfBoundsException e){}
        }

        //right up
        if(x+1<=7 && y-1>=0){
            try{
                if(!boardState[x+1][y-1].isOccupy()){
                    this.legal_move.add(boardState[x+1][y-1]);
                }
                else if(boardState[x+1][y-1].isOccupy()){
                    if(boardState[x+1][y-1].getPieceOccupy().isWhite != this.isWhite){
                        this.legal_move.add(boardState[x+1][y-1]);
                    }
                }
            }
            catch (IndexOutOfBoundsException e){}
        }

        //right down
        if(x+1<=7 && y+1<=7){
            try{
                if(!boardState[x+1][y+1].isOccupy()){
                    this.legal_move.add(boardState[x+1][y+1]);
                }
                else if(boardState[x+1][y+1].isOccupy()){
                    if(boardState[x+1][y+1].getPieceOccupy().isWhite != this.isWhite){
                        this.legal_move.add(boardState[x+1][y+1]);
                    }
                }
            }
            catch (IndexOutOfBoundsException e){}
        }

        //left up
        if(x-1>=0 && y-1>=0){
            try{
                if(!boardState[x-1][y-1].isOccupy()){
                    this.legal_move.add(boardState[x-1][y-1]);
                }
                else if(boardState[x-1][y-1].isOccupy()){
                    if(boardState[x-1][y-1].getPieceOccupy().isWhite != this.isWhite){
                        this.legal_move.add(boardState[x-1][y-1]);
                    }
                }
            }
            catch (IndexOutOfBoundsException e){}
        }

        //left down
        if(x-1>=0 && y+1<=7){
            try{
                if(!boardState[x-1][y+1].isOccupy()){
                    this.legal_move.add(boardState[x-1][y+1]);
                }
                else if(boardState[x-1][y+1].isOccupy()){
                    if(boardState[x-1][y+1].getPieceOccupy().isWhite != this.isWhite){
                        this.legal_move.add(boardState[x-1][y+1]);
                    }
                }
            }
            catch (IndexOutOfBoundsException e){}
        }

    }
}
