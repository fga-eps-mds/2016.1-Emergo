package unlv.erc.emergo.model;

/**
 * Created by mrvictor on 16/04/16.
 */
public class HospitalUnit {
    private String nome;
    private Double latitude;
    private Double longitude;
    private Integer id;
    private String uf;
    private Float distance;


    public HospitalUnit(String nome, Double latitude, Double longitude, Integer id, String uf) {
        setNome(nome);
        setLatitude(latitude);
        setLongitude(longitude);
        setId(id);
        setUf(uf);
    }


    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }
}
