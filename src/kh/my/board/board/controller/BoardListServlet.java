package kh.my.board.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.my.board.board.model.service.BoardService;
import kh.my.board.board.model.vo.Board;
import kh.my.board.member.model.service.MemberService;
import kh.my.board.member.model.vo.Member;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/boardlist")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out  = response.getWriter();
		
		final int PAGE_SIZE = 20; // 한 페이지 당 글 수
		final int PAGE_BLOCK = 3; // 한 화면에 나타날 페이지 링크 수
		int bCount = 0; // 총 글수
		int pageCount = 0; // 총 페이지수
		int startPage = 1; // 화면에 나타날 시작 페이지
		int endPage = 1; // 화면에 나타날 마지막 페이지
		int currentPage = 1;
		int startRnum = 1; // 화면에 글
		int endRnum = 1; // 화면에 글
		
		String pageNum = request.getParameter("pagenum");
		if(pageNum !=null) { // 눌려진 페이지가 있음.
				currentPage=Integer.parseInt(pageNum);// 눌려진 페이지
		}
		
		// 총 글수
		bCount = new BoardService().getBoardCount();
		//총 페이지수 = (총 글 수 / 페이지당글수) + (총글개수에서 페이지당글수로 나눈 나머지가 0이 아니라면 페이지개수를 1 증가)
		pageCount = (bCount / PAGE_SIZE) + (bCount % PAGE_SIZE == 0 ? 0:1);
		// rownum 조건 계산
		startRnum = (currentPage-1) * PAGE_SIZE + 1; // 1//6//11//16 이렇게 나온다. 
		endRnum = startRnum + PAGE_SIZE -1;
		if(endRnum > bCount) endRnum = bCount;
		
		if (currentPage % PAGE_BLOCK == 0) {
			startPage = (currentPage / PAGE_BLOCK -1) * PAGE_BLOCK + 1;
		} else {
			startPage = (currentPage / PAGE_BLOCK) * PAGE_BLOCK + 1;
		}
		endPage = startPage + PAGE_BLOCK -1;
		if(endPage > pageCount) endPage = pageCount;
		
		ArrayList<Board> volist  = new BoardService().selectBoardList(startRnum,endRnum);
		
		request.setAttribute("boardvolist", volist);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		
		request.getRequestDispatcher("/boardlist.jsp").forward(request, response);
				
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
