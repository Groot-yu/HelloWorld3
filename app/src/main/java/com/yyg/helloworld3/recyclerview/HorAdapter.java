package com.yyg.helloworld3.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yyg.helloworld3.R;

public class HorAdapter extends RecyclerView.Adapter<HorAdapter.HorViewHolder> {
    private Context mContext;
    private OnItemClickListener mListener;

    public HorAdapter(Context context, OnItemClickListener listener) {
        mContext = context;
        mListener = listener;
    }

    @NonNull
    @Override
    public HorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new HorViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_horizontal_recycler_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HorViewHolder viewHolder, final int i) {
        viewHolder.textView.setText("Hello Forest!");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.Oncl(i);
            }
        })

        ;
    }

    @Override
    public int getItemCount() {
        return 88;
    }

    public interface OnItemClickListener {
        void Oncl(int position);
    }

    class HorViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public HorViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.tv_hrvitem);

        }
    }
}
