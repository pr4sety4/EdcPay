package com.example.adi.edcpay.content;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.adi.edcpay.ChooseBuyActivity;
import com.example.adi.edcpay.FormActivity;
import com.example.adi.edcpay.R;
import com.example.adi.edcpay.util.Constant;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * A simple {@link Fragment} subclass.
 */
public class Finance extends Fragment implements View.OnClickListener {


    public Finance() {
        // Required empty public constructor
    }

    LinearLayout imgSend, imgWithDraw, imgBuy;
    TextView tvBuyBTC, tvSellBTC;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_finance, container, false);

        imgSend = view.findViewById(R.id.sendFinanceIcon);
        imgBuy = view.findViewById(R.id.buyIcon);
        imgWithDraw = view.findViewById(R.id.withdrawIcon);
        tvBuyBTC = view.findViewById(R.id.tvBuyBitcoin);
        tvSellBTC = view.findViewById(R.id.tvSellBitcoin);

        GraphView graph = view.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 8),
                new DataPoint(1, 6),
                new DataPoint(2, 7),
                new DataPoint(3, 9),
                new DataPoint(4, 12),
                new DataPoint(5, 15),
                new DataPoint(6, 10),
                new DataPoint(7, 8),
                new DataPoint(8, 6),
                new DataPoint(9, 7),
                new DataPoint(10, 4),
                new DataPoint(11, 6),
                new DataPoint(12, 5),
                new DataPoint(13, 3),
                new DataPoint(14, 1),
        });
        graph.addSeries(series);
//        graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        graph.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);
        graph.getGridLabelRenderer().setGridColor(getResources().getColor(R.color.white));
        series.setColor(getResources().getColor(R.color.white));
        series.setBackgroundColor(getResources().getColor(R.color.transparentWhite));
        series.setDrawBackground(true);

        imgSend.setOnClickListener(this);
        imgBuy.setOnClickListener(this);
        imgWithDraw.setOnClickListener(this);
        tvBuyBTC.setOnClickListener(this);
        tvSellBTC.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intentForm = new Intent(getActivity(), FormActivity.class);
        Intent intentBuy = new Intent(getActivity(), ChooseBuyActivity.class);
        switch (v.getId()) {
            case R.id.buyIcon:
                startActivity(intentBuy);
                break;
            case R.id.tvBuyBitcoin:
                startActivity(intentBuy);
                break;
            case R.id.sendFinanceIcon:
                intentForm.putExtra(Constant.TITLE, "Send");
                intentForm.putExtra(Constant.SUB_TITLE, "Send");
                intentForm.putExtra(Constant.ICON, R.drawable.send);
                startActivity(intentForm);
                break;
            case R.id.tvSellBitcoin:
                startActivity(intentBuy);
                break;
            case R.id.withdrawIcon:
                WithdrawFragment withdrawFragment = new WithdrawFragment();
                withdrawFragment.show(getActivity().getSupportFragmentManager(), "Withdraw Bottom Sheet");
                break;
        }

    }
}
