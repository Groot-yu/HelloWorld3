package com.yyg.tiange;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.yyg.tiange.util.ToastUtil;
//4 通过外部类去实现
public class MyClickListener implements View.OnClickListener {
    private Activity mActivity;

    MyClickListener(Activity activity) {
        this.mActivity = activity;
    }

    @Override
    public void onClick(View v) {
        Log.d("外部类", "Click");
        ToastUtil.showMsg(mActivity, "click 4外部类...");
    }
}
