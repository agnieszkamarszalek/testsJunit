package ticTacToeTest;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.junit.Test;
import ticTacToe.ChoosePlayerCharacter;
import ticTacToe.ScannerWrapper;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class ChoosePlayerCharacterTest {

    @Test
    public void shouldTakeSignFromPlayer() {
        //given
        ScannerWrapper scannerMock = mock(ScannerWrapper.class);
        when(scannerMock.nextLine()).thenReturn("Q").thenReturn("V").thenReturn("O");
        ChoosePlayerCharacter choosePlayerCharacter = new ChoosePlayerCharacter();
        choosePlayerCharacter.setScanner(scannerMock);

        //when

        String chosenPlayerCharacter = choosePlayerCharacter.choosePlayerCharacter();

        //then
        assertThat(chosenPlayerCharacter).isEqualTo("O");
        verify(scannerMock, times(3)).nextLine();

    }


}
