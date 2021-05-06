package homeworkLesson11;

public class Main {
    public static void main(String[] args) {
        Box<Apple> box1 = new Box<>(Box.fruitTypes.APPLE);
        Box<Orange> box2 = new Box<>(Box.fruitTypes.ORANGE);
        Box<Apple> box3 = new Box<>(Box.fruitTypes.APPLE);
        Box<Orange> box4 = new Box<>(Box.fruitTypes.ORANGE);
        Apple apple = new Apple();
        Orange orange = new Orange();

        box1.addFruit(apple);
        box1.addFruit(apple);
        box1.addFruit(apple);
        System.out.println(box1.getWeight());

        box2.addFruit(orange);
        System.out.println(box2.getWeight());

        System.out.println(box1.compare(box2));

        box3.addFruit(apple);
        box3.addFruit(apple);
        box3.addFruit(apple);

        System.out.println(box1.compare(box2));

        box1.transferToBox(box2);
        System.out.println("Box 1 contains: " + box1.box);
        System.out.println("Box 1 weight: " + box1.boxWeight);
        System.out.println("Box 2 contains: " + box2.box);
        System.out.println("Box 2 weight: " + box2.boxWeight);

        box3.transferToBox(box1);
        System.out.println("Box 3 contains: " + box3.box);
        System.out.println("Box 3 weight: " + box3.boxWeight);
        System.out.println("Box 1 contains: " + box1.box);
        System.out.println("Box 1 weight: " + box1.boxWeight);
    }


}
