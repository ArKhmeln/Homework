import org.junit.Before;
import org.junit.Test;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class CharIOStreamTest {
    Map <String, Integer> testMap = new LinkedHashMap<>();

    @Before
    public void before() {
        testMap.put("private", 3);
        testMap.put("final", 3);
        testMap.put("static", 3);
        testMap.put("int", 3);
    }

    @Test
    public void analyzeCharStream() {
        String testString = "private final static int DEFAULT_SIZE = 100;\n" +
                "    private final static int CHANGE_SIZE = 50;\n" +
                "    private final static int EMPTY_SIZE_LIMIT = 100;";
        Map <String, Integer> actual = CharIOStream.analyzeCharStream(testString);
        assertEquals(testMap, actual);
    }

    @Test
    public void writeCharacterOutput() {
        String testPath = "D://Java//Projects//Homework//src//test//Testtext2.txt";
        String expectPath = "D://Java//Projects//Homework//src//test//Expecttext1.txt";
        CharIOStream.writeCharacterOutput(testMap, testPath);
        String actual = CharIOStream.readCharacterInput(testPath);
        String expected = CharIOStream.readCharacterInput(expectPath);
        assertEquals(expected, actual);
    }
}