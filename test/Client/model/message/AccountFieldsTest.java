package Client.model.message;

import models.message.AccountFields;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountFieldsTest {
    private AccountFields accountFields;
    private String username = "testUser";
    private String password = "testPassword";

    @BeforeEach
    void setup() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<AccountFields> constructor = AccountFields.class.getDeclaredConstructor(String.class, String.class);
        constructor.setAccessible(true);
        accountFields = constructor.newInstance(username, password);
    }

    @Test
    void testAccountFieldsInitialization() throws NoSuchFieldException, IllegalAccessException {
        // Ellenőrizzük a `username` attribútumot
        Field usernameField = AccountFields.class.getDeclaredField("username");
        usernameField.setAccessible(true);
        String actualUsername = (String) usernameField.get(accountFields);
        assertEquals(username, actualUsername, "A username mező értéke nem megfelelő");

        // Ellenőrizzük a `password` attribútumot
        Field passwordField = AccountFields.class.getDeclaredField("password");
        passwordField.setAccessible(true);
        String actualPassword = (String) passwordField.get(accountFields);
        assertEquals(password, actualPassword, "A password mező értéke nem megfelelő");
    }
}
