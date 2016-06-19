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
        healthUnit = new HealthUnit(0.0, 0.0, stringTest, stringTest, stringTest, stringTest, stringTest, stringTest);
        healthUnit.setId((long) 20);

        assertNotNull(healthUnit);

    }

    @Test
    public void testGettersAndSetters() {

        String stringTest = "asd";
        healthUnit = new HealthUnit(0.0, 0.0, stringTest, stringTest, stringTest, stringTest, stringTest, stringTest);

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

    // test for name Health Unit
    @Test
    public void testSetNameHealthUnit(){
        healthUnit.setNameHospital("Hospital Regional do Gama");
        assertEquals("Hospital Regional do Gama", healthUnit.getNameHospital());
    }

    @Test
    public void testGetNameHealthUnit(){
        String name = "Hospital Regional da Asa Norte";
        healthUnit.setNameHospital("Hospital Regional da Asa Norte");
        assertEquals(name, healthUnit.getNameHospital());
    }

    // tests for Unit Type
    @Test
    public void testSetUnitTypeHealthUnit(){
        healthUnit.setUnitType("Posto de Saude");
        assertEquals("Posto de Saude", healthUnit.getUnitType());
    }

    @Test
    public void testGetUnitTypeHealthUnit(){
        String unitType = "Posto de Saude";
        healthUnit.setUnitType("Posto de Saude");
        assertEquals(unitType, healthUnit.getUnitType());
    }

    // test for Address Number

    @Test
    public void testSetAddressNumberHealthUnit(){
        healthUnit.setAddressNumber("9999");
        assertEquals("9999", healthUnit.getAddressNumber());
    }

    @Test
    public void testGetAddressNumberHealthUnit(){
        String addressNumber = "9999";
        healthUnit.setAddressNumber("9999");
        assertEquals(addressNumber, healthUnit.getAddressNumber());
    }

    // tests for District

    @Test
    public void testSetDistrictHealthUnit(){
        healthUnit.setDistrict("Asa Sul");
        assertEquals("Asa Sul", healthUnit.getDistrict());
    }

    @Test
    public void testGetDistrictHealthUnit(){
        String district = "Asa Sul";
        healthUnit.setDistrict("Asa Sul");
        assertEquals(district, healthUnit.getDistrict());
    }

    // tests for State

    @Test
    public void testSetStateHealthUnit(){
        healthUnit.setState("DF");
        assertEquals("DF", healthUnit.getState());
    }

    @Test
    public void testGetStateHealthUnit(){
        String state = "DF";
        healthUnit.setState("DF");
        assertEquals(state, healthUnit.getState());
    }

    // tests for city

    @Test
    public void testSetCityHealthUnit(){
        healthUnit.setCity("Brasília");
        assertEquals("Brasília", healthUnit.getCity());
    }

    @Test
    public void testGetCityHealthUnit(){
        String city = "Brasília";
        healthUnit.setCity("Brasília");
        assertEquals(city, healthUnit.getCity());
    }

    // tests for Latitude

    @Test
    public void testSetLatitudeHealthUnit(){
        Double latitude = 45.678964;
        healthUnit.setLatitude(latitude);
        assertEquals(latitude, healthUnit.getLatitude());
    }

    @Test
    public void testGetLatitudeHealthUnit(){
        Double latitude = 45.678964;
        healthUnit.setLatitude(45.678964);
        assertEquals(latitude, healthUnit.getLatitude());
    }

    // tests for Longitude

    @Test
    public void testSetLongitudeHealthUnit(){
        Double longitude = -56.195678;
        healthUnit.setLongitude(longitude);
        assertEquals(longitude, healthUnit.getLongitude());
    }

    @Test
    public void testGetLongitudeHealthUnit(){
        Double longitude = -56.195678;
        healthUnit.setLongitude(-56.195678);
        assertEquals(longitude, healthUnit.getLongitude());
    }

    // tests for Distance

    @Test
    public void testSetDistanceHealthUnit(){
        healthUnit.setLongitude(25.34);
        assertEquals((Double) 25.34, healthUnit.getLongitude());
    }

    @Test
    public void testGetDistanceHealthUnit(){
        Float distance = Float.valueOf(1815);
        healthUnit.setDistance(distance);
        assertEquals(distance, healthUnit.getDistance());
    }

    // tests

    @Test
    public void testGetInformationsWithoutIDHealthUnit(){
        Double longitude = -16.999;
        Double latitude = 15.4567;
        healthUnit = new HealthUnit(latitude, longitude,"Hospital Regional do Gama",
                "Posto de Saude", "9999", "Asa Norte", "DF", "Brasília");
        assertEquals((Double) latitude, healthUnit.getLatitude());
        assertEquals( healthUnit.getLongitude(), longitude );
        assertEquals("Hospital Regional do Gama", healthUnit.getNameHospital());
        assertEquals("Posto de Saude", healthUnit.getUnitType());
        assertEquals("9999", healthUnit.getAddressNumber());
        assertEquals("Asa Norte", healthUnit.getDistrict());
        assertEquals("DF", healthUnit.getState());
        assertEquals("Brasília", healthUnit.getCity());
    }

    @Test
    public void testGetInformationsWithIDHealthUnit(){
        Double longitude = -16.999;
        Double latitude = 15.4567;
        healthUnit = new HealthUnit(latitude, longitude,"Hospital Regional do Gama",
                "Posto de Saude", "9999", "Asa Norte", "DF", "Brasília");
        healthUnit.setId((long) 1);
        assertEquals(latitude, healthUnit.getLatitude());
        assertEquals(longitude, healthUnit.getLongitude());
        assertEquals("Hospital Regional do Gama", healthUnit.getNameHospital());
        assertEquals("Posto de Saude", healthUnit.getUnitType());
        assertEquals("9999", healthUnit.getAddressNumber());
        assertEquals("Asa Norte", healthUnit.getDistrict());
        assertEquals("DF", healthUnit.getState());
        assertEquals("Brasília", healthUnit.getCity());
    }

    @Test
    public void testSetInformationsWithoutIDHealthUnit(){
        healthUnit = new HealthUnit(166.66,190.00,"","","", "", "", "");
        healthUnit.setLatitude(17.8906);
        Double longitude = -18.7878;
        healthUnit.setLongitude(longitude);
        healthUnit.setNameHospital("Hospital da Lulu");
        healthUnit.setUnitType("Hospital Isolado");
        healthUnit.setAddressNumber("6969");
        healthUnit.setDistrict("Asa Sul");
        healthUnit.setState("DF");
        healthUnit.setCity("Brasólia");

        Double latitude = (Double) 17.8906;
        assertEquals(latitude, healthUnit.getLatitude());
        assertEquals(longitude, healthUnit.getLongitude());
        assertEquals("Hospital da Lulu", healthUnit.getNameHospital());
        assertEquals("6969", healthUnit.getAddressNumber());
        assertEquals("Asa Sul", healthUnit.getDistrict());
        assertEquals("DF", healthUnit.getState());
        assertEquals("Brasólia", healthUnit.getCity());
    }

}