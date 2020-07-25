package com.example.checkapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnCountryPickerListener {

    Button country_Button;
    ImageView img;
    Country country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        country_Button=findViewById(R.id.country_Button);

        country_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showPicker();
            }
        });


    }

    @Override
    public void onSelectCountry(Country country) {

    }


    private void showPicker() {
        CountryPicker.Builder builder =
                new CountryPicker.Builder().with(MainActivity.this)
                        .listener(MainActivity.this);

        CountryPicker countryPicker = builder.build();

            countryPicker.showBottomSheet(MainActivity.this);

    }



}