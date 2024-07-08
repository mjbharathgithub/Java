// In Java, Throwable, throw, and throws are integral parts of the exception handling mechanism. Let's explore each of them in detail with examples.

// 1. Throwable
// Throwable is the superclass of all errors and exceptions in the Java language. Only objects that are instances of this class (or one of its subclasses) can be thrown by the Java Virtual Machine or can be caught by a catch clause.

// Subclasses of Throwable:
// Exception: Represents conditions that a reasonable application might want to catch.
// Error: Represents serious problems that a reasonable application should not try to catch.
// Example:


public class ThrowableExample {
    public static void main(String[] args) {
        try {
            throw new Exception("This is an Exception");
        } catch (Throwable t) {
            System.out.println("Caught Throwable: " + t.getMessage());
        }
    }
}

// 2. throw
// The throw keyword is used to explicitly throw an exception. You can throw either a checked or unchecked exception, but for checked exceptions, the method must handle it with a try-catch block or declare it using the throws keyword.

// Example:

public class ThrowExample {
    public static void main(String[] args) {
        try {
            validateAge(15);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    static void validateAge(int age) throws Exception {
        if (age < 18) {
            throw new Exception("Age must be at least 18");
        } else {
            System.out.println("Valid age");
        }
    }
}

// 3. throws
// The throws keyword is used in method signatures to declare that a method can throw one or more exceptions. This informs the caller of the method to handle these exceptions, either with a try-catch block or by propagating them further using their own throws declaration.

// Example:

import java.io.*;

public class ThrowsExample {
    public static void main(String[] args) {
        try {
            readFile("nonexistentfile.txt");
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

    static void readFile(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
    }
}

// Combining throw and throws
// You can combine throw and throws to create a method that throws an exception which must be handled or declared by the caller.

// Example:

public class ThrowAndThrowsExample {
    public static void main(String[] args) {
        try {
            processFile("nonexistentfile.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: " + e.getMessage());
        }
    }

    static void processFile(String fileName) throws FileNotFoundException {
        if (fileName == null || fileName.isEmpty()) {
            throw new FileNotFoundException("File name cannot be null or empty");
        }
        // Simulating file processing
        System.out.println("Processing file: " + fileName);
    }
}

// Summary
// Throwable: The superclass of all errors and exceptions. All exception types in Java inherit from this class.
// throw: Used to explicitly throw an exception.
// throws: Used in method signatures to declare that the method can throw exceptions, informing the caller to handle or propagate them.
