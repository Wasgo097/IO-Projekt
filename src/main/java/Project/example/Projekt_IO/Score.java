package Project.example.Projekt_IO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Score {
    @JsonCreator
    public Score(@JsonProperty("score") int score,
                 @JsonProperty("comment") String comment)  {
        this.score = score;
        this.comment = comment;
    }
    public final int score;
    public final String comment;
}
