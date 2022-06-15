package UI;

import AI.CheckmateDetector;
import AI.MiniMax;
import AI.Move;
import Pieces.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Board extends JPanel implements MouseListener, MouseMotionListener {
    private boolean isInnit = false;
    public static List<Piece> black_piece_list = new ArrayList<>();
    public static List<Piece> white_piece_list = new ArrayList<>();
    private int xM, yM;
    private boolean paintOut = false;
    private boolean whiteturn = true;
    private List<Square> move_of_piece = new LinkedList<>();
    private CheckmateDetector checker;

    private MiniMax ai;

    public static boolean gameOver = false;

    public Piece currentPiece;

    public static final Square[][] boardState = new Square[8][8];
    private static Color black_sq_color;
    private static Color white_sq_color;

    //Fall
    private static final Color whiteColor = new Color(235,235, 208); // White
    private static final Color browColor = new Color(153, 102, 0); // Brow

    //Hell
    private static final Color redColor = new Color(235,31,37); //Red
    private static final Color orangeColor = new Color(241,127,61); //Red

    //Sky
    private static final Color brightblueColor = new Color(1,241,238);
    private static final Color darkblueColor = new Color(17,47,124);

    //Set up color
    public static String choise;


    //Image of chess pieces
    public static final Image White_King = new ImageIcon("../Chess_Engine/Resources/wking.png").getImage();
    public static final Image White_Queen = new ImageIcon("../Chess_Engine/Resources/wqueen.png").getImage();
    public static final Image White_Knight = new ImageIcon("../Chess_Engine/Resources/wknight.png").getImage();
    public static final Image White_Bishop = new ImageIcon("../Chess_Engine/Resources/wbishop.png").getImage();
    public static final Image White_Rook = new ImageIcon("../Chess_Engine/Resources/wrook.png").getImage();
    public static final Image White_Pawn = new ImageIcon("../Chess_Engine/Resources/wpawn.png").getImage();
    public static final Image Black_King = new ImageIcon("../Chess_Engine/Resources/bking.png").getImage();
    public static final Image Black_Queen = new ImageIcon("../Chess_Engine/Resources/bqueen.png").getImage();
    public static final Image Black_Knight = new ImageIcon("../Chess_Engine/Resources/bknight.png").getImage();
    public static final Image Black_Bishop = new ImageIcon("../Chess_Engine/Resources/bbishop.png").getImage();
    public static final Image Black_Rook = new ImageIcon("../Chess_Engine/Resources/brook.png").getImage();
    public static final Image Black_Pawn = new ImageIcon("../Chess_Engine/Resources/bpawn.png").getImage();

    public void boardSetup(){
        if("sky".equals(choise)){
            black_sq_color = darkblueColor;
            white_sq_color = brightblueColor;
        }
        else if("hell".equals(choise)){
            black_sq_color = redColor;
            white_sq_color = orangeColor;
        }
        else{
            black_sq_color = browColor;
            white_sq_color = whiteColor;
        }

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)){
                    boardState[i][j] = new Square(i, j, null, white_sq_color);
                }
                else {
                    boardState[i][j] = new Square(i, j, null, black_sq_color);
                }
            }
        }
        Piece brook1 = new Rook(0, 0, false, Black_Rook, "black rook");
        black_piece_list.add(brook1);
        boardState[0][0].setPieceOccupy(new Rook(0, 0, false, Black_Rook, "black rook"));

        Piece bknight1 = new Knight(1, 0, false, Black_Knight, "black knight");
        black_piece_list.add(bknight1);
        boardState[1][0].setPieceOccupy(new Knight(1, 0, false, Black_Knight, "black knight"));

        Piece bbishop1 = new Bishop(2, 0, false, Black_Bishop, "black bishop");
        black_piece_list.add(bbishop1);
        boardState[2][0].setPieceOccupy(new Bishop(2, 0, false, Black_Bishop, "black bishop"));

        Piece bqueen = new Queen(3, 0, false, Black_Queen, "black queen");
        black_piece_list.add(bqueen);
        boardState[3][0].setPieceOccupy(new Queen(3, 0, false, Black_Queen, "black queen"));

        Piece bking = new King(4, 0, false, Black_King, "black king");
        black_piece_list.add(bking);
        boardState[4][0].setPieceOccupy(new King(4, 0, false, Black_King, "black king"));

        Piece bbishop2 = new Bishop(5, 0, false, Black_Bishop, "black bishop");
        black_piece_list.add(bbishop2);
        boardState[5][0].setPieceOccupy(new Bishop(5, 0, false, Black_Bishop, "black bishop"));

        Piece bknight2 = new Knight(6, 0, false, Black_Knight, "black knight");
        black_piece_list.add(bknight2);
        boardState[6][0].setPieceOccupy(new Knight(6, 0, false, Black_Knight, "black knight"));

        Piece brook2 = new Rook(7, 0, false, Black_Rook, "black rook");
        black_piece_list.add(brook2);
        boardState[7][0].setPieceOccupy(new Rook(7, 0, false, Black_Rook, "black rook"));

        for(int i = 0; i < 8; i++){
            Piece bpawn = new Pawn(i, 1, false, Black_Pawn, "black pawn");
            black_piece_list.add(bpawn);
            boardState[i][1].setPieceOccupy(new Pawn(i, 1, false, Black_Pawn, "black pawn"));
        }

        Piece wrook1 = new Rook(0, 7, true, White_Rook, "white rook");
        white_piece_list.add(wrook1);
        boardState[0][7].setPieceOccupy(new Rook(0, 7, true, White_Rook, "white rook"));

        Piece wknight1 = new Knight(1, 7, true, White_Knight, "white knight");
        white_piece_list.add(wknight1);
        boardState[1][7].setPieceOccupy(new Knight(1, 7, true, White_Knight, "white knight"));

        Piece wbishop1 = new Bishop(2, 7, true, White_Bishop, "white bishop");
        white_piece_list.add(wbishop1);
        boardState[2][7].setPieceOccupy(new Bishop(2, 7, true, White_Bishop, "white bishop"));

        Piece wqueen = new Queen(3, 7, true, White_Queen, "white queen");
        white_piece_list.add(wqueen);
        boardState[3][7].setPieceOccupy(new Queen(3, 7, true, White_Queen, "white queen"));

        Piece wking = new King(4, 7, true, White_King, "white king");
        white_piece_list.add(wking);
        boardState[4][7].setPieceOccupy(new King(4, 7, true, White_King, "white king"));

        Piece wbishop2 = new Bishop(5, 7, true, White_Bishop, "white bishop");
        white_piece_list.add(wbishop2);
        boardState[5][7].setPieceOccupy(new Bishop(5, 7, true, White_Bishop, "white bishop"));

        Piece wknight2 = new Knight(6, 7, true, White_Knight, "white knight");
        white_piece_list.add(wknight2);
        boardState[6][7].setPieceOccupy(new Knight(6, 7, true, White_Knight, "white knight"));

        Piece wrook2 = new Rook(7, 7, true, White_Rook, "white rook");
        white_piece_list.add(wrook2);
        boardState[7][7].setPieceOccupy(new Rook(7, 7, true, White_Rook, "white rook"));

        for(int i = 0; i < 8; i++){
            Piece wpawn = new Pawn(i, 6, true, White_Pawn, "white pawn");
            white_piece_list.add(wpawn);
            boardState[i][6].setPieceOccupy(new Pawn(i, 6, true, White_Pawn, "white pawn"));
        }

        checker = new CheckmateDetector(boardState);
        ai = new MiniMax(boardState, false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                boardState[i][j].paintComponent(g);
            }
        }

        if(currentPiece != null && !paintOut){
            g.drawImage(currentPiece.getChess_image(), xM - 12, yM - 14, null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        xM = e.getX();
        yM = e.getY();
        Square sq = boardState[xM/64][yM/64];
//        try{
//            Component test_comp = getComponentAt(new Point(xM, yM));
//            Square square_test = (Square) test_comp;
//        }
//        catch (Exception e_comp){
//            System.out.println(e_comp);
//        }

        if(sq.isOccupy() && sq.getPieceOccupy().isWhite() == whiteturn){
            paintOut = false;
            currentPiece = sq.getPieceOccupy();
            String[] piece_name = currentPiece.getName().split(" ");
            try{
                switch (piece_name[1]){
                    case "king":{
                        ((King) currentPiece).calculateLegalMove(boardState);
                        break;
                    }
                    case "queen":{
                        ((Queen) currentPiece).calculateLegalMove(boardState);
                        break;
                    }
                    case "rook":{
                        ((Rook) currentPiece).calculateLegalMove(boardState);
                        break;
                    }
                    case "knight":{
                        ((Knight) currentPiece).calculateLegalMove(boardState);
                        break;
                    }
                    case "bishop":{
                        ((Bishop) currentPiece).calculateLegalMove(boardState);
                        break;
                    }
                    case "pawn":{
                        ((Pawn) currentPiece).calculateLegalMove(boardState);
                        break;
                    }
                    default:{
                        System.out.println("piece");
                    }

                }

                //Indicate with square is movable
                move_of_piece.clear();
                if(!currentPiece.getLegal_move().isEmpty()){
                    move_of_piece.addAll(currentPiece.getLegal_move());
                    for (Square move : move_of_piece) {
                        Color origin = boardState[move.getxS()][move.getyS()].getSquareColor();
                        if(origin == white_sq_color){
                            boardState[move.getxS()][move.getyS()].setSquareColor(Color.LIGHT_GRAY);
                        }
                        else if(origin == black_sq_color){
                            boardState[move.getxS()][move.getyS()].setSquareColor(Color.GRAY);
                        }
                    }
                    repaint();
                }
            }
            catch (ClassCastException e_class){
                System.out.println(e_class);
            }
        }
        else {
            //System.out.println("No piece");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        xM = e.getX();
        yM = e.getY();

        boolean approve = false;

        //Logic when moving a piece
        if(currentPiece != null){
            int xPre = currentPiece.getX();
            int yPre = currentPiece.getY();
            Piece restorePiece = currentPiece;

            if(currentPiece.getLegal_move().isEmpty()){
                boardState[xPre][yPre].setPieceOccupy(restorePiece);
                paintOut = true;
                repaint();
            }
            else {
                for (Square legalMove : currentPiece.getLegal_move()) {
                    if(xM/64 == legalMove.getxS() && yM/64 == legalMove.getyS()){

                        Move move = new Move(boardState[xPre][yPre], boardState[xM/64][yM/64]);
                        MakeMoveOnBoard(move);
                        currentPiece = null;
                        approve = true;
                        paintOut = false;

                        whiteturn = !whiteturn;

                        break;
                    }
                }

                if(!approve){
                    paintOut = true;
                    restorePiece.getLegal_move().clear();
                    boardState[xPre][yPre].setPieceOccupy(restorePiece);
                    repaint();
                }

            }

            //Paint the square color to identify which square the piece can move to
            if(!move_of_piece.isEmpty()){
                for (Square move : move_of_piece) {
                    Color origin = boardState[move.getxS()][move.getyS()].getResertColor();
                    boardState[move.getxS()][move.getyS()].setSquareColor(origin);
                }
                repaint();
            }

        }

        if(!whiteturn && !gameOver){
//            System.out.println("AI turn");
            ai.setBoardState(boardState);
//            for(int i=0; i<8; i++){
//                for (int j=0; j<8; j++){
//                    if(ai.getBoardState()[i][j].getPieceOccupy() != null){
//                        System.out.print(ai.getBoardState()[i][j].getPieceOccupy().getName() + " ");
//                    }
//                    else{
//                        System.out.print("-");
//                    }
//                }
//                System.out.println();
//            }
            Move m = ai.calcBestMoveOne();
            System.out.println(m.toString());
            MakeMoveOnBoard(m);

//            System.out.println("Paint");
            whiteturn = !whiteturn;

        }

        checker.setBoard(boardState);

        if(checker.CheckWinning()){
            if(checker.isWhiteWin()){
                System.out.println("White win the game");
            }
            else if(checker.isBlackWin()){
                System.out.println("Black win the game");
            }

            gameOver = true;
        }

        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        xM = e.getX() - 8;
        yM = e.getY() - 8;

        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void MakeMoveOnBoard(Move m){
        int xL = m.getLocation().getxS();
        int yL = m.getLocation().getyS();

        int xD = m.getDestination().getxS();
        int yD = m.getDestination().getyS();

        Piece p = boardState[xL][yL].getPieceOccupy();
        Piece q = boardState[xD][yD].getPieceOccupy();

        if(p.isWhite()){
            white_piece_list.remove(p);
        }
        else {
            black_piece_list.remove(p);
        }

        if(q != null){
            if(q.isWhite()){
                white_piece_list.remove(q);
            }
            else {
                black_piece_list.remove(q);
            }
        }

        p.setX(xD);
        p.setY(yD);
        if(p.getName() == "white pawn" || p.getName() == "black pawn"){
            if(!((Pawn) p).get_isMove()){
                ((Pawn) p).set_isMove(true);
            }
        }
        p.getLegal_move().clear();

        boardState[xL][yL].setPieceOccupy(null);
        boardState[xD][yD].setPieceOccupy(p);

        if(p.getName() == "white pawn" || p.getName() == "black pawn"){
            if(p.isWhite() && m.getDestination().getyS() == 0){
                PawnLvUp(m.getDestination(), p.isWhite());
            }
            else if(!p.isWhite() && m.getDestination().getyS() == 7){
                PawnLvUp(m.getDestination(), p.isWhite());
            }
        }

        if(p.isWhite()){
            white_piece_list.add(p);
        }
        else {
            black_piece_list.add(p);
        }
    }

    public void PawnLvUp(Square lvup_sq, boolean iswhite){
        int x = lvup_sq.getxS();
        int y = lvup_sq.getyS();

        if(iswhite){
            boardState[x][y].setPieceOccupy(new Queen(x, y, iswhite, White_Queen, "white queen"));
        }
        else {
            boardState[x][y].setPieceOccupy(new Queen(x, y, iswhite, Black_Queen, "black queen"));
        }
    }

    public void undo(Move move){
        int xl = move.getLocation().getxS();
        int yl = move.getLocation().getyS();

        int xd = move.getDestination().getxS();
        int yd = move.getDestination().getyS();

        boardState[xl][yl].setPieceOccupy(move.getLocation_piece());
        boardState[xd][yd].setPieceOccupy(move.getDestination_piece());
    }


}
