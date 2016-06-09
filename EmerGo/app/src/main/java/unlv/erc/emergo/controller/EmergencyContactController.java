package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dao.EmergencyContactDao;
import helper.MaskHelper;
import unlv.erc.emergo.R;


public class EmergencyContactController extends Activity {
    private Button saveFirstContact;
    private Button saveSecondContact;
    private Button saveThirdContact;
    private EditText nameFirstContact;
    private EditText nameSecondContact;
    private EditText nameThirdContact;
    private EditText phoneFirstContact;
    private EditText phoneSecondContact;
    private EditText phoneThirdContact;
    private Button deleteFirstContact;
    private Button deleteSecondContact;
    private Button deleteThirdContact;
    private Button updateFirstContact;
    private Button addAnotherContactLast;
    private String phoneContact;
    private String nameContact;
    private Integer idFirstContact = 1;
    private Integer idSecondContact = 2;
    private Integer idThirdContact = 3;

    EmergencyContactDao emergencyContactDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emergency_contact);

        emergencyContactDao = new EmergencyContactDao(this);

        saveFirstContact = (Button) findViewById(R.id.saveButtonFirstContact);
        saveSecondContact = (Button) findViewById(R.id.saveSecondContactButton);
        saveThirdContact = (Button) findViewById(R.id.saveThirdContactButton);
        updateFirstContact = (Button) findViewById(R.id.updateButtonFirstContact);
        nameFirstContact = (EditText) findViewById(R.id.nameFirstContactEditText);
        nameSecondContact = (EditText) findViewById(R.id.nameSecondContactEditText);
        nameThirdContact = (EditText) findViewById(R.id.nameThirdContactEditText);
        phoneFirstContact = (EditText) findViewById(R.id.phoneEditText);
        phoneFirstContact.addTextChangedListener(MaskHelper.insert("(##)#####-####", phoneFirstContact));
        phoneSecondContact = (EditText) findViewById(R.id.phoneSecondContactEditText);
        phoneSecondContact.addTextChangedListener(MaskHelper.insert("(##)#####-####", phoneSecondContact));
        phoneThirdContact = (EditText) findViewById(R.id.phoneThirdContactEditText);
        phoneThirdContact.addTextChangedListener(MaskHelper.insert("(##)#####-####", phoneThirdContact));
        deleteFirstContact = (Button) findViewById(R.id.deleteFirstContactButton);
        deleteSecondContact = (Button) findViewById(R.id.deleteSecondContactButton);
        deleteThirdContact = (Button) findViewById(R.id.deleteThirdContactButton);

        Cursor result = emergencyContactDao.getEmergencyContact();
        if(result.getCount() == 0) {
            showMessage("NÃO TEM NADA");
            updateFirstContact.setEnabled(false);
            deleteFirstContact.setEnabled(false);
        }else{
            result.moveToFirst();
            saveFirstContact.setEnabled(false);
            nameFirstContact.setText(result.getString(1));
            nameFirstContact.setEnabled(false);
        }
        saveFirstContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                firstContact();
                saveFirstContact.setEnabled(false);
                updateFirstContact.setEnabled(true);
                deleteFirstContact.setEnabled(true);
            }
        });
        updateFirstContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                updateContact(saveFirstContact, nameFirstContact, idFirstContact,updateFirstContact);
                saveFirstContact.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        updateFirstContact(idFirstContact);
                    }
                });
            }
        });

        deleteFirstContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                deleteContact(nameFirstContact,phoneFirstContact,saveFirstContact,
                        idFirstContact);
                saveFirstContact.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        firstContact();
                        saveFirstContact.setEnabled(false);
                        updateFirstContact.setEnabled(true);
                        deleteFirstContact.setEnabled(true);
                    }
                });
            }
        });
    }

    public void firstContact(){
        boolean sucess = true;
        Cursor result = emergencyContactDao.getEmergencyContact();

        if(result.getCount() == 0) {
            if (checksName(nameFirstContact.getText().toString()) == false) {
                nameContact = nameFirstContact.getText().toString();
                phoneContact = phoneFirstContact.getText().toString();

                sucess = emergencyContactDao.insertEmergencyContact(idFirstContact, nameContact, phoneContact);
                if (sucess == true) {
                    showMessage("Contato de Emergência Cadastrado Com Sucesso!");
                } else {
                    showMessage("Contato de Emergência Não Cadastrado! Tente Novamente");
                }
            }
        }
    }


    public void updateContact(Button save,EditText nameEdit,Integer id,Button update){
        nameEdit.setEnabled(true);
        update.setEnabled(false);
        save.setEnabled(true);
    }

    public void updateFirstContact(Integer id){
        boolean sucess = true;
        if(checksName(nameFirstContact.getText().toString()) == false){
            nameContact = nameFirstContact.getText().toString();
            phoneContact = phoneFirstContact.getText().toString();

            sucess = emergencyContactDao.updateEmergencyContact(id,nameContact,phoneContact);
            if(sucess == true){
                showMessage("Contato de Emergência Alterado Com Sucesso!");
            }else{
                showMessage("Contato de Emergência Não Alterado! Tente Novamente");
            }
        }
    }

    public void deleteContact(final EditText nameContact, final EditText phoneContact,
                              final Button save, final Integer id){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Excluir Contato");
        builder.setMessage("Deseja Mesmo Excluir Este Contato?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                emergencyContactDao.deleteEmergencyContact(id);
                showMessage("Contato de Emergência Excluido Com Sucesso");
                saveFirstContact.setEnabled(true);
                nameFirstContact.setEnabled(true);
                updateFirstContact.setEnabled(false);
                deleteFirstContact.setEnabled(false);
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    private boolean checksName(String nameUser){
        final int MINIMUM = 3;
        if(nameUser.isEmpty()){
            showMessage("Nome Vazio! Informe Seu Nome.");
            return true;
        }if(nameUser.trim().length()<MINIMUM){
            showMessage("Informe um nome com no mínimo 3 caracteres.");
            return true;
        }
        return false;
    }

    private void showMessage(String message){
        Toast.makeText(this,""+message,Toast.LENGTH_SHORT).show();
    }
}