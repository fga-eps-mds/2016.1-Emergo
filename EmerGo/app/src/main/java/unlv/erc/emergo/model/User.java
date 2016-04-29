import java.util.ArrayList;
import java.util.Date;

package unlv.erc.emergo.model;

package unlv.erc.emergo.model;

import java.util.ArrayList;
import java.util.Date;

public class User {
    private String name;
    private Date dateBirth;
    private String tpBlood;
    private ArrayList<String> alergias[];
    private boolean hipertenso;
    private boolean diabetico;
    private boolean cardiaco;
    private boolean soro_positivo;

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getTpBlood() {
        return tpBlood;
    }

    public void setTpBlood(String tpBlood) {
        this.tpBlood = tpBlood;
    }

    public ArrayList<String>[] getAlergias() {
        return alergias;
    }

    public void setAlergias(ArrayList<String>[] alergias) {
        this.alergias = alergias;
    }

    public boolean isHipertenso() {
        return hipertenso;
    }

    public void setHipertenso(boolean hipertenso) {
        this.hipertenso = hipertenso;
    }

    public boolean isDiabetico() {
        return diabetico;
    }

    public void setDiabetico(boolean diabetico) {
        this.diabetico = diabetico;
    }

    public boolean isCardiaco() {
        return cardiaco;
    }

    public void setCardiaco(boolean cardiaco) {
        this.cardiaco = cardiaco;
    }

    public boolean isSoro_positivo() {
        return soro_positivo;
    }

    public void setSoro_positivo(boolean soro_positivo) {
        this.soro_positivo = soro_positivo;
    }

}
