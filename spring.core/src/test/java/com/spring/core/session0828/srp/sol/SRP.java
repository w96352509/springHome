package com.spring.core.session0828.srp.sol;

interface Add extends Call , Camera{
	
}

interface Call{
	void dial(String number);
}

interface Camera{
	void takaPicture();
}

interface TV{
	void watch();
}


// java 8 寫法 : 引入 property
// 也可使用 implements
class IPhone { // 建立職責並組裝功能
  Call call = (number) -> System.out.println("撥號" + number);
  Camera camera = () -> System.out.println("拍照");
  TV tv = () -> System.out.println("影片");
}

class OldPhone{
	 Call call = (number) -> System.out.println("撥號" + number);
	 // 無其他功能
}

class Phone implements Add {

	@Override
	public void dial(String number) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void takaPicture() {
		// TODO Auto-generated method stub
		
	}
	
}

public class SRP {
	public static void main(String[] args) {
		OldPhone phone = new OldPhone();
		phone.call.dial("091234567");
	}
}
