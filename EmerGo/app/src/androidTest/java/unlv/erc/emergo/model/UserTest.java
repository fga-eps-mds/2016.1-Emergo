package unlv.erc.emergo.model;
import junit.framework.TestCase;

//import org.junit.Test;


public class UserTest extends TestCase {


    public void testGetName(){
        User user = new User();
        String name = "Peter";
        user.setName("Peter");
        assertEquals(name,user.getName());
    }

   // @Test
    public void testSetName(){
        User user = new User();
        user.setName("Maria Joaquina");
        assertEquals("Maria Joaquina", user.getName());
    }

   // @Test
    public void testSetNameEmpty(){
        User user = new User();
        user.setName("");
        assertEquals("", user.getName());
    }


    public void testSetTypeBloodBiggerThree(){
        User user = new User();
        user.setTypeBlood("AB-");
        boolean result = true;
        if(user.getTypeBlood().length()>3){
            assertFalse(result);
        }else{
            assertTrue(result);
        }
    }

    public void testSetAllergyLowerFour(){
        User user = new User();
        user.setAllergy("Camarão");
        boolean result = true;
        if(user.getAllergy().trim().length() < 4){
            assertFalse(result);
        }else{
            assertTrue(result);
        }
    }

    public void testSetNameLowerThree(){
        User user = new User();
        user.setName("Ana");
        boolean result = true;
        if(user.getName().trim().length()<3){
            assertFalse(result);
        }else{
            assertTrue(result);
        }
    }

    public void testSetTypeBloodNull() {
        User user = new User();

        user.setTypeBlood("AB+");
        boolean result = true;
        if(user.getTypeBlood()==null){
            assertFalse(result);
        }else{
            assertTrue(result);
        }
    }

    public void testSetTypeBloodLowerOrEqualsTwo(){
        User user = new User();

        user.setTypeBlood("A-");
        boolean result = true;
        if(user.getTypeBlood().length()<=2){
            assertFalse(result);
        }else{
            assertTrue(result);
        }
    }

    public void testSetAllergyBiggerTwoHundred(){
        User user = new User();
        user.setAllergy("Alergia");
        boolean result = true;
        if(user.getAllergy().trim().length()>200){
            assertFalse(result);
        }else{
            assertTrue(result);
        }
    }
}
