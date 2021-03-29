package homeworkLesson2;

import java.util.Arrays;

public class exercise7 {

    public static void main(String[] args) {

        int[] arrayA = {0, 1, 2, 3, 4, 5, 6};
        int[] arrayB = {0, 1, 2, 3};
        int[] arrayC = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arrayD = {1, 2, 3, 4, 5};
        int[] arrayE = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        arrayShift(arrayA, -13);
        System.out.println();
        arrayShift(arrayB, -2);
        System.out.println();
        arrayShift(arrayC, 3);
        System.out.println();
        arrayShift(arrayD, 8);
        System.out.println();
        arrayShift(arrayE, 256);
        System.out.println();
        arrayShiftV2(arrayA, -3);
        System.out.println();
        arrayShiftV2(arrayB, -19);
        System.out.println();
        arrayShiftV2(arrayC, 3);
        System.out.println();
        arrayShiftV2(arrayD, 8);
        System.out.println();
        arrayShiftV2(arrayE, 123);
        System.out.println();
    }

    private static int nCheck(int[] array, int n) {
        int nNormalization = n - n / array.length * array.length;
        if (n >= 0) {
            if ((n / array.length) >= 1) {
                n = nNormalization;
            }
        } else {
            if ((n / array.length) <= -1) {
                n = nNormalization;
            }
        }
        return n;
    }

    // Вариант со вспомогательным массивом
    private static void arrayShift(int[] array, int n) {
        System.out.println(Arrays.toString(array));
        if (n >= 0) {
            arrayShiftPlus(array, n);
        } else {
            arrayShiftMinus(array, n);
        }
    }

    private static void arrayShiftMinus(int[] array, int n) {
        int[] newArray = new int[array.length];
        n = nCheck(array, n);
        for (int i = 0; i < array.length; i++) {
            if (i + n >= 0) {
                newArray[i + n] = array[i];
            } else {
                newArray[i + n + array.length] = array[i];
            }
        }
        System.out.println(Arrays.toString(newArray));
    }

    private static void arrayShiftPlus(int[] array, int n) {
        int[] newArray = new int[array.length];
        n = nCheck(array, n);
        for (int i = 0; i < array.length; i++) {
            if (i + n < array.length) {
                newArray[i + n] = array[i];
            } else {
                newArray[i + n - array.length] = array[i];
            }
        }
        System.out.println(Arrays.toString(newArray));
    }

    // Вариант без вспомогательного массива ( идею подсмотрел в телеграмм чате группы после долгих самостоятельных попыток)
    private static void arrayShiftV2(int[] array, int n) {
        System.out.println(Arrays.toString(array));
        if (n >= 0) {
            arrayShiftPlusV2(array, n);
        } else {
            arrayShiftMinusV2(array, n);
        }
    }

    private static void arrayShiftMinusV2(int[] array, int n) {
        n = nCheck(array, n);
        int k;
        int j = array.length - 1;
        for (int i = 0; i < -n / 2; i++) {
            k = array[-n - i - 1];
            array[-n - i - 1] = array[i];
            array[i] = k;
        }
        for (int i = -n, l = 0; i <= (j - n) / 2; i++, l++) {
            k = array[j - l];
            array[j - l] = array[i];
            array[i] = k;
        }
        for (int i = 0; i < array.length / 2; i++) {
            k = array[j - i];
            array[j - i] = array[i];
            array[i] = k;
        }
        System.out.println(Arrays.toString(array));
    }

    private static void arrayShiftPlusV2(int[] array, int n) {
        n = nCheck(array, n);
        int k;
        int j = array.length - 1;
        for (int i = 0; i < (array.length - n) / 2; i++) {
            k = array[j - n - i];
            array[j - n - i] = array[i];
            array[i] = k;
        }
        for (int i = array.length - n, l = 0; i < array.length - (n / 2); i++, l++) {
            k = array[j - l];
            array[j - l] = array[i];
            array[i] = k;
        }
        for (int i = 0; i < array.length / 2; i++) {
            k = array[j - i];
            array[j - i] = array[i];
            array[i] = k;
        }
        System.out.println(Arrays.toString(array));
    }


}
