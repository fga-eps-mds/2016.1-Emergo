package unlv.erc.emergo.model;


import junit.framework.TestCase;

public class UserTest extends TestCase {

    // tests for user

    public void testGetName(){
        User user = new User();
        String name = "Peter";
        user.setName("Peter");
        assertEquals(name,user.getName());
    }



}
