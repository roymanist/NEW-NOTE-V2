package services;

import obj.Note;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface INewNote {
    public default List<Note>  NewNote(Connection connection, String noteName, String noteText, List<Note> notebook) throws SQLException {
        Statement SQL = connection.createStatement();
        LocalDateTime currentDateTime = LocalDateTime.now();
        // Создание объекта форматтера
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Применение форматирования к текущей дате и времени
        String dt = currentDateTime.format(formatter);

       // SQL.execute("INSERT INTO notes (nameNote, textNote, dtCreate, dtChange  ) SELECT 'Тестовая','привет мир','2024-05-16','2024-05-16' ");

        SQL.execute("INSERT INTO notes ( textNote, dtCreate, dtChange, nameNote) SELECT "  +"'"+ noteText +"'"+ ", " +"'"+ dt + "'"+", " +"'"+ dt+"', '"+noteName+"'");
       NoteManager manager = new NoteManager();
       return notebook = manager.ReadNoteBase(connection);
    }
}
