package com.yyg.helloworld3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.yyg.helloworld3.fragment.ContainerActivity;
import com.yyg.helloworld3.gridview.GridViewActivity;
import com.yyg.helloworld3.jump.AActivity;
import com.yyg.helloworld3.listview.ListViewActivity;
import com.yyg.helloworld3.recyclerview.GridRecyclerViewActivity;
import com.yyg.helloworld3.recyclerview.HorizontalRecyclerViewActivity;
import com.yyg.helloworld3.recyclerview.LinearRecyclerViewActivity;
import com.yyg.helloworld3.recyclerview.PubuRecyclerViewActivity;


public class UiActivity extends AppCompatActivity {
    //    private Button nBtnTextView, mBtnButton, mBtnEditText, mBtnRadioButton;
//
//    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        setListener();
//        mBtnRadioButton = findViewById(R.id.btn_radiobutton);
//        mBtnRadioButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                跳转到RadioButton演示界面
//                Intent intent = new Intent(UiActivity.this, RadioButtonActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    private void setListener() {
        OnClick onClick = new OnClick();
        findViewById(R.id.btn_textview).setOnClickListener(onClick);
        findViewById(R.id.btn_button).setOnClickListener(onClick);
        findViewById(R.id.btn_edittext).setOnClickListener(onClick);
        findViewById(R.id.btn_menu).setOnClickListener(onClick);
        findViewById(R.id.btn_radiobutton).setOnClickListener(onClick);
        findViewById(R.id.btn_checkbox).setOnClickListener(onClick);
        findViewById(R.id.btn_imageview).setOnClickListener(onClick);
        findViewById(R.id.btn_listview).setOnClickListener(onClick);
        findViewById(R.id.btn_gridview).setOnClickListener(onClick);
        findViewById(R.id.btn_linearrecyclerview).setOnClickListener(onClick);
        findViewById(R.id.btn_horizontalrecyclerview).setOnClickListener(onClick);
        findViewById(R.id.btn_gridrecyclerview).setOnClickListener(onClick);
        findViewById(R.id.btn_puburecyclerview).setOnClickListener(onClick);
        findViewById(R.id.btn_webview).setOnClickListener(onClick);
        findViewById(R.id.btn_toast).setOnClickListener(onClick);
        findViewById(R.id.btn_dialog).setOnClickListener(onClick);
        findViewById(R.id.btn_progress).setOnClickListener(onClick);
        findViewById(R.id.btn_customdialog).setOnClickListener(onClick);
        findViewById(R.id.btn_popupwindow).setOnClickListener(onClick);
        findViewById(R.id.btn_lifecycle).setOnClickListener(onClick);
        findViewById(R.id.btn_jumpa).setOnClickListener(onClick);
        findViewById(R.id.btn_fragment).setOnClickListener(onClick);

    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_textview:
//                    跳转到TextView界面
                    intent = new Intent(UiActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_button:
//                    跳转到Button界面
                    intent = new Intent(UiActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_edittext:
//                    跳转到EditText界面
                    intent = new Intent(UiActivity.this, EditTextActivity.class);
                    break;
//                    跳转到Menu界面
                case R.id.btn_menu:
                    intent=new Intent(UiActivity.this,MenuActivity.class);
                    break;
                case R.id.btn_radiobutton:
//                    跳转到RadioButton界面
                    intent = new Intent(UiActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_checkbox:
                    intent = new Intent(UiActivity.this, CheckBoxActivity.class);
                    break;
//                    跳转到ImageView演示界面
                case R.id.btn_imageview:
                    intent = new Intent(UiActivity.this, ImageViewActivity.class);
                    break;
//                    跳转到LidtView演示界面
                case R.id.btn_listview:
                    intent = new Intent(UiActivity.this, ListViewActivity.class);
                    break;
//                    跳转到GridView演示界面
                case R.id.btn_gridview:
                    intent = new Intent(UiActivity.this, GridViewActivity.class);
                    break;
//                    跳转到LinearRecyclerView演示界面
                case R.id.btn_linearrecyclerview:
                    intent = new Intent(UiActivity.this, LinearRecyclerViewActivity.class);
                    break;
//                    跳转到HorizontalRecyclerView演示界面
                case R.id.btn_horizontalrecyclerview:
                    intent = new Intent(UiActivity.this, HorizontalRecyclerViewActivity.class);
                    break;
//                    跳转到GridRecyclerView演示界面
                case R.id.btn_gridrecyclerview:
                    intent = new Intent(UiActivity.this, GridRecyclerViewActivity.class);
                    break;
//                    跳转到PubuRecyclerView演示界面
                case R.id.btn_puburecyclerview:
                    intent = new Intent(UiActivity.this, PubuRecyclerViewActivity.class);
                    break;
//                    跳转到WebView演示界面
                case R.id.btn_webview:
                    intent = new Intent(UiActivity.this, WebViewActivity.class);
                    break;
//                    跳转到Toast演示界面
                case R.id.btn_toast:
                    intent = new Intent(UiActivity.this, ToastActivity.class);
                    break;
//                    跳转到Toast演示界面
                case R.id.btn_dialog:
                    intent = new Intent(UiActivity.this, DialogActivity.class);
                    break;
//                    跳转到Progress演示界面
                case R.id.btn_progress:
                    intent = new Intent(UiActivity.this, ProgressActivity.class);
                    break;
//                    跳转到CustomDialog演示界面
                case R.id.btn_customdialog:
                    intent = new Intent(UiActivity.this, CustomDialogActivity.class);
                    break;
//                    跳转到PopupWindow演示界面
                case R.id.btn_popupwindow:
                    intent = new Intent(UiActivity.this, PopupWindowActivity.class);
                    break;
//                    跳转到LifeCycle演示界面
                case R.id.btn_lifecycle:
                    intent = new Intent(UiActivity.this, LifeCycleActivity.class);
                    break;
//                    跳转到JumpA演示界面
                case R.id.btn_jumpa:
                    intent = new Intent(UiActivity.this, AActivity.class);
                    break;
//                    跳转到Fragment演示界面
                case R.id.btn_fragment:
                    intent = new Intent(UiActivity.this, ContainerActivity.class);
                    startActivity(intent);
                    break;


            }
            startActivity(intent);
        }
    }
}
