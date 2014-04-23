package com.sample.album.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sample.album.R;

import java.util.ArrayList;

public class ItemsAdapter extends BaseAdapter {
    private ArrayList<Item> items;
    private Context mContext;

    public ItemsAdapter(ArrayList<Item> items, Context mContext) {
        this.items = items;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_item, viewGroup, false);

        Item item = (Item) getItem(i);
        ((TextView) view.findViewById(R.id.main_header)).setText(item.getMainHeader());
        ((TextView) view.findViewById(R.id.secondary_header)).setText(item.getSecondaryHeader());

        return view;
    }
}
