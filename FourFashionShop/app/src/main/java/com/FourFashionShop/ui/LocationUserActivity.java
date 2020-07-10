package com.FourFashionShop.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.FourFashionShop.R;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

public class LocationUserActivity extends AppCompatActivity {
    private Button btSaveLocation, btnLocation;
    private Button btnVanPhong, btnNhaRieng;
    private TextInputEditText txtInputLocation, txtInputName, txtInputNumber;
    private static final int REQUEST_CODE_LOCATION_PERMISSION = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_user);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Thêm Địa Chỉ Giao Hàng");

        btSaveLocation = findViewById(R.id.btSaveLocation);
        btnNhaRieng = findViewById(R.id.btnNhaRieng);
        btnLocation = findViewById(R.id.btnLocation);
        txtInputLocation = findViewById(R.id.txtInputLocation);
        txtInputName = findViewById(R.id.txtInputName);
        txtInputNumber = findViewById(R.id.txtInputNumber);

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(
                        getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(
                            LocationUserActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                REQUEST_CODE_LOCATION_PERMISSION
                    );

                } else {
                    getCurrentLocation();
                }
            }
        });

        btnNhaRieng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        btSaveLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code luu location

                //
                if (txtInputName.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), "Họ tên không được bỏ trống!", Toast.LENGTH_LONG).show();
                else
                    if (txtInputLocation.getText().toString().isEmpty())
                        Toast.makeText(getApplicationContext(), "Địa chỉ không được bỏ trống!", Toast.LENGTH_LONG).show();
                    else
                    if (txtInputNumber.getText().toString().isEmpty())
                        Toast.makeText(getApplicationContext(), "Số điện thoại không được bỏ trống!", Toast.LENGTH_LONG).show();
                    else {
                        Intent comeback = new Intent(getApplication(), BeforeOrderActivity.class);
                        startActivity(comeback);
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_LOCATION_PERMISSION && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation();
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void getCurrentLocation() {
        final LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(3000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        final Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

        LocationServices.getFusedLocationProviderClient(LocationUserActivity.this)
                .requestLocationUpdates(locationRequest, new LocationCallback() {
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        super.onLocationResult(locationResult);
                        LocationServices.getFusedLocationProviderClient(LocationUserActivity.this)
                                .removeLocationUpdates(this);
                        String result;
                        if (locationResult != null && locationResult.getLocations().size() > 0) {
                            int index = locationResult.getLocations().size() - 1;
                            double x = locationResult.getLocations().get(index).getLatitude();
                            double y = locationResult.getLocations().get(index).getLongitude();
                            List<Address> addresses = null;
                            try {
                                addresses = geocoder.getFromLocation(
                                        x,
                                        y,
                                        // In this sample, get just a single address
                                        1);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            if (addresses != null && addresses.size() > 0) {
                                Address address = addresses.get(0);
                                // sending back first address line and locality
                                result = address.getAddressLine(0);
                                txtInputLocation.setText(result);

                            }

                        }
                    }
                }, Looper.getMainLooper());
    }
}




