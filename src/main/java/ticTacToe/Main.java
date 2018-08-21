package ticTacToe;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ManagerTicTacToe managerTicTacToe = new ManagerTicTacToe("X");
        DisplayBoard displayBoard = new DisplayBoard(primaryStage);
        displayBoard.setManagerTicTacToe(managerTicTacToe);
        managerTicTacToe.setDisplayBoard(displayBoard);
        displayBoard.showBoardWhenPlay();
    }

    public static void main(String[] args) {

        launch(args);
    }

}

