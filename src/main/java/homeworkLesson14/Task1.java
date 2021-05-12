package homeworkLesson14;


import java.util.Arrays;

public class Task1 {
    public static final int parA = 4;

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 2, 5, 4, 3, 8, 1, 2};
        task1Method(arr);

    }

    private static void task1Method(int[] arr) {
        try {
            System.out.println("Enter: " + Arrays.toString(arr) + " -> Exit: " + Arrays.toString(arrConversion(arr)));
        } catch (RuntimeException e){
            e.printStackTrace();
        }
    }

    public static int[] arrConversion(int[] arr) {
        int position = 0;
        boolean parCheck = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == parA) {
                parCheck = false;
                position = i;
            }
        }
        if (parCheck) {
            throw new RuntimeException(Arrays.toString(arr) + " does not contain " + parA);
        }
        int newArrayLength = arr.length - 1 - position;
        int[] convArray = new int[newArrayLength];
        for (int i = 0; i < convArray.length; i++) {
            convArray[i] = arr[i + position + 1];
        }
        return convArray;
    }


}
