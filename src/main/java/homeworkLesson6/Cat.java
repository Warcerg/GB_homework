package homeworkLesson6;

import java.util.Random;

public class Cat extends Animal{
    private static int catCount = 0;
    Random random = new Random();


    public Cat(String name) {
        super(name);
        maxRunDistance = random.nextInt(201) + 100;
        maxJumpHeight = random.nextDouble() * 3 + 1;
        catCount++;
    }

    public Cat(String name, int maxRunDistance, double maxJumpHeight) {
        super(name, maxRunDistance, maxJumpHeight);
        catCount++;
    }

    @Override
    public void swim(int distance) {
        System.out.println("Swim distance: " + distance);
        System.out.println( name + " can't swim. He's a cat!");
        System.out.println();
    }

    @Override
    public void swim(double distance) {
        System.out.println("Swim distance: " + distance);
        System.out.println( name + " can't swim. He's a cat!");
        System.out.println();
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void AnimalInfo() {
        System.out.println("Name: " + getName() );
        System.out.println("Max run distance: " + getMaxRunDistance());
        System.out.printf("Max jump distance: %.2f\n", getMaxJumpHeight());
        System.out.println();
    }
}
