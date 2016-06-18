package unlv.erc.emergo;

import android.test.InstrumentationTestCase;

import org.junit.Before;
import org.junit.Test;

import unlv.erc.emergo.model.EmergencyContact;

import static org.junit.Assert.assertEquals;

/**
 * Created by Matheus on 27/05/2016.
 */
public class EmergencyContactTest {


    private EmergencyContact contact;

    @Before
    public void setUp() {
        contact = new EmergencyContact();
    }

    @Test
    public void testGetNameContact(){
        String name = "Astolfo";
        contact.setName("Astolfo");

        assertEquals(name,contact.getName());

    }


    @Test
    public void testSetNameContact(){
        contact.setName("Jovaildo");

        assertEquals("Jovaildo",contact.getName());

    }
}
