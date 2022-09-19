package com.spring.core.solid.lkp;


import java.util.Arrays;
import java.util.List;


import com.spring.core.solid.lkp.before.Customer;
import com.spring.core.solid.lkp.before.PaperBoy;

public class Test {
    public static void main(String[] args) {
        List<Customer> customers = Arrays.asList(
                new Customer(new Wallet(1000, "A1234")),
                new Customer(new Wallet(500, "B1234")),
                new Customer(new Wallet(200, "C1234"))
        );
        System.out.println(customers);
        
        // 送報生收款
        PaperBoy paperBoy = new PaperBoy(customers);
        paperBoy.collectMoney();
        
        System.out.println(customers);
    }
}
