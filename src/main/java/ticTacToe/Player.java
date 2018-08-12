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

    public void setXorO(String xorO) {
        XorO = xorO;
    }

    @Override
    public int[] chooseField() {
        String field = takeFieldFromPlayer();
        String[] results = field.split(",");

        return new int[] {Integer.parseInt(results[0].trim()), Integer.parseInt(results[1].trim())};
    }

    public String takeFieldFromPlayer(){
        System.out.println("Choose field. Give: x, y");
        String  field = this.scanner.nextLine();
        return field;
    }
}
