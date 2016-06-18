package unlv.erc.emergo.model;

import org.junit.Before;
import org.junit.Test;

import unlv.erc.emergo.model.HealthUnit;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;


public class HealthUnitTest {

    HealthUnit healthUnit;

    @Before
    public void setUp() {
        healthUnit = new HealthUnit();
    }

    @Test
    public void testConstruction() {

        assertNotNull(healthUnit);
    }

    @Test
    public void testConstructionWithParameters() {

        String stringTest = "asd";
        healthUnit = new HealthUnit(0.0, 0.0, stringTest, stringTest, stringTest, stringTest, stringTest, stringTest);

        assertNotNull(healthUnit);

    }

    @Test
    public void testConstructionWithParametersAndId() {

        String stringTest = "asd";
        healthUnit = new HealthUnit(20, 0.0, 0.0, stringTest, stringTest, stringTest, stringTest, stringTest, stringTest);

        assertNotNull(healthUnit);

    }

    @Test
    public void testGettersAndSetters() {

        String stringTest = "asd";
        healthUnit = new HealthUnit(0, 0.0, 0.0, stringTest, stringTest, stringTest, stringTest, stringTest, stringTest);

        assertEquals(healthUnit.getId(), (Integer) 0);
        assertEquals(healthUnit.getLatitude(), (Double) 0.0);
        assertEquals(healthUnit.getLongitude(), (Double) 0.0);
        assertEquals(healthUnit.getAddressNumber(), stringTest);
        assertEquals(healthUnit.getCity(), stringTest);
        assertEquals(healthUnit.getDistrict(), stringTest);
        assertEquals(healthUnit.getNameHospital(), stringTest);
        assertEquals(healthUnit.getState(), stringTest);
        assertEquals(healthUnit.getUnitType(), stringTest);

    }

    @Test
    public void testDistance(){

        float distance = (float)20;

        healthUnit.setDistance(distance);

        assertEquals(healthUnit.getDistance(), (Float) distance);

    }



}