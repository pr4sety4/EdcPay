package com.example.adi.edcpay.content;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.adi.edcpay.DetailActivity;
import com.example.adi.edcpay.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Wallet extends Fragment implements View.OnClickListener {


    public Wallet() {
        // Required empty public constructor
    }

    ImageView imgCard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_wallet, container, false);

        imgCard = view.findViewById(R.id.imgCard);

        imgCard.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        startActivity(intent);
    }
}
