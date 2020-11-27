package lms.funix.lab.dao;

import lms.funix.lab.entities.User;

import java.io.*;

public class UserDAO {
    private static final String RESOURCE_LOCATION = "src/main/resources/";
    private static final String FILE_PATH = "users.txt";
    public static final String SEPARATOR = "_";


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
