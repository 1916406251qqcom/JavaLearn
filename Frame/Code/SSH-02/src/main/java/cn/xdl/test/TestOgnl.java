package cn.xdl.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.xdl.entity.Dept;
import ognl.Ognl;
import ognl.OgnlException;

public class TestOgnl {
	
	
	
	@Test
	public void test1() throws OgnlException{
//		Ognl.setValue(expression, root, value);//��root��������ֵ
//		Ognl.getValue(expression, root);//��root������ȡֵ
		
		Object dept = new Dept();
		Ognl.setValue("dname", dept, "Java����");
		Ognl.setValue("deptno", dept, 10);
		Ognl.setValue("loc", dept, "����");
		
		System.out.println(dept);
	}
	
	@Test
	public void test2() throws OgnlException{	
		Dept dept = new Dept();
		dept.setDeptno(20);
		dept.setDname("PHP");
		dept.setLoc("�Ϻ�");
		//ȡֵ
		Object deptno = Ognl.getValue("deptno", dept);
		System.out.println(deptno);
		Object dname = Ognl.getValue("dname", dept);
		System.out.println(dname);
		Object loc = Ognl.getValue("loc", dept);
		System.out.println(loc);
	}
	
	@Test
	public void test3() throws OgnlException{	
		Map<String, Object> context = new HashMap<String, Object>();
		context.put("dname", "����");
		context.put("age", 20);
		
		Dept dept = new Dept();
		dept.setDname("JAVA");
		
		//ȡֵ
		Object name = Ognl.getValue("dname", context, dept);
		System.out.println(name);
	}
	
}
