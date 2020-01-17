package com.inhatc.system.user.service;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.transaction.annotation.Transactional;
import com.inhatc.system.user.vo.UserVO;



@Transactional
public interface UserService {
 
	
	public int login(UserVO uservo)throws Exception;

    /**
     * INHATC System �α���
     * @param UserVO - �����
     * @return resultCode
     * @throws Exception 
     */
	
	public UserVO loginInqr(UserVO uservo, HttpSession ses)throws Exception;
	
	 /**
     * INHATC System �α��ΰ��ɿ��� 
     * @param UserVO - �����
     * @return UserVO
     * @throws Exception 
     */
	
	public void join(UserVO uservo, HttpSession ses) throws Exception;

	 /**
    * INHATC System ȸ�� �߰�
    * @param UserVO - �����
    * @return resultCode
    * @throws Exception 
    */
	
	public List<UserVO> UserList(UserVO uservo, HttpSession ses) throws Exception;

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
	
	public void userModify(UserVO uservo, HttpSession ses) throws Exception;

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
