package com.xdl.service;

import java.util.List;

import com.xdl.entity.UserVo;
import com.xdl.util.DataSource;

public interface UserService {

	/**
	 * ��ѯ---��ҵ��----�ӷ�����
	 * @return
	 */
	@DataSource("slave")
	public List<UserVo> findUser();
	
	/**
	 * ����---д----�����������в���
	 * @param userVo
	 */
	public void addUser(UserVo userVo);
	
}
