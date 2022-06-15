package AI;

import Pieces.*;
import UI.Board;
import UI.Square;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MiniMax {

    private Square[][] boardState;
    private boolean isWhite;

    public MiniMax(Square[][] boardState, boolean isWhite) {
        this.boardState = new Square[8][8];

        for (int x=0; x<8; x++){
            for (int y=0; y<8; y++){
                if(boardState[x][y].getPieceOccupy() != null){
                    this.boardState[x][y] = new Square(x, y);
                    this.boardState[x][y].setPieceOccupy(boardState[x][y].getPieceOccupy());
                }
                else {}
            }
        }

        this.isWhite = isWhite;
    }

    public Square[][] getBoardState() {
        return boardState;
    }

    public void setBoardState(Square[][] boardState) {
        this.boardState = boardState;
//        for (int x = 0; x < 8; x++){
//            for (int y = 0; y < 8; y++){
//                this.boardState[x][y].setxS(x);
//                this.boardState[x][y].setyS(y);
//            }
//        }
    }

    public int evaluateBoard(Square[][] board){
        int value = 0;
        try{
            for (int x=0; x<8; x++){
                for (int y=0; y<8; y++){
                    if(board[x][y].isOccupy()){
                        Piece tmp = board[x][y].getPieceOccupy();
                        value += tmp.getValues();
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException e){}
        return value;
    }

    public void Make_Move(Move m){
        //create a temporary board

        if(m != null){
            Square loc = new Square(m.getLocation().getxS(), m.getLocation().getyS());
            loc.setPieceOccupy(m.getLocation().getPieceOccupy());

            Square des = new Square(m.getDestination().getxS(), m.getDestination().getyS());
            des.setPieceOccupy(m.getDestination().getPieceOccupy());

            Piece p = boardState[loc.getxS()][loc.getyS()].getPieceOccupy();
            boardState[loc.getxS()][loc.getyS()].setPieceOccupy(null);
            boardState[des.getxS()][des.getyS()].setPieceOccupy(p);
        }

        //test
//        for (int x=0; x<8; x++){
//            for (int y=0; y<8; y++){
//                if(tmp[x][y].getPieceOccupy() != null){
//                    System.out.print(tmp[x][y].getPieceOccupy().getName() + " ");
//                }
//                else {
//                    System.out.print("-");
//                }
//            }
//            System.out.println();
//        }
    }

    public Move calcBestMoveOne(){
        Move bestMove = new Move();

        List<Move> all_possiple_move = new ArrayList<Move>();
        List<Move> best_move_list = new ArrayList<Move>();
        try{
            for (int x=0; x<8; x++){
                for (int y=0; y<8; y++){
                    if(boardState[x][y].isOccupy() && boardState[x][y].getPieceOccupy().isWhite() == this.isWhite){
                        Piece tmp = boardState[x][y].getPieceOccupy();
                        tmp.getLegal_move().clear();
                        String[] piece_name = tmp.getName().split(" ");
                        try {
                            switch (piece_name[1]) {
                                case "king": {
                                    ((King) tmp).calculateLegalMove(boardState);
                                    break;
                                }
                                case "queen": {
                                    ((Queen) tmp).calculateLegalMove(boardState);
                                    break;
                                }
                                case "rook": {
                                    ((Rook) tmp).calculateLegalMove(boardState);
                                    break;
                                }
                                case "knight": {
                                    ((Knight) tmp).calculateLegalMove(boardState);
                                    break;
                                }
                                case "bishop": {
                                    ((Bishop) tmp).calculateLegalMove(boardState);
                                    break;
                                }
                                case "pawn": {
                                    ((Pawn) tmp).calculateLegalMove(boardState);
                                    break;
                                }
                                default: {
                                    System.out.println("piece");
                                }

                            }
                        }
                        catch (ClassCastException e_class){}

                        if(!tmp.getLegal_move().isEmpty()){
                            for (Square moveSquare : tmp.getLegal_move()) {
                                Move move = new Move(boardState[x][y], moveSquare);
//                                System.out.println(move.getLocation_piece().getName() + " move to: "
//                                        + move.getDestination().getxS() + " " + move.getDestination().getyS());
                                all_possiple_move.add(move);
//                                System.out.println(move.getPiece_location().getPieceOccupy().getName());
                            }
                        }
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException e){}

        if (all_possiple_move.isEmpty() || Board.gameOver){
            return null;
        }
        boolean foundIt = false;
        int bestMoveValue = 9999999;

        for (Move move : all_possiple_move) {
            Make_Move(move);
            int moveValue = evaluateBoard(boardState);
            if (moveValue < bestMoveValue && move.getLocation_piece().isWhite() == this.isWhite) {
                foundIt = true;
                best_move_list.clear();
                best_move_list.add(move);
                bestMoveValue = moveValue;
            }
            else if(moveValue == bestMoveValue && move.getLocation_piece().isWhite() == this.isWhite){
                foundIt = true;
                best_move_list.add(move);
                bestMoveValue = moveValue;
            }
            this.undo(move);
        }

        if(foundIt){
            Random r = new Random();
            bestMove = best_move_list.get(r.nextInt(best_move_list.size()));
        }
        else {
            while (true){
                Random r = new Random();
                bestMove = all_possiple_move.get(r.nextInt(all_possiple_move.size()));
                if(bestMove.getLocation_piece().isWhite() == this.isWhite){
                    break;
                }
            }
        }

        System.out.println("Best value: " + bestMoveValue);
        return bestMove;
    }

    public void undo(Move move){
        int xl = move.getLocation().getxS();
        int yl = move.getLocation().getyS();

        int xd = move.getDestination().getxS();
        int yd = move.getDestination().getyS();

        this.boardState[xl][yl].setPieceOccupy(move.getLocation_piece());
        this.boardState[xd][yd].setPieceOccupy(move.getDestination_piece());
    }



}
