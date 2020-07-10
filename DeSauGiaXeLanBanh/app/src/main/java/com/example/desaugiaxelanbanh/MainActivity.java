package com.example.desaugiaxelanbanh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Spinner spLoaiXe, spDiaPhuong;
    List<String> list1, list2;
    private TextView txtGiaDamPhan, txtPhiTruocHa, txtPhiDuongBo, txtBaoHiem, txtBienSo, txtPhiDuongKiem, txtTong, txtTienTra, txtBaKieu;
    private EditText txtGiaXe;
    Double giaDamPhan = 789000000.0;
    private Button btnTinhToan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spLoaiXe = findViewById(R.id.spLoaiXe);
        spDiaPhuong = findViewById(R.id.spDiaPhuong);
        txtGiaXe = findViewById(R.id.txtGiaXe);

        txtGiaXe = findViewById(R.id.txtGiaXe);
        txtBaoHiem = findViewById(R.id.txtBaoHiem);
        txtBienSo = findViewById(R.id.txtBienSo);
        txtPhiDuongBo = findViewById(R.id.txtPhiDuongBo);
        txtPhiDuongKiem = findViewById(R.id.txtPhiDuongKiem);
        txtTong = findViewById(R.id.txtTong);
        txtPhiTruocHa = findViewById(R.id.txtPhiTruocHa);
        txtTienTra = findViewById(R.id.txtTienTra);
        txtGiaDamPhan = findViewById(R.id.txtGiaDamPhan);
        txtBaKieu = findViewById(R.id.txtBaKieu);

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list1.add("Xe dung lịch dưới 10 chỗ");
        list1.add("Xe bán tải");
        list1.add("Xe tải nhỏ");
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list1);
        spLoaiXe.setAdapter(arrayAdapter1);

        list2.add("TP.HCM");
        list2.add("Đồng Nai");
        list2.add("Bình Dương");
        list2.add("Long An");
        list2.add("Vũng Tàu");

        btnTinhToan = findViewById(R.id.btnTinhToan);

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list2);
        spDiaPhuong.setAdapter(arrayAdapter2);

        btnTinhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtGiaXe.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Bạn cần nhập giá xe!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (list2.get(spDiaPhuong.getSelectedItemPosition()) == "TP.HCM") {

                        txtBaKieu.setText("Phí trước bạ(3%)");
                    }
                    else {

                        txtBaKieu.setText("Phí trước hạ(10%)");
                    }
                    if (!txtGiaXe.getText().toString().isEmpty()) {
                        giaDamPhan = Double.parseDouble(txtGiaXe.getText().toString());
                        DecimalFormat formatter = new DecimalFormat("###,###,###");
                        Locale localeVN = new Locale("vi", "VN");
                        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
                        txtGiaDamPhan.setText(currencyVN.format(giaDamPhan));
                        Double tk = PhiTruocBa();
                        txtPhiTruocHa.setText(currencyVN.format(tk));
                        txtPhiDuongBo.setText(currencyVN.format(PhiSuDungDuongBo()));
                        txtBaoHiem.setText(currencyVN.format(PhiBaoHiem()));
                        txtBienSo.setText(currencyVN.format(TienDangKy()));
                        txtPhiDuongKiem.setText(currencyVN.format(PhiDangKiem()));
                        Double tong = PhiTruocBa() + giaDamPhan + PhiSuDungDuongBo() + PhiBaoHiem() + TienDangKy() +PhiDangKiem();
                        txtTong.setText(currencyVN.format(tong));
                        txtTienTra.setText(currencyVN.format(tong));
                    }
                    else
                        Toast.makeText(getApplicationContext(), "Bạn cần nhập giá xe!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    Double PhiTruocBa() {
        Double tien = 0.0;
        if (spDiaPhuong.getSelectedItemPosition() != 0) {
            tien = giaDamPhan * 0.03;
            txtBaKieu.setText("Phí trước hạ(3%)");
        }
        else {
            tien = giaDamPhan * 0.1;
            txtBaKieu.setText("Phí trước hạ(10%)");
        }
        return tien;
    }

    Double PhiSuDungDuongBo() {
        Double tien = 0.0;
        if (spLoaiXe.getSelectedItemPosition() != 0) {
            tien = 2160000.0;
        }
        else
            tien = 1560000.0;
        return tien;
    }

    Double PhiBaoHiem() {
        Double tien = 0.0;
        if (spLoaiXe.getSelectedItemPosition() == 0) {
            tien = 794000.0;
        }
        else if (spLoaiXe.getSelectedItemPosition() == 1)
            tien = 933000.0;
        else
            tien = 953000.0;
        return tien;
    }
    Double TienDangKy() {
        Double tien = 0.0;
        if (spDiaPhuong.getSelectedItemPosition() == 0) {
            tien = 11000000.0;
        }
        else
            tien = 3000000.0;
        return tien;
    }

    Double PhiDangKiem() {
        Double tien = 0.0;
        if (spLoaiXe.getSelectedItemPosition() == 0) {
            tien = 340000.0;
        }
        else
            tien = 540000.0;
        return tien;
    }
}
