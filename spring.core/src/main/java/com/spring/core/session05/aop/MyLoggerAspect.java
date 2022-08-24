package com.spring.core.session05.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//切面程式
@Component // 可以被 Spring 管理的物件
@Aspect // 切面
@Order(1) // 數字越小越先執行(若不設定預設就是int的最大值)
		  // 使用時機: 有多個切面程式在同一個程切關注點要執行時	

public class MyLoggerAspect {
	
	@Pointcut(value = "execution(* com.spring.core.session05.aop.*.*(..))")
	public void pt() {}
	
	@Pointcut(value = "execution(* com.spring.core.session05.aop.*.add(Integer , Integer))")
	public void pt2() {};
	
	// 前置通知 Advice: 執行該連接點之前所要執行的程式
	//@Before(value = "execution(public Integer com.spring.core.session05.aop.MathCalcImpl.add(Integer, Integer))") // 切入點表達式 Spring EL : execution(..)
	//@Before(value = "execution(* com.spring.core.session05.aop.MathCalcImpl.*(..))") // * 表示任意方法, .. 表示0~多任意參數
	//@Before(value = "execution(public * com.spring.core.session05.aop.MathCalcImpl.*(..))")
	//@Before(value = "execution(* com.spring.core.session05.aop.*.*(..))") // 在指定套件下之任意類 + 任意方法
	//@Before(value = "execution(* *(..))")  // 全部攔截
	//@Before(value = "pt() && !pt2()") // 支援 &&, ||, !
	/*
	@Before(value = "pt()")
	public void beforeAdvice(JoinPoint joinPoint) { // joinPoint 連接點
		String methodName = joinPoint.getSignature().getName(); // 取得連接點的方法簽章名稱
		Object[] args = joinPoint.getArgs(); // 方法參數
		System.out.printf("前置通知 - 方法名稱: %s 方法參數: %s\n", methodName, args);
	}
	
	@AfterReturning(value = "pt()" , returning = "result")
	public void afterReturning(JoinPoint joinPoint , Object result) {
		String methodName = joinPoint.getSignature().getName(); // 取得連接點的方法簽章名稱
		Object[] args = joinPoint.getArgs(); // 方法參數
		System.out.printf("返回通知 - 方法名稱: %s 方法參數: %s 結果: %s \n", methodName, args , result);
	}
	
	@AfterThrowing(value = "pt()" , throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint , Throwable ex) {
		String methodName = joinPoint.getSignature().getName(); // 取得連接點的方法簽章名稱
		Object[] args = joinPoint.getArgs(); // 方法參數
		System.out.printf("異常通知 - 方法名稱: %s 方法參數: %s 異常: %s \n", methodName, args , ex);
	}
	
	@After(value = "pt()")
	public void afterAdvice(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName(); // 取得連接點的方法簽章名稱
		System.out.printf("後置通知 - 方法名稱: %s\n", methodName);
	}
	
	*/
	
	@Around(value = "pt2()")
	public Object  aroundAdvice(ProceedingJoinPoint joinPoint)  {
		Object result = null;
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		try {
			// 1. 前置通知
			System.out.printf("環繞通知: 前置通知 - 方法名稱: %s 參數: %s\n", methodName, Arrays.toString(args));
			// 2. 執行業務邏輯 (重要!! 一定要加入)
			result = joinPoint.proceed();
			// 3. 返回通知
			System.out.printf("環繞通知: 返回通知 - 方法名稱: %s 返回值: %s\n", methodName, result);
		} catch (Throwable e) {
			// 4. 異常通知
			System.out.printf("環繞通知: 異常通知 - 方法名稱: %s 例外: %s\n", methodName, e);
		} finally {
			// 5. 後置通知
			System.out.printf("環繞通知: 後置通知 - 方法名稱: %s\n", methodName);
		}
		return result;
	}
}