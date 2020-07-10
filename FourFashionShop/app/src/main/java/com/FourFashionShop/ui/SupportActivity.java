package com.FourFashionShop.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.FourFashionShop.R;
import com.FourFashionShop.Adapters.SupportAdapter;

import java.util.ArrayList;
import java.util.List;

public class SupportActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<String> stringList;
    SupportAdapter supportAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Hỗ trợ");

        stringList = new ArrayList<>();
        stringList.add("Giới thiệu về FashionShop");
        stringList.add("Gửi email hỗ trợ");
        stringList.add("Các câu hỏi thường gặp");
        stringList.add("Hướng dẫn đặt hàng");
        stringList.add("Chính sách đổi trả");
        stringList.add("Chính sách vận chuyển");
        stringList.add("Chính sách hàng nhập khẩu");
        stringList.add("Chính sách bảo mật thanh toán");
        stringList.add("Chính sách bảo mật thông tin");
        stringList.add("Chính sách bảo mặt ứng dụng");
        stringList.add("Chính sách giải quyết khiếu nại");
        stringList.add("Qui chế ứng dụng");
        stringList.add("Điều khoản sử dụng");

        recyclerView = findViewById(R.id.recyclerViewSupport);
        supportAdapter = new SupportAdapter(stringList, this);
        recyclerView.setAdapter(supportAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
