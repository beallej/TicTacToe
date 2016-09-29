import java.io.PrintStream;

/**
 * Created by jbealle on 9/29/16.
 */
public class Board {
    private PrintStream printStream;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void draw() {
        String bd = "1|2|3\n-----\n4|5|6\n-----\n7|8|9";
        printStream.println(bd);
    }

    public void redraw(Player player, int location) {
    }
}
