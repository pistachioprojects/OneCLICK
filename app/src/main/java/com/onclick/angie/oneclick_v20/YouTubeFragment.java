package com.onclick.angie.oneclick_v20;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

/**
 * Created by Angie on 9/28/2017.
 */

public class YouTubeFragment extends YouTubePlayerSupportFragment implements YouTubePlayer.OnInitializedListener {

    private static final int RECOVERY_DIALOG_REQUEST = 1;
    private static final String vidIdKey = null;
    private String mVideoId;
    private int mVideoStamp;


    private YouTubePlayer player;

    public YouTubeFragment() {}

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initialize(YouTubeConfig.getApiKey(), this);


    }

    /**
     * Set the video id and initialize the player
     * This can be used when including the Fragment in an XML layout
     * @param videoId The ID of the video to play
     */
    public void setVideoId(String videoId, int videoStamp) {
        mVideoId = videoId;
        mVideoStamp = videoStamp;
        initialize(YouTubeConfig.getApiKey(), this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean restored) {
        this.player = youTubePlayer;

        if(restored){
            player.play();
        }
        else{
            player.loadVideo(mVideoId, mVideoStamp);
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(getActivity(), RECOVERY_DIALOG_REQUEST).show();
        } else {
            //Handle the failure
            Toast.makeText(getActivity(), "ERROR", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(vidIdKey, mVideoId);
    }


    public void onRelease(){
        player.release();
    }
    public void onSeekTo(String id, int time) {
        //player.seekToMillis(time);
        player.loadVideo(id, time);
        //player.play();
    }


}
