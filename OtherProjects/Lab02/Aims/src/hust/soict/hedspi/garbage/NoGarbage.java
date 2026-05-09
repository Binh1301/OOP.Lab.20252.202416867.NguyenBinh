package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: java hust.soict.hedspi.garbage.NoGarbage <file-path>");
            return;
        }

        Path filePath = Path.of(args[0]);
        if (!Files.exists(filePath)) {
            System.out.println("File not found: " + filePath);
            return;
        }

        byte[] inputBytes = Files.readAllBytes(filePath);

        long startTime = System.currentTimeMillis();
        StringBuffer outputStringBuffer = new StringBuffer(inputBytes.length);
        for (byte b : inputBytes) {
            outputStringBuffer.append((char) b);
        }
        String outputString = outputStringBuffer.toString();
        long endTime = System.currentTimeMillis();

        System.out.println("Time with StringBuffer: " + (endTime - startTime) + " ms");
        System.out.println("Output length: " + outputString.length());
    }
}
