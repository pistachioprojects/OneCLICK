package com.onclick.angie.oneclick_v20;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class StudentHome extends AppCompatActivity{

    FirebaseClient firebaseClient;
    private String dbChild;
    private RecyclerView grade11Recycler;
    private RecyclerView grade12Recycler;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        StudentDrawer drawerFragment = (StudentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_student_drawer);
        drawerFragment.setUp(R.id.fragment_student_drawer, (DrawerLayout) findViewById(R.id.student_drawer_layout), toolbar);

        grade11Recycler = (RecyclerView) findViewById(R.id.grade11_courses);
        grade11Recycler.setHasFixedSize(true);
        LinearLayoutManager tLinearLayout = new LinearLayoutManager(this);
        tLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        grade11Recycler.setLayoutManager(tLinearLayout);
        dbChild = "grade11courses";

        firebaseClient = new FirebaseClient(this, dbChild, grade11Recycler);
        firebaseClient.refreshData();


        grade12Recycler = (RecyclerView) findViewById(R.id.grade12_courses);
        grade12Recycler.setHasFixedSize(true);
        LinearLayoutManager nLinearLayout = new LinearLayoutManager(this);
        nLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        grade12Recycler.setLayoutManager(nLinearLayout);
        dbChild = "grade11courses";

        firebaseClient = new FirebaseClient(this, dbChild, grade12Recycler);
        firebaseClient.refreshData();
    }

    public void redirectGrade11 (View view){
        startActivity(new Intent(this, StudentGrade11.class));
    }

}
