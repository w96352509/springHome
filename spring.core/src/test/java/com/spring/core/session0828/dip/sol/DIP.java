package com.spring.core.session0828.dip.sol;



interface Receiver {
	public String message();
}

class Email implements Receiver{ 
	public String message() {
		return "Email";
	}
}

class Line implements Receiver{
	public String message() {
		return "Line";
	}
}

class SMS implements Receiver {
	public String message() {
		return "SMS";
	}
}


class IPhone{ // 實體 (假設不可更改)
	public void read(Receiver receiver) {
		System.out.println(receiver.message());
	}
}

public class DIP  {

	public static void main(String[] args) {
		IPhone iPhone = new IPhone();
		iPhone.read(new Email());
		iPhone.read(new Line());
		iPhone.read(new SMS());
	}
	
}
