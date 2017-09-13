package com.onclick.angie.oneclick_v20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void redirectLogin(View view) {
        //Set-up redirection

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        if (username.getText().toString().equalsIgnoreCase("user") && password.getText().toString().equalsIgnoreCase("user")) {
            Intent login = new Intent(this, StudentHome.class);
            startActivity(login);
            finish();
        } else {
            username.setText("");
            password.setText("");
        }

    }

    public void redirectAlt(View view){
        Intent signup = new Intent(this, SignUpActivity.class);
        startActivity(signup);
    }

}
