import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import services.*;
import obj.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Ваш код начинается здесь

        Connection connection = DriverManager.getConnection("jdbc:h2:./dbase/NoteDBase");
        NoteManager manager = new NoteManager();

        List<Note> notebook = manager.ReadNoteBase(connection);

         manager.DrawNotes(notebook);
        // notebook = manager.NewNote(connection,"Second","New Note 2", notebook);
        // manager.DrawNotes(notebook);

        // notebook = manager.DeleteNote(connection, notebook,10);

        //
        //manager.UpdateNoteNameAndText(connection, notebook, "YYYY", "ZZZZZZZZZZZ",1);
        //manager.UpdateNoteName(connection,notebook,"TestNote",1);
        //manager.DrawNotes(notebook);

        //  manager.DrawNotes(notebook);

    }
}