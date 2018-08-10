package ticTacToe;

import ticTacToe.exceptions.WrongSignException;

import java.util.Scanner;

public class ChoosePlayerCharacter {
    private ScannerWrapper scanner;

    public ChoosePlayerCharacter() {
        this.scanner = new ScannerWrapper();
    }

    public void setScanner(ScannerWrapper scanner) {
        this.scanner = scanner;
    }

    public String choosePlayerCharacter() {
        String playerCharacter = "";
        do {
            System.out.println("You can be X or O. Choose! ");
            playerCharacter = this.scanner.nextLine().toUpperCase();
            System.out.println("p" + playerCharacter);
            if(!(playerCharacter.equals("X") || playerCharacter.equals("O"))){
                System.out.println("Choose X or O");
            }
        }while (!(playerCharacter.equals("X") || playerCharacter.equals("O")));
        return playerCharacter;
    }

}
