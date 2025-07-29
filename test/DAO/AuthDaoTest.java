package DAO;

import Model.AdminModel;
import Model.LoginModel;
import Model.Userdata;
import org.junit.*;

import static org.junit.Assert.*;

public class AuthDaoTest {

    private AuthDao instance;

    @Before
    public void setUp() {
        instance = new AuthDao();
    }

    @Test
    public void testRegister() {
        System.out.println("register");

        Userdata user = new Userdata();
        user.setfullName("Test User");
        user.setEmail("testuser@example.com");
        user.setUsername("testuser");
        user.setPassword("testpass123");
        user.setSecurityAnswer("blue");

        instance.register(user);

       
        assertTrue(instance.checkUser(user));
    }

    @Test
    public void testCheckUser() {
        System.out.println("checkUser");

        Userdata user = new Userdata();
        user.setEmail("testuser@example.com");
        user.setUsername("testuser");

        boolean result = instance.checkUser(user);
        assertTrue(result);
    }

    @Test
    public void testLogin() {
        System.out.println("login");

        LoginModel user = new LoginModel();
        user.setUsername("testuser");
        user.setPassword("testpass123");

        int result = instance.login(user);
        assertTrue(result >= 0); 
    }

    @Test
    public void testGetSecutityAnswerAndUsername() {
        System.out.println("getSecutityAnswerAndUsername");

        String username = "testuser";

        Userdata result = instance.getSecutityAnswerAndUsername(username);

        assertNotNull(result);
        assertEquals("testuser", result.getUsername());
        assertEquals("blue", result.getSecurityAnswer());
    }

    @Test
    public void testUpdatePasswordBySecurityAnswer() {
        System.out.println("updatePasswordBySecurityAnswer");

        String email = "testuser@example.com";
        String securityAnswer = "blue";
        String newPassword = "newpass456";

        boolean result = instance.updatePasswordBySecurityAnswer(email, securityAnswer, newPassword);
        assertTrue(result);

       
        LoginModel user = new LoginModel();
        user.setUsername("testuser");
        user.setPassword("newpass456");

        int userId = instance.login(user);
        assertTrue(userId >= 0);
    }

    @Test
    public void testIsEmailRegistered() {
        System.out.println("isEmailRegistered");

        String email = "testuser@example.com";

        boolean result = instance.isEmailRegistered(email);
        assertTrue(result);
    }

    @Test
    public void testAdminLogin() {
        System.out.println("AdminLogin");

        AdminModel admin = new AdminModel();
        admin.setAdminName("admin");         
        admin.setPassword("admin123");       

        boolean result = instance.AdminLogin(admin);
        assertTrue(result); 
    }
}

