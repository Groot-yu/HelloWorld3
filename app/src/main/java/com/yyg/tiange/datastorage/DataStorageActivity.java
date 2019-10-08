package com.yyg.tiange.datastorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yyg.tiange.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnFile, mBtnSharedPreferences, mBtnExternalStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        mBtnFile = findViewById(R.id.btn_file);
        mBtnSharedPreferences = findViewById(R.id.btn_sharedpreferences);
        mBtnExternalStorage = findViewById(R.id.btn_externalstorage);
        mBtnSharedPreferences.setOnClickListener(this);
        mBtnFile.setOnClickListener(this);
        mBtnExternalStorage.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_sharedpreferences:
                intent = new Intent(DataStorageActivity.this, SharedPerencesActivity.class);
                break;
            case R.id.btn_file:
                intent = new Intent(DataStorageActivity.this, FileActivity.class);
                break;
            case R.id.btn_externalstorage:
                intent = new Intent(DataStorageActivity.this, ExternalStorageActivity.class);
                break;
        }
        startActivity(intent);
    }
}
