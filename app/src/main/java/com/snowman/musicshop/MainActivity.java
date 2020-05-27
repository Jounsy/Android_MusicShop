package com.snowman.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int countItems = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
