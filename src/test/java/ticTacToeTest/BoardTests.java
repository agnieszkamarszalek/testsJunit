package ticTacToeTest;

import org.junit.Test;
import ticTacToe.Board;
import ticTacToe.Player;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BoardTests {
    @Test
    public void shouldMakeNewBoard() {
        //given

        Board board = new Board();

        //when
        String[][] expectedBoard = new String[3][3];
        for (int i = 0; i < expectedBoard.length; i++) {
            for (int j = 0; j < expectedBoard[i].length; j++) {
                expectedBoard[i][j] = " ";
            }
        }

        String[][] notExpectedBoard = new String[3][3];
        for (int i = 0; i < notExpectedBoard.length ; i++) {
            for (int j = 0; j < notExpectedBoard[i].length; j++) {
                notExpectedBoard[i][j] = "1";
            }
        }
        //then
        assertThat(expectedBoard).isEqualTo(board.getMyBoard());
        assertThat(notExpectedBoard).isNotEqualTo(board.getMyBoard());
        assertThat(board.getMyBoard()).isNotNull();
    }

    //czy da sie dodac prawidlowy ruch
    @Test
    public void shouldMakeAmove(){
        //given
        Board board = new Board();
        Player playerX = new Player("X");

        //when
        board.takeField(playerX, 2, 2);
        String fieldToCHeck = board.getMyBoard()[2][2];

        String[][] expectedBoard = new String[3][3];
        expectedBoard[2][2] = "X";
        String expectedField = expectedBoard[2][2];

        //then

        assertThat(fieldToCHeck).isEqualTo(expectedField);

    }

    @Test
    public void shouldNotTakeTheSameFieldSecondTime(){
        //given
        Board board = new Board();
        Player playerX = new Player("X");

        //when
        boolean tryTakeField = board.takeField(playerX, 2, 2);
        boolean tryTakeNextField = board.takeField(playerX, 2,2);

        //then

        assertThat(tryTakeField).isEqualTo(true);
        assertThat(tryTakeNextField).isEqualTo(false);

    }

    @Test
    public void shouldNotTakeAwrongFieldOutOfBounds() {
        //given
        Board board = new Board();
        Player playerX = new Player("X");

        //when
        boolean tryTakeField = board.takeField(playerX, 8, 4);

        //then
        assertThat(tryTakeField).isEqualTo(false);
    }
}





