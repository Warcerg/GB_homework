package homeworkLesson2;

import java.util.Arrays;

public class exercise4 {
    public static void main(String[] args) {
        int[][] array = new int[13][13];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || (i + j) == array.length - 1) {
                    array[i][j] = 1;
                }
                System.out.printf("%3d ", array[i][j]);
            }
            System.out.println();
        }

    }
}
