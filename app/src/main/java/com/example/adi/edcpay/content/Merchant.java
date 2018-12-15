package com.example.adi.edcpay.content;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.adi.edcpay.DetailActivity;
import com.example.adi.edcpay.PromoActivity;
import com.example.adi.edcpay.R;
import com.example.adi.edcpay.adapter.PromoAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Merchant extends Fragment implements PromoAdapter.ItemClickListener, View.OnClickListener {


    public Merchant() {
        // Required empty public constructor
    }

    CardView imgNearMe, imgDealsnPromo, imgMyVouchers, imgMall, imgMerchants;

    ImageView imgHealth, imgEntertainmet, imgFood, imgShopping, imgTransport, imgEducation, imgGift, imgTravel, imgSport;
    RecyclerView recyclerViewPromo;
    PromoAdapter promoAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_merchant, container, false);

        imgNearMe = view.findViewById(R.id.nearMeIcon);
        imgDealsnPromo = view.findViewById(R.id.dealsAndPromoIcon);
        imgMyVouchers = view.findViewById(R.id.voucherIcon);
        imgMall = view.findViewById(R.id.mallIcon);
        imgMerchants = view.findViewById(R.id.merchantsIcon);
        imgHealth = view.findViewById(R.id.healthIcon);
        imgEntertainmet = view.findViewById(R.id.entertainmentIcon);
        imgFood = view.findViewById(R.id.foodIcon);
        imgShopping = view.findViewById(R.id.shoppingIcon);
        imgTransport = view.findViewById(R.id.transportIcon);
        imgEducation = view.findViewById(R.id.educationIcon);
        imgGift = view.findViewById(R.id.giftIcon);
        imgTravel = view.findViewById(R.id.travelIcon);
        imgSport = view.findViewById(R.id.sportIcon);

        ArrayList<Integer> image = new ArrayList<>();
        image.add(R.drawable.ad1);
        image.add(R.drawable.ad2);
        image.add(R.drawable.ad3);
        image.add(R.drawable.ad4);
        image.add(R.drawable.ad5);

        recyclerViewPromo = view.findViewById(R.id.homePromoRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPromo.setLayoutManager(linearLayoutManager);
        promoAdapter = new PromoAdapter(image, getActivity());
        promoAdapter.setClickListener(this);
        recyclerViewPromo.setAdapter(promoAdapter);

        imgNearMe.setOnClickListener(this);
        imgDealsnPromo.setOnClickListener(this);
        imgMyVouchers.setOnClickListener(this);
        imgMall.setOnClickListener(this);
        imgMerchants.setOnClickListener(this);
        imgHealth.setOnClickListener(this);
        imgEntertainmet.setOnClickListener(this);
        imgFood.setOnClickListener(this);
        imgShopping.setOnClickListener(this);
        imgTravel.setOnClickListener(this);
        imgEducation.setOnClickListener(this);
        imgGift.setOnClickListener(this);
        imgTravel.setOnClickListener(this);
        imgSport.setOnClickListener(this);


        return view;
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), PromoActivity.class);
        startActivity(intent);
    }
}
