package lesson_8;

public class MyArraySizeException extends RuntimeException {
    private String details;

    public MyArraySizeException(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "MyArraySizeException: " + details;
    }
}
