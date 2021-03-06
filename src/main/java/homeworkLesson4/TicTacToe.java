package homeworkLesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static final char HEADER_FIRST_SYMBOL = '◆';
    static final String EMPTY = " ";

    static final char DOT_EMPTY = '*';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = '0';

    static int size;
    static int winCondition;

    static char[][] MAP;
    static final Scanner in = new Scanner(System.in);
    static final Random random = new Random();

    static int turnsCount = 0;
    static int lastTurn; //  а нужен ли?
    static int lastPlayedRow;
    static int lastPlayedColumn;


    public static void main(String[] args) {

        setTheGame();

        turnGame();

    }

    private static void turnGame() {
        do{
            initMap();

            printMap();

            playGame();


        } while(newGameCheck());

        endGame();
    }

    private static void setTheGame() {

        boolean isInputValid = true;

        System.out.println("Let's play a TicTacToe! " +
                "\nRecommended game field size > 2 ");
        do{
            System.out.println("Please choose a size of a game field: ");
            if(in.hasNextInt()){
                size = in.nextInt();
            } else {
                processingIncorrectInputGameSetting();
                isInputValid = false;
                continue;
            }

            System.out.println("Please choose a win condition. \nSet how many marks (X or 0) are needed are needed for the win?: ");
            if(in.hasNextInt()){
                winCondition = in.nextInt();
            } else {
                processingIncorrectInputGameSetting();
                isInputValid = false;
            }

        } while (!(isInputValid && checkingGameSettings(size, winCondition)));

        MAP = new char[size][size];
    }

    private static boolean checkingGameSettings(int size, int winCondition) {
        if (size < 3) {
            System.out.println("Error! Please enter game field size that > 2");
            return false;
        } else if (winCondition < 3 || winCondition > size) {
            System.out.println("Error! Please enter a win condition that > 2 and not higher than the game field size!");
            return false;
        }
        return true;
    }

    private static void processingIncorrectInputGameSetting() {
        System.out.println("Error!  PLease enter the positive number > 2");
        in.nextLine();
    }

    private static void initMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHeaderMap();

        printBodyMap();
    }

    private static void printHeaderMap() {
        printByMapSize(HEADER_FIRST_SYMBOL);
        for (int i = 0; i < size; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printMapNumber(int i) {
        if (size > 9) {
            if (i > 8) {
                System.out.print(i + 1 + EMPTY);
            } else {
                System.out.print(i + 1 + EMPTY + EMPTY);
            }
        } else {
            System.out.print(i + 1 + EMPTY);
        }
    }

    private static void printByMapSize(char header) {
        if (size > 9) {
            System.out.print(header + EMPTY + EMPTY);
        } else {
            System.out.print(header + EMPTY);
        }
    }

    private static void printBodyMap() {
        for (int i = 0; i < size; i++) {
            printMapNumber(i);
            for (int j = 0; j < size; j++) {
                printByMapSize(MAP[i][j]);
            }
            System.out.println();
        }
    }

    private static void playGame() {
        do {
            humanTurn();
            printMap();
            if (checkEnd(DOT_HUMAN, lastPlayedRow, lastPlayedColumn)) {
                break;
            }

            aiTurn();
            printMap();
            if (checkEnd(DOT_AI, lastPlayedRow, lastPlayedColumn)) {
                break;
            }

        } while (true);
    }

    private static void humanTurn() {
        int rowNumber;
        int columnNumber;
        boolean isInputValid;

        System.out.println("\n Human turn. Please enter the row and column number.");
        do {
            rowNumber = -1;
            columnNumber = -1;
            isInputValid = true;

            System.out.print("Row: ");
            if (in.hasNextInt()) {
                rowNumber = in.nextInt() - 1;
            } else {
                processingIncorrectInput();
                isInputValid = false;
                continue;
            }

            System.out.print("Column: ");
            if (in.hasNextInt()) {
                columnNumber = in.nextInt() - 1;
            } else {
                processingIncorrectInput();
                isInputValid = false;
            }

        } while (!(isInputValid && isHumanTurnValid(rowNumber, columnNumber)));

        MAP[rowNumber][columnNumber] = DOT_HUMAN;
        turnsCount++;
        rememberLastPlayedPosition(rowNumber, columnNumber);

    }

    private static void rememberLastPlayedPosition(int rowNumber, int columnNumber) {
        lastPlayedRow = rowNumber;
        lastPlayedColumn = columnNumber;
    }

    private static boolean isHumanTurnValid(int rowNumber, int columnNumber) {
        if (!isNumbersValid(rowNumber, columnNumber)) {
            System.out.println("\n Check row and column values");
            return false;
        } else if (!isCellFree(rowNumber,columnNumber)){
            System.out.println("\n You chose occupied cell");
            return false;
        }
        return true;
    }

    private static boolean isCellFree(int rowNumber, int columnNumber) {
        return MAP[rowNumber][columnNumber] == DOT_EMPTY;
    }

    private static boolean isNumbersValid(int rowNumber, int columnNumber) {
        return rowNumber < size && rowNumber >= 0 && columnNumber < size && columnNumber >= 0;
    }

    private static void processingIncorrectInput() {
        System.out.println("Error!  PLease enter the number within field range");
        in.nextLine();
    }

    private static boolean checkEnd(char symbol, int lastPlayedRow, int lastPlayedColumn) {
        if (checkWin(symbol, lastPlayedRow, lastPlayedColumn)){
            if (symbol == DOT_HUMAN){
                System.out.println("Hooray! You won!");
            } else {
                System.out.println("You lost....AI have prevailed!");
            }
            return true;
        } else if (isMapFull()){
            System.out.println("Draw!");
            return true;
        }

        return false;
    }

    private static boolean checkWin(char symbol, int lastPlayedRow, int lastPlayedColumn) {

        return checkWinVertical(symbol, lastPlayedColumn)
                || checkWinHorizontal(symbol, lastPlayedRow)
                || checkWinDiagonal(symbol, lastPlayedRow, lastPlayedColumn)
                || checkWinAntiDiagonal(symbol, lastPlayedRow, lastPlayedColumn);
    }

    private static boolean checkWinVertical(char symbol, int lastPlayedColumn) {
        int symbolCount = 0;
        for (int i = 0; i < size; i++) {
            if (MAP[i][lastPlayedColumn] == symbol) {
                symbolCount++;
                if (symbolCount == winCondition) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkWinHorizontal(char symbol, int lastPlayedRow) {
        int symbolCount = 0;
        for (int i = 0; i < size; i++) {
            if (MAP[lastPlayedRow][i] == symbol){
                symbolCount++;
                if (symbolCount == winCondition){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkWinDiagonal(char symbol, int lastPlayedRow, int lastPlayedColumn) {
        int symbolCount = 0;
        int x = lastPlayedColumn;
        int y = lastPlayedRow;
        while ( x>0 && y>0){
            x--;
            y--;
        }
        return diagonalSymbolWinCount(symbol, symbolCount, x, y);
    }

    private static boolean diagonalSymbolWinCount(char symbol, int symbolCount, int x, int y) {
        for (int i = x, j = y; i < size && j < size; i++, j++) { //
            if (MAP[i][j] == symbol){
                symbolCount++;
                if (symbolCount == winCondition){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkWinAntiDiagonal(char symbol, int lastPlayedRow, int lastPlayedColumn) {
        int symbolCount = 0;
        int x = lastPlayedColumn;
        int y = lastPlayedRow;
        while ( x > 0 && y < size - 1){
            x--;
            y++;
        }
        return antiDiagonalSymbolWinCount(symbol, symbolCount, x, y);
    }

    private static boolean antiDiagonalSymbolWinCount(char symbol, int symbolCount, int x, int y) {
        for (int i = x, j = y; i < size && j >= 0; i++, j--) { //
            if (MAP[i][j] == symbol){
                symbolCount++;
                if (symbolCount == winCondition){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isMapFull() {
        return turnsCount == size * size;
    }

    private static void aiTurn() {
        int rowNumber;
        int columnNumber;

        System.out.println("\n AI turn.");

        do {
            rowNumber = random.nextInt(size);
            columnNumber = random.nextInt(size);
        } while (!isCellFree(rowNumber, columnNumber));

        MAP[rowNumber][columnNumber] = DOT_AI;
        turnsCount++;
        rememberLastPlayedPosition(rowNumber, columnNumber);
    }

    private static boolean newGameCheck() {
        boolean isUserInputValid = true;
        boolean newgame = false;
        do {
            System.out.println("\nGame has ended. Want to play another round? \nY/N? : ");
            String userDecision = in.next().toLowerCase();
            if (userDecision.equals("yes") || userDecision.equals("y")){
                newgame = true;
            } else if (userDecision.equals("no") || userDecision.equals("n")){
                newgame = false;
            } else {
                System.out.println("Response has not been acknowledged. Only 'yes' or 'no' are accepted. Please try again." );
                isUserInputValid = false;
            }
        } while (!isUserInputValid);
        return newgame;
    }

    private static void endGame() {
        System.exit(0);
    }


}
