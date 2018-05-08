package com.xxxxxxyk.playvideo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoViewActivity extends AppCompatActivity {

    private VideoView mVv_paly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        mVv_paly = findViewById(R.id.vv_video);
        mVv_paly.setMediaController(new MediaController(this));
        mVv_paly.setVideoURI(Config.video_uri);
        mVv_paly.start();
        mVv_paly.requestFocus();
    }
}
