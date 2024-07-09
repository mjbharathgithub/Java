import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample {
    public static void sample1(String[] args) {
        try (InputStream inputStream = new FileInputStream("example.txt")) {
            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class InputStreamBufferExample {
    public static void sample2(String[] args) {
        try (InputStream inputStream = new FileInputStream("example.txt")) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                String text = new String(buffer, 0, bytesRead);
                System.out.print(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class InputStreamSkipExample {
    public static void sample4(String[] args) {
        try (InputStream inputStream = new FileInputStream("example.txt")) {
            int availableBytes = inputStream.available();
            System.out.println("Available bytes before skip: " + availableBytes);

            inputStream.skip(10);
            System.out.println("Skipped 10 bytes");

            availableBytes = inputStream.available();
            System.out.println("Available bytes after skip: " + availableBytes);

            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class InputStreamMarkResetExample {
    public static void sample4(String[] args) {
        byte[] data = "Hello, World!".getBytes();
        try (InputStream inputStream = new ByteArrayInputStream(data)) {
            if (inputStream.markSupported()) {
                System.out.print((char) inputStream.read()); // H
                System.out.print((char) inputStream.read()); // e

                inputStream.mark(0); // Mark this position

                System.out.print((char) inputStream.read()); // l
                System.out.print((char) inputStream.read()); // l

                inputStream.reset(); // Reset to the marked position

                System.out.print((char) inputStream.read()); // l
                System.out.print((char) inputStream.read()); // l
            } else {
                System.out.println("Mark/reset not supported");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
