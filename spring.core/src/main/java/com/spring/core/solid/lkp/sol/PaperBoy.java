package com.spring.core.solid.lkp.sol;

// 送報生, 負責收款

import java.util.List;

public class PaperBoy {
    // 他有許多的客戶
    private List<Customer> customers;

    public PaperBoy(List<Customer> customers) {
        this.customers = customers;
    }
    
    // 收集所有報紙費用 $100
    public void collectMoney() {
        // 輪詢所有客戶
        for(Customer customer : customers) {
            // 請客服付款
            customer.pay(1000);
        }
    }
    
}
