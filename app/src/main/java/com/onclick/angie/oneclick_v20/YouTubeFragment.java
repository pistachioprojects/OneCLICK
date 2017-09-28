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

    private static final String vidIdKey = "W4hTJybfU7s";
    private String mVideoId;

    public YouTubeFragment() {}

    public static YouTubeFragment newInstance(final String videoId) {
        final YouTubeFragment youTubeFragment = new YouTubeFragment();
        final Bundle bundle = new Bundle();
        bundle.putString(vidIdKey, videoId);
        youTubeFragment.setArguments(bundle);
        return youTubeFragment;
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        final Bundle arguments = getArguments();

        if (bundle != null && bundle.containsKey(vidIdKey)) {
            mVideoId = bundle.getString(vidIdKey);
        } else if (arguments != null && arguments.containsKey(vidIdKey)) {
            mVideoId = arguments.getString(vidIdKey);
        }

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
