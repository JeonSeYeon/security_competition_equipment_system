package com.inhatc.system.board.dao;

import java.util.List;
import com.inhatc.system.board.vo.BoardVO;
import com.inhatc.system.board.vo.Criteria;


public interface BoardDAO {
	
	public void create(BoardVO vo) throws Exception;
	
	/**
	 * INHATC System �� ���
	 * 
	 * @param BoardVO - �Խ���
	 * @return resultCode
	 * @throws Exception
	 */
	
	public void updateIng(BoardVO board) throws Exception;

	/**
	 * INHATC System ó����� ��ư -> ó���� ��ư
	 * 
	 * @param BoardVO - �Խ���
	 * @return resultCode
	 * @throws Exception
	 */

	public void updateEnd(BoardVO board) throws Exception;

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
	
	public void update(BoardVO vo) throws Exception;

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
	
	public List<BoardVO> listAll(Criteria cri) throws Exception;

	/**
	 * INHATC System �� ���
	 * 
	 * @param BoardVO - �Խ���
	 * @return List<BoardVO>
	 * @throws Exception
	 */
	
	public int countPaging(Criteria cri) throws Exception;

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
	
	public List<BoardVO> BoardList(BoardVO vo) throws Exception;

	/**
	 * INHATC System ������ȣ ���� ������
	 * 
	 * @param BoardVO - �Խ���
	 * @return List<BoardVO>
	 * @throws Exception
	 */
	
	public void managerModify(BoardVO vo) throws Exception;

	/**
	 * INHATC System ������ȣ ���� ����
	 * 
	 * @param BoardVO - �Խ���
	 * @return resultCode
	 * @throws Exception
	 */
	
	public void managerInsert(BoardVO boardvo) throws Exception;

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
	
	public List<BoardVO> informationList(BoardVO board) throws Exception;

	/**
	 * INHATC System ������ȣ ���
	 * 
	 * @param BoardVO - �Խ���
	 * @return List<BoardVO>
	 * @throws Exception
	 */
	
	public List<BoardVO> listAll_p(BoardVO board) throws Exception;
	
	/**
	 * INHATC System �μ�
	 * 
	 * @param BoardVO - �Խ���
	 * @return List<BoardVO>
	 * @throws Exception
	 */
	
}