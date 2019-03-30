import java.io.*;
import java.util.*;

public class ByteIOStream  {
    private static String result;
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

    public static void readВyteInput(String read) {
        try {
            FileInputStream input = new FileInputStream(read);
            StringBuilder sb = new StringBuilder(0);
            int data = -1;
            while ((data = input.read()) != -1) {
                sb.append(Character.toChars(data));
            }
            result = sb.toString();
            String [] re = result.split("[^a-z]+");
            map = new LinkedHashMap<>();
            for (int i = 0; i < re.length; i++) {
                for (int j = 0; j < KEYWORDS.length; j++) {
                    if (re[i].equals(KEYWORDS[j])) {
                        if (!map.containsKey(re[i])) {
                            map.put(re[i], 1);
                        } else {
                            int count = map.get(re[i]);
                            map.put(re[i], count + 1);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void writeByteOutput(String write) {
        try {
            FileOutputStream out = new FileOutputStream(write);
            for(Map.Entry i: map.entrySet()) {
                out.write((i.getKey() + ": ").getBytes());
                out.write((i.getValue() + "\r\n").getBytes());
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}