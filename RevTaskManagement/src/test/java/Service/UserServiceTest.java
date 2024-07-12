package Service;

import org.example.DAO.UserDAO;
import org.example.Models.Users;
import org.example.Services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private UserService userSer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoginUserSuccess() throws SQLException {
        Users user = new Users();
        user.setEmail("test@example.com");
        user.setUser_password("password");

        when(userDAO.getByEmail("test@example.com")).thenReturn(user);

        Users result = userSer.loginUser("test@example.com", "password");

        assertNotNull(result);
        assertEquals("test@example.com", result.getEmail());
        verify(userDAO, times(1)).getByEmail("test@example.com");
    }

    @Test
    void testLoginUserFailure() throws SQLException {
        when(userDAO.getByEmail("test@example.com")).thenReturn(null);

        Users result = userSer.loginUser("test@example.com", "password");

        assertNull(result);
        verify(userDAO, times(1)).getByEmail("test@example.com");
    }

    @Test
    void testGetUserRoleById() throws SQLException {
        Users user = new Users();
        user.setUser_role("Admin");

        when(userDAO.getUserById(1)).thenReturn(user);

        String role = userSer.getUserRoleById(1);

        assertEquals("Admin", role);
        verify(userDAO, times(1)).getUserById(1);
    }
}
