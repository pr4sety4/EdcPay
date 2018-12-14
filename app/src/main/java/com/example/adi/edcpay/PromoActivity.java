package com.example.adi.edcpay;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.adi.edcpay.adapter.PromoAdapter;
import com.example.adi.edcpay.adapter.TabAdapter;
import com.example.adi.edcpay.content.Deals;
import com.example.adi.edcpay.content.Promo;

public class PromoActivity extends AppCompatActivity {

    RecyclerView recyclerViewPromo;
    PromoAdapter promoAdapter;
    TabAdapter tabAdapter;
    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar promoListToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);

        promoListToolbar = findViewById(R.id.toolbarHeader);
        setSupportActionBar(promoListToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        int[] tabIcons = {
                R.drawable.deals,
                R.drawable.promo,
        };

        tabAdapter = new TabAdapter(getSupportFragmentManager(), this);
        tabAdapter.addFragment(new Deals(), "Deals", tabIcons[0]);
        tabAdapter.addFragment(new Promo(), "Promo", tabIcons[1]);


        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);

        highLightCurrentTab(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                highLightCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void highLightCurrentTab(int position) {

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            assert tab != null;
            tab.setCustomView(null);
            tab.setCustomView(tabAdapter.getTabView(i));
        }

        TabLayout.Tab tab = tabLayout.getTabAt(position);
        assert tab != null;
        tab.setCustomView(null);
        tab.setCustomView(tabAdapter.getSelectedTabView(position));

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

//    @Override
//    public void onItemClick(View view, int position) {
//        Intent intent = new Intent(this, DetailActivity.class);
//        startActivity(intent);
//    }
}
