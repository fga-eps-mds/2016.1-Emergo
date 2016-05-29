package unlv.erc.emergo.controller;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import helper.DatabaseHelper;
import helper.MaskHelper;
import unlv.erc.emergo.R;


public class RegisterUserController extends Activity {
    private EditText fullName;
    private EditText birthday;
    private EditText observations;
    private Spinner typeBlood;
    private Spinner cardiac;
    private Spinner diabect;
    private Spinner hypertension;
    private Spinner seropositive;
    private Button saveButton;
    private Button updateButton;
    private Button deleteButton;
    private String nameUser;
    private String birthdayUser;
    private String typeBloodUser;
    private String cardiacUser;
    private String observationsUser;
    private String diabeticUser;
    private String hypertensionUser;
    private String seropositiveUser;
    private String id = "1";

    DatabaseHelper myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user);

        myDatabase = new DatabaseHelper(this);

        fullName = (EditText) findViewById(R.id.fullNameEditText);
        birthday = (EditText) findViewById(R.id.birthdayEditText);
        observations = (EditText) findViewById(R.id.observationsEditText);
        typeBlood = (Spinner) findViewById(R.id.typeBloodSpinner);
        birthday.addTextChangedListener(MaskHelper.insert("##/##/####", birthday));
        cardiac = (Spinner) findViewById(R.id.cardiacSpinner);
        diabect = (Spinner) findViewById(R.id.diabeticSpinner);
        hypertension = (Spinner) findViewById(R.id.hipertensionSpinner);
        seropositive = (Spinner) findViewById(R.id.soropositiveSpinner);
        saveButton = (Button) findViewById(R.id.saveButton);
        updateButton = (Button) findViewById(R.id.updateButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);


        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createUser();
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                updateUser();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                deleteUser();
            }
        });
    }


    public void createUser(){

        Cursor result = myDatabase.getUser();
        boolean sucess = true;
        if(result.getCount() == 0){

            if(checksName(fullName.getText().toString()) == false){

                birthdayUser = birthday.getText().toString();
                observationsUser = observations.getText().toString();
                nameUser = String.valueOf(checksName(fullName.getText().toString()));
                typeBloodUser = typeBlood.getSelectedItem().toString();
                cardiacUser = cardiac.getSelectedItem().toString();
                diabeticUser = diabect.getSelectedItem().toString();
                hypertensionUser = diabect.getSelectedItem().toString();
                seropositiveUser = seropositive.getSelectedItem().toString();

                sucess = myDatabase.insertUser(id, nameUser, birthdayUser, typeBloodUser, cardiacUser, diabeticUser,
                        hypertensionUser, seropositiveUser,observationsUser);
                if (sucess == true) {
                    showMessage("Usuário Cadastrado Com Sucesso!");
                } else {
                    showMessage("Usuário Não Cadastrado! Tente Novamente");
                }
            }

        }else {
            showMessageDialog("Erro!","Não é possível cadastrar mais uma ficha médica");
        }
    }

    public void updateUser(){

        Cursor result = myDatabase.getUser();
        boolean sucess = true;
        if(result.getCount() == 0){
            showMessageDialog("Ficha Médica Vazia!","Cadastre uma ficha médica antes");
            return;
        }else{
            nameUser = fullName.getText().toString();
            birthdayUser = birthday.getText().toString();
            typeBloodUser = typeBlood.getSelectedItem().toString();
            observationsUser = observations.getText().toString();
            cardiacUser = cardiac.getSelectedItem().toString();
            diabeticUser = diabect.getSelectedItem().toString();
            hypertensionUser = hypertension.getSelectedItem().toString();
            seropositiveUser = seropositive.getSelectedItem().toString();

            sucess = myDatabase.updateUser(id, nameUser, birthdayUser, typeBloodUser, cardiacUser, typeBloodUser,
                    hypertensionUser, seropositiveUser,observationsUser);
            if(sucess == true){
                showMessage("Alteração Realizada Com Sucesso!");
            }else{
                showMessage("Não foi possível fazer a alteração, tente novamente");
            }
        }
    }
    public void deleteUser(){
        Cursor res = myDatabase.getUser();
        if(res.getCount() == 0){
            showMessageDialog("Ficha Medica Vazia!","Cadastre uma ficha medica antes");
            return;
        }else {
            myDatabase.deleteUser(id);
            showMessage("Usuario excluido com sucesso");
        }
    }
    public void showMessage(String message){
        Toast.makeText(this,""+message,Toast.LENGTH_SHORT).show();
    }
    public void showMessageDialog(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public boolean checksName(String nameUser){
        final int MINIMUM = 3;
        if(nameUser.isEmpty()){
            showMessage("Nome Vazio! Informe seu nome");
            return true;
        }while(nameUser.trim().length()<MINIMUM){
            showMessage("Informe um nome com no mínimo 3 caracteres");
            fullName.requestFocus();
            return true;
        }
        return false;
    }
    public void goClicked(View map_screen){
        Toast.makeText(this , "Função não habilitada!" , Toast.LENGTH_SHORT).show();
        Intent routeActivity = new Intent();
        routeActivity.setClass(this, RouteActivity.class);
        startActivity(routeActivity);
        finish();
    }

    public void listMapsImageClicked(View map_screen){
        Intent listOfHealth = new Intent();
        listOfHealth.setClass(this , ListOfHealthUnitsController.class);
        startActivity(listOfHealth);
        finish();
    }

    public void openConfig(View map_screen){
        Intent config = new Intent();
        config.setClass(this , RegisterUserController.class);
        startActivity(config);
        finish();
    }

    public void openMap(View mapScreen){
        Intent mapActivity = new Intent();
        mapActivity.setClass(this, MapScreenController.class);
        startActivity(mapActivity);
        finish();
    }
}
