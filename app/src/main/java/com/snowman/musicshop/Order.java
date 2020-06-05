package com.snowman.musicshop;

import android.content.Intent;

public class Order {
String userName;
String goodsName;
int quantity;
double orderPrice;

    Order (String userName, String goodsName, int quantity, double orderPrice){
        this.userName = userName;
        this.goodsName = goodsName;
        this.quantity = quantity;
        this.orderPrice = orderPrice;

    }
}
