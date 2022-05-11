package com.study.springjungsuk.singleton;

public class StateFulServiceError {
    private int price;

    //주문 서비스
    public void order(String name, int price){
        System.out.println("name = " + name + "price = " + price);
//        this.price = price;   /// 여기가 문제
    }

    public int getPrice() {
        return price;
    }


}
