import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.nio.Buffer;

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

    @Before
    public void setup() {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        player = new Player(bufferedReader, printStream, board);

    }
    @Test
    public void shouldGetInput() throws Exception {
        when(board.locationIsValid("1")).thenReturn(true);
        when(bufferedReader.readLine()).thenReturn("1");
        assertEquals(player.pickLocation(), "1");
    }

    @Test
    public void gameShouldAllowPlayer2ToRepickAfterPickingTakenLocation() throws Exception {
        when(board.locationIsValid("1")).thenReturn(false);
        when(board.locationIsValid("8")).thenReturn(true);
        when(bufferedReader.readLine()).thenReturn("1", "8");
        assertEquals(player.pickLocation(), "8");
    }


}