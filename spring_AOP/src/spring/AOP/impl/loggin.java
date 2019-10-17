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
 * �i�ϥ�  @order �өw�q�Ӥ������u����
 * 
 * */

@Aspect
@Component
public class loggin {
	
	@Pointcut("execution(* spring.AOP.impl.calculatorImpl.*(..))")
	public void Pointcut() {}
	
	//�e�m�q��
	@Before("Pointcut()") 
	public void beforeMethod(JoinPoint joinPoint) { 
		String name=joinPoint.getSignature().getName(); 
		List<Object> list=Arrays.asList(joinPoint.getArgs());
		System.out.println("The method "+name+" begin with"+list); 
	} 
	//��m�q��
	@After("Pointcut()") 
	public void afterMethod(JoinPoint joinPoint) { 
		String name=joinPoint.getSignature().getName();
		System.out.println("The method "+name+" end "); 
	} 
	//��m�q��,�i�X�ݨ쵲�G
	@AfterReturning(value ="Pointcut()",
	returning = "result") 
	public void afterReturnMethod(JoinPoint joinPoint,Object result){ 
		String name=joinPoint.getSignature().getName();
		System.out.println("The method "+name+" end "+result); 
	} 
	//���`�q��,�i���w�S�w���`����q���N�X
	@AfterThrowing(value ="Pointcut()",
	throwing = "e") 
	public void afterThrowMethod(JoinPoint joinPoint,Exception e){ 
		String name=joinPoint.getSignature().getName();
		System.out.println("The method "+name+" end "+e); }
	//��¶�q��
	@Around("Pointcut()")
	public Object aroundMethod(ProceedingJoinPoint pjp) {
		Object result=null;
		String name = pjp.getSignature().getName();
		try {
			//�e�m�q�� @Before
			System.out.println("The method "+name+" begin with "+Arrays.asList(pjp.getArgs()));
			//����ؼФ�k
			result=pjp.proceed();
			//��^�q�� @AfterReturning
			System.out.println("The method "+name+" end with "+result);
		} catch (Throwable e) {
			//���`�q�� @AfterThrowing
			System.out.println("The method occurs exception :"+e);
		}
		return result;
	}
}
