package net.engineeringdigest.journalapp;

import net.engineeringdigest.journalapp.entity.User;
import net.engineeringdigest.journalapp.repository.UserRepository;
import net.engineeringdigest.journalapp.service.UserDetailsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;


import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ActiveProfiles("dev")
@Disabled
public class UserDetailsServiceImplTests {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Disabled
    void loadUserByUsernameTest() {
        User mockUser =
                new User("ram", "ijnojji");

        // 👇 Make sure roles is not null
        mockUser.setRoles(new ArrayList<>());
        mockUser.getRoles().add("USER");  // or whatever type your roles field is

        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(mockUser);

        UserDetails user = userDetailsService.loadUserByUsername("ram");

        Assertions.assertNotNull(user);
        Assertions.assertEquals("ram", user.getUsername());
    }
}
