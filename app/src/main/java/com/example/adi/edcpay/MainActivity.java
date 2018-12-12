package com.example.adi.edcpay;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.adi.edcpay.adapter.TabAdapter;
import com.example.adi.edcpay.content.Finance;
import com.example.adi.edcpay.content.History;
import com.example.adi.edcpay.content.Home;
import com.example.adi.edcpay.content.Merchant;
import com.example.adi.edcpay.content.Notification;
import com.example.adi.edcpay.content.Setting;
import com.example.adi.edcpay.content.Wallet;

public class MainActivity extends AppCompatActivity {

    Toolbar mainToolbar, contentToolbar;

    TabAdapter tabAdapter;
    TabLayout tabLayout;
    ViewPager viewPager;
    ImageView imgNotif, imgSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        mainToolbar = findViewById(R.id.toolbarHeader);
        setSupportActionBar(mainToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        imgNotif = findViewById(R.id.notificationIcon);
        imgSetting = findViewById(R.id.settingsIcon);

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

        imgNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Notification.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });

        imgSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Setting.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
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
