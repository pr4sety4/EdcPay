package com.example.adi.edcpay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adi.edcpay.util.Constant;

public class FormActivity extends AppCompatActivity {

    Toolbar formToolbarHeader;
    TextView tvTitleBar, tvSubTitle;
    ImageView imgSubTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        formToolbarHeader = findViewById(R.id.toolbarHeader);
        tvTitleBar = findViewById(R.id.toolbarTitle);
        tvSubTitle = findViewById(R.id.subToolbarTitle);
        imgSubTitle = findViewById(R.id.subToolbarImage);

        setSupportActionBar(formToolbarHeader);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            tvTitleBar.setText(extra.getString(Constant.TITLE));
            tvSubTitle.setText(extra.getString(Constant.TITLE));
            imgSubTitle.setImageResource(extra.getInt(Constant.ICON));
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
