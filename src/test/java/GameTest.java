import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by jbealle on 9/29/16.
 */
public class GameTest {

    private Board board;
    private Game game;
    private Player player1;
    private Player player2;

    @Before
    public void setup(){
        board = mock(Board.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        game = new Game(board, player1, player2);
        when(board.isFull()).thenReturn(false, false, false, false, true);


    }

    @Test
    public void shouldDrawBoardOnStart() throws Exception {
        game.start();
        verify(board).draw();
    }

    @Test
    public void firstPlayerShouldBeAskedToMakeMoveAfterBoardDrawn() throws Exception {
        game.start();
        verify(player1, atLeastOnce()).makeMove();
    }


    @Test
    public void player2ShouldMakeMoveAfterPlayer1(){
        game.start();
        verify(player2, atLeastOnce()).makeMove();
    }


    @Test
    public void playerOneShouldNotMakeMoveIfBoardIsFull() throws Exception {
        when(board.isFull()).thenReturn(true);
        game.start();
        verify(player1, never()).makeMove();

    }

    @Test
    public void playerTwoShouldNotMakeMoveIfBoardIsFullInitially() throws Exception {
        when(board.isFull()).thenReturn(true, true);
        game.start();
        verify(player2, never()).makeMove();

    }

    @Test
    public void playerTwoShouldNotMakeMoveIfBoardBecomesFull() throws Exception {
        when(board.isFull()).thenReturn(false, true);
        game.start();
        verify(player2, never()).makeMove();

    }

}
