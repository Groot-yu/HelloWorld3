package com.yyg.tiange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yyg.tiange.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {
    private Button mBtntoast1, mBtntoast2, mBtntoast3, mBtntoast4, mBtntoast5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        mBtntoast1 = findViewById(R.id.btn_toast_1);
        mBtntoast2 = findViewById(R.id.btn_toast_2);
        mBtntoast3 = findViewById(R.id.btn_toast_3);
        mBtntoast4 = findViewById(R.id.btn_toast_4);
        mBtntoast5 = findViewById(R.id.btn_toast_5);
        OnClick onClick = new OnClick();
        mBtntoast1.setOnClickListener(onClick);
        mBtntoast2.setOnClickListener(onClick);
        mBtntoast3.setOnClickListener(onClick);
        mBtntoast4.setOnClickListener(onClick);
        mBtntoast5.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_toast_1:
                    Toast toast = Toast.makeText(getApplicationContext(), "Toast1", Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                case R.id.btn_toast_2:
                    Toast toastcenter = Toast.makeText(ToastActivity.this, "Toast2居中", Toast.LENGTH_SHORT);
                    toastcenter.setGravity(Gravity.CENTER, 0, 0);
                    toastcenter.show();
                    break;
                case R.id.btn_toast_3:
                    Toast toastcustomize = new Toast(ToastActivity.this);
                    View view = LayoutInflater.from(ToastActivity.this).inflate(R.layout.layout_toast3, null);

                    ImageView imageView = view.findViewById(R.id.iv_toast);
                    TextView textView = view.findViewById(R.id.tv_toast);
                    imageView.setImageResource(R.drawable.toast3_imageview);
                    textView.setText("古典美女");

                    toastcustomize.setView(view);
                    toastcustomize.setDuration(Toast.LENGTH_LONG);
                    toastcustomize.show();
                    break;
                case R.id.btn_toast_4:
                    ToastUtil.showMsg(ToastActivity.this, "包装过的Toast1");
                    break;
                case R.id.btn_toast_5:
                    ToastUtil.showMsg(ToastActivity.this, "包装过的Toast2");
                    break;
            }
        }
    }
}
