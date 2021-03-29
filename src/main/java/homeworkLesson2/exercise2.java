package homeworkLesson2;

import java.util.Arrays;

public class exercise2 {


    public static void main(String[] args) {
        int[] arrayA = new int[8];
        int add = 3;

        for (int i = 1; i < arrayA.length; i++) {
            arrayA[i] = arrayA[i - 1] + add;
        }
        System.out.println(Arrays.toString(arrayA));

    }
}
