package services;

import obj.Note;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface INewNote {
    public  void NewNote( String noteName, String noteText) throws SQLException ;
}
