package com.spring.core.solid.srp.before;

interface MyPhone {
    void dial(String number); // 打電話
    void camera(); // 照相
    void watch();  // 看直播
}

class SmartPhone implements MyPhone { // 智慧電話
    public void dial(String number) {
        System.out.println("撥打電話: " + number);
    }
    public void camera() {
        System.out.println("照相");
    }
    public void watch() {
        System.out.println("看直播");
    }
}

class OldPhone implements MyPhone { // 復古電話
    public void dial(String number) {
        System.out.println("撥打電話: " + number);
    }
    public void camera() { throw new UnsupportedOperationException("無拍照功能");}
    public void watch() { throw new UnsupportedOperationException("無觀看直播功能");}
}

public class Demo {
    public static void main(String[] args) {
        MyPhone phone = new OldPhone();
        phone.dial("0912345678");
        phone.camera();  // 若沒有此服務, 就應該不要讓我可以使用
        phone.watch();   // 若沒有此服務, 就應該不要讓我可以使用
    }
}
