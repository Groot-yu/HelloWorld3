package com.yyg.tiange.datastorage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yyg.tiange.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExternalStorageActivity extends AppCompatActivity {
    private EditText mEtContent;
    private Button mBtnSave, mBtnShow;
    private TextView mTvData;
    private final String mFileName = "test.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);
        mEtContent = findViewById(R.id.et_content);
        mBtnSave = findViewById(R.id.btn_save);
        mBtnShow = findViewById(R.id.btn_show);
        mTvData = findViewById(R.id.tv_data);
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(mEtContent.getText().toString().trim());
                //trim()去除前后空格
            }
        });
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvData.setText(read());
            }
        });

    }

    //存储数据
    private void save(String content) {
        FileOutputStream out = null;
        try {
            File dir = new File(Environment.getExternalStorageDirectory(), "yyg");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File file = new File(dir, mFileName);
            if (file.exists()) {
                file.createNewFile();
            }
            out = new FileOutputStream(file);
            out.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String read() {
        FileInputStream in = null;
        StringBuilder content = new StringBuilder();
        try {
           File file= new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"yyg",mFileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            in = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = in.read(bytes)) > 0) {
                content.append(new String(bytes, 0, len));
            }
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

