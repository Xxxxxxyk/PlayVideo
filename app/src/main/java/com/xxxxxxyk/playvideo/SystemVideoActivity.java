package com.xxxxxxyk.playvideo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class SystemVideoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent view = new Intent(Intent.ACTION_VIEW);
        view.setDataAndType(Config.video_uri,"video/mp4");
        startActivity(view);
        finish();
    }
}
