notes 
{
     id INT AUTO_INCREMENT PRIMARY KEY, 
     nameNote VARCHAR(255), 
     textNote VARCHAR(255), 
     dtCreate TIMESTAMP, 
     dtChange TIMESTAMP
}

// String createTableQuery = "CREATE TABLE IF NOT EXISTS notes (id INT AUTO_INCREMENT PRIMARY KEY, nameNote VARCHAR(10), textNote VARCHAR(255), dtCreate TIMESTAMP, dtChange TIMESTAMP)";
        // String createTableQuery = "INSERT INTO notes (nameNote, textNote, dtCreate, dtChange  ) SELECT 'Тестовая','привет мир','2024-05-16','2024-05-16' ";