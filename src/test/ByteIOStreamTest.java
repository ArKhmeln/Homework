import org.junit.Test;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class ByteIOStreamTest {

    @Test
    public void analyzeByteInput() {
        String testString = "private final static int DEFAULT_SIZE = 100;\n" +
                "    private final static int CHANGE_SIZE = 50;\n" +
                "    private final static int EMPTY_SIZE_LIMIT = 100;";
        Map <String, Integer> actual = ByteIOStream.analyzeByteInput(testString);
        Map <String, Integer> expected = new LinkedHashMap<>();
        expected.put("private", 3);
        expected.put("final", 3);
        expected.put("static", 3);
        expected.put("int", 3);
        assertEquals(actual, expected);
    }

    @Test
    public void writeByteOutput() {
        Map <String, Integer> testMap = new LinkedHashMap<>();
        testMap.put("private", 3);
        testMap.put("final", 3);
        testMap.put("static", 3);
        testMap.put("int", 3);
        String testPath = "D://Java//Projects//Homework//src//test//Testtext1.txt";
        String expectPath = "D://Java//Projects//Homework//src//test//Expecttext1.txt";
        ByteIOStream.writeByteOutput(testMap, testPath);
        String actual = ByteIOStream.readВyteInput(testPath);
        String expected = ByteIOStream.readВyteInput(expectPath);
        assertEquals(actual, expected);
    }
}