package com.example.adi.edcpay.content;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.adi.edcpay.FormActivity;
import com.example.adi.edcpay.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * A simple {@link Fragment} subclass.
 */
public class Finance extends Fragment implements View.OnClickListener {


    public Finance() {
        // Required empty public constructor
    }

    ImageView imgSend, imgBuy, imgWithDraw;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_finance, container, false);

        imgSend = view.findViewById(R.id.sendFinanceIcon);
        imgBuy = view.findViewById(R.id.buyIcon);
        imgWithDraw = view.findViewById(R.id.withdrawIcon);

        GraphView graph = view.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        graph.addSeries(series);

        imgSend.setOnClickListener(this);
        imgBuy.setOnClickListener(this);
        imgWithDraw.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), FormActivity.class);
        startActivity(intent);
    }
}
