package com.spring.core.solid.lkp.before;

// 送報生, 負責收款


import java.util.List;

import com.spring.core.solid.lkp.Wallet;

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
            // 先拿到客戶的皮包
            Wallet wallet = customer.getWaller();
            // 再從皮包拿錢
            int total = wallet.getMoney();
            // 扣掉 100 元
            total = total - 100;
            // 再將剩餘的錢放回皮包
            wallet.setMoney(total);
            // 得到不應該得到的客戶 id
            wallet.getId();
            // 做其他事...
        }
    }
    
}
