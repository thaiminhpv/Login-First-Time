package lms.funix.lab.bo;

import lms.funix.lab.entities.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static lms.funix.lab.view.View.Login.MSG1;
import static lms.funix.lab.view.View.Login.MSG2;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginBOTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testValidate_allUsersCase_successful() {
        Object[][] testUsers = new Object[][]{
                // userID / password / expected output / Message
                {"123", "abc", true, "valid"},
                {"123", "abc123", true, "valid"},
                {"123", "123", true, "valid"},
                {"1234a", "alskdj2", false, "userID allows number only"},
                {"123456", "asdfghjkl", false, "password's maximum length is 8"},
                {"12345678765432112", "asklj", false, "userID's maximum length is 16"},
                {"", "alsdjf", false, "userID is empty"},
                {"1234", "", false, "password is empty"}
        };

        List<Executable> tests = new ArrayList<>();
        final LoginBO loginBO = new LoginBO();
        for (Object[] testUser : testUsers) {
            try {
                loginBO.validate(new User((String) testUser[0], (String) testUser[1]));
                throw new Exception();
            } catch (Exception e) {
                tests.add(() -> assertEquals(testUser[2], !Objects.equals(e.getMessage(), MSG1), (String) testUser[3]));
            }
        }
        assertAll(tests);
    }


    @Test
    void login() {
    }

}