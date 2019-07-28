package com.yyg.helloworld3.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yyg.helloworld3.R;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {
    private Context mContext;
    private OnItemClickListener mListener;

    public LinearAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_recycler_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder holder, final int i) {
        holder.textView.setText("Hello World!");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext, "click..." + i, Toast.LENGTH_SHORT).show();
                mListener.Oncl(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 88;
    }

    public interface OnItemClickListener {
        void Oncl(int position);
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_lrvitem);

        }
    }
}
