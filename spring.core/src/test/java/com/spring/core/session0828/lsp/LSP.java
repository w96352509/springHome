package com.spring.core.session0828.lsp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class Father{
	void add(int x , int y) {
		System.out.println(x+y);
	}
	
	void foo(HashSet set) {
		System.out.println(set);
	}
	
	Map bar() {     
		return null;
	}
	
	abstract void sub(int x , int y);
}

class son2{
	Father father = new Father() {
		
		@Override
		void sub(int x, int y) {
		}
	};
	
	// 幫助他人取得
	Father getFather() {
		return father;
	}
}

class Son extends Father{ // 不可覆寫非抽象的方法

	void foo(Set set) {  // 超載 Overloading
		System.out.println(set);
	}
	
	@Override
	HashMap bar() {      // 回傳要更嚴格
		return null;
	}
	
	@Override
	void sub(int x , int y) {
		System.out.println(x - y);
	} 
}

public class LSP {

}
