package com.yyg.tiange;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {
    private TextView mTv4, mTv5, mTv6, mTv7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        mTv4 = findViewById(R.id.tv_4);
        mTv4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//中划线
        //CSS中 {text-decoration:overline underline line-through none blink inherit}
        //html中 <strike></strike>已不用     <s>其它所有情况使用</s> <delete>表示删除的内容</delete>效果相同
        mTv4.getPaint().setAntiAlias(true);//去除锯齿

        mTv5 = findViewById(R.id.tv_5);
        mTv5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线

        mTv6 = findViewById(R.id.tv_6);
        mTv6.setText(Html.fromHtml("<u>根哥在冲浪</u>"));

        mTv7 = findViewById(R.id.tv_7);
        mTv7.setSelected(true);
    }
}
