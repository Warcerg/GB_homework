package homeworkLesson2;

import java.util.Arrays;

public class exercise3 {

    public static void main(String[] args) {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int condition = 6;
        int mutliplicator = 2;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < condition){
                array[i] *= mutliplicator;
            }
        }
        System.out.println(Arrays.toString(array));
    }














}
