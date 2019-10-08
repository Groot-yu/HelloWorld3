package com.yyg.tiange.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.yyg.tiange.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {
    private Context mContext;
    private OnItemClickListener mListener;

    public GridAdapter(Context context, OnItemClickListener listener) {
        mContext = context;
        mListener = listener;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new GridViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_grid_recycler_item, viewGroup, false));

    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder viewHolder, final int i) {
        viewHolder.textView.setText("Hello Ocean!");
        viewHolder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mListener.Oncl(i);
                    }
                }
        );
    }

    @Override
    public int getItemCount() {
        return 88;
    }

    public interface OnItemClickListener {
        void Oncl(int position);
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_grvitem);
        }
    }
}
