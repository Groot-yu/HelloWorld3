package com.yyg.helloworld3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.yyg.helloworld3.util.ToastUtil;

public class MenuActivity extends AppCompatActivity {
    private Button mBtnfinish, mBtnyishi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mBtnfinish = findViewById(R.id.btn_finish);
        mBtnfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBtnyishi = findViewById(R.id.btn_intent_yinshi);
        mBtnyishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("yinshi");
                intent.addCategory("yinshi");
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                ToastUtil.showMsg(MenuActivity.this, "you click add_item");
                break;
            case R.id.remove_item:
                ToastUtil.showMsg(MenuActivity.this, "you click remove_item");
                break;
        }
        return true;
    }
}
