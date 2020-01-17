package com.inhatc.system.user.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.inhatc.system.user.dao.UserDAO;
import com.inhatc.system.user.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	/*�α���*/
	@Override
	public int login(UserVO uservo) throws Exception {
		
	
		int resultCode = 0;
		
	
		  
		 for(int i=0; i<10; i++) {    //�ݺ��� �����õ� ���� ���
			 
			 resultCode = userDAO.login(uservo);
		
		 }
		
		
		return resultCode;
	}

	/*�α��ΰ��ɿ���*/
	public UserVO loginInqr(UserVO uservo, HttpSession ses) throws Exception {
				
		UserVO loginModel = userDAO.loginInqr(uservo); // db ���� ����Ʈ �ؿ� ������ -> ��oginModel 

		if (loginModel != null) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  

			
			uservo.setLoginType("Y");
			
			ses.setAttribute("LOGIN_ID", loginModel.getId()); 
			ses.setAttribute("LOGIN_PW", loginModel.getPw()); 
			ses.setAttribute("LOGIN_NAME", loginModel.getManager_name()); 
			ses.setAttribute("LOGIN_BELONG", loginModel.getManager_belong());
			ses.setMaxInactiveInterval(60*60*60) ;
			
			System.out.println("(UserServiceImpl) �ٷ��л��� �ҼӺз��� " + loginModel.getManager_belong());
			System.out.println("(UserServiceImpl) �ٷ��л��� �̸��� " + loginModel.getManager_name());

		} else {
			
			uservo.setLoginType("N");
		}

		return uservo;

	}
	
	/*ȸ�� ���*/
	@Override
	public List<UserVO> UserList(UserVO uservo, HttpSession ses) throws Exception {
		
		return userDAO.UserList(uservo);
	}
	
	/*id �˻�*/
	@Override
	public UserVO find_id(String id) throws Exception {
		
		return userDAO.find_id(id);
	}
	
	   
	/*ȸ�� �߰�*/
   @Override
	public void join(UserVO uservo, HttpSession ses) throws Exception{
		
		System.out.println("(User_ServiceImpl) ȸ�� ���� �߰�");
		
		 String encPassword = passEncoder.encode(uservo.getPw());
		 uservo.setPw(encPassword);
		  
		 
		userDAO.join(uservo);
	}
	
	/*ȸ�� ���� ����*/
	@Override
	public void userModify(UserVO uservo, HttpSession ses) throws Exception {

		System.out.println("(User_ServiceImpl) ȸ�� ���� ����");

		userDAO.userModify(uservo);
	}
	
	/*ȸ�� ���� ����*/
	@Override
	public void userDelete(UserVO uservo) throws Exception {

		System.out.println("(User_ServiceImpl) ������ȣ ���� ����");
		
		userDAO.userDelete(uservo);
	}
	
}
