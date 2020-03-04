package com.raulreyes.restApi.user;

import com.raulreyes.restApi.entity.User;
import com.raulreyes.restApi.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class userServiceTest {

    @MockBean
    private UserService userService;

    @DisplayName("Test Spring @Autowired Integration")
    @Test
    void testGet() {
        User user = userService.findById(4);
        System.out.print(user);
        assertEquals("Hello JUnit 5", userService.findById(3));
    }
}
