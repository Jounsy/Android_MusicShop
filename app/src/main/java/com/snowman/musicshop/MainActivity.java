package com.snowman.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int countItems;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;
    ImageView goodsImageView;

    Map goodsMap;
    String goodsName;
    double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);  //Важно!

        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("Guitar");
        spinnerArrayList.add("Trombon");
        spinnerArrayList.add("Beats");

        goodsMap = new HashMap<String,Double>();
        goodsMap.put("Guitar",500d);
        goodsMap.put("Trombon",1000d);
        goodsMap.put("Beats",350d);

        spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, spinnerArrayList);
        spinner.setAdapter(spinnerAdapter);

    }

    public void increaseQuantity(View view) {
        TextView quantity = findViewById(R.id.textItemsCount);
        quantity.setText(String.valueOf(++countItems));
        sumCostOfProduct(price,countItems);
    }

    public void decreaseQuantity(View view) {
        TextView quantity = findViewById(R.id.textItemsCount);
        if (countItems > 0) {
            quantity.setText(String.valueOf(--countItems));
        }
        else{quantity.setText("0");
        }
        sumCostOfProduct(price,countItems);
    }

    public void sumCostOfProduct(Double price, Integer count){
        TextView summaText = findViewById(R.id.textDollarsCount);
        summaText.setText("" + price * count);
        Toast toast = Toast.makeText(getApplicationContext(),
                "Цена: " + price * count, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        goodsImageView = findViewById(R.id.goodsImageView);
        goodsName = spinner.getSelectedItem().toString();
        Toast toast = Toast.makeText(getApplicationContext(),
                "Товар выбран" + goodsName, Toast.LENGTH_SHORT);
        toast.show();
        price = (double)goodsMap.get(goodsName);
        sumCostOfProduct(price,countItems);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
