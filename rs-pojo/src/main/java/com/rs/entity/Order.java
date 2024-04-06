package com.rs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


public class Order implements Serializable{
    static private Order order;
    private List<Good> goods=null;
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

    public Order getOrder(){
        if(order==null)  order=new Order();

        return order;
    }


    public void addGood(Good good){
        goods.add(good);
    }

    public void removeGood(Good good){
        goods.remove(good);
    }
}
