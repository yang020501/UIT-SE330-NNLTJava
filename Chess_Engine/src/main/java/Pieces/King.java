package Pieces;

import AI.Move;
import UI.Board;
import UI.Square;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
                    Move move = new Move(boardState[x][y], boardState[x+1][y]);
                    Move.MakeMoveOnBoard(move, boardState);

                    if(isSafe(boardState, boardState[x+1][y] )){
                        this.legal_move.add(boardState[x+1][y]);
                    }

                    Move.undo(move, boardState);
                }
                else if(boardState[x+1][y].isOccupy()){
                    if(boardState[x+1][y].getPieceOccupy().isWhite != this.isWhite){
                        Move move = new Move(boardState[x][y], boardState[x+1][y]);
                        Move.MakeMoveOnBoard(move, boardState);

                        if(isSafe(boardState, boardState[x+1][y] )){
                            this.legal_move.add(boardState[x+1][y]);
                        }

                        Move.undo(move, boardState);
                    }
                }
            }
            catch (IndexOutOfBoundsException e){}
        }

        //left
        if((x-1)>=0){
            try{
                if(!boardState[x-1][y].isOccupy()){
                    Move move = new Move(boardState[x][y], boardState[x-1][y]);
                    Move.MakeMoveOnBoard(move, boardState);

                    if(isSafe(boardState, boardState[x-1][y])){
                        this.legal_move.add(boardState[x-1][y]);
                    }

                    Move.undo(move, boardState);
                }
                else if(boardState[x-1][y].isOccupy()){
                    if(boardState[x-1][y].getPieceOccupy().isWhite != this.isWhite){
                        Move move = new Move(boardState[x][y], boardState[x-1][y]);
                        Move.MakeMoveOnBoard(move, boardState);

                        if(isSafe(boardState, boardState[x-1][y])){
                            this.legal_move.add(boardState[x-1][y]);
                        }

                        Move.undo(move, boardState);
                    }
                }
            }
            catch (IndexOutOfBoundsException e){}
        }

        //up
        if((y-1)>=0){
            try{
                if(!boardState[x][y-1].isOccupy()){
                    Move move = new Move(boardState[x][y], boardState[x][y-1]);
                    Move.MakeMoveOnBoard(move, boardState);

                    if(isSafe(boardState, boardState[x][y-1])){
                        this.legal_move.add(boardState[x][y-1]);
                    }

                    Move.undo(move, boardState);
                }
                else if(boardState[x][y-1].isOccupy()){
                    if(boardState[x][y-1].getPieceOccupy().isWhite != this.isWhite){
                        Move move = new Move(boardState[x][y], boardState[x][y-1]);
                        Move.MakeMoveOnBoard(move, boardState);

                        if(isSafe(boardState, boardState[x][y-1])){
                            this.legal_move.add(boardState[x][y-1]);
                        }

                        Move.undo(move, boardState);
                    }
                }
            }
            catch (IndexOutOfBoundsException e){}
        }

        //down
        if((y+1)<=7){
            try{
                if(!boardState[x][y+1].isOccupy()){
                    Move move = new Move(boardState[x][y], boardState[x][y+1]);
                    Move.MakeMoveOnBoard(move, boardState);

                    if(isSafe(boardState, boardState[x][y+1])){
                        this.legal_move.add(boardState[x][y+1]);
                    }

                    Move.undo(move, boardState);
                }
                else if(boardState[x][y+1].isOccupy()){
                    if(boardState[x][y+1].getPieceOccupy().isWhite != this.isWhite){
                        Move move = new Move(boardState[x][y], boardState[x][y+1]);
                        Move.MakeMoveOnBoard(move, boardState);

                        if(isSafe(boardState, boardState[x][y+1])){
                            this.legal_move.add(boardState[x][y+1]);
                        }

                        Move.undo(move, boardState);
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

        //Check move
        
    }

    @Override
    public boolean isSafe(Square[][] boardState, Square location) {
        if(this.isWhite){
            for (Piece temp : Board.black_piece_list) {
                String[] piece_name = temp.getName().split(" ");
                try{
                    switch (piece_name[1]) {
                        case "king": {
                            ((King) temp).calculateLegalMove(boardState);
                            break;
                        }
                        case "queen": {
                            ((Queen) temp).calculateLegalMove(boardState);
                            break;
                        }
                        case "rook": {
                            ((Rook) temp).calculateLegalMove(boardState);
                            break;
                        }
                        case "knight": {
                            ((Knight) temp).calculateLegalMove(boardState);
                            break;
                        }
                        case "bishop": {
                            ((Bishop) temp).calculateLegalMove(boardState);
                            break;
                        }
                        case "pawn": {
                            ((Pawn) temp).calculateLegalMove(boardState);
                            break;
                        }
                        default: {
                            System.out.println("piece");
                        }
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }

                temp.calculateLegalMove(boardState);
                for (Square move : temp.getLegal_move()) {
                    if(move.getxS() == location.getxS() && move.getyS() == location.getyS()){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
