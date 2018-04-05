package com.example.willi.homeschool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Declaring variables
        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);
        Info.setText("No of attempts remaining: 5");
        //Takes in Name string and Password string and naviagates to the appropriate actvity
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

    }
    private void validate(String userName, String userPassword){

        if((userName.equals("Admin")) && (userPassword.equals("Admin"))){
            Intent intent = new Intent (LoginActivity.this, AdminActivity.class);
            startActivity(intent);
        }
        else if ((userName.equals("Teacher")) && ((userPassword.equals("Teacher")))){
            Intent intent = new Intent (LoginActivity.this, TeacherActivity.class);
            startActivity(intent);
        }
        else if ((userName.equals("Parent")) && ((userPassword.equals("Parent")))){
            Intent intent = new Intent (LoginActivity.this, ParentActivity.class);
            startActivity(intent);
        }
        else{
            counter --;

            Info.setText("No of attempts remaining:" + String.valueOf(counter));

            if(counter == 0){
                Login.setEnabled(false);
            }
        }
    }
}
