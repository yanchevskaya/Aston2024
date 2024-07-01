package lesson_8;

public class MyArrayDataException extends RuntimeException{
    private int firstPosition;
    private int secondPosition;

    public MyArrayDataException(int firstPosition, int secondPosition) {

        this.firstPosition = firstPosition;
        this.secondPosition = secondPosition;
    }

    public int getFirstPosition() {
        return firstPosition;
    }

    public int getSecondPosition() {
        return secondPosition;
    }

    @Override
    public String toString() {
        return "MyArrayDataExeption: failed format in " + getFirstPosition() + " array " +
                 getSecondPosition() + " position" ;
    }
}
