/**
 * EmergencyContatct.java
 */

package unlv.erc.emergo.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Arrays;


public class EmergencyContact {

    private String name;
    private String phone[];

    public EmergencyContact(String name, String phone) {
        setName(name);
        setPhone(phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone[phone.length()] = phone;
    }


}
