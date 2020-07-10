package com.FourFashionShop.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.FourFashionShop.Models.OrderModel;
import com.FourFashionShop.R;
import com.FourFashionShop.Adapters.OrdersManagementAdapter;

import java.util.ArrayList;
import java.util.List;

public class OrdersManagementActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<OrderModel> orderModelList;
    private OrdersManagementAdapter ordersManagementAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_management);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Quản lí đơn hàng");

        initItem();

        recyclerView = findViewById(R.id.recyclerViewOrdersManagement);
        ordersManagementAdapter = new OrdersManagementAdapter(orderModelList, this);
        recyclerView.setAdapter(ordersManagementAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    void initItem(){
        orderModelList = new ArrayList<>();
        orderModelList.add(new OrderModel("Ao cute", "123842", "6/2/2020", "Đã mua"));
        orderModelList.add(new OrderModel("Ao cute", "123842", "6/2/2020", "Đã mua"));
        orderModelList.add(new OrderModel("Ao cute", "123842", "6/2/2020", "Đã mua"));
        orderModelList.add(new OrderModel("Ao cute", "123842", "6/2/2020", "Đã mua"));
        orderModelList.add(new OrderModel("Ao cute", "123842", "6/2/2020", "Đã mua"));
        orderModelList.add(new OrderModel("Ao cute", "123842", "6/2/2020", "Đã mua"));
        orderModelList.add(new OrderModel("Ao cute", "123842", "6/2/2020", "Đã mua"));
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
