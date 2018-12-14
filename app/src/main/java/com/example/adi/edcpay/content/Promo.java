package com.example.adi.edcpay.content;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adi.edcpay.DetailActivity;
import com.example.adi.edcpay.R;
import com.example.adi.edcpay.adapter.PromoAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Promo extends Fragment implements PromoAdapter.ItemClickListener {


    RecyclerView recyclerViewPromo;
    PromoAdapter promoAdapter;

    public Promo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_promo, container, false);

        ArrayList<Integer> image = new ArrayList<>();
        image.add(R.drawable.ad2);
        image.add(R.drawable.ad3);

        recyclerViewPromo = view.findViewById(R.id.homePromoRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerViewPromo.setLayoutManager(linearLayoutManager);
        promoAdapter = new PromoAdapter(image, getActivity());
        promoAdapter.setClickListener(this);
        recyclerViewPromo.setAdapter(promoAdapter);

        return view;
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        startActivity(intent);
    }
}
