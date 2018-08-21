package ticTacToe;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        DisplayBoard displayBoard = new DisplayBoard(primaryStage);
        displayBoard.showBoardWhenPlay();
    }

    public static void main(String[] args) {

        launch(args);
    }

}

