package ticTacToe;

import java.util.Scanner;

public class ScannerWrapper {
    public String nextLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
