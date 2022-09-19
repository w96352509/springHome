package com.spring.core.session0828.srp.before;

interface MyPhone{
	// 功能
	void dial(String number);
	void camera();
	void watch(); 
}

//現代電話
class SmartPhone implements MyPhone{ 

	@Override
	public void dial(String number) {
		System.out.println("電話號碼" + number);
	}

	@Override
	public void camera() {
		System.out.println("拍照");
	}

	@Override
	public void watch() {
		System.out.println("影片");
	}
	
}

// 復古電話
class OldPhone implements MyPhone{

	@Override
	public void dial(String number) {
		 System.out.println("電話號碼" + number);
	}

	@Override
	public void camera() {
	     throw new UnsupportedOperationException("無拍照功能");
	}

	@Override
	public void watch() {
		 throw new UnsupportedOperationException("無觀看影片功能");
	}
	
}

public class Demo {
 
	public static void main(String[] args) {
		MyPhone myPhone = new OldPhone();
		myPhone.camera(); // 無功能就不應該可以呼叫
	}
	
}
