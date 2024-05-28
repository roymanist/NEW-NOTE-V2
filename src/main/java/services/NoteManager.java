package services;
import java.sql.DriverManager;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import obj.Note;
@Data
public class NoteManager implements IReadNoteBase, IDrawNotes, INewNote, IDeleteNote, IUpdateNote {

    private static NoteManager instance;
    private static final Object lock = new Object();/// не сильно понял этот локер. по теории он блочит создание дубля в многопоточности

    private Connection connection;
    private List<Note> notebook;

    private NoteManager() throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:E:/JAVA_LRN/II/PROJ/NEW-NOTE-V2/src/main/java/dbase/NoteDBase");
        notebook = new ArrayList<>();
        ReadNoteBase();
    }//приватный конструктор

    public static NoteManager getNoteData() throws SQLException {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new NoteManager();
                }
            }
        }
        return instance;
    }

    public void ReadNoteBase() throws SQLException {


        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM notes");

        while (resultSet.next()) {
            Note note = new Note();
            note.setId(resultSet.getInt("id"));
            note.setNameNote(resultSet.getString("nameNote").trim());
            note.setTextNote(resultSet.getString("textNote").trim());
            note.setDtCreate(resultSet.getString("dtCreate"));
            note.setDtChange(resultSet.getString("dtChange"));

            if (!notebook.contains(note)) {
                notebook.add(note);

               /* resultSet.close();
                statement.close();
                connection.close();*/
            }
        }
    }


    public void NewNote(String noteName, String noteText, List<Note> notebook) throws SQLException {


        Statement SQL = connection.createStatement();
        LocalDateTime currentDateTime = LocalDateTime.now();
        // Создание объекта форматтера
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Применение форматирования к текущей дате и времени
        String dt = currentDateTime.format(formatter);


        SQL.execute("INSERT INTO notes ( textNote, dtCreate, dtChange, nameNote) SELECT " + "'" + noteText + "', " + "'" + dt + "'" + ", " + "'" + dt + "', '" + noteName + "'");
        NoteManager manager = new NoteManager();

    }

    public void UpdateNoteNameAndText(List<Note> notebook, String changeNameNote, String changeTextNote, int idNote) throws SQLException {

        Statement SQL = connection.createStatement();

        LocalDateTime currentDateTime = LocalDateTime.now();
        // Создание объекта форматтера
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Применение форматирования к текущей дате и времени
        String dt = currentDateTime.format(formatter);

        SQL.execute("UPDATE notes set nameNote = '" + changeNameNote + "', textNote= '" + changeTextNote + "', dtChange= '" + dt + "' where id = " + idNote);

        for (Note note : notebook) {
            if (note.getId() == idNote) {
                note.setNameNote(changeNameNote);
                note.setTextNote(changeTextNote);
                note.setDtChange(dt);
                break;
            }

        }

    }

    public void UpdateNoteName(List<Note> notebook, String changeNameNote, int idNote) throws SQLException {


        Statement SQL = connection.createStatement();

        LocalDateTime currentDateTime = LocalDateTime.now();
        // Создание объекта форматтера
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Применение форматирования к текущей дате и времени
        String dt = currentDateTime.format(formatter);

        SQL.execute("UPDATE notes set nameNote = '" + changeNameNote + "',  dtChange= '" + dt + "' where id = " + idNote);

        for (Note note : notebook) {
            if (note.getId() == idNote) {
                note.setNameNote(changeNameNote);
                note.setDtChange(dt);
                break;
            }

        }

    }

    public void UpdateNoteText(List<Note> notebook, String changeTextNote, int idNote) throws SQLException {


        Statement SQL = connection.createStatement();

        LocalDateTime currentDateTime = LocalDateTime.now();
        // Создание объекта форматтера
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Применение форматирования к текущей дате и времени
        String dt = currentDateTime.format(formatter);

        SQL.execute("UPDATE notes set  textNote= '" + changeTextNote + "', dtChange= '" + dt + "' where id = " + idNote);

        for (Note note : notebook) {
            if (note.getId() == idNote) {
                note.setTextNote(changeTextNote);
                note.setDtChange(dt);
                break;
            }

        }

    }

    public void DeleteNote(int idNote) throws SQLException {

        notebook.removeIf(note -> note.getId() == idNote);
        Statement SQL = connection.createStatement();
        SQL.execute("DELETE FROM notes where id=" + idNote);

    }

    public void DrawNotes() {

        for (Note bufNote : notebook) {

            int width = bufNote.getWidth();
            int height = bufNote.getHeight();
            String Name = bufNote.getNameNote().trim();
            String txt = bufNote.getTextNote();

            String info = "| " + bufNote.getId() + " | " + bufNote.getDtCreate() + "  |  " + bufNote.getDtChange();
            if (info.length() > width - 1) {
                width = info.length() + 1;
            }
            //Верх
            for (int i = 0; i < width; i++) {
                System.out.print('-');
            }
            System.out.println(' ');
            //Верх

            //инфа
            System.out.print(info);
            for (int i = 0; i < (width - info.length() - 1); i++) {
                System.out.print(' ');
            }
            System.out.println('|');
            for (int i = 0; i < width; i++) {
                System.out.print('-');
            }
            System.out.println(' ');
            //инфа

            //Название
            System.out.print('|');
            for (int i = 0; i < ((width - Name.length()) / 2); i++) {
                System.out.print(" ");
            }

            System.out.print(Name);

            for (int i = 0; i < (((width - Name.length()) / 2) + ((width - Name.length()) % 2) - 2); i++) {
                System.out.print(" ");
            }
            System.out.println('|');
            //Название

            //Низ
            for (int i = 0; i < width; i++) {
                System.out.print('-');
            }
            System.out.println(' ');
            //Низ
            int Counter = 0;
            for (int j = 0; j < height; j++) {
                System.out.print('|');

                for (int i = 0; i < width - 2; i++) {
                    if (Counter < txt.length()) {
                        System.out.print(txt.charAt(Counter));
                        Counter++;
                    } else {
                        System.out.print(' ');
                    }
                }


                System.out.println('|');
            }
            //Низ
            for (int i = 0; i < width; i++) {
                System.out.print('-');
            }
            System.out.println(' ');
            //Низ
        }
    }
}