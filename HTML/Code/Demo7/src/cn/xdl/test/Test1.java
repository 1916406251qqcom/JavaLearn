package cn.xdl.test;


import java.sql.Connection;
import java.sql.Statement;

import org.junit.Test;

import cn.xdl.db.DBUtil;

public class Test1 {

	@Test
	public void test1() throws Exception {
		Connection conn = DBUtil.getConnection();
		Statement state = conn.createStatement();
		int count = state.executeUpdate("insert into book16 values(20,'�߷���һ���������޵�������','riyuqiannv ,hahahahahhahahahhahahahahahahhahahahahahahah',18888)");
		if(count>0) {
			System.out.println("���� �ɹ�");
		}else {
			System.out.println("���� ʧ��, ����BUG��, �ٲ���");
			
		}
	}
}
