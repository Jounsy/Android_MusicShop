package com.snowman.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int countItems = 0;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.spinner);
        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("Guitar");
        spinnerArrayList.add("Trombon");
        spinnerArrayList.add("Beats");

        spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, spinnerArrayList);
        spinner.setAdapter(spinnerAdapter);
    }

    public void increaseQuantity(View view) {
        TextView quantity = findViewById(R.id.textItemsCount);
        quantity.setText(String.valueOf(++countItems));

    }

    public void decreaseQuantity(View view) {
        TextView quantity = findViewById(R.id.textItemsCount);
        if (countItems > 0) {
            quantity.setText(String.valueOf(--countItems));
        }
        else{quantity.setText("0");
        }
    }

}
