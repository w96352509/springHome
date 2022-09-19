package com.spring.core.solid.srp.sol;

interface Call {  // 功能 
    void dial(String number);
}
interface Camera {  // 功能 
    void takaPicture();
}
interface TV {  // 功能 
    void watch();
}

class IPhone { // 建立職責, 組合需要的功能
    Call call = (number) -> System.out.println("撥號: " + number);
    Camera camera = () -> System.out.println("拍照");
    TV tv = () -> System.out.println("看直播");
}

class OldPhone { // 建立職責, 組合需要的功能
    Call call = (number) -> System.out.println("撥號: " + number);
    // 沒有 Camera 與 TV
}

public class SRP {
    public static void main(String[] args) {
        OldPhone phone = new OldPhone();
        phone.call.dial("0912345678");
    }
}
