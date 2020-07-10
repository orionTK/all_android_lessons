package com.example.vaytieudung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText txtThuNhapThang, txtChiPhiTra, txtTienVay ;
    private TextView txtKetQua;
    private Button btnTinhToan;
    private RadioButton rd12Thang, rd24Thang, rd36Thang, rd48Thang;
    private Spinner spLaiSuat;
    int thang = 12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtThuNhapThang = findViewById(R.id.txtThuNhapThang);
        txtChiPhiTra = findViewById(R.id.txtChiPhiTra);
        txtTienVay = findViewById(R.id.txtTienVay);

        txtKetQua = findViewById(R.id.txtKetQua);

        btnTinhToan = findViewById(R.id.btnTinhToan);

        rd12Thang = findViewById(R.id.rd12Thang);
        rd24Thang = findViewById(R.id.rd24Thang);
        rd36Thang = findViewById(R.id.rd36Thang);
        rd48Thang = findViewById(R.id.rd48Thang);

        spLaiSuat = findViewById(R.id.spLaiSuat);

        List<String> list = new ArrayList<>();
        list.add("16%");
        list.add("17%");
        list.add("18%");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list);
        spLaiSuat.setAdapter(arrayAdapter);

        rd12Thang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thang = 12;
            }
        });

        rd24Thang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thang = 24;
            }
        });

        rd36Thang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thang = 36;
            }
        });

        rd48Thang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thang = 48;
            }
        });

        btnTinhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtThuNhapThang.getText().toString().trim().isEmpty() || txtChiPhiTra.getText().toString().trim().isEmpty()
                        || txtTienVay.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Bạn cần nhập dữ liệu!", Toast.LENGTH_LONG);
                }
                else
                {
                    double tienThuNhap = Double.parseDouble(txtThuNhapThang.getText().toString().trim());
                    double chiPhiTra = Double.parseDouble(txtChiPhiTra.getText().toString().trim());
                    double tienVay = Double.parseDouble(txtTienVay.getText().toString().trim());
                    double tienConLai = tienThuNhap - chiPhiTra;
                    if (tienVay > 10 * tienConLai) {
                        Toast.makeText(getApplicationContext(), "Tiền vay không vượt quá 10 lần tiền còn lại!", Toast.LENGTH_LONG).show();
                    }
                    else
                        if (tienVay < 20000000) {
                            Toast.makeText(getApplicationContext(), "Tiền vay không được ít hơn 20 triệu!", Toast.LENGTH_LONG).show();

                        }
                        else
                        {
                            int vt = spLaiSuat.getSelectedItemPosition();
                            double laiSuat = 0.0;
                            if (vt == 0) {
                                laiSuat = 0.16;
                            }
                            else
                            if (vt == 1) {
                                laiSuat = 0.17;
                            }
                            else
                            if (vt == 2) {
                                laiSuat = 0.18;
                            }
                            laiSuat = laiSuat / 12;
                            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                            Double tien = (tienVay * Math.pow(( 1 + laiSuat), thang) * laiSuat) / (Math.pow(( 1 + laiSuat), thang) - 1);
                            txtKetQua.setText(decimalFormat.format(tien));
                        }
                }
            }
        });
    }


}