package com.example.adi.edcpay.content;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adi.edcpay.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OverViewWallet extends Fragment {


    public OverViewWallet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_over_view_wallet, container, false);
        return view;
    }

}
