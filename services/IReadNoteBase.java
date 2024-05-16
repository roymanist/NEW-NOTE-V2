package services;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import obj.Note;

public interface IReadNoteBase
{
    public default   List<Note> ReadNoteBase(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM notes");
        List<Note> allNotes = new ArrayList<>();
        while (resultSet.next()) {
            Note note = new Note();
            note.setId(resultSet.getInt("id"));
            note.setNameNote(resultSet.getString("nameNote").trim());
            note.setTextNote(resultSet.getString("textNote").trim());
            note.setDtCreate(resultSet.getString("dtCreate"));
            note.setDtChange(resultSet.getString("dtChange"));

            if (!allNotes.contains(note)) {
                allNotes.add(note);
            }
        }

        /*resultSet.close();
        statement.close();
        connection.close();*/

        return allNotes;
    }

}
