package com.example.de4chuyentien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spCountryFrom, spCountryTo;
    private TextView txtTieuDe, txtTienChuyen1, txtTieuDaChuyen1, txtDonVi, txtKetQua1, txtKetQua2;
    private EditText txtTien;
    private ImageButton btnChuyen, btnChuyenTien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spCountryFrom = findViewById(R.id.spCountryFrom);
        spCountryTo = findViewById(R.id.spCountryTo);

        txtDonVi = findViewById(R.id.txtDonVi);
        txtKetQua1 = findViewById(R.id.txtKetQua1);
        txtKetQua2 = findViewById(R.id.txtKetQua2);
        txtTien = findViewById(R.id.txtTien);
        txtTienChuyen1 = findViewById(R.id.txtTienChuyen1);
        txtTieuDe = findViewById(R.id.txtTieuDe);
        txtTieuDaChuyen1 = findViewById(R.id.txtTieuDaChuyen1);

        btnChuyen = findViewById(R.id.btnChuyen);
        btnChuyenTien = findViewById(R.id.btnChuyenTien);

        List<String> list = new ArrayList<>();
        list.add("AUD");
        list.add("CAD");
        list.add("EUR");
        list.add("GBP");
        list.add("HKD");
        list.add("JPY");
        list.add("KRW");
        list.add("SGD");
        list.add("THB");
        list.add("USD");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list);

        spCountryTo.setAdapter(arrayAdapter);
        spCountryTo.setSelection(9);

        spCountryFrom.setAdapter(arrayAdapter);
        spCountryFrom.setSelection(2);

        btnChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int vt = spCountryFrom.getSelectedItemPosition();
                spCountryFrom.setSelection(spCountryTo.getSelectedItemPosition());
                spCountryTo.setSelection(vt);
            }
        });

        btnChuyenTien.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txtTien.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Bạn cần nhập tiền!", Toast.LENGTH_LONG).show();
                }
                else
                {
                    String donvi1 = spCountryFrom.getSelectedItem().toString();
                    String donvi2 = spCountryTo.getSelectedItem().toString();
                    Double tien = Double.parseDouble(txtTien.getText().toString());
                    txtTieuDe.setText(String.format("%s%s%s%s%s%.6f%s%s", "XE Currency Converter: 1 ",
                            donvi1, " to ", donvi2, " = ", chuyenTien(donvi1, donvi2, tien) / tien, " " , donvi2));
                    txtTienChuyen1.setText(String.format("%.3f%s%s%s", tien, " ",  donvi1, " = "));
                    txtTieuDaChuyen1.setText(String.format("%.6f", chuyenTien(donvi1, donvi2, tien)));
                    txtDonVi.setText(donvi2);

                    txtKetQua1.setText(String.format("%.3f%s%s%s%.6f%s%s", tien, " ",donvi1, " = ", chuyenTien(donvi1,donvi2, tien), " ", donvi2));
                    txtKetQua2.setText(String.format("%.3f%s%s%s%.6f%s%s",tien, " ", donvi2, " = ", chuyenTien(donvi2,donvi1, tien), " ", donvi1));
                }
            }
        });

    }

    double chuyenQuaTienVN(String name) {
        double money = 0.0;
        switch (name)
        {
            case "AUD":
                money = 16160.89;
                break;
            case "CAD":
                money = 17265.13;
                break;
            case "EUR":
                money = 26709.40;
                break;
            case "GBP":
                money = 29245.09;
                break;
            case "HKD":
                money = 3040.37;
                break;
            case "JPY":
                money = 219.24;
                break;
            case "KRW":
                money = 20.27;
                break;
            case "SGD":
                money = 16922.90;
                break;
            case "THB":
                money = 764.65;
                break;
            case "USD":
                money = 23295.00;
                break;

        }
        return money;
    }

    double chuyenTien(String name1, String name2, double tien) {
        double money1 = chuyenQuaTienVN(name1);
        double money2 = chuyenQuaTienVN(name2);
        return tien * money1 / money2;
    }


}