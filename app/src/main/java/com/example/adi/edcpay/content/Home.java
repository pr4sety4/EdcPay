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
import android.widget.LinearLayout;

import com.example.adi.edcpay.DetailActivity;
import com.example.adi.edcpay.FormActivity;
import com.example.adi.edcpay.R;
import com.example.adi.edcpay.UserActivity;
import com.example.adi.edcpay.adapter.PromoAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment implements View.OnClickListener, PromoAdapter.ItemClickListener {


    public Home() {
        // Required empty public constructor
    }

    CardView imgPln, imgPulsa, imgPascabayar, imgBpjs, imgTvKabel, imgAsuransi, imgPaketData;
    ImageView imgSeeAll, imgTopUp, imgSend, imgRequest, imgScan, imgPay;
    RecyclerView recyclerViewPromo;
    PromoAdapter promoAdapter;
    LinearLayout userLayout, cashLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);

        imgPln = view.findViewById(R.id.plnIcon);
        imgPulsa = view.findViewById(R.id.pulsaIcon);
        imgPascabayar = view.findViewById(R.id.pascaBayarIcon);
        imgBpjs = view.findViewById(R.id.bpjsIcon);
        imgTvKabel = view.findViewById(R.id.tvKabelIcon);
        imgAsuransi = view.findViewById(R.id.asuransiIcon);
        imgPaketData = view.findViewById(R.id.paketDataIcon);
        imgTopUp = view.findViewById(R.id.topupIcon);
        imgSend = view.findViewById(R.id.sendIcon);
        imgRequest = view.findViewById(R.id.requestIcon);
        imgScan = view.findViewById(R.id.scanIcon);
        imgPay = view.findViewById(R.id.payIcon);
        userLayout = view.findViewById(R.id.userLayout);
        cashLayout = view.findViewById(R.id.cashLayout);

        ArrayList<Integer> image = new ArrayList<>();
        image.add(R.drawable.ad1);
        image.add(R.drawable.ad2);
        image.add(R.drawable.ad3);

        recyclerViewPromo = view.findViewById(R.id.homePromoRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPromo.setLayoutManager(linearLayoutManager);
        promoAdapter = new PromoAdapter(image, getActivity());
        promoAdapter.setClickListener(this);
        recyclerViewPromo.setAdapter(promoAdapter);

        imgPln.setOnClickListener(this);
        imgPulsa.setOnClickListener(this);
        imgPascabayar.setOnClickListener(this);
        imgBpjs.setOnClickListener(this);
        imgTvKabel.setOnClickListener(this);
        imgPaketData.setOnClickListener(this);
        imgAsuransi.setOnClickListener(this);
        imgTopUp.setOnClickListener(this);
        imgSend.setOnClickListener(this);
        imgRequest.setOnClickListener(this);
        imgScan.setOnClickListener(this);
        imgPay.setOnClickListener(this);
        userLayout.setOnClickListener(this);
        cashLayout.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intentForm = new Intent(getActivity(), FormActivity.class);
        Intent intentScan = new Intent(getActivity(), Scanner.class);
        switch (v.getId()) {
            case R.id.plnIcon:
                startActivity(intentForm);
                break;
            case R.id.pulsaIcon:
                startActivity(intentForm);
                break;
            case R.id.pascaBayarIcon:
                startActivity(intentForm);
                break;
            case R.id.bpjsIcon:
                startActivity(intentForm);
                break;
            case R.id.tvKabelIcon:
                startActivity(intentForm);
                break;
            case R.id.asuransiIcon:
                startActivity(intentForm);
                break;
            case R.id.paketDataIcon:
                startActivity(intentForm);
                break;
            case R.id.topupIcon:
                startActivity(intentForm);
                break;
            case R.id.sendIcon:
                startActivity(intentForm);
                break;
            case R.id.requestIcon:
                startActivity(intentForm);
                break;
            case R.id.scanIcon:
                startActivity(intentScan);
                break;
            case R.id.payIcon:
                startActivity(intentScan);
                break;
            case R.id.userLayout:
                Intent intentUser = new Intent(getActivity(), UserActivity.class);
                startActivity(intentUser);
                break;
            case R.id.cashLayout:
                Intent intentCash = new Intent(getActivity(), UserActivity.class);
                startActivity(intentCash);
                break;
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        startActivity(intent);
    }
}
