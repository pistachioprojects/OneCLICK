package com.onclick.angie.oneclick_v20;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText studentFName;
    EditText studentLName;
    EditText studentEmail;
    EditText studentUserName;
    EditText studentPass;
    EditText studentConfPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void studentSignUp(View view){

        studentFName = (EditText) findViewById(R.id.student_fname);
        studentLName = (EditText) findViewById(R.id.student_lname);
        studentEmail = (EditText) findViewById(R.id.student_email);
        studentUserName = (EditText) findViewById(R.id.student_username);

        studentPass = (EditText) findViewById(R.id.student_password);
        studentConfPass = (EditText) findViewById(R.id.student_confpassword);

        boolean valid = validateForm(new EditText[] {studentFName, studentLName, studentEmail, studentUserName, studentPass, studentConfPass});

        if(valid){
            if(studentPass.getText().toString().equals(studentConfPass.getText().toString())){
                toasterMessage("Successful Sign-Up!");
            }
            else{
                toasterMessage("Passwords did not match!");
            }
        }
        else {
            toasterMessage("Please fill-out all information!");
        }

    }

    //Check if all field are filled-out
    public boolean validateForm(EditText[] fields){

        for(int i=0; i<fields.length; i++){
            EditText currentField = fields[i];
            if(currentField.getText().toString().length()<=0){
                return false;
            }
        }
        return true;
    }

    public void toasterMessage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

}
