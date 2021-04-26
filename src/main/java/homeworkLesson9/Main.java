package homeworkLesson9;

import java.util.Random;

public class Main {

    public static final int SIZE = 4;

    public static void main(String[] args) {

        int sumArray;
        String[][] array = new String[SIZE][SIZE];
        Random random = new Random();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                array[i][j] = String.valueOf(random.nextInt(10));
            }
        }

/*        printArray(array);

        try {
            sumArray = sumArrayElements(array);
            System.out.println("Sum of all array elements: " + sumArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }*/

        array[random.nextInt(SIZE)][random.nextInt(SIZE)] = "er";

        try {
            sumArray = sumArrayElements(array);
            System.out.println("Sum of all array elements: " + sumArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    private static int sumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != SIZE || array[SIZE-1].length != SIZE) {
            throw new MyArraySizeException(SIZE);
        }
        int sumOfArrayElements = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sumOfArrayElements += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sumOfArrayElements;
    }



    private static void printArray(String[][] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.printf("%4s", array[i][j]);
            }
            System.out.println();
        }
    }
}
