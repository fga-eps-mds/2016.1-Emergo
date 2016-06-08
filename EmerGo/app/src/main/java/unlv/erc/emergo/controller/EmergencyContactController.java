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
    private Button saveAndUpdateFirstContact;
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
    private Button addAnotherContact;
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

        saveAndUpdateFirstContact = (Button) findViewById(R.id.saveButtonFirstContact);
        saveSecondContact = (Button) findViewById(R.id.saveButtonSecondContact);
        saveThirdContact = (Button) findViewById(R.id.saveButtonLastContact);
        nameFirstContact = (EditText) findViewById(R.id.nameContactEditText);
        nameSecondContact = (EditText) findViewById(R.id.nameSecondContactEditText);
        nameThirdContact = (EditText) findViewById(R.id.nameLastContactEditText);
        phoneFirstContact = (EditText) findViewById(R.id.phoneEditText);
        phoneFirstContact.addTextChangedListener(MaskHelper.insert("(##)#####-####", phoneFirstContact));
        phoneSecondContact = (EditText) findViewById(R.id.phoneSecondContactEditText);
        phoneSecondContact.addTextChangedListener(MaskHelper.insert("(##)#####-####", phoneSecondContact));
        phoneThirdContact = (EditText) findViewById(R.id.phoneLastContactEditText);
        phoneThirdContact.addTextChangedListener(MaskHelper.insert("(##)#####-####", phoneThirdContact));
        deleteFirstContact = (Button) findViewById(R.id.deleteButtonFirstContact);
        deleteSecondContact = (Button) findViewById(R.id.deleteButtonSecondContact);
        deleteThirdContact = (Button) findViewById(R.id.deleteButtonLastContact);
        addAnotherContact = (Button) findViewById(R.id.addNewContact);
        addAnotherContactLast = (Button) findViewById(R.id.addSecondContact);

        invisibleOptions(saveAndUpdateFirstContact,deleteFirstContact,addAnotherContact);
        saveAndUpdateFirstContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                firstContact();
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
                    visibleOptionsContact(nameFirstContact, nameContact, saveAndUpdateFirstContact,
                            deleteFirstContact, addAnotherContact);
                } else {
                    showMessage("Contato de Emergência Não Cadastrado! Tente Novamente");
                }
            }
        }

        saveAndUpdateFirstContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                updateContact(saveAndUpdateFirstContact, nameFirstContact, idFirstContact);
            }
        });


        deleteFirstContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                deleteContact(nameFirstContact,phoneFirstContact,saveAndUpdateFirstContact,
                                idFirstContact);
            }
        });
    }


    public void updateContact(Button save,EditText nameEdit,Integer id){
        save.setText("Salvar");
        nameEdit.setEnabled(true);
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
    public void invisibleOptions(Button save, Button delete, Button addAnotherContact){
        save.setVisibility(View.VISIBLE);
        delete.setVisibility(View.INVISIBLE);
        addAnotherContact.setVisibility(View.INVISIBLE);
    }


    public void visibleOptionsContact(EditText nameEdit,String nameContact,Button save,
                                           Button delete,Button addAnotherContact){
        nameEdit.setText(""+nameContact);
        nameEdit.setEnabled(false);
        save.setText("Editar");
        delete.setVisibility(View.VISIBLE);
        addAnotherContact.setVisibility(View.VISIBLE);
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
                nameContact.setEnabled(true);
                nameContact.setText("");
                phoneContact.setEnabled(true);
                phoneContact.setText("");
                save.setText("Salvar");
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
