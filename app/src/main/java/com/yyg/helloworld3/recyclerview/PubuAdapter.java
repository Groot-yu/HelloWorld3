package com.yyg.helloworld3.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yyg.helloworld3.R;

public class PubuAdapter extends RecyclerView.Adapter<PubuAdapter.PubuViewHolder> {
    private Context mContext;
    private OnItemClickListener mListener;

    public PubuAdapter(Context context, OnItemClickListener listener) {
        mContext = context;
        mListener = listener;
    }

    @NonNull
    @Override
    public PubuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new PubuViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_pubu_recycler_item, viewGroup, false));

    }

    @Override
    public void onBindViewHolder(@NonNull PubuViewHolder viewHolder, final int i) {
        if (i % 2 == 0) {
            viewHolder.imageView.setImageResource(R.drawable.pubu_imageview0);
        } else {
            viewHolder.imageView.setImageResource(R.drawable.pubu_imageview1);
        }
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

    class PubuViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public PubuViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_pubuitem);
        }
    }
}
