package net.engineeringdigest.journalapp.service;

import net.engineeringdigest.journalapp.entity.User;
import net.engineeringdigest.journalapp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserSercviceTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @ParameterizedTest
    @ArgumentsSource(net.engineeringdigest.journalApp.service.UserArgumentsProvider.class)
    @Disabled //Currently no tests needed
    public void testSaveNewUser(User user) {
        assertTrue(userService.saveNewUser(user));
    }

    @Disabled // same as above
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,9"
    })
    public void test (int a, int b, int expected) {
        assertEquals(expected, a + b);
    }
}
