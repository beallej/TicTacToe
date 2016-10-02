import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jbealle on 9/29/16.
 */
public class PlayerTest {
    private Player player;
    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private Board board;
    private String playerSymbol;

    @Before
    public void setup() {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        playerSymbol = "K";
        player = new Player(bufferedReader, printStream, board, playerSymbol);

    }
    @Test
    public void shouldGetInput() throws Exception {
        when(board.locationIsValid("1")).thenReturn(true);
        when(bufferedReader.readLine()).thenReturn("1");
        assertEquals(player.pickLocation(), "1");
    }


    @Test
    public void shouldTellPlayer2WhenPickedTakenLocation() throws Exception {
        when(board.locationIsValid("1")).thenReturn(false);
        when(board.locationIsValid("8")).thenReturn(true);
        when(bufferedReader.readLine()).thenReturn("1", "8");
        player.pickLocation();
        verify(printStream).println("Location taken, try again!");
    }

    @Test
    public void shouldAllowPlayer2ToRepickAfterPickingTakenLocation() throws Exception {
        when(board.locationIsValid("1")).thenReturn(false);
        when(board.locationIsValid("8")).thenReturn(true);
        when(bufferedReader.readLine()).thenReturn("1", "8");
        assertEquals(player.pickLocation(), "8");
    }


    @Test
    public void firstPlayerShouldBeAskedForLocationWhenMakingMove() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.locationIsValid("1")).thenReturn(true);
        player.makeMove();
        verify(printStream).println("Pick a location");
    }



    @Test
    public void gameShouldRedrawBoardAfterPlayer1PicksLocation() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.locationIsValid("1")).thenReturn(true);
        player.makeMove();
        verify(board).placePlayerSymbolOnBoard(playerSymbol, "1");
    }

    @Test
    public void boardShouldBeMarkedWithSameSymbolAsPlayerMakingMove() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1");
        when(board.locationIsValid("1")).thenReturn(true);
        player.makeMove();
        verify(board).placePlayerSymbolOnBoard(playerSymbol, "1");
    }


}