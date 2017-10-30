package com.onclick.angie.oneclick_v20;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angie on 9/10/2017.
 */

public class Grade11BranchStem extends Fragment {

    private RecyclerView recyclerView;
    private CourseItemShowAdapter adapter;

    FirebaseClient firebaseClient;

    public Grade11BranchStem() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout =inflater.inflate(R.layout.tab_stem,container,false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.stem_recycler_view);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        firebaseClient = new FirebaseClient(getContext(), "Grade11_Courses", recyclerView, "StudentViewMore", "STEM");
        firebaseClient.refreshData();

        return layout;
    }
}
