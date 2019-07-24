package com.yyg.helloworld3.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yyg.helloworld3.R;


public class MyGridViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    MyGridViewAdapter(Context context) {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder {
        public ImageView ivgrid;
        public TextView tvtitle;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.layout_grid_item, null);
            vh = new ViewHolder();
            vh.ivgrid = convertView.findViewById(R.id.iv_grid);
            vh.tvtitle = convertView.findViewById(R.id.tv_title);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563387058265&di=2c2c069a53a05feb4067b6bd4c7a278f&imgtype=0&src=http%3A%2F%2Fimg10.360buyimg.com%2FpopWaterMark%2Fg14%2FM07%2F17%2F1A%2FrBEhV1JrXO4IAAAAAAGSGuv1EaUAAEqAwBw-a0AAZIy171.jpg").into(vh.ivgrid);
        vh.tvtitle.setText("挪威的森林");
        return convertView;
    }


}
