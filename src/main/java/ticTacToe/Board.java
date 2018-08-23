package ticTacToe;

import java.util.Arrays;

public class Board {
    private String[][] myBoard = new String[3][3];

    public Board() {
        setEmptyFieldsOnBoard();
    }

    public Board(String[][] myBoard) {
        this.myBoard = myBoard;
    }

    public void setEmptyFieldsOnBoard () {
        for (int i = 0; i < myBoard.length ; i++) {
            for (int j = 0; j < myBoard[i].length; j++) {
                myBoard[i][j] = " ";
            }
        }
    }

    public boolean markField(PlayersInterface player, int row, int column) {

        String XorO = player.getXorO();

        if (row < 0 || row > 2 || column < 0 || column > 2 ) {
            System.out.println("Positions out of bounds");
            return false;
        }

        if(!" ".equalsIgnoreCase(this.getMyBoard()[row][column])) {
            System.out.println("Field is already taken. Choose another one");
            return false;
        }

        getMyBoard()[row][column] = XorO;

        return true;
    }

    public String[][] getMyBoard() {
        return myBoard;
    }

    @Override
    public String toString() {
        String arrayString = "";
        for (String[] row : myBoard) {
            arrayString += Arrays.toString(row) + "\n";
        }
        return arrayString;
    }
}
