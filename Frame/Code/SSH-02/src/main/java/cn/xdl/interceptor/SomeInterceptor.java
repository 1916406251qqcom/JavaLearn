package cn.xdl.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SomeInterceptor implements Interceptor{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	//���ָ����invoke()����������Stringֵ��Ч;δִ��invoke()������Stringֵ�������ӦResult����������
	public String intercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("��ʼ����������SomeInterceptor");
		
		invocation.invoke();//����Action+Result
		
		System.out.println("����������SomeInterceptor����");
		return null;
	}

}
