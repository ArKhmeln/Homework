import java.io.*;
import java.util.*;

public class CharIOStream {
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

    public static Map<String, Integer> analyzeCharStream(String result) {
        String[] splitArray = result.split("[^a-z]+");
        map = new LinkedHashMap<>();
        for (int i = 0; i < splitArray.length; i++) {
            for (int j = 0; j < KEYWORDS.length; j++) {
                if (splitArray[i].equals(KEYWORDS[j])) {
                    if (!map.containsKey(splitArray[i])) {
                        map.put(splitArray[i], 1);
                    } else {
                        int count = map.get(splitArray[i]);
                        map.put(splitArray[i], count + 1);
                    }
                }
            }
        }
        return map;
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
