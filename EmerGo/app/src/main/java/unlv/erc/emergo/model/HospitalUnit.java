package unlv.erc.emergo.model;

/**
 * Created by mrvictor on 16/04/16.
 */
public class HospitalUnit {

    private Integer id;
    private String no_fantasia;
    private String ds_tipo_unidade;
    private String no_logradouro;
    private Integer nu_endereco;
    private String no_bairro;
    private Integer co_cep;
    private String regiao;
    private String uf;
    private String municipio;
    private Integer latitude;
    private Integer longitude;
    private Character tipo_gestao;

    public HospitalUnit(Integer id, String no_fantasia, String ds_tipo_unidade, String no_logradouro,
              Integer nu_endereco, String no_bairro, Integer co_cep, String regiao, String uf,
              String municipio, Integer latitude, Integer longitude, Character tipo_gestao) {
        this.id = id;
        this.no_fantasia = no_fantasia;
        this.ds_tipo_unidade = ds_tipo_unidade;
        this.no_logradouro = no_logradouro;
        this.nu_endereco = nu_endereco;
        this.no_bairro = no_bairro;
        this.co_cep = co_cep;
        this.regiao = regiao;
        this.uf = uf;
        this.municipio = municipio;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tipo_gestao = tipo_gestao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo_fantasia() {
        return no_fantasia;
    }

    public void setNo_fantasia(String no_fantasia) {
        this.no_fantasia = no_fantasia;
    }

    public String getDs_tipo_unidade() {
        return ds_tipo_unidade;
    }

    public void setDs_tipo_unidade(String ds_tipo_unidade) {
        this.ds_tipo_unidade = ds_tipo_unidade;
    }

    public String getNo_logradouro() {
        return no_logradouro;
    }

    public void setNo_logradouro(String no_logradouro) {
        this.no_logradouro = no_logradouro;
    }

    public Integer getNu_endereco() {
        return nu_endereco;
    }

    public void setNu_endereco(Integer nu_endereco) {
        this.nu_endereco = nu_endereco;
    }

    public String getNo_bairro() {
        return no_bairro;
    }

    public void setNo_bairro(String no_bairro) {
        this.no_bairro = no_bairro;
    }

    public Integer getCo_cep() {
        return co_cep;
    }

    public void setCo_cep(Integer co_cep) {
        this.co_cep = co_cep;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Character getTipo_gestao() {
        return tipo_gestao;
    }

    public void setTipo_gestao(Character tipo_gestao) {
        this.tipo_gestao = tipo_gestao;
    }

}
