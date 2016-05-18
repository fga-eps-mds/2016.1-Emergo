package unlv.erc.emergo.model;


public class HealthUnit {

    private Double latitude;
    private Double longitude;
    private String nameHospital;
    private String unitType;
    private String addressNumber;
    private String district;
    private String state;
    private String city;
    private Float distance;
    private Integer id;

    public HealthUnit(){

    }

    public HealthUnit(Double latitude, Double longitude, String nameHospital, String unitType,
                      String addressNumber, String district, String state, String city) {
        this.latitude = latitude;
        this.longitude = longitude;

        this.nameHospital = nameHospital;
        this.unitType = unitType;
        this.addressNumber = addressNumber;
        this.district = district;
        this.state = state;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getNameHospital() {
        return nameHospital;
    }

    public void setNameHospital(String nameHospital) {
        this.nameHospital = nameHospital;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

