package com.yyg.helloworld3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {
    private ImageView mIv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        mIv4 = findViewById(R.id.iv_4);
        Glide.with(this).load("http://img13.360buyimg.com/n1/jfs/t1165/315/531086589/76913/12412804/552f0f33N4b2a8a86.jpg").into(mIv4);
    }
}
//Git 需 重新学习