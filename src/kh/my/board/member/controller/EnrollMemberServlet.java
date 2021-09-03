package kh.my.board.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.my.board.member.model.service.MemberService;
import kh.my.board.member.model.vo.Member;

/**
 * Servlet implementation class EnrollMemberServlet
 */
@WebServlet("/enroll") // 회원가입
public class EnrollMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO: 회원가입
		// 데이터 임의로 넣으면 됨.
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out  = response.getWriter();
		
		// 화면에 받아온 데이터 - 임시
		String member_id = "qwoeiruqwpoei";
		String member_pwd = "aa";
		String member_name = "HarryPotter";
		char gender = 'M'; 
		String email = "magic@potter.com";
		String phone = "010-1111-1111";
		String address = "Hogwarts";
		int age = 16;
//		Date enroll_date = ;
		
		// 화면 데이터를 vo에 싣기
		Member vo = new Member(member_id, member_pwd, member_name, gender, email, phone, address, age, null);
		
		// vo를 가지고 회원가입하러 DAO로 출발~~~
		int result = new MemberService().insertMember(vo);
		// 오류발생 : -1, 가입성공 : 1, 가입실패 : 0, 기존회원있으면 : 2, 가장 큰 수0xFF
		if(result == 1) {
			out.println("😊" + member_id + "님 가입되었습니다. 환영합니다! 😊");
		} else if (result == 2) {
			out.println("😝 기존회원 id가 존재합니다. 😝");
		} else { // 오류발생 : -1, 그 외 등등, 가입실패 : 0
			out.println(" 😥 예기치 못한 오류 발생. 다시 시도해 주세요. 😥");
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
