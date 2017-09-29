package com.onclick.angie.oneclick_v20;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    EditText studentFName;
    EditText studentLName;
    EditText studentEmail;
    EditText studentPass;
    EditText studentConfPass;

    ProgressBar progressBar;

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseStudents = FirebaseDatabase.getInstance().getReference("Students");

        studentFName = (EditText) findViewById(R.id.student_fname);
        studentLName = (EditText) findViewById(R.id.student_lname);
        studentEmail = (EditText) findViewById(R.id.student_email);

        studentPass = (EditText) findViewById(R.id.student_password);
        studentConfPass = (EditText) findViewById(R.id.student_confpassword);
    }

    public void studentSignUp(View view){

        boolean valid = validateForm(new EditText[] {studentFName, studentLName, studentEmail, studentPass, studentConfPass});

        if(valid){
            if(studentPass.getText().toString().equals(studentConfPass.getText().toString())){

                String email = studentEmail.getText().toString();
                String password = studentPass.getText().toString();

                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    String fname = studentFName.getText().toString();
                                    String lname = studentLName.getText().toString();
                                    String email = studentEmail.getText().toString();
                                    //Creates a unique id
                                    String id = databaseStudents.push().getKey();
                                    //Creates one student
                                    StudentInfo student = new StudentInfo(id, fname, lname, email);
                                    //Saves the student into Firebase database
                                    databaseStudents.child(id).setValue(student);
                                    toasterMessage("Successful Sign-Up!");
                                    finish();
                                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                }
                                else{
                                    toasterMessage("Could not sign-up. Please try again.");
                                }
                            }
                        });
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
