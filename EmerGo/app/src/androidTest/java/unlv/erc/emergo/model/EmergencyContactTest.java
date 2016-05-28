package unlv.erc.emergo.model;

import android.test.InstrumentationTestCase;

/**
 * Created by Matheus on 27/05/2016.
 */
public class EmergencyContactTest extends InstrumentationTestCase {

    private EmergencyContact contact;

    public void testGetNameContact(){
        contact = new EmergencyContact();
        String name = "Astolfo";
        contact.setName("Astolfo");

        assertEquals(name,contact.getName());

    }

    public void testSetNameContact(){
        contact = new EmergencyContact();
        contact.setName("Jovaildo");

        assertEquals("Jovaildo",contact.getName());

    }
}
