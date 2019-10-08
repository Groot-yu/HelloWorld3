package com.yyg.tiange.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.yyg.tiange.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnClick {

    private AFragment aFragment;
    private TextView mTvTitle;
//    private Button mBtnChangeF;
//    private BFragment bFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
//        实例化AFragment
        aFragment = AFragment.newInstance("实例化时传入参数");
//        把Fragment添加到FrameLayout组件中 记得commit
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, aFragment, "a").commitAllowingStateLoss();

//        mBtnChangeF = findViewById(R.id.btn_change);
//        mBtnChangeF.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (bFragment == null) {
//                    bFragment = new BFragment();
//                }
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).commitAllowingStateLoss();
//            }
//        });
        mTvTitle = findViewById(R.id.tv_title);

    }

    @Override
    public void onClick(String text) {
        mTvTitle.setText(text);
    }
}
