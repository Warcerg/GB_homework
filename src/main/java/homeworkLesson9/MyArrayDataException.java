package homeworkLesson9;

public class MyArrayDataException extends Exception{
    public MyArrayDataException(int i, int j) {
        super("Incorrect data in cell i:" + i + " j:" + j);
    }
}
