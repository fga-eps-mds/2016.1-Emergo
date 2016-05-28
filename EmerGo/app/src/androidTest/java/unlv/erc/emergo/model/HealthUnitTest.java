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

    public void testSetUnitTypeEmpty(){
        HealthUnit healthUnit = new HealthUnit();
        healthUnit.setUnitType("");
        assertEquals("",healthUnit.getUnitType());
    }

    public void testSetUnitTypeNull(){
        HealthUnit healthUnit = new HealthUnit();
        healthUnit.setUnitType("Unidade Básica");
        boolean result = true;
        if(healthUnit.getUnitType().trim() == null){
            assertFalse(result);
        }else{
            assertTrue(result);
        }
    }

    public void testGetAddressNumber(){
        HealthUnit healthUnit = new HealthUnit();
        String adressNumber = "05";
        healthUnit.setAddressNumber("05");
        assertEquals(adressNumber,healthUnit.getAddressNumber());
    }

    public void testSetAddressNumberEmpty(){
        HealthUnit healthUnit = new HealthUnit();
        healthUnit.setAddressNumber("");
        assertEquals("",healthUnit.getAddressNumber());
    }

    public void testSetAddressNumberNull(){
        HealthUnit healthUnit = new HealthUnit();
        healthUnit.setAddressNumber("05");
        boolean result = true;
        if(healthUnit.getAddressNumber().trim() == null){
            assertFalse(result);
        }else{
            assertTrue(result);
        }
    }

    public void testGetDistrict(){
        HealthUnit healthUnit = new HealthUnit();
        String district = "Distrito Federal";
        healthUnit.setDistrict("Distrito Federal");
        assertEquals(district,healthUnit.getDistrict());
    }

}
