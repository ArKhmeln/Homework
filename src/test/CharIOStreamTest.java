import org.junit.Test;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class CharIOStreamTest {

    @Test
    public void analyzeCharStream() {
        String testString = "private final static int DEFAULT_SIZE = 100;\n" +
                "    private final static int CHANGE_SIZE = 50;\n" +
                "    private final static int EMPTY_SIZE_LIMIT = 100;";
        Map <String, Integer> actual = CharIOStream.analyzeCharStream(testString);
        Map <String, Integer> expected = new LinkedHashMap<>();
        expected.put("private", 3);
        expected.put("final", 3);
        expected.put("static", 3);
        expected.put("int", 3);
        assertEquals(actual, expected);
    }

    @Test
    public void writeCharacterOutput() {
        Map <String, Integer> testMap = new LinkedHashMap<>();
        testMap.put("private", 3);
        testMap.put("final", 3);
        testMap.put("static", 3);
        testMap.put("int", 3);
        String testPath = "D://Java//Projects//Homework//src//test//Testtext2.txt";
        String expectPath = "D://Java//Projects//Homework//src//test//Expecttext1.txt";
        CharIOStream.writeCharacterOutput(testMap, testPath);
        String actual = CharIOStream.readCharacterInput(testPath);
        String expected = CharIOStream.readCharacterInput(expectPath);
        assertEquals(actual, expected);
    }
}