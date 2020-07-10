package com.example.dangkythanhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DangKyThanhCong extends AppCompatActivity {
    private TextView txtTen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky_thanh_cong);

        txtTen = findViewById(R.id.txtTen);
        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.NAME);
        txtTen.setText(text);
    }
}