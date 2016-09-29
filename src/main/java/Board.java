import java.io.PrintStream;

/**
 * Created by jbealle on 9/29/16.
 */
public class Board {
    private PrintStream printStream;
    private String[][] boardSpaces;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
        this.boardSpaces = new String[][]{{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
    }

    public void draw() {
        String bd = "";
        for (int rowNum = 0; rowNum < boardSpaces.length; rowNum ++){
            String[] row = boardSpaces[rowNum];
            for (int colNum = 0; colNum < row.length; colNum++){
                bd += boardSpaces[rowNum][colNum];
                if (colNum < 2){
                    bd += "|";
                }
            }
            if (rowNum < 2) {
                bd += "\n-----\n";
            }
        }

        printStream.println(bd);
    }

    public boolean redraw(String playerSymbol, String location) {

        int locationInt = Integer.valueOf(location) - 1;
        int row = locationInt / 3;
        int col = locationInt % 3;
        String currentSpaceValue = boardSpaces[row][col];
        if (currentSpaceValue.equals("X") || currentSpaceValue.equals("O")) {
            printStream.println("Location already taken, try again!");
            return false;
        } else {
            boardSpaces[row][col] = playerSymbol;
            draw();
            return true;
        }

    }

    public boolean locationIsValid(String location) {
        int locationInt = Integer.valueOf(location) - 1;
        int row = locationInt / 3;
        int col = locationInt % 3;
        String currentSpaceValue = boardSpaces[row][col];
        if (currentSpaceValue.equals("X") || currentSpaceValue.equals("O")) {
            return false;
        } else {
            return true;
        }
    }
}
