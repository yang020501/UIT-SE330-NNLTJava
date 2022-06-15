package AI;

import Pieces.Piece;
import UI.Square;

public class Move {
    private Piece location_piece;
    private Piece destination_piece;
    private Square location;
    private Square destination;

    @Override
    public String toString() {
        return "Move: " + location_piece.getName() + " go to " + destination.getxS() + " " + destination.getyS();
    }

    public Move(Square squarex, Square squarey) {
        this.location = new Square(squarex.getxS(), squarex.getyS());
        this.location_piece = squarex.getPieceOccupy();

        this.destination = new Square(squarey.getxS(), squarey.getyS());
        this.destination_piece = squarey.getPieceOccupy();
    }

    public Move(){

    }

    public Square getLocation() {
        return location;
    }

    public Square getDestination() {
        return destination;
    }

    public Piece getLocation_piece() {
        return location_piece;
    }

    public void setLocation_piece(Piece location_piece) {
        this.location_piece = location_piece;
    }

    public Piece getDestination_piece() {
        return destination_piece;
    }

    public void setDestination_piece(Piece destination_piece) {
        this.destination_piece = destination_piece;
    }

    public void setLocation(Square location) {
        this.location = location;
    }

    public void setDestination(Square destination) {
        this.destination = destination;
    }

    public static void MakeMoveOnBoard(Move move, Square[][] boardState){
        int xL = move.getLocation().getxS();
        int yL = move.getLocation().getyS();

        int xD = move.getDestination().getxS();
        int yD = move.getDestination().getyS();

        try{
            Piece p = boardState[xL][yL].getPieceOccupy();
            boardState[xL][yL].setPieceOccupy(null);
            boardState[xD][yD].setPieceOccupy(p);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void undo(Move move, Square[][] boardState){
        int xl = move.getLocation().getxS();
        int yl = move.getLocation().getyS();

        int xd = move.getDestination().getxS();
        int yd = move.getDestination().getyS();

        try{
            boardState[xl][yl].setPieceOccupy(move.getLocation_piece());
            boardState[xd][yd].setPieceOccupy(move.getDestination_piece());
        }
        catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
    }
}
