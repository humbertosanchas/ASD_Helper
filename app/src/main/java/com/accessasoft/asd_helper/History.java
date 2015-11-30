package com.accessasoft.asd_helper;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by Paul Boyko on 11/25/2015.
 */
public class History extends TabActivity
{
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        tabHost = (TabHost) findViewById(android.R.id.tabhost);

        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("page1");
        tabSpec1.setIndicator("Tables");
        tabSpec1.setContent(new Intent(this, Tables.class));
        tabHost.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("page2");
        tabSpec2.setIndicator("Charts");
        tabSpec2.setContent(new Intent(this, Charts.class));
        tabHost.addTab(tabSpec2);

        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("page3");
        tabSpec3.setIndicator("Locations");
        tabSpec3.setContent(new Intent(this, Maps.class));
        tabHost.addTab(tabSpec3);
    }
}
