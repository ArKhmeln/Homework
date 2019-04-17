import java.util.Map;

public class MainIOB {
    public static void main(String[] args) {
        String readPath = "D:/Java/Projects/Homework/src/Test_for_IO.txt";
        //Byte
        String outPathByte = "D://Java//Projects//Homework//src//text1.txt";
        String readedText= ByteIOStream.readВyteInput(readPath);
        Map <String, Integer> analyzedText = Analysis.analyzeInput(readedText);
        ByteIOStream.writeByteOutput(analyzedText, outPathByte);
        //Character
        String outPathChar = "D://Java//Projects//Homework//src//text2.txt";
        String readedTextChar = CharIOStream.readCharacterInput(readPath);
        Map <String, Integer> analyzedTextChar = Analysis.analyzeInput(readedTextChar);
        CharIOStream.writeCharacterOutput(analyzedTextChar, outPathChar);
    }
}