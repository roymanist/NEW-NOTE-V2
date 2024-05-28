package services;

import obj.Note;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface IUpdateNote {
    public  void UpdateNoteNameAndText(List<Note> notebook, String changeNameNote, String changeTextNote, int idNote) throws SQLException ;


    public  void UpdateNoteName(List<Note> notebook, String changeNameNote, int idNote) throws SQLException ;




    public  void UpdateNoteText(List<Note> notebook, String changeTextNote, int idNote) throws SQLException ;

}