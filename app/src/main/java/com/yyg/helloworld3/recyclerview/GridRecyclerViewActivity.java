package com.yyg.helloworld3.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yyg.helloworld3.R;

public class GridRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        mRvGrid = findViewById(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this,3));
//        mRvGrid.setAdapter(new );
    }
}
