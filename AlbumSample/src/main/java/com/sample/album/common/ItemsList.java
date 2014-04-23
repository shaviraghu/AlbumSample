package com.sample.album.common;

import android.app.ListFragment;
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
        for (int i = 0; i < 1000; i++){
            Item item = new Item();
            item.setMainHeader("Album " + i);
            item.setSecondaryHeader("Gender " + i);
            dummies.add(item);
        }

        ItemsAdapter adapter = new ItemsAdapter(dummies, getActivity());
        setListAdapter(adapter);
    }
}
