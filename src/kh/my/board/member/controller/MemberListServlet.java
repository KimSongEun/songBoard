package kh.my.board.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.my.board.member.model.service.MemberService;
import kh.my.board.member.model.vo.Member;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/memberlist")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
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
		
		// member를 db에서 읽어와야함.
				ArrayList<Member> volist  = new MemberService().readMemberListAll();
				
				// member 리스트를 화면에 출력
				for (Member vo : volist) {
					out.println("<p>" + "💡 회원 아이디 : " + vo.getMember_id() + "</p>");
					out.println("<p>" + "✏ 회원 비밀번호 : " + vo.getMember_pwd() + "</p>");
					out.println("<p>" + "📑 회원명 : " + vo.getMember_name() + "</p>");
					out.println("<p>" + "🕶 성별 : " + vo.getGender() + "</p>");
					out.println("<p>" + "🖋 이메일 : " + vo.getEmail() + "</p>");
					out.println("<p>" + "☎ 연락처 : " + vo.getPhone() + "</p>");
					out.println("<p>" + "🏡 주소 : " + vo.getAddress() + "</p>");
					out.println("<p>" + "🖐 나이 : " + vo.getAge() + "</p>");
					out.println("<p>" + "📆 가입일 : " + vo.getEnroll_date() + "</p>");
					out.println("<p>" + "💸 포인트 : " + vo.getPoint() + "</p>");
					out.println("<p>" + "-------------------------" + "</p>");
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
