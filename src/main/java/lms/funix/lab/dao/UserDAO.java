package lms.funix.lab.dao;

import lms.funix.lab.entities.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static lms.funix.lab.view.View.Path.DAO.*;

public class UserDAO {
    public static synchronized void addUser(User user) {

    }

    public static boolean validate(User user) {
        final File file = new File(RESOURCE_LOCATION + FILE_PATH);
        System.out.println(file.getAbsolutePath());

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                final String[] attributes = line.split(SEPARATOR);
                if (new User(attributes[0], attributes[1]).equals(user)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
