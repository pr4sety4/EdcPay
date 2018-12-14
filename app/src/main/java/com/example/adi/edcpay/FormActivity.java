package com.example.adi.edcpay;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.adi.edcpay.util.Constant;

public class FormActivity extends AppCompatActivity {

    Toolbar formToolbarHeader;
    TextView tvTitleBar, tvSubTitle, tvNominal;
    ImageView imgSubTitle;
    TextInputLayout etFirst, etSecond;
    RadioGroup rgFirst;
    LinearLayout nominalLayout;
    RadioButton rbPrabayar, rbPascabayar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        formToolbarHeader = findViewById(R.id.toolbarHeader);
        tvTitleBar = findViewById(R.id.toolbarTitle);
        tvSubTitle = findViewById(R.id.subToolbarTitle);
        imgSubTitle = findViewById(R.id.subToolbarImage);
        etFirst = findViewById(R.id.etFirstInput);
        etSecond = findViewById(R.id.etSecondInput);
        rgFirst = findViewById(R.id.radioGroup);
        nominalLayout = findViewById(R.id.nominalLayout);
        rbPascabayar = findViewById(R.id.radioPascabayar);
        rbPrabayar = findViewById(R.id.radioPrabayar);
        tvNominal = findViewById(R.id.tvNominal);

        setSupportActionBar(formToolbarHeader);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            tvTitleBar.setText(extra.getString(Constant.TITLE));
            tvSubTitle.setText(extra.getString(Constant.SUB_TITLE));
            imgSubTitle.setImageResource(extra.getInt(Constant.ICON));
            showNeededInput(extra.getString(Constant.TITLE));
        }

    }

    private void showNeededInput(String type) {
        switch (type) {
            case "PLN":
                etFirst.setVisibility(View.VISIBLE);
                etFirst.setHint("Nomor Meter");
                rgFirst.setVisibility(View.VISIBLE);
                rbPrabayar.setSelected(true);
                nominalLayout.setVisibility(View.VISIBLE);
                break;
            case "Pulsa":
                etFirst.setVisibility(View.VISIBLE);
                etFirst.setHint("Nomor Ponsel");
                rgFirst.setVisibility(View.VISIBLE);
                rbPrabayar.setSelected(true);
                nominalLayout.setVisibility(View.VISIBLE);
                break;
            case "Pascabayar":
                etFirst.setVisibility(View.VISIBLE);
                etFirst.setHint("Nomor Ponsel");
                rgFirst.setVisibility(View.VISIBLE);
                rbPascabayar.setSelected(true);
                break;
            case "BPJS":
                etFirst.setVisibility(View.VISIBLE);
                etFirst.setHint("No. BPJS");
                rgFirst.setVisibility(View.VISIBLE);
                rbPrabayar.setSelected(true);
                tvNominal.setText("Sampai Dengan");
                nominalLayout.setVisibility(View.VISIBLE);
                break;
            case "TV Kabel":
                etFirst.setVisibility(View.VISIBLE);
                etFirst.setHint("Nomor Pelanggan");
                break;
            case "Asuransi":
                etFirst.setVisibility(View.VISIBLE);
                etFirst.setHint("Nomor Polis Asuransi");
                break;
            case "Paket Data":
                etFirst.setVisibility(View.VISIBLE);
                etFirst.setHint("Nomor Ponsel");
                tvNominal.setText("Jenis Paket");
                break;
            case "Send":
                etFirst.setVisibility(View.VISIBLE);
                etFirst.setHint("Nomor Rek. Tujuan");
                break;
            case "Request":
                etFirst.setVisibility(View.VISIBLE);
                etFirst.setHint("Nomor Rek. Tujuan");
                break;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
