package com.inhatc.system.user.controller;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.inhatc.system.user.service.UserService;
import com.inhatc.system.user.vo.UserVO;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService service;

	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	/*go to the login*/
	@RequestMapping(value = "/loginHome", method = RequestMethod.GET)
	public String loginHome(UserVO uservo) throws Exception {
		
		logger.info("�α���ȭ���Դϴ�. IT������������ & PC������ ���� ���α׷��Դϴ�.");
		return "user/login";
	}

	/*click the login button*/
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginInqr(@ModelAttribute("uservo") UserVO uservo, HttpSession ses, ModelMap model) throws Exception {

		String resultCode = "";

		logger.info("(UserControllor) �α����� ����� ���̵�� " + uservo.getId());
		logger.info("(UserControllor) �α����� ����� ��й�ȣ�� " + uservo.getPw());

		UserVO loginModel = service.loginInqr(uservo, ses);
		
			logger.info("(UserControllor) �α����� ����� �̸��� " + loginModel.getManager_name());

			resultCode = loginModel.getLoginType();
		
		return resultCode;
	}

	/*click the logout button*/
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(HttpSession ses, HttpServletResponse response) throws Exception {
		
		logger.info("�����մϴ�. �α׾ƿ��� ���������� �Ͽ����ϴ�.");
		ses.invalidate();
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('���������� �α׾ƿ� �Ǿ����ϴ�.'); window.opener.location.reload();</script>");  
        out.println("<script>location.href = '/'</script>");
        out.flush();
	}
	
	/*go to the join*/
	@RequestMapping(value = "/joinAction", method = RequestMethod.GET)
	public String joinGET(UserVO uservo) throws Exception {
		
		logger.info("ȸ������ �Է� �������� �̵��մϴ�.");
		logger.info("(UserControllor) ȸ����� GET���");
		logger.info("(UserControllor)  ������ " + uservo.toString());
		
		return "user/join";
	}
	
	/* show member list */
	@RequestMapping(value = "/showUser", method = RequestMethod.POST)
	public String ShowLogin(UserVO uservo, HttpSession ses, Model model) throws Exception {

		logger.info("ȸ������ ����Ʈ �������Դϴ�..");
		model.addAttribute("UserList", service.UserList(uservo, ses));
		
		return "user/showUser";
	}

	/*search the id*/
	@ResponseBody
	@RequestMapping(value = "/user/list", method = RequestMethod.POST)
	public UserVO userList(String id, Model model) throws Exception {
	
			
		logger.info("(UserControllor) user���̺��� ���̵� ������." + id);

		UserVO result = service.find_id(id);
		

	     return result;
		
	}
	
	/* insert the member */
	@RequestMapping(value = "/userInsert", method = RequestMethod.POST)
	public void userInsertPOST(UserVO uservo, HttpSession ses,  HttpServletResponse response) throws Exception {
		logger.info("(UserControllor) ȸ����� POST���");
		logger.info(uservo.toString());
		System.out.println("(UserControllor) �̸��� : " + uservo.getManager_name()); // ��ȭ��ȣ
		System.out.println("(UserControllor) �Ҽ��� : " + uservo.getManager_belong()); //�Ƿ��� �Ҽ�
		System.out.println("(UserControllor) ���̵�� : " + uservo.getId()); // �Ƿ��� �̸�
		System.out.println("(UserControllor) ��й�ȣ�� : " + uservo.getPw()); // �۾� �з�
	
		
		service.join(uservo, ses);
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('����� �Ϸ�Ǿ����ϴ�.'); window.opener.location.reload(); window.close();</script>");  
        out.flush();

	}
	
	/* update the member */
	@RequestMapping(value = "/userModify", method = RequestMethod.POST)
	public void userModifyPOST(UserVO uservo, HttpSession ses ,HttpServletResponse response) throws Exception {
		logger.info("(UserControllor) ȸ������ POST���");
		logger.info(uservo.toString());
		System.out.println("(UserControllor) �̸��� : " + uservo.getManager_name()); // ��ȭ��ȣ
		System.out.println("(UserControllor) �Ҽ��� : " + uservo.getManager_belong()); //�Ƿ��� �Ҽ�
		System.out.println("(UserControllor) ���̵�� : " + uservo.getId());
		System.out.println("(UserControllor) ��й�ȣ�� : " + uservo.getPw()); // �۾� �з�
	
		service.userModify(uservo, ses);
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('������ �Ϸ�Ǿ����ϴ�.'); window.opener.location.reload(); window.close();</script>");        
        out.flush();
	}
	
	/* delete the member */
	@RequestMapping(value = "/userDelete", method = RequestMethod.POST)
	public void userDeletePOST(UserVO uservo, HttpServletResponse response) throws Exception {
		
		logger.info("(UserControllor) ȸ�� ���� ���� POST���");
		logger.info(uservo.toString());
		System.out.println("(UserControllor) �̸��� : " + uservo.getManager_name()); // ��ȭ��ȣ
		System.out.println("(UserControllor) �Ҽ��� : " + uservo.getManager_belong()); //�Ƿ��� �Ҽ�
		System.out.println("(UserControllor) ���̵�� : " + uservo.getId());
		System.out.println("(UserControllor) ��й�ȣ�� : " + uservo.getPw()); // �۾� �з�
		
		service.userDelete(uservo);

		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('������ �Ϸ�Ǿ����ϴ�.'); window.opener.location.reload(); window.close();</script>");  
        out.flush();
	}
	
}
