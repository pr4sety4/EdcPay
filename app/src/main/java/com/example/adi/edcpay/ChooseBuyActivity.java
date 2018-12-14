package com.example.adi.edcpay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

public class ChooseBuyActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar chooseBuyToolbar;
    LinearLayout buyBtcWithEth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_buy);

        chooseBuyToolbar = findViewById(R.id.toolbarHeader);
        setSupportActionBar(chooseBuyToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buyBtcWithEth = findViewById(R.id.buyBtcWithEth);

        buyBtcWithEth.setOnClickListener(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, BuyActivity.class);
        startActivity(intent);
    }
}
