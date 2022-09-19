package com.spring.core.session0828.ocp;

// 加入一個抽象類別
// 也可使用介面
abstract class Shape {
	abstract String draw();
}

class Rectangle extends Shape {
	public String draw() {
		return "畫矩形";
	};
}

class Traingle extends Shape {
	public String draw() {
		return "畫三角形";
	};
}

class Circle extends Shape { // 新功能
	public String draw() {
		return "畫圓形";
	};
}

// 類似範本 dip 的 IPhone
class Edit { // 編輯板 (不可改變)
	String draw(Shape shape) {
		return shape.draw();
	}
}

public class OCP {
	public static void main(String[] args) {
		Edit edit = new Edit();
		System.out.println(edit.draw(new Rectangle()));
		System.out.println(edit.draw(new Traingle()));
		System.out.println(edit.draw(new Circle()));
	}
}
