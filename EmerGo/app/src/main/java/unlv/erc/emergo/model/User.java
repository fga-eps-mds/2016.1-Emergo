package unlv.erc.emergo.model;

public class User{

    private String name;
    private String birthday;
    private String typeBlood;
    private String cardiac;
    private String diabetic;
    private String hypertension;
    private String seropositive;
    private String observations;
    private Integer ID;

    public User(){

    }

    public User(String name,String birthday,String typeBlood,String cardiac,String diabetic,
                String hypertension,String seropositive,String observations,Integer id){
        setName(name);
        setBirthday(birthday);
        setTypeBlood(typeBlood);
        setCardiac(cardiac);
        setDiabetic(diabetic);
        setHypertension(hypertension);
        setSeropositive(seropositive);
        setObservations(observations);
        setID(id);
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTypeBlood() {
        return typeBlood;
    }

    public void setTypeBlood(String typeBlood) {
        this.typeBlood = typeBlood;
    }

    public String getCardiac() {
        return cardiac;
    }

    public void setCardiac(String cardiac) {
        this.cardiac = cardiac;
    }

    public String getDiabetic() {
        return diabetic;
    }

    public void setDiabetic(String diabetic) {
        this.diabetic = diabetic;
    }

    public String getHypertension() {
        return hypertension;
    }

    public void setHypertension(String hypertension) {
        this.hypertension = hypertension;
    }

    public String getSeropositive() {
        return seropositive;
    }

    public void setSeropositive(String seropositive) {
        this.seropositive = seropositive;
    }
}
