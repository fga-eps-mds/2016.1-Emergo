package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;

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

    public EmergencyContactController(){

    }

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
        phoneFirstContact.addTextChangedListener(MaskHelper.insert("(###)#####-####", phoneFirstContact));
        phoneSecondContact = (EditText) findViewById(R.id.phoneSecondContactEditText);
        phoneSecondContact.addTextChangedListener(MaskHelper.insert("(###)#####-####", phoneSecondContact));
        phoneThirdContact = (EditText) findViewById(R.id.phoneThirdContactEditText);
        phoneThirdContact.addTextChangedListener(MaskHelper.insert("(###)#####-####", phoneThirdContact));
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
                            disableField(nameFirstContact,phoneFirstContact);
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
                        updateContact(idFirstContact,nameFirstContact,phoneFirstContact,
                                saveFirstContact,updateFirstContact,deleteFirstContact);
                        visibleOptions(saveFirstContact,updateFirstContact);
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
                        if(firstContact() == false){
                            saveFirstContact.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    firstContact();
                                    disableField(nameFirstContact,phoneFirstContact);
                                }
                            });
                        }else{
                            disableButtons(saveFirstContact,updateFirstContact,deleteFirstContact);
                        }
                    }
                });
            }
        });

        if(result.getCount() == 0){
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
                            disableField(nameSecondContact,phoneSecondContact);
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
                        updateContact(idSecondContact,nameSecondContact,phoneSecondContact,
                                saveSecondContact,updateSecondContact,deleteSecondContact);
                        visibleOptions(saveSecondContact,updateSecondContact);
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
                        if(secondContact() == false){
                            saveSecondContact.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    secondContact();
                                    disableField(nameSecondContact,phoneSecondContact);
                                }
                            });
                        }else{
                            disableButtons(saveSecondContact,updateSecondContact,deleteSecondContact);
                        }
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
                            disableField(nameThirdContact,phoneThirdContact);
                        }
                    });
                }else{
                    disableButtons(saveThirdContact,updateThirdContact,deleteThirdContact);
                }
            }
        });

        updateThirdContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                disableJustUpdateButton(nameThirdContact,phoneThirdContact,updateThirdContact,
                        saveThirdContact);
                saveThirdContact.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        updateContact(idThirdContact,nameThirdContact,phoneThirdContact,
                                saveThirdContact,updateThirdContact,deleteThirdContact);
                        visibleOptions(saveThirdContact,updateFirstContact);
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
                        if(thirdContact() == false){
                            saveThirdContact.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    thirdContact();
                                    disableField(nameThirdContact,phoneThirdContact);
                                }
                            });
                        }else{
                            disableButtons(saveThirdContact,updateThirdContact,deleteThirdContact);
                        }
                    }
                });
            }
        });
    }

    private boolean firstContact(){
        boolean sucess = true;
        boolean valid = false;
        if (checksName(nameFirstContact.getText().toString()) == false) {
            nameContact = nameFirstContact.getText().toString();
            phoneContact = phoneFirstContact.getText().toString();

            sucess = emergencyContactDao.insertEmergencyContact(idFirstContact, nameContact, phoneContact);
            if (sucess == true) {
                showMessage("Contato de Emergência Cadastrado Com Sucesso!");
                valid = true;
                nameFirstContact.setEnabled(false);
                phoneFirstContact.setEnabled(false);
                disableOptionsUpdate(saveFirstContact,updateFirstContact,deleteFirstContact);
            } else {
                showMessage("Contato de Emergência Não Cadastrado! Tente Novamente");
                valid = false;
            }
        }
        return valid;
    }


    private boolean secondContact(){
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
                    nameSecondContact.setEnabled(false);
                    phoneSecondContact.setEnabled(false);
                    disableOptionsUpdate(saveSecondContact,updateSecondContact,deleteSecondContact);
                } else {
                    showMessage("Contato de Emergência Não Cadastrado! Tente Novamente");
                    valid = true;
                }
            }
        }
        return valid;
    }

    private boolean thirdContact(){
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
                    nameThirdContact.setEnabled(false);
                    phoneThirdContact.setEnabled(false);
                    disableOptionsUpdate(saveThirdContact,updateThirdContact,deleteThirdContact);
                } else {
                    showMessage("Contato de Emergência Não Cadastrado! Tente Novamente");
                    valid = true;
                }
            }
        }
        return valid;
    }

    private void updateContact(Integer id,EditText name,EditText phone,Button save,Button update,
                               Button delete){
        boolean sucess = true;
        if(checksName(name.getText().toString()) == false){
            nameContact = name.getText().toString();
            phoneContact = phone.getText().toString();

            sucess = emergencyContactDao.updateEmergencyContact(id,nameContact,phoneContact);
            if(sucess == true){
                showMessage("Contato de Emergência Alterado Com Sucesso!");
                save.setVisibility(View.VISIBLE);
                save.setEnabled(false);
                update.setEnabled(true);
                delete.setEnabled(true);
            }else{
                showMessage("Contato de Emergência Não Alterado! Tente Novamente");
            }
        }
    }

    private void deleteContact(final EditText nameContact, final EditText phoneContact,
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
                update.setVisibility(View.INVISIBLE);
                delete.setVisibility(View.INVISIBLE);
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
        }else if(nameUser.trim().length()<MINIMUM){
            showMessage("Informe um nome com no mínimo 3 caracteres.");
            return true;
        }
        else if(nameUser.matches(".*\\d.*")){
            showMessage("Um nome não pode ter um número!");
            return true;
        }
        return false;
    }

    private void showMessage(String message){
        Toast.makeText(this,""+message,Toast.LENGTH_SHORT).show();
    }

    private void disableOptions(Button save, Button update,Button delete){
        save.setVisibility(View.VISIBLE);
        update.setVisibility(View.INVISIBLE);
        delete.setVisibility(View.INVISIBLE);
    }

    private void disableField(Button save,EditText name, EditText phone){
        save.setVisibility(View.INVISIBLE);
        name.setEnabled(false);
        phone.setEnabled(false);
    }
    private void disableButtons(Button save,Button update,Button delete){
        save.setVisibility(View.INVISIBLE);
        update.setVisibility(View.VISIBLE);
        update.setEnabled(true);
        delete.setVisibility(View.VISIBLE);
        delete.setEnabled(true);
    }

    private void disableJustUpdateButton(EditText name, EditText phone, Button update, Button save) {
        name.setEnabled(true);
        phone.setEnabled(true);
        update.setVisibility(View.INVISIBLE);
        save.setVisibility(View.VISIBLE);
        save.setEnabled(true);
    }

    private void disableOptionsUpdate(Button save,Button update,Button delete){
        save.setEnabled(false);
        update.setVisibility(View.VISIBLE);
        update.setEnabled(true);
        delete.setVisibility(View.VISIBLE);
        delete.setEnabled(true);
    }

    private void visibleOptions(Button save,Button update){
        update.setVisibility(View.VISIBLE);
        save.setVisibility(View.INVISIBLE);
    }

    private void disableField(EditText name,EditText phone){
        name.setEnabled(false);
        phone.setEnabled(false);
    }

    public void open_search(View mapScreen){
        Intent openSearch = new Intent();
        openSearch.setClass(this , SearchUsController.class);
        startActivity(openSearch);
        finish();
    }

    public void goClicked(View map_screen) throws IOException, JSONException {
        final String ROUTETRACED = "Rota mais próxima traçada";

        Toast.makeText(this, ROUTETRACED , Toast.LENGTH_SHORT).show();
        Intent routeActivity = new Intent();
        routeActivity.setClass(this , RouteActivity.class);
        routeActivity.putExtra("numeroUs" , -1);
        startActivity(routeActivity);
        finish();
    }

    public void listMapsImageClicked(View map_screen){
        Intent listOfHealth = new Intent();
        listOfHealth.setClass(this , ListOfHealthUnitsController.class);
        startActivity(listOfHealth);
        finish();
    }

    public void openConfig(View map_screen) {
        Intent config = new Intent();
        config.setClass(this, ConfigController.class);
        startActivity(config);
    }

    public void openMap(View mapScreen){
        Intent mapActivity = new Intent();
        mapActivity.setClass(this, MapScreenController.class);
        startActivity(mapActivity);
        finish();
    }
}