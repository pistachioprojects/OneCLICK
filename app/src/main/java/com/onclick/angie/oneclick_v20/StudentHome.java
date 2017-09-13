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

public class StudentHome extends AppCompatActivity implements CourseItemAdapter.ClickListener {

    private RecyclerView grade11Recycler;
    private CourseItemAdapter grade11Adapter;

    private RecyclerView grade12Recycler;
    private CourseItemAdapter grade12Adapter;

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
        grade11Adapter = new CourseItemAdapter(this, getGrade11CourseData());
        grade11Adapter.setClickListenerGrade11(this);
        grade11Recycler.setAdapter(grade11Adapter);

        grade12Recycler = (RecyclerView) findViewById(R.id.grade12_courses);
        grade12Recycler.setHasFixedSize(true);
        LinearLayoutManager nLinearLayout = new LinearLayoutManager(this);
        nLinearLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
        grade12Recycler.setLayoutManager(nLinearLayout);
        grade12Adapter = new CourseItemAdapter(this, getGrade12CourseData());
        grade12Adapter.setClickListenerGrade12(this);
        grade12Recycler.setAdapter(grade12Adapter);
    }

    private List<CourseItem> getGrade11CourseData() {
        List<CourseItem> data = new ArrayList<>();
        int[] icons = {R.drawable.language, R.drawable.philosophy, R.drawable.science};
        String[] titles = {"Language", "Philosophy", "Science"};

        for (int i=0; i<titles.length && i<icons.length; i++) {
            CourseItem current = new CourseItem();
            current.imageId = icons[i];
            current.courseTitle = titles[i];
            data.add(current);
        }
        return data;
    }

    private List<CourseItem> getGrade12CourseData() {
        List<CourseItem> data = new ArrayList<>();
        int[] icons = {R.drawable.mathematics, R.drawable.social, R.drawable.pe};
        String[] titles = {"Mathematics", "Social Science", "PE & Health"};

        for (int i=0; i<titles.length && i<icons.length; i++) {
            CourseItem current = new CourseItem();
            current.imageId = icons[i];
            current.courseTitle = titles[i];
            data.add(current);
        }
        return data;
    }

    @Override
    public void itemClickGrade11(View view, int position) {
        if(position == 0){
            startActivity(new Intent(this, StudentGrade11.class));
        }
        else{
            startActivity(new Intent(this, StudentGrade11.class));
        }
    }

    @Override
    public void itemClickGrade12(View view, int position) {
        startActivity(new Intent(this, StudentHome.class));
    }

    public void redirectGrade11 (View view){
        startActivity(new Intent(this, StudentGrade11.class));
    }

}
