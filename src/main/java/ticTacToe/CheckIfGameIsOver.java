package ticTacToe;

public class CheckIfGameIsOver {
    Board board;
    Player player;

    public boolean checkBoard(String[][] board){
        return false;
    }

    public boolean checkAreAllFieldsTaken(String[][] board){
        board = this.board.getMyBoard();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j].equals(" ")){
                    return false;
                }
            }
        }
        return true;
    }


    public String checkIsTheWinner(String[][] myBoard) {
        String winner = " ";
        for (int i = 0; i < myBoard.length ; i++) {
            for (int j = 0; j < myBoard[i].length ; j++) {
                int k = i;
                if(i==1) {
                    k = i - 1;
                }else if(i==2){
                    k = i - 2;
                }
                //rows
                if(myBoard[i][k].equals(myBoard[i][k + 1]) && myBoard[i][k].equals(myBoard[i][k + 2]) && !myBoard[i][k].equals(" ")){
                    winner = myBoard[i][i];
                        return winner;
                    }
                    //collumn
                if(myBoard[k][i].equals(myBoard[k + 1][i]) && myBoard[i+1][i].equals(myBoard[k + 2][i]) && !myBoard[k][i].equals(" ")){
                    winner = myBoard[i][i];
                    return winner;
                }
                //across 1
                if(myBoard[0][0].equals(myBoard[1][1]) && myBoard[1][1].equals(myBoard[2][2]) && !myBoard[1][1].equals(" ")){
                    winner = myBoard[1][1];
                    return winner;
                }
                //across 2
                if(myBoard[0][2].equals(myBoard[1][1]) && myBoard[1][1].equals(myBoard[2][0]) && !myBoard[1][1].equals(" ")){
                    winner = myBoard[1][1];
                    return winner;
                }
            }
        }
        return winner;
    }
}

