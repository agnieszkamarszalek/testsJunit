package ticTacToe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class DisplayBoard {
    private Board board;
    private Stage primaryStage;

    public DisplayBoard(Board board, Stage primaryStage) {
        this.board = board;
        this.primaryStage = primaryStage;
    }

    public DisplayBoard(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public DisplayBoard(Board board) {
        this.board = board;
    }

    public void showBoardWhenPlay(){
        // primary stage
        primaryStage.sizeToScene();

        //gridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));

        //buttons

        List<Button> buttons = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Button button = new Button();
            button.setAlignment(Pos.CENTER);
            button.setPrefSize(60,60);
            buttons.add(button);
        }

        //label
        Label mainLabel = new Label();

        mainLabel.setStyle("-fx-background-color: chartreuse");
        mainLabel.setText("Let's play a game!");
        mainLabel.setTextAlignment(TextAlignment.CENTER); // ???

        //gridpane with board
//        gridPane.setMargin(new Insets(10,10,10,10));
        gridPane.setAlignment(Pos.TOP_CENTER);

        //constraints gridpane
        //gridPane.setConstraints(mainLabel, 0, 0, 3, 3, HPos.CENTER, VPos.CENTER);
        gridPane.setConstraints(buttons.get(0), 0, 0 );
        gridPane.setConstraints(buttons.get(1), 1,0);
        gridPane.setConstraints(buttons.get(2), 2,0);
        gridPane.setConstraints(buttons.get(3), 0,1);
        gridPane.setConstraints(buttons.get(4), 1,1);
        gridPane.setConstraints(buttons.get(5), 2,1);
        gridPane.setConstraints(buttons.get(6), 0,2);
        gridPane.setConstraints(buttons.get(7), 1,2);
        gridPane.setConstraints(buttons.get(8), 2,2);


        gridPane.getChildren().addAll( buttons.get(0), buttons.get(1), buttons.get(2), buttons.get(3), buttons.get(4),
                buttons.get(5), buttons.get(6), buttons.get(7), buttons.get(8));
        gridPane.setPadding(new Insets(10,10,10,10));
        //borderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10,10,10,10));
        borderPane.setCenter(gridPane);
        borderPane.setTop(mainLabel);
        mainLabel.setAlignment(Pos.CENTER);

        //scene
        Scene scene = new Scene(borderPane, 300, 300);
        mainLabel.setPrefWidth(scene.getWidth());
        mainLabel.setPrefHeight(scene.getHeight()/5);
        mainLabel.setPadding(new Insets(10,10,10,10));
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
