package com.spring.core.solid.lkp;

public class Wallet {
    private int money; // 錢
    private String id; // 身分證

    public Wallet(int money, String id) {
        this.money = money;
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Wallet{" + "money=" + money + ", id=" + id + '}';
    }
}
