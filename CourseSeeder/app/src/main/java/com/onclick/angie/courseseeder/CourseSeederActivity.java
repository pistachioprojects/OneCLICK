package com.onclick.angie.courseseeder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CourseSeederActivity extends AppCompatActivity {

    EditText cTitle;
    EditText cDescription;
    EditText cImage;
    EditText cVideolink;
    EditText cEcount;
    Spinner cAvailability;

    DatabaseReference databaseCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_seeder);

        cTitle = (EditText) findViewById(R.id.crs_title);
        cDescription = (EditText) findViewById(R.id.crs_desc);
        cImage = (EditText) findViewById(R.id.crs_img);
        cVideolink = (EditText) findViewById(R.id.crs_vidlink);
        cEcount = (EditText) findViewById(R.id.crs_enrolcnt);
        cAvailability = (Spinner) findViewById(R.id.crs_avail);
    }

    public void seedGrade11(View view){

        databaseCourses = FirebaseDatabase.getInstance().getReference("grade11courses");

        String title = cTitle.getText().toString();
        String description = cDescription.getText().toString();
        String image = cImage.getText().toString();
        String vidlink = cVideolink.getText().toString();
        int enrolleecount = Integer.parseInt(cEcount.getText().toString());
        String availability = cAvailability.getSelectedItem().toString();

        String id = databaseCourses.push().getKey();

        CourseInfo course = new CourseInfo(id, title, description, image, vidlink, enrolleecount, availability);

        databaseCourses.child(id).setValue(course);

        toasterMessage("Successful!");
        clearText();
    }

    public void seedGrade12(View view){

        databaseCourses = FirebaseDatabase.getInstance().getReference("grade12courses");

        String title = cTitle.getText().toString();
        String description = cDescription.getText().toString();
        String image = cImage.getText().toString();
        String vidlink = cVideolink.getText().toString();
        int enrolleecount = Integer.parseInt(cEcount.getText().toString());
        String availability = cAvailability.getSelectedItem().toString();

        String id = databaseCourses.push().getKey();

        CourseInfo course = new CourseInfo(id, title, description, image, vidlink, enrolleecount, availability);

        databaseCourses.child(id).setValue(course);

        toasterMessage("Successful!");
        clearText();
    }

    public void clearText(){
        cTitle.setText("");
        cDescription.setText("");
        cImage.setText("");
        cVideolink.setText("");
        cEcount.setText("");
    }


    public void toasterMessage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
