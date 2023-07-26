package com.vagdeviitsol.fitwala;


import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

public class UserControllerTest {

    @Mock
    private UserServiceImp userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Use MockitoAnnotations.openMocks instead of MockitoAnnotations.initMocks
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testPostDetails() throws Exception {
        Users user = new Users();
        user.setId(11);
        user.setFistName("Lingeswar_mk");
        user.setLastName("Reddy");
        user.setEmail("vbl@gemail.com");
        user.setMobileNo(630016545);
        user.setGender("male");
        user.setAge(22);
        user.setAddress("Beeramguda");
        user.setGymName("Orange");
        user.setPlanType(3);

        // Mock the behavior of the UserServiceImp
        when(userService.addDetails(any(Users.class))).thenReturn(user);

        // Convert the Users object to JSON string using ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = objectMapper.writeValueAsString(user);

        // Perform the POST request with the JSON payload
        mockMvc.perform(post("/addUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 5, \"fistName\": \"Lingeswar\",\"lastName\":\"Reddy\"," +
                                "\"email\":\"vbl@gemail.com\",\"mobileNo\":630016545,\"gender\":\"male\",\"age\":22,\"address\":\"Beeramguda\",\"gymName\":\"Orange\",\"planType\":3}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(11))
                .andExpect(jsonPath("$.fistName").value("Lingeswar_mk"))
                .andExpect(jsonPath("$.lastName").value("Reddy"))
                .andExpect(jsonPath("$.email").value("vbl@gemail.com"))
                .andExpect(jsonPath("$.mobileNo").value(630016545))
                .andExpect(jsonPath("$.gender").value("male"))
                .andExpect(jsonPath("$.age").value(22))
                .andExpect(jsonPath("$.address").value("Beeramguda"))
                .andExpect(jsonPath("$.gymName").value("Orange"))
                .andExpect(jsonPath("$.planType").value(3));
    }
    @Test
    public void testAllUsers() throws Exception {
        List<Users> userList = new ArrayList<>();
        Users user1 = new Users();
        user1.setId(11);
        user1.setFistName("Lingeswar_mk");
        Users user2 = new Users();
        user2.setId(2);
        user2.setFistName("Reddy");
        userList.add(user1);
        userList.add(user2);

        when(userService.getAllUsers()).thenReturn(userList);

        mockMvc.perform(get("/allUsers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(11))
                .andExpect(jsonPath("$[0].fistName").value("Lingeswar_mk"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].fistName").value("Reddy"));
    }
    @Test
    public void testUpdateUser() throws Exception {
        Users user = new Users();
        user.setId(5);
        user.setFistName("lingeswar");

        when(userService.updateUser(anyInt(), any())).thenReturn(user);

        mockMvc.perform(put("/5")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":5, \"fistName\": \"John Doe\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("success"));

    }
    @Test
    public void testGetUsers() throws Exception {
        Users user1 = new Users();
        user1.setId(5);
        user1.setFistName("Lingeswar");
        user1.setLastName("Reddy");

        Users user2 = new Users();
        user2.setId(2);
        user2.setFistName("Jane");
        user2.setLastName("Smith");

        // Mock the behavior of the UserServiceImp
        when(userService.getUsers(anyString())).thenReturn(List.of(user1, user2));

        // Perform the GET request with the query parameter
        mockMvc.perform(get("/searchusers")
                        .param("str", "search-string"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(5));
//                .andExpect(jsonPath("$[0].firstName").value("Lingeswar"))
//                .andExpect(jsonPath("$[0].lastName").value("Reddy"))
//                .andExpect(jsonPath("$[1].id").value(2))
//                .andExpect(jsonPath("$[1].firstName").value("Jane"))
//                .andExpect(jsonPath("$[1].lastName").value("Smith"));
    }
//@Test
//public void testUpdateUser() throws Exception {
//    Users user = new Users();
//    user.setId(12);
//    user.setFistName("lingeswar");
//
//    // Modify the behavior of the UserServiceImp to return the updated user
//    when(userService.updateUser(anyInt(), any())).thenAnswer((invocation) -> {
//        int userId = invocation.getArgument(5);
//        Users updatedUser = invocation.getArgument(6);
//        updatedUser.setId(userId); // Set the id in the updated user
//        return updatedUser;
//    });
//
//    mockMvc.perform(put("/12")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content("{\"id\":11, \"firstName\": \"John Doe\"}"))
//            .andExpect(status().isOk())
//            .andExpect(jsonPath("$.id").value(12))
//            .andExpect(jsonPath("$.firstName").value("lingeswar"));
//}


}