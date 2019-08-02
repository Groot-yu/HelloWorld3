package com.yyg.helloworld3.jump;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yyg.helloworld3.R;
import com.yyg.helloworld3.util.ToastUtil;

public class AActivity extends AppCompatActivity {
    private Button mBtnExplicitJump, mBtnImplicitJump;
    private TextView mTvReturn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        mBtnExplicitJump = findViewById(R.id.btn_explicitjumpatob);
        mBtnExplicitJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显式跳转1
                Intent intent = new Intent(AActivity.this, BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", "包大人");
                bundle.putInt("number", 1024);
                intent.putExtras(bundle);
//                startActivity(intent);
                startActivityForResult(intent, 0);

//                显式跳转2
//                Intent intent = new Intent();
//                intent.setClass(AActivity.this, BActivity.class);
//                startActivity(intent);
//                显式跳转3
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this, "com.yyg.helloworld3.jump.BActivity");
//                startActivity(intent);
//                显式跳转4
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this, "com.yyg.helloworld3.jump.BActivity"));
//                startActivity(intent);
            }
        });

        mBtnImplicitJump = findViewById(R.id.btn_implicitjumpatob);
        mBtnImplicitJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                隐式跳转
                Intent intent = new Intent();
                intent.setAction("implicitjump");
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String r = data.getExtras().getString("return");
//        mTvReturn.setText(r); 有问题
        ToastUtil.showMsg(AActivity.this, r);

    }
}
