package com.yyg.genge.recyclerview;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.yyg.genge.R;

public class PubuRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvPubu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pubu_recycler_view);
        mRvPubu = findViewById(R.id.rv_pubu);
        mRvPubu.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRvPubu.setAdapter(new PubuAdapter(PubuRecyclerViewActivity.this, new PubuAdapter.OnItemClickListener() {
            @Override
            public void Oncl(int position) {
                Toast.makeText(PubuRecyclerViewActivity.this, "click PubuRecyclerItem " + position, Toast.LENGTH_SHORT).show();
            }
        }));
        mRvPubu.addItemDecoration(new MyDecoration());

    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        int gap = getResources().getDimensionPixelOffset(R.dimen.PubuDividerHeight);

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(gap, gap, 0, 0);
        }
    }
}
