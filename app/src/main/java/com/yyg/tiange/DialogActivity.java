package com.yyg.tiange;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yyg.tiange.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {
    private Button mBtnDialog1, mBtnDialog2, mBtnDialog3, mBtnDialog4, mbtnDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mBtnDialog1 = findViewById(R.id.btn_dialog1);
        mBtnDialog2 = findViewById(R.id.btn_dialog2);
        mBtnDialog3 = findViewById(R.id.btn_dialog3);
        mBtnDialog4 = findViewById(R.id.btn_dialog4);
        mbtnDialog5 = findViewById(R.id.btn_dialog5);
        setListener();
    }

    private void setListener() {
        OnClick onClick = new OnClick();
        mBtnDialog1.setOnClickListener(onClick);
        mBtnDialog2.setOnClickListener(onClick);
        mBtnDialog3.setOnClickListener(onClick);
        mBtnDialog4.setOnClickListener(onClick);
        mbtnDialog5.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("请回答：").setMessage("你觉得课程如何？")
                            .setIcon(R.drawable.icon_username)
                            .setPositiveButton("棒", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this, "你很诚实；");
                                }
                            })
                            .setNeutralButton("还行", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this, "你再瞅瞅；");
                                }
                            })
                            .setNegativeButton("不行", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this, "睁眼说瞎话；");
                                }
                            })
                            .show();
                    break;
                case R.id.btn_dialog2:
                    final String[] array2 = new String[]{"男", "女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("选择性别：")
                            .setItems(array2, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this, array2[which]);
                                }
                            }).show();
                    break;

                case R.id.btn_dialog3:
                    final String[] array3 = new String[]{"已知", "未知"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("选择世界：")
                            .setSingleChoiceItems(array3, 0, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this, array3[which]);
                                    dialog.dismiss();
//                                    dialog.cancel();
                                }
                            })
                            .setCancelable(false).show();
                    break;
                case R.id.btn_dialog4:
                    final String[] array4 = new String[]{"剧", "漫", "乐", "生"};
                    boolean[] isSelected = new boolean[]{false, false, false, true};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("选择兴趣：")
                            .setMultiChoiceItems(array4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                    ToastUtil.showMsg(DialogActivity.this, array4[which] + isChecked);
                                }
                            })
                            .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this, "提交完成");
                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(DialogActivity.this, "未提交");
                                }
                            }).setCancelable(false).show();
                    break;
                case R.id.btn_dialog5:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogActivity.this);
                    View view = LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog5, null, false);
                    EditText etUsername = view.findViewById(R.id.et_username);
                    EditText etPassword = view.findViewById(R.id.et_password);
                    Button btnRegister = view.findViewById(R.id.btn_register);
                    Button btnLogin = view.findViewById(R.id.btn_login);
                    builder5.setTitle("请先注册或登录").setView(view).setCancelable(false).show();
                    break;

            }
        }
    }
}
