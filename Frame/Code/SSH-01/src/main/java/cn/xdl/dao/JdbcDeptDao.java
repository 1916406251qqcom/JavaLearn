package cn.xdl.dao;

import java.util.ArrayList;
import java.util.List;

import cn.xdl.entity.Dept;

public class JdbcDeptDao implements DeptDao {

	public List<Dept> loadAll() {
		List<Dept> list = new ArrayList<Dept>();
		Dept dept = new Dept();
		dept.setDeptno(10);
		dept.setDname("Java");
		dept.setLoc("����");
		list.add(dept);
		
		Dept dept1 = new Dept();
		dept1.setDeptno(20);
		dept1.setDname("PHP");
		dept1.setLoc("����");
		list.add(dept1);
		
		Dept dept2 = new Dept();
		dept2.setDeptno(30);
		dept2.setDname("Python");
		dept2.setLoc("����");
		list.add(dept2);
		return list;
	}

}
