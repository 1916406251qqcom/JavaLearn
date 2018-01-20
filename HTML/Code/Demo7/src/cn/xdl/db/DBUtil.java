package cn.xdl.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * ���ݿ�����ӳع���!
 */
public class DBUtil {

	/**
	 * ���ӳ�
	 */
	private static DataSource source;

	static {
		InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("dbcp.properties");
		Properties ppt = new Properties();
		try {
			ppt.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
		source = BasicDataSourceFactory.createDataSource(ppt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * ͨ�����ݿ�����ӳ� ,�õ�һ�����ݿ�����Ӷ���<br>
	 * �ڵ���ʱ, �п��ܴ���һЩ�쳣<b>SQLException</b><br>
	 * �������쳣ʱ, �᷵��null ,������ִ���� , ����properties�ļ��Ƿ���� �� �����Ƿ���ȷ
	 * @return ���Ӷ��� or null
	 */
	public static Connection getConnection() {
		try {
			return source.getConnection();
		} catch (SQLException e) {
			return null;
		}
	}
	/**
	 * �����ͷ���Դ�����ķ���
	 * @param conn  ���ݿ����Ӷ���
	 * @param state ���ݿ�ִ�л���
	 * @param result ���������
	 */
	public static void close(Connection conn,Statement state,ResultSet result) throws SQLException {
		if(result!=null) {
			result.close();
			result=null;
		}
		if(state!=null) {
			state.close();
			state=null;
		}
		if(conn!=null) {
			conn.close();
			conn=null;
		}
		
		
		
		
			
	}
	
	
	
}
