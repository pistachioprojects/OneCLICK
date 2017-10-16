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
    String invokerBranch;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ArrayList<CourseItem> courseItems=new ArrayList<>();
    CourseItemAdapter itemAdapter;
    CourseItemShowAdapter itemShowAdapter;

    public FirebaseClient(Context context, String dbChild, RecyclerView recycler, String invoker, String invokerBranch) {
        this.context = context;
        this.dbChild = dbChild;
        this.recycler = recycler;
        this.invoker = invoker;
        this.invokerBranch = invokerBranch;

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
                        switch (invokerBranch){
                            case "STEM":
                                getUpdatesStem(dataSnapshot);
                                break;
                            case "ABM":
                                getUpdatesAbm(dataSnapshot);
                                break;
                            case "HUMSS":
                                getUpdatesHumss(dataSnapshot);
                                break;
                            case "GAS":
                                getUpdatesGas(dataSnapshot);
                                break;
                            default:
                                break;
                        }
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

    private void getUpdatesStem(DataSnapshot dataSnapshot){
        courseItems.clear();
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            if(ds.getValue(CourseItem.class).getCourse_branch().equals("STEM")){
                CourseItem course = new CourseItem();
                course.setCourse_id(ds.getValue(CourseItem.class).getCourse_id());
                course.setCourse_title(ds.getValue(CourseItem.class).getCourse_title());
                course.setCourse_image_link(ds.getValue(CourseItem.class).getCourse_image_link());
                course.setCourse_description(ds.getValue(CourseItem.class).getCourse_description());
                course.setCourse_availability(ds.getValue(CourseItem.class).getCourse_availability());
                courseItems.add(course);
            }
            else if(ds.getValue(CourseItem.class).getCourse_branch().equals("CORE")){
                CourseItem course = new CourseItem();
                course.setCourse_id(ds.getValue(CourseItem.class).getCourse_id());
                course.setCourse_title(ds.getValue(CourseItem.class).getCourse_title());
                course.setCourse_image_link(ds.getValue(CourseItem.class).getCourse_image_link());
                course.setCourse_description(ds.getValue(CourseItem.class).getCourse_description());
                course.setCourse_availability(ds.getValue(CourseItem.class).getCourse_availability());
                courseItems.add(course);
            }
        }

        if(courseItems.size()>0){
            itemShowAdapter = new CourseItemShowAdapter(context, courseItems);
            recycler.setAdapter(itemShowAdapter);
        }
        else{
            Toast.makeText(context, "NO DATA TO SHOW!", Toast.LENGTH_SHORT).show();
        }
    }

    private void getUpdatesAbm(DataSnapshot dataSnapshot){
        courseItems.clear();
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            if(ds.getValue(CourseItem.class).getCourse_branch().equals("ABM")){
                CourseItem course = new CourseItem();
                course.setCourse_id(ds.getValue(CourseItem.class).getCourse_id());
                course.setCourse_title(ds.getValue(CourseItem.class).getCourse_title());
                course.setCourse_image_link(ds.getValue(CourseItem.class).getCourse_image_link());
                course.setCourse_description(ds.getValue(CourseItem.class).getCourse_description());
                course.setCourse_availability(ds.getValue(CourseItem.class).getCourse_availability());
                courseItems.add(course);
            }
            else if(ds.getValue(CourseItem.class).getCourse_branch().equals("CORE")){
                CourseItem course = new CourseItem();
                course.setCourse_id(ds.getValue(CourseItem.class).getCourse_id());
                course.setCourse_title(ds.getValue(CourseItem.class).getCourse_title());
                course.setCourse_image_link(ds.getValue(CourseItem.class).getCourse_image_link());
                course.setCourse_description(ds.getValue(CourseItem.class).getCourse_description());
                course.setCourse_availability(ds.getValue(CourseItem.class).getCourse_availability());
                courseItems.add(course);
            }
        }


        if(courseItems.size()>0){
            itemShowAdapter = new CourseItemShowAdapter(context, courseItems);
            recycler.setAdapter(itemShowAdapter);
        }
        else{
            Toast.makeText(context, "NO DATA TO SHOW!", Toast.LENGTH_SHORT).show();
        }
    }

    private void getUpdatesHumss(DataSnapshot dataSnapshot){
        courseItems.clear();
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            if(ds.getValue(CourseItem.class).getCourse_branch().equals("HUMSS")){
                CourseItem course = new CourseItem();
                course.setCourse_id(ds.getValue(CourseItem.class).getCourse_id());
                course.setCourse_title(ds.getValue(CourseItem.class).getCourse_title());
                course.setCourse_image_link(ds.getValue(CourseItem.class).getCourse_image_link());
                course.setCourse_description(ds.getValue(CourseItem.class).getCourse_description());
                course.setCourse_availability(ds.getValue(CourseItem.class).getCourse_availability());
                courseItems.add(course);
            }
            else if(ds.getValue(CourseItem.class).getCourse_branch().equals("CORE")){
                CourseItem course = new CourseItem();
                course.setCourse_id(ds.getValue(CourseItem.class).getCourse_id());
                course.setCourse_title(ds.getValue(CourseItem.class).getCourse_title());
                course.setCourse_image_link(ds.getValue(CourseItem.class).getCourse_image_link());
                course.setCourse_description(ds.getValue(CourseItem.class).getCourse_description());
                course.setCourse_availability(ds.getValue(CourseItem.class).getCourse_availability());
                courseItems.add(course);
            }
        }

        if(courseItems.size()>0){
            itemShowAdapter = new CourseItemShowAdapter(context, courseItems);
            recycler.setAdapter(itemShowAdapter);
        }
        else{
            Toast.makeText(context, "NO DATA TO SHOW!", Toast.LENGTH_SHORT).show();
        }
    }

    private void getUpdatesGas(DataSnapshot dataSnapshot){
        courseItems.clear();
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            if(ds.getValue(CourseItem.class).getCourse_branch().equals("GAS")){
                CourseItem course = new CourseItem();
                course.setCourse_id(ds.getValue(CourseItem.class).getCourse_id());
                course.setCourse_title(ds.getValue(CourseItem.class).getCourse_title());
                course.setCourse_image_link(ds.getValue(CourseItem.class).getCourse_image_link());
                course.setCourse_description(ds.getValue(CourseItem.class).getCourse_description());
                course.setCourse_availability(ds.getValue(CourseItem.class).getCourse_availability());
                courseItems.add(course);
            }
            else if(ds.getValue(CourseItem.class).getCourse_branch().equals("CORE")){
                CourseItem course = new CourseItem();
                course.setCourse_id(ds.getValue(CourseItem.class).getCourse_id());
                course.setCourse_title(ds.getValue(CourseItem.class).getCourse_title());
                course.setCourse_image_link(ds.getValue(CourseItem.class).getCourse_image_link());
                course.setCourse_description(ds.getValue(CourseItem.class).getCourse_description());
                course.setCourse_availability(ds.getValue(CourseItem.class).getCourse_availability());
                courseItems.add(course);
            }
        }

        if(courseItems.size()>0){
            itemShowAdapter = new CourseItemShowAdapter(context, courseItems);
            recycler.setAdapter(itemShowAdapter);
        }
        else{
            Toast.makeText(context, "NO DATA TO SHOW!", Toast.LENGTH_SHORT).show();
        }
    }

}
