package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtHeight, txtWeight;
    private TextView txtBMI, txtNhanXet1, txtNhanXet2;
    private Button btnTinhToan;
    private RadioButton rdNam, rdNu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHeight = findViewById(R.id.txtHeight);
        txtWeight = findViewById(R.id.txtWeight);

        txtBMI = findViewById(R.id.txtBMI);
        txtNhanXet1 = findViewById(R.id.txtNhanXet1);
        txtNhanXet2 = findViewById(R.id.txtNhanXet2);

        btnTinhToan = findViewById(R.id.btnTinhToan);

        rdNam = findViewById(R.id.rdNam);
        rdNu = findViewById(R.id.rdNu);

        btnTinhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtHeight.getText().toString().trim().isEmpty() || txtWeight.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Bạn cần nhập dữ liệu!", Toast.LENGTH_LONG).show();
                }
                else {
                    double h = Double.parseDouble(txtHeight.getText().toString().trim()) / 100;
                    double w = Double.parseDouble(txtWeight.getText().toString().trim()) ;
                    double BMI = Math.round((w / ( h * h)) * 10) / 10;

                    txtBMI.setText(String.valueOf(BMI));

                    if (rdNu.isChecked()) {
                        if (BMI < 18.5) {
                            txtNhanXet1.setText("Bạn cần tăng cân!");
                            txtNhanXet2.setText("Bạn có chỉ số BMI thấp gầy!");
                        }
                        else
                            if (BMI < 22.9) {
                                txtNhanXet1.setText("Chúc mừng bạn!");
                                txtNhanXet2.setText("Bạn có chỉ số BMI bình thường!");
                            }
                            else
                                if (BMI == 23) {
                                    txtNhanXet1.setText("Bạn nên vận động!");
                                    txtNhanXet2.setText("Bạn có chỉ số BMI thừa cân!");
                                }
                                else
                                    if (BMI < 25) {
                                        txtNhanXet1.setText("Bạn nên vận động và có chế độ ăn uống phù hợp!");
                                        txtNhanXet2.setText("Bạn có chỉ số BMI tiền béo phì!");
                                    }
                                    else
                                        if (BMI < 30) {
                                            txtNhanXet1.setText("Bạn cần giảm cân!");
                                            txtNhanXet2.setText("Bạn có chỉ số BMI béo phì cấp độ I!");
                                        }
                                        else
                                            if (BMI < 40) {
                                                txtNhanXet1.setText("Bạn cần giảm cân ngay!");
                                                txtNhanXet2.setText("Bạn có chỉ số BMI béo phì cấp độ II!");
                                            }
                                            else {
                                                txtNhanXet1.setText("Bạn cần giảm cân khẩn cấp!");
                                                txtNhanXet2.setText("Bạn có chỉ số BMI béo phì cấp độ III!");
                                            }

                    } else {
                        if (BMI < 18.5) {
                            txtNhanXet1.setText("Bạn cần tăng cân!");
                            txtNhanXet2.setText("Bạn có chỉ số BMI thấp gầy!");
                        }
                        else
                            if (BMI < 25) {
                                txtNhanXet1.setText("Chúc mừng bạn!");
                                txtNhanXet2.setText("Bạn có chỉ số BMI bình thường!");
                            }
                            else
                                if (BMI < 30) {
                                    txtNhanXet1.setText("Bạn nên vận động!");
                                    txtNhanXet2.setText("Bạn có chỉ số BMI thừa cân!");
                                }
                                else
                                    if (BMI < 30) {
                                        txtNhanXet1.setText("Bạn nên vận động và có chế độ ăn uống phù hợp!");
                                        txtNhanXet2.setText("Bạn có chỉ số BMI tiền béo phì!");
                                    }
                                    else
                                        if (BMI < 35) {
                                            txtNhanXet1.setText("Bạn cần giảm cân!");
                                            txtNhanXet2.setText("Bạn có chỉ số BMI béo phì cấp độ I!");
                                        }
                                        else
                                            if (BMI < 40) {
                                                txtNhanXet1.setText("Bạn cần giảm cân ngay!");
                                                txtNhanXet2.setText("Bạn có chỉ số BMI béo phì cấp độ II!");
                                            }
                                            else {
                                                txtNhanXet1.setText("Bạn cần giảm cân khẩn cấp!");
                                                txtNhanXet2.setText("Bạn có chỉ số BMI béo phì cấp độ III!");
                                            }

                    }
                }
            }
        });

    }
}