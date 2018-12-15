package com.example.adi.edcpay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.adi.edcpay.util.Constant;

public class WithdrawActivity extends AppCompatActivity {

    TextView tvTitle;
    Toolbar withdrawToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);

        withdrawToolbar = findViewById(R.id.toolbarHeader);
        tvTitle = findViewById(R.id.tvTitleWithdraw);
        setSupportActionBar(withdrawToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            tvTitle.setText(extra.getString(Constant.TITLE));
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
