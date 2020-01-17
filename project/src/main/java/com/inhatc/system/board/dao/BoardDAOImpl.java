package com.inhatc.system.board.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.inhatc.system.board.vo.BoardVO;
import com.inhatc.system.board.vo.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSession session;
	
	private static String namespace="com.inhatc.mapper.BoardMapper";
	
	/*�� ���*/
	@Override
	public void create(BoardVO boardvo) throws Exception{
		
		System.out.println("(Baord_DAOImpl)���� �۾��� ���� ��");
		
		session.insert("com.inhatc.mapper.BoardMapper.create",boardvo);
	}

	/*�� ����*/
	@Override
	public BoardVO read(Integer bno) throws Exception{
		
		System.out.println("(Baord_DAOImpl)���� ���б� ���� ��");
		
		return session.selectOne(namespace + ".read", bno);
	}
	
	/*ó����� ��ư -> ó���� ��ư*/
	@Override
	public void updateIng(BoardVO board) throws Exception{
		
		System.out.println("(Baord_DAOImpl)���� ó����Ȳ�� �˷���, ó����");
		
		session.update(namespace + ".updateIng", board);
	}
	
	/*ó���� ��ư -> ó���Ϸ� ��ư*/
	@Override
	public void updateEnd(BoardVO board) throws Exception{
		
		System.out.println("(Baord_DAOImpl)���� ó����Ȳ�� �˷���, ó���Ϸ�");
		
		session.update(namespace + ".updateEnd", board);
	}
	
	/*�� ����*/
	@Override
	public void update(BoardVO vo) throws Exception{
		
		System.out.println("(Baord_DAOImpl)���� �� ����");
		
		session.update(namespace + ".update", vo);
	}

	/*�� ����*/
	@Override
	public void delete(Integer bno) throws Exception{
		
		System.out.println("(Baord_DAOImpl)���� �� ���� ���� ��");
		session.delete(namespace + ".delete", bno);
	}
	
	/*�� ���*/
	@Override
	public List<BoardVO> listAll(Criteria cri) throws Exception{
		
		System.out.println("(Baord_DAOImpl)���� �� ��� �ҷ�����");
		
		return session.selectList(namespace + ".listAll", cri);
	}
	/*List<BoardVO>: �迭*/
	
	/*�� ������ ����*/
	@Override
	public int countPaging(Criteria cri) throws Exception{
		
		return session.selectOne(namespace +".countPaging", cri);
	}
	
	/*������ȣ �˻� ��ư*/
	@Override
	public BoardVO find_number(String client_number) throws Exception{
		
		return session.selectOne(namespace + ".find_number", client_number);
	}
	
	/*������ȣ ���� ������*/
	@Override
	public List<BoardVO> BoardList(BoardVO vo) throws Exception{
		
		System.out.println("(Baord_DAOImpl)���� ��ȭ��ȣ ��� �ҷ�����");
		
		return session.selectList(namespace + ".BoardList", vo);
	}

	/*������ȣ ���� ����*/
	@Override
	public void managerModify(BoardVO vo) throws Exception{
		
		System.out.println("(Baord_DAOImpl)���� ������ȣ ���� ����");
		
		session.update(namespace + ".managerUpdate", vo);
	}

	/*������ȣ ���� �߰�*/
	@Override
	public void managerInsert(BoardVO boardvo) throws Exception{
		
		System.out.println("(Baord_DAOImpl)���� ������ȣ ���� �߰�");
		
		session.insert("com.inhatc.mapper.BoardMapper.managerInsert",boardvo);
	}
	
	/*������ȣ ���� ����*/
	@Override
	public void managerDelete(BoardVO board) throws Exception{
		
		System.out.println("(Baord_DAOImpl)���� ������ȣ ���� ����");
		
		session.delete(namespace + ".managerDelete", board);
	
	}
	
	/*������ȣ ���*/
	@Override
	public List<BoardVO> informationList(BoardVO board) throws Exception{
		
		System.out.println("(Baord_DAOImpl)���� ������ȣ ���� ��� �ҷ�����");
		
		return session.selectList(namespace + ".informationList", board);
	}
	
	/*�μ�*/
	@Override
	public List<BoardVO> listAll_p(BoardVO board) throws Exception{
		
		System.out.println("(Baord_DAOImpl)���� �μ�κ�");
		
		return session.selectList(namespace + ".listAll_p", board);
	}
}
	
