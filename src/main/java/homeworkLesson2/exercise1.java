package homeworkLesson2;

import java.util.Arrays;

public class exercise1<i> {


    public static void main(String[] args) {
        int[] array = {0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0};
        System.out.println(Arrays.toString(array));

        //Вариант 1

        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case (0):
                    array[i] = 1;
                    break;
                case (1):
                    array[i] = 0;
                    break;
            }
        }
        System.out.println(Arrays.toString(array));

        //Вариант 2

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
