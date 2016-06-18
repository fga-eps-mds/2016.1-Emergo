package unlv.erc.emergo;

import org.junit.Before;
import org.junit.Test;

import unlv.erc.emergo.model.HealthUnit;

import static junit.framework.Assert.assertNotNull;


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



}