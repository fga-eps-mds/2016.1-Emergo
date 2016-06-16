/**
 * EmergencyContatct.java
 */

package unlv.erc.emergo.model;

public class EmergencyContact {

    private String name;
    private String phone;

    public EmergencyContact(String name, String phone) {
        setName(name);
        setPhone(phone);
    }

    public EmergencyContact(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}