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

    /*EditText cTitle;
    EditText cDescription;
    EditText cImage;
    EditText cVideolink;
    EditText cEcount;
    Spinner cAvailability;*/

    String id;
    String title;
    String description;
    String image;
    String videoid;
    String availability;
    String branch;

    CourseInfo course;

    DatabaseReference databaseCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_seeder);

     /*   cTitle = (EditText) findViewById(R.id.crs_title);
        cDescription = (EditText) findViewById(R.id.crs_desc);
        cImage = (EditText) findViewById(R.id.crs_img);
        cVideolink = (EditText) findViewById(R.id.crs_vidlink);
        cEcount = (EditText) findViewById(R.id.crs_enrolcnt);
        cAvailability = (Spinner) findViewById(R.id.crs_avail); */
    }

    public void seedGrade11(View view){

        databaseCourses = FirebaseDatabase.getInstance().getReference("Grade11_Courses");

        /*String title = cTitle.getText().toString();
        String description = cDescription.getText().toString();
        String image = cImage.getText().toString();
        String vidlink = cVideolink.getText().toString();
        int enrolleecount = Integer.parseInt(cEcount.getText().toString());
        String availability = cAvailability.getSelectedItem().toString();*/

        id = databaseCourses.push().getKey();
        title = "Language";
        description = "This module develops the student's skill in English and Oral Communication";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/language.jpg?alt=media&token=4a77b10f-7192-4854-b543-ecd289971ff9";
        videoid = "3y-S-Ggp0BY";
        availability = "Offered this Semester";
        branch = "HUMSS";
        course = new CourseInfo(id, title, description, image, videoid, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Science";
        description = "This module discusses about General Science";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/science.jpg?alt=media&token=1cd3fbb0-5490-4caf-aab4-539dc67a9a6c";
        videoid = "T20RT0GgOB4";
        availability = "Offered this Semester";
        branch = "STEM";
        course = new CourseInfo(id, title, description, image, videoid, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Philosophy";
        description = "This module discusses about world philisophies";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/philosophy.jpg?alt=media&token=265a205a-1dff-4116-9b6f-a6d37dd713b2";
        videoid = "1A_CAkYt3GY";
        availability = "Offered this Semester";
        branch = "STEM";
        course = new CourseInfo(id, title, description, image, videoid, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "General Mathematics";
        description = "This module develops the student's logical skills in problem solving";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/mathematics.jpg?alt=media&token=05b745bc-9f6b-421c-ac46-195323f8a639";
        videoid = "osoVKtmHQpQ";
        availability = "Offered this Semester";
        branch = "STEM";
        course = new CourseInfo(id, title, description, image, videoid, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "PE & Health";
        description = "This module discusses about world philisophies";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/pe.jpg?alt=media&token=5082e6bd-9438-4236-bc57-a6969ae9cefc";
        videoid = "Yo3TRbkIrow";
        availability = "Not Offered this Semester";
        branch = "GAS";
        course = new CourseInfo(id, title, description, image, videoid, availability, branch);
        databaseCourses.child(id).setValue(course);


        toasterMessage("Successful!");
     //   clearText();
    }

    public void seedGrade12(View view){

        databaseCourses = FirebaseDatabase.getInstance().getReference("Grade12_Courses");

        /*String title = cTitle.getText().toString();
        String description = cDescription.getText().toString();
        String image = cImage.getText().toString();
        String vidlink = cVideolink.getText().toString();
        int enrolleecount = Integer.parseInt(cEcount.getText().toString());
        String availability = cAvailability.getSelectedItem().toString(); */

        id = databaseCourses.push().getKey();
        title = "Philosophy";
        description = "This module discusses about world philisophies";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/philosophy.jpg?alt=media&token=265a205a-1dff-4116-9b6f-a6d37dd713b2";
        videoid = "1A_CAkYt3GY";
        availability = "Not Offered this Semester";
        branch = "GAS";
        course = new CourseInfo(id, title, description, image, videoid, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Science";
        description = "This module discusses about General Science";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/science.jpg?alt=media&token=1cd3fbb0-5490-4caf-aab4-539dc67a9a6c";
        videoid = "T20RT0GgOB4";
        availability = "Offered this Semester";
        branch = "STEM";
        course = new CourseInfo(id, title, description, image, videoid, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "General Mathematics";
        description = "This module develops the student's logical skills in problem solving";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/mathematics.jpg?alt=media&token=05b745bc-9f6b-421c-ac46-195323f8a639";
        videoid = "osoVKtmHQpQ";
        availability = "Offered this Semester";
        branch = "STEM";
        course = new CourseInfo(id, title, description, image, videoid, availability, branch);
        databaseCourses.child(id).setValue(course);


        toasterMessage("Successful!");
    //    clearText();
    }
/*
    public void clearText(){
        cTitle.setText("");
        cDescription.setText("");
        cImage.setText("");
        cVideolink.setText("");
        cEcount.setText("");
    }
*/

    public void toasterMessage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
