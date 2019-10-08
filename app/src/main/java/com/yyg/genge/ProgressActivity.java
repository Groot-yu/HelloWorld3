package com.yyg.genge;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.yyg.genge.util.ToastUtil;

public class ProgressActivity extends AppCompatActivity {
    private ProgressBar mPb3;
    private Button mBtnmoni, mPd1, mPd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        mPb3 = findViewById(R.id.pb_3);
        mPd1 = findViewById(R.id.btn_pd1);
        mPd2 = findViewById(R.id.btn_pd2);
        mBtnmoni = findViewById(R.id.btn_progress_moni);
        mBtnmoni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);
            }
        });

        mPd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setTitle("提示：");
                progressDialog.setMessage("正在加载！");
                progressDialog.setCancelable(false);
                progressDialog.show();
            }
        });
        mPd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setTitle("提示：");
                progressDialog.setMessage("正在下载！");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToastUtil.showMsg(ProgressActivity.this, "会话被动Cancel。。。");
                    }
                });
                progressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
//                        ToastUtil.showMsg(ProgressActivity.this, "会话主动Dismiss。。。");
                    }
                });
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtil.showMsg(ProgressActivity.this, "后台继续下载!");
                    }
                });
                progressDialog.show();
            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mPb3.getProgress() < 100) {
                handler.postDelayed(runnable, 500);
            } else {
                ToastUtil.showMsg(ProgressActivity.this, "加载完成。");
            }
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mPb3.setProgress(mPb3.getProgress() + 5);
            handler.sendEmptyMessage(0);
        }
    };
}
