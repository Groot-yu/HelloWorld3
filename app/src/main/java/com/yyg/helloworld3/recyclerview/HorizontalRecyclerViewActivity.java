package com.yyg.helloworld3.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.yyg.helloworld3.R;

public class HorizontalRecyclerViewActivity extends AppCompatActivity {
private RecyclerView mRvHorizontal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_recycler_view);
        mRvHorizontal=findViewById(R.id.rv_horizontal);
//        mRvHorizontal.setAdapter();
    }
}
