package com.snowman.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    String addresses[] = {"Ndrdtstwerty@gmail.com"};
    String subject = "Order from Music Shop"; //Тема
    String emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent recievedIntent = getIntent();
        String userName = recievedIntent.getStringExtra("userName");
        String goodsName = recievedIntent.getStringExtra("goodsName");
        int quantity = recievedIntent.getIntExtra("countItems",0);
        double orderPrice = recievedIntent.getDoubleExtra("price",0.0);
        emailText = "Customer Name: " + userName + "\n Goods name: " + goodsName + "\n Quantity: " + quantity +"\n Price: " + orderPrice + "\n Order price: " + orderPrice * quantity;
        TextView textView = findViewById(R.id.orderTextView);
        textView.setText(emailText);
        setTitle(R.string.order_activity_name);
    }
    public void submitOrder(View view){
         Intent intent = new Intent(Intent.ACTION_SEND);
         intent.setType("text/plain");
         intent.putExtra(Intent.EXTRA_TEXT, emailText);
         Intent chosenIntent = Intent.createChooser(intent, "Choose application for send mail");
          if (chosenIntent.resolveActivity(getPackageManager()) != null) {
              startActivity(chosenIntent);
          }
}

    public void submitOrderOnMail(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        //intent.setType("*.*"); // при комментировании нижней строки должно появляться диалоговое окно с выбором приложения
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
