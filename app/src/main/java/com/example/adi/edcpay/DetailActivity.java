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
        setTitle("Edc Pay");

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
        top250.add(getResources().getString(R.string.syarat_and_ketentuan));

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("1. “Pengelola” adalah developer.");
        nowShowing.add("2. “Layanan” adalah segala bentuk aktivitas yang terjadi  yang diperuntukkan untuk pengguna.");
        nowShowing.add("3. “Jual Beli” adalah bagian yang berisi informasi mengenai penjualan dan pembelian barang dan jasa.");


        listNotifChild.put(listNotifHeader.get(0), top250); // Header, Child data
        listNotifChild.put(listNotifHeader.get(1), nowShowing);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
