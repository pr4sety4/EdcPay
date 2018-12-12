package com.example.adi.edcpay.content;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.example.adi.edcpay.DetailTransactionActivity;
import com.example.adi.edcpay.R;
import com.example.adi.edcpay.adapter.SimpleNotifListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Notification extends AppCompatActivity implements View.OnClickListener, ExpandableListView.OnChildClickListener {

    Toolbar notifMainToolbar;
    ExpandableListView notifElv;
    ExpandableListAdapter listAdapter;
    List<String> listNotifHeader;
    HashMap<String, List<String>> listNotifChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notifMainToolbar = findViewById(R.id.toolbarHeader);
        setSupportActionBar(notifMainToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        notifElv = findViewById(R.id.notificationElv);

        prepareListData();

        listAdapter = new SimpleNotifListAdapter(this, listNotifHeader, listNotifChild);

        // setting list adapter
        notifElv.setAdapter(listAdapter);

        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            notifElv.expandGroup(i);
        }

        notifElv.setOnChildClickListener(this);

    }

    private void prepareListData() {

        listNotifHeader = new ArrayList<String>();
        listNotifChild = new HashMap<String, List<String>>();

        // Adding child data
        listNotifHeader.add("11 November 2018");
        listNotifHeader.add("12 November 2018");
        listNotifHeader.add("13 November 2018");

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

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

        listNotifChild.put(listNotifHeader.get(0), top250); // Header, Child data
        listNotifChild.put(listNotifHeader.get(1), nowShowing);
        listNotifChild.put(listNotifHeader.get(2), comingSoon);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

        Intent intent = new Intent(this, DetailTransactionActivity.class);
        startActivity(intent);

        return true;
    }
}
