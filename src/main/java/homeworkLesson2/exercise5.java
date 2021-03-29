package homeworkLesson2;

import java.util.Arrays;

public class exercise5 {

    public static void main(String[] args) {
        int[] array = { 5, 8, 3, 12, 9, 4, 5, 2, 13, 6, 1, 9};
        int max = array[0];
        int min = array[0];
        for( int i = 0; i < array.length; i++){
            if (max < array[i]){
                max = array[i];
            }
            if (min > array[i]){
                min = array[i];
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("Максимальное число массива: " + max);
        System.out.println("Минимальное число массива: " + min);
    }
}
