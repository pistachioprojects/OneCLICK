package com.onclick.angie.oneclick_v20;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Angie on 10/28/2017.
 */

public class Grade12BranchAbm extends Fragment {

    private RecyclerView recyclerView;
    private CourseItemShowAdapter adapter;

    FirebaseClient firebaseClient;

    public Grade12BranchAbm() {
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout =inflater.inflate(R.layout.tab_abm,container,false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.abm_recycler_view);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        firebaseClient = new FirebaseClient(getContext(), "Grade12_Courses", recyclerView, "StudentViewMore", "ABM");
        firebaseClient.refreshData();
        return layout;
    }
}
