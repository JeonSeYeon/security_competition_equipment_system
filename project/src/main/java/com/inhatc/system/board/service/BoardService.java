package com.inhatc.system.board.service;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.transaction.annotation.Transactional;
import com.inhatc.system.board.vo.BoardVO;
import com.inhatc.system.board.vo.Criteria;

@Transactional
public interface BoardService {

	public void regist(BoardVO board, HttpSession ses) throws Exception;

	/**
	 * INHATC System �� ���
	 * 
	 * @param BoardVO - �Խ���
	 * @return resultCode
	 * @throws Exception
	 */

	public void updateIng(BoardVO board, HttpSession ses) throws Exception;

	/**
	 * INHATC System ó����� ��ư -> ó���� ��ư
	 * 
	 * @param BoardVO - �Խ���
	 * @return resultCode
	 * @throws Exception
	 */

	public void updateEnd(BoardVO board, HttpSession ses) throws Exception;
	
	/**
	 * INHATC System ó���� ��ư -> ó���Ϸ� ��ư
	 * 
	 * @param BoardVO - �Խ���
	 * @return resultCode
	 * @throws Exception
	 */
	
	public BoardVO read(Integer bno) throws Exception;

	/**
	 * INHATC System �� ����
	 * 
	 * @param BoardVO - �Խ���
	 * @return BoardVO
	 * @throws Exception
	 */
	
	public void modify(BoardVO board, HttpSession ses) throws Exception;

	/**
	 * INHATC System �� ����
	 * 
	 * @param BoardVO - �Խ���
	 * @return resultCode
	 * @throws Exception
	 */
	
	public void delete(Integer bno) throws Exception;

	/**
	 * INHATC System �� ����
	 * 
	 * @param BoardVO - �Խ���
	 * @return resultCode
	 * @throws Exception
	 */
	
	public List<BoardVO> listAll(BoardVO board, Criteria cri, HttpSession ses) throws Exception;
	
	/**
	 * INHATC System �� ���
	 * 
	 * @param BoardVO - �Խ���
	 * @return List<BoardVO>
	 * @throws Exception
	 */
	
	public int listCountCriteria(Criteria cri, HttpSession ses) throws Exception;

	/**
	 * INHATC System �� ������ ����
	 * 
	 * @param BoardVO - �Խ���
	 * @return resultCode
	 * @throws Exception
	 */
	
	public BoardVO find_number(String client_number) throws Exception;

	/**
	 * INHATC System ������ȣ �˻� ��ư
	 * 
	 * @param BoardVO - �Խ���
	 * @return BoardVO
	 * @throws Exception
	 */
	
	public List<BoardVO> boardList(BoardVO vo, HttpSession ses) throws Exception;

	/**
	 * INHATC System ������ȣ ���� ������
	 * 
	 * @param BoardVO - �Խ���
	 * @return List<BoardVO>
	 * @throws Exception
	 */
	
	public void managerModify(BoardVO board, HttpSession ses) throws Exception;

	/**
	 * INHATC System ������ȣ ���� ����
	 * 
	 * @param BoardVO - �Խ���
	 * @return resultCode
	 * @throws Exception
	 */
	
	public void managerInsert(BoardVO board, HttpSession ses) throws Exception;

	/**
	 * INHATC System ������ȣ ���� �߰�
	 * 
	 * @param BoardVO - �Խ���
	 * @return resultCode
	 * @throws Exception
	 */
	
	public void managerDelete(BoardVO board) throws Exception;

	/**
	 * INHATC System ������ȣ ���� ����
	 * 
	 * @param BoardVO - �Խ���
	 * @return resultCode
	 * @throws Exception
	 */
	
	public List<BoardVO> informationList(BoardVO board, HttpSession ses) throws Exception;

	/**
	 * INHATC System ������ȣ ���
	 * 
	 * @param BoardVO - �Խ���
	 * @return List<BoardVO>
	 * @throws Exception
	 */
	
	public List<BoardVO> listAll_p(BoardVO board, HttpSession ses) throws Exception;
	
	/**
	 * INHATC System �� ��� ���
	 * 
	 * @param BoardVO - �Խ���
	 * @return List<BoardVO>
	 * @throws Exception
	 */
}