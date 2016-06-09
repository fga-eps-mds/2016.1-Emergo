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
    private Button updateSecondContact;
    private Button updateThirdContact;
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
        updateSecondContact = (Button) findViewById(R.id.updateSecondContactButton);
        updateThirdContact = (Button) findViewById(R.id.updateThirdContactButton);
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
            disableOptions(saveFirstContact,updateFirstContact,deleteFirstContact);
        }else{
            if(result.moveToFirst()){
                nameFirstContact.setText(result.getString(1));
                phoneFirstContact.setText(result.getString(2));
                disableField(saveFirstContact,nameFirstContact,phoneFirstContact);
            }
        }
        saveFirstContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(firstContact() == false){
                    saveFirstContact.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            firstContact();
                        }
                    });
                }else{
                    disableButtons(saveFirstContact,updateFirstContact,deleteFirstContact);
                }
            }
        });

        updateFirstContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                disableJustUpdateButton(nameFirstContact, phoneFirstContact, updateFirstContact,
                        saveFirstContact);
                saveFirstContact.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        updateContact(idFirstContact,nameFirstContact,phoneFirstContact);
                    }
                });
            }
        });


        deleteFirstContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                deleteContact(nameFirstContact,phoneFirstContact,saveFirstContact,
                        idFirstContact,updateFirstContact,deleteFirstContact);
                saveFirstContact.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        firstContact();
                        updateFirstContact.setEnabled(true);
                        deleteFirstContact.setEnabled(true);
                    }
                });
            }
        });

        if(result.getCount() == 0) {
            disableOptions(saveSecondContact, updateSecondContact,deleteSecondContact);
        }else{
            if(result.moveToNext()){
                nameSecondContact.setText(result.getString(1));
                phoneSecondContact.setText(result.getString(2));
                disableField(saveSecondContact,nameSecondContact,phoneSecondContact);
            }
        }
        saveSecondContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(secondContact() == false){
                    saveSecondContact.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            secondContact();
                        }
                    });
                }else{
                    disableButtons(saveSecondContact,updateSecondContact,deleteSecondContact);
                }
            }
        });

        updateSecondContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                disableJustUpdateButton(nameSecondContact, phoneSecondContact, updateSecondContact,
                        saveSecondContact);
                saveSecondContact.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        updateContact(idSecondContact,nameSecondContact,phoneSecondContact);
                    }
                });
            }
        });


        deleteSecondContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                deleteContact(nameSecondContact,phoneSecondContact,saveSecondContact,
                        idSecondContact,updateSecondContact,deleteSecondContact);
                saveSecondContact.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        secondContact();
                        updateSecondContact.setEnabled(true);
                        deleteSecondContact.setEnabled(true);
                    }
                });
            }
        });

        if(result.getCount() == 0) {
            disableOptions(saveThirdContact, updateThirdContact,deleteThirdContact);
        }else{
            if(result.moveToNext()){
                nameThirdContact.setText(result.getString(1));
                phoneThirdContact.setText(result.getString(2));
                disableField(saveThirdContact,nameThirdContact,phoneThirdContact);
            }
        }
        saveThirdContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(thirdContact() == false){
                    saveThirdContact.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            thirdContact();
                        }
                    });
                }else{
                    disableButtons(saveThirdContact,updateThirdContact,deleteThirdContact);
                }
            }
        });

        updateThirdContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                disableJustUpdateButton(nameThirdContact, phoneThirdContact, updateThirdContact,
                        saveThirdContact);
                saveThirdContact.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        updateContact(idThirdContact,nameThirdContact,phoneThirdContact);
                    }
                });
            }
        });


        deleteThirdContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                deleteContact(nameThirdContact,phoneThirdContact,saveThirdContact,
                        idThirdContact,updateThirdContact,deleteThirdContact);
                saveThirdContact.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        thirdContact();
                        updateThirdContact.setEnabled(true);
                        deleteThirdContact.setEnabled(true);
                    }
                });
            }
        });
    }

    public boolean firstContact(){
        boolean sucess = true;
        boolean valid = false;
        if (checksName(nameFirstContact.getText().toString()) == false) {
            nameContact = nameFirstContact.getText().toString();
            phoneContact = phoneFirstContact.getText().toString();

            sucess = emergencyContactDao.insertEmergencyContact(idFirstContact, nameContact, phoneContact);
            if (sucess == true) {
                showMessage("Contato de Emergência Cadastrado Com Sucesso!");
                valid = true;
                saveFirstContact.setEnabled(false);
            } else {
                showMessage("Contato de Emergência Não Cadastrado! Tente Novamente");
                valid = false;
            }
        }
        return valid;
    }


    public boolean secondContact(){
        boolean sucess = true;
        boolean valid = false;

        if(checksName(nameSecondContact.getText().toString()) == false) {
            if (checksName(nameSecondContact.getText().toString()) == false) {
                nameContact = nameSecondContact.getText().toString();
                phoneContact = phoneSecondContact.getText().toString();

                sucess = emergencyContactDao.insertEmergencyContact(idSecondContact, nameContact, phoneContact);
                if (sucess == true) {
                    showMessage("Contato de Emergência Cadastrado Com Sucesso!");
                    valid = true;
                } else {
                    showMessage("Contato de Emergência Não Cadastrado! Tente Novamente");
                    valid = true;
                }
            }
        }
        return valid;
    }

    public boolean thirdContact(){
        boolean sucess = true;
        boolean valid = false;

        if(checksName(nameThirdContact.getText().toString()) == false) {
            if (checksName(nameThirdContact.getText().toString()) == false) {
                nameContact = nameThirdContact.getText().toString();
                phoneContact = phoneThirdContact.getText().toString();

                sucess = emergencyContactDao.insertEmergencyContact(idThirdContact, nameContact, phoneContact);
                if (sucess == true) {
                    showMessage("Contato de Emergência Cadastrado Com Sucesso!");
                    valid = true;
                } else {
                    showMessage("Contato de Emergência Não Cadastrado! Tente Novamente");
                    valid = true;
                }
            }
        }
        return valid;
    }

    public void updateContact(Integer id,EditText name,EditText phone){
        boolean sucess = true;
        if(checksName(name.getText().toString()) == false){
            nameContact = name.getText().toString();
            phoneContact = phone.getText().toString();

            sucess = emergencyContactDao.updateEmergencyContact(id,nameContact,phoneContact);
            if(sucess == true){
                showMessage("Contato de Emergência Alterado Com Sucesso!");
            }else{
                showMessage("Contato de Emergência Não Alterado! Tente Novamente");
            }
        }
    }

    public void deleteContact(final EditText nameContact, final EditText phoneContact,
                              final Button save, final Integer id, final Button update,
                              final Button delete){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Excluir Contato");
        builder.setMessage("Deseja Mesmo Excluir Este Contato?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                emergencyContactDao.deleteEmergencyContact(id);
                showMessage("Contato de Emergência Excluido Com Sucesso");
                save.setVisibility(View.VISIBLE);
                save.setEnabled(true);
                nameContact.setText("");
                phoneContact.setText("");
                nameContact.setEnabled(true);
                phoneContact.setEnabled(true);
                update.setEnabled(false);
                delete.setEnabled(false);
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

    public void disableOptions(Button save, Button update,Button delete){
        save.setVisibility(View.VISIBLE);
        update.setVisibility(View.INVISIBLE);
        delete.setVisibility(View.INVISIBLE);
    }

    public void disableField(Button save,EditText name, EditText phone){
        save.setVisibility(View.INVISIBLE);
        name.setEnabled(false);
        phone.setEnabled(false);
    }
    public void disableButtons(Button save,Button update,Button delete){
        save.setVisibility(View.INVISIBLE);
        update.setVisibility(View.VISIBLE);
        delete.setVisibility(View.VISIBLE);
    }

    public void disableJustUpdateButton(EditText name, EditText phone, Button update, Button save) {
        name.setEnabled(true);
        phone.setEnabled(true);
        update.setVisibility(View.INVISIBLE);
        save.setVisibility(View.VISIBLE);
    }
}