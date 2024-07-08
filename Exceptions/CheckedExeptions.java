// Checked Exceptions
// Checked exceptions are exceptions that are checked at compile-time. The Java compiler ensures that these exceptions are either caught or declared in the method where they can be thrown.
// ClassNotFoundException:
// This exception is thrown when an application tries to load a class through its string name using Class.forName() and the class cannot be found.

// Example:

try {
    Class.forName("com.nonexistent.ClassName");
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}

// ClassNotFoundException:
// This exception is thrown when an application tries to load a class through its string name using Class.forName() and the class cannot be found.

// Example:
try {
    Class.forName("com.nonexistent.ClassName");
} catch (ClassNotFoundException e) {
    e.printStackTrace();
}

// InterruptedException:
// This exception is thrown when a thread is interrupted while it is waiting, sleeping, or otherwise occupied.

// Example:

class InterruptDemo extends Thread {
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Thread running");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }

    public static void main(String[] args) {
        InterruptDemo t = new InterruptDemo();
        t.start();
        t.interrupt();
    }
}

// IOException:
// This exception is thrown when an input-output operation is failed or interpreted.

// Example:

import java.io.*;

public class IOExceptionDemo {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("nonexistentfile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// InstantiationException:
// This exception is thrown when an application tries to create an instance of a class using the newInstance method in class Class, but the specified class object cannot be instantiated.

// Example:

try {
    Class<?> clazz = Class.forName("java.lang.String");
    Object obj = clazz.newInstance();
} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
    e.printStackTrace();
}

// SQLException:
// This exception is thrown when there is any error in the database operation.

// Example:
  
import java.sql.*;

public class SQLExceptionDemo {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM nonexistent_table");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// FileNotFoundException:
// This exception is a subclass of IOException and is thrown when a file with the specified pathname does not exist.

// Example:

import java.io.*;

public class FileNotFoundExceptionDemo {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("nonexistentfile.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
