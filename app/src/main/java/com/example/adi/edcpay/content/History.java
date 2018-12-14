package com.example.adi.edcpay.content;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.example.adi.edcpay.DetailTransactionActivity;
import com.example.adi.edcpay.R;
import com.example.adi.edcpay.adapter.NotificationListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class History extends Fragment implements ExpandableListView.OnChildClickListener {

    Toolbar notifMainToolbar;
    ExpandableListView notifElv;
    ExpandableListAdapter listAdapter;
    List<String> listNotifHeader;
    HashMap<String, List<String>> listNotifChild;

    public History() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_history, container, false);

        notifElv = view.findViewById(R.id.historyElv);

        prepareListData();

        listAdapter = new NotificationListAdapter(getActivity(), listNotifHeader, listNotifChild);
        // setting list adapter
        notifElv.setAdapter(listAdapter);

        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            notifElv.expandGroup(i);
        }

        notifElv.setOnChildClickListener(this);
        return view;
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
        top250.add("Grab");
        top250.add("KFC");
        top250.add("Shihlin");
        top250.add("Miniso");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("Grab");
        nowShowing.add("KFC");
        nowShowing.add("Shihlin");
        nowShowing.add("Miniso");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Grab");
        comingSoon.add("KFC");
        comingSoon.add("Shihlin");
        comingSoon.add("Miniso");

        listNotifChild.put(listNotifHeader.get(0), top250); // Header, Child data
        listNotifChild.put(listNotifHeader.get(1), nowShowing);
        listNotifChild.put(listNotifHeader.get(2), comingSoon);
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

        Intent intent = new Intent(getActivity(), DetailTransactionActivity.class);
        startActivity(intent);

        return true;
    }
}
