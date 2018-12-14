package com.example.adi.edcpay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    Toolbar editToolbar;
    TextView tvTitleBar, tvDefaultValue, tvDescription, tvDefaultValueTitle, tvNewValueTitle;
    EditText etNewValue;

    String titleBar, defaultValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editToolbar = findViewById(R.id.toolbarHeader);
        tvTitleBar = findViewById(R.id.toolbar_title);
        tvDefaultValue = findViewById(R.id.defaultValue);
        tvDescription = findViewById(R.id.description);
        tvDefaultValueTitle = findViewById(R.id.defaultValueTitle);
        tvNewValueTitle = findViewById(R.id.newValueTitle);
        etNewValue = findViewById(R.id.newValue);

        setSupportActionBar(editToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tvTitleBar.setText("Ubah " + extras.getString("type"));
            tvDefaultValue.setText(extras.getString("defaultValue"));
            tvDefaultValueTitle.setText(extras.getString("type") + " Terdaftar");
            tvNewValueTitle.setText(extras.getString("type") + " Baru");
            etNewValue.setText(extras.getString("defaultValue"));
            tvDescription.setText("Instruksi \n\n Setelah menugbah " + extras.getString("type") + ", anda akan diminta \n login dengan menggunakan " + extras.getString("type") + " yang baru");
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
