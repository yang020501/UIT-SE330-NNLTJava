package Pieces;

import UI.Square;

import java.awt.*;

public class Rook extends Piece {

    public Rook(int x, int y, boolean iswhite, Image image, String name) {
        super(x, y, iswhite, image, name);
        if (iswhite) {
            values = 10;
        } else {
            values = -10;
        }
    }

    @Override
    public void calculateLegalMove(Square[][] boardState) {
        super.calculateLegalMove(boardState);

        //right
        for (int i = 1; i < 8; i++) {
            if ((x + i) > 7) {
                break;
            }
            try {
                if (!boardState[x + i][y].isOccupy()) {
                    this.legal_move.add(boardState[x + i][y]);
                } else if (boardState[x + i][y].isOccupy()) {
                    if (boardState[x + i][y].getPieceOccupy().isWhite != this.isWhite) {
                        this.legal_move.add(boardState[x + i][y]);
                    }
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        //left
        for (int i = 1; i < 8; i++) {
            if ((x - i) < 0) {
                break;
            }

            try {
                if (!boardState[x - i][y].isOccupy()) {
                    this.legal_move.add(boardState[x - i][y]);
                } else if (boardState[x - i][y].isOccupy()) {
                    if (boardState[x - i][y].getPieceOccupy().isWhite != this.isWhite) {
                        this.legal_move.add(boardState[x - i][y]);
                    }
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        //up
        for (int i = 1; i < 8; i++) {
            if ((y - i) < 0) {
                break;
            }
            try {
                if (!boardState[x][y - i].isOccupy()) {
                    this.legal_move.add(boardState[x][y - i]);
                } else if (boardState[x][y - i].isOccupy()) {
                    if (boardState[x][y - i].getPieceOccupy().isWhite != this.isWhite) {
                        this.legal_move.add(boardState[x][y - i]);
                    }
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        //down
        for (int i = 1; i < 8; i++) {
            if ((y + i) > 7) {
                break;
            }

            try {
                if (!boardState[x][y + i].isOccupy()) {
                    this.legal_move.add(boardState[x][y + i]);
                } else if (boardState[x][y + i].isOccupy()) {
                    if (boardState[x][y + i].getPieceOccupy().isWhite != this.isWhite) {
                        this.legal_move.add(boardState[x][y + i]);
                    }
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
    }
}
