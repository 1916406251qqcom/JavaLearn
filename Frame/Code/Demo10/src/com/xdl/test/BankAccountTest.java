package com.xdl.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.xdl.bean.BankAccount;

public class BankAccountTest {

	public static void main(String[] args) {
		// ��ȡSqlSession
		SqlSessionFactoryBuilder  ssfb = new SqlSessionFactoryBuilder();
		InputStream  inputStream = BankAccountTest.class.getClassLoader()
			.getResourceAsStream("sqlmap-config.xml");
		SqlSessionFactory ssf = ssfb.build(inputStream);
        SqlSession  sqlSession = ssf.openSession();
        // ����sql�����ļ��е�id ��ѯ 
        int  count = sqlSession.selectOne("bankAccountCount");
        System.out.println("count = "+ count);
        String  aname = sqlSession.selectOne("bankAccountName", "0002");
        System.out.println("aname = " +aname);
        // �����˺�  ��ѯһ���˻���Ϣ 
        BankAccount  account = sqlSession.selectOne("bankAccountByAno", "0002");
        System.out.println("account:"+account);
        // ��ѯ���е������˻� 
        List<BankAccount>  datas = sqlSession.selectList("bankAccountList");
        System.out.println("datas="+datas);
        // ɾ�������˻�  ���������˺� 
        int rows = sqlSession.delete("bankAccountDeteleByAno", "0002");
        System.out.println("rows = " +rows);
        sqlSession.commit();
        sqlSession.close();
	}

}
