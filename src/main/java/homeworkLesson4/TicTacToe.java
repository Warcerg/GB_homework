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

    public static void main(String[] args) {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }

        System.out.print(HEADER_FIRST_SYMBOL + EMPTY);
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + EMPTY);
            }
            System.out.println();
        }


}
