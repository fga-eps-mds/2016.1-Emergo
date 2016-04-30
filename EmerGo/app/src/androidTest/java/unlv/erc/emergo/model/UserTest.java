package unlv.erc.emergo.model;
import java.text.ParseException;


import org.junit.Test;

import junit.framework.TestCase;


public class UserTest extends TestCase {

    @Test
    public void testGetName(){
        User user = new User();
        String name = "Peter";
        user.setName("Peter");
        assertEquals(name,user.getName());
    }

    @Test
    public void testSetName(){
        User user = new User();
        user.setName("Maria Joaquina");
        assertEquals("Maria Joaquina", user.getName());
    }

    @Test
    public void testSetNameEmpty(){
        User user = new User();
        user.setName("");
        assertEquals("", user.getName());
    }







}
