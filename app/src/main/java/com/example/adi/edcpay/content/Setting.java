package com.example.adi.edcpay.content;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.adi.edcpay.EditProfileActivity;
import com.example.adi.edcpay.LoginActivity;
import com.example.adi.edcpay.R;

public class Setting extends AppCompatActivity implements View.OnClickListener {

    Toolbar settingMainToolbar;
    Button btnLogOut;
    TextView tvEditProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        settingMainToolbar = findViewById(R.id.toolbarHeader);
        btnLogOut = findViewById(R.id.btnLogOut);
        tvEditProfile = findViewById(R.id.tvEditProfile);

        setSupportActionBar(settingMainToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnLogOut.setOnClickListener(this);
        tvEditProfile.setOnClickListener(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogOut:
                Intent intentLogOut = new Intent(this, LoginActivity.class);
                startActivity(intentLogOut);
                break;
            case R.id.tvEditProfile:
                Intent intentEditProfile = new Intent(this, EditProfileActivity.class);
                startActivity(intentEditProfile);
                break;
        }
    }
}
