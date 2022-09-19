package com.spring.core.solid.dip.before;

class Email { // Email 服務功能
    public String message() { return "email..."; }
}

class Line { // Line 服務功能
    public String message() { return "line..."; }
}

class SMS { // 簡訊功能
    public String message() { return "sms..."; }
}

class IPhone { // 實體（不可再變動了）
    public void read(Email email) {
        System.out.println(email.message());
    }
    public void read() {
        Line line = new Line();
        System.out.println(line.message());
    }
    // 強迫加入實作, 違反開放關閉原則
    public void read(SMS sms) {
        System.out.println(sms.message());
    }
}

public class Demo {
    public static void main(String[] args) {
        IPhone iPhone = new IPhone();
        iPhone.read(new Email());
        iPhone.read();
        iPhone.read(new SMS());
    }
}
