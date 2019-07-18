package com.yyg.helloworld3.gridview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yyg.helloworld3.listview.MyListAdapter;

public class MyGridAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
//    MyGridAdapter(m){

    //    }
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
        public TextView tv;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
