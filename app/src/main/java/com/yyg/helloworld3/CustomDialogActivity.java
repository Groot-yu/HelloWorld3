package com.yyg.helloworld3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yyg.helloworld3.widget.CustomDialog;

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
                CustomDialog dialog = new CustomDialog(CustomDialogActivity.this);
                dialog.show();
            }
        });

    }
}
