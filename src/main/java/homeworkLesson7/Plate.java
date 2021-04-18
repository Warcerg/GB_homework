package homeworkLesson7;

import java.util.Random;

public class Plate {
    private static int plateCount;
    private int plateNumber;
    private int food;
    private int foodDecreaseQuantity;
    private final int MaxPlateCapacity;
    Random random = new Random();

    public Plate(int food, int maxPlateCapacity) {
        plateCount++;
        this.plateNumber = plateCount;
        this.food = food;
        this.MaxPlateCapacity = maxPlateCapacity;
    }

    public void printPlateInfo() {
        System.out.println("Plate " + getPlateNumber() +"  now has: " + getFood() + " pieces");
    }

    public int getFood() {
        return food;
    }

    public int getPlateNumber() {
        return plateNumber;
    }

    public void decreaseFood(int appetite) {
        foodDecreaseQuantity = random.nextInt(appetite) + 10;
        if (food < foodDecreaseQuantity) {
            foodDecreaseQuantity = foodDecreaseQuantity - food;
            food = 0;
        } else {
            food -= foodDecreaseQuantity;
        }
        System.out.println(": " + foodDecreaseQuantity + " pieces");
        printPlateInfo();
    }


    public int getFoodDecreaseQuantity() {
        return foodDecreaseQuantity;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void fillThePlate() {
        if (food < (int)(MaxPlateCapacity / 2)) {
            food += (int)(MaxPlateCapacity / 2);
        } else {
            food += random.nextInt(MaxPlateCapacity - food);
        }
        System.out.println("The plate " + getPlateNumber() + " is filled to: " + food);
    }
}
