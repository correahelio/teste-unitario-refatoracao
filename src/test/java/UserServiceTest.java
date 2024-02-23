import org.example.Main;
import org.example.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Main.class)
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @BeforeEach
    public void setup() {
        userService.deleteAllUsers();
    }

    @Test
    public void when_no_users_return_empty_list() {
        var usersFromDb = userService.getUsers();
        assertTrue(usersFromDb.isEmpty());
    }

    @Test
    public void insert_new_user() {
        userService.addUser("Helio");
        var usersFromDb = userService.getUsers();
        assertFalse(usersFromDb.isEmpty());
        assertEquals(usersFromDb.get(0), "Helio");
    }

    @Test()
    public void throw_exception_when_user_is_null() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.addUser(null);
        });

        String expectedMessage = "Usuário não pode estar nulo";
        String actualMessage = exception.getMessage();

        assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void insert_formatted_user_name() {
        userService.formatAndSaveUser("helio");
        var usersFromDb = userService.getUsers();
        assertFalse(usersFromDb.isEmpty());
        assertEquals(usersFromDb.get(0), "HELIO");

        userService.formatAndSaveUser("HELIO");
        usersFromDb = userService.getUsers();
        assertFalse(usersFromDb.isEmpty());
        assertEquals(usersFromDb.get(1), "helio");
    }

    @Test
    public void insert_formatted_user_name_with_z() {
        userService.formatAndSaveUser("zebra");
        var usersFromDb = userService.getUsers();
        assertTrue(usersFromDb.isEmpty());
    }

    @Test
    public void insert_formatted_user_name_with_a() {
        userService.formatAndSaveUser("aluisio");
        var usersFromDb = userService.getUsers();
        assertFalse(usersFromDb.isEmpty());
        assertEquals(usersFromDb.get(0), "aluisio");
        assertEquals(usersFromDb.get(1), "ALUISIO");
    }
}

