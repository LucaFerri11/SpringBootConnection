package com.springdb.SpringDB;

import com.springdb.SpringDB.controllers.UserController;
import com.springdb.SpringDB.models.HttpResponse;
import com.springdb.SpringDB.models.User;
import com.springdb.SpringDB.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

public class UserControllerTests extends SpringDbApplicationTests {

    @Mock
    UserService userServiceMock;

    @InjectMocks
    UserController userControllerMock = new UserController();

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveUserTest() {
        User user = new User(1,"Luca", "Ferri", "333", "email@mock");

        HttpResponse response = userControllerMock.saveUser(user);

        assertTrue(response.isSuccess());
    }

    @Test
    public void saveUserInputTooLongTest() {
        User userFirstNameTooLong = new User(1,"LucaLucaLucaLucaLucaLucaLuca",
                "Ferri", "333", "email@mock");
        User userLastNameTooLong = new User(1,"Luca", "LucaLucaLucaLucaLucaLucaLuca",
                "333", "email@mock");
        User userPhoneNumberTooLong = new User(1,"Luca", "Ferri",
                "LucaLucaLucaLucaLucaLucaLuca", "email@mock");
        User userEmailTooLong = new User(1,"Luca", "Ferri",
                "333", "LucaLucaLucaLucaLucaLucaLuca");


        HttpResponse responseFirstNameTooLong = userControllerMock.saveUser(userFirstNameTooLong);
        HttpResponse responseLastNameTooLong = userControllerMock.saveUser(userLastNameTooLong);
        HttpResponse responsePhoneNumberTooLong = userControllerMock.saveUser(userPhoneNumberTooLong);
        HttpResponse responseEmailTooLong = userControllerMock.saveUser(userEmailTooLong);

        assertFalse(responseFirstNameTooLong.isSuccess());
        assertFalse(responseLastNameTooLong.isSuccess());
        assertFalse(responsePhoneNumberTooLong.isSuccess());
        assertFalse(responseEmailTooLong.isSuccess());
    }
}
