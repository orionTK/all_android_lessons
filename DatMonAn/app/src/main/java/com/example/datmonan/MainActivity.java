package com.example.datmonan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private CheckBox ckThemPhoMai2, ckThemThitBo, ckThemTrung;
    private RadioButton rdBMPhoMai, rdBMOpLa, rdBMChaCa;
    private ImageButton btnTru2, btnTru3, btnCong2, btnCong3;
    private TextView txtSL2, txtSL3, txtGiamGia, txtTongTien;
    private EditText txtMaGiamGia;
    private Button btnDatHang, btnLamLai;
    double tong, tien1 = 0.0, tien2 = 0.0, tien3 = 0.0;
    int num1, num2, num3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ckThemPhoMai2 = findViewById(R.id.ckThemPhoMai2);
        ckThemThitBo = findViewById(R.id.ckThemThitBo);
        ckThemTrung = findViewById(R.id.ckThemTrung);

        rdBMChaCa = findViewById(R.id.rdBMChaCa);
        rdBMOpLa = findViewById(R.id.rdBMOpLa);
        rdBMPhoMai = findViewById(R.id.rdBMPhoMai);

        btnCong2 = findViewById(R.id.btnCong2);
        btnCong3 = findViewById(R.id.btnCong3);
        btnTru2 = findViewById(R.id.btnTru2);
        btnTru3 = findViewById(R.id.btnTru3);

        txtSL2 = findViewById(R.id.txtSL2);
        txtSL3 = findViewById(R.id.txtSL3);

        txtGiamGia = findViewById(R.id.txtGiamGia);
        txtMaGiamGia = findViewById(R.id.txtMaGiamGia);
        txtTongTien = findViewById(R.id.txtTongTien);

        num2 = Integer.parseInt(txtSL2.getText().toString());
        num3 = Integer.parseInt(txtSL3.getText().toString());

        btnDatHang = findViewById(R.id.btnDatHang);
        btnLamLai = findViewById(R.id.btnLamLai);
        Tong();

        btnCong2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2 = Integer.parseInt(txtSL2.getText().toString());
                num2 = cong(num2, txtSL2);
                Tong();
            }
        });

        btnCong3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num3 = Integer.parseInt(txtSL3.getText().toString());
                num3 = cong(num3, txtSL3);
                Tong();
            }
        });

        btnTru2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2 = Integer.parseInt(txtSL2.getText().toString());
                num2 = tru(num2, txtSL2);
                Tong();
            }
        });

        btnTru3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num3 = Integer.parseInt(txtSL3.getText().toString());
                num3 = tru(num3, txtSL3);
                Tong();
            }
        });


        ckThemPhoMai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tong();
            }
        });

        ckThemTrung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tong();
            }
        });

        ckThemThitBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tong();
            }
        });

        rdBMOpLa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tong();
            }
        });

        rdBMChaCa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tong();
            }
        });

        rdBMPhoMai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tong();
            }
        });


        btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tong();
                if (num2 == 0 || num3 == 0 || tien2 == 0 || tien3 == 0) {
                    Toast.makeText(getApplicationContext(), "Đơn hàng của bạn không hoàn tất!", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), DatThanhCong.class);
                    startActivity(intent);
                }
            }
        });

        btnLamLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale localeVN = new Locale("vi", "VN");
                NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                txtMaGiamGia.setText("");
                num2 = 0;
                num3= 0;
                txtSL2.setText("0");
                txtSL3.setText("0");
                ckThemPhoMai2.setChecked(true);
                rdBMOpLa.setChecked(true);
                txtGiamGia.setText(currencyVN.format(0));
                txtTongTien.setText(currencyVN.format(0));
            }
        });

    }

    int cong(int sl, TextView t) {
        sl++;
        t.setText(String.valueOf(sl));
        return sl;
    }

    int tru(int sl, TextView t) {
        if (sl > 0) {
            sl--;

        }

        t.setText(String.valueOf(sl));
        return sl;
    }



    void hungburger() {
        tien2 = 0;
        int i = 0;
        if (ckThemPhoMai2.isChecked()) {
            tien2 += 15000;
            i = 1;
        }

        if (ckThemThitBo.isChecked()) {
            tien2 += 35000;
            i = 1;
        }

        if (ckThemTrung.isChecked()) {
            tien2 += 25000;
            i = 1;
        }

        if (i == 1) {
            tien2 += 45000;
            i = 0;
        }
        tien2 = tien2 * num2;

    }

    void BanhMi() {
        tien3 = 0;
        if (rdBMOpLa.isChecked()) {
            tien3 = 45000;
        }
        if (rdBMPhoMai.isChecked()) {
            tien3 = 50000;
        }
        if (rdBMChaCa.isChecked()) {
            tien3 = 30000;
        }
        tien3 = tien3 * num3;

    }

    void Tong() {


        hungburger();
        BanhMi();
        double giamGia = 0.0;
        tong = 0;
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        tong = tien1 + tien2 + tien3;
        double tongTien = tong;
        if (txtMaGiamGia.getText().toString().trim().equals("ABC")) {
            tong = tongTien * 0.8;
            giamGia = tongTien * 0.2;
        }
        else
        if (txtMaGiamGia.getText().toString().trim().equals("XYZ")) {
            tong = tongTien * 0.9;
            giamGia = tongTien * 0.1;
        }


        txtGiamGia.setText(currencyVN.format(giamGia));
        txtTongTien.setText(currencyVN.format(tong));

    }







}