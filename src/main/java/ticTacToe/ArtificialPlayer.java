package ticTacToe;

public class ArtificialPlayer {
    String XorO;
    Board board;


    public ArtificialPlayer(String xorO,Board board) {
        this.XorO = xorO;
        this.board = board;
    }

    public String getXorO() {
        return XorO;
    }

    public int[] chooseField() {
        String[][] myBoard = board.getMyBoard();
        int i = 0;
        int j = 0;
        do {
            i = (int) Math.floor(Math.random()*3);
            j = (int) Math.floor(Math.random()*3);

        }while (!myBoard[i][j].equals(" "));
        int[] field = {i,j};

        return field;
    }
}
