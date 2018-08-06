package ticTacToe;

public class ManagerTicTacToe {
    Board board;
    Player player;
    CheckIfGameIsOver checkIfGameIsOver;
    ArtificialPlayer artificialPlayer;
    DisplayBoard displayBoard;

    public ManagerTicTacToe(Board board, Player player, CheckIfGameIsOver checkIfGameIsOver, ArtificialPlayer artificialPlayer, DisplayBoard displayBoard) {
        this.board = board;
        this.player = player;
        this.checkIfGameIsOver = checkIfGameIsOver;
        this.artificialPlayer = artificialPlayer;
        this.displayBoard = displayBoard;
    }
}
