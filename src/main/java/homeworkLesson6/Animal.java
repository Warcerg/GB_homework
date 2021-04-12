package homeworkLesson6;

import java.sql.SQLOutput;

public class Animal {
    protected String name;
    protected int maxRunDistance;
    protected int maxSwimDistance;
    protected double maxJumpHeight;
    private static int animalsCount = 0;


    public Animal(String name) {
        this.name = name;
        animalsCount++;
    }

    public Animal(String name, int maxRunDistance, double maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        animalsCount++;
    }

    public Animal(String name, int maxRunDistance, int maxSwimDistance, double maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpHeight = maxJumpHeight;
        animalsCount++;
    }

    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println("Run distance: " + distance);
            System.out.println(name + " ran " + distance + " meters");
            System.out.println();
        } else {
            System.out.println("Run distance: " + distance);
            System.out.println(name + " couldn't run the whole distance." + name + " only ran " + maxRunDistance + " meters!");
            System.out.println();
        }
    }

    public void run(double distance) {
        if (distance <= maxRunDistance) {
            System.out.println("Run distance: " + distance);
            System.out.println(name + " ran " + distance + " meters");
            System.out.println();
        } else {
            System.out.println("Run distance: " + distance);
            System.out.println(name + " couldn't run the whole distance. " + name + " only ran " + maxRunDistance + " meters!");
            System.out.println();
        }
    }

    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println("Jump height: " + height);
            System.out.println(name + " jumped to a height of " + height + " meters");
            System.out.println();
        } else {
            System.out.println("Jump height: " + height);
            System.out.printf(name + " couldn't jump to the required height. "+ name + " only jumped to a height of  %.2f meters\n",  maxJumpHeight);
            System.out.println();
        }
    }

    public void jump(double height) {
        if (height <= maxJumpHeight) {
            System.out.println("Jump height: " + height);
            System.out.println(name + " jumped to a height of " + height + " meters");
            System.out.println();
        } else {
            System.out.println("Jump height: " + height);
            System.out.printf(name + " couldn't jump to the required height. " + name + " only jumped to a height of  %.2f meters\n",  maxJumpHeight);
            System.out.println();
        }
    }

    public void swim(int distance) {
        if (distance <= maxSwimDistance) {
            System.out.println("Swim distance: " + distance);
            System.out.println(name + " swam " + distance + " meters");
            System.out.println();
        } else {
            System.out.println("Swim distance: " + distance);
            System.out.println(name + " couldn't swam the whole distance. " + name + " only swam " + maxSwimDistance + " meters!");
            System.out.println();
        }
    }

    public void swim(double distance) {
        if (distance <= maxSwimDistance) {
            System.out.println("Swim distance: " + distance);
            System.out.println(name + " swam " + distance + " meters");
            System.out.println();
        } else {
            System.out.println("Swim distance: " + distance);
            System.out.println(name + " couldn't swam the whole distance. " + name + " only swam " + maxSwimDistance + " meters!");
            System.out.println();
        }
    }

    public  void AnimalInfo(){
        System.out.println("Name: " + getName() );
        System.out.println("Max run distance: " + getMaxRunDistance());
        System.out.printf("Max jump distance: %.2f\n", getMaxJumpHeight());
        System.out.println("Max swim distance: " + getMaxSwimDistance());
        System.out.println();
    }

    public static int getAnimalsCount() {
        return animalsCount;
    }

    public void setAnimalsCount(int animalsCount) {
        Animal.animalsCount = animalsCount;
    }

    public String getName() {
        return name;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public int getMaxSwimDistance() {
        return maxSwimDistance;
    }

    public double getMaxJumpHeight() {
        return maxJumpHeight;
    }
}
