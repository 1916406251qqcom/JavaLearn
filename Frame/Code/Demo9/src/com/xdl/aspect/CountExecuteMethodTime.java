package com.xdl.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class CountExecuteMethodTime {
    /** ͳ��ҵ�񷽷�ִ�е�ʱ�� 
     * @throws Throwable */
	@Around("execution(* login())")
	public   Object  around(ProceedingJoinPoint  pjp) throws Throwable{
		long  start = System.currentTimeMillis();
		Object   obj = pjp.proceed();
		long  end  = System.currentTimeMillis();
		System.out.println("����:" + pjp.getSignature().getName() 
			+ ":ִ��ʱ��:" + (end-start) + "����"  );
		return  obj;
	}
}
