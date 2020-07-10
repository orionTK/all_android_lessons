package com.example.maytinhbt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private Button btnDellALL, btnDellChi, btnChia, btn0,btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,btnBang,
            btnTru, btnNhan,btnCong, btnCham, btnChuyenDau;
    private TextView txtPhepTinh;
    double so1 = 0, so2 = 0;
    String dau = "";
    String chuoiPT = "";
    int flag = 0;
    int flagNum = 0;
    int flagChia = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDellALL = findViewById(R.id.btnDellALL);
        btnDellChi = findViewById(R.id.btnDellChi);
        btnChia = findViewById(R.id.btnChia);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnBang = findViewById(R.id.btnBang);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnCong = findViewById(R.id.btnCong);
        btnCham = findViewById(R.id.btnCham);
        btnChuyenDau = findViewById(R.id.btnChuyenDau);

        txtPhepTinh = findViewById(R.id.txtPhepTinh);
        txtPhepTinh.setText("0");
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemChuoiSo(String.valueOf(0));
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemChuoiSo(String.valueOf(1));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemChuoiSo(String.valueOf(2));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemChuoiSo(String.valueOf(3));
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemChuoiSo(String.valueOf(4));
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemChuoiSo(String.valueOf(5));
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemChuoiSo(String.valueOf(6));
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemChuoiSo(String.valueOf(7));
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemChuoiSo(String.valueOf(8));
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemChuoiSo(String.valueOf(9));
            }
        });

        btnChuyenDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (chuoiPT.charAt(0) == '-') {
                   chuoiPT = chuoiPT.substring(1);
               }
               else if (chuoiPT.charAt(0) == '+') {
                   chuoiPT = chuoiPT.substring(1);
                   chuoiPT = "-" + chuoiPT;
               }
               else
                   chuoiPT = "-" + chuoiPT;
                HienThi();
            }
        });

        btnCham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chuoiPT.indexOf(".") == -1 ||   (chuoiPT.lastIndexOf("+") != -1 && chuoiPT.substring(chuoiPT.lastIndexOf("+")).indexOf(".") == -1)
                || (chuoiPT.lastIndexOf("-") != -1 && chuoiPT.substring(chuoiPT.lastIndexOf("-")).indexOf(".") == -1)
                    || (chuoiPT.lastIndexOf("x") != -1 && chuoiPT.substring(chuoiPT.lastIndexOf("x")).indexOf(".") == -1)
                || (chuoiPT.lastIndexOf("/") != -1 && chuoiPT.substring(chuoiPT.lastIndexOf("/")).indexOf(".") == -1))
                    chuoiPT += ".";
                HienThi();
            }
        });

        btnBang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 0) {
                    TinhToan();
                }

            }
        });

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemDau("+");
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemDau("-");
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemDau("x");
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemDau("/");
            }
        });

        btnDellChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAC();
            }
        });

        btnDellALL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuoiPT = "0";
                HienThi();
            }
        });
    }

    void ThemChuoiSo(String text) {
        if (flag == 1) {
            chuoiPT = text;
            flag = 0;
        }
        else
            chuoiPT += text;
        flagNum = 1;
        HienThi();


    }

    void ThemDau(String text) {
//        if (chuoiPT.indexOf("/") != -1 || chuoiPT.indexOf("+") != -1 || chuoiPT.indexOf("x") != -1 || chuoiPT.indexOf("-") != -1) {
//
//        }
//        if ((chuoiPT.charAt(chuoiPT.length() - 1) == '+' || chuoiPT.charAt(chuoiPT.length() - 1) == '-' || chuoiPT.charAt(chuoiPT.length() - 1) == 'x'
//                || chuoiPT.charAt(chuoiPT.length() - 1) == '/')) {
//            so1 = Double.parseDouble(chuoiPT.substring(0,chuoiPT.length() - 2));
        if (flagNum == 1) {
            chuoiPT += text;
            flag = 0;

        }


        HienThi();

    }

    void HienThi() {
        txtPhepTinh.setText(chuoiPT);
    }

    void deleteAC() {
        if (!chuoiPT.isEmpty()) {
            chuoiPT = chuoiPT.substring(0, chuoiPT.length() - 1);
            HienThi();
        }

    }

    //Mảng chứa các phép tính +, - , x, /
    public ArrayList<String> arrOperation;
    public ArrayList<String> arrOperationT;
    //Mảng chứa các số
    public ArrayList<Double> arrNumber;
    public ArrayList<Double> arrNumberT;

    //Lấy tất cả các phép tính lưu vào mảng arrOperation
    public int addOperation() {
        arrOperation = new ArrayList<>();

        char[] cArray = chuoiPT.toCharArray();
        Toast.makeText(getApplicationContext(), String.valueOf(cArray), Toast.LENGTH_SHORT).show();

        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrOperation.add(cArray[i] + "");
                    break;
                case 'x':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '/':
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }
    //Lấy tất cả các số lưu vào mảng arrNumber
    public void addNumber() {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(chuoiPT);
        while(matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }

    public void TinhToan() {
        double result = 0;
        addOperation();
        addNumber();
        Toast.makeText(getApplicationContext(), String.valueOf(arrNumber) + String.valueOf(arrOperation), Toast.LENGTH_SHORT).show();
        if(arrOperation == null){
            if (arrNumber == null)
                chuoiPT = String.valueOf(0);
            else
                chuoiPT = String.valueOf(arrNumber.get(0));
        }else  {


//            Toast.makeText(getApplicationContext(), String.valueOf(arrNumber) + String.valueOf(arrOperation.get(0).equals("x")), Toast.LENGTH_SHORT).show();

            if(arrOperation.size() >= arrNumber.size()){
                chuoiPT= "Lỗi định dạng" ;

            }else
            {
                int n = arrOperation.size();
                for (int i = 0; i < arrOperation.size(); i++) {
                    if (arrOperation.get(i).equals("x")) {

                        arrNumber.set(i,arrNumber.get(i)* arrNumber.get(i + 1));
                        arrNumber.remove(i + 1);
                        arrOperation.remove(i);
                        i--;
                    }
                    else
                    if (arrOperation.get(i).equals("/")) {

                        if (arrNumber.get(i + 1) == 0)
                        {
                            Toast.makeText(getApplicationContext(), "Số bị chia phải khác không!", Toast.LENGTH_SHORT).show();
                            chuoiPT = "ERROR";
                            flagChia = 1;
                        }

                        arrNumber.set(i,arrNumber.get(i)/ arrNumber.get(i + 1));
                        arrNumber.remove(i + 1);

                        arrOperation.remove(i);
                        Toast.makeText(getApplicationContext(), String.valueOf(i) + String.valueOf(arrOperation.size()), Toast.LENGTH_SHORT).show();
                        i--;
                    }

                }
//                Toast.makeText(getApplicationContext(), String.valueOf(arrNumber) + String.valueOf(arrOperation), Toast.LENGTH_SHORT).show();

                if (arrOperation == null) {
                    result = arrNumber.get(0);
                }
                else {
                    for (int i = 0; i < (arrNumber.size() - 1); i++) {
                        switch (arrOperation.get(i)) {
                            case "+":
                                if (i == 0) {
                                    result = arrNumber.get(i) + arrNumber.get(i + 1);

                                } else {
                                    result = result + arrNumber.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    result = arrNumber.get(i) - arrNumber.get(i + 1);

                                } else {
                                    result = result - arrNumber.get(i + 1);

                                }
                                break;
                            case "x":
                                if (i == 0) {
                                    result = arrNumber.get(i) * arrNumber.get(i + 1);

                                } else {
                                    result = result * arrNumber.get(i + 1);

                                }
                                break;
                            case "/":
                                if (arrNumber.get(i + 1) == 0)
                                {
                                    Toast.makeText(getApplicationContext(), "Số bị chia phải khác không!", Toast.LENGTH_SHORT).show();
                                    chuoiPT = "ERROR";
                                    flagChia = 1;
                                    break;
                                }
                                else
                                if (i == 0) {
                                    result = arrNumber.get(i) / arrNumber.get(i + 1);

                                }
                                else {
                                    result = result / arrNumber.get(i + 1);

                                }
                                break;
                            default:
                                break;

                        }

                    }
            }
                if (chuoiPT != "ERROR" && flagChia == 0)
                    chuoiPT += " = " + String.format("%.2f",result);
            }
        }
        flagNum = 0;
        flag = 1;
        HienThi();
        flagChia = 0;
    }
}