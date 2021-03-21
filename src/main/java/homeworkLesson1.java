public class homeworkLesson1 {

    public static void main(String[] args) {
        printTask(2);
        task2();
        printTask(3);
        System.out.println(task3(3.14f, 6.25f, 25f, 5f));
        System.out.println(task3( 2.17f, 4.43f, 68f, 14.5f));
        printTask(4);
        System.out.println(task4(7, 13));
        System.out.println(task4(2, 5));
        printTask(5);
        task5(-4);
        task5(6);
        printTask(6);
        System.out.println(task6(4));
        System.out.println(task6(-2));
        printTask(7);
        task7("Андрей");
        printTask(8);
        task8(3);
        task8(16);
        task8(100);
        task8(400);
        task8(1200);
        task8(1500);
    }

    private static void printTask(int a) {
        System.out.println("Задание " + a + ":");
    }

    public static void task2(){
        byte a = 127;
        short b = 32425;
        int c = 7;
        long d = 3000000000L;
        float e = 3.14f;
        double f = -254.137;
        char mizu = '水';
        char ki = '\u2f55';
        boolean h = true;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(mizu);
        System.out.println(ki);
        System.out.println(h);
    }

    public static float task3(float a, float b, float c, float d){
        return (a * (b + c / d));
    }

    public static boolean task4( int a, int b){
        return a + b >= 10 & a + b <= 20;
    }

    public static void task5(int a){
        if ( a >= 0){
            System.out.println("Число " + a + " положительное");
        } else System.out.println("Число " + a + " отрицательное");
    }

    public static boolean task6(int a){
        return !(a >= 0);
    }

    public static void task7(String name){
        System.out.println("Привет, " + name + "!");
    }

    public static void task8(int a){
        if ((a % 4 == 0) & ((a % 400 == 0) || !(a % 100 == 0))) {
            System.out.println("Год " + a + " високосный");
        } else System.out.println("Год " + a + " не является високосным");
    }

}
