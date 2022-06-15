package UI;

import Pieces.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Board extends JPanel implements MouseListener, MouseMotionListener {
    public boolean isInnit = false;
    public int xM, yM;
    public boolean paintOut = false;
    public boolean whiteturn = true;

    public Piece currentPiece;

    public static final Square[][] boardState = new Square[8][8];
    private static final Color whiteColor = new Color(235,235, 208); // White
    private static final Color browColor = new Color(153, 102, 0); // Brow

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
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)){
                    boardState[i][j] = new Square(i, j, null, whiteColor);
                }
                else {
                    boardState[i][j] = new Square(i, j, null, browColor);
                }
            }
        }

        boardState[0][0].setPieceOccupy(new Rook(0, 0, false, Black_Rook, "black rook"));
        boardState[1][0].setPieceOccupy(new Knight(1, 0, false, Black_Knight, "black knight"));
        boardState[2][0].setPieceOccupy(new Bishop(2, 0, false, Black_Bishop, "black bishop"));
        boardState[3][0].setPieceOccupy(new Queen(3, 0, false, Black_Queen, "black queen"));
        boardState[4][0].setPieceOccupy(new King(4, 0, false, Black_King, "black king"));
        boardState[5][0].setPieceOccupy(new Bishop(5, 0, false, Black_Bishop, "black bishop"));
        boardState[6][0].setPieceOccupy(new Knight(6, 0, false, Black_Knight, "black knight"));
        boardState[7][0].setPieceOccupy(new Rook(7, 0, false, Black_Rook, "black rook"));
        for(int i = 0; i < 8; i++){
            boardState[i][1].setPieceOccupy(new Pawn(i, 1, false, Black_Pawn, "black pawn"));
        }

        boardState[0][7].setPieceOccupy(new Rook(0, 7, true, White_Rook, "white rook"));
        boardState[1][7].setPieceOccupy(new Knight(1, 7, true, White_Knight, "white knight"));
        boardState[2][7].setPieceOccupy(new Bishop(2, 7, true, White_Bishop, "white bishop"));
        boardState[3][7].setPieceOccupy(new Queen(3, 7, true, White_Queen, "white queen"));
        boardState[4][7].setPieceOccupy(new King(4, 7, true, White_King, "white king"));
        boardState[5][7].setPieceOccupy(new Bishop(5, 7, true, White_Bishop, "white bishop"));
        boardState[6][7].setPieceOccupy(new Knight(6, 7, true, White_Knight, "white knight"));
        boardState[7][7].setPieceOccupy(new Rook(7, 7, true, White_Rook, "white rook"));
        for(int i = 0; i < 8; i++){
            boardState[i][6].setPieceOccupy(new Pawn(i, 6, true, White_Pawn, "white pawn"));
        }
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

        if(sq.isOccupy()){
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
            }
            catch (ClassCastException e_class){
                System.out.println(e_class);
            }
        }
        else {
            System.out.println("No piece");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        xM = e.getX();
        yM = e.getY();

        boolean approve = false;

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
                        currentPiece.setX(xM/64);
                        currentPiece.setY(yM/64);
                        if(currentPiece.getName() == "white pawn" || currentPiece.getName() == "black pawn"){
                            if(!((Pawn) currentPiece).get_isMove()){
                                ((Pawn) currentPiece).set_isMove(true);
                            }
                        }
                        currentPiece.getLegal_move().clear();
                        boardState[xM/64][yM/64].setPieceOccupy(currentPiece);
                        boardState[xPre][yPre].setPieceOccupy(null);
                        currentPiece = null;
                        approve = true;
                        paintOut = false;
                        repaint();
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

        }
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
}
