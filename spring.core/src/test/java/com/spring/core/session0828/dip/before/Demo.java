package com.spring.core.session0828.dip.before;

class Email{ 
	public String message() {
		return "Email";
	}
}

class Line{
	public String message() {
		return "Line";
	}
}

class SMS{
	public String message() {
		return "SMS";
	}
}

// 會造成隨意增加或隨意減少(違反開放封閉原則)
class IPhone{ // 實體 (假設不可更改)
	public void read(Email email) {
		System.out.println(email.message());
	}
	
	// 超載
	public void read(Line line) {
		System.out.println(line.message());
	}
	
	// 強制加入實作
	public void read(SMS sms) {
		System.out.println(sms.message());
	}
}

public class Demo {

	public static void main(String[] args) {
		IPhone iPhone = new IPhone();
		iPhone.read(new Email());
		iPhone.read(new Line());
		iPhone.read(new SMS());
	}
	
}
