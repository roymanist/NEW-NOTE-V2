import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import services.*;
import obj.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Ваш код начинается здесь

        Connection connection = DriverManager.getConnection("jdbc:h2:./dbase/NoteDBase");
       /* Statement SQL = connection.createStatement();
        SQL.execute("delete from notes where id >1");*/
        NoteManager manager = new NoteManager();

        List<Note> notebook = manager.ReadNoteBase(connection);

        // notebook = manager.NewNote(connection,"Second","New Note 2", notebook);

        // notebook = manager.DeleteNote(connection, notebook,9);

        manager.DrawNotes(notebook);
manager.UpdateNoteNameAndText(connection, notebook, "YYYY", "ZZZZZZZZZZZ",1);
        manager.DrawNotes(notebook);

        //  manager.DrawNotes(notebook);

    }
}