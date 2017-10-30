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
 * Created by Angie on 9/10/2017.
 */

public class Grade11BranchHumss extends Fragment {

    private RecyclerView recyclerView;
    private CourseItemShowAdapter adapter;

    FirebaseClient firebaseClient;


    public Grade11BranchHumss() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout =inflater.inflate(R.layout.tab_humss,container,false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.humss_recycler_view);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        firebaseClient = new FirebaseClient(getContext(), "Grade11_Courses", recyclerView, "StudentViewMore", "HUMSS");
        firebaseClient.refreshData();

        return layout;
    }

}
