package homeworkLesson7;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int eatingCount = 0;
        int cycle = 0;
        final int DailyServings = 3;
        Cat cat1 = new Cat("Pushinka", 15);
        Cat cat2 = new Cat("Shashlik", 20);
        Cat cat3 = new Cat("Kebab", 14);
        Plate plate1 = new Plate(100, 150);
        Plate plate2 = new Plate(80, 145);
        Plate plate3 = new Plate(110, 120);

        Cat[] cats = {cat1, cat2, cat3};
        Plate[] plates = {plate1, plate2, plate3};


        while (cycle < 100) {
            System.out.println("Day " + (cycle + 1));
            System.out.println();
            for (int k = 1; k <= DailyServings; k++) {
                for (int i = 0; i < cats.length; i++) {
                    if (cats[i].getCatBellyFulness() != cats[i].getCatMaxBellyFulness()) {
                        int n = choosingPlateNumber(plates);
                        System.out.print(cats[i].getName() + " eats from the plate " + (n + 1));
                        cats[i].eat(plates[n]);
                        eatingCount++;
                        if (eatingCount == 9) {
                            System.out.println();
                            for (int j = 0; j < plates.length; j++) {
                                plates[j].fillThePlate();
                            }
                            System.out.println();
                            eatingCount = 0;
                        }
                    } else {
                        System.out.println("Cat " + cats[i].getName() + " is not hungry. " + cats[i].getName() + " skips the eating!");
                    }
                }
                for (int i = 0; i < cats.length; i++) {
                    cats[i].catHunger(k, DailyServings);
                }
                System.out.println();
            }
            cycle++;
        }

    }

    private static int choosingPlateNumber(Plate[] plates) {
        Random rnd = new Random();
        boolean isPlateEmpty;
        int plateNumber;
        do {
            isPlateEmpty = false;
            plateNumber = rnd.nextInt(plates.length);
            if (plates[plateNumber].getFood() == 0) {
                isPlateEmpty = true;
            }
        } while (isPlateEmpty);
        return plateNumber;
    }
}
