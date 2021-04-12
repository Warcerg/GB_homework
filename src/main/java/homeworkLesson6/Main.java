package homeworkLesson6;

public class Main {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Felix");
        Cat cat2 = new Cat("Thomas");
        Cat cat3 = new Cat("GrumpyCat");
        Dog dog1 = new Dog("Rex");
        Dog dog2 = new Dog("Lassie", 600, 100, 50);


        Animal[] animals = {cat1, cat2, cat3, dog1, dog2};

/*        Competition(animals, 150, 2, 8);*/
        Competition(animals, 200.5, 1.7, 8.8);

        animalsPrintInfo(animals);

    }

    private static void animalsPrintInfo(Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            animals[i].AnimalInfo();

        }
    }

    public static void Competition(Animal[] animals, int runDistance, int height, double swimDistance) {
        competitionAnnouncement(animals);

        for (int i = 0; i < animals.length; i++) {
            System.out.println("Participant " + animals[i].name);
            animals[i].run(runDistance);
            animals[i].jump(height);
            animals[i].swim(swimDistance);
        }
        System.out.println("That's all for today. Thank you for visiting our competition! \nHave a good day!");
    }

    public static void Competition(Animal[] animals, double runDistance, double height, double swimDistance) {
        competitionAnnouncement(animals);

        for (int i = 0; i < animals.length; i++) {
            System.out.println("Participant " + animals[i].name);
            animals[i].run(runDistance);
            animals[i].jump(height);
            animals[i].swim(swimDistance);
        }
        System.out.println("That's all for today. Thank you for visiting our competition! \nHave a good day!");
    }

    public static void Competition(Animal[] animals, int runDistance, double height, double swimDistance) {
        competitionAnnouncement(animals);

        for (int i = 0; i < animals.length; i++) {
            System.out.println("Participant " + animals[i].name);
            animals[i].run(runDistance);
            animals[i].jump(height);
            animals[i].swim(swimDistance);
        }
        System.out.println("That's all for today. Thank you for visiting our competition! \nHave a good day!");
    }

    public static void Competition(Animal[] animals, double runDistance, int height, double swimDistance) {
        competitionAnnouncement(animals);

        for (int i = 0; i < animals.length; i++) {
            System.out.println("Participant " + animals[i].name);
            animals[i].run(runDistance);
            animals[i].jump(height);
            animals[i].swim(swimDistance);
        }
        System.out.println("That's all for today. Thank you for visiting our competition! \nHave a good day!");
    }

    private static void competitionAnnouncement(Animal[] animals) {
        if (Animal.getAnimalsCount() > 1) {
            System.out.println("Today, in our competition will participate " + Animal.getAnimalsCount() + " animals");
            catsAndDogsAnnouncement(animals);
        } else if (Animal.getAnimalsCount() == 1) {
            soleCompetitorAnnouncement(animals);
        } else {
            System.out.println("Sadly, we don't have any competitors today! Please come back tomorrow!");
        }
        System.out.println();
    }


    private static void catsAndDogsAnnouncement(Animal[] animals) {
        System.out.println("As for our participants:");
        catsParticipantsAnnouncement(animals);
        dogsParticipantAnnouncement(animals);
    }

    private static void catsParticipantsAnnouncement(Animal[] animals) {
        if (Cat.getCatCount() > 1) {
            System.out.println("We have " + Cat.getCatCount() + " cats! ");
        } else if (Cat.getCatCount() == 1) {
            System.out.println("We have one cat!");
            for (int i = 0; i < animals.length; i++) {
                if (animals[i] instanceof Cat) {
                    System.out.print("And this lovely cat's name is " + animals[i].name);
                }
            }
        }
    }

    private static void dogsParticipantAnnouncement(Animal[] animals) {
        if (Dog.getDogCount() > 1) {
            System.out.println("We have " + Dog.getDogCount() + " dogs! ");
        } else if (Dog.getDogCount() == 1) {
            System.out.println("We have one dog!");
            for (int i = 0; i < animals.length; i++) {
                if (animals[i] instanceof Dog) {
                    System.out.print("And this friendly dog's name is " + animals[i].name);
                }
            }
        }
    }

    private static void soleCompetitorAnnouncement(Animal[] animals) {
        System.out.println("Today, in out competition will participate only 1 animal");
        System.out.println("And speaking of our competitor, ");
        if (animals[0] instanceof Cat) {
            System.out.println("it is a cat with a lovely name " + animals[0].name + "!");
        } else if (animals[0] instanceof Dog) {
            System.out.println("it is a dog with a lovely name " + animals[0].name + "!");
        }
    }


}


