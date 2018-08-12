package ticTacToe;

public class DisplayBoard {
    private Board board;

    public DisplayBoard(Board board) {
        this.board = board;
    }

    public void showBoardWhenPlay(){
        System.out.println(board);
    }
}
