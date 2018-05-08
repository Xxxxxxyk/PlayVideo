package com.xxxxxxyk.playvideo;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRv_list;
    private List<String> mList;
    private final int READ_EXTERNAL_STORAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        methodRequiresTwoPermission();

        mList = new ArrayList();
        mList.add("系统播放器");
        mList.add("使用VideoView");
        mList.add("使用节操播放器");
        mList.add("使用Vitamio播放RTSP视频");
        mList.add("使用Vitamio播放M3U8视频");


        mRv_list = findViewById(R.id.rv_list);
        mRv_list.setLayoutManager(new LinearLayoutManager(this));
        mRv_list.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new MyViewHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.item_video_button, null, false));
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                MyViewHolder my_holder = (MyViewHolder) holder;
                my_holder.mTv_play.setText(mList.get(position));
                my_holder.itemView.setOnClickListener((View v) -> {
                    switch (position) {
                        case 0:
                            startActivity(new Intent(MainActivity.this, SystemVideoActivity.class));
                            break;
                        case 1:
                            startActivity(new Intent(MainActivity.this, VideoViewActivity.class));
                            break;
                        case 2:
                            startActivity(new Intent(MainActivity.this, JieCaoViewActivity.class));
                            break;
                        case 3:
                            startActivity(new Intent(MainActivity.this, VitamioPlayActivity.class));
                            break;
                        case 4:
                            startActivity(new Intent(MainActivity.this, VitamioPlayActivity.class));
                            break;

                    }
                });
            }

            @Override
            public int getItemCount() {
                return mList.size();
            }

            class MyViewHolder extends RecyclerView.ViewHolder {

                private final TextView mTv_play;

                public MyViewHolder(View itemView) {
                    super(itemView);
                    mTv_play = itemView.findViewById(R.id.tv_play);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @AfterPermissionGranted(READ_EXTERNAL_STORAGE)
    private void methodRequiresTwoPermission() {
        String[] perms = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            // Already have permission, do the thing
            // ...
        } else {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(this, "请求存储权限来读取视频",
                    READ_EXTERNAL_STORAGE, perms);
        }
    }
}
