import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Analysis {

    private static final List<String> KEYWORDS = Arrays.asList("abstract", "assert", "boolean",
            "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "extends", "false",
            "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native",
            "new", "null", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true",
            "try", "void", "volatile", "while");

    private Analysis() {}

    public static Map<String, Integer> analyzeInput(String result) {
        String [] splittedArray = result.split("[^a-z0-9]+");
        Map <String, Integer> map = new LinkedHashMap<>();
        for (String i : splittedArray) {
            if (KEYWORDS.contains(i)) {
                if (!map.containsKey(i)) {
                    map.put(i, 1);
                } else {
                    int count = map.get(i);
                    map.put(i, count + 1);
                }
            }
        }
        return map;
    }
}
