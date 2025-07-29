package DAO;

import Model.RoomModel;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddRoomDaoTest {

    private AddRoomDao instance;

    @Before
    public void setUp() {
        instance = new AddRoomDao();
    }

    @Test
    public void testAddRoom() {
        System.out.println("Testing: AddRoom");

       
        RoomModel roomModel = new RoomModel("Norml", 84, 80007, "test_images/nomal_test.jpg");

        boolean result = instance.AddRoom(roomModel);

        assertTrue("Room should be added successfully", result);
    }
}
