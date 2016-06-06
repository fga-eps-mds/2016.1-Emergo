package unlv.erc.emergo.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import unlv.erc.emergo.R;


public class EmergencyContactController extends Activity {
    private Button saveFirstContact;
    private Button saveSecondContact;
    private Button saveThirdContact;
    private EditText nameFirstContact;
    private EditText nameSecondContact;
    private EditText nameThirdContact;
    private Button deleteFirstContact;
    private Button deleteSecondContact;
    private Button deleteThirdContact;
    private Button addAnotherContact;
    private Button addAnotherContactLast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emergency_contact);

        saveFirstContact = (Button) findViewById(R.id.saveButtonFirstContact);
        saveSecondContact = (Button) findViewById(R.id.saveButtonSecondContact);
        saveThirdContact = (Button) findViewById(R.id.saveButtonLastContact);
        nameFirstContact = (EditText) findViewById(R.id.nameContactEditText);
        nameSecondContact = (EditText) findViewById(R.id.nameSecondContactEditText);
        nameThirdContact = (EditText) findViewById(R.id.nameLastContactEditText);
        deleteFirstContact = (Button) findViewById(R.id.deleteButtonFirstContact);
        deleteSecondContact = (Button) findViewById(R.id.deleteButtonSecondContact);
        deleteThirdContact = (Button) findViewById(R.id.deleteButtonLastContact);
        addAnotherContact = (Button) findViewById(R.id.addNewContact);
        addAnotherContactLast = (Button) findViewById(R.id.addSecondContact);

        saveFirstContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                visibleOptionsFirstContact();
            }
        });
    }

    public void firstContact(){
        invisibleOptions();
    }

    public void invisibleOptions(){
        saveFirstContact.setVisibility(View.VISIBLE);
        deleteFirstContact.setVisibility(View.INVISIBLE);
        addAnotherContact.setVisibility(View.INVISIBLE);
    }


    public void visibleOptionsFirstContact(){
        saveFirstContact.setVisibility(View.VISIBLE);
        deleteFirstContact.setVisibility(View.VISIBLE);
        addAnotherContact.setVisibility(View.VISIBLE);
    }
}
