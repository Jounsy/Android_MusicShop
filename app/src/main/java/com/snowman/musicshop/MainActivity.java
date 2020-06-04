package com.snowman.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
    EditText getUserName;

    Map goodsMap;
    String goodsName;
    double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getUserName = findViewById(R.id.userNameEditText);
        createSpinner();
        createMap();

    }

    private void createMap() {
        goodsMap = new HashMap<String,Double>();
        goodsMap.put("Guitar",500d);
        goodsMap.put("Trombon",1000d);
        goodsMap.put("Drums",350d);
    }

    public void createSpinner(){
        spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);  //Важно!

        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("Guitar");
        spinnerArrayList.add("Trombon");
        spinnerArrayList.add("Drums");

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
        changeItemImage(goodsName);
        price = (double)goodsMap.get(goodsName);
        sumCostOfProduct(price,countItems);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void changeItemImage (String itemName){
        if (itemName.equals("Guitar")){
            goodsImageView.setImageResource(R.drawable.triple_guitars);
        } else if(itemName.equals("Trombon")){
            goodsImageView.setImageResource(R.drawable.trombon);
        } else if (itemName.equals("Drums")){
            goodsImageView.setImageResource(R.drawable.drums);
        }
    }

    public void addToCart(View view) {

        String userName = getUserName.getText().toString();

        Order order = new Order(userName, goodsName, countItems, price);
        //Log.d("addToCart", userName + " " + goodsName  + " " + countItems  + " " + price);
    }
}
