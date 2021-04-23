package homeworkLesson9;

public class MyArraySizeException extends Exception{
    public MyArraySizeException(int SIZE) {
        super("Incorrect Array size! Array size should be " + SIZE + 'x' + SIZE);
    }
}
