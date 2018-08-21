package ticTacToeTest;

import org.junit.Test;

import org.mockito.InOrder;
import ticTacToe.ArtificialPlayer;
import ticTacToe.Board;
import ticTacToe.ManagerTicTacToe;
import ticTacToe.Player;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.inOrder;
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

//    @Test
//    public void shouldTakeMoveFromPlayer(){
//        //given
//        Player mockPlayer = mock(Player.class);
//        ManagerTicTacToe managerTicTacToe = new ManagerTicTacToe("X");
//
//        //when
//        when(mockPlayer.takeFieldFromPlayer()).thenReturn("1,1");
//        when(mockPlayer.getXorO()).thenReturn("X");
//        when(mockPlayer
//                .chooseCoordinates())
//                .thenCallRealMethod();
//
//        managerTicTacToe.setPlayer(mockPlayer);
//        managerTicTacToe.takeMoveFromPlayer();
//        String[][] boardToCheck = managerTicTacToe.getBoard().getMyBoard();
//        String fieldToCheck = boardToCheck[1][1];
//
//        //then
//        assertThat(fieldToCheck).isEqualTo("X");
//    }

//    @Test
//    public void shouldTakeMoveFromArtificialPlayer(){
//        //given
//        ManagerTicTacToe managerTicTacToe = new ManagerTicTacToe("X");
//        String[][] givenBoard = new String[][]{{"X","X","X"}, {"X"," ","X"}, {"X","X","X"}};
//        Board board = new Board(givenBoard);
//        managerTicTacToe.setBoard(board);
//
//        //when
//        managerTicTacToe.takeMovesFromArtificialPlayer();
//        String fieldToCheck = givenBoard[1][1];
//
//        //then
//        assertThat(fieldToCheck).isEqualTo("O");
//    }

    @Test
    public void shouldCheckMovesOrder(){
        //given
        Player mockPlayer = mock(Player.class);
        ArtificialPlayer mockArtificialPlayer = mock(ArtificialPlayer.class);
        ManagerTicTacToe managerTicTacToe = new ManagerTicTacToe("X");
        managerTicTacToe.setPlayer(mockPlayer);
        managerTicTacToe.setArtificialPlayer(mockArtificialPlayer);

        when(mockPlayer.takeFieldFromPlayer()).thenReturn("1, 1");
        when(mockPlayer
                .chooseCoordinates())
                .thenCallRealMethod();
        when(mockArtificialPlayer.chooseCoordinates()).thenReturn(new int[]{1,2});

        InOrder inOrder = inOrder(mockPlayer, mockArtificialPlayer);
        //when
        managerTicTacToe.playGame();

        //then
        inOrder.verify(mockPlayer).chooseCoordinates();
        inOrder.verify(mockArtificialPlayer).chooseCoordinates();

    }

}
