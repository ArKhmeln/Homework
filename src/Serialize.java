import java.io.*;

public class Serialize {

    public static void collectionSave(String path, FilmsCollection tosave) {
        try(ObjectOutputStream objo = new ObjectOutputStream(new FileOutputStream(path))) {
            objo.writeObject(tosave);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public static FilmsCollection collectionLoad(String path) {
        try(ObjectInputStream obji = new ObjectInputStream(new FileInputStream(path))) {
             FilmsCollection coll = (FilmsCollection)obji.readObject();
             return coll;
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
