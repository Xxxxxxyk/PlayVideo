package com.xxxxxxyk.playvideo;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cn.jzvd.JZVideoPlayerStandard;

public class JieCaoViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiecaoview);
        JZVideoPlayerStandard jzVideoPlayerStandard =  findViewById(R.id.videoplayer);
        jzVideoPlayerStandard.setUp(Config.video_uri.toString(), JZVideoPlayerStandard.SCREEN_WINDOW_FULLSCREEN, "炮姐OP");
    }
}
