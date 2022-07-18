package com.spring.core.session04.dyn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDynUtil {

	// 代理物件
	private Object object;

	// 將代理物件注入
	public ProxyDynUtil(Object object) {
       this.object = object;
	}
	
	public Object getProxy() {
		Object proxyObj = null;
		
		// 類別載入器
		ClassLoader classLoader = object.getClass().getClassLoader();
		
		// 取得代理物件介面
		Class[] interfaces = object.getClass().getInterfaces();
		
		// 取得代理物件
		InvocationHandler invocationHandler = (Object proxy, Method method, Object[] args)->{
			Object result = null;
			MyLogger.before(object.getClass(), method.getName(), args);
			try {
				// 調用業務方法
				result = method.invoke(object, args);
			} catch (Exception e) {
				// Exception: 例外異常通知
				MyLogger.throwing(object.getClass(), e);
			} finally {
				// End: 後置通知
				MyLogger.end(object.getClass(), method.getName(), result);
			}
			return result;
		};
		
		proxyObj = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
		return proxyObj;
	}
	
	
}
