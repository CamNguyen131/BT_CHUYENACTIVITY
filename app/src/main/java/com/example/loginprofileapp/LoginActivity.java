package com.example.loginprofileapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edtUser, edtPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String username = edtUser.getText().toString().trim();
            String password = edtPass.getText().toString().trim();

            if(username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            if(username.equals("nguyen") && password.equals("123456")) {
                // Đăng nhập thành công
                Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                intent.putExtra("USERNAME", username);
                intent.putExtra("EMAIL", "admin@ute.udn.vn");
                startActivity(intent);
                Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
            } else {
                // Sai tài khoản/mật khẩu
                Toast.makeText(this, "Sai tài khoản hoặc mật khẩu!", Toast.LENGTH_SHORT).show();
            }

            // Gửi dữ liệu sang ProfileActivity
            Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
            intent.putExtra("USERNAME", username);
            intent.putExtra("EMAIL", username + "@gmail.com");
            startActivity(intent);
        });
    }
}
