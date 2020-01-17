package com.inhatc.system.board.service;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inhatc.system.board.dao.BoardDAO;
import com.inhatc.system.board.vo.BoardVO;
import com.inhatc.system.board.vo.Criteria;


@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO dao;

	/*�� ���*/
	@Override
	public void regist(BoardVO board, HttpSession ses) throws Exception {
		
		String resultWriter = "";

		resultWriter = (String) ses.getAttribute("LOGIN_NAME");

		board.setWriter(resultWriter);

		System.out.println("(Board_ServiceImpl) �ۼ��ڴ� : " + resultWriter);

		dao.create(board);
	}
	
	/*ó����� ��ư -> ó���� ��ư*/
	@Override
	public void updateIng(BoardVO board, HttpSession ses) throws Exception {
		
		String resultCompleteId = "";

		resultCompleteId = (String) ses.getAttribute("LOGIN_NAME");

		board.setCompleteId(resultCompleteId);

		System.out.println("(Board_ServiceImpl) ó���� ����� �̸���: " + resultCompleteId);

		dao.updateIng(board);
	}
	
	/*ó���� ��ư -> ó���Ϸ� ��ư*/
	@Override
	public void updateEnd(BoardVO board, HttpSession ses) throws Exception {
		
		String resultCompleteId = "";

		resultCompleteId = (String) ses.getAttribute("LOGIN_NAME");

		board.setCompleteId(resultCompleteId);

		System.out.println("(Board_ServiceImpl) ó������ ����� �̸���: " + resultCompleteId);

		dao.updateEnd(board);
	}
	
	/*�� ����*/
	@Override
	public BoardVO read(Integer bno) throws Exception {
		
		System.out.println("(Board_ServiceImpl) �� ����");
		
		return dao.read(bno);
	}

	/*�� ����*/
	@Override
	public void modify(BoardVO board, HttpSession ses) throws Exception {

		System.out.println("(Board_ServiceImpl) �� ����");

		dao.update(board);
	}
	
	/*�� ����*/
	@Override
	public void delete(Integer bno) throws Exception {
		
		System.out.println("(Board_ServiceImpl) �� ����");
		
		dao.delete(bno);
	}

	/*�� ���*/
	@Override
	public List<BoardVO> listAll(BoardVO board, Criteria cri, HttpSession ses) throws Exception {
		
		String sessionBelong = "";
		
		String resultWriter = "";
				
		if(ses.getAttribute("LOGIN_BELONG") != null) {
		sessionBelong = (String) ses.getAttribute("LOGIN_BELONG");

		cri.setManager_belong(sessionBelong);

		System.out.println("(Board_ServiceImpl) �α����� ������ classification�� : " + sessionBelong);

		}
		
		if(ses.getAttribute("LOGIN_NAME") != null){

		resultWriter = (String) ses.getAttribute("LOGIN_NAME");

		cri.setWriter(resultWriter);

		System.out.println("(Board_ServiceImpl) �ۼ��ڴ� : " + resultWriter);
		
		}else {
			
			cri.setManager_belong("all");
			cri.setWriter("�͸�");
		}
		return dao.listAll(cri);
	}

	/*�� ������ ����*/
	@Override
	public int listCountCriteria(Criteria cri, HttpSession ses) throws Exception {
		
		if(ses.getAttribute("LOGIN_BELONG") != null) {
		String sessionBelong = "";

		sessionBelong = (String) ses.getAttribute("LOGIN_BELONG");
		
		cri.setManager_belong(sessionBelong);
		}
		else {
			cri.setManager_belong("all");
		}
		return dao.countPaging(cri);
	}

	/*������ȣ �˻� ��ư*/
	@Override
	public BoardVO find_number(String client_number) throws Exception {
		
		System.out.println("(Board_ServiceImpl) ������ȣ ���� �˻�");
		
		return dao.find_number(client_number);
	}
	
	/*������ȣ ���� ������*/
	@Override
	public List<BoardVO> boardList(BoardVO vo, HttpSession ses) throws Exception {
		
		System.out.println("(Board_ServiceImpl) ������ȣ ���� ���� ������");
		
		return dao.BoardList(vo);
	}
	
	/*������ȣ ���� ����*/
	@Override
	public void managerModify(BoardVO board, HttpSession ses) throws Exception {

		System.out.println("(Board_ServiceImpl) ������ȣ ���� ����");

		dao.managerModify(board);
	}
	
	/*������ȣ ���� �߰�*/
	@Override
	public void managerInsert(BoardVO board, HttpSession ses) throws Exception {

		System.out.println("(Board_ServiceImpl) ������ȣ ���� �߰�");

		dao.managerInsert(board);
	}
	
	/*������ȣ ���� ����*/
	@Override
	public void managerDelete(BoardVO board) throws Exception {

		System.out.println("(Board_ServiceImpl) ������ȣ ���� ����");
		
		dao.managerDelete(board);
	}
	
	/*������ȣ ���*/
	@Override
	public List<BoardVO> informationList(BoardVO board, HttpSession ses) throws Exception {
		
		System.out.println("(Board_ServiceImpl) ������ȣ ���� ���");
		
		return dao.informationList(board);
	}
	
	/*�μ�*/
	@Override
	public List<BoardVO> listAll_p(BoardVO board,  HttpSession ses) throws Exception{
		
		System.out.println("(Board_ServiceImpl) ��� ���");
		
		return dao.listAll_p(board);
	}
	
}