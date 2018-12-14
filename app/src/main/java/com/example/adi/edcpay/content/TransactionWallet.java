package com.example.adi.edcpay.content;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adi.edcpay.R;
import com.example.adi.edcpay.adapter.ListTransactionWalletAdapter;
import com.example.adi.edcpay.model.ListTransactionWalletHeader;
import com.example.adi.edcpay.model.ListTransactionWalletItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransactionWallet extends Fragment {


    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ListTransactionWalletAdapter listTransactionWalletAdapter;

    public TransactionWallet() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transaction_wallet, container, false);

        recyclerView = view.findViewById(R.id.transactionWalletRecyclerView);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        listTransactionWalletAdapter = new ListTransactionWalletAdapter(getActivity(), getHeader(), getListItems());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(listTransactionWalletAdapter);

        return view;
    }

    private List<ListTransactionWalletItem> getListItems() {
        List<ListTransactionWalletItem> listItems = new ArrayList<ListTransactionWalletItem>();

        ListTransactionWalletItem listItem1 = new ListTransactionWalletItem();
        listItem1.setTitle("Bought BTC 0.00003523 for idr 44,000");
        listItem1.setDate("January 12");
        listItem1.setAmount("BTC 0.000314");
        listItem1.setStatus("success");
        listItem1.setImageResource(R.drawable.bpjstitleicon);

        ListTransactionWalletItem listItem2 = new ListTransactionWalletItem();
        listItem2.setTitle("Sold 0.02 ETH/BTC @0.0187");
        listItem2.setDate("January 10");
        listItem2.setAmount("BTC 0.001614");
        listItem2.setStatus("success");
        listItem2.setImageResource(R.drawable.bpjstitleicon);

        ListTransactionWalletItem listItem3 = new ListTransactionWalletItem();
        listItem3.setTitle("Bitcoin send fee");
        listItem3.setDate("January 9");
        listItem3.setAmount("BTC 0.000314");
        listItem3.setStatus("fail");
        listItem3.setImageResource(R.drawable.bpjstitleicon);

        ListTransactionWalletItem listItem4 = new ListTransactionWalletItem();
        listItem4.setTitle("Deposit OCtoin");
        listItem4.setDate("January 7");
        listItem4.setAmount("BTC 0.0001614");
        listItem4.setStatus("fail");
        listItem4.setImageResource(R.drawable.bpjstitleicon);

        listItems.add(listItem1);
        listItems.add(listItem2);
        listItems.add(listItem3);
        listItems.add(listItem4);

        return listItems;
    }

    private ListTransactionWalletHeader getHeader() {
        ListTransactionWalletHeader header = new ListTransactionWalletHeader();
        header.setHeader("January 2018");
        return header;
    }

}
