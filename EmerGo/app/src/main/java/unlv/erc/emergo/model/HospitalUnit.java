package unlv.erc.emergo.model;

/**
 * Created by mrvictor on 16/04/16.
 */
public class HospitalUnit {

    private Float latitude;
    private Float longitude;
    private String endereco;
    private Double telefone;

    public HospitalUnit(Float latitude, Float longitude, String endereco, Double telefone) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Float getLatitude() {
        return latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public String getEndereco() {
        return endereco;
    }

    public Double getTelefone() {
        return telefone;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(Double telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Hospitais{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", endereco='" + endereco + '\'' +
                ", telefone=" + telefone +
                '}';
    }

}
