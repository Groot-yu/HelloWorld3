package com.yyg.helloworld3.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.yyg.helloworld3.DialogActivity;
import com.yyg.helloworld3.R;

public class CustomDialog extends Dialog implements View.OnClickListener {
    private TextView mTvTitle, mTvMessage, mTvCancel, mTvConfirm;
    private String title, message, cancel, confirm;
    private IOnCancelListener iOnCancelListener;
    private IOnConfirmListener iOnConfirmListener;


    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);


        WindowManager windowManager = getWindow().getWindowManager();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        Display display = windowManager.getDefaultDisplay();
        Point displaysize = new Point();
        display.getSize(displaysize);
        lp.width=(int)(displaysize.x*0.8);
        getWindow().setAttributes(lp);

        mTvTitle = findViewById(R.id.tv_title);
        mTvMessage = findViewById(R.id.tv_message);
        mTvCancel = findViewById(R.id.tv_cancel);
        mTvConfirm = findViewById(R.id.tv_confirm);
        if (!TextUtils.isEmpty(title)) {
            mTvTitle.setText(title);
        }
        if (!TextUtils.isEmpty(message)) {
            mTvMessage.setText(message);
        }
        if (!TextUtils.isEmpty(cancel)) {
            mTvCancel.setText(cancel);
        }
        if (!TextUtils.isEmpty(confirm)) {
            mTvConfirm.setText(confirm);
        }
        mTvCancel.setOnClickListener(this);
        mTvConfirm.setOnClickListener(this);

    }


    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel, IOnCancelListener listener) {
        this.cancel = cancel;
        this.iOnCancelListener = listener;
        return this;
    }

    public CustomDialog setConfirm(String confirm, IOnConfirmListener listener) {
        this.confirm = confirm;
        this.iOnConfirmListener = listener;
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                if (iOnCancelListener != null) {
                    iOnCancelListener.onCancel(this);
                }
                break;
            case R.id.tv_confirm:
                if (iOnConfirmListener != null) {
                    iOnConfirmListener.onConfirm(this);
                }
                break;
        }
    }

    public interface IOnCancelListener {
        void onCancel(CustomDialog dialog);
    }

    public interface IOnConfirmListener {
        void onConfirm(CustomDialog dialog);
    }

}
