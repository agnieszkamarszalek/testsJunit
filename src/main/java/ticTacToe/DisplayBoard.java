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
    private Stage primaryStage;
    private ManagerTicTacToe managerTicTacToe;
    List<Button> buttons = new ArrayList<>();

    public DisplayBoard(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setManagerTicTacToe(ManagerTicTacToe managerTicTacToe) {
        this.managerTicTacToe = managerTicTacToe;
    }

    public void showBoardWhenPlay(){
        // primary stage
        primaryStage.sizeToScene();

        //gridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));

        //buttons
        for (int i = 0; i < 9; i++) {
            Button button = new Button();
            button.setAlignment(Pos.CENTER);
            button.setPrefSize(60,60);
            buttons.add(button);
        }

        //buttons action
        buttons.get(0).setOnAction( b -> managerTicTacToe.playGame("0,0"));
        buttons.get(1).setOnAction( b -> managerTicTacToe.playGame("0,1"));
        buttons.get(2).setOnAction( b -> managerTicTacToe.playGame("0,2"));
        buttons.get(3).setOnAction( b -> managerTicTacToe.playGame("1,0"));
        buttons.get(4).setOnAction( b -> managerTicTacToe.playGame("1,1"));
        buttons.get(5).setOnAction( b -> managerTicTacToe.playGame("1,2"));
        buttons.get(6).setOnAction( b -> managerTicTacToe.playGame("2,0"));
        buttons.get(7).setOnAction( b -> managerTicTacToe.playGame("2,1"));
        buttons.get(8).setOnAction( b -> managerTicTacToe.playGame("2,2"));

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

    public void refreshBoard(String XorO, int x, int y) {

        int whichButtonToSetText = x * 3 + y;
        buttons.get(whichButtonToSetText).setText(XorO);
    }


}

