package kh.my.board.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.my.board.board.model.service.BoardService;
import kh.my.board.board.model.vo.Board;

/**
 * Servlet implementation class BoardReWriteServlet
 */
@WebServlet("/boardwrite.kh")
public class BoardReWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		Board oVo = null;
		String viewBno = request.getParameter("bno"); // 현재 보고있는 bno 번호
		if(viewBno == null || viewBno.equals("")|| viewBno.equals("null")) { // 기존 읽고 있던 글이 없다면 원본 새글쓰기로 인식
			oVo = new Board();
		} else {
		int bno = Integer.parseInt(viewBno);
		oVo = new BoardService().getBoard(bno);// 내가 답을 달려고 하는 글의 Vo (original)
		}
		String title = request.getParameter("title"); 
		String content = request.getParameter("content");
		String writer = (String)request.getSession().getAttribute("memberLoginInfo");
		if(writer == null) {
			writer = "user01"; // TODO: 임시 user 설정, login정보 없을 경우 로그인 하라고 하기
		}
		out.println("✍🏻 title: " + title);
		out.println("<br>✍🏻 content: " + content);
		
		Board vo = new Board(oVo.getBno(), title, content, writer, oVo.getBref(), oVo.getBreLevel(), oVo.getBreStep());
		
		int result = new BoardService().insertBoard(vo);
		response.sendRedirect("boardlist");
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
