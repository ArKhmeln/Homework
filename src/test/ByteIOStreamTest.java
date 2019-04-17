import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class ByteIOStreamTest {
    Map <String, Integer> testMap = new LinkedHashMap<>();
    Map <String, Integer> emptyMap = new HashMap<>();

    @Before
    public void before() {
        testMap.put("private", 3);
        testMap.put("final", 3);
        testMap.put("static", 3);
        testMap.put("int", 3);
    }

    @Test
    public void analyzeByteInput() {
        String testString = "private final static int DEFAULT_SIZE = 100;\n" +
                "    private final static int CHANGE_SIZE = 50;\n" +
                "    private final static int EMPTY_SIZE_LIMIT = 100;";
        Map <String, Integer> actual = Analysis.analyzeInput(testString);
        assertEquals(testMap, actual);
    }

    @Test
    public void writeByteOutput() {
        String testPath = "D://Java//Projects//Homework//src//test//Testtext1.txt";
        String expectPath = "D://Java//Projects//Homework//src//test//Expecttext1.txt";
        ByteIOStream.writeByteOutput(testMap, testPath);
        String actual = ByteIOStream.readВyteInput(testPath);
        String expected = ByteIOStream.readВyteInput(expectPath);
        assertEquals(actual, expected);
    }

    @Test
    public void analyzeEmptyString() {
        String testPath = "D://Java//Projects//Homework//src//test//Empty_string.txt";
        String writePath = "D://Java//Projects//Homework//src//test//Empty_string_out.txt";
        String read1 = ByteIOStream.readВyteInput(testPath);
        Map <String, Integer> analyzedText = Analysis.analyzeInput(read1);
        ByteIOStream.writeByteOutput(analyzedText, writePath);
        String read2 = ByteIOStream.readВyteInput(writePath);
        analyzedText = Analysis.analyzeInput(read2);
        assertEquals(emptyMap, analyzedText);
    }

    @Test
    public void analyzeZeroKeywords() {
        String testPath = "D://Java//Projects//Homework//src//test//Zero_keywords.txt";
        String writePath = "D://Java//Projects//Homework//src//test//Zero_keywords_out.txt";
        String read1 = ByteIOStream.readВyteInput(testPath);
        Map <String, Integer> analyzedText = Analysis.analyzeInput(read1);
        ByteIOStream.writeByteOutput(analyzedText, writePath);
        String read2 = ByteIOStream.readВyteInput(writePath);
        analyzedText = Analysis.analyzeInput(read2);
        assertEquals(emptyMap, analyzedText);
    }

    @Test
    public void analyzeSpaceString() {
        String testPath = "D://Java//Projects//Homework//src//test//Space_string.txt";
        String writePath = "D://Java//Projects//Homework//src//test//Space_string_out.txt";
        String read1 = ByteIOStream.readВyteInput(testPath);
        Map<String, Integer> analyzedText = Analysis.analyzeInput(read1);
        ByteIOStream.writeByteOutput(analyzedText, writePath);
        String read2 = ByteIOStream.readВyteInput(writePath);
        analyzedText = Analysis.analyzeInput(read2);
        assertEquals(emptyMap, analyzedText);
    }
}