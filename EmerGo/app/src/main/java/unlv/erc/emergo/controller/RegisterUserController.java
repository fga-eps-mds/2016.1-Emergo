package unlv.erc.emergo.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import helper.MaskHelper;
import unlv.erc.emergo.R;
import unlv.erc.emergo.model.User;

/**
 * Created by victor on 25/05/16.
 */
public class RegisterUserController extends Activity {
    private EditText fullName;
    private EditText birthday;
    private List<User> userList = new ArrayList<User>();
    private Button saveButton;
    private Button deleteButton;
    UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user);

        fullName = (EditText) findViewById(R.id.fullNameEditText);
        birthday = (EditText) findViewById(R.id.birthdayEditText);
        birthday.addTextChangedListener(MaskHelper.insert("##/##/####",birthday));
        saveButton = (Button) findViewById(R.id.saveButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);


        if(userList.isEmpty()) {
            saveButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    createUser();
                }
            });
        }else{
            disableOptions();
        }
    }

    public void createUser(){
        String nameUser,birthdayUser;

        nameUser = fullName.getText().toString();
        birthdayUser = birthday.getText().toString();

        if(nameUser.isEmpty()) {
            Toast.makeText(this,"Nome vazio! Informe um nome",Toast.LENGTH_SHORT).show();
            fullName.requestFocus();

        }else {
            User user = new User(nameUser, birthdayUser);
            userDao.insertUserOnDatabase(user);
            userList.add(user);
            Toast.makeText(this,"Usuário Cadastrado Com Sucesso",Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteUser(){
        String nameUser,birthdayUser;

        fullName.setText("");
        nameUser = fullName.getText().toString();
        birthdayUser = birthday.getText().toString();
        User user = new User(nameUser,birthdayUser);
        //user.delete();
    }

    public void disableOptions(){
        saveButton.setClickable(false);
    }
}
