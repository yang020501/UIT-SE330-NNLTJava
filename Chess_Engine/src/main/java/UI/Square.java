package UI;

import Pieces.*;

import javax.swing.*;
import java.awt.*;

public class Square extends JComponent {
    private int xS;
    private int yS;
    public static final int HEIGHT_OF_SQUARE = 64;
    public static final int WIGHT_OF_SQUARE = 64;
    private Piece pieceOccupy;
    private Color squareColor;

    public Square(){}

    public Square(int x, int y, Piece piece, Color color){
        this.xS = x;
        this.yS = y;
        this.pieceOccupy = piece;
        this.squareColor = color;

        this.setBorder(BorderFactory.createEmptyBorder());
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(squareColor);
        g.fillRect(xS * WIGHT_OF_SQUARE,yS * HEIGHT_OF_SQUARE, WIGHT_OF_SQUARE, HEIGHT_OF_SQUARE);
        if(pieceOccupy != null){
            pieceOccupy.draw(g);
        }
    }

    public int getxS() {
        return xS;
    }

    public void setxS(int xS) {
        this.xS = xS;
    }

    public int getyS() {
        return yS;
    }

    public void setyS(int yS) {
        this.yS = yS;
    }

    public Piece getPieceOccupy() {
        return pieceOccupy;
    }

    public void setPieceOccupy(Piece pieceOccupy) {
        this.pieceOccupy = pieceOccupy;
    }

    public Color getSquareColor() {
        return squareColor;
    }

    public void setSquareColor(Color squareColor) {
        this.squareColor = squareColor;
    }

    public boolean isOccupy() {
        if(pieceOccupy == null){
            return false;
        }
        return true;
    }
}
