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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.UserDao;
import helper.MaskHelper;
import unlv.erc.emergo.R;


public class MedicalRecordsController extends Activity {
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
    private Integer id = 1;

    UserDao myDatabase;

    public MedicalRecordsController() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medical_records);

        myDatabase = new UserDao(this);

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


    private void createUser(){

        Cursor result = myDatabase.getUser();
        boolean sucess = true;
        if(result.getCount() == 0){

            if(checksName(fullName.getText().toString()) == false
                    && checkBirthday(birthday.getText().toString()) == false){

                birthdayUser = birthday.getText().toString();
                observationsUser = observations.getText().toString();
                nameUser = fullName.getText().toString();
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
                    showMessage("Usuário Não Cadastrado! Tente Novamente.");
                }
            }
        }else {
            showMessageDialog("Erro!","Não É Possível Cadastrar Mais De Uma Ficha Médica.");
        }
    }

    private void updateUser(){
        Cursor result = myDatabase.getUser();
        boolean sucess = true;
        if(result.getCount() == 0){
            showMessageDialog("Ficha Médica Vazia!","Cadastre Uma Ficha Médica Antes.");
            return;
        }else if(checksName(fullName.getText().toString()) == false
                && checkBirthday(birthday.getText().toString()) == false){

            birthdayUser = birthday.getText().toString();
            observationsUser = observations.getText().toString();
            nameUser = fullName.getText().toString();
            typeBloodUser = typeBlood.getSelectedItem().toString();
            cardiacUser = cardiac.getSelectedItem().toString();
            diabeticUser = diabect.getSelectedItem().toString();
            hypertensionUser = diabect.getSelectedItem().toString();
            seropositiveUser = seropositive.getSelectedItem().toString();

            sucess = myDatabase.updateUser(id, nameUser, birthdayUser, typeBloodUser, cardiacUser, diabeticUser,
                    hypertensionUser, seropositiveUser,observationsUser);
            if (sucess == true) {
                showMessage("Alteração Realizada Com Sucesso!");
            } else {
                showMessage("Não Foi Possível Fazer A Alteração, Tente Novamente.");
            }
        }
    }
    private void deleteUser(){
        Cursor res = myDatabase.getUser();
        if(res.getCount() == 0){
            showMessageDialog("Ficha Médica Vazia!","Cadastre Uma Ficha Médica Antes.");
            return;
        }else {
            myDatabase.deleteUser(id);
            showMessage("Usuario Excluido Com Sucesso.");
        }
    }
    private void showMessage(String message){
        Toast.makeText(this,""+message,Toast.LENGTH_SHORT).show();
    }
    private void showMessageDialog(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    private boolean checksName(String nameUser){
        final int MINIMUM = 3;
        if(nameUser.isEmpty()){
            showMessage("Nome Vazio! Informe Seu Nome.");
            return true;
        }if(nameUser.trim().length()<MINIMUM){
            showMessage("Informe um nome com no mínimo 3 caracteres.");
            fullName.requestFocus();
            return true;
        }
        return false;
    }
    private boolean checkBirthday(String birthdayUser){
        final int MINIMUMYEAR = 42;
        if(!birthdayUser.isEmpty() && birthdayUser!=null){
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                format.setLenient(false);
                Date userDate = format.parse(birthdayUser);

                if (userDate.before(new Date())){
                    if(userDate.getYear() < MINIMUMYEAR){
                        showMessage("Informe um ano superior a 1942.");
                        return true;
                    }
                    this.birthdayUser = birthdayUser;
                    return false;
                }

                else{
                    showMessage("Ops, essa data é inválida!.");
                    return true;
                }
            }
            catch (ParseException excecao){
                showMessage("Ano Bissexto! Tente colocar 01/03/ e o ano que você nasceu.");
                return true;
            }
        }
        else{
            showMessage("Informe a sua data de nascimento.");
            return true;
        }
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
        config.setClass(this , ConfigController.class);
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
