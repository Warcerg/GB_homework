package homeworkLesson6;

import java.util.Random;

public class Dog extends Animal{
    private static int dogCount = 0;
    Random random = new Random();

    public Dog(String name) {
        super(name);
        maxRunDistance = random.nextInt(501) + 300;
        maxJumpHeight = random.nextDouble() * 1.3 + 1;
        maxSwimDistance = random.nextInt(46) + 5;
        dogCount++;
    }

    public Dog(String name, int maxRunDistance, int maxSwimDistance, double maxJumpHeight) {
        super(name, maxRunDistance, maxSwimDistance, maxJumpHeight);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }
}

