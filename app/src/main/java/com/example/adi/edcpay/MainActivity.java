package com.example.adi.edcpay;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.adi.edcpay.Adapter.TabAdapter;
import com.example.adi.edcpay.Content.Finance;
import com.example.adi.edcpay.Content.History;
import com.example.adi.edcpay.Content.Home;
import com.example.adi.edcpay.Content.Merchant;
import com.example.adi.edcpay.Content.Wallet;

public class MainActivity extends AppCompatActivity {

    Toolbar mainToolbar, contentToolbar;

    TabAdapter tabAdapter;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        mainToolbar = findViewById(R.id.toolbarHeader);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        int[] tabIcons = {
                R.drawable.home,
                R.drawable.shopping_basket,
                R.drawable.finance,
                R.drawable.wallet,
                R.drawable.history
        };

        tabAdapter = new TabAdapter(getSupportFragmentManager(), this);
        tabAdapter.addFragment(new Home(), "Home", tabIcons[0]);
        tabAdapter.addFragment(new Merchant(), "Merchant", tabIcons[1]);
        tabAdapter.addFragment(new Finance(), "Finance", tabIcons[2]);
        tabAdapter.addFragment(new Wallet(), "Wallet", tabIcons[3]);
        tabAdapter.addFragment(new History(), "History", tabIcons[4]);

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


}
