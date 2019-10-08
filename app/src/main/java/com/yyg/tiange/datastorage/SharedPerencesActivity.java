package com.yyg.tiange.datastorage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yyg.tiange.R;

public class SharedPerencesActivity extends AppCompatActivity {
    private EditText mEtContent;
    private Button mBtnSave, mBtnShow;
    private TextView mTvData;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_perences);
        mEtContent = findViewById(R.id.et_content);
        mBtnSave = findViewById(R.id.btn_save);
        mBtnShow = findViewById(R.id.btn_show);
        mTvData = findViewById(R.id.tv_data);
        mSharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();


        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = mEtContent.getText().toString();
                mEditor.putString("content", content);
                //建议使用apply commit为同步方法 处理需较长时间 apply为异步 后台执行
                mEditor.apply();
            }
        });
        mBtnShow.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mTvData.setText(mSharedPreferences.getString("content", ""));
                    }
                }
        );

    }
}
