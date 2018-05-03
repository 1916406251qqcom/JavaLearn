package com.xdl.util;

public class HandleDataSource {
	
	
	public static final ThreadLocal<String> holder = new ThreadLocal<String>();
	
	
	/**
	 * �󶨵�ǰ�̵߳�����Դ
	 */
	public static void putDataSource(String datasource){
		holder.set(datasource);
	}
	
	/**
	 * ��ȡ��ǰ�̵߳�����Դ
	 */
	public static String getDataSource(){
		return holder.get();
	}

}
