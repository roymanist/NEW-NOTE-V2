import java.sql.*;
import java.util.List;

import services.*;
import obj.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Ваш код начинается здесь

NoteManager manager = NoteManager.getNoteData();

manager.DrawNotes();

       //Connection connection = DriverManager.getConnection("jdbc:h2:E:/JAVA_LRN/II/PROJ/src/main/java/dbase/NoteDBaseNew");


     /*   for(Note note : manager.getNotebook())
        {
            System.out.print(note.getId());
            System.out.println(note.getNameNote());
            System.out.println(note.getTextNote());
        }
*/



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