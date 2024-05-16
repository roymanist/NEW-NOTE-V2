package obj;

import lombok.Getter;
import lombok.Setter;

public class Note {
    @Getter
    @Setter
    private int id = 0;
    @Getter
    @Setter
    private int height = 5;
    @Getter
    @Setter
    private int width = 40;
    @Getter
    @Setter
    private String nameNote = "";
    @Getter
    @Setter
    private String textNote = "";
    @Getter
    @Setter
    private String dtCreate = "";
    @Getter
    @Setter
    private String dtChange = "";
}
