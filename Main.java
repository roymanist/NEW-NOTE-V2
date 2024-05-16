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

     //  notebook = manager.NewNote(connection,"try","hello hard world22", notebook);


        manager.DrawNotes(notebook);
for (Note x : notebook){System.out.println(x.getNameNote());
    System.out.println(x.getNameNote().length());
}
    }
}