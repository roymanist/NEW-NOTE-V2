package services;

import obj.Note;

import java.sql.*;
import java.util.List;

public interface IDeleteNote {
    public default List<Note> DeleteNote(Connection connection, List<Note> notebook, int idNote) throws SQLException {
        notebook.removeIf(note -> note.getId() == idNote);
        Statement SQL = connection.createStatement();
        SQL.execute("DELETE FROM notes where id="+idNote);
return notebook;
    }
}
