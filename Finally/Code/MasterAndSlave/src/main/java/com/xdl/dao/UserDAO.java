package com.xdl.dao;

import java.util.List;

import com.xdl.entity.UserVo;

/**
 * dao�ӿ�
 * @author likang
 * @date   2017-10-25 ����8:07:10
 */
public interface UserDAO {

	/**
	 * ��ѯ---��
	 * @return
	 */
	public List<UserVo> findUsers();
	
	
	/**
	 * �����û�---д
	 * @param userVo
	 * @return
	 */
	public Integer addUser(UserVo userVo);
	
	
	
	
}
