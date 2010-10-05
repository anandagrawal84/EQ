package com.android.eq;

import android.*;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class EmotionsAdapter extends BaseAdapter {
    private Context mContext;

    public EmotionsAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return 9;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view;
        if (convertView == null) {
            view = new TextView(mContext);
            view.setLayoutParams(new GridView.LayoutParams(85, 85));
            view.setPadding(30, 30, 30, 30);
            view.setText(position - 4 + "");
            view.setBackgroundColor(android.R.color.white);
            parent.setBackgroundColor(android.R.color.white);

        } else {
            view = (TextView) convertView;

        }
        return view;
    }
}
