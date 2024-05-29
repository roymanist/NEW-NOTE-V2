import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;
import java.net.URL;
import services.*;
import obj.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Ваш код начинается здесь

NoteManager manager = NoteManager.getNoteData();


        //manager.UpdateNote("Second Test","NEW TEST 4",11);
        //manager.DeleteNote(14);
        manager.DrawNotes();


    }
}