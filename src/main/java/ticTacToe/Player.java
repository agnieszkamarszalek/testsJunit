package ticTacToe;

import ticTacToe.exceptions.WrongSignException;

import java.util.Scanner;

public class Player implements PlayersInterface {

    private String XorO;
    private Scanner scanner;

    public Player(String XorO) {
        this.XorO = XorO;
        this.scanner = new Scanner(System.in);
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getXorO() {
        return XorO;
    }

    @Override
    public int[] chooseCoordinates() {
        String field = takeFieldFromPlayer();
        String[] results = field.split(",");
        int[] intsResult = null;
        try {
            intsResult = new int[]{Integer.parseInt(results[0].trim()), Integer.parseInt(results[1].trim())};
        } catch (NumberFormatException e) {
            System.out.println("Choose field using two numbers! ");
            intsResult = new int[] {};
        }

        return intsResult;
    }

    public String takeFieldFromPlayer(){
        System.out.println("Choose field. Give: x, y");
        String  field = this.scanner.nextLine();
        return field;
    }
}
