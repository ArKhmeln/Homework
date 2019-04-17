import java.io.*;
import java.util.*;

public class ByteIOStream  {

    private ByteIOStream() {}

    public static String readВyteInput(String pathToRead) {
        try (FileInputStream input = new FileInputStream(pathToRead)) {
            StringBuilder sb = new StringBuilder(0);
            int data;
            while ((data = input.read()) != -1) {
                sb.append(Character.toChars(data));
            }
            String result = sb.toString();
            return result;
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public static void writeByteOutput(Map <String, Integer> map, String outPath) {
        try (FileOutputStream out = new FileOutputStream(outPath)) {
            for (Map.Entry i: map.entrySet()) {
                out.write((i.getKey() + ": ").getBytes());
                out.write((i.getValue() + "\r\n").getBytes());
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}