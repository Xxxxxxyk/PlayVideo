package com.xxxxxxyk.playvideo;

import android.net.Uri;
import android.os.Environment;

public interface Config {
    Uri video_uri = Uri.parse(Environment.getExternalStorageDirectory().getPath() + "/Only_My_Railgun_art--fripSide.mp4");
    String RTSP_URL = "rtsp://192.168.11.241:8554/vlc";
    String M3U8_URL = "http://playertest.longtailvideo.com/adaptive/bipbop/gear4/prog_index.m3u8";
}
