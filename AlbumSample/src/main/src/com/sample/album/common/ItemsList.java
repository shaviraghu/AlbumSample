package com.sample.album.common;

import android.app.ListFragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;


public class ItemsList extends ListFragment {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     // Generate a list of 1000 dummy items
        ArrayList<Item> dummies = new ArrayList<Item>();
        String itemType = getArguments().getString("itemType");
        
        String[] mStrings={
                "http://androidexample.com/media/webservice/LazyListView_images/image0.png",
                "http://androidexample.com/media/webservice/LazyListView_images/image1.png",
                "http://androidexample.com/media/webservice/LazyListView_images/image2.png",
                "http://androidexample.com/media/webservice/LazyListView_images/image3.png",
                "http://androidexample.com/media/webservice/LazyListView_images/image4.png",
                "http://androidexample.com/media/webservice/LazyListView_images/image5.png",
                "http://androidexample.com/media/webservice/LazyListView_images/image6.png",
                "http://androidexample.com/media/webservice/LazyListView_images/image7.png",
                "http://androidexample.com/media/webservice/LazyListView_images/image8.png",
                "http://androidexample.com/media/webservice/LazyListView_images/image9.png",
                "http://androidexample.com/media/webservice/LazyListView_images/image10.png",
                };
        
        for (int i = 0; i < 1000; i++){
            Item item = new Item();
            item.setMainHeader(itemType+ " " + i);
            item.setSecondaryHeader("Gender " + i);
            item.setImageURL(mStrings[i%11]);
            dummies.add(item);
        }

        ItemsAdapter adapter = new ItemsAdapter(dummies, getActivity());
        setListAdapter(adapter);
	}
	
}