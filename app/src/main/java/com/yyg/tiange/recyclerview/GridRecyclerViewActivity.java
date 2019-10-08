package com.yyg.tiange.recyclerview;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.yyg.tiange.R;

public class GridRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        mRvGrid = findViewById(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this, 3));
        mRvGrid.setAdapter(new GridAdapter(GridRecyclerViewActivity.this, new GridAdapter.OnItemClickListener() {
            @Override
            public void Oncl(int position) {
                Toast.makeText(GridRecyclerViewActivity.this, "click GridRecyclerItem " + position, Toast.LENGTH_SHORT).show();
            }
        }));
        mRvGrid.addItemDecoration(new MyDecoration());
    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, getResources().getDimensionPixelOffset(R.dimen.DividerHeight), getResources().getDimensionPixelSize(R.dimen.DividerHeight));
        }
    }
}
