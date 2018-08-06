package ticTacToe;

import java.util.Arrays;

public class Board {
    String[][] myBoard = new String[3][3];

    public Board() {

        for (int i = 0; i < myBoard.length ; i++) {
            for (int j = 0; j < myBoard[i].length; j++) {
                myBoard[i][j] = " ";
            }
        }
    }

    public Board(String[][] myBoard) {
        this.myBoard = myBoard;
    }

    public boolean takeField(Player player, int X, int Y) {
        String XorO = player.getXorO();
        if(X >= 0 && X <3 && Y >= 0 && Y < 3){
            if (this.getMyBoard()[X][Y].equals(" ")) {
                getMyBoard()[X][Y] = XorO;
                return true;
            } else {
                System.out.println("Field is already taken. Chose another one");
                return false;
            }
        }
        System.out.println("Positions out of bounds");
        return false;
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
