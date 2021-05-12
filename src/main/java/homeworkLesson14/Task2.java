package homeworkLesson14;

import java.util.ArrayList;
import java.util.Arrays;


public class Task2 {
    public static final int parA = 1;
    public static final int parB = 4;
    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 4, 4, 1, 1};
        System.out.println(Arrays.toString(arr) + " -> " + arrCheck(arr));

    }

    public static boolean arrCheck(int[] arr) {

        ArrayList<Integer> al = new ArrayList<>();
        for (int i : arr) {
            al.add(i);
        }
        return al.contains(parA) && al.contains(parB) && !otherNumbersCheck(al);
    }

    private static boolean otherNumbersCheck(ArrayList<Integer> al) {
        for (Integer i : al) {
            if (!(i == parA || i == parB)) {
                return true;
            }
        }
        return false;
    }
}
