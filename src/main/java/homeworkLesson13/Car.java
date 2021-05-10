package homeworkLesson13;


import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static Semaphore smp;
    private static boolean syncSwitch = true;
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.smp = smp;
    }

    @Override
    public void run(){
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            MainClass.cdl.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            MainClass.cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
            if (i == race.getStages().size()-1){
                MainClass.finishCdl.countDown();
                MainClass.place++;
                if (MainClass.place == 1){
                    System.out.println(this.name + " занял 1-ое место!");
                }
            }
        }
    }
}


