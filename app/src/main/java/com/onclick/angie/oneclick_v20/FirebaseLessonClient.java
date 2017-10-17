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
    String dbChild;
    RecyclerView recycler;
    String parentId;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ArrayList<LessonItem> lessonItems=new ArrayList<>();
    LessonItemAdapter itemAdapter;

    public FirebaseLessonClient(Context context, String dbChild, RecyclerView recycler, String parentId) {
        this.context = context;
        this.dbChild = dbChild;
        this.recycler = recycler;
        this.parentId = parentId;

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference(this.dbChild);
    }

    public void refreshData(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                getUpdates(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getUpdates(DataSnapshot dataSnapshot){
        lessonItems.clear();
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            if(ds.getValue(LessonItem.class).getLesson_parent_id().equals(parentId)){
                LessonItem lesson = new LessonItem();
                lesson.setLesson_id(ds.getValue(LessonItem.class).getLesson_id());
                lesson.setLesson_description(ds.getValue(LessonItem.class).getLesson_description());
                lesson.setLesson_number(ds.getValue(LessonItem.class).getLesson_number());
                lesson.setLesson_video_id(ds.getValue(LessonItem.class).getLesson_video_id());

                Log.d("COURSE RETRIEVED", "=========================> "+ds.getValue(LessonItem.class).getLesson_description());

                lessonItems.add(lesson);
            }
        }

        if(lessonItems.size()>0){
            itemAdapter = new LessonItemAdapter(context, lessonItems);
            recycler.setAdapter(itemAdapter);
        }
        else{
            Toast.makeText(context, "NO DATA TO SHOW!", Toast.LENGTH_LONG).show();
        }
    }
}
