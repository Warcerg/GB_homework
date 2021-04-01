package homeworkLesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static final int SIZE = 3;

    static final char HEADER_FIRST_SYMBOL = '#';
    static final String EMPTY = " ";

    static final char DOT_EMPTY = '*';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = '0';

    static final char[][] MAP = new char[SIZE][SIZE];
    static final Scanner in = new Scanner(System.in);
    static final Random random = new Random();
    static int turnsCount = 0;

    public static void main(String[] args) {

        turnGame();

    }

    private static void turnGame() {
        initMap();

        printMap();

        playGame();

        endGame();
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        printHeaderMap();

        printBodyMap();
    }

    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_SYMBOL + EMPTY);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printBodyMap() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + EMPTY);
            }
            System.out.println();
        }
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + EMPTY);
    }

    private static void playGame() {
        do {
            humanTurn();
            printMap();
            if (checkEnd(DOT_HUMAN)){
                break;
            }

            aiTurn();
            printMap();
          if (checkEnd(DOT_AI)){
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
        return rowNumber < SIZE && rowNumber >= 0 && columnNumber < SIZE && columnNumber >= 0;
    }

    private static void processingIncorrectInput() {
        System.out.println("Error!  PLease enter the number within field range");
        in.nextLine();
    }

    private static boolean checkEnd(char symbol) {
        if (checkWin(symbol)){
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

    private static boolean checkWin(char symbol) {
        if(MAP[0][0] == symbol && MAP[0][1] == symbol && MAP[0][2] == symbol) return true;
        if(MAP[1][0] == symbol && MAP[1][1] == symbol && MAP[1][2] == symbol) return true;
        if(MAP[2][0] == symbol && MAP[2][1] == symbol && MAP[2][2] == symbol) return true;

        if(MAP[0][0] == symbol && MAP[1][0] == symbol && MAP[2][0] == symbol) return true;
        if(MAP[0][1] == symbol && MAP[1][1] == symbol && MAP[2][1] == symbol) return true;
        if(MAP[0][2] == symbol && MAP[1][2] == symbol && MAP[2][2] == symbol) return true;

        if(MAP[0][0] == symbol && MAP[1][1] == symbol && MAP[2][2] == symbol) return true;
        if(MAP[2][0] == symbol && MAP[1][1] == symbol && MAP[0][2] == symbol) return true;

        return false;
    }

    private static boolean isMapFull() {
        return turnsCount == SIZE * SIZE;
    }

    private static void aiTurn() {
        int rowNumber;
        int columnNumber;

        System.out.println("\n AI turn.");

        do {
            rowNumber = random.nextInt(SIZE);
            columnNumber = random.nextInt(SIZE);
        } while (!isCellFree(rowNumber, columnNumber));

        MAP[rowNumber][columnNumber] = DOT_AI;
        turnsCount++;
    }

    private static void endGame() {
        System.exit(0);
    }


}
