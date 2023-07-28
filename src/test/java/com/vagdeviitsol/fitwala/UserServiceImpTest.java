package com.vagdeviitsol.fitwala;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpTest {

    @Mock
    private SearchRepositroy searchRepositroy;

    @Mock
    private UserRepository userRepositoryMock;
    @Mock
    private UserRepository searchRepositoryMock;

    @InjectMocks
    private UserServiceImp userService;


    @Test
    public void testAddDetails() {
        MockitoAnnotations.initMocks(this);

           final Users userToAdd = new Users();
           userToAdd.setId(5);
           userToAdd.setFistName("Lingeswar");
           userToAdd.setLastName("Reddy");
           userToAdd.setEmail("john.doe@example.com");
           userToAdd.setMobileNo(63001555);
           userToAdd.setGender("Male");
           userToAdd.setAge(22);
           userToAdd.setAddress("123 Main Street, City");
           userToAdd.setGymName("Fitness Center");
           userToAdd.setPlanType(3);
           final Users expectedUser = new Users();
           expectedUser.setId(5);
           expectedUser.setFistName("Lingeswar");
           expectedUser.setLastName("Reddy");
           expectedUser.setEmail("john.doe@example.com");
           expectedUser.setMobileNo(63001555);
           expectedUser.setGender("Male");
           expectedUser.setAge(22);
           expectedUser.setAddress("123 Main Street, City");
           expectedUser.setGymName("Fitness Center");
           expectedUser.setPlanType(3);

        when(userRepositoryMock.save(userToAdd)).thenReturn(expectedUser);

            Users resultUser = userService.addDetails(userToAdd);

            assertEquals(expectedUser, resultUser);
            verify(userRepositoryMock, times(1)).save(userToAdd);
        }
    @Test
    public void testGetUserById() {
        MockitoAnnotations.initMocks(this);
        Long userId = 1L;

        Users expectedUser = new Users();
        expectedUser.setId(5);
        expectedUser.setFistName("Lingeswar");
        expectedUser.setLastName("Reddy");
        expectedUser.setEmail("john.doe@example.com");
        expectedUser.setMobileNo(63001555);
        expectedUser.setGender("Male");
        expectedUser.setAge(22);
        expectedUser.setAddress("123 Main Street, City");
        expectedUser.setGymName("Fitness Center");
        expectedUser.setPlanType(3);

        when(userRepositoryMock.findById(userId)).thenReturn(Optional.of(expectedUser));

        Optional<Users> resultUser = userService.getUserById(userId);

        assertTrue(resultUser.isPresent());
        assertEquals(expectedUser, resultUser.get());
        verify(userRepositoryMock, times(1)).findById(userId);
    }
    @Test
    public void testGetUserByIdNotFound() {
        MockitoAnnotations.initMocks(this);
        Long userId = 1L;

        when(userRepositoryMock.findById(userId)).thenReturn(Optional.empty());

        Optional<Users> resultUser = userService.getUserById(userId);

        assertFalse(resultUser.isPresent());
        verify(userRepositoryMock, times(1)).findById(userId);
    }
    @Test
    public void testUpdateUser() {
        MockitoAnnotations.initMocks(this);
        Long userId = 5L;
        Users userToUpdate = new Users();
        userToUpdate.setFistName("Lingeswar");
        userToUpdate.setLastName("Reddy");
        userToUpdate.setEmail("john.doe@example.com");
        userToUpdate.setMobileNo(63001555);
        userToUpdate.setGender("Male");
        userToUpdate.setAge(22);
        userToUpdate.setAddress("123 Main Street, City");
        userToUpdate.setGymName("Fitness Center");
        userToUpdate.setPlanType(3);

        Users existingUser = new Users();

        existingUser.setId(userId);
        existingUser.setFistName("John");
        existingUser.setLastName("Doe");
        existingUser.setEmail("john.doe@example.com");
        existingUser.setMobileNo(63001555);
        existingUser.setGender("Male");
        existingUser.setAge(25);
        existingUser.setAddress("456 Park Avenue, Town");
        existingUser.setGymName("Fitness Studio");
        existingUser.setPlanType(2);

        // Mock the behavior of userRepositoryMock.findById()
        when(userRepositoryMock.findById(userId)).thenReturn(Optional.of(existingUser));

        // Mock the behavior of userRepositoryMock.save()
        when(userRepositoryMock.save(any(Users.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Users updatedUser = userService.updateUser(userId, userToUpdate);

        // Verify that the update was successful
        assertNotNull(updatedUser);
        assertEquals(userId, updatedUser.getId());
        assertEquals(userToUpdate.getFistName(), updatedUser.getFistName());
        assertEquals(userToUpdate.getLastName(), updatedUser.getLastName());
        assertEquals(userToUpdate.getEmail(), updatedUser.getEmail());
        assertEquals(userToUpdate.getMobileNo(), updatedUser.getMobileNo());
        assertEquals(userToUpdate.getGender(), updatedUser.getGender());
        assertEquals(userToUpdate.getAge(), updatedUser.getAge());
        assertEquals(userToUpdate.getAddress(), updatedUser.getAddress());
        assertEquals(userToUpdate.getGymName(), updatedUser.getGymName());
        assertEquals(userToUpdate.getPlanType(), updatedUser.getPlanType());

        // Verify that the userRepositoryMock.findById() was called once
        verify(userRepositoryMock, times(1)).findById(userId);

        // Verify that the userRepositoryMock.save() was called once with the correct user object
        verify(userRepositoryMock, times(1)).save(updatedUser);
    }
    @Test
    public void testGetUsers() {
        MockitoAnnotations.initMocks(this);
        String searchQuery = "{\"fistName\":\"John\", \"planType\":3}";

        List<Users> expectedUsers = new ArrayList<>();
        Users user1 = new Users();
        user1.setId(5);
        user1.setFistName("John");
        user1.setLastName("Doe");
        user1.setEmail("john.doe@example.com");
        user1.setMobileNo(123456789);
        user1.setGender("Male");
        user1.setAge(30);
        user1.setAddress("123 Main Street, City");
        user1.setGymName("Fitness Center");
        user1.setPlanType(3);
        expectedUsers.add(user1);

        Users user2 = new Users();
        user2.setId(5);
        user2.setFistName("Jane");
        user2.setLastName("Smith");
        user2.setEmail("jane.smith@example.com");
        user2.setMobileNo(987654321);
        user2.setGender("Female");
        user2.setAge(25);
        user2.setAddress("456 Park Avenue, Town");
        user2.setGymName("Fitness Studio");
        user2.setPlanType(4);
        expectedUsers.add(user2);

        when(searchRepositroy.getUsers(anyString())).thenReturn(expectedUsers);

        List<Users> resultUsers = userService.getUsers(searchQuery);

        assertEquals(expectedUsers, resultUsers);
        verify(searchRepositroy, times(1)).getUsers(anyString());
    }
//    @Test
//    public void testUpdateUserNotFound() {
//        MockitoAnnotations.initMocks(this);
//        int userId = 1;
//        Users userToUpdate = new Users();
//        userToUpdate.setId(5);
//        userToUpdate.setFistName("Lingeswar");
//        userToUpdate.setLastName("Reddy");
//        userToUpdate.setEmail("john.doe@example.com");
//        userToUpdate.setMobileNo(63001555);
//        userToUpdate.setGender("Male");
//        userToUpdate.setAge(22);
//        userToUpdate.setAddress("123 Main Street, City");
//        userToUpdate.setGymName("Fitness Center");
//        userToUpdate.setPlanType(3);
//
//        when(userRepositoryMock.existsById(userId)).thenReturn(false);
//
//        Users resultUser = userService.updateUser(userId, userToUpdate);
//
//        assertNull(resultUser);
//        verify(userRepositoryMock, never()).save(userToUpdate);
//        verify(userRepositoryMock, times(1)).existsById(userId);
//    }

//        final Users userToAdd = new Users();
//        userToAdd.setId(5);
//        userToAdd.setFistName("Lingeswar");
//        userToAdd.setLastName("Reddy");
//        userToAdd.setEmail("john.doe@example.com");
//        userToAdd.setMobileNo(63001555);
//        userToAdd.setGender("Male");
//        userToAdd.setAge(22);
//        userToAdd.setAddress("123 Main Street, City");
//        userToAdd.setGymName("Fitness Center");
//        userToAdd.setPlanType(3);
//
//        // Mock the behavior of userRepositoryMock.findById() to return an empty Optional
//        given(userRepositoryMock.findById(userToAdd.getId())).willReturn(Optional.empty());
//
//        // Mock the behavior of userRepositoryMock.save() to return the same object as the argument
//        when(userRepositoryMock.save(userToAdd)).thenAnswer(invocation -> invocation.getArgument(0));
//
//        Users resultUser = userService.addDetails(userToAdd);
//
//        assertThat(resultUser).isNotNull();
//        assertThat(resultUser.getId()).isEqualTo(5);
//        assertThat(resultUser.getFistName()).isEqualTo("Lingeswar");
//        assertThat(resultUser.getLastName()).isEqualTo("Reddy");
//        assertThat(resultUser.getEmail()).isEqualTo("john.doe@example.com");
//        assertThat(resultUser.getMobileNo()).isEqualTo(63001555);
//        assertThat(resultUser.getGender()).isEqualTo("Male");
//        assertThat(resultUser.getAge()).isEqualTo(22);
//        assertThat(resultUser.getAddress()).isEqualTo("123 Main Street, City");
//        assertThat(resultUser.getGymName()).isEqualTo("Fitness Center");
//        assertThat(resultUser.getPlanType()).isEqualTo(3);
//
//        verify(userRepositoryMock).findById(userToAdd.getId());
//        verify(userRepositoryMock).save(userToAdd);
//    }
}




























































//import net.bytebuddy.dynamic.DynamicType;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import java.util.Optional;
//
//
//import static java.awt.dnd.DnDEventMulticaster.save;
//import static jdk.internal.jimage.ImageLocation.verify;
//import static net.bytebuddy.matcher.ElementMatchers.any;
//import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;
//import static org.mockito.BDDMockito.given;
//
//public class UserServiceImpTest {
//
//    @Mock
//    private UserRepository userRepositoryMock;
//
//    @InjectMocks
//    private UserServiceImp userService;
//
////    @Before
////    public void setUp() {
////        MockitoAnnotations.initMocks(this);
////    }
//
//    @Test
//    public void testAddDetails() {
//        final Users userToAdd = new Users();
//        userToAdd.setId(5);
//        userToAdd.setFistName("Lingeswar");
//        userToAdd.setLastName("Reddy");
//        userToAdd.setEmail("john.doe@example.com");
//        userToAdd.setMobileNo(630015555);
//        userToAdd.setGender("Male");
//        userToAdd.setAge(22);
//        userToAdd.setAddress("123 Main Street, City");
//        userToAdd.setGymName("Fitness Center");
//        userToAdd.setPlanType(3);
//
//        Users expectedUser = new Users();
//        expectedUser.setId(5);
//        expectedUser.setFistName("John");
//        expectedUser.setLastName("Doe");
//        expectedUser.setEmail("john.doe@example.com");
//        expectedUser.setMobileNo(630015555);
//        expectedUser.setGender("Male");
//        expectedUser.setAge(22);
//        expectedUser.setAddress("123 Main Street, City");
//        expectedUser.setGymName("Fitness Center");
//        expectedUser.setPlanType(3);
//
//        given(userRepositoryMock.findById(userToAdd.getId())).willReturn(Optional.empty());
//        given(userRepositoryMock.save(userToAdd)).willAnswer(invocation -> invocation.getArguments());
//       // when(userRepositoryMock.save(userToAdd)).thenReturn(expectedUser);
//
//        Users resultUser = userService.addDetails(userToAdd);
//
//        assertThat(resultUser).isNotNull();;
//        verify(userRepositoryMock,save(any(userToAdd.class));
//    }
//}