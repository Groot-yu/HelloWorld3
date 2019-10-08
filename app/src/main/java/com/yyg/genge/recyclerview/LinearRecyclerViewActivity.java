package com.yyg.genge.recyclerview;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.yyg.genge.R;

public class LinearRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);
        mRvLinear = findViewById(R.id.rv_linear);
        mRvLinear.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));
        mRvLinear.setAdapter(new LinearAdapter(LinearRecyclerViewActivity.this, new LinearAdapter.OnItemClickListener() {
            @Override
            public void Oncl(int position) {
                Toast.makeText(LinearRecyclerViewActivity.this, "click LinearRecyclerItem " + position, Toast.LENGTH_SHORT).show();
            }
        }));
        mRvLinear.addItemDecoration(new MyDecoration());
    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, 0, getResources().getDimensionPixelOffset(R.dimen.DividerHeight));
        }
    }
}
