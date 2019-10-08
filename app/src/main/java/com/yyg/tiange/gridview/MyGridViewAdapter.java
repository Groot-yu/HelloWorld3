package com.yyg.tiange.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yyg.tiange.R;


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
        Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563985107481&di=dca2f940d5ff9ebf0992d086afab17b1&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201201%2F07%2F20120107154546_Cxzk8.thumb.700_0.jpg").into(vh.ivgrid);
        vh.tvtitle.setText("花");
        return convertView;
    }


}
