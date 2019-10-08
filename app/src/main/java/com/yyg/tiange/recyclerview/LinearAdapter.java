package com.yyg.tiange.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yyg.tiange.R;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private OnItemClickListener mListener;

    public LinearAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == 0) {
            return new LinearViewHolder0(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_recycler_item0, viewGroup, false));
        } else {
            return new LinearViewHolder1(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_recycler_item1, viewGroup, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position) == 0) {
            ((LinearViewHolder0) holder).textView.setText("Hello World!");
        } else {
            ((LinearViewHolder1) holder).textView.setText("Hello Ocean!");
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext, "click..." + i, Toast.LENGTH_SHORT).show();
                mListener.Oncl(position);
            }
        });

    }

    //    @Override
//    public int getItemViewType(int position) {
//        return super.getItemViewType(position);
//    }
    @Override
    public int getItemViewType(int i) {
        if (i % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return 88;
    }

    public interface OnItemClickListener {
        void Oncl(int position);
    }

    class LinearViewHolder0 extends RecyclerView.ViewHolder {
        private TextView textView;

        public LinearViewHolder0(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_lrvitem);
        }
    }

    class LinearViewHolder1 extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public LinearViewHolder1(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_lrvitem);
            imageView = itemView.findViewById(R.id.iv_linearitem);
        }
    }
}
