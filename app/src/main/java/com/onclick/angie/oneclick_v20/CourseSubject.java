package com.onclick.angie.oneclick_v20;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CourseSubject extends AppCompatActivity {

    private static final String TAG = "COURSE_SUBJECT";
    public static final String vidIdKey = "h4VPgGqv4kk";

    private Toolbar toolbar;

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
        String crsId = bundle.getString("course_id");
        String crsTitle = bundle.getString("course_title");
        String crsVidId = bundle.getString("course_video");
        String crsDesc = bundle.getString("course_description");

        Log.d(TAG, "=========================> "+crsId+","+crsTitle+","+crsVidId+","+crsDesc);

        final YouTubeFragment fragment = (YouTubeFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_youtube);
        fragment.setVideoId(crsVidId);

        final TextView videoTitle = (TextView) findViewById(R.id.course_video_title);
        videoTitle.setText(crsTitle);

    }
}
