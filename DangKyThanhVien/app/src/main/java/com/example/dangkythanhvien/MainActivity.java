package com.example.dangkythanhvien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.TaskStackBuilder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText txtName, txtUserName, txtPass, txtNgaySinh;
    private RadioButton rdNam, rdNu;
    private Spinner spQuocTich;
    private Button btnTao;
    private static final String REGEX1 = "\\S";
    private static Pattern pattern;
    public static String NAME = "KIEU";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtUserName = findViewById(R.id.txtUserName);
        txtPass = findViewById(R.id.txtPass);
        txtNgaySinh = findViewById(R.id.txtNgaySinh);

        rdNam = findViewById(R.id.rdNam);
        rdNu = findViewById(R.id.rdNu);

        spQuocTich = findViewById(R.id.spQuocTich);

        btnTao = findViewById(R.id.btnTao);

        List<String> list = new ArrayList<>();
        list.add("Việt Nam");
        list.add("Anh");
        list.add("...");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, list);
        spQuocTich.setAdapter(arrayAdapter);

        btnTao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean kt1 = isNull();
                if (kt1) {
                    boolean kt2 = ktUserName();
                    boolean kt3 = ktPassword();

                    if (kt2 && kt3) {
                        Toast.makeText(getApplicationContext(), "Bạn đã tạo thành công!", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(getApplicationContext(), DangKyThanhCong.class);
                        intent.putExtra(NAME, txtName.getText().toString());
                        startActivity(intent);
                    }
                }
            }
        });
    }

    boolean isNull() {
        boolean flag = true;
        if (txtName.getText().toString().trim().isEmpty()) {
            flag = false;
            Toast.makeText(getApplicationContext(), "Họ tên không được bỏ trống!", Toast.LENGTH_SHORT).show();
        }
        if (txtUserName.getText().toString().trim().isEmpty()) {
            flag = false;
            Toast.makeText(getApplicationContext(), "UserName không được bỏ trống!", Toast.LENGTH_SHORT).show();
        }
        if (txtPass.getText().toString().trim().isEmpty()) {
            flag = false;
            Toast.makeText(getApplicationContext(), "Mật khẩu không được bỏ trống!", Toast.LENGTH_SHORT).show();
        }
        if (txtNgaySinh.getText().toString().trim().isEmpty()) {
            flag = false;
            Toast.makeText(getApplicationContext(), "Ngày sinh không được bỏ trống!", Toast.LENGTH_SHORT).show();
        }
        return flag;
    }

    boolean ktUserName() {
        boolean flag = true;
        if (txtUserName.getText().toString().length() > 128) {
            flag = false;
            Toast.makeText(getApplicationContext(), "UserName không vượt quá 128 kí tự!", Toast.LENGTH_SHORT).show();
        }

        if (!txtUserName.getText().toString().matches("\\S+")){
            flag = false;
            Toast.makeText(getApplicationContext(), "UserName không có khoảng trắng!", Toast.LENGTH_SHORT).show();
        }

        if (!txtUserName.getText().toString().matches("\\w+")) {
            flag = false;
            Toast.makeText(getApplicationContext(), "UserName không chứa kí tự đặc biệt!", Toast.LENGTH_SHORT).show();
        }


        return flag;
    }

    boolean ktPassword() {
        boolean flag = true;
        if (txtPass.getText().toString().length() < 8) {
            flag = false;
            Toast.makeText(getApplicationContext(), "Mật khẩu phải có ít nhất 8 kí tự!", Toast.LENGTH_SHORT).show();
        }

        if (txtPass.getText().toString().matches("\\w+")) {
            flag = false;
            Toast.makeText(getApplicationContext(), "Mật khẩu phải có ít nhất một kí tự đặc biệt!", Toast.LENGTH_SHORT).show();
        }

        if (!txtPass.getText().toString().matches(".*[1-9].*")) {
            flag = false;
            Toast.makeText(getApplicationContext(), "Mật khẩu chứa ít nhất 1 ký tự số!", Toast.LENGTH_SHORT).show();
        }

        if (!txtPass.getText().toString().matches(".*[A-Z].*")) {
            flag = false;
            Toast.makeText(getApplicationContext(), "Mật khẩu phải chứa ít nhất 1 ký tự chữ hoa!", Toast.LENGTH_SHORT).show();
        }

        if (!txtPass.getText().toString().matches(".*[a-z].*")) {
            flag = false;
            Toast.makeText(getApplicationContext(), "Mật khẩu phải chứa ít nhất 1 ký tự thường!", Toast.LENGTH_SHORT).show();
        }
        return flag;
    }
}