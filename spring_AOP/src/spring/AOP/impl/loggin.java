package spring.AOP.impl;

 
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * 可使用  @order 來定義該切面的優先度
 * 
 * */

@Aspect
@Component
public class loggin {
	
	@Pointcut("execution(* spring.AOP.impl.calculatorImpl.*(..))")
	public void Pointcut() {}
	
	//前置通知
	@Before("Pointcut()") 
	public void beforeMethod(JoinPoint joinPoint) { 
		String name=joinPoint.getSignature().getName(); 
		List<Object> list=Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+name+" begin with"+list); 
	} 
	//後置通知
	@After("Pointcut()") 
	public void afterMethod(JoinPoint joinPoint) { 
		String name=joinPoint.getSignature().getName();
		System.out.println("The method "+name+" end "); 
	} 
	//後置通知,可訪問到結果
	@AfterReturning(value ="Pointcut()",
	returning = "result") 
	public void afterReturnMethod(JoinPoint joinPoint,Object result){ 
		String name=joinPoint.getSignature().getName();
		System.out.println("The method "+name+" end "+result); 
	} 
	//異常通知,可指定特定異常執行通知代碼
	@AfterThrowing(value ="Pointcut()",
	throwing = "e") 
	public void afterThrowMethod(JoinPoint joinPoint,Exception e){ 
		String name=joinPoint.getSignature().getName();
		System.out.println("The method "+name+" end "+e); }
	//環繞通知
	@Around("Pointcut()")
	public Object aroundMethod(ProceedingJoinPoint pjp) {
		Object result=null;
		String name = pjp.getSignature().getName();
		try {
			//前置通知 @Before
			System.out.println("The method "+name+" begin with "+Arrays.asList(pjp.getArgs()));
			//執行目標方法
			result=pjp.proceed();
			//返回通知 @AfterReturning
			System.out.println("The method "+name+" end with "+result);
		} catch (Throwable e) {
			//異常通知 @AfterThrowing
			System.out.println("The method occurs exception :"+e);
		}
		return result;
	}
}
