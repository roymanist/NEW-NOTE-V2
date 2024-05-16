package services;

import obj.Note;

import java.util.List;

public interface IDrawNotes {
    public default void DrawNotes(List<Note> notebook) {

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
        ;
    }
}
