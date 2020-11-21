package lms.funix.lab.bo;

import lms.funix.lab.entities.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testValidate_allUsersCase_successful() {
        Object[][] testUsers = new Object[][]{
                {"123", "abc", true, "valid"},
                {"123", "abc123", true, "valid"},
                {"123", "123", true, "valid"},
                {"1234a", "alskdj2", false, "userID allows number only"},
                {"123456", "asdfghjkl", false, "password's maximum length is 8"},
                {"12345678765432112", "asklj", false, "userID's maximum length is 16"},
                {"", "alsdjf", false, "userID is empty"},
                {"1234", "", false, "password is empty"}
        };

        final Login login = new Login();
        for (Object[] testUser : testUsers) {
            assertEquals((boolean) testUser[2], login.validate(new User((String) testUser[0], (String) testUser[1])), (String) testUser[3]);
        }
    }

    @Test
    void login() {
    }
}