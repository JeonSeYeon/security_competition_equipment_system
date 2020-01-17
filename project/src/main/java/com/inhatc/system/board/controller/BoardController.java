package com.inhatc.system.board.controller;

import java.io.PrintWriter;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.inhatc.system.board.service.BoardService;
import com.inhatc.system.board.vo.BoardVO;
import com.inhatc.system.board.vo.Criteria;
import com.inhatc.system.board.vo.PageMaker;

@Controller
public class BoardController {

	 public String toFilterString(String in){
		  if(in == null || in.length() < 1){
		   return in;
		  }
		  StringBuffer out = new StringBuffer();
		  
		  for(int i = 0; in != null && i < in.length(); i++){
		   char c = in.charAt(i);
		   if(c == '\''){
		    out.append(" ");
		   } else if(c == '\"'){
		    out.append(" ");
		   } else if(c == '<'){
		    out.append(" ");
		   } else if(c == '>'){
		    out.append(" ");
		   } else if(c == '&'){
		    out.append(" ");
		   } else if(c == '('){
		    out.append(" ");
		   } else if(c == ')'){
		    out.append(" ");
		   } else {
		    out.append(c);
		   }
		  }
		  return out.toString();
		 }

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService service;

	/* board main GET */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHome(@ModelAttribute("cri") Criteria cri, BoardVO vo, Locale locale, Model model, HttpSession ses)
			throws Exception {

		logger.info("ȯ���մϴ�. IT������������ & PC������ ���� ���α׷��Դϴ�.");
		logger.info("���� �������� �������� �ִ� ���� ������ " + cri.toString());

		model.addAttribute("boardList", service.listAll(vo, cri, ses));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listCountCriteria(cri, ses));

		model.addAttribute("pageMaker", pageMaker);

