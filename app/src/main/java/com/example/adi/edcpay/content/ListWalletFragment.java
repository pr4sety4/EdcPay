package com.example.adi.edcpay.content;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adi.edcpay.R;
import com.example.adi.edcpay.adapter.ListWalletAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListWalletFragment extends Fragment implements ListWalletAdapter.ItemClickListener {


    RecyclerView recyclerViewListWallet;
    ListWalletAdapter listWalletAdapter;

    public ListWalletFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_wallet, container, false);

        //List Data
        ArrayList<String> title = new ArrayList<>();
        title.add("BHC");
        title.add("BTC");
        title.add("BTC");
        title.add("BHC");


        ArrayList<String> amount = new ArrayList<>();
        amount.add("0.0001752");
        amount.add("0.00018652");
        amount.add("0.0001242");
        amount.add("0.01562");

        ArrayList<String> status = new ArrayList<>();
        status.add("send");
        status.add("sell");
        status.add("sell");
        status.add("send");

        recyclerViewListWallet = view.findViewById(R.id.listWalletRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerViewListWallet.setLayoutManager(linearLayoutManager);
        listWalletAdapter = new ListWalletAdapter(getActivity(), title, amount, status);
        listWalletAdapter.setItemClickListener(this);
        recyclerViewListWallet.setAdapter(listWalletAdapter);
        return view;
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), DetailsWalletActivity.class);
        startActivity(intent);
    }
}
