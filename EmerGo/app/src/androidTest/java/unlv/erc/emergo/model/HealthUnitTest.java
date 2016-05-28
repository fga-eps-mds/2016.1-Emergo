package unlv.erc.emergo.model;


import junit.framework.TestCase;

public class HealthUnitTest extends TestCase{

    public void testGetNameHealthUnit(){
        HealthUnit healthUnit = new HealthUnit();
        String nameHospital = "Hospital Regional do Gama";
        healthUnit.setUnitType("Hospital Regional do Gama");
        assertEquals(nameHospital,healthUnit.getUnitType());
    }

    public void testSetHealthUnitEmpty(){
        HealthUnit healthUnit = new HealthUnit();
        healthUnit.setNameHospital("");
        assertEquals("", healthUnit.getNameHospital());
    }

    public void testSetHealthUnitNull(){
        HealthUnit healthUnit = new HealthUnit();
        healthUnit.setNameHospital("Hospital Regional do Gama");
        boolean result = true;
        if(healthUnit.getNameHospital().trim() == null){
            assertFalse(result);
        }else{
            assertTrue(result);
        }
    }

    public void testGetUnitType(){
        HealthUnit healthUnit = new HealthUnit();
        String unitType = "Unidade Básica de saúde";
        healthUnit.setUnitType("Unidade Básica de saúde");
        assertEquals(unitType,healthUnit.getUnitType());
    }


}
