import java.io.*;
import java.util.*;

public class ByteIOStream  {
    private static Map <String, Integer> map;
    private static final String [] KEYWORDS = {"abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "extends", "false",
            "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native",
            "new", "null", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile", "while"};

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

    public static Map <String, Integer> analyzeByteInput(String result) {
        String [] splittedArray = result.split("[^a-z]+");
        map = new LinkedHashMap<>();
        for (int i = 0; i < splittedArray.length; i++) {
            for (int j = 0; j < KEYWORDS.length; j++) {
                if (splittedArray[i].equals(KEYWORDS[j])) {
                    if (!map.containsKey(splittedArray[i])) {
                        map.put(splittedArray[i], 1);
                    } else {
                        int count = map.get(splittedArray[i]);
                        map.put(splittedArray[i], count + 1);
                    }
                }
            }
        }
        return map;
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