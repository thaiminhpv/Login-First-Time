package lms.funix.lab.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import static lms.funix.lab.commons.HelperDAO.getFilePath;
import static lms.funix.lab.view.View.Path.DAO.FILE_PATH.USER_FILE;
import static lms.funix.lab.view.View.Path.DAO.SEPARATOR;

public class HintDAO {
    /**
     * append hints to the end of database
     */
    public static synchronized void addHints(String userID, Map<String, String> hintsList) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(getFilePath(USER_FILE), true))) {
            hintsList.forEach((key, value) -> writer.println(hintsToStringDAO(userID, key, value)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * convert User to be stored-readable in text file
     * split by SEPARATOR
     * @return String can be inserted into database
     */
    private static String hintsToStringDAO(String userID, String key, String value) {
        ArrayList<String> line = new ArrayList<>();
        line.add(userID);
        line.add(key);
        line.add(value);
        return String.join(SEPARATOR, line);
    }
}
