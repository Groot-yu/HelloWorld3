package com.yyg.genge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.yyg.genge.util.ToastUtil;
import com.yyg.genge.widget.MyButton;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnEvent, btnMyHandler;
    private MyButton btnMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnEvent = findViewById(R.id.btn_click);
        //1 内部类实现
//        mBtnEvent.setOnClickListener(new OnClick());
        //2 匿名内部类实现 未声明
//        mBtnEvent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("匿名内部类", "Click");
//                ToastUtil.showMsg(EventActivity.this, "click 2...");
//            }
//        });
        //3 通过事件源所在类实现View.OnClickListener接口
//        mBtnEvent.setOnClickListener(this);
//        mBtnEvent.setOnClickListener(EventActivity.this);
        //4 通过外部类去实现
        mBtnEvent.setOnClickListener(new MyClickListener(EventActivity.this));

        btnMy = findViewById(R.id.btn_my);
        //监听优先级高于回调函数  View源码OnTouchListener在onTouchEvent前面
        btnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("MyButton 匿名内部类", "----onTouch----");
                        break;
                }
                return false;
            }
        });
        //onClick onLongClick通过onTouchEvent来判断是哪一种  两种方法均由onTouchEvent产生
        //小于100ms
        btnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MyButton 匿名内部类", "----onClick----");
            }
        });
        //大于500ms
        btnMy.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d("MyButton 匿名内部类", "----onLongClick----");
                //若返回true 则不会执行onClcik 若false 则会执行onClick
                return false;
            }
        });
        btnMyHandler = findViewById(R.id.btn_handler);
        btnMyHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, HandlerActivity.class);
                startActivity(intent);
            }
        });
    }

    //    3 通过事件源所在类实现View.OnClickListener接口
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_click:
                ToastUtil.showMsg(EventActivity.this, "click 3...");
                break;
        }
    }


    //1 内部类实现
//    class OnClick implements View.OnClickListener {
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id.btn_click:
//                    Log.d("内部类", "Click");
//                    ToastUtil.showMsg(EventActivity.this, "click 1...");
//                    break;
//            }
//
//        }
//    }

    //layout文件中设置android:onClick属性”show“
    public void show(View v) {
        switch (v.getId()) {
            case R.id.btn_show:
                Log.d("布局", "Click");
                ToastUtil.showMsg(EventActivity.this, "show ...");
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("EventActivity", "----onTouchEvent----");
                break;
        }
        return false;
    }

}
//设置同种类型监听器 系统只会响应最后一个监听器 有效
//布局中的监听器是最先设置的