package unlv.erc.emergo.model;

import junit.framework.TestCase;


public class HealthUnitTest extends TestCase {

    private HealthUnit healthUnit = new HealthUnit();

    // test for name Health Unit
    public void testSetNameHealthUnit() {
        healthUnit.setNameHospital("Hospital Regional do Gama");
        assertEquals("Hospital Regional do Gama", healthUnit.getNameHospital());
    }

    public void testGetNameHealthUnit() {
        String name = "Hospital Regional da Asa Norte";
        healthUnit.setNameHospital("Hospital Regional da Asa Norte");
        assertEquals(name, healthUnit.getNameHospital());
    }

    // tests for Unit Type

    public void testSetUnitTypeHealthUnit() {
        healthUnit.setUnitType("Posto de Saude");
        assertEquals("Posto de Saude", healthUnit.getUnitType());
    }

    public void testGetUnitTypeHealthUnit() {
        String unitType = "Posto de Saude";
        healthUnit.setUnitType("Posto de Saude");
        assertEquals(unitType, healthUnit.getUnitType());
    }

    // test for Address Number

    public void testSetAddressNumberHealthUnit() {
        healthUnit.setAddressNumber("9999");
        assertEquals("9999", healthUnit.getAddressNumber());
    }

    public void testGetAddressNumberHealthUnit() {
        String addressNumber = "9999";
        healthUnit.setAddressNumber("9999");
        assertEquals(addressNumber, healthUnit.getAddressNumber());
    }

    // tests for District

    public void testSetDistrictHealthUnit() {
        healthUnit.setDistrict("Asa Sul");
        assertEquals("Asa Sul", healthUnit.getDistrict());
    }

    public void testGetDistrictHealthUnit() {
        String district = "Asa Sul";
        healthUnit.setDistrict("Asa Sul");
        assertEquals(district, healthUnit.getDistrict());
    }

    // tests for State

    public void testSetStateHealthUnit() {
        healthUnit.setState("DF");
        assertEquals("DF", healthUnit.getState());
    }

    public void testGetStateHealthUnit() {
        String state = "DF";
        healthUnit.setState("DF");
        assertEquals(state, healthUnit.getState());
    }

    // tests for city

    public void testSetCityHealthUnit() {
        healthUnit.setCity("Brasília");
        assertEquals("Brasília", healthUnit.getCity());
    }

    public void testGetCityHealthUnit() {
        String city = "Brasília";
        healthUnit.setCity("Brasília");
        assertEquals(city, healthUnit.getCity());
    }

    // tests for Latitude

    public void testSetLatitudeHealthUnit() {
        healthUnit.setLatitude(45.678964);
        assertEquals(45.678964, healthUnit.getLatitude());
    }

    public void testGetLatitudeHealthUnit() {
        Double latitude = 45.678964;
        healthUnit.setLatitude(45.678964);
        assertEquals(latitude, healthUnit.getLatitude());
    }

    // tests for Longitude

    public void testSetLongitudeHealthUnit() {
        healthUnit.setLongitude(-56.195678);
        assertEquals(-56.195678, healthUnit.getLongitude());
    }

    public void testGetLongitudeHealthUnit() {
        Double longitude = -56.195678;
        healthUnit.setLongitude(-56.195678);
        assertEquals(longitude, healthUnit.getLongitude());
    }

    // tests for Distance

    public void testSetDistanceHealthUnit() {
        healthUnit.setLongitude(25.34);
        assertEquals(25.34, healthUnit.getLongitude());
    }

    public void testGetDistanceHealthUnit() {
        float distance = 1815;
        healthUnit.setDistance(distance);
        assertEquals(distance, healthUnit.getDistance());
    }

    // tests

    public void testGetInformationsWithoutIDHealthUnit() {
        healthUnit = new HealthUnit(15.4567, -16.999, "Hospital Regional do Gama",
                "Posto de Saude", "9999", "Asa Norte", "DF", "Brasília");
        assertEquals(15.4567, healthUnit.getLatitude());
        assertEquals(-16.999, healthUnit.getLongitude());
        assertEquals("Hospital Regional do Gama", healthUnit.getNameHospital());
        assertEquals("Posto de Saude", healthUnit.getUnitType());
        assertEquals("9999", healthUnit.getAddressNumber());
        assertEquals("Asa Norte", healthUnit.getDistrict());
        assertEquals("DF", healthUnit.getState());
        assertEquals("Brasília", healthUnit.getCity());
    }

    public void testGetInformationsWithIDHealthUnit(){
        healthUnit = new HealthUnit(15.4567,-16.999,"Hospital Regional do Gama",
                "Posto de Saude", "9999", "Asa Norte", "DF", "Brasília");
        healthUnit.setId((long) 1);
        assertEquals(15.4567, healthUnit.getLatitude());
        assertEquals(-16.999, healthUnit.getLongitude());
        assertEquals("Hospital Regional do Gama", healthUnit.getNameHospital());
        assertEquals("Posto de Saude", healthUnit.getUnitType());
        assertEquals("9999", healthUnit.getAddressNumber());
        assertEquals("Asa Norte", healthUnit.getDistrict());
        assertEquals("DF", healthUnit.getState());
        assertEquals("Brasília", healthUnit.getCity());
    }

    public void testSetInformationsWithoutIDHealthUnit(){
        healthUnit = new HealthUnit(166.66,190.00,"","","", "", "", "");
        healthUnit.setLatitude(17.8906);
        healthUnit.setLongitude(-18.7878);
        healthUnit.setNameHospital("Hospital da Lulu");
        healthUnit.setUnitType("Hospital Isolado");
        healthUnit.setAddressNumber("6969");
        healthUnit.setDistrict("Asa Sul");
        healthUnit.setState("DF");
        healthUnit.setCity("Brasólia");

        assertEquals(17.8906, healthUnit.getLatitude());
        assertEquals(-18.7878, healthUnit.getLongitude());
        assertEquals("Hospital da Lulu", healthUnit.getNameHospital());
        assertEquals("6969", healthUnit.getAddressNumber());
        assertEquals("Asa Sul", healthUnit.getDistrict());
        assertEquals("DF", healthUnit.getState());
        assertEquals("Brasólia", healthUnit.getCity());
    }
}