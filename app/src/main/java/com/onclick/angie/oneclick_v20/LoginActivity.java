package com.onclick.angie.oneclick_v20;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        /*if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(this, StudentHome.class));
        }*/

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

    public void redirectLogin(View view) {
        //Set-up redirection

        String uname = username.getText().toString();
        String pass = password.getText().toString();

        if (!uname.equals("") && !pass.equals("")) {
            firebaseAuth.signInWithEmailAndPassword(uname, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                finish();
                                startActivity(new Intent(getApplicationContext(), StudentHome.class));
                            }
                            else{
                                toasterMessage("Could not login. Please try again.");
                            }
                        }
                    });
        }
        else{
            toasterMessage("You must fill-out all the fields");
        }

    }

    public void redirectAlt(View view){
        startActivity(new Intent(this, SignUpActivity.class));
    }

    public void toasterMessage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}
