package unlv.erc.emergo.model;


import com.google.android.gms.maps.model.Marker;

public class HealthUnit {

    private int id = 0;
    private String nameHospital = "";
    private String unitType = "";
    private String address = "";
    private String addressNumber = "";
    private String district = "";
    private String postalCode = "";
    private String region = "";
    private String state = "";
    private String city = "";
    private double latitude = 0;
    private double longitude = 0;
    private String managementType = "";
    private Marker marker;


    public HealthUnit (String nameHospital, String address, String addressNumber, String district,
                       String state, String city,double latitude, double longitude){
        this.nameHospital = nameHospital;
        this.address = address;
        this.addressNumber = addressNumber;
        this.district = district;
        this.state = state;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameHospital() {
        return this.nameHospital;
    }

    public void setNameHospital(String nameHospital){
        this.nameHospital = nameHospital;
    }

    public String getUnitType() {
        return this.unitType;
    }

    public void setUnitType(String unitType){
        this.unitType = unitType;
    }

    public String getAddress () {
        return this.address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddressNumber(){
        return this.addressNumber;
    }

    public void setAddressNumber(String addressNumber){
        this.addressNumber = addressNumber;
    }

    public String getDistrict(){
        return this.district;
    }

    public void setDistrict(String district){
        this.district = district;
    }

    public String getPostalColde(){
        return postalCode;
    }

    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }

    public String getRegion(){
        return region;
    }

    public void setRegio(String region){
        this.region = region;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public double getLatitute(){
        return latitude;
    }

    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    public double getLongitude(){
        return longitude;
    }

    public void setLongitude(double longitude){
        this.longitude = longitude;
    }

    public String getManagementType(){
        return managementType;
    }

    public void setManagementType(String managementType){
        this.managementType = managementType;
    }

    public boolean getMarkerStatus(){
       return  this.marker.isVisible();
    }

}
