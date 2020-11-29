package lms.funix.lab.dao;

import lms.funix.lab.entities.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

import static lms.funix.lab.view.View.Login.*;
import static lms.funix.lab.view.View.Login.Config.MAX_ATTEMPTS;
import static lms.funix.lab.view.View.Path.DAO.*;
import static lms.funix.lab.view.View.Path.DAO.FILE_PATH.USER_FILE;

public class UserDAO {
    /**
     * query all user into arraylist, delete the whole file, update new user, then print all back
     * @param updatingUser
     */
    public static synchronized void updateUser(User updatingUser) {
        final ArrayList<User> allUsers = getAllUsers();
        updateUserInList(allUsers, updatingUser);

        try (PrintWriter writer = new PrintWriter(new FileWriter(getFilePath(USER_FILE), false))) {
            allUsers.forEach(user -> writer.println(userToStringDAO(user)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * append user to the end of database
     * @param user
     */
    public static synchronized void addUser(User user) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(getFilePath(USER_FILE), true))) {
            writer.println(userToStringDAO(user));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * get all current users from database
     * @return list of existing users
     */
    public static ArrayList<User> getAllUsers() {
        ArrayList<User> out = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(getFilePath(USER_FILE)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                final String[] attributes = line.split(SEPARATOR);
                final User currentUser = new User(attributes[0], attributes[1], Integer.parseInt(attributes[2]) == 1, Integer.parseInt(attributes[3]));
                out.add(currentUser);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }

    /**
     *
     * @param user
     * @return true if correct, false if user doesn't exist in database
     * @throws Exception - errorMessage if user found but wrong password -> increase failed attempts
     */
    public static boolean validateUser(User user) throws Exception {
        final File file = new File(getFilePath(USER_FILE));
        System.out.println(file.getAbsolutePath());

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                final String[] attributes = line.split(SEPARATOR);
                final User currentUser = new User(attributes[0], attributes[1], Integer.parseInt(attributes[2]) == 1, Integer.parseInt(attributes[3]));
                if (Objects.equals(user.getUserID(), currentUser.getUserID())) {
                    // if userID matches
                    if (currentUser.getFailedAttempts() >= MAX_ATTEMPTS) {
                        throw new Exception(MSG3);
                    } else if (Objects.equals(user.getPassword(), currentUser.getPassword())) {
                        return true;
                    } else {
                        currentUser.increaseFailedAttempts();
                        //TODO: update User to database
                        updateUser(currentUser);
                        throw new Exception(MSG2 + (MAX_ATTEMPTS - currentUser.getFailedAttempts()));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * update User to List
     * @param list will be updated by reference
     * @param updatingUser
     */
    private static void updateUserInList(ArrayList<User> list, User updatingUser) {
        list.set(
                list.indexOf( //get index of updating User
                        list.stream()
                                .filter(user -> user.getUserID().equals(updatingUser.getUserID()))
                                .findAny()
                                .orElse(null)),
                updatingUser); //update it
    }

    /**
     * convert User to be stored-readable in text file
     * split by SEPARATOR
     * @param user
     * @return String can be inserted into database
     */
    private static String userToStringDAO(User user) {
        ArrayList<String> args = new ArrayList<>();
        args.add(user.getUserID());
        args.add(user.getPassword());
        args.add(user.isFirstLogin() ? TRUE_STRING : FALSE_STRING);
        args.add(String.valueOf(user.getFailedAttempts()));
        return String.join(SEPARATOR, args);
    }

    private static String getFilePath(String file) {
        return RESOURCE_PATH + DATABASE_LOCATION + file;
    }

}
