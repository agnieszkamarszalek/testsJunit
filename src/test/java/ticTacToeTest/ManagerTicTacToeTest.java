package ticTacToeTest;

import org.junit.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import ticTacToe.Board;
import ticTacToe.DisplayBoard;
import ticTacToe.ManagerTicTacToe;
import ticTacToe.Player;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ManagerTicTacToeTest {

    @Test
    public void shoulMakeInstanceOfManagerTicTacToe() {
        //given


        //when;
        ManagerTicTacToe managerTicTacToe = new ManagerTicTacToe("X");

        //then
        assertThat(managerTicTacToe).isNotNull();
        assertThat(managerTicTacToe.getArtificialPlayer().getXorO()).isEqualTo("O");


    }

    @Test
    public void shouldTakeMoveFromPlayer(){
        //given
        Player mockPlayer = mock(Player.class);
        ManagerTicTacToe managerTicTacToe = new ManagerTicTacToe("X");

        //when
        when(mockPlayer.chooseField()).thenReturn("1,1");
        when(mockPlayer.getXorO()).thenReturn("X");
        when(mockPlayer
                .splitParseMove(Mockito.any(String.class)))
                .thenCallRealMethod();

        managerTicTacToe.setPlayer(mockPlayer);
        managerTicTacToe.takeMovesFromPlayers();
        String[][] boardToCheck = managerTicTacToe.getBoard().getMyBoard();
        String fieldToCheck = boardToCheck[1][1];

        //then
        assertThat(fieldToCheck).isEqualTo("X");


    }

}
