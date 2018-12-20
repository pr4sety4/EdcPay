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
public class Deals extends Fragment implements DealsAndPromoAdapter.ItemClickListener {


    RecyclerView recyclerViewPromo;
    DealsAndPromoAdapter promoAdapter;
    ArrayList<Integer> image = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> desc = new ArrayList<>();

    public Deals() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_deals, container, false);


        image.add(R.drawable.ad1);
        image.add(R.drawable.ad2);
        image.add(R.drawable.ad3);
        image.add(R.drawable.ad4);
        image.add(R.drawable.ad5);

        title.add("Edc Pay");
        title.add("Edc Pay");
        title.add("Edc Pay");
        title.add("Edc Pay");
        title.add("Edc Pay");

        desc.add("Simpan dan pakai kartu digibank");
        desc.add("Kirim EdcPay Raih Iphone X");
        desc.add("Foto Momen 12.12 pakai EdcPay dapetin Samsung A9");
        desc.add("Jadilah akun Premium dapatkan pulsa 10k");
        desc.add("Mainkan Spin & Win raih separuh harga");

        recyclerViewPromo = view.findViewById(R.id.homePromoRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerViewPromo.setLayoutManager(linearLayoutManager);
        promoAdapter = new DealsAndPromoAdapter(getActivity(), image, title, desc);
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
