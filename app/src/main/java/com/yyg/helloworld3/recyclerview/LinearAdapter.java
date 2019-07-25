package com.yyg.helloworld3.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yyg.helloworld3.R;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {
    private Context mContext;
    private LinearLayout ll;

    public LinearAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_recycler_view_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder holder, int i) {
        holder.textView.setText("HelloWorld!");
    }

    @Override
    public int getItemCount() {
        return 88;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {

            super(itemView);
            textView = itemView.findViewById(R.id.tv_linearrecyclerviewitem);

        }
    }
}
