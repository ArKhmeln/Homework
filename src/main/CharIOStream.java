import java.io.*;
import java.util.*;

public class CharIOStream {

    private CharIOStream() {}

    public static String readCharacterInput(String pathToRead) {
        try (FileReader input = new FileReader(pathToRead)) {
            StringBuilder sb = new StringBuilder();
            Scanner scan = new Scanner(input);
            while (scan.hasNext()) {
                sb.append(scan.nextLine());
            }
            String result = sb.toString();
            return result;
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            return null;
        }
    }

    public static void writeCharacterOutput(Map<String, Integer> map, String outPath) {
        try (FileWriter out = new FileWriter(outPath)) {
            for (Map.Entry i: map.entrySet()) {
                out.write(i.getKey() + ": ");
                out.write(i.getValue() + "\r\n");
            }
        }catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
