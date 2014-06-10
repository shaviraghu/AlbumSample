package com.sample.album;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.sample.album.common.ItemsList;


public class AlbumSampleMain extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_sample_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(String selectedItem) {
        FragmentManager fragmentManager = getFragmentManager();
        Bundle args = new Bundle();
        args.putString("itemType", selectedItem.substring(0, selectedItem.length()-1));
        ItemsList itemsList = new ItemsList();
        itemsList.setArguments(args);
        fragmentManager.beginTransaction()
                .replace(R.id.container, itemsList)
                .commit();
        if(getFragmentManager().findFragmentById(R.id.detailcontainer)!=null) {
	        ItemsList itemsList2 = new ItemsList();
	        itemsList2.setArguments(args);
	        fragmentManager.beginTransaction()
	        .replace(R.id.detailcontainer, itemsList2)
	        .commit();
        }
    }
}
