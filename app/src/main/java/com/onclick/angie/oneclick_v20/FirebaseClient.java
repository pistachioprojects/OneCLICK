package com.onclick.angie.oneclick_v20;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Angie on 9/28/2017.
 */

public class FirebaseClient {

    Context context;
    String dbChild;
    RecyclerView recycler;
    String invoker;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ArrayList<CourseItem> courseItems=new ArrayList<>();
    CourseItemAdapter itemAdapter;
    CourseItemShowAdapter itemShowAdapter;

    public FirebaseClient(Context context, String dbChild, RecyclerView recycler, String invoker) {
        this.context = context;
        this.dbChild = dbChild;
        this.recycler = recycler;
        this.invoker = invoker;

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference(this.dbChild);
    }

    public void refreshData(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                switch (invoker){
                    case "StudentHome":
                        getUpdates(dataSnapshot);
                        break;
                    case "StudentViewMore":
                        //Do Something
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getUpdates(DataSnapshot dataSnapshot){
        courseItems.clear();
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            CourseItem course = new CourseItem();
            course.setCourse_id(ds.getValue(CourseItem.class).getCourse_id());
            course.setCourse_title(ds.getValue(CourseItem.class).getCourse_title());
            course.setCourse_image_link(ds.getValue(CourseItem.class).getCourse_image_link());
            course.setCourse_video_id(ds.getValue(CourseItem.class).getCourse_video_id());
            course.setCourse_description(ds.getValue(CourseItem.class).getCourse_description());
            courseItems.add(course);
        }

        if(courseItems.size()>0){
            itemAdapter = new CourseItemAdapter(context, courseItems);
            recycler.setAdapter(itemAdapter);
        }
        else{
            Toast.makeText(context, "NO DATA TO SHOW!", Toast.LENGTH_SHORT).show();
        }
    }
}
