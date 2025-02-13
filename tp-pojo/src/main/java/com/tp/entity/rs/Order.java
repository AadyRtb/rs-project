package com.tp.entity.rs;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Order implements Serializable{
    static private Order order;//单例
    private List<Good> goods;

    private double price;
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private LocalDateTime orderTime;

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    //返回单例
    public static Order getOrder(){
        if(order==null) {
            order=new Order();
        order.setGoods(new ArrayList<Good>());
        }

        return order;
    }


    public void addGood(Good good){
        goods.add(good);
    }

    public void removeGood(Good good){
        goods.remove(good);
    }

    public double getPrice(){
        //TODO 计算总价
        return goods.stream().mapToDouble(Good::getPrice).sum();
    }
}
