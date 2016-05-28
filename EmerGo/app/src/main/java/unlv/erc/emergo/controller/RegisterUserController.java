package unlv.erc.emergo.controller;

import android.app.Activity;
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
            showMessageDialog("Espaços Vazios!","Preencha os campos acima para concluir o cadastro");
            return;
        }else {
            nameUser = checksName(fullName.getText().toString());
            birthdayUser = birthday.getText().toString();
            typeBloodUser = checkTypeBlood(typeBlood.getSelectedItem().toString());
            cardiacUser = checkCardiac(cardiac.getSelectedItem().toString());
            diabeticUser = checkDiabetic(diabect.getSelectedItem().toString());
            hypertensionUser = checkHipertension(hypertension.getSelectedItem().toString());
            seropositiveUser = checkSeropositive(seropositive.getSelectedItem().toString());

            sucess = myDatabase.insertUser(id, nameUser, birthdayUser, typeBloodUser, cardiacUser, diabeticUser,
                    hypertensionUser, seropositiveUser);
            if (sucess == true) {
                showMessage("Usuário Cadastrado Com Sucesso!");
            } else {
                showMessage("Usuário Não Cadastrado! Tente Novamente");
            }
        }
    }


    public void updateUser(){

        Cursor result = myDatabase.getUser();
        boolean sucess = true;
        if(result.getCount() == 0){
            showMessageDialog("Ficha Médica Vazia!","Cadastre uma ficha médica antes");
            return;
        }else{
            nameUser = checksName(fullName.getText().toString());
            birthdayUser = birthday.getText().toString();
            typeBloodUser = checkTypeBlood(typeBlood.getSelectedItem().toString());
            cardiacUser = checkCardiac(cardiac.getSelectedItem().toString());
            diabeticUser = checkDiabetic(diabect.getSelectedItem().toString());
            hypertensionUser = checkHipertension(hypertension.getSelectedItem().toString());
            seropositiveUser = checkSeropositive(seropositive.getSelectedItem().toString());

            sucess = myDatabase.updateUser(id, nameUser, birthdayUser, typeBloodUser, cardiacUser, typeBloodUser,
                    hypertensionUser, seropositiveUser);
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
    public String checksName(String nameUser){
        final int MINIMUM = 3;
        if(nameUser.isEmpty()){
            showMessage("Nome Vazio! Informe seu nome completo");
            fullName.requestFocus();
        }else if(nameUser.trim().length()<MINIMUM){
            showMessage("Informe um nome com no mínimo 3 caracteres");
            fullName.requestFocus();
        }
        return nameUser;
    }
    public String checkTypeBlood(String typeBloodUser){
        if(typeBloodUser.isEmpty()){
            showMessage("Tipo Sanguíneo vazio! Informe o seu tipo sanguíneo");
            typeBlood.requestFocus();
        }
        return typeBloodUser;
    }
    public String checkCardiac(String cardiacUser){
        if(cardiacUser.isEmpty()){
            showMessage("Você é cardiaco? Informe se sim ou não");
            cardiac.requestFocus();
        }
        return cardiacUser;
    }
    public String checkHipertension(String hypertensionUser){
        if(hypertensionUser.isEmpty()){
            showMessage("Você é hipertenso? Informe se sim ou não");
            hypertension.requestFocus();
        }
        return hypertensionUser;
    }
    public String checkSeropositive(String seropositiveUser){
        if(seropositiveUser.isEmpty()){
            showMessage("Você possui soropositivo? Informe se sim ou não");
            hypertension.requestFocus();
        }
        return seropositiveUser;
    }
    public String checkDiabetic(String diabeticUser){
        if(diabeticUser.isEmpty()){
            showMessage("Você é diabetico? Informe se sim ou não");
            diabect.requestFocus();
        }
        return diabeticUser;
    }
}