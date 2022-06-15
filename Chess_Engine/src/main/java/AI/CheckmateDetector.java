package AI;

import Pieces.Piece;
import UI.Square;

import java.util.LinkedList;
import java.util.List;

public class CheckmateDetector {
    private Square[][] board;
    private List<Piece> white_piece_list = new LinkedList<Piece>();
    private List<Piece> black_piece_list = new LinkedList<Piece>();
    private boolean whiteWin;
    private boolean blackWin;

    public CheckmateDetector(Square[][] board) {
        this.board = board;
        this.whiteWin = false;
        this.blackWin = false;

    }

    public void setBoard(Square[][] board) {
        this.board = board;
        white_piece_list.clear();
        black_piece_list.clear();

        try{
            for(int x=0; x<8; x++){
                for (int y=0; y<8; y++){
                    if(this.board[x][y].isOccupy()){
                        Piece tmp = this.board[x][y].getPieceOccupy();
                        if(tmp.isWhite()){
                            white_piece_list.add(tmp);
                        }
                        else {
                            black_piece_list.add(tmp);
                        }
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Set up board in checkmate detector fail");
        }

    }

    public boolean isWhiteWin() {
        return whiteWin;
    }


    public boolean isBlackWin() {
        return blackWin;
    }


    public boolean CheckWinning(){
        int wking_exist = 0;
        int bking_exist = 0;

        if(!white_piece_list.isEmpty()){
            for (Piece p : white_piece_list) {
                if(p.getName() == "white king"){
                    wking_exist = 1;
                }
            }
        }

        if(!black_piece_list.isEmpty()){
            for (Piece p : black_piece_list) {
                if(p.getName().equals("black king")){
                    bking_exist = 1;
                }
            }
        }

        if(wking_exist == 1 && bking_exist == 0){
            whiteWin = true;
            return true;
        }
        else if(wking_exist == 0 && bking_exist == 1){
            blackWin = true;
            return true;
        }

        return false;
    }
}
