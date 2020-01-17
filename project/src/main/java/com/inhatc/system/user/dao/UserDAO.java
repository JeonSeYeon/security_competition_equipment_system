package com.inhatc.system.user.dao;

import java.util.List;

import com.inhatc.system.user.vo.UserVO;

public interface UserDAO {

	public int login(UserVO uservo) throws Exception;

	/**
	 * INHATC System �α���
	 * 
	 * @param UserVO - �Խ���
	 * @return resultCode
	 * @throws Exception
	 */
	
	public UserVO loginInqr(UserVO uservo) throws Exception;

	 /**
    * INHATC System �α��ΰ��ɿ��� 
    * @param UserVO - �����
    * @return UserVO
    * @throws Exception 
    */
	
	public void join(UserVO uservo) throws Exception;

	 /**
     * INHATC System ȸ�� �߰�
     * @param UserVO - �����
     * @return resultCode
     * @throws Exception 
     */
	
	public List<UserVO> UserList(UserVO uservo) throws Exception;

	 /**
	 * INHATC System ȸ�� ���
	 * @param UserVO - �����
	 * @return List<UserVO>
	 * @throws Exception 
	 */
	
	public UserVO find_id(String id) throws Exception;

	 /**
	 * INHATC System id �˻�
	 * @param UserVO - �����
	 * @return UserVO
	 * @throws Exception 
	 */
	
	public void userModify(UserVO uservo) throws Exception;

	 /**
	 * INHATC System ȸ�� ���� ����
	 * @param UserVO - �����
	 * @return resultCode
	 * @throws Exception 
	 */
	
	public void userDelete(UserVO uservo) throws Exception;

	 /**
	 * INHATC System ȸ�� ���� ����
	 * @param UserVO - �����
	 * @return resultCode
	 * @throws Exception 
	 */
	
}
