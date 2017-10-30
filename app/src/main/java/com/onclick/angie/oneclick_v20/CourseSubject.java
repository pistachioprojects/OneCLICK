package com.onclick.angie.oneclick_v20;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.text.format.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CourseSubject extends AppCompatActivity{

    public static final String vidIdKey = "h4VPgGqv4kk";

    private FloatingActionButton fabChat;
    FirebaseAuth firebaseAuth;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private FirebaseListAdapter<ChatItem> adapter;

    private Toolbar toolbar;

    YouTubeFragment fragment;

    ListView listOfMessages;

    EditText chat;
    String chatMessage;
    int videoTime;
    String userEmail;
    private static int SIGN_IN_REQUEST_CODE = 1;

    String lessonId;
    String lessonTitle;
    String lessonVidId;

    int time = 0;

    int hours = 0;
    int minutes = 0;
    int seconds = 0;

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

        final Bundle bundle = getIntent().getExtras();
        lessonId = bundle.getString("lesson_id");
        lessonTitle = bundle.getString("lesson_description");
        lessonVidId = bundle.getString("lesson_video_id");

        //Log.d("COURSE SUBJECT", "=========================> "+crsId+","+crsTitle+","+crsVidId+","+crsDesc);

        fragment = (YouTubeFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_youtube);
        fragment.setVideoId(lessonVidId, 0);

        final TextView videoTitle = (TextView) findViewById(R.id.course_video_title);
        videoTitle.setText(lessonTitle);


        //userEmail = firebaseAuth.getCurrentUser().getEmail();

        //Log.d("CURRENT USER","====================> "+" UserEmail: "+userEmail);

        //Not sure if I'll use this one
        fabChat = (FloatingActionButton) findViewById(R.id.fab_chat);
        fabChat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Send chat message
                chat = (EditText) findViewById(R.id.chat_message_textinput);
                chatMessage = chat.getText().toString();

                Matcher vidStampMatch = Pattern.compile("([A-Za-z _'@#!?&=,.])*(\\d)?:?([0-5]?\\d{1}):([0-5]{1}\\d{1})([A-Za-z _'@#!?&=,.])*").matcher(chatMessage);

                if(vidStampMatch.matches()){
                    try {
                        if(vidStampMatch.group(2) == null){
                            hours = 0;
                        }
                        else{
                            hours = Integer.parseInt(vidStampMatch.group(2));
                        }
                        minutes = Integer.parseInt(vidStampMatch.group(3));
                        seconds = Integer.parseInt(vidStampMatch.group(4));
                    }catch (NumberFormatException e){
                        Log.d("VIDEO TIME", "=========================> NOPE NOPE NOPE");
                    }
                    videoTime = (hours*3600)+(minutes*60)+seconds;
                }
                else {
                    videoTime = 0;
                }

                Log.d("VIDEO TIME", "=========================> "+videoTime);

                FirebaseDatabase.getInstance().getReference("Chat").push().setValue(
                        new ChatItem(FirebaseAuth.getInstance().getCurrentUser().getEmail(), chatMessage, videoTime));

                chat.setText("");
            }
        });

        displayChatMessage();
    }

    private void displayChatMessage(){

        adapter = new FirebaseListAdapter<ChatItem>(this, ChatItem.class, R.layout.chat_item, FirebaseDatabase.getInstance().getReference("Chat")) {
            @Override
            protected void populateView(View view, ChatItem model, int i) {
                TextView chatUsername, chatTimestamp, chatMessage;
                chatUsername =  view.findViewById(R.id.chat_username);
                chatMessage = view.findViewById(R.id.chat_message);
                chatTimestamp = view.findViewById(R.id.chat_timestamp);

                chatUsername.setText(model.getChat_email());
                chatTimestamp.setText(DateFormat.format("MMM dd, yyyy (HH:mm)", model.getChat_time()));

                //chatMessage.setText(model.getChat_message());
                //RETURN THE SPANNABLE TEXT HERE

                String text = model.getChat_message();

                SpannableString spanString = new SpannableString(text);
                Matcher matcher = Pattern.compile("(\\d)?:?([0-5]?\\d{1}):([0-5]{1}\\d{1})").matcher(spanString);

                while(matcher.find()){
                    spanString.setSpan(new ForegroundColorSpan(Color.parseColor("#00838F")), matcher.start(), matcher.end(), 0);
                    spanString.setSpan(new UnderlineSpan(), matcher.start(), matcher.end(), 0);
                }
                chatMessage.setText(spanString);
            }
        };

        listOfMessages = (ListView) findViewById(R.id.chat_list_view);
        listOfMessages.setAdapter(adapter);
        listOfMessages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ChatItem item = (ChatItem) parent.getItemAtPosition(position);
                Log.d("VIDEO TIME STAMP?", "=========================> "+item.getChat_video_stamp());

                time = item.getChat_video_stamp();

                /*FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                YouTubeFragment fragmentRefresh = new YouTubeFragment();
                fragmentRefresh = (YouTubeFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_youtube);
                fragmentRefresh.setVideoId(lessonVidId, item.getChat_video_stamp());

                transaction.replace(R.id.fragment_youtube, fragmentRefresh).commit();*/

                fragment.onRelease();

                fragment = new YouTubeFragment();
                fragment = (YouTubeFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_youtube);
                fragment.setVideoId(lessonVidId, item.getChat_video_stamp());

                //fragment.onSeekTo(lessonVidId, item.getChat_video_stamp());

                /*fragment = new YouTubeFragment();
                fragment = (YouTubeFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_youtube);
                fragment.setVideoId(lessonVidId, item.getChat_video_stamp());*/
            }
        });
    }

    public void toasterMessage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
