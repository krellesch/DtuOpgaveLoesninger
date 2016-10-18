package com.example.kristian.dtu.dk.dtuopgaveloesninger;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by Kristian on 05-10-2016.
 */

public class YoutubeActivity extends YouTubeBaseActivity {

    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    private YouTubePlayer player;
    private TextView time;
    private CountDownTimer countDownTimer;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube);
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                player = youTubePlayer;
                youTubePlayer.loadVideo("a59gmGkq_pw");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult
                    youTubeInitializationResult) {

            }

            public void pause(YouTubePlayer youTubePlayer){youTubePlayer.pause();}
        };
        Button b = (Button) findViewById(R.id.btnPlay);
        b.setOnClickListener(myHandler);
        time = (TextView) findViewById(R.id.chono);
    }
    View.OnClickListener myHandler = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnPlay:
                    start();
                    youTubePlayerView.initialize("AIzaSyDp8S1bbrM7mOxrMGI_22YKCpJ8HP3lOhI",onInitializedListener);
                    break;
            }
        }
    };

    private void start(){
        time.setText("60");

        countDownTimer = new CountDownTimer(60 * 1000, 1000 ) {
            @Override
            public void onTick(long millisUntilFinished) {
                time.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                //player.pause();
                time.setText("stopped");
            }
        };
        countDownTimer.start();
    }
}
