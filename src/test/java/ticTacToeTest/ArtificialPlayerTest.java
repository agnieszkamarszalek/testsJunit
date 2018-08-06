package ticTacToeTest;

import org.junit.Test;
import ticTacToe.ArtificialPlayer;
import ticTacToe.Board;
import ticTacToe.Player;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ArtificialPlayerTest {
    @Test
    public void shouldMakePlayer() {
        //given
        Board board = new Board();
        //when
        ArtificialPlayer artificialPlayer = new ArtificialPlayer("O", board);

        //then
        assertThat(artificialPlayer).isNotNull();
        assertThat(artificialPlayer.getXorO()).isEqualTo("O");

    }

    @Test
    public void shouldMarkedFreeField(){
        //given
        String[][] givenBoard = new String[][]{{"X","X","X"}, {"X"," ","X"}, {"X","X","X"}};

        Board board = new Board(givenBoard);
        ArtificialPlayer artificialPlayer = new ArtificialPlayer("O",board);

        int[] expected = {1,1};

        //when
        int[] ints = artificialPlayer.chooseField();

        //then
        assertThat(ints).isEqualTo(expected);
    }


}
