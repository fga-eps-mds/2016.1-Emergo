package unlv.erc.emergo.model;

import junit.framework.TestCase;

import org.junit.Test;


public class HealthUnitTest extends TestCase{

    @Test
    public void testGetNameHealthUnit(){
        User user = new User();
        String name = "Hospital Regional do Gama";
        user.setName("Hospital Regional do Gama");
        assertEquals(name,user.getName());
    }


}
