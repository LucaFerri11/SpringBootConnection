package com.springdb.SpringDB;

import com.springdb.SpringDB.models.User;
import com.springdb.SpringDB.repositories.UserRepository;
import com.springdb.SpringDB.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

public class UserServiceTests extends SpringDbApplicationTests{

    @Mock
    UserRepository userRepositoryMock;

    @InjectMocks
    UserService userServiceMock = new UserService();

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void listAllUsersTest() {
        User user = new User(1,"Luca", "Ferri", "333", "email@mock");
        ArrayList<User> userList = new ArrayList<>(Arrays.asList(user));

        when(userServiceMock.listAllUsers()).thenReturn(userList);

        ArrayList<User> result = (ArrayList<User>) userServiceMock.listAllUsers();

        assertEquals(userList, result);
    }

    @Test
    public void listAllUsersEmptyTest() {
        List<User> expected = Collections.<User>emptyList();
        List<User> result = userServiceMock.listAllUsers();

        assertEquals(expected, result);
    }
}
