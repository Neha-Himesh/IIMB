package com.example.nehahimesh.iimb.drawer;

import java.util.Date;

/**
 * Created by USER on 06-02-2018.
 */

public class Order {
    public String order_no;
    public String order_date;
    public String order_source;
    public String customer_id;
    public String sku_type;
    public Integer quantity;
    public String due_date;
    public String status;
    public String date_of_delivery;
    public Order(){}

    public Order(String order_no,String order_date,String order_source,String customer_id, String sku_type,Integer quantity, String due_date,String status,String date_of_delivery){
        this.order_no=order_no;
        this.order_date=order_date;
        this.order_source=order_source;
        this.customer_id=customer_id;
        this.sku_type=sku_type;
        this.quantity=quantity;
        this.due_date=due_date;
        this.status=status;
        this.date_of_delivery=date_of_delivery;

    }

}
