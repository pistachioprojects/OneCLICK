package com.onclick.angie.oneclick_v20;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

public class CourseOutline extends AppCompatActivity {

    FirebaseLessonClient firebaseClient;

    TextView courseTitle;

    private RecyclerView lessonRecycler;
    private Toolbar toolbar;

    String dbChild11;
    String dbChild12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_outline);


        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        StudentDrawer drawerFragment = (StudentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_student_drawer);
        drawerFragment.setUp(R.id.fragment_student_drawer, (DrawerLayout) findViewById(R.id.student_drawer_layout), toolbar);


        final Bundle bundle = getIntent().getExtras();
        String crsId = bundle.getString("course_id");
        String crsBranch = bundle.getString("course_branch");
        String crsTitle = bundle.getString("course_title");


        courseTitle = (TextView) findViewById(R.id.course_title_of_lesson);
        courseTitle.setText(crsTitle);

        switch (crsBranch){
            case "CORE":
                dbChild11 = "Grade11_Course_Lessons_CORE";
                dbChild12 = "Grade12_Course_Lessons_CORE";
                break;
            case "ABM":
                dbChild11 = "Grade11_Course_Lessons_ABM";
                dbChild12 = "Grade12_Course_Lessons_ABM";
                break;
            case "HUMSS":
                dbChild11 = "Grade11_Course_Lessons_HUMSS";
                dbChild12 = "Grade12_Course_Lessons_HUMSS";
                break;
            case "STEM":
                dbChild11 = "Grade11_Course_Lessons_STEM";
                dbChild12 = "Grade12_Course_Lessons_STEM";
                break;
            case "GAS":
                dbChild11 = "Grade11_Course_Lessons_GAS";
                dbChild12 = "Grade12_Course_Lessons_GAS";
                break;
        }


        Log.d("COURSE OUTLINE", "=========================> "+crsId+", "+crsBranch+", "+dbChild11);

        lessonRecycler = (RecyclerView) findViewById(R.id.course_outline_recycler);
        lessonRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        firebaseClient = new FirebaseLessonClient(this, dbChild11, dbChild12, lessonRecycler, crsId);
        firebaseClient.refreshData();

    }
}
