package ticTacToeTest;

import org.junit.Test;
import ticTacToe.Board;
import ticTacToe.CheckIfGameIsOver;
import ticTacToe.Player;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckIfGameIsOverTest {
    @Test
    public void shouldInformThatNobodyWinsWhenBoardIsEmpty(){
        //given
        Board board = new Board();
        CheckIfGameIsOver checkIfGameIsOver = new CheckIfGameIsOver();
        //when
        boolean ifWins = checkIfGameIsOver.checkBoard(board.getMyBoard());

        //then
        assertThat(ifWins).isEqualTo(false);
    }

    @Test
    public void shouldReturnWinnerIfrowsIsTaken() {
        //given
        Board board = new Board();
        CheckIfGameIsOver checkIfGameIsOver = new CheckIfGameIsOver();
        String[][] myBoard = board.getMyBoard();
        //when
        Player playerX = new Player("X");
        board.takeField(playerX, 2, 0);
        board.takeField(playerX, 2, 1);
        board.takeField(playerX, 2, 2);
        String winner = checkIfGameIsOver.checkIsTheWinner(myBoard);
        //then
        assertThat(winner).isEqualTo("X");
    }

    @Test
    public void shouldReturnWinnerIfColumnsAreTaken(){
        //given
        Board board = new Board();
        CheckIfGameIsOver checkIfGameIsOver = new CheckIfGameIsOver();
        String[][] myBoard = board.getMyBoard();
        //when
        Player playerX = new Player("X");
        //Player playerY = new Player("Y");
        board.takeField(playerX, 0, 1);
        board.takeField(playerX, 1, 1);
        board.takeField(playerX, 2, 1);
        String winner = checkIfGameIsOver.checkIsTheWinner(myBoard);
        //then
        assertThat(winner).isEqualTo("X");
    }

    @Test
    public void shouldReturnWinnerIfAcross1FieldAreTaken(){
        //given
        Board board = new Board();
        CheckIfGameIsOver checkIfGameIsOver = new CheckIfGameIsOver();
        String[][] myBoard = board.getMyBoard();
        //when
        Player playerX = new Player("X");
        board.takeField(playerX, 0, 0);
        board.takeField(playerX, 1, 1);
        board.takeField(playerX, 2, 2);
        String winner = checkIfGameIsOver.checkIsTheWinner(myBoard);
        //then
        assertThat(winner).isEqualTo("X");

    }

    @Test
    public void shouldReturnWinnerIfAcross2FieldAreTaken(){
        //given
        Board board = new Board();
        CheckIfGameIsOver checkIfGameIsOver = new CheckIfGameIsOver();
        String[][] myBoard = board.getMyBoard();
        //when
        Player playerX = new Player("X");
        board.takeField(playerX, 0, 2);
        board.takeField(playerX, 1, 1);
        board.takeField(playerX, 2, 0);
        String winner = checkIfGameIsOver.checkIsTheWinner(myBoard);
        //then
        assertThat(winner).isEqualTo("X");

    }

}
