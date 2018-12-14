package com.example.adi.edcpay.content;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adi.edcpay.R;
import com.example.adi.edcpay.adapter.TabDetailListWalletAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailWalletFragment extends Fragment {


    TabLayout tabLayout;
    ViewPager viewPager;
    TabDetailListWalletAdapter tabDetailListWalletAdapter;

    public DetailWalletFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);

        tabDetailListWalletAdapter = new TabDetailListWalletAdapter(getActivity().getSupportFragmentManager(), getActivity());
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

        return view;
    }


}
