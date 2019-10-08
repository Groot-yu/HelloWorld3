package com.yyg.genge;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yyg.genge.util.ToastUtil;

public class HandlerActivity extends AppCompatActivity {
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
//        mHandler = new Handler();
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(HandlerActivity.this, ButtonActivity.class);
//                startActivity(intent);
//            }
//        }, 3000);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 2:
                        ToastUtil.showMsg(HandlerActivity.this, "我在处理另一个线程传来的message 线程通信成功");
                        break;
                }

            }
        };
        new Thread() {
            @Override
            public void run() {
                super.run();
                Message message = new Message();
                message.what = 2;
                mHandler.sendMessage(message);
            }
        }.start();
    }
}
