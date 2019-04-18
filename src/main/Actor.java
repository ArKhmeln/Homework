import java.io.Serializable;

public class Actor implements Serializable {
    private String actorName;

    public Actor(String name) {
        actorName = name;
    }

    public String getActorName() {
        return actorName;
    }
}
