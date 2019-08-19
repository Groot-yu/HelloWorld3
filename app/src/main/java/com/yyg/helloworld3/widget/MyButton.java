package com.yyg.helloworld3.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class MyButton extends AppCompatButton {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //touch事件分发入口
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        //log两次 ACTION_DOWN ACTION_UP 各一次
        Log.d("MyButton", "----dispatchTouchEvent----");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //event 手指触摸 滑动都会触发
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("MyButton 回调函数", "----onTouchEvent----");
                break;
        }
        //false 方法没结束 不停止 事件会向外传播 传到Activity 也会调用onTouchEvent方法
//        return false;
        //true 已消费完 停止传播
        return super.onTouchEvent(event);
    }
}
