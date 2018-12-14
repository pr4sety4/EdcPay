package com.example.adi.edcpay.content;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.adi.edcpay.R;
import com.example.adi.edcpay.adapter.TabDetailListWalletAdapter;

public class DetailsWalletActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TabDetailListWalletAdapter tabDetailListWalletAdapter;
    Toolbar detailsWalletToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_detail);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        detailsWalletToolbar = findViewById(R.id.toolbarHeader);

        setSupportActionBar(detailsWalletToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabDetailListWalletAdapter = new TabDetailListWalletAdapter(getSupportFragmentManager(), this);
        tabDetailListWalletAdapter.addFragment(new OverViewWallet(), "Overview");
        tabDetailListWalletAdapter.addFragment(new TransactionWallet(), "Transactions");


        viewPager.setAdapter(tabDetailListWalletAdapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
