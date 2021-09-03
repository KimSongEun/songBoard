package kh.my.board.board.model.service;

import static kh.my.board.common.JdbcTemplate.close;
import static kh.my.board.common.JdbcTemplate.getConnection;
import static kh.my.board.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import kh.my.board.board.model.dao.BoardDao;
import kh.my.board.board.model.vo.Board;
import kh.my.board.common.JdbcTemplate;

public class BoardService {

	public BoardService() {
	}
	
	public Board getBoard(int bno) {
		Board vo = null;
		Connection conn = JdbcTemplate.getConnection();
		vo = new BoardDao().getBoard(conn, bno);
		JdbcTemplate.close(conn);
		return vo;
	}
	
	public int updateContent(String content, String writer, int bno) {
		int result = -1;
		Connection conn = getConnection();
		result = new BoardDao().updateContent(conn, content, writer, bno);
		close(conn);
		return result;
	}
	
	public int deleteContent(String writer, int bno) {
		int result = -1; 
		Connection conn = getConnection();
		result = new BoardDao().deleteContent(conn, writer, bno);
		close(conn);
		return result;
	}
	
	public int getBoardCount() {
		int result = 0;
		Connection conn = JdbcTemplate.getConnection();
		
		result = new BoardDao().getBoardCount(conn);
		
		JdbcTemplate.close(conn);
		return result; 
	}
	
	
	public ArrayList<Board> selectBoardList(int start, int end){
		ArrayList<Board> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		
		volist = new BoardDao().selectBoardList(conn, start, end);
		
		JdbcTemplate.close(conn);
		return volist;
	}
	
	public ArrayList<Board> selectBoardList(){
		ArrayList<Board> volist = null;
		Connection conn = JdbcTemplate.getConnection();
		
		volist = new BoardDao().selectBoardList(conn);
		
		JdbcTemplate.close(conn);
		return volist;
	}
	
	public int insertBoard(Board vo) {
		int result = -1;
		Connection conn = JdbcTemplate.getConnection();
		
		result = new BoardDao().insertBoard(conn, vo);
		
		JdbcTemplate.close(conn);
		return result; 
	}
	
	
}
