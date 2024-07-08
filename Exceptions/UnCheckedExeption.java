// Unchecked Exceptions
// Unchecked exceptions are exceptions that are not checked at compile-time. These exceptions occur during the execution of the program, often due to programming errors.

// ArithmeticException:
// This exception is thrown when an exceptional arithmetic condition has occurred, such as divide by zero.

// Example:

public class ArithmeticExceptionDemo {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
}

// ClassCastException:
// This exception is thrown when an attempt is made to cast an object to a subclass of which it is not an instance.

// Example:

public class ClassCastExceptionDemo {
    public static void main(String[] args) {
        try {
            Object x = new Integer(0);
            System.out.println((String) x);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }
}

// NullPointerException:
// This exception is thrown when an application attempts to use null in a case where an object is required.

// Example:

public class NullPointerExceptionDemo {
    public static void main(String[] args) {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}

// ArrayIndexOutOfBoundsException:
// This exception is thrown to indicate that an array has been accessed with an illegal index.

// Example:


public class ArrayIndexOutOfBoundsExceptionDemo {
    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            int x = arr[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}

// ArrayStoreException:
// This exception is thrown to indicate that an attempt has been made to store the wrong type of object into an array of objects.

// Example:

public class ArrayStoreExceptionDemo {
    public static void main(String[] args) {
        try {
            Object[] x = new String[3];
            x[0] = new Integer(0);
        } catch (ArrayStoreException e) {
            e.printStackTrace();
        }
    }
}

// IllegalThreadStateException:
// This exception is thrown to indicate that a thread is not in an appropriate state for the requested operation.

// Example:

public class IllegalThreadStateExceptionDemo {
    public static void main(String[] args) {
        try {
            Thread t = new Thread();
            t.start();
            t.start();
        } catch (IllegalThreadStateException e) {
            e.printStackTrace();
        }
    }
}
