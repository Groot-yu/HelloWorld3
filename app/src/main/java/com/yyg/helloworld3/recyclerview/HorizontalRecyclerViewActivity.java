package com.yyg.helloworld3.recyclerview;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.yyg.helloworld3.R;

public class HorizontalRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_recycler_view);
        mRvHorizontal = findViewById(R.id.rv_horizontal);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HorizontalRecyclerViewActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvHorizontal.setLayoutManager(linearLayoutManager);
        mRvHorizontal.setAdapter(new HorAdapter(HorizontalRecyclerViewActivity.this, new HorAdapter.OnItemClickListener() {
            @Override
            public void Oncl(int position) {
                Toast.makeText(HorizontalRecyclerViewActivity.this, "click HorizontalRecyclerItem " + position, Toast.LENGTH_SHORT).show();

            }
        }));
        mRvHorizontal.addItemDecoration(new MyDecoration());
    }

    class MyDecoration extends RecyclerView.ItemDecoration {
//        本身没有颜色，只是抻开间距、露出底色 即recyclerview的background 非item的background
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, getResources().getDimensionPixelOffset(R.dimen.DividerHeight), 0);
        }
    }
}
