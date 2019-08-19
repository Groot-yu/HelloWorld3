package com.yyg.helloworld3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yyg.helloworld3.R;

public class IntentActivity extends AppCompatActivity {
    private Button mBtnwangye;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        mBtnwangye = findViewById(R.id.btn_intent_wangye);
        mBtnwangye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
    }
}

