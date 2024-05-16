package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.List;

import services.*;
import obj.*;


public class NoteManager implements IReadNoteBase, IDrawNotes, INewNote, IDeleteNote, IUpdateNote {
public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:h2:./dbase/NoteDBase");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
