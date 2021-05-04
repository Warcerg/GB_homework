package homeworkLesson12;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) throws InterruptedException {
        float[] arr = new float[size];
        method1(arr);
        method2(arr);
    }

    private static void method1(float[] arr) {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
/*        System.out.println(arr[2500]);
        System.out.println(arr[7500]);*/
        System.out.println("Method 1: " + (System.currentTimeMillis() - a));
    }

    private static void method2(float[] arr) throws InterruptedException {
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        Thread t1 = new Thread(() -> arrCalc(arr, a1, 0));
        Thread t2 = new Thread(() -> arrCalc(arr, a2, h));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Method 2: " + (System.currentTimeMillis() - a));
/*        System.out.println(arr[2500]);
        System.out.println(arr[7500]);*/
    }

    private static void arrCalc(float[] arr, float[] a, int j) {
        System.arraycopy(arr, j, a, 0, h);
        for (int i = 0; i < h; i++) {
            a[i] = (float) (a[i] * Math.sin(0.2f + (i+j) / 5) * Math.cos(0.2f + (i+j) / 5) * Math.cos(0.4f + (i+j) / 2));
        }
        System.arraycopy(a, 0, arr, j, h);
    }


}
