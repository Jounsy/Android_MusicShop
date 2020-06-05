package com.snowman.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent recievedIntent = getIntent();
        String userName = recievedIntent.getStringExtra("userName");
        String goodsName = recievedIntent.getStringExtra("goodsName");
        int quantity = recievedIntent.getIntExtra("countItems",0);
        double orderPrice = recievedIntent.getDoubleExtra("price",0.0);
        TextView textView = findViewById(R.id.orderTextView);
        textView.setText("Customer Name: " + userName + "\n Goods name: " + goodsName + "\n Quantity: " + quantity +"\n Price: " + orderPrice + "\n Order price: " + orderPrice * quantity);
        setTitle(R.string.order_activity_name);
    }
}
