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
import com.example.adi.edcpay.adapter.DealsAndPromoAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Promo extends Fragment implements DealsAndPromoAdapter.ItemClickListener {


    RecyclerView recyclerViewPromo;
    DealsAndPromoAdapter promoAdapter;
    ArrayList<Integer> image = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> desc = new ArrayList<>();

    public Promo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_promo, container, false);

        image.add(R.drawable.promo1);
        image.add(R.drawable.promo4);
        image.add(R.drawable.promo5);

        title.add("Edc Pay");
        title.add("Edc Pay");
        title.add("Edc Pay");

        desc.add("Terima Kasih Telah Memilih Kami Sebagai Best App 2018!");
        desc.add("Buruan, Beli Gadget & Elektronik Idaman Sebelum Kehabisan!");
        desc.add("Kulit Sempurna Cerah Merona, Diskon hingga 20%");

        recyclerViewPromo = view.findViewById(R.id.homePromoRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerViewPromo.setLayoutManager(linearLayoutManager);
        promoAdapter = new DealsAndPromoAdapter(getActivity(), image, title, desc);

        recyclerViewPromo.setAdapter(promoAdapter);

        return view;
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        startActivity(intent);
    }
}
