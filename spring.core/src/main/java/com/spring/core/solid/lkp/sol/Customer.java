package com.spring.core.solid.lkp.sol;

import com.spring.core.solid.lkp.Wallet;

public class Customer {
    private Wallet waller;

    public Customer(Wallet waller) {
        this.waller = waller;
    }
    
    // 請求付款
    public void pay(int payment) {
        int total = waller.getMoney();
        total = total - payment;
        waller.setMoney(total);
    }

    @Override
    public String toString() {
        return "Customer{" + "waller=" + waller + '}';
    }
    
}
