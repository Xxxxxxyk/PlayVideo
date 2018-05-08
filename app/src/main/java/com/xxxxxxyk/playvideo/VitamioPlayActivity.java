package com.xxxxxxyk.playvideo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class VitamioPlayActivity extends AppCompatActivity {

    private VideoView mVv_player;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitamioplay);
        Vitamio.isInitialized(this);
        mVv_player = findViewById(R.id.vv_player);
        mVv_player.setVideoPath(Config.RTSP_URL);
//        mVv_player.setVideoPath(Config.M3U8_URL);
        mVv_player.setMediaController(new MediaController(this));
        mVv_player.requestFocus();
    }
}
