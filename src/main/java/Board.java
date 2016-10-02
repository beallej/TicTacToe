import javafx.util.Pair;

import java.io.PrintStream;

/**
 * Created by jbealle on 9/29/16.
 */
public class Board {
    private PrintStream printStream;
    private String[] boardSpaces;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
        this.boardSpaces = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    }

    public void draw() {
        String bd = String.format("%s|%s|%s\n-----\n%s|%s|%s\n-----\n%s|%s|%s", boardSpaces);
        printStream.println(bd);
    }

    public void placePlayerSymbolOnBoard(String playerSymbol, String location) {

        int locationInt = Integer.valueOf(location) - 1;
        boardSpaces[locationInt] = playerSymbol;
        draw();
    }


    public String getCurrentSpaceValue(int location) {
        return boardSpaces[location];
    }

    public boolean locationIsValid(String location) {
        int locationInt = Integer.valueOf(location) - 1;
        String currentSpaceValue = getCurrentSpaceValue(locationInt);
        if (currentSpaceValue.equals("X") || currentSpaceValue.equals("O")) {
            return false;
        } else {
            return true;
        }
    }

}
