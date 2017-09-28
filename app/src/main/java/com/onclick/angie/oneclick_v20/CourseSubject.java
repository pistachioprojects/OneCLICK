package com.onclick.angie.oneclick_v20;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class CourseSubject extends AppCompatActivity {

    private Toolbar toolbar;
    public static final String vidIdKey = "W4hTJybfU7s";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_subject);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        StudentDrawer drawerFragment = (StudentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_student_drawer);
        drawerFragment.setUp(R.id.fragment_student_drawer, (DrawerLayout) findViewById(R.id.student_drawer_layout), toolbar);


        final Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey(vidIdKey)) {
            final String videoId = bundle.getString(vidIdKey);
            final YouTubeFragment fragment = (YouTubeFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_youtube);
            fragment.setVideoId(videoId);
        }

    }
}
