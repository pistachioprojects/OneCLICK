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
    public void setVideoId(final String videoId) {
        mVideoId = videoId;
        initialize(YouTubeConfig.getApiKey(), this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean restored) {
        if (mVideoId != null) {
            if (restored) {
                youTubePlayer.play();
            } else {
                youTubePlayer.loadVideo(mVideoId);
            }
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

}
