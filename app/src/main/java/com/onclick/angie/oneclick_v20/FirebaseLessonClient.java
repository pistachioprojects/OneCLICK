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
 * Created by Angie on 10/17/2017.
 */

public class FirebaseLessonClient {

    Context context;
    String dbChild11;
    String dbChild12;
    RecyclerView recycler;
    String parentId;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference11;
    DatabaseReference databaseReference12;

    ArrayList<LessonItem> lessonItems11=new ArrayList<>();
    ArrayList<LessonItem> lessonItems12=new ArrayList<>();
    LessonItemAdapter itemAdapter11;
    LessonItemAdapter itemAdapter12;

    public FirebaseLessonClient(Context context, String dbChild11, String dbChild12, RecyclerView recycler, String parentId) {
        this.context = context;
        this.dbChild11 = dbChild11;
        this.dbChild12 = dbChild12;
        this.recycler = recycler;
        this.parentId = parentId;

        //firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference11 = FirebaseDatabase.getInstance().getReference(this.dbChild11);
        databaseReference12 = FirebaseDatabase.getInstance().getReference(this.dbChild12);
    }

    public void refreshData(){
        databaseReference11.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                getUpdates11(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show();
            }
        });

       databaseReference12.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                getUpdates12(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void getUpdates11(DataSnapshot dataSnapshot){
        lessonItems11.clear();
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            if(ds.getValue(LessonItem.class).getLesson_parent_id().equals(parentId)){
                LessonItem lesson = new LessonItem();
                lesson.setLesson_id(ds.getValue(LessonItem.class).getLesson_id());
                lesson.setLesson_description(ds.getValue(LessonItem.class).getLesson_description());
                lesson.setLesson_number(ds.getValue(LessonItem.class).getLesson_number());
                lesson.setLesson_video_id(ds.getValue(LessonItem.class).getLesson_video_id());

                Log.d("COURSE RETRIEVED", "=========================> "+ds.getValue(LessonItem.class).getLesson_description());

                lessonItems11.add(lesson);
            }
        }

        if(lessonItems11.size()>0){
            itemAdapter11 = new LessonItemAdapter(context, lessonItems11);
            recycler.setAdapter(itemAdapter11);
        }
        /*else{
            Toast.makeText(context, "NO DATA TO SHOW!", Toast.LENGTH_LONG).show();
        }*/
    }

    private void getUpdates12(DataSnapshot dataSnapshot){
        lessonItems12.clear();
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            if(ds.getValue(LessonItem.class).getLesson_parent_id().equals(parentId)){
                LessonItem lesson = new LessonItem();
                lesson.setLesson_id(ds.getValue(LessonItem.class).getLesson_id());
                lesson.setLesson_description(ds.getValue(LessonItem.class).getLesson_description());
                lesson.setLesson_number(ds.getValue(LessonItem.class).getLesson_number());
                lesson.setLesson_video_id(ds.getValue(LessonItem.class).getLesson_video_id());

                Log.d("COURSE RETRIEVED", "=========================> "+ds.getValue(LessonItem.class).getLesson_description());

                lessonItems12.add(lesson);
            }
        }

        if(lessonItems12.size()>0){
            itemAdapter12 = new LessonItemAdapter(context, lessonItems12);
            recycler.setAdapter(itemAdapter12);
        }
        /*else{
            Toast.makeText(context, "NO DATA TO SHOW!", Toast.LENGTH_LONG).show();
        }*/
    }
}
