package ticTacToeTest;

import org.junit.Test;
import ticTacToe.Player;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {
    @Test
    public void shouldMakePlayer() {
        //given
        Player player = new Player("X");
//        Scanner mockScanner = mock(Scanner.class);
//        player.setScanner(mockScanner);
//        when(mockScanner.nextLine()).thenReturn("1,1");
//        //when

        //then
        assertThat(player).isNotNull();
        assertThat(player.getXorO()).isEqualTo("X");

    }

    @Test
    public void shouldReturnReadFieldPosition(){
        //given
        Player mockPlayer = mock(Player.class);
        //when
        when(mockPlayer.takeFieldFromPlayer()).thenReturn("1, 1");
        when(mockPlayer
            .chooseCoordinates())
            .thenCallRealMethod();

        int[] checkWhichField = mockPlayer.chooseCoordinates();

        //then
        assertThat(checkWhichField).containsExactly(1,1);


    }


}
