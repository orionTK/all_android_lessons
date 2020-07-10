package com.example.tienthuetncn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spThang, spNam;
    private TextView txtTienThue, txtTienTNCN;
    private EditText txtThuNhapThang, txtSoNguoi;
    private Button btnTinhToan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spThang = findViewById(R.id.spThang);
        spNam = findViewById(R.id.spNam);

        txtTienThue = findViewById(R.id.txtTienThue);
        txtTienTNCN = findViewById(R.id.txtTienTNCN);
        txtThuNhapThang = findViewById(R.id.txtThuNhapThang);
        txtSoNguoi = findViewById(R.id.txtSoNguoi);

        btnTinhToan = findViewById(R.id.btnTinhToan);

        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");
        list1.add("6");
        list1.add("7");
        list1.add("8");
        list1.add("9");
        list1.add("10");
        list1.add("11");
        list1.add("12");

        ArrayAdapter arrayAdapter1 = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list1);
        spThang.setAdapter(arrayAdapter1);

        List<String> list2 = new ArrayList<>();
        list2.add("2010");
        list2.add("2011");
        list2.add("2012");
        list2.add("2013");
        list2.add("2014");
        list2.add("2015");
        list2.add("2016");
        list2.add("2017");
        list2.add("2018");
        list2.add("2019");
        list2.add("2020");
        list2.add("2021");

        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list2);
        spNam.setAdapter(arrayAdapter2);

        btnTinhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtThuNhapThang.getText().toString().isEmpty() || txtSoNguoi.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Bạn cần nhập dữ liệu!" , Toast.LENGTH_LONG).show();
                }
                else {
                    double tienThue = 0.0;
                    double tienTNCN = 0.0;
                    int ng = Integer.parseInt(txtSoNguoi.getText().toString());
                    double tienTN = Double.parseDouble(txtThuNhapThang.getText().toString());


                    //tính tiền thuế
                    if (Integer.parseInt(spNam.getSelectedItem().toString()) < 2020)
                        tienThue = tienTN - 9000000 - 3600000 * ng;
                    else
                        tienThue = tienTN - 11000000 - 4400000 * ng;

                    if (tienThue < 0) {
                        tienThue = 0.0;
                    }

                    txtTienThue.setText(String.format("%.0f", tienThue));

                    if (tienThue < 5000000)
                        tienTNCN = tienThue * 0.05;
                    else
                        if (tienThue < 10000000)
                            tienTNCN = tienThue * 0.1 - 250000;
                        else
                            if (tienThue < 18000000)
                                tienTNCN = tienThue * 0.15 - 750000;
                            else
                                if (tienThue < 32000000)
                                    tienTNCN = tienThue * 0.2 - 1650000;
                                else
                                    if (tienThue < 52000000)
                                        tienTNCN = tienThue * 0.25 - 3250000;
                                    else
                                        if (tienThue < 80000000)
                                            tienTNCN = tienThue * 0.3 - 5850000;
                                        else
                                            tienTNCN = tienThue * 0.35 - 9850000;
                    if (tienTNCN < 0.0)
                        tienTNCN = 0.0;
                    txtTienTNCN.setText(String.format("%.0f", tienTNCN));
                }
            }
        });
    }
}