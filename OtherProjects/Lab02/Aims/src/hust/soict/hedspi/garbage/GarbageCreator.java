package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: java hust.soict.hedspi.garbage.GarbageCreator <file-path>");
            return;
        }

        Path filePath = Path.of(args[0]);
        if (!Files.exists(filePath)) {
            System.out.println("File not found: " + filePath);
            return;
        }

        byte[] inputBytes = Files.readAllBytes(filePath);

        long startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b;
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Time with + operator: " + (endTime - startTime) + " ms");
        System.out.println("Output length: " + outputString.length());
    }
}
