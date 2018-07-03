package com.medic.dao;

import com.medic.pojo.User;

/**
 * �û��ӿ�
 * @author ����
 *
 */
public interface UserDao {
	/**
	 * ����½��Ϣ
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean checkUserLogin(String userName , String password);
	
	/**
	 * ע���û�
	 * @return
	 */
	public boolean addUser(User u);
	
	/**
	 * ɾ���û�
	 * @return
	 */
	public boolean deleteUser();
}
