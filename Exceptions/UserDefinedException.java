class MyCustomException extends Exception {
    public MyCustomException(String message) {
        super(message);
    }
}

public class CustomExceptionDemo {
    public static void main(String[] args) {
        try {
            validateAge(15);
        } catch (MyCustomException e) {
            System.out.println("Caught the exception: " + e.getMessage());
        }
    }

    static void validateAge(int age) throws MyCustomException {
        if (age < 18) {
            throw new MyCustomException("Age must be at least 18");
        }
    }
}
