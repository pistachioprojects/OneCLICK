package com.onclick.angie.oneclick_v20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angie on 9/10/2017.
 */

public class StudentDrawer extends Fragment implements CustomDrawerAdapter.ClickListener {

    private RecyclerView recyclerView;
    //This is an adapter
    private CustomDrawerAdapter adapter;

    public static final String PRE_FILE_NAME = "testpref";
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    private View containerView;

    //Indicate if drawer is started for the first time or is it coming from a rotation
    private boolean mFromSavedInstanceState;

    public StudentDrawer() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState == null){
            mFromSavedInstanceState = true;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_student_drawer, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.student_drawer_list);

        //Displaying data on the navigation
        adapter = new CustomDrawerAdapter(getActivity(), getStudentData());
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return layout;
    }

    //Getting data for the adapter
    public static List<CustomDrawerItem> getStudentData () {
        List<CustomDrawerItem> data = new ArrayList<>();
        int[] icons = {R.drawable.home, R.drawable.courses, R.drawable.sh, R.drawable.sh, R.drawable.settings, R.drawable.power};
        String[] titles = {"HOME", "MY COURSES", "GRADE 11 COURSES", "GRADE 12 COURSES", "SETTINGS","LOG OUT"};

        for (int i=0; i<titles.length && i<icons.length; i++) {
            CustomDrawerItem current = new CustomDrawerItem();
            current.iconId = icons[i];
            current.title = titles[i];
            data.add(current);
        }
        return data;
    }

    public void setUp (int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if(slideOffset > -0.6){
                    toolbar.setAlpha(1+slideOffset);
                }
            }
        };

        if(!mFromSavedInstanceState){
            mDrawerLayout.openDrawer(containerView);
        }
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }

    @Override
    public void itemClick(View view, int position) {

        //Home
        if(position == 0){
            startActivity(new Intent(getActivity(), StudentHome.class));
        }
        else if(position == 2){
            startActivity(new Intent(getActivity(), StudentGrade11.class));
        }
        else if(position == 6){
            startActivity(new Intent(getActivity(), LoginActivity.class));
        }

    }
}
