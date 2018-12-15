package com.example.adi.edcpay.content;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adi.edcpay.R;
import com.example.adi.edcpay.WithdrawActivity;
import com.example.adi.edcpay.adapter.WithdrawAdapter;
import com.example.adi.edcpay.util.Constant;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WithdrawFragment extends BottomSheetDialogFragment implements WithdrawAdapter.ItemClickListener {


    RecyclerView recyclerViewWithdraw;
    WithdrawAdapter withdrawAdapter;
    ArrayList<Integer> image = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();

    public WithdrawFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_withdraw, container, false);

        image.add(R.drawable.permata);
        image.add(R.drawable.bri);
        image.add(R.drawable.bni);

        title.add("Bank Permata Tbk x3722");
        title.add("Bank Rakyat Indonesia x5500");
        title.add("Bank Nasional Indonesia x3239");

        recyclerViewWithdraw = view.findViewById(R.id.withdrawRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerViewWithdraw.setLayoutManager(linearLayoutManager);
        withdrawAdapter = new WithdrawAdapter(getActivity(), image, title);
        withdrawAdapter.setClickListener(this);
        recyclerViewWithdraw.setAdapter(withdrawAdapter);

        return view;
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), WithdrawActivity.class);
        intent.putExtra(Constant.TITLE, title.get(position));
        startActivity(intent);
    }
}
