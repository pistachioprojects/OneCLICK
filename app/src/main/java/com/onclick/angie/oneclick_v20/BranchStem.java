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

public class BranchStem extends Fragment implements CourseItemShowAdapter.ClickListener {

    private RecyclerView recyclerView;
    private CourseItemShowAdapter adapter;

    public BranchStem() {
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

        adapter = new CourseItemShowAdapter(getActivity(), getCourseData());
        //SHOULD SET UP CLICK LISTENER
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;
    }

    //Getting data for the adapter
    public static List<CourseItemShow> getCourseData () {
        List<CourseItemShow> data = new ArrayList<>();
        int[] icons = {R.drawable.language, R.drawable.science, R.drawable.mathematics, R.drawable.philosophy, R.drawable.pe};
        String[] titles = {"Language", "Science", "General Mathematics", "Philosophy", "PE & Health"};
        String[] sDescription = {"This module develops the student's skill in English and Filipino.",
                "This module discusses about General Science.",
                "This module develops the student's logical skills in solving real life problems.",
                "This module discusses about world philosophies.",
                "This module discusses and develops the student's well being."};
        String[] user = {"all", "all", "all", "all", "all", "all"};
        for (int i=0; i<titles.length && i<icons.length; i++) {
            CourseItemShow current = new CourseItemShow();
            current.imageId = icons[i];
            current.courseTitle = titles[i];
            current.shortDescription = sDescription[i];
            current.userAvailability = user[i];
            data.add(current);
        }
        return data;
    }

    public void itemClick(View view, int position) {

        //Home
        if(position == 0){
            startActivity(new Intent(getActivity(), StudentHome.class));
        }

    }
}
