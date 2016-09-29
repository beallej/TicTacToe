import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by jbealle on 9/29/16.
 */
public class BoardTest {
    private PrintStream printStream;
    private Board board;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
    }

    @Test
    public void shouldDisplayBoardOnDraw() throws Exception {
        String bd = "1|2|3\n-----\n4|5|6\n-----\n7|8|9";
        board.draw();
        verify(printStream).println(bd);

    }



}