package unlv.erc.emergo.model;


import com.orm.SugarRecord;

public class HealthUnit extends SugarRecord {

    private Double latitude;
    private Double longitude;
    String no_fantasia;
    private String unitType;
    private String addressNumber;
    private String no_bairro;
    private String state;
    String municipio;
    private Float distance;
    //  private Integer id;

    public HealthUnit(){

    }

    public HealthUnit (String no_fantasia, String no_bairro, String municipio){
        this.no_fantasia = no_fantasia;
        this.no_bairro = no_bairro;
        this.municipio = municipio;
    }

    public HealthUnit(Double latitude, Double longitude, String no_fantasia, String unitType,
                      String addressNumber, String no_bairro, String state, String municipio) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.no_fantasia = no_fantasia;
        this.unitType = unitType;
        this.addressNumber = addressNumber;
        this.no_bairro = no_bairro;
        this.state = state;
        this.municipio = municipio;
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

    public String getNo_fantasia() {
        return no_fantasia;
    }

    public void setNo_fantasia(String no_fantasia) {
        this.no_fantasia = no_fantasia;
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

    public String getNo_bairro() {
        return no_bairro;
    }

    public void setNo_bairro(String no_bairro) {
        this.no_bairro = no_bairro;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

  /*  public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/

}

