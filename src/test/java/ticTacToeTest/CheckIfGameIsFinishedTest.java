package ticTacToeTest;

import org.junit.Test;
import ticTacToe.Board;
import ticTacToe.CheckIfGameIsFinished;
import ticTacToe.Player;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckIfGameIsFinishedTest {

    @Test
    public void shouldReturnWinnerIfrowsIsTaken() {
        //given
        Board board = new Board();
        CheckIfGameIsFinished checkIfGameIsOver = new CheckIfGameIsFinished();
        String[][] myBoard = board.getMyBoard();
        //when
        Player playerX = new Player("X");
        board.markField(playerX, 2, 0);
        board.markField(playerX, 2, 1);
        board.markField(playerX, 2, 2);
        String winner = checkIfGameIsOver.checkIsTheWinner(myBoard);
        //then
        assertThat(winner).isEqualTo("X");
    }

    @Test
    public void shouldReturnWinnerIfColumnsAreTaken(){
        //given
        Board board = new Board();
        CheckIfGameIsFinished checkIfGameIsOver = new CheckIfGameIsFinished();
        String[][] myBoard = board.getMyBoard();
        //when
        Player playerX = new Player("X");
        //Player playerY = new Player("Y");
        board.markField(playerX, 0, 1);
        board.markField(playerX, 1, 1);
        board.markField(playerX, 2, 1);
        String winner = checkIfGameIsOver.checkIsTheWinner(myBoard);
        //then
        assertThat(winner).isEqualTo("X");
    }

    @Test
    public void shouldReturnWinnerIfAcross1FieldAreTaken(){
        //given
        Board board = new Board();
        CheckIfGameIsFinished checkIfGameIsOver = new CheckIfGameIsFinished();
        String[][] myBoard = board.getMyBoard();
        //when
        Player playerX = new Player("X");
        board.markField(playerX, 0, 0);
        board.markField(playerX, 1, 1);
        board.markField(playerX, 2, 2);
        String winner = checkIfGameIsOver.checkIsTheWinner(myBoard);
        //then
        assertThat(winner).isEqualTo("X");

    }

    @Test
    public void shouldReturnWinnerIfAcross2FieldAreTaken(){
        //given
        Board board = new Board();
        CheckIfGameIsFinished checkIfGameIsOver = new CheckIfGameIsFinished();
        String[][] myBoard = board.getMyBoard();
        //when
        Player playerX = new Player("X");
        board.markField(playerX, 0, 2);
        board.markField(playerX, 1, 1);
        board.markField(playerX, 2, 0);
        String winner = checkIfGameIsOver.checkIsTheWinner(myBoard);
        //then
        assertThat(winner).isEqualTo("X");

    }

}
