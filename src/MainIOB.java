public class MainIOB {
    public static void main(String[] args) {
        String readPath = "D:/Java/Projects/Homework/src/Test_for_IO.txt";
        //Byte
        String writePathByte = "D://Java//Projects//Homework//src//text1.txt";
        ByteIOStream.readВyteInput(readPath);
        ByteIOStream.writeByteOutput(writePathByte);
        //Character
        String writePathCharacter = "D://Java//Projects//Homework//src//text2.txt";
        CharIOStream.readCharacterInput(readPath);
        CharIOStream.writeCharacterOutput(writePathCharacter);
    }
}