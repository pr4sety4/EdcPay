package com.example.adi.edcpay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.adi.edcpay.adapter.PromoAdapter;

import java.util.ArrayList;

public class PromoActivity extends AppCompatActivity implements PromoAdapter.ItemClickListener {

    RecyclerView recyclerViewPromo;
    PromoAdapter promoAdapter;
    Toolbar promoListToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);

        promoListToolbar = findViewById(R.id.toolbarHeader);
        setSupportActionBar(promoListToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<Integer> image = new ArrayList<>();
        image.add(R.drawable.ad1);
        image.add(R.drawable.ad2);
        image.add(R.drawable.ad3);

        recyclerViewPromo = findViewById(R.id.homePromoRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewPromo.setLayoutManager(linearLayoutManager);
        promoAdapter = new PromoAdapter(image, this);
        promoAdapter.setClickListener(this);
        recyclerViewPromo.setAdapter(promoAdapter);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }
}
