package com.spring.core.solid.lkp.before;

import com.spring.core.solid.lkp.Wallet;

public class Customer {
    private Wallet waller;

    public Customer(Wallet waller) {
        this.waller = waller;
    }
    
    // 讓外界可以得到你的皮包
    public Wallet getWaller() {
        return waller;
    }

    @Override
    public String toString() {
        return "Customer{" + "waller=" + waller + '}';
    }
    
}
