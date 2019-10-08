package com.yyg.tiange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.yyg.tiange.util.ToastUtil;

public class PopupWindowActivity extends AppCompatActivity {
    private Button mBtnPopup;
    private PopupWindow mPopupwindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        mBtnPopup = findViewById(R.id.btn_popup1);
        mBtnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.layout_popup_window, null);
                mPopupwindow = new PopupWindow(view, mBtnPopup.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
//                mPopupwindow.setOutsideTouchable(true);
                mPopupwindow.setFocusable(true);
                TextView textView = view.findViewById(R.id.tv_good);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPopupwindow.dismiss();
                        ToastUtil.showMsg(getApplicationContext(), "感谢您的评价！");
                    }
                });
                mPopupwindow.showAsDropDown(mBtnPopup);
            }
        });
    }
}
