package homeworkLesson11;

import java.util.ArrayList;

public class Box<E extends Fruit & FruitType> {
    ArrayList<E> box;
    int fruitsCount;
    float boxWeight = 0;

    enum fruitTypes {APPLE, ORANGE}

    fruitTypes boxType;

    public Box(fruitTypes boxType) {
        this.box = new ArrayList<E>();
        this.boxType = boxType;
    }

    public void addFruit(E fruit) {
        box.add(fruit);
        fruitsCount++;
    }

    public float getWeight() {
        if (box.size() == 0) {
            boxWeight = 0;
        } else if (box.get(0) instanceof Apple) {
            boxWeight = (float) box.size() * Apple.weight;
        } else {
            boxWeight = (float) box.size() * Orange.weight;
        }
        return boxWeight;
    }

    public boolean compare(Box box) {
        Comparable a = (Comparable) getWeight();
        Comparable b = (Comparable) box.getWeight();
        return a.compareTo(b) == 0;
    }

    public void transferToBox(Box box) {
        if (this.boxType.equals(box.boxType)) {
            for (int i = 0; i < fruitsCount; i++) {
                box.box.add(this.box.get(i));
                box.fruitsCount++;
            }
            fruitsCount = 0;
            this.box.clear();
            getWeight();
            box.getWeight();
            System.out.println("Transfer done");
        } else {
            System.out.println("Transfer cannot happen because boxes are for different types of fruits. \n"
                    + "BOX 1: " + this.boxType + "\nBOX 2: " + box.boxType);
        }
    }
}
