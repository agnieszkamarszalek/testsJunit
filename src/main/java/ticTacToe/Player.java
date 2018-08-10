package ticTacToe;

import ticTacToe.exceptions.WrongSignException;

import java.util.Scanner;

public class Player {
    private Board board;
    private String XorO;

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    Scanner scanner;

    public Player(String XorO) {
        this.XorO = XorO;
        this.scanner = new Scanner(System.in);
    }

    public String chooseField(){
        System.out.println("Choose field. Give: x, y");
        String  field = this.scanner.nextLine();
        return field;
    }

    public int[] splitParseMove(String field){
        String[] results = field.split(",");

        return new int[] {Integer.parseInt(results[0].trim()), Integer.parseInt(results[1].trim())};
    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getXorO() {
        return XorO;
    }

    public void setXorO(String xorO) {
        XorO = xorO;
    }
}
