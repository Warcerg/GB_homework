package homeworkLesson7;

import java.util.Random;

public class Cat {
    private String name;
    private int appetite;
    private int catMaxBellyFulness;
    private int catBellyFulness;
    Random random = new Random();

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.catMaxBellyFulness = random.nextInt(41) + 30;
        this.catBellyFulness = random.nextInt(21);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public int getCatMaxBellyFulness() {
        return catMaxBellyFulness;
    }

    public void setCatMaxBellyFulness(int catMaxBellyFulness) {
        this.catMaxBellyFulness = catMaxBellyFulness;
    }

    public int getCatBellyFulness() {
        return catBellyFulness;
    }

    public void setCatBellyFulness(int catBellyFulness) {
        this.catBellyFulness = catBellyFulness;
    }

    public void eat(Plate plate) throws InterruptedException {
        plate.decreaseFood(appetite);
        catBellyFill(plate);
        System.out.println();
        Thread.sleep(3000);
    }

    public void catHunger(int k, int DailyServings) {
        int hungerAmount = random.nextInt(appetite);
        if (k == DailyServings) {
            bellyFulnessDecrese(hungerAmount * 2 + 10);
            System.out.println("Cat " + getName() + " got hungry overnight. Belly fullness " + getCatBellyFulness() + " out of " + getCatMaxBellyFulness());
        } else {
            bellyFulnessDecrese(hungerAmount);
            if (hungerAmount == 0) {
                System.out.println("Somehow " + getName() + " didn't get any hungrier. What a strange cat!");
            } else {

                System.out.println("Cat " + getName() + " got a bit hungry. Belly fullness " + getCatBellyFulness() + " out of " + getCatMaxBellyFulness());
            }
        }
    }

    private void bellyFulnessDecrese(int i) {
        if (catBellyFulness - (i) <= 0) {
            catBellyFulness = 0;
        } else {
            catBellyFulness -= (i);
        }
    }

    public void catBellyFill(Plate plate){
        if (catBellyFulness + plate.getFoodDecreaseQuantity() > catMaxBellyFulness) {
            catBellyFulness = catMaxBellyFulness;
        } else {
            catBellyFulness += plate.getFoodDecreaseQuantity();
        }
        System.out.println( name + "'s belly fullness after eating: " + getCatBellyFulness() + " out of " + getCatMaxBellyFulness());
    }

    public void printCatInfo(){
        System.out.println("Cat name: " + getName() + " \n Appetite: " + getAppetite() + "   MaxBellyFullness: " + getCatMaxBellyFulness() + "  CurrentBellyFullness: " + getCatBellyFulness());
    }
}
