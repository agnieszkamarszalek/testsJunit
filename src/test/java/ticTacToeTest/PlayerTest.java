package ticTacToeTest;

import org.junit.Test;
import org.mockito.Mockito;
import ticTacToe.Player;

import java.util.Scanner;

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
        when(mockPlayer.chooseField()).thenReturn("1, 1");
        when(mockPlayer
            .splitParseMove(Mockito.any(String.class)))
            .thenCallRealMethod();
        String input = mockPlayer.chooseField();
        int[] checkWhichField = mockPlayer.splitParseMove(input);

        //then
        assertThat(checkWhichField).containsExactly(1,1);


    }


}
