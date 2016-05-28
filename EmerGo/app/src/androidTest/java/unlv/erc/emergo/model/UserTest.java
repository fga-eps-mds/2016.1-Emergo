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

    public void testSetName(){
        User user = new User();
        user.setName("Maria Joaquina");
        assertEquals("Maria Joaquina", user.getName());
    }

    public void testSetNameEmpty(){
        User user = new User();
        user.setName("");
        assertEquals("", user.getName());
    }

    public void testSetNameLowerThree(){
        User user = new User();
        user.setName("Ana");
        final int MINIMUM = 3;
        boolean result = true;
        if(user.getName().trim().length()<MINIMUM){
            assertFalse(result);
        }else{
            assertTrue(result);
        }
    }

    public void testSetNameMaximumSize(){
        User user = new User();
        final int MAXIMUM = 42;
        user.setName("Pedro Alvares Cabral de Valentina");
        boolean result = true;
        if(user.getName().trim().length()>MAXIMUM){
            assertFalse(result);
        }else{
            assertTrue(result);
        }
    }



    // tests for typeBlood

    public void testSetTypeBloodBiggerThree(){
        User user = new User();
        user.setTypeBlood("AB-");
        final int MAXIMUM = 3;
        boolean result = true;
        if(user.getTypeBlood().length()>MAXIMUM){
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
        final int MINIMUM = 2;
        user.setTypeBlood("A-");
        boolean result = true;
        if(user.getTypeBlood().length()<=MINIMUM){
            assertFalse(result);
        }else{
            assertTrue(result);
        }
    }

    // tests for allergies

    public void testSetAllergyLowerFour(){
        User user = new User();
        final int MINIMUM = 4;
        user.setAllergy("Camarão");
        boolean result = true;
        if(user.getAllergy().trim().length() < MINIMUM){
            assertFalse(result);
        }else{
            assertTrue(result);
        }
    }


}
