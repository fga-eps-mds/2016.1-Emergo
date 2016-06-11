package unlv.erc.emergo.model;

import junit.framework.TestCase;

public class EmergencyContactTest extends TestCase {

    private EmergencyContact emergencyContact;

    private final int MINIMUM_LENGTH_NAME = 3;
    private final int MAXIMUM_LENGHT_NAME = 42;
    private final int MAXIMUM_LENGHT_PHONE = 11;

    public void testSetNameEmergencyContact(){
        emergencyContact = new EmergencyContact();
        emergencyContact.setName("Joaquina Josefina");
        assertEquals("Joaquina Josefina", emergencyContact.getName());

    }

    public void testGetNameEmergencyContact(){
        emergencyContact = new EmergencyContact();
        String name = "Pedro Henrique";
        emergencyContact.setName("Pedro Henrique");
        assertEquals(name, emergencyContact.getName());

    }

    public void testSetNameEmergencyContactEmpty(){
        emergencyContact = new EmergencyContact();
        emergencyContact.setName("");
        assertEquals("", emergencyContact.getName());
    }

    public void testSetNameEmergencyContactLowerThree(){
        emergencyContact = new EmergencyContact();
        emergencyContact.setName("Ana");
        boolean result = true;
        if(emergencyContact.getName().trim().length()<MINIMUM_LENGTH_NAME){
            assertFalse(result);
        }else{
            assertTrue(result);
        }
    }

    public void testSetNameMaximumSize(){
        emergencyContact = new EmergencyContact();
        emergencyContact.setName("Maraia Maraisa Mendonça");
        boolean result = true;
        if(emergencyContact.getName().trim().length()>MAXIMUM_LENGHT_NAME){
            assertFalse(result);
        }else{
            assertTrue(result);
        }
    }

    public void testSetPhoneEmergencyContact(){
        emergencyContact = new EmergencyContact();
        emergencyContact.setPhone("84009765");
        assertEquals("84009765", emergencyContact.getPhone());

    }

    public void testGetPhoneEmergencyContact(){
        emergencyContact = new EmergencyContact();
        String phone = "61985980034";
        emergencyContact.setPhone("61985980034");
        assertEquals(phone, emergencyContact.getPhone());

    }

    public void testSetPhoneEmergencyContactEmpty(){
        emergencyContact = new EmergencyContact();
        emergencyContact.setPhone("");
        assertEquals("", emergencyContact.getPhone());
    }

    public void testSetPhoneMaximumSize(){
        emergencyContact = new EmergencyContact();
        emergencyContact.setPhone("61985993870");
        boolean result = true;
        if(emergencyContact.getPhone().trim().length()>MAXIMUM_LENGHT_PHONE){
            result = false;
            assertTrue(result);
        }else{
            assertTrue(result);
        }
    }

    public void testGetNameAndPhoneEmergencyContact(){
        emergencyContact = new EmergencyContact( "Justin Timberlake", "61985980034");
        assertEquals("Justin Timberlake", emergencyContact.getName());
        assertEquals("61985980034", emergencyContact.getPhone());

    }

    public void testSetNameAndPhoneEmergencyContact(){
        emergencyContact = new EmergencyContact("","");
        emergencyContact.setName("Joana");
        emergencyContact.setPhone("6185993870");
        assertEquals("Joana", emergencyContact.getName());
        assertEquals("6185993870", emergencyContact.getPhone());
    }

    public void testSetJustNameEmergencyContact(){
        emergencyContact = new EmergencyContact("","");
        emergencyContact.setName("Mariana");
        emergencyContact.setPhone("");
        assertEquals("Mariana", emergencyContact.getName());
        assertEquals("", emergencyContact.getPhone());
    }

    public void testGetJustNameEmergencyContact(){
        emergencyContact = new EmergencyContact( "Justin Timberlake", "");
        assertEquals("Justin Timberlake", emergencyContact.getName());
        assertEquals("", emergencyContact.getPhone());
    }

    public void testSetNameEmergencyContactLessThan42(){
        emergencyContact = new EmergencyContact("","");
        emergencyContact.setName("Mariana Andrade Queiroz");
        emergencyContact.setPhone("");
        boolean result = true;
        if(emergencyContact.getName().trim().length()>MAXIMUM_LENGHT_NAME){
            result = false;
            assertTrue(result);
        }else{
            assertTrue(result);
        }
    }

    public void testSetNameEmergencyContactMoreThan3(){
        emergencyContact = new EmergencyContact("","");
        emergencyContact.setName("Ana");
        emergencyContact.setPhone("");
        boolean result = true;
        if(emergencyContact.getName().trim().length()<MINIMUM_LENGTH_NAME){
            result = false;
            assertTrue(result);
        }else{
            assertTrue(result);
        }
    }
}