		return "board/board";
	}
	
	/* board main POST */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String postHome(@ModelAttribute("cri") Criteria cri, BoardVO vo, Locale locale, Model model, HttpSession ses)
			throws Exception {
		logger.info("ȯ���մϴ�. IT������������ & PC������ ���� ���α׷��Դϴ�.");
		logger.info("���� �������� �������� �ִ� ���� ������ " + cri.toString());

		model.addAttribute("boardList", service.listAll(vo, cri, ses));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		pageMaker.setTotalCount(service.listCountCriteria(cri, ses));

		model.addAttribute("pageMaker", pageMaker);

		return "board/board";
	}

	/*go to URL, board write */
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String write(BoardVO board) throws Exception {

		logger.info("(BoardControllor) �� �ۼ� GET���");
		logger.info("(BoardControllor) �� �ۼ� ������ " + board.toString());

		return "board/write";
	}

	/* board register */
	@RequestMapping(value = "/board/register", method = RequestMethod.POST)
	public void registerPOST(BoardVO board, HttpSession ses, HttpServletResponse response) throws Exception {
		logger.info("(BoardControllor) �� ��� POST���");
		logger.info(board.toString());
		System.out.println("(BoardControllor) ��ȭ��ȣ�� : " + board.getClient_number()); // ��ȭ��ȣ
		System.out.println("(BoardControllor) �Ҽ��� : " + board.getClient_belong()); // �Ƿ��� �Ҽ�
		System.out.println("(BoardControllor) �̸��� : " + board.getClient_name()); // �Ƿ��� �̸�
		System.out.println("(BoardControllor) ���Ҽ��� : " + board.getManager_belong()); // �۾� �з�

		service.regist(board, ses);

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('����� �Ϸ�Ǿ����ϴ�.'); window.opener.location.reload(); window.close();</script>");
		out.flush();
	}

	/*change updateStart -> updateIng*/
	@RequestMapping(value = "/board/updateIng", method = RequestMethod.POST)
	public void updateIng(BoardVO board, RedirectAttributes rttr, HttpSession ses, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		service.updateIng(board, ses);

		rttr.addFlashAttribute("msg", "success");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('ó���� ��û�Ǿ����ϴ�.'); window.opener.location.reload(); window.close();</script>");
		out.flush();

	}

	/*change updateIng -> updateEnd*/
	@RequestMapping(value = "/board/updateEnd", method = RequestMethod.POST)
	public void updateEnd(BoardVO board, RedirectAttributes rttr, HttpSession ses, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		service.updateEnd(board, ses);

		rttr.addFlashAttribute("msg", "success");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<script>alert('ó���� �Ϸ�Ǿ����ϴ�.'); window.opener.location.reload(); window.close();</script>");
		out.flush();
	}

	/* board read */
	@RequestMapping(value = "/board/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {

		model.addAttribute(service.read(bno));
	}

	/* board delete */
	@RequestMapping(value = "/board/delete", method = RequestMethod.POST)
	public void delete(@RequestParam("bno") int bno, RedirectAttributes rttr, HttpServletResponse response)
			throws Exception {

		service.delete(bno);

		rttr.addFlashAttribute("msg", "success");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script> alert('������ �Ϸ�Ǿ����ϴ�.'); window.opener.location.reload(); window.close();</script>");
		out.flush();

	}

	/* board modify */
	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)
	public void modifyActionPOST(BoardVO board, HttpSession ses, HttpServletResponse response) throws Exception {
		logger.info("(BoardControllor) �� ���� POST���");
		logger.info(board.toString());
		System.out.println("(BoardControllor) ������ȣ�� : " + board.getClient_number());
		System.out.println("(BoardControllor) �Ҽ��� : " + board.getClient_belong());
		System.out.println("(BoardControllor) �̸��� : " + board.getClient_name());
		System.out.println("(BoardControllor) ���Ҽ��� : " + board.getManager_belong());
		System.out.println("(BoardControllor) �۾��з��� : " + board.getManager_classification());
		System.out.println("(BoardControllor) ��ġ�� : " + board.getClient_local());
		System.out.println("(BoardControllor) ��������� : " + board.getInstrument());
		System.out.println("(BoardControllor) �ۼ��ڴ� : " + board.getWriter());
		System.out.println("(BoardControllor) ������ : " + board.getContent());

		service.modify(board, ses);

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('������ �Ϸ�Ǿ����ϴ�.'); window.opener.location.reload(); window.close();</script>");
		out.flush();

	}
	
	/*When board write, bring the information of school phone number*/
	@ResponseBody
	@RequestMapping(value = "/board/information", method = RequestMethod.POST)
	public BoardVO information(String client_number, Model model) throws Exception {

		logger.info("(BoardControllor) information���̺��� ��ȭ��ȣ�� ������." + client_number);
		BoardVO result = service.find_number(client_number);
		
		      
				return result;
		        
		    }

	
	
	/*manage to information  of school phone number*/ 
	@RequestMapping(value = "/managerAction", method = RequestMethod.GET)
	public String managerGET(BoardVO board, HttpSession ses, Model model) throws Exception {

		logger.info("���ϰ����������� �а�(�к�) ��ȭ��ȣ ���� �������� �̵��մϴ�.");
		logger.info("(BoardControllor) ��ȭ��ȣ ���� POST���");
		logger.info("(BoardControllor)  ������ " + board.toString());

		model.addAttribute("boadList", service.boardList(board, ses));
		
		return "board/manager";
	}

	/* update to information of school phone number */
	@RequestMapping(value = "/managerModify", method = RequestMethod.POST)
	public void managerModifyPOST(BoardVO board, HttpSession ses, HttpServletResponse response) throws Exception {
		logger.info("(BoardControllor) ������ȣ ���� ���� POST���");
		logger.info(board.toString());
		System.out.println("(BoardControllor) ������ȣ�� : " + board.getClient_number());
		System.out.println("(BoardControllor) �Ҽ��� : " + board.getClient_belong());
		System.out.println("(BoardControllor) �̸��� : " + board.getClient_name());
		System.out.println("(BoardControllor) ��ġ�� : " + board.getClient_local());

		service.managerModify(board, ses);

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('������ �Ϸ�Ǿ����ϴ�.'); window.opener.location.reload(); window.close();</script>");
		out.flush();
	}

	/* insert to information of school phone number */
	@RequestMapping(value = "/managerInsert", method = RequestMethod.POST)
	public void managerInsertPOST(BoardVO board, HttpSession ses, HttpServletResponse response) throws Exception {
		logger.info("(BoardControllor) ������ȣ ���� �߰� POST���");
		logger.info(board.toString());
		System.out.println("(BoardControllor) ��ȭ��ȣ�� : " + board.getClient_number()); // ��ȭ��ȣ
		System.out.println("(BoardControllor) �Ҽ��� : " + board.getClient_belong()); // �Ƿ��� �Ҽ�
		System.out.println("(BoardControllor) �̸��� : " + board.getClient_name()); // �Ƿ��� �̸�
		System.out.println("(BoardControllor) ��ġ�� : " + board.getClient_local()); // �۾� �з�

		service.managerInsert(board, ses);

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('����� �Ϸ�Ǿ����ϴ�.'); window.opener.location.reload(); window.close();</script>");
		out.flush();

	}

	/* delete to information of school phone number */
	@RequestMapping(value = "/managerDelete", method = RequestMethod.POST)
	public void managerDeletePOST(BoardVO board, HttpServletResponse response) throws Exception {

		logger.info("(BoardControllor) ������ȣ ���� ���� POST���");
		logger.info(board.toString());
		System.out.println("(BoardControllor) ��ȭ��ȣ�� : " + board.getClient_number()); // ��ȭ��ȣ
		System.out.println("(BoardControllor) �Ҽ��� : " + board.getClient_belong()); // �Ƿ��� �Ҽ�
		System.out.println("(BoardControllor) �̸��� : " + board.getClient_name()); // �Ƿ��� �̸�
		System.out.println("(BoardControllor) ��ġ�� : " + board.getClient_local()); // �۾� �з�

		service.managerDelete(board);

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('������ �Ϸ�Ǿ����ϴ�.'); window.opener.location.reload(); window.close();</script>");
		out.flush();
	}

	/* show information of school phone number */
	@RequestMapping(value = "/showInformation", method = RequestMethod.POST)
	public String ShowInformation(BoardVO board, HttpSession ses, Model model) throws Exception {

		logger.info("���� ������ȣ ���� ����Ʈ �������Դϴ�..");
		model.addAttribute("informationList", service.informationList(board, ses));

		return "board/showInformation";
	}
	
	
	
	@RequestMapping(value = "/board/print", method = RequestMethod.POST)
	public String print(BoardVO board, HttpSession ses, Model model) throws Exception {

		logger.info("�μ�κ� �������Դϴ�.");
		model.addAttribute("boardList", service.listAll_p(board, ses));


		return "board/print_page";
	}
	
	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public String printGET(BoardVO board, HttpSession ses, Model model) throws Exception {

		logger.info("�μ�");
		logger.info("(BoardControllor) �μ� GET���");
		logger.info("(BoardControllor)  ������ " + board.toString());

		
		return "/board/print_page";
	}
	
	@ExceptionHandler(RuntimeException.class)

	public String exceptionHandler(Model model, Exception e){

	logger.info("exception : " + e.getMessage());

	model.addAttribute("exception", e);

	return "board/error";

	}
}



