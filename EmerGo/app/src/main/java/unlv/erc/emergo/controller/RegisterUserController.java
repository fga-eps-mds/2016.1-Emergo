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

        if(verifDatabase() == false) {
            saveButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    createUser();
                }
            });
        }else{
            myDatabase.getUser();
            saveButton.setEnabled(false);
            updateButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    updateUser();
                    showUser();
                }
            });
            deleteButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    deleteUser();
                }
            });
        }
    }

    public void createUser(){

        nameUser = fullName.getText().toString();
        birthdayUser = birthday.getText().toString();
        typeBloodUser = typeBlood.getSelectedItem().toString();
        cardiacUser = cardiac.getSelectedItem().toString();
        diabeticUser = diabect.getSelectedItem().toString();
        hypertensionUser = hypertension.getSelectedItem().toString();
        seropositiveUser = seropositive.getSelectedItem().toString();

        if(nameUser.isEmpty()) {
            showMessage("Nome Vazio! Informe seu nome completo");
            fullName.requestFocus();
        }else if(birthdayUser.isEmpty()){
            showMessage("Data de Nascimento vazia! Informe sua data de nascimento");
            birthday.requestFocus();
        }else if(typeBloodUser.isEmpty()){
            showMessage("Tipo Sanguíneo vazio! Informe o seu tipo sanguíneo");
            typeBlood.requestFocus();
        }else if(cardiacUser.isEmpty()){
            showMessage("Você é cardiaco? Informe se sim ou não");
            cardiac.requestFocus();
        }else if(diabeticUser.isEmpty()){
            showMessage("Você é diabetico? Informe se sim ou não");
            diabect.requestFocus();
        }else if(hypertensionUser.isEmpty()){
            showMessage("Você é hipertenso? Informe se sim ou não");
            hypertension.requestFocus();
        }else if(seropositiveUser.isEmpty()){
            showMessage("Você possui soropositivo? Informe se sim ou não");
            seropositive.requestFocus();
        }else {
            myDatabase.insertUser(id,nameUser,birthdayUser,typeBloodUser,cardiacUser,diabeticUser,
                    hypertensionUser,seropositiveUser);
            showMessage("Usuário Cadastrado Com Sucesso!");
        }
    }

    public void updateUser(){
        nameUser = fullName.getText().toString();
        birthdayUser = birthday.getText().toString();
        typeBloodUser = typeBlood.getSelectedItem().toString();
        cardiacUser = cardiac.getSelectedItem().toString();
        diabeticUser = diabect.getSelectedItem().toString();
        hypertensionUser = hypertension.getSelectedItem().toString();
        seropositiveUser = seropositive.getSelectedItem().toString();

        if(myDatabase.getUser()==null) {
            if (nameUser.isEmpty()) {
                showMessage("Nome Vazio! Informe seu nome completo");
                fullName.requestFocus();
            } else if (birthdayUser.isEmpty()) {
                showMessage("Data de Nascimento vazia! Informe sua data de nascimento");
                birthday.requestFocus();
            } else if (typeBloodUser.isEmpty()) {
                showMessage("Tipo Sanguíneo vazio! Informe o seu tipo sanguíneo");
                typeBlood.requestFocus();
            } else if (cardiacUser.isEmpty()) {
                showMessage("Você é cardiaco? Informe se sim ou não");
                cardiac.requestFocus();
            } else if (diabeticUser.isEmpty()) {
                showMessage("Você é diabetico? Informe se sim ou não");
                diabect.requestFocus();
            } else if (hypertensionUser.isEmpty()) {
                showMessage("Você é hipertenso? Informe se sim ou não");
                hypertension.requestFocus();
            } else if (seropositiveUser.isEmpty()) {
                showMessage("Você possui soropositivo? Informe se sim ou não");
                seropositive.requestFocus();
            }
        }else {
            myDatabase.updateUser(id, nameUser, birthdayUser, typeBloodUser, cardiacUser, typeBloodUser,
                    hypertensionUser, seropositiveUser);
            showMessage("Alteração Realizada Com Sucesso!");
        }
    }

    public void deleteUser(){
        Cursor res = myDatabase.getUser();
        if(res.getCount() == 0){
            showMessageDialog("Ficha Medica Vazia!","Cadastre uma ficha medica antes.");
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
    public void showUser(){
        Cursor res = myDatabase.getUser();
        if(res.getCount() == 0){
            showMessageDialog("Ficha Medica Vazia!","Cadastre uma ficha medica antes.");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("NAME :"+ res.getString(1)+"\n");
            buffer.append("BIRTHDAY :"+ res.getString(2)+"\n");
        }
        showMessageDialog("Data",buffer.toString());
    }
    public boolean verifDatabase(){
        Cursor cursor = myDatabase.getUser();
        if(cursor.getCount()==0){
            showMessageDialog("Ficha Medica","Não foi encontrado nenhum cadastro.\n" +
                    "Sinta se a vontade para realizar um cadastro");
            return false;
        }else
            return true;
    }
}