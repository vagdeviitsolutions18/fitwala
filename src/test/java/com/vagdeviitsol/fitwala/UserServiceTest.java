package com.vagdeviitsol.fitwala;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest {



    @Mock
    private UserRepository userRepositoryMock;


    @InjectMocks
    private UserServiceImp userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddDetails() {
        Users userToAdd = new Users(/* Set user properties */);
        Users expectedUser = new Users(/* Set expected user properties */);

        when(userRepositoryMock.save(userToAdd)).thenReturn(expectedUser);

        Users resultUser = userService.addDetails(userToAdd);

        assertEquals(expectedUser, resultUser);
        verify(userRepositoryMock, times(1)).save(userToAdd);
    }
}
