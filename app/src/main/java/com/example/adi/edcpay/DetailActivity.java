package com.example.adi.edcpay;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.example.adi.edcpay.adapter.SimpleNotifListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    CollapsingToolbarLayout collapsingToolbarLayout;
    ExpandableListView notifElv;
    ExpandableListAdapter listAdapter;
    List<String> listNotifHeader;
    HashMap<String, List<String>> listNotifChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Grape");

        collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.transparent));
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.rgb(255, 255, 255));

        notifElv = findViewById(R.id.elvDetail);

        prepareListData();

        listAdapter = new SimpleNotifListAdapter(this, listNotifHeader, listNotifChild);

        // setting list adapter
        notifElv.setAdapter(listAdapter);

    }

    private void prepareListData() {
        listNotifHeader = new ArrayList<String>();
        listNotifChild = new HashMap<String, List<String>>();

        // Adding child data
        listNotifHeader.add("Syarat dan Ketentuan");
        listNotifHeader.add("Cara Penggunaan");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        listNotifChild.put(listNotifHeader.get(0), top250); // Header, Child data
        listNotifChild.put(listNotifHeader.get(1), nowShowing);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
