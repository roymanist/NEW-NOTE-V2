package services;

import obj.Note;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface IUpdateNote {

    public enum upd {
        name,
        text
    };
    public  void UpdateNote(upd type, String value, int idNote) throws SQLException ;



}