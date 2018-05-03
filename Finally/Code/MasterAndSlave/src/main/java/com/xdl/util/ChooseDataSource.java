package com.xdl.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * ��̬��ȡ����Դ
 * @author likang
 */
public class ChooseDataSource extends AbstractRoutingDataSource{

	/**
	 * ��ȡ������Դ��ص�keyֵ����ֵ��Map<String,DataSource> ��������Դ�󶨵�keyֵ
	 * ͨ��determineTargetDataSource ��ȡĿ������Դʹ��
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		return HandleDataSource.getDataSource();
	}

}
