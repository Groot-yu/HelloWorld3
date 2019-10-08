package com.yyg.genge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yyg.genge.util.ToastUtil;
import com.yyg.genge.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {
    private Button mBtnCustomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        mBtnCustomDialog = findViewById(R.id.btn_customdialog);
        mBtnCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog dialog = new CustomDialog(CustomDialogActivity.this, R.style.CustomDialog);
//                加了Style xml内background drawable才生效
                dialog.setCancel("取消", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog dialog) {
                        ToastUtil.showMsg(CustomDialogActivity.this, "已取消");
                        dialog.dismiss();
                    }
                }).setConfirm("确认", new CustomDialog.IOnConfirmListener() {
                    @Override
                    public void onConfirm(CustomDialog dialog) {
                        ToastUtil.showMsg(CustomDialogActivity.this, "已删除");
                        dialog.dismiss();
                    }
                });
//                dialog.
                dialog.show();
            }
        });

    }
}
