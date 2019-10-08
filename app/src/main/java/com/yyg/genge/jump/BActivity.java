package com.yyg.genge.jump;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yyg.genge.R;

public class BActivity extends AppCompatActivity {
    private TextView mTvname, mTvnumber;
    private Button mBtnfinish, mBtnJumpBtoA, mBtnJumpBtoB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Log.d("BActivity", "----onCreate----");
        Log.d("BActivity", "taskid-" + getTaskId() + "  hashcode-" + hashCode());
        logtaskName();
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
        mBtnJumpBtoA = findViewById(R.id.btn_jumpbtoa);
        mBtnJumpBtoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BActivity.this, AActivity.class);
                startActivity(intent);
            }
        });
        mBtnJumpBtoB = findViewById(R.id.btn_jumpbtob);
        mBtnJumpBtoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BActivity.this, BActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("BActivity", "----onNewIntent----");
        Log.d("BActivity", "taskid-" + getTaskId() + "  hashcode-" + hashCode());
        logtaskName();
    }

    private void logtaskName() {
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("BAcitivty", info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
