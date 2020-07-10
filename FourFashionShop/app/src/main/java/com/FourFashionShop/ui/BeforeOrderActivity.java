package com.FourFashionShop.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.FourFashionShop.R;
import com.FourFashionShop.Adapters.BeforeOrderAdapter;
import com.FourFashionShop.Adapters.*;
import com.FourFashionShop.Fragments.CartFragment;
import com.FourFashionShop.Adapters.BeforeOrderAdapter;
import com.FourFashionShop.Fragments.CartFragment;

public class BeforeOrderActivity extends AppCompatActivity {
    private TextView txtContent, txtPriceTamTinh, txtTongTien;
    private RecyclerView recycler_product_order;
    private BeforeOrderAdapter beforeOrderAdapter;
    private Button btnBeforeOrder;
    private LinearLayout lnLocation;
    private RadioButton rdGiaoNhanh, rdGiaoHomSau, rdGiaoTC;
    private RadioGroup rgGiaoHang;
    private TextView txtShip;
    int shipGiaoNhanh = 60000;
    int shipHomSau = 30000;
    int shipGiaoTC = 20000;
    private int flag = 1;
    int tien = CartFragment.tongTien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_order);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Hình Thức Giao Hàng");


        txtContent = (TextView) findViewById(R.id.txtContent);
        txtContent.setText("Địa chỉ nhận hàng\nChọn địa chỉ");

        beforeOrderAdapter = new BeforeOrderAdapter(CartFragment.cartModels, this);

        recycler_product_order = findViewById(R.id.recycler_product_order);
        btnBeforeOrder = findViewById(R.id.btnBeforeOrder);
        lnLocation = findViewById(R.id.lnLocation);
        txtPriceTamTinh = findViewById(R.id.txtPriceTamTinh);
        txtTongTien = findViewById(R.id.txtTongTien);

        rdGiaoNhanh = findViewById(R.id.rdGiaoNhanh);
        rdGiaoHomSau = findViewById(R.id.rdGiaoHomSau);
        rdGiaoTC = findViewById(R.id.rdGiaoTC);
        txtShip = findViewById(R.id.txtShip);
        recycler_product_order.setAdapter(beforeOrderAdapter);
        recycler_product_order.setLayoutManager(new LinearLayoutManager(this));
        txtShip.setText("0");
        txtTongTien.setText(String.valueOf(CartFragment.tongTien));
        //Địa điểm
        lnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent locate = new Intent(getApplication(), LocationUserActivity.class);
                startActivity(locate);
            }
        });

        rdGiaoNhanh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub

                if(isChecked)
                {
                    tien = CartFragment.tongTien;
                    txtShip.setText(String.valueOf(shipGiaoNhanh));
                    tien +=  Integer.parseInt(txtShip.getText().toString());
                    txtTongTien.setText(String.valueOf(tien));
                    flag = 0;
                    Toast toast = Toast.makeText(getApplicationContext(), "Tiền ship của bạn là: " + shipGiaoNhanh + " đ", Toast.LENGTH_LONG);

                    toast.show();
                }


            }

        });

        rdGiaoTC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub

                if(isChecked)
                {
                    tien = CartFragment.tongTien;
                    txtShip.setText(String.valueOf(shipGiaoTC));
                    tien +=  Integer.parseInt(txtShip.getText().toString());
                    txtTongTien.setText(String.valueOf(tien));
                    flag = 0;
                    Toast toast = Toast.makeText(getApplicationContext(), "Tiền ship của bạn là: " + shipGiaoTC + " đ", Toast.LENGTH_LONG);

                    toast.show();
                }


            }

        });



        rdGiaoHomSau.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub

                if(isChecked)
                {
                    tien = CartFragment.tongTien;
                    txtShip.setText(String.valueOf(shipHomSau));
                    tien +=  Integer.parseInt(txtShip.getText().toString());
                    txtTongTien.setText(String.valueOf(tien));
                    flag = 0;
                    Toast toast = Toast.makeText(getApplicationContext(), "Tiền ship của bạn là: " + shipHomSau + " đ", Toast.LENGTH_LONG);

                    toast.show();
                }

            }

        });


        btnBeforeOrder.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (rdGiaoHomSau.isChecked() == false && rdGiaoNhanh.isChecked() == false && rdGiaoTC.isChecked() == false)
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Bạn cần chọn hình thức giao hàng!", Toast.LENGTH_LONG);

                    toast.show();
                } else {
                    Intent ordered = new Intent(getApplication(), OrderInfoActivity.class);
                    startActivity(ordered);
                }

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    //Tổng tiền


}
