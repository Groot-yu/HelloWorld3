package com.yyg.helloworld3.jump;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yyg.helloworld3.R;

public class BActivity extends AppCompatActivity {
    private TextView mTvname, mTvnumber;
    private Button mBtnfinish;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        mTvname = findViewById(R.id.tv_name);
        mTvnumber = findViewById(R.id.tv_number);
        Bundle bundle = getIntent().getExtras();
//        Log.d("name", bundle.getString("name"));
        mTvname.setText("name:" + bundle.getString("name"));
        mTvnumber.setText("number:" + bundle.getInt("number"));

        mBtnfinish = findViewById(R.id.btn_finish);
        mBtnfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("return", "我回来了");
                intent.putExtras(bundle);
                setResult(AActivity.RESULT_OK, intent);
                finish();
            }
        });

    }
}
