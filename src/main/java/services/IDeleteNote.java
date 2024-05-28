package services;

import obj.Note;

import java.sql.*;
import java.util.List;

public interface IDeleteNote {
    public void DeleteNote( int idNote) throws SQLException ;
}
