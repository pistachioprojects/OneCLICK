package com.onclick.angie.oneclick_v20;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.text.format.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CourseSubject extends AppCompatActivity{

    public static final String vidIdKey = "h4VPgGqv4kk";

    private FloatingActionButton fabChat;
    FirebaseAuth firebaseAuth;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private FirebaseListAdapter<ChatItem> adapter;

    private Toolbar toolbar;

    EditText chat;
    String userEmail;
    private static int SIGN_IN_REQUEST_CODE = 1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SIGN_IN_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                toasterMessage("SUCCESSFUL");
                displayChatMessage();
            }
            else{
                toasterMessage("FAIL");
                finish();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_subject);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        StudentDrawer drawerFragment = (StudentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_student_drawer);
        drawerFragment.setUp(R.id.fragment_student_drawer, (DrawerLayout) findViewById(R.id.student_drawer_layout), toolbar);

        //firebaseAuth = FirebaseAuth.getInstance();

        final Bundle bundle = getIntent().getExtras();
        String crsId = bundle.getString("course_id");
        String crsTitle = bundle.getString("course_title");
        String crsVidId = bundle.getString("course_video");
        String crsDesc = bundle.getString("course_description");

        //Log.d("COURSE SUBJECT", "=========================> "+crsId+","+crsTitle+","+crsVidId+","+crsDesc);

        final YouTubeFragment fragment = (YouTubeFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_youtube);
        fragment.setVideoId(crsVidId);

        final TextView videoTitle = (TextView) findViewById(R.id.course_video_title);
        videoTitle.setText(crsTitle);


        //userEmail = firebaseAuth.getCurrentUser().getEmail();

        //Log.d("CURRENT USER","====================> "+" UserEmail: "+userEmail);

        //Not sure if I'll use this one
        fabChat = (FloatingActionButton) findViewById(R.id.fab_chat);
        fabChat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Send chat message
                chat = (EditText) findViewById(R.id.chat_message_textinput);
                /*
                firebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference();
                databaseReference.push().setValue(new ChatItem(userEmail ,chat.getText().toString()));*/
                FirebaseDatabase.getInstance().getReference("Chat").push().setValue(
                        new ChatItem(FirebaseAuth.getInstance().getCurrentUser().getEmail(), chat.getText().toString()));
                chat.setText("");
            }
        });

        displayChatMessage();
    }

    private void displayChatMessage(){

        ListView listOfMessages = (ListView) findViewById(R.id.chat_list_view);
        adapter = new FirebaseListAdapter<ChatItem>(this, ChatItem.class, R.layout.chat_item, FirebaseDatabase.getInstance().getReference("Chat")) {
            @Override
            protected void populateView(View view, ChatItem model, int i) {
                TextView chatUsername, chatTimestamp, chatMessage;
                chatUsername =  view.findViewById(R.id.chat_username);
                chatMessage = view.findViewById(R.id.chat_message);
                chatTimestamp = view.findViewById(R.id.chat_timestamp);

                chatUsername.setText(model.getChat_email());
                chatMessage.setText(model.getChat_message());

                /*String strCurrentDate = "Apr 18,2012 07:55 ";

                SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy hh:mm a");
                Date newDate = null;
                try {
                    newDate = dateFormat.parse(strCurrentDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String date = dateFormat.format(newDate);

                chatTimestamp.setText(date);*/

                chatTimestamp.setText(DateFormat.format("MMM dd, yyyy (HH:mm)", model.getChat_time()));
            }
        };
        listOfMessages.setAdapter(adapter);

    }

    public void toasterMessage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
