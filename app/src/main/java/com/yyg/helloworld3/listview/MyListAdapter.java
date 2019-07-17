package com.yyg.helloworld3.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yyg.helloworld3.R;

public class MyListAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    MyListAdapter(Context context) {
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 2;
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
        public ImageView iv;
        public TextView tvtitle, tvtime, tvcontent;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.layout_list_item, null);
            vh = new ViewHolder();
            vh.iv = convertView.findViewById(R.id.iv);
            vh.tvtitle = convertView.findViewById(R.id.tv_title);
            vh.tvtime = convertView.findViewById(R.id.tv_time);
            vh.tvcontent = convertView.findViewById(R.id.tv_content);
            convertView.setTag(vh);
        } else {
//          给vh赋值 连接vh convertView
            vh = (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext).load("https://www.baidu.com/img/emoji_58912914459c4f54cdc3d61bd6eac927.gif").into(vh.iv);
        vh.tvtitle.setText("这是标题");
        vh.tvtime.setText("2019-07-17");
        vh.tvcontent.setText("《挪威的森林》是日本作家村上春树于1987年所著的一部长篇爱情小说。");
        return convertView;
    }
}
