package homeworkLesson13;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS_COUNT = 5;
    public static CountDownLatch cdl = new CountDownLatch(CARS_COUNT);
    public static CountDownLatch finishCdl = new CountDownLatch(CARS_COUNT);
    public static Semaphore smp = new Semaphore((int) CARS_COUNT / 2);
    public static int place = 0;

    public static void main(String[] args) {
        announce();
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

    }


    public static void announce() {
        new Thread(new AnnouncerThread()).start();

    }

    static class AnnouncerThread implements Runnable {

        @Override
        public void run() {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
            try {
                cdl.await();
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                finishCdl.await();
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
