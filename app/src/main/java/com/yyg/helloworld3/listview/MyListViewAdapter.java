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

public class MyListViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    MyListViewAdapter(Context context) {
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
        public ImageView ivlist;
        public TextView tvtitle, tvtime, tvcontent;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.layout_list_item, null);
            vh = new ViewHolder();
            vh.ivlist = convertView.findViewById(R.id.iv_list);
            vh.tvtitle = convertView.findViewById(R.id.tv_title);
            vh.tvtime = convertView.findViewById(R.id.tv_time);
            vh.tvcontent = convertView.findViewById(R.id.tv_content);
            convertView.setTag(vh);
        } else {
//          给vh赋值 连接vh convertView
            vh = (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext).load("https://gss1.bdstatic.com/9vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=30fe99efcecec3fd9f33af27b7e1bf5a/7a899e510fb30f24cb4b8820c595d143ad4b033b.jpg").into(vh.ivlist);
//        Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563387058265&di=2c2c069a53a05feb4067b6bd4c7a278f&imgtype=0&src=http%3A%2F%2Fimg10.360buyimg.com%2FpopWaterMark%2Fg14%2FM07%2F17%2F1A%2FrBEhV1JrXO4IAAAAAAGSGuv1EaUAAEqAwBw-a0AAZIy171.jpg").into(vh.iv);

        vh.tvtitle.setText("挪威的森林");
        vh.tvtime.setText("2019-07-17");
        vh.tvcontent.setText("《挪威的森林》是日本作家村上春树于1987年所著的一部长篇爱情小说。");
        return convertView;
    }
}
