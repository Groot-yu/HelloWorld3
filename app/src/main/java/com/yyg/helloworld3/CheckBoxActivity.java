package com.yyg.helloworld3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {
    private CheckBox mCb_7, mCb_8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        mCb_7 = findViewById(R.id.cb_7);
        mCb_8 = findViewById(R.id.cb_8);
        mCb_7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this, isChecked ? "7选中" : "7未选中", Toast.LENGTH_SHORT).show();
            }
        });
        mCb_8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this, isChecked ? "8选中" : "8未选中", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
