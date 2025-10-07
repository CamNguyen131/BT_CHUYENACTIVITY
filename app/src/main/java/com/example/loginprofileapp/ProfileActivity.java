package com.example.loginprofileapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class ProfileActivity extends AppCompatActivity {

    TextView tvProfileName, tvEmail, tvPhone, tvSkype, tvWeb;
    ImageButton btnSetting, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvProfileName = findViewById(R.id.tvProfileName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvSkype = findViewById(R.id.tvSkype);
        tvWeb = findViewById(R.id.tvWeb);
        btnSetting = findViewById(R.id.btnSetting);
        btnBack = findViewById(R.id.btnBack);

        // Lấy dữ liệu từ LoginActivity
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");

        // Hiển thị thông tin


        // Bấm Setting → quay lại LoginActivity
        btnSetting.setOnClickListener(v -> {
            Intent i = new Intent(ProfileActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        });

        // Nút Back cũng quay lại LoginActivity
        btnBack.setOnClickListener(v -> {
            finish();
        });
    }
}
