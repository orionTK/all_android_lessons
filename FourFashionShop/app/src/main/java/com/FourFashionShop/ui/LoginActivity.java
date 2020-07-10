package com.FourFashionShop.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ScrollView;

import com.FourFashionShop.R;

public class LoginActivity extends AppCompatActivity {

    //private TextView tvLogin;
    private Button loginButton;
    private ScrollView sv;
    private Animation svAnim;
    //private Toolbar bgHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //tvLogin     = findViewById(R.id.tvLogin);
        loginButton = findViewById(R.id.loginBtn);
        //bgHeader = findViewById(R.id.bgHeader);
        sv = findViewById(R.id.sv);

        svAnim = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        sv.animate();
        sv.startAnimation(svAnim);
//        tvLogin.animate();
//        tvLogin.startAnimation(svAnim);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
            }
        });

    }
}
