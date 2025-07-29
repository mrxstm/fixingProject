package DAO;

import Model.Userdata;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserProfileDaoTest {

    private UserProfileDao instance;
    private int testUserId;

    @Before
    public void setUp() {
        instance = new UserProfileDao();

        // Ensure user exists in DB before tests
        Userdata user = new Userdata();
        user.setfullName("Profile Test User");
        user.setEmail("profiletest@example.com");
        user.setUsername("profileuser");
        user.setPassword("testpass");
        user.setSecurityAnswer("red");

        AuthDao authDao = new AuthDao();
        authDao.register(user);
        testUserId = authDao.login(new Model.LoginModel("profileuser", "testpass"));
    }

    @Test
    public void testGetUserProfile() {
        System.out.println("getUserProfile");

        Userdata user = instance.getUserProfile(testUserId);

        assertNotNull(user);
        assertEquals("Profile Test User", user.getfullName());
        assertEquals("profiletest@example.com", user.getEmail());
        assertEquals("profileuser", user.getUsername());
    }

    @Test
    public void testUpdateUserProfile() {
        System.out.println("updateUserProfile");

        Userdata updated = new Userdata();
        updated.setfullName("Updated User");
        updated.setEmail("updated@example.com");
        updated.setUsername("updateduser");

        boolean result = instance.updateUserProfile(updated, testUserId);
        assertTrue(result);

        Userdata afterUpdate = instance.getUserProfile(testUserId);
        assertEquals("Updated User", afterUpdate.getfullName());
        assertEquals("updated@example.com", afterUpdate.getEmail());
        assertEquals("updateduser", afterUpdate.getUsername());
    }

    @Test
    public void testDeleteUserProfile() {
        System.out.println("deleteUserProfile");

        boolean result = instance.deleteUserProfile(testUserId);
        assertTrue(result);

        Userdata user = instance.getUserProfile(testUserId);
        assertNull(user); 
    }
}
