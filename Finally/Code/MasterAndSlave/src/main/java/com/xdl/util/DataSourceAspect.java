package com.xdl.util;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * ����ӳ��
 * @author likang
 */
public class DataSourceAspect {

	public void before(JoinPoint point){
		Object target = point.getTarget();//���ص�ʵ�������
		String method = point.getSignature().getName();//���صķ�������
		Class<?>[] classz = target.getClass().getInterfaces();
		//���ط�����������
		Class<?>[] parameterTypes = ((MethodSignature)point.getSignature()).getMethod().getParameterTypes();
		
		try {
			Method m = classz[0].getMethod(method, parameterTypes);
			if (m != null && m.isAnnotationPresent(DataSource.class)) {
				DataSource data = m.getAnnotation(DataSource.class);
				System.out.println("��ǰ�û�ѡ�����ݿ�����Ϊ��"+data.value());
				HandleDataSource.putDataSource(data.value());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
