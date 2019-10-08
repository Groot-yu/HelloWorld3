package com.yyg.genge.datastorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yyg.genge.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {
    private EditText mEtContent;
    private Button mBtnSave, mBtnShow;
    private TextView mTvData;
    private final String mFileName = "test.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
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
            out = openFileOutput(mFileName, MODE_PRIVATE);
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

    //使用OutoutStreamWriter  不会去空格  尽量使用接近底层数据如getbyte()和new String(bytes, 0, len)的方法
//    private void save(String content) {
//        FileOutputStream out = null;
//        BufferedWriter writer = null;
//        try {
//            out = openFileOutput(mFileName, MODE_PRIVATE);
//            writer = new BufferedWriter(new OutputStreamWriter(out));
//            writer.write(content);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (writer != null) {
//                try {
//                    writer.flush();
//                    writer.close();
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    //读取数据
    private String read() {
        FileInputStream in = null;
        StringBuilder content = null;
        try {
            in = openFileInput(mFileName);
            byte[] bytes = new byte[1024];
            content = new StringBuilder();
            int len = 0;
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

        //会去除空格 弃用
//    private String read() {
//        FileInputStream in = null;
//        BufferedReader reader = null;
//        StringBuilder content = null;
//        try {
//            in = openFileInput(mFileName);
//            reader = new BufferedReader(new InputStreamReader(in));
//            content = new StringBuilder();
//            String line = "";
//            while ((line = reader.readLine()) != null) {
//                content.append(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                    in.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return content.toString();
//    }
}
