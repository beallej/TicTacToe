import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

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

    @Test
    public void shouldRedrawBoardWhenFirstPlayerMovesin1() throws Exception {
        String location = "1";
        String playerSymbol = "X";
        board.placePlayerSymbolOnBoard(playerSymbol, location);
        verify(printStream).println("X|2|3\n-----\n4|5|6\n-----\n7|8|9");
    }

    @Test
    public void shouldRedrawBoardWhenFirstPlayerMovesin8() throws Exception {
        String location = "8";
        String playerSymbol = "X";
        board.placePlayerSymbolOnBoard(playerSymbol, location);
        verify(printStream).println("1|2|3\n-----\n4|5|6\n-----\n7|X|9");
    }

    @Test
    public void shouldRedrawBoardWhenSecondPlayerMovesin8AfterFirstHasMovedin1() throws Exception {
        String location = "1";
        String playerSymbol = "X";
        board.placePlayerSymbolOnBoard(playerSymbol, location);
        String location2 = "8";
        String playerSymbol2 = "O";
        board.placePlayerSymbolOnBoard(playerSymbol2, location2);
        verify(printStream).println("X|2|3\n-----\n4|5|6\n-----\n7|O|9");
    }

    @Test
    public void shouldReportInvalidOnFilledLocation() throws Exception {
        board.placePlayerSymbolOnBoard("X", "1");
        assertFalse(board.locationIsValid("1"));

    }

    @Test
    public void shouldReportValidOnUnfilledLocation() throws Exception {
        assertTrue(board.locationIsValid("1"));
    }

    @Test
    public void shouldReportFullWhenBoardIsFull() throws Exception {
        for (int space = 1; space < 10; space ++) {
            board.placePlayerSymbolOnBoard("X", String.valueOf(space));
        }
        assertTrue(board.isFull());
    }

    @Test
    public void shouldReportNotFullWhenBoardIsEmpty() throws Exception {
        assertFalse(board.isFull());
    }

    @Test
    public void shouldReportNotFullWhenBoardIsPartiallyFul() throws Exception {
        for (int space = 1; space < 5; space ++) {
            board.placePlayerSymbolOnBoard("X", String.valueOf(space));
        }
        assertFalse(board.isFull());
    }
}