package services;

import java.nio.file.Path;
import java.nio.file.Paths;

public interface GetURLDBase {
    public default String GetURL()
    {
        String relativePath = "src/main/java/resources/NoteDBase";

        // Преобразование относительного пути в абсолютный
        Path path = Paths.get(relativePath).toAbsolutePath();
        String URL = "jdbc:h2:" + path;
        return URL;
    }

}
