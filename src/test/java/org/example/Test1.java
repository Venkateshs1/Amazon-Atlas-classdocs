package org.example;
import day37Test.Main.User;
import day37Test.Main.UserRepository;
import day37Test.Main.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class Test1 {
    @Mock
    private UserRepository userRepository;


    @InjectMocks
    private UserService userService;


    @Test
    void testRegisterUser() {


        User newUser = new User();
        newUser.setName("Himanshu Rajpoot");


        when(userRepository.save(any(User.class))).thenReturn(newUser);


        User registeredUser = userService.registerUser(newUser);

        assertNotNull(registeredUser);
        assertNotNull(registeredUser.getRegistrationDate());
    }
}
