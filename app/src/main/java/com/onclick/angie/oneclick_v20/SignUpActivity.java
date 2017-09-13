package com.onclick.angie.oneclick_v20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    EditText studentFName;
    EditText studentLName;
    EditText studentEmail;
    EditText studentUserName;
    EditText studentPass;
    EditText studentConfPass;

    DatabaseReference databaseStudents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        databaseStudents = FirebaseDatabase.getInstance().getReference("students");
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

                String fname = studentFName.getText().toString();
                String lname = studentLName.getText().toString();
                String email = studentEmail.getText().toString();
                String uname = studentUserName.getText().toString();
                String pass = studentPass.getText().toString();

                String id = databaseStudents.push().getKey();
                StudentInfo student = new StudentInfo(id, fname, lname, email, uname, pass);
                databaseStudents.child(id).setValue(student);
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
