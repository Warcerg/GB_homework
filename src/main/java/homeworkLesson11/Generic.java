package homeworkLesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Задания 1 и 2
public class Generic<E> {
    private E[] data;
    private int currentSize;
    private ArrayList<E> dataList;

    public Generic(int size) {
        this.data = (E[]) new Object[size];
    }
    public void add(E value){
        add(value, currentSize);
    }

    public void add(E value, int i){
        data[i] = value;
        currentSize++;
    }

    public void elementsSwitch(int i, int j){
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public void toArrayList(){
        this.dataList = new ArrayList<>();
        Collections.addAll(dataList,data);
/*        for(E value: data){
            dataList.add(value);*/
/*        }*/
    }

    public void printArray(){
        System.out.println(Arrays.toString(data));
    }

    public void printArrayList(){
        System.out.println(dataList);
    }

    public static void main(String[] args) {
        Generic intGeneric = new Generic(5);
        intGeneric.add(4);
        intGeneric.add(3);
        intGeneric.add(7);
        intGeneric.add(12);
        intGeneric.add(6);

        intGeneric.printArray();
        intGeneric.elementsSwitch(0,3);
        intGeneric.printArray();

        intGeneric.toArrayList();
        intGeneric.printArrayList();

        Generic strGeneric = new Generic(5);
        strGeneric.add("Hi");
        strGeneric.add("my");
        strGeneric.add("name");
        strGeneric.add("is");
        strGeneric.add("Slim Shady");

        strGeneric.printArray();
        strGeneric.elementsSwitch(0,3);
        strGeneric.elementsSwitch(3,4);
        strGeneric.printArray();

        strGeneric.toArrayList();
        strGeneric.printArrayList();

        Generic doubleGeneric = new Generic(5);
        doubleGeneric.add(3.14);
        doubleGeneric.add(2.71);
        doubleGeneric.add(1.34);
        doubleGeneric.add(5.74);
        doubleGeneric.add(0.95);

        doubleGeneric.printArray();
        doubleGeneric.elementsSwitch(0,3);
        doubleGeneric.printArray();

        doubleGeneric.toArrayList();
        doubleGeneric.printArrayList();
    }
}
