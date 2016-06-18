package unlv.erc.emergo.model;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import unlv.erc.emergo.model.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {



    private User user;
    final int MAXIMUM_LENGHT_NAME = 42;
    final int MAXIMUM_TYPEBLOOD = 3;


    @Before
    public void setUp() {
        user = new User();
    }
    // tests for name

    @Test
    public void testGetName(){
        String name = "Peter";
        user.setName("Peter");
        assertEquals(name,user.getName());
    }

    @Test
    public void testSetName(){
        user.setName("Maria Joaquina");
        assertEquals("Maria Joaquina", user.getName());
    }

    @Test
    public void testSetNameEmpty(){
        user.setName("");
        assertEquals("", user.getName());
    }

    @Test
    public void testSetNameLowerThree(){
        user.setName("Ana");
        final int MINIMUM = 3;
        boolean result = true;
        if(user.getName().trim().length()<MINIMUM){
            assertFalse(result);
        }else{
            assertTrue(result);
        }
    }

    @Test
    public void testSetNameMaximumSize(){

        user.setName("Pedro Alvares Cabral de Valentina");
        boolean result = true;
        if(user.getName().trim().length()>MAXIMUM_LENGHT_NAME){
            assertFalse(result);
        }else{
            assertTrue(result);
        }
    }

    // tests birthday

    @Test
    public void testSetBirthday(){
        user.setBirthday("12/03/1990");
        assertEquals("12/03/1990", user.getBirthday());
    }

    // tests for typeBlood

    @Test
    public void testSetTypeBloodBiggerThree(){
        user.setTypeBlood("AB-");
        boolean result = true;
        if(user.getTypeBlood().length()>MAXIMUM_TYPEBLOOD){
            assertFalse(result);
        }else{
            assertTrue(result);
        }
    }

    @Test
    public void testSetTypeBloodNull() {
        user.setTypeBlood("AB+");
        boolean result = true;
        if(user.getTypeBlood()==null){
            result = false;
            assertTrue(result);
        }else{
            assertTrue(result);
        }
    }

    @Test
    public void testSetTypeBloodLowerOrEqualsTwo(){
        user.setTypeBlood("A-");
        boolean result = true;
        if(user.getTypeBlood().length()<=MAXIMUM_TYPEBLOOD-1){
            assertTrue(result);
        }else{
            assertFalse(result);
        }
    }
}