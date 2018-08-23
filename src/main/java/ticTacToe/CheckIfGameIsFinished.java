package ticTacToe;

public class CheckIfGameIsFinished {
    private Board board;
    private Player player;

    public boolean checkAreAllFieldsTaken(String[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }


    public String checkIsTheWinner(String[][] myBoard) {

        String getWinnerSign = " ";

        for (int i = 0; i < myBoard.length; i++) {
            //rows
            if (myBoard[i][0].equals(myBoard[i][1]) && myBoard[i][1].equals(myBoard[i][2]) && !myBoard[i][0].equals(" ")) {

                getWinnerSign = myBoard[i][i];
                return getWinnerSign;
            }

            //column
            if (myBoard[0][i].equals(myBoard[1][i]) && myBoard[1][i].equals(myBoard[2][i]) && !myBoard[0][i].equals(" ")) {
                getWinnerSign = myBoard[i][i];
                return getWinnerSign;
            }

        }

        //across 1
        if (myBoard[0][0].equals(myBoard[1][1]) && myBoard[1][1].equals(myBoard[2][2]) && !myBoard[1][1].equals(" ")) {
            getWinnerSign = myBoard[1][1];
            return getWinnerSign;
        }
        //across 2
        if (myBoard[0][2].equals(myBoard[1][1]) && myBoard[1][1].equals(myBoard[2][0]) && !myBoard[1][1].equals(" ")) {
            getWinnerSign = myBoard[1][1];
            return getWinnerSign;
        }

        return getWinnerSign;
    }

    public WinningFields chooseWinningFields(String[][] myBoard) {
        for (int i = 0; i < myBoard.length; i++) {
            //rows
            if (myBoard[i][0].equals(myBoard[i][1]) && myBoard[i][1].equals(myBoard[i][2]) && !myBoard[i][0].equals(" ")) {
                int winningRow = i;

                if (winningRow == 0) {
                    return WinningFields.ROW_0;
                } else if (winningRow == 1) {
                    return WinningFields.ROW_1;
                } else {
                    return WinningFields.ROW_2;
                }
            }
            //column
            if (myBoard[0][i].equals(myBoard[1][i]) && myBoard[1][i].equals(myBoard[2][i]) && !myBoard[0][i].equals(" ")) {
                int winningColumn = i;

                if (winningColumn == 0) {
                    return WinningFields.COLUMN_0;
                } else if (winningColumn == 1) {
                    return WinningFields.COLUMN_1;
                } else {
                    return WinningFields.COLUMN_2;
                }
            }
            //axis left
            if (myBoard[0][0].equals(myBoard[1][1]) && myBoard[1][1].equals(myBoard[2][2]) && !myBoard[1][1].equals(" ")) {
                return WinningFields.AXIS_LEFT;
            }
            //axis right
            if (myBoard[0][2].equals(myBoard[1][1]) && myBoard[1][1].equals(myBoard[2][0]) && !myBoard[1][1].equals(" ")) {
                return WinningFields.AXIS_RIGHT;
            }
        }
        //when nobody wins
        return WinningFields.NONE;
    }
}


