package homeworkLesson2;

public class exercise6 {

    public static void main(String[] args) {

        int[] arrayA = {1, 1, 1, 1, 1, 1};
        int[] arrayB = {1, 6, 8, 25};
        int[] arrayC = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] arrayD = {1, 1, 1, 2, 1};
        System.out.println(arrayCheck(arrayA));
        System.out.println(arrayCheck(arrayB));
        System.out.println(arrayCheck(arrayC));
        System.out.println(arrayCheck(arrayD));
        // Second variant
        System.out.println(arrayCheckB(arrayA));
        System.out.println(arrayCheckB(arrayB));
        System.out.println(arrayCheckB(arrayC));
        System.out.println(arrayCheckB(arrayD));
    }


    private static boolean arrayCheck(int[] array) {
        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            int k = array.length - 1;
            while (k != i) {
                rightSum += array[k--];
            }
            for (int j = 0; j <= i; j++) {
                leftSum += array[j];
            }
            if (leftSum == rightSum) {
                check = true;
                break;
            }

        }
        return check;
    }

    private static boolean arrayCheckB(int[] array) {
        boolean check = false;
        int halfArraySum = 0;
        int leftSum = 0;
        int k = 0;
        while (k < array.length) {
            halfArraySum += array[k];
            k++;
        }
        halfArraySum /= 2;
        for (int i = 0; i < array.length; i++) {
            leftSum += array[i];
            if (leftSum == halfArraySum) {
                check = true;
                break;
            }
        }
        return check;
    }

}
