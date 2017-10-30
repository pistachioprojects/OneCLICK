package com.onclick.angie.courseseeder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

    String lessonId;
    String lessonTitle;
    String lessonVideoId;
    String lessonParentId;
    int lessonNum;

    String parentCourse;

    CourseInfo course;
    LessonInfo lesson;

    DatabaseReference databaseCourses;
    DatabaseReference databaseLessons;


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
        title = "Oral Communication";
        description = "This module develops the student's skill in Speech Oral Communication";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fcommunication.png?alt=media&token=a89df465-fd26-4e10-9871-87747ef26b81";
        availability = "Offered this Semester";
        branch = "CORE";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Reading and Writing";
        description = "This module discusses about technical aspect of a write-up";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fhumanities.png?alt=media&token=9133b1e0-772a-42c9-b7ae-26124cf1771b";
        availability = "Offered this Semester";
        branch = "CORE";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Komunikasyon sa Filipino";
        description = "This module discusses about Filipino Culture and Language";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fcommunication.png?alt=media&token=a89df465-fd26-4e10-9871-87747ef26b81";
        availability = "Offered this Semester";
        branch = "CORE";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Pagbasa, Pananaliksik, at Pagsusuri ng Teksto";
        description = "This module discusses proper research method, and analysis on Filipino contents";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Facademics.png?alt=media&token=1b95277a-62c9-44df-950f-2d5168a1f451";
        availability = "Offered this Semester";
        branch = "CORE";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Contemporary Philippine Arts from the Regions";
        description = "This module discusses different types of art and their origin";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Farts.png?alt=media&token=1023a44c-8cc8-479c-bf19-345ddba2705d";
        availability = "Offered this Semester";
        branch = "CORE";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Media and Information Literacy";
        description = "This module discusses about information technology";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fcommunication.png?alt=media&token=a89df465-fd26-4e10-9871-87747ef26b81";
        availability = "Offered this Semester";
        branch = "CORE";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "General Mathematics";
        description = "This module develops the student's logical skills in problem solving";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fmathematics.png?alt=media&token=089737a2-733a-4303-863e-9c523c3aa3fa";
        availability = "Offered this Semester";
        branch = "CORE";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Earth and Life Science";
        description = "This module discusses about General Science";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fscience.png?alt=media&token=cb60013c-0fe9-4b67-af7d-a0ed916008f9";
        availability = "Offered this Semester";
        branch = "CORE";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Introduction to Philosophy of Human";
        description = "This module discusses about world philisophies";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fphilosophy.png?alt=media&token=f21327f8-7280-4234-9806-f6315cdf31eb";
        availability = "Offered this Semester";
        branch = "CORE";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "PE & Health";
        description = "This module discusses about health and sports";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fsports.png?alt=media&token=96265256-5c89-41a5-8a0c-36f0f5a98185";
        availability = "Offered this Semester";
        branch = "CORE";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Applied Economics";
        description = "This module develops economic mindset amongst student";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fmathematics.png?alt=media&token=089737a2-733a-4303-863e-9c523c3aa3fa";
        availability = "Offered this Semester";
        branch = "ABM";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Business Ethics and Social Responsibility";
        description = "This module discusses about ethics and develops social amongst student";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fsocscience.png?alt=media&token=5531b643-6f2a-4512-a1ed-e750d76993ff";
        availability = "Offered this Semester";
        branch = "ABM";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Fundamentals of ABM 1";
        description = "This module discusses the fundamental theories in Accountancy, Business and Management";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fmathematics.png?alt=media&token=089737a2-733a-4303-863e-9c523c3aa3fa";
        availability = "Offered this Semester";
        branch = "ABM";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Business Math";
        description = "This module develops the critical thinking in students when it comes to business";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fmathematics.png?alt=media&token=089737a2-733a-4303-863e-9c523c3aa3fa";
        availability = "Offered this Semester";
        branch = "ABM";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Introduction to World Religions and Belief Systems";
        description = "This module discusses about different religion in the world through time";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fsocscience.png?alt=media&token=5531b643-6f2a-4512-a1ed-e750d76993ff";
        availability = "Offered this Semester";
        branch = "HUMSS";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Philippine Politics and Governance";
        description = "This module discusses about politics, law, and other aspects of Philippine Government";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fsocscience.png?alt=media&token=5531b643-6f2a-4512-a1ed-e750d76993ff";
        availability = "Offered this Semester";
        branch = "HUMSS";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Disciplines and Ideas in the Social Science";
        description = "This module discusses about social science ideas";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fsocscience.png?alt=media&token=5531b643-6f2a-4512-a1ed-e750d76993ff";
        availability = "Offered this Semester";
        branch = "HUMSS";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Pre-Calculus";
        description = "This module develops the student's logical skills in problem solving in Pre-Calculus";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fmathematics.png?alt=media&token=089737a2-733a-4303-863e-9c523c3aa3fa";
        availability = "Offered this Semester";
        branch = "STEM";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Basic Calculus";
        description = "This module develops the student's logical skills in problem solving in Basic Calculus";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fmathematics.png?alt=media&token=089737a2-733a-4303-863e-9c523c3aa3fa";
        availability = "Offered this Semester";
        branch = "STEM";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "General Physics 1";
        description = "This module discusses about Physics";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fscience.png?alt=media&token=cb60013c-0fe9-4b67-af7d-a0ed916008f9";
        availability = "Offered this Semester";
        branch = "STEM";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "General Biology 1";
        description = "This module discusses about General Biology";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fscience.png?alt=media&token=cb60013c-0fe9-4b67-af7d-a0ed916008f9";
        availability = "Offered this Semester";
        branch = "STEM";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "General Chemistry 1";
        description = "This module discusses about Chemistry";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fscience.png?alt=media&token=cb60013c-0fe9-4b67-af7d-a0ed916008f9";
        availability = "Offered this Semester";
        branch = "STEM";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Humanities 1";
        description = "This module discusses general topics regarding Humanities";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fhumanities.png?alt=media&token=9133b1e0-772a-42c9-b7ae-26124cf1771b";
        availability = "Offered this Semester";
        branch = "GAS";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Applied Economics";
        description = "This module discusses about general topics in application of Economics";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Ftechvoc.png?alt=media&token=1761ea95-e0ac-43a5-9310-61b39f421ac3";
        availability = "Offered this Semester";
        branch = "GAS";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);


        toasterMessage("Successful!");
     //   clearText();
    }

    public void seedGrade11Lessons(View view) {
        databaseLessons = FirebaseDatabase.getInstance().getReference("Grade11_Course_Lessons_CORE");

        //ORAL COMMUNICATION ----------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Nature and Elements of Communication";
        lessonVideoId = "8jlWF1ufmMg";
        lessonParentId = "-KwYKKPFIbqYFrf3r3cf";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Functions of Communication";
        lessonVideoId = "MN8jyeqJHsc";
        lessonParentId = "-KwYKKPFIbqYFrf3r3cf";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Type of Speech";
        lessonVideoId = "vrQM6Oz2lwE";
        lessonParentId = "-KwYKKPFIbqYFrf3r3cf";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Type of Speech Style";
        lessonVideoId = "V8vReAUspSk";
        lessonParentId = "-KwYKKPFIbqYFrf3r3cf";
        lessonNum = 4;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Type of Speech Acts";
        lessonVideoId = "f2PJoe9Umxc";
        lessonParentId = "-KwYKKPFIbqYFrf3r3cf";
        lessonNum = 5;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Type of Communicative Strategy";
        lessonVideoId = "kh_EDOVSQOI";
        lessonParentId = "-KwYKKPFIbqYFrf3r3cf";
        lessonNum = 6;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        //READING AND WRITING ---------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Rules of Grammar";
        lessonVideoId = "JCwCaTHCm8Q";
        lessonParentId = "-KwYKKPLmbzaqHw5Y6B-";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Technical Writing";
        lessonVideoId = "eZm22PGDeVk";
        lessonParentId = "-KwYKKPLmbzaqHw5Y6B-";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Writing a Resume";
        lessonVideoId = "BCHi3vemjCQ";
        lessonParentId = "-KwYKKPLmbzaqHw5Y6B-";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);


        //KOMUNIKASYON SA FILIPINO ----------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Konseptong Pangwika";
        lessonVideoId = "PkW3c9lSRZI";
        lessonParentId = "-KwYKKPM1pAG-G6SenIP";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Gamit ng Wika sa Lipunan";
        lessonVideoId = "Akp4D6Kka7w";
        lessonParentId = "-KwYKKPM1pAG-G6SenIP";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Kasaysayan ng Wikang Pambansa";
        lessonVideoId = "URzOZGMEfyM";
        lessonParentId = "-KwYKKPM1pAG-G6SenIP";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        //PAGBASA, PANANALIKSIK, PAGSUSURI --------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Mga Uri ng Teksto";
        lessonVideoId = "Yk6ou-3cmNw";
        lessonParentId = "-KwYKKPOnZpKGUKgBsmo";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Pagbasa at Pagsusuri ng Teksto";
        lessonVideoId = "f3nYe-2zEfs";
        lessonParentId = "-KwYKKPOnZpKGUKgBsmo";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);


        //CONTEMPORARY PHILIPPINE ARTS ------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Contemporary Arts in the Philippines";
        lessonVideoId = "hK9FXUK1upc";
        lessonParentId = "-KwYKKPPAdEAJecYx5a5";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Contemporary Art Rules";
        lessonVideoId = "z74Bx6wqDdk";
        lessonParentId = "-KwYKKPPAdEAJecYx5a5";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        //MEDIA AND INFORMATION LITERACY ----------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Introduction to Media and Information Literacy";
        lessonVideoId = "b-Y6LRIppU4";
        lessonParentId = "-KwYKKPPAdEAJecYx5a6";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "The Evolution of Traditional to New Media";
        lessonVideoId = "wJkfKE-sZDg";
        lessonParentId = "-KwYKKPPAdEAJecYx5a6";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Information Literacy";
        lessonVideoId = "zfZsHtXwnVs";
        lessonParentId = "-KwYKKPPAdEAJecYx5a6";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Types of Media";
        lessonVideoId = "1y6a3HLPCnk";
        lessonParentId = "-KwYKKPPAdEAJecYx5a6";
        lessonNum = 4;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Media and Information Sources";
        lessonVideoId = "JmImdMvdpJ8";
        lessonParentId = "-KwYKKPPAdEAJecYx5a6";
        lessonNum = 5;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Media and Information Language";
        lessonVideoId = "8AOGcLKZHDk";
        lessonParentId = "-KwYKKPPAdEAJecYx5a6";
        lessonNum = 6;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Legal, Ethical, and Societal Issues in Media and Information";
        lessonVideoId = "7fqInW0F6mc";
        lessonParentId = "-KwYKKPPAdEAJecYx5a6";
        lessonNum = 7;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Opportunities, Challenges, and Power of Media and Information";
        lessonVideoId = "OetTq7QU7JE";
        lessonParentId = "-KwYKKPPAdEAJecYx5a6";
        lessonNum = 8;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "People Media";
        lessonVideoId = "am44z-TOPJI";
        lessonParentId = "-KwYKKPPAdEAJecYx5a6";
        lessonNum = 9;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = " Multimedia Information and Media";
        lessonVideoId = "0OBbEfVG0YA";
        lessonParentId = "-KwYKKPPAdEAJecYx5a6";
        lessonNum = 10;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);


        //GENERAL MATHEMATICS ---------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Functions and their Graphs";
        lessonVideoId = "ZZOSVxqlniI";
        lessonParentId = "-KwYKKPRtvUpJDHd4IMe";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Basic Business Mathematics";
        lessonVideoId = "ZWCXrbnMN-E";
        lessonParentId = "-KwYKKPRtvUpJDHd4IMe";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);


        //EARTH AND LIFE SCIENCE ------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Origin and Structure of the Earth";
        lessonVideoId = "VYJoQ5S5NnI";
        lessonParentId = "-KwYKKPSRaUa1AouDWxs";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Earth Materials and Systems";
        lessonVideoId = "EH1kat51jJY";
        lessonParentId = "-KwYKKPSRaUa1AouDWxs";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Natural Hazards, Mitigation, and Adaptation";
        lessonVideoId = "mZ8pqBQfebM";
        lessonParentId = "-KwYKKPSRaUa1AouDWxs";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Introduction to Life Science";
        lessonVideoId = "q_jaZuW0f30";
        lessonParentId = "-KwYKKPSRaUa1AouDWxs";
        lessonNum = 4;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Bioenergetics";
        lessonVideoId = "nDCxIpiI7-Y";
        lessonParentId = "-KwYKKPSRaUa1AouDWxs";
        lessonNum = 5;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "How Animals Survive";
        lessonVideoId = "EkHgJW7KWts";
        lessonParentId = "-KwYKKPSRaUa1AouDWxs";
        lessonNum = 6;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "How Plants Survive";
        lessonVideoId = "nHhTykvfucM";
        lessonParentId = "-KwYKKPSRaUa1AouDWxs";
        lessonNum = 7;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Process of Evolution";
        lessonVideoId = "hOfRN0KihOU";
        lessonParentId = "-KwYKKPSRaUa1AouDWxs";
        lessonNum = 8;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);


        //INTRODUCTION TO PHILOSOPHY --------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Doing Philosophy";
        lessonVideoId = "wxk97DpKI";
        lessonParentId = "-KwYKKPSRaUa1AouDWxt";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Methods of Philosophizing";
        lessonVideoId = "n_ucYeG2axI";
        lessonParentId = "-KwYKKPSRaUa1AouDWxt";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Freedom of the Human Person";
        lessonVideoId = "XwLJLQy84zw";
        lessonParentId = "-KwYKKPSRaUa1AouDWxt";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Human Person in Society";
        lessonVideoId = "O7fTTESFA58";
        lessonParentId = "-KwYKKPSRaUa1AouDWxt";
        lessonNum = 4;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);


        //PE AND HEALTH ---------------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Aerobic and Anaerobic Exercise";
        lessonVideoId = "FSJLQ-GtJM4";
        lessonParentId = "-KwYKKPTb4Pzzz_bpcbj";//T
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Muscle and Bone Strengthening Activities";
        lessonVideoId = "kIdDyjfEHaQ";
        lessonParentId = "-KwYKKPTb4Pzzz_bpcbj";//T
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        toasterMessage("Successful Seeding Lessons!");

    }

    public void seedGrade11LessonsAbm(View view){
        databaseLessons = FirebaseDatabase.getInstance().getReference("Grade11_Course_Lessons_ABM");

        //APPLIED ECONOMICS ----------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Introduction to Applied Economics";
        lessonVideoId = "0Yf4fPBOKI4";
        lessonParentId = "-KwYKKPUIRA5Qd2JPsWX";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Applications of Supply and Demand";
        lessonVideoId = "AOkbX865WuY";
        lessonParentId = "-KwYKKPUIRA5Qd2JPsWX";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Types of Industries";
        lessonVideoId = "vUpcFc9ST-w";
        lessonParentId = "-KwYKKPUIRA5Qd2JPsWX";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Identification of Business Opportunities";
        lessonVideoId = "g5mz7WISg10";
        lessonParentId = "-KwYKKPUIRA5Qd2JPsWX";
        lessonNum = 4;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);


        //BUSINESS ETHICS AND SOCIAL RESPONSIBILITIES ---------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "The Role of Business in Social and Economic Development";
        lessonVideoId = "WMWNjqn_mck";
        lessonParentId = "-KwYKKPV2pmS-sVagXXQ";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = " Foundations of the Principles of Business Ethics";
        lessonVideoId = "xoE8XlcDUI8";
        lessonParentId = "-KwYKKPV2pmS-sVagXXQ";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = " Social Responsibility of Entrepreneurs";
        lessonVideoId = "CiOHT619uj0";
        lessonParentId = "-KwYKKPV2pmS-sVagXXQ";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = " Business Beyond Profit Motivation";
        lessonVideoId = "9VVNtUy7IpE";
        lessonParentId = "-KwYKKPV2pmS-sVagXXQ";
        lessonNum = 4;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);


        //FUNDAMENTALS OF ABM 1 -------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Introduction to Accounting";
        lessonVideoId = "i751_tkcu4I";
        lessonParentId = "-KwYKKPWpmVf1ajBJU07";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Branches of Accounting";
        lessonVideoId = "COdajaa6WKs";
        lessonParentId = "-KwYKKPWpmVf1ajBJU07";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Users of Accounting Information";
        lessonVideoId = "O6clb2SEOTc";
        lessonParentId = "-KwYKKPWpmVf1ajBJU07";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Forms of Business Organizations";
        lessonVideoId = "nzRi-I1MYHw";
        lessonParentId = "-KwYKKPWpmVf1ajBJU07";
        lessonNum = 4;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Accounting Concepts and Principles";
        lessonVideoId = "3BvcVqfdC1k";
        lessonParentId = "-KwYKKPWpmVf1ajBJU07";
        lessonNum = 5;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "The Accounting Equation";
        lessonVideoId = "XvoE0sjixaA";
        lessonParentId = "-KwYKKPWpmVf1ajBJU07";
        lessonNum = 6;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);


        //BUSINESS MATH ---------------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Ratio and Proportion";
        lessonVideoId = "7qm234LL6tA";
        lessonParentId = "-KwYKKPXKqovg9qx6tWi";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Salaries and Wages";
        lessonVideoId = "eRq09mcQaV4";
        lessonParentId = "-KwYKKPXKqovg9qx6tWi";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        toasterMessage("Successful Seeding Lessons!");
    }

    public void seedGrade11LessonsHumss(View view){
        databaseLessons = FirebaseDatabase.getInstance().getReference("Grade11_Course_Lessons_HUMSS");


        //INTRODUCTION TO WORLD RELIGIONS AND BELIEF SYSTEMS --------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "How World Religions Began";
        lessonVideoId = "V9mFNgu6Cww";
        lessonParentId = "-KwYKKPYDyGQKdOsS9Xn";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Positive and Negative Effect of Religions";
        lessonVideoId = "GK80cowNIKw";
        lessonParentId = "-KwYKKPYDyGQKdOsS9Xn";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Judaism";
        lessonVideoId = "PWsKZ2Xto4Y";
        lessonParentId = "-KwYKKPYDyGQKdOsS9Xn";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Christianity";
        lessonVideoId = "0XceOxLsGzg";
        lessonParentId = "-KwYKKPYDyGQKdOsS9Xn";
        lessonNum = 4;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Islam";
        lessonVideoId = "8S_Tw6jA77E";
        lessonParentId = "-KwYKKPYDyGQKdOsS9Xn";
        lessonNum = 5;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Hinduism";
        lessonVideoId = "IGV6M4wQ8Os";
        lessonParentId = "-KwYKKPYDyGQKdOsS9Xn";
        lessonNum = 6;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Buddhism";
        lessonVideoId = "eYKdEnEqfQQ";
        lessonParentId = "-KwYKKPYDyGQKdOsS9Xn";
        lessonNum = 7;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Taoism";
        lessonVideoId = "KcQcwPAiMwI";
        lessonParentId = "-KwYKKPYDyGQKdOsS9Xn";
        lessonNum = 8;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);


        //PHILIPPINE POLITICS AND GOVERNANCE ------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Political Ideologies";
        lessonVideoId = "KYOKtvMOpLA";
        lessonParentId = "-KwYKKPZ2gi2TElZG5sL";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "States, Nations, and Globalization";
        lessonVideoId = "Nm8z9FotntM";
        lessonParentId = "-KwYKKPZ2gi2TElZG5sL";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Historical Background of Philippine Democratic Politics";
        lessonVideoId = "Cepc_J5S86A";
        lessonParentId = "-KwYKKPZ2gi2TElZG5sL";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "The Executive";
        lessonVideoId = "FWYQJbhzwiM";
        lessonParentId = "-KwYKKPZ2gi2TElZG5sL";
        lessonNum = 4;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "The Legislative";
        lessonVideoId = "Kjx31ZTpjV0";
        lessonParentId = "-KwYKKPZ2gi2TElZG5sL";
        lessonNum = 5;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "The Judiciary";
        lessonVideoId = "HnfQ6H2S55E";
        lessonParentId = "-KwYKKPZ2gi2TElZG5sL";
        lessonNum = 6;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Decentralization and Local Governance";
        lessonVideoId = "19tFfvuhLEU";
        lessonParentId = "-KwYKKPZ2gi2TElZG5sL";
        lessonNum = 7;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Elections and Political Parties";
        lessonVideoId = "-XlUICruITE";
        lessonParentId = "-KwYKKPZ2gi2TElZG5sL";
        lessonNum = 8;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Citizenship";
        lessonVideoId = "U-NQVRGVkbI";
        lessonParentId = "-KwYKKPZ2gi2TElZG5sL";
        lessonNum = 9;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Integration";
        lessonVideoId = "JLGd3hASl1s";
        lessonParentId = "-KwYKKPZ2gi2TElZG5sL";
        lessonNum = 10;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);


        //DISCIPLINES AND IDEAS IN THE SOCIAL SCIENCES --------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Emergence of the Social Science";
        lessonVideoId = "DSIdaTSG2Gg";
        lessonParentId = "-KwYKKP_OX3EwC1OBZ47";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Indigenizing the Social Sciences";
        lessonVideoId = "sQGLFHj6ZhM";
        lessonParentId = "-KwYKKP_OX3EwC1OBZ47";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        toasterMessage("Successful Seeding Lessons!");

    }

    public void seedGrade11LessonsStem(View view){
        databaseLessons = FirebaseDatabase.getInstance().getReference("Grade11_Course_Lessons_STEM");

        //PRE-CALCULUS ----------------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Analytic Geometry";
        lessonVideoId = "Re0s1NPZ4ek";
        lessonParentId = "-KwYKKP_OX3EwC1OBZ48";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Series and Mathematical Induction";
        lessonVideoId = "wblW_M_HVQ8";
        lessonParentId = "-KwYKKP_OX3EwC1OBZ48";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Trigonometry";
        lessonVideoId = "F21S9Wpi0y8";
        lessonParentId = "-KwYKKP_OX3EwC1OBZ48";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        //BASIC CALCULUS --------------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Limits and Continuity";
        lessonVideoId = "kdEQGfeC0SE";
        lessonParentId = "-KwYKKPaDX7I4DyPaSP_";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Derivatives";
        lessonVideoId = "FLGRPYAtReo";
        lessonParentId = "-KwYKKPaDX7I4DyPaSP_";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Integration";
        lessonVideoId = "rfG8ce4nNh0";
        lessonParentId = "-KwYKKPaDX7I4DyPaSP_";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        //GENERAL PHYSICS 1 -----------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Vectors";
        lessonVideoId = "ml4NSzCQobk";
        lessonParentId = "-KwYKKPaDX7I4DyPaSPa";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Kinematics: Motion Along a Straight Line";
        lessonVideoId = "EhsEIRAImM8";
        lessonParentId = "-KwYKKPaDX7I4DyPaSPa";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Kinematics: Motion in 2- Dimensions and 3- Dimensions";
        lessonVideoId = "h9Ipz-7rKu0";
        lessonParentId = "-KwYKKPaDX7I4DyPaSPa";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Newton’s Laws of Motion and Applications";
        lessonVideoId = "kKKM8Y-u7ds";
        lessonParentId = "-KwYKKPaDX7I4DyPaSPa";
        lessonNum = 4;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Work, Energy, and Energy Conservation";
        lessonVideoId = "kw_4Loo1HR4";
        lessonParentId = "-KwYKKPaDX7I4DyPaSPa";
        lessonNum = 5;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Center of Mass, Momentum, Impulse, and Collisions";
        lessonVideoId = "VrflZifKIuw";
        lessonParentId = "-KwYKKPaDX7I4DyPaSPa";
        lessonNum = 6;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Gravity";
        lessonVideoId = "Xcel427Ezl0";
        lessonParentId = "-KwYKKPaDX7I4DyPaSPa";
        lessonNum = 7;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Periodic Motion ";
        lessonVideoId = "D6oVrp2QTKM";
        lessonParentId = "-KwYKKPaDX7I4DyPaSPa";
        lessonNum = 8;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Mechanical Waves and Sound";
        lessonVideoId = "c38H6UKt3_I";
        lessonParentId = "-KwYKKPaDX7I4DyPaSPa";
        lessonNum = 9;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Fluid Mechanics";
        lessonVideoId = "5JG_P6ixaaE";
        lessonParentId = "-KwYKKPaDX7I4DyPaSPa";
        lessonNum = 10;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Temperature and Heat";
        lessonVideoId = "LL54E5CzQ-A";
        lessonParentId = "-KwYKKPaDX7I4DyPaSPa";
        lessonNum = 11;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);


        //GENERAL BIOLOGY 1 -----------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Cell";
        lessonVideoId = "8IlzKri08kk";
        lessonParentId = "-KwYKKPcZ4AMf0AJ5KkR";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Biological Molecules";
        lessonVideoId = "FgfknBZaVTI";
        lessonParentId = "-KwYKKPcZ4AMf0AJ5KkR";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Energy Transformation";
        lessonVideoId = "-8atIc3XixY";
        lessonParentId = "-KwYKKPcZ4AMf0AJ5KkR";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        //GENERAL CHEMISTRY 1 ---------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Matter and its Properties";
        lessonVideoId = "AR_F7IGgjkM";
        lessonParentId = "-KwYKKPdEGCrNem-uDHk";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Measurements";
        lessonVideoId = "pFl49nIGQF8";
        lessonParentId = "-KwYKKPdEGCrNem-uDHk";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Atoms, Molecules, and Ions";
        lessonVideoId = "pSJeMJaCkVU";
        lessonParentId = "-KwYKKPdEGCrNem-uDHk";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Stoichiometry";
        lessonVideoId = "SjQG3rKSZUQ";
        lessonParentId = "-KwYKKPdEGCrNem-uDHk";
        lessonNum = 4;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Gases";
        lessonVideoId = "gmN2fRlQFp4";
        lessonParentId = "-KwYKKPdEGCrNem-uDHk";
        lessonNum = 5;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Electronic Structure of Atoms";
        lessonVideoId = "yBrp8uvNAhI";
        lessonParentId = "-KwYKKPdEGCrNem-uDHk";
        lessonNum = 6;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Electronic Structure and Periodicity";
        lessonVideoId = "2AFPfg0Como";
        lessonParentId = "-KwYKKPdEGCrNem-uDHk";
        lessonNum = 7;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Chemical Bonding: Ionic Bonds";
        lessonVideoId = "DEdRcfyYnSQ";
        lessonParentId = "-KwYKKPdEGCrNem-uDHk";
        lessonNum = 8;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Chemical Bonding: Covalent Bonds";
        lessonVideoId = "LkAykOv1foc";
        lessonParentId = "-KwYKKPdEGCrNem-uDHk";
        lessonNum = 9;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Organic Compounds";
        lessonVideoId = "0WAV47hsCpY";
        lessonParentId = "-KwYKKPdEGCrNem-uDHk";
        lessonNum = 10;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        toasterMessage("Successful Seeding Lessons!");
    }

    public void seedGrade11LessonsGas(View view){
        databaseLessons = FirebaseDatabase.getInstance().getReference("Grade11_Course_Lessons_GAS");

        //HUMANITIES 1 ----------------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Introduction to Humanities";
        lessonVideoId = "oZjiraM3vSs";
        lessonParentId = "-KwYKKPdEGCrNem-uDHl";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        //APPLIED ECONOMICS -----------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Introduction to Economics";
        lessonVideoId = "8JYP_wU1JTU";
        lessonParentId = "-KwYKKPf5_djXOygwFNO";//T
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        toasterMessage("Successful Seeding Lessons!");

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
        title = "Personal Development";
        description = "This module discusses about personal development.";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fsports.png?alt=media&token=96265256-5c89-41a5-8a0c-36f0f5a98185";
        availability = "Offered this Semester";
        branch = "CORE";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);


        id = databaseCourses.push().getKey();
        title = "Understanding Culture, Society, and Politics";
        description = "This module discusses about social sciences.";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fsocscience.png?alt=media&token=5531b643-6f2a-4512-a1ed-e750d76993ff";
        availability = "Offered this Semester";
        branch = "CORE";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Earth Science";
        description = "This module discusses about earth science";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fscience.png?alt=media&token=cb60013c-0fe9-4b67-af7d-a0ed916008f9";
        availability = "Offered this Semester";
        branch = "CORE";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Disaster Readiness and Risk Reduction";
        description = "This module develops the student's readiness in calamities.";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Ftechvoc.png?alt=media&token=1761ea95-e0ac-43a5-9310-61b39f421ac3";
        availability = "Offered this Semester";
        branch = "CORE";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Organization and Management";
        description = "This module develops the student's business organization.";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fsocscience.png?alt=media&token=5531b643-6f2a-4512-a1ed-e750d76993ff";
        availability = "Offered this Semester";
        branch = "ABM";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Principles of Marketing";
        description = "This module discusses about the principles of marketing.";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fmathematics.png?alt=media&token=089737a2-733a-4303-863e-9c523c3aa3fa";
        availability = "Offered this Semester";
        branch = "ABM";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "Disciplines and Ideas in the Applied Social Sciences";
        description = "This module discusses about the ideas in applied social sciences.";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fsocscience.png?alt=media&token=5531b643-6f2a-4512-a1ed-e750d76993ff";
        availability = "Offered this Semester";
        branch = "HUMSS";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "General Biology 2";
        description = "This module discusses deeper about Biology.";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fscience.png?alt=media&token=cb60013c-0fe9-4b67-af7d-a0ed916008f9";
        availability = "Offered this Semester";
        branch = "STEM";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "General Physics 2";
        description = "This module discusses deeper about Physics.";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fscience.png?alt=media&token=cb60013c-0fe9-4b67-af7d-a0ed916008f9";
        availability = "Offered this Semester";
        branch = "STEM";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);

        id = databaseCourses.push().getKey();
        title = "General Chemistry 2";
        description = "This module discusses deeper about Chemistry.";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fscience.png?alt=media&token=cb60013c-0fe9-4b67-af7d-a0ed916008f9";
        availability = "Offered this Semester";
        branch = "STEM";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);
        toasterMessage("Successful!");


        id = databaseCourses.push().getKey();
        title = "Humanities 2";
        description = "This module discusses deeper about Humanities.";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fhumanities.png?alt=media&token=9133b1e0-772a-42c9-b7ae-26124cf1771b";
        availability = "Offered this Semester";
        branch = "GAS";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);
        toasterMessage("Successful!");

        id = databaseCourses.push().getKey();
        title = "Social Science 1";
        description = "This module discusses about basics of Social Science.";
        image = "https://firebasestorage.googleapis.com/v0/b/oneclick-2ca2a.appspot.com/o/Course_Icons%2Fsocscience.png?alt=media&token=5531b643-6f2a-4512-a1ed-e750d76993ff";
        availability = "Offered this Semester";
        branch = "GAS";
        course = new CourseInfo(id, title, description, image, availability, branch);
        databaseCourses.child(id).setValue(course);
        toasterMessage("Successful!");
        //    clearText();
    }

    public void seedGrade12Lessons(View view) {
        databaseLessons = FirebaseDatabase.getInstance().getReference("Grade12_Course_Lessons_CORE");

        //PERSONAL DEVELOPMENT --------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Knowing Oneself";
        lessonVideoId = "7LsSXeyHgEE";
        lessonParentId = "-KxVxwOijZ_9Nn_pESZx";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Developing the Whole Person";
        lessonVideoId = "aQidnt85xcw";
        lessonParentId = "-KxVxwOijZ_9Nn_pESZx";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Developmental Stages in Middle and Late Adolescence";
        lessonVideoId = "gcMCtOJCkCE";
        lessonParentId = "-KxVxwOijZ_9Nn_pESZx";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "The Powers of the Mind";
        lessonVideoId = "sp3U8kj86TM";
        lessonParentId = "-KxVxwOijZ_9Nn_pESZx";
        lessonNum = 4;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Emotional Intelligence";
        lessonVideoId = "LgUCyWhJf6s";
        lessonParentId = "-KxVxwOijZ_9Nn_pESZx";
        lessonNum = 5;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Personal Relationships";
        lessonVideoId = "nFWXNcGo5V8";
        lessonParentId = "-KxVxwOijZ_9Nn_pESZx";
        lessonNum = 6;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Family Structures and Legacies";
        lessonVideoId = "yHvaKv9N0VE";
        lessonParentId = "-KxVxwOijZ_9Nn_pESZx";
        lessonNum = 7;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        //UNDERSTANDING CULTURE, SOCIETY, AND POLITICS --------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Starting Points for the Understanding of Culture, Society, and Politics";
        lessonVideoId = "Abl5apX3Ex4";
        lessonParentId = "-KxVxwOpTQ-Nf1Qt656d";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Defining Culture and Society from the Perspectives of Anthropology and Sociology";
        lessonVideoId = "VpiIlemQK8o";
        lessonParentId = "-KxVxwOpTQ-Nf1Qt656d";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Looking back at Human Biocultural and Social Evolution";
        lessonVideoId = "xlmruDxY48Y";
        lessonParentId = "-KxVxwOpTQ-Nf1Qt656d";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "How Society is Organized";
        lessonVideoId = "rkL3T-mjjho";
        lessonParentId = "-KxVxwOpTQ-Nf1Qt656d";
        lessonNum = 4;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Cultural, Social and Political Institutions";
        lessonVideoId = "iUVxCw_9z2U";
        lessonParentId = "-KxVxwOpTQ-Nf1Qt656d";
        lessonNum = 5;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Social and Political Stratification";
        lessonVideoId = "ja6MPh088II";
        lessonParentId = "-KxVxwOpTQ-Nf1Qt656d";
        lessonNum = 6;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        //EARTH SCIENCE ---------------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Origin and Structure of the Earth";
        lessonVideoId = "VYJoQ5S5NnI";
        lessonParentId = "-KxVxwOqkDbXRwzt2V50";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Earth Materials and Systems";
        lessonVideoId = "EH1kat51jJY";
        lessonParentId = "-KxVxwOqkDbXRwzt2V50";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Natural Hazards, Mitigation, and Adaptation";
        lessonVideoId = "mZ8pqBQfebM";
        lessonParentId = "-KxVxwOqkDbXRwzt2V50";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        //DISASTER READINESS AND RISK REDUCTION ---------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Basic Concept of Disaster and Disaster Risk";
        lessonVideoId = "y16aMLeh91Q";
        lessonParentId = "-KxVxwOrq2WYDm0ZTAcs";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Exposure and Vulnerability";
        lessonVideoId = "ypmiQLLS8sE";
        lessonParentId = "-KxVxwOrq2WYDm0ZTAcs";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Basic Concept of Hazard";
        lessonVideoId = "-jUp_zsKp7k";
        lessonParentId = "-KxVxwOrq2WYDm0ZTAcs";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Earthquake Hazards";
        lessonVideoId = "Py9k7dacoKo";
        lessonParentId = "-KxVxwOrq2WYDm0ZTAcs";
        lessonNum = 4;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Volcano Hazards";
        lessonVideoId = "BCm6xTZj-vk";
        lessonParentId = "-KxVxwOrq2WYDm0ZTAcs";
        lessonNum = 5;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Hydro Meteorological Hazards";
        lessonVideoId = "lzDyI_VhGy0";
        lessonParentId = "-KxVxwOrq2WYDm0ZTAcs";
        lessonNum = 6;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Fire Hazard";
        lessonVideoId = "8hNegmLacMc";
        lessonParentId = "-KxVxwOrq2WYDm0ZTAcs";
        lessonNum = 7;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Concept of Disaster Risk Reduction (DRR) and Disaster Risk Reduction and Management (DRRM)";
        lessonVideoId = "D4cDePpQUrM";
        lessonParentId = "-KxVxwOrq2WYDm0ZTAcs";
        lessonNum = 8;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        toasterMessage("Successful Seeding Lessons!");

    }

    public void seedGrade12LessonsAbm(View view){
        databaseLessons = FirebaseDatabase.getInstance().getReference("Grade12_Course_Lessons_ABM");

        //ORGANIZATION AND MANAGEMENT -------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Nature and Concept of Management";
        lessonVideoId = "gZCnsMV0p-4";
        lessonParentId = "-KxVxwOtFOiOJ4aB2nhJ";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "The Firm and Its Environment";
        lessonVideoId = "MB3PJubQdro";
        lessonParentId = "-KxVxwOtFOiOJ4aB2nhJ";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Planning";
        lessonVideoId = "k2oZ-vPg3Pg";
        lessonParentId = "-KxVxwOtFOiOJ4aB2nhJ";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Organizing";
        lessonVideoId = "3yVsOSbbPhc";
        lessonParentId = "-KxVxwOtFOiOJ4aB2nhJ";
        lessonNum = 4;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Staffing";
        lessonVideoId = "s4JYhIAt8iE";
        lessonParentId = "-KxVxwOtFOiOJ4aB2nhJ";
        lessonNum = 5;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Leading";
        lessonVideoId = "YeutF6puazw";
        lessonParentId = "-KxVxwOtFOiOJ4aB2nhJ";
        lessonNum = 6;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Controlling";
        lessonVideoId = "J_TqI2PqF8g";
        lessonParentId = "-KxVxwOtFOiOJ4aB2nhJ";
        lessonNum = 7;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Introduction to the Different Functional Areas of Management";
        lessonVideoId = "JH4srpPMgAc";
        lessonParentId = "-KxVxwOtFOiOJ4aB2nhJ";
        lessonNum = 8;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        //PRINCIPLES OF MARKETING -----------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Marketing Principles and Strategies";
        lessonVideoId = "hZLMv5aexto";
        lessonParentId = "-KxVxwOuppV0XfaQgNpf";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Customer Relationship: Customer Service";
        lessonVideoId = "PKoZbFN4KSY";
        lessonParentId = "-KxVxwOuppV0XfaQgNpf";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Market Opportunity Analysis and Consumer Analysis";
        lessonVideoId = "CHh49_ZtY8I";
        lessonParentId = "-KxVxwOuppV0XfaQgNpf";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Developing the Marketing Mix";
        lessonVideoId = "7SSu0KtXI2c";
        lessonParentId = "-KxVxwOuppV0XfaQgNpf";
        lessonNum = 4;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Managing the Marketing Effort (The Marketing Process)";
        lessonVideoId = "xyb5Edfpw5U";
        lessonParentId = "-KxVxwOuppV0XfaQgNpf";
        lessonNum = 5;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        toasterMessage("Successful Seeding Lessons!");
    }

    public void seedGrade12LessonsHumss(View view){
        databaseLessons = FirebaseDatabase.getInstance().getReference("Grade12_Course_Lessons_HUMSS");


        //DISCIPLINES AND IDEAS IN APPLIED SOCIAL SCIENCES ----------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Counseling";
        lessonVideoId = "xrC9HYYaTz4";
        lessonParentId = "-KxVxwOuppV0XfaQgNpg";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Social Work";
        lessonVideoId = "oKbj3y-LUbw";
        lessonParentId = "-KxVxwOuppV0XfaQgNpg";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Communication";
        lessonVideoId = "S7CN9Trw43w";
        lessonParentId = "-KxVxwOuppV0XfaQgNpg";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Importance of Social Sciences";
        lessonVideoId = "r78sZTAhYbE";
        lessonParentId = "-KxVxwOuppV0XfaQgNpg";
        lessonNum = 4;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);


        toasterMessage("Successful Seeding Lessons!");

    }

    public void seedGrade12LessonsStem(View view){
        databaseLessons = FirebaseDatabase.getInstance().getReference("Grade12_Course_Lessons_STEM");


        //GENERAL PHYSICS 2 -----------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Vectors";
        lessonVideoId = "ml4NSzCQobk";
        lessonParentId = "-KxVxwOwa9LYdN1uS7fv";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Kinematics: Motion Along a Straight Line";
        lessonVideoId = "EhsEIRAImM8";
        lessonParentId = "-KxVxwOwa9LYdN1uS7fv";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Kinematics: Motion in 2- Dimensions and 3- Dimensions";
        lessonVideoId = "h9Ipz-7rKu0";
        lessonParentId = "-KxVxwOwa9LYdN1uS7fv";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Newton’s Laws of Motion and Applications";
        lessonVideoId = "kKKM8Y-u7ds";
        lessonParentId = "-KxVxwOwa9LYdN1uS7fv";
        lessonNum = 4;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Work, Energy, and Energy Conservation";
        lessonVideoId = "kw_4Loo1HR4";
        lessonParentId = "-KxVxwOwa9LYdN1uS7fv";
        lessonNum = 5;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Center of Mass, Momentum, Impulse, and Collisions";
        lessonVideoId = "VrflZifKIuw";
        lessonParentId = "-KxVxwOwa9LYdN1uS7fv";
        lessonNum = 6;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Gravity";
        lessonVideoId = "Xcel427Ezl0";
        lessonParentId = "-KxVxwOwa9LYdN1uS7fv";
        lessonNum = 7;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Periodic Motion ";
        lessonVideoId = "D6oVrp2QTKM";
        lessonParentId = "-KxVxwOwa9LYdN1uS7fv";
        lessonNum = 8;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Mechanical Waves and Sound";
        lessonVideoId = "c38H6UKt3_I";
        lessonParentId = "-KxVxwOwa9LYdN1uS7fv";
        lessonNum = 9;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Fluid Mechanics";
        lessonVideoId = "5JG_P6ixaaE";
        lessonParentId = "-KxVxwOwa9LYdN1uS7fv";
        lessonNum = 10;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Temperature and Heat";
        lessonVideoId = "LL54E5CzQ-A";
        lessonParentId = "-KxVxwOwa9LYdN1uS7fv";
        lessonNum = 11;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);


        //GENERAL BIOLOGY 2 -----------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Cell";
        lessonVideoId = "8IlzKri08kk";
        lessonParentId = "-KxVxwOvQTAYQQFGoeoQ";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Biological Molecules";
        lessonVideoId = "FgfknBZaVTI";
        lessonParentId = "-KxVxwOvQTAYQQFGoeoQ";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Energy Transformation";
        lessonVideoId = "-8atIc3XixY";
        lessonParentId = "-KxVxwOvQTAYQQFGoeoQ";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        //GENERAL CHEMISTRY 2 ---------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Matter and its Properties";
        lessonVideoId = "AR_F7IGgjkM";
        lessonParentId = "-KxVxwOx83FcnBih_Idm";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Measurements";
        lessonVideoId = "pFl49nIGQF8";
        lessonParentId = "-KxVxwOx83FcnBih_Idm";
        lessonNum = 2;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Atoms, Molecules, and Ions";
        lessonVideoId = "pSJeMJaCkVU";
        lessonParentId = "-KxVxwOx83FcnBih_Idm";
        lessonNum = 3;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Stoichiometry";
        lessonVideoId = "SjQG3rKSZUQ";
        lessonParentId = "-KxVxwOx83FcnBih_Idm";
        lessonNum = 4;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Gases";
        lessonVideoId = "gmN2fRlQFp4";
        lessonParentId = "-KxVxwOx83FcnBih_Idm";
        lessonNum = 5;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Electronic Structure of Atoms";
        lessonVideoId = "yBrp8uvNAhI";
        lessonParentId = "-KxVxwOx83FcnBih_Idm";
        lessonNum = 6;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Electronic Structure and Periodicity";
        lessonVideoId = "2AFPfg0Como";
        lessonParentId = "-KxVxwOx83FcnBih_Idm";
        lessonNum = 7;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Chemical Bonding: Ionic Bonds";
        lessonVideoId = "DEdRcfyYnSQ";
        lessonParentId = "-KxVxwOx83FcnBih_Idm";
        lessonNum = 8;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Chemical Bonding: Covalent Bonds";
        lessonVideoId = "LkAykOv1foc";
        lessonParentId = "-KxVxwOx83FcnBih_Idm";
        lessonNum = 9;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Organic Compounds";
        lessonVideoId = "0WAV47hsCpY";
        lessonParentId = "-KxVxwOx83FcnBih_Idm";
        lessonNum = 10;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        toasterMessage("Successful Seeding Lessons!");
    }

    public void seedGrade12LessonsGas(View view){
        databaseLessons = FirebaseDatabase.getInstance().getReference("Grade12_Course_Lessons_GAS");

        //HUMANITIES 2 ----------------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Introduction to Humanities 2";
        lessonVideoId = "oZjiraM3vSs";
        lessonParentId = "-KxVxwPStGm_NwUAzu6y";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        //SOCIAL SCIENCE 1 -----------------------------------------------------------------------

        lessonId = databaseLessons.push().getKey();
        lessonTitle = "Introduction to Social Science 1";
        lessonVideoId = "r78sZTAhYbE";
        lessonParentId = "-KxVxwPU8HG_Ij0Q5R2i";
        lessonNum = 1;
        lesson = new LessonInfo(lessonId, lessonTitle, lessonVideoId, lessonParentId, lessonNum);
        databaseLessons.child(lessonId).setValue(lesson);

        toasterMessage("Successful Seeding Lessons!");

    }


    public void toasterMessage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
