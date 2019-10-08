package com.yyg.tiange;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yyg.tiange.datastorage.DataStorageActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListener();
        setListener();
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
    }

    private void setListener() {
        Onclick onclick = new Onclick();
        findViewById(R.id.btn_ui).setOnClickListener(onclick);
        findViewById(R.id.btn_event).setOnClickListener(onclick);
        findViewById(R.id.btn_data).setOnClickListener(onclick);
    }

    class Onclick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UiActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
