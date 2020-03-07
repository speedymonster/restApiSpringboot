package com.raulreyes.restApi.user;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raulreyes.restApi.entity.User;
import com.raulreyes.restApi.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class userControllerTest {

    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    @DisplayName("Test Spring @Autowired Integration")
    @Test
    void testGetListUser() throws Exception {
        User user = new User();
        user.setId(2);
        user.setEmail("dfd");
        user.setPassword("aaaaa");
        user.setCreateAt(new Date());
        user.setUpdatedAt(new Date());

        List<User> users = Arrays.asList(user);

        given(userService.findAll()).willReturn(users);

        mockMvc.perform(get("/api/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(2)));
    }
}
