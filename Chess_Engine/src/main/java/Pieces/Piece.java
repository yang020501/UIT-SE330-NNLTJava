package Pieces;

import UI.Square;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public abstract class Piece extends JPanel {
    protected static final int CHESS_HEIGHT = 48;
    protected static final int CHESS_WIGHT = 48;
    protected int x,y;
    protected boolean isWhite;
    protected Image chess_image;
    protected String name;
    protected int values;

    //Legal move of a piece
    protected List<Square> legal_move;

    public List<Square> getLegal_move() {
        return legal_move;
    }

    public void setLegal_move(List<Square> legal_move) {
        this.legal_move = legal_move;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getChess_image() {
        return chess_image;
    }

    public void setChess_image(Image chess_image) {
        this.chess_image = chess_image;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Piece(int x, int y, boolean iswhite, Image image, String name){
        this.x = x;
        this.y = y;
        this.isWhite = iswhite;
        this.chess_image = image;
        this.name = name;
        this.legal_move = new LinkedList<Square>();

    }

    public void draw(Graphics g){
        Image chessImage_wking = new ImageIcon(chess_image).getImage();
        int xP = Square.WIGHT_OF_SQUARE - CHESS_HEIGHT - 8;
        int yP = Square.HEIGHT_OF_SQUARE - CHESS_WIGHT - 8;
        g.drawImage(chessImage_wking, this.getX() * Square.WIGHT_OF_SQUARE + xP, this.getY() * Square.HEIGHT_OF_SQUARE + yP , CHESS_WIGHT, CHESS_WIGHT, this);
    }

    public void calculateLegalMove(Square[][] boardState){

    }

}
