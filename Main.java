import java.sql.*;
import java.util.List;

import services.*;
import obj.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Ваш код начинается здесь

       // Connection connection = DriverManager.getConnection("jdbc:h2:./dbase/NoteDBase");
        NoteManager manager = new NoteManager();

        List<Note> notebook = manager.ReadNoteBase();

         manager.DrawNotes(notebook);
        // notebook = manager.NewNote("Three","New Note 3", notebook);
        // manager.DrawNotes(notebook);

         //notebook = manager.DeleteNote(notebook,12);
        //manager.DrawNotes(notebook);
        //
        //manager.UpdateNoteNameAndText( notebook, "YYYY", "ZZZZZZZZZZZ",1);
        //manager.UpdateNoteName(notebook,"TestNote",1);
        //manager.DrawNotes(notebook);

        //  manager.DrawNotes(notebook);

    }
}