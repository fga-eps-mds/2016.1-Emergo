package unlv.erc.emergo.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import unlv.erc.emergo.R;
import unlv.erc.emergo.model.User;

public class UserController extends Activity implements View.OnClickListener{
    private EditText fullName;
    private EditText birthday;
    private SimpleDateFormat dateFormat;
    private List<User> userList = new ArrayList<User>();
    private Button saveButton;
    private Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user);

        fullName = (EditText) findViewById(R.id.fullNameEditText);
        birthday = (EditText) findViewById(R.id.birthdayEditText);
        dateFormat = new SimpleDateFormat("dd/MM/yyyy",Locale.US);
        saveButton = (Button) findViewById(R.id.saveButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);

        saveButton.setOnClickListener(this);

    }

    public void createUser(){
        String nameUser,birthdayUser;

        nameUser = fullName.getText().toString();
        birthdayUser = birthday.getText().toString();
        User user = new User(nameUser,birthdayUser);
        user.save();
        userList.add(user);
//        Toast.makeText(this,"SALVOU",Toast.LENGTH_SHORT);
    }

    public void daleteUser(){
        String nameUser,birthdayUser;

        nameUser = fullName.getText().toString();
        birthdayUser = birthday.getText().toString();
        User user = new User(nameUser,birthdayUser);
        user.delete();
    }

    public void desableOptions(){
        saveButton.setClickable(false);
    }

    @Override
    public void onClick(View v) {
        if(saveButton.isPressed()){
            createUser();
        }
    }
}
