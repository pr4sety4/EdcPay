package com.example.adi.edcpay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar editProfileToolbar;
    TextView ubahEmail, ubahPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        editProfileToolbar = findViewById(R.id.toolbarHeader);
        setSupportActionBar(editProfileToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ubahEmail = findViewById(R.id.ubahEmail);
        ubahPhoneNumber = findViewById(R.id.ubahPhoneNumber);

        ubahEmail.setOnClickListener(this);
        ubahPhoneNumber.setOnClickListener(this);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, EditActivity.class);
        switch (v.getId()) {
            case R.id.ubahEmail:
                intent.putExtra("type", "Alamat Email");
                intent.putExtra("defaultValue", "sndr1722@gmail.com");
                startActivity(intent);
                break;
            case R.id.ubahPhoneNumber:
                intent.putExtra("type", "Nomor Telephone");
                intent.putExtra("defaultValue", "082233837891");
                startActivity(intent);
                break;
        }
    }
}
