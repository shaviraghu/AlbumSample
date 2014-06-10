package com.sample.album.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sample.album.R;

import java.util.ArrayList;
import com.sample.utilities.ImageLoader;;

public class ItemsAdapter extends BaseAdapter {
    private ArrayList<Item> items;
    private Context mContext;
    private ImageLoader mImageLoader;

    public ItemsAdapter(ArrayList<Item> items, Context mContext) {
        this.items = items;
        this.mContext = mContext;
        this.mImageLoader = new ImageLoader(mContext);
    }

    class ViewHolder {
        ImageView imageView;
        TextView mainHeader;
        TextView secondaryHeader;
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
    	
    	ViewHolder holder;
    	
    	if(view == null)
    	{
    		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    		view = inflater.inflate(R.layout.list_item, viewGroup, false);
    		
    		//setup holder
    		holder = new ViewHolder();
    		holder.mainHeader = ((TextView) view.findViewById(R.id.main_header));
    		holder.secondaryHeader = ((TextView) view.findViewById(R.id.secondary_header));
    		holder.imageView = ((ImageView) view.findViewById(R.id.icon));
    		
    		view.setTag(holder);
    	}
    	else
    	{
    		holder = (ViewHolder) view.getTag();
    	}
    	
        Item item = (Item) getItem(i);
        holder.mainHeader.setText(item.getMainHeader());
        holder.secondaryHeader.setText(item.getSecondaryHeader());
        mImageLoader.displayImage(item.getImageURL(), holder.imageView);
      
        return view;
    }
}

