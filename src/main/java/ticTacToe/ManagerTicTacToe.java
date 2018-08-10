package ticTacToe;

import ticTacToe.exceptions.WrongSignException;

import java.util.Scanner;

public class ManagerTicTacToe {
    Board board;
    Player player;
    CheckIfGameIsOver checkIfGameIsOver;
    ArtificialPlayer artificialPlayer;
    DisplayBoard displayBoard;
    ChoosePlayerCharacter choosePlayerCharacter;

    public ManagerTicTacToe(String playerXorPlayerO) {
        this.board = new Board();
        this.player = new Player(playerXorPlayerO);

        if(playerXorPlayerO.equals("X")){
            this.artificialPlayer = new ArtificialPlayer("O", board);
        }else {
            this.artificialPlayer = new ArtificialPlayer("X", board);
        }

        this.checkIfGameIsOver = new CheckIfGameIsOver();
        this.player = player;
        this.displayBoard = new DisplayBoard();

    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer() {
        return player;
    }

    public CheckIfGameIsOver getCheckIfGameIsOver() {
        return checkIfGameIsOver;
    }

    public ArtificialPlayer getArtificialPlayer() {
        return artificialPlayer;
    }

    public DisplayBoard getDisplayBoard() {
        return displayBoard;
    }




//    public void takeMovesFromPlayers(){
//        String input = player.chooseField();
//        int[] xYtable = player.splitParseMove(input);
//        int x = xYtable[0];
//        int y = xYtable[1];
//        board.takeField()
//    }
}
