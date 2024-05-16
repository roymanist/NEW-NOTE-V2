package services;
import obj.Note;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface IUpdateNote {
    public default List<Note>  UpdateNoteNameAndText(Connection connection, List<Note> notebook, String changeNameNote, String changeTextNote, int idNote ) throws SQLException {

        Statement SQL = connection.createStatement();

        LocalDateTime currentDateTime = LocalDateTime.now();
        // Создание объекта форматтера
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Применение форматирования к текущей дате и времени
        String dt = currentDateTime.format(formatter);

        SQL.execute("UPDATE notes set nameNote = '"+changeNameNote+"', textNote= '"+changeTextNote+"', dtChange= '"+dt+"' where id = "+idNote);

        for (Note note : notebook) {
            if (note.getId() == idNote) {
                note.setNameNote(changeNameNote);
                note.setTextNote(changeTextNote);
                note.setDtChange(dt);
                break;
            }

        }
        return  notebook;
    }
}