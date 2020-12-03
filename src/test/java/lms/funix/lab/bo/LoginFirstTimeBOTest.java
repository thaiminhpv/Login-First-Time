package lms.funix.lab.bo;

import lms.funix.lab.entities.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static lms.funix.lab.view.View.LoginFirstTime.MSG1;
import static lms.funix.lab.view.View.LoginFirstTime.MSG2;
import static org.junit.jupiter.api.Assertions.*;

class LoginFirstTimeBOTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addHints() {
    }

    @Test
    void testCheckChangePassword() {
        Object[][] testUsers = new Object[][]{
                // {userID / old password / new password / confirm password } / actual old password / expected output / Message
                {"123", "abcd123", "abc96", "abc96", "abcd123", null, "valid"},
                {"345", "abcd123", "abc96", "abc70", "abcd123", MSG1, "new password and confirm password must match"},
                {"6973", "mnpq", "abc69", "abc69", "mpnkasdf", MSG2, "old password must match"},
        };

        List<Executable> tests = new ArrayList<>();
        final LoginFirstTimeBO loginFirstTimeBO = new LoginFirstTimeBO();
        for (Object[] testUser : testUsers) {
            try {
                loginFirstTimeBO.checkChangePassword(new User((String) testUser[0], (String) testUser[4]), (String) testUser[1], (String) testUser[2], (String) testUser[3]);
                throw new Exception();
            } catch (Exception e) {
                tests.add(() -> assertEquals(testUser[5], e.getMessage(), (String) testUser[6]));
            }
        }
        assertAll(tests);
    }


    @Test
    void changePassword() {
    }
}