package com.onclick.angie.oneclick_v20;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Angie on 10/4/2017.
 */

public class FirebaseStudentClient {

    Context context;
    String dbChild;
    String studId;
    String studEmail;
    TextView student;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    public FirebaseStudentClient(Context context, String dbChild, String studId, String studEmail) {
        this.context = context;
        this.dbChild = dbChild;
        this.studId = studId;
        this.studEmail = studEmail;

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
        for(DataSnapshot ds : dataSnapshot.getChildren()){
            if(ds.getValue(StudentInfo.class).getStudent_id().equals(studId) && ds.getValue(StudentInfo.class).getStudent_email().equals(studEmail)){
                StudentInfo studentInfo =  new StudentInfo();
                studentInfo.setStudent_firstname(ds.getValue(StudentInfo.class).getStudent_firstname());
            }
        }
    }
}
