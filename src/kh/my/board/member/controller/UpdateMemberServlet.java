package kh.my.board.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.my.board.member.model.service.MemberService;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/updatemember")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		String member_id = request.getParameter("id");
		String member_pwd = request.getParameter("pw");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		int result = new MemberService().updateMember(member_id, member_pwd, email, phone, address);
		if(result == 1) {
			out.println("ππ»" + member_id + "λμ μ λ³΄κ° μ μμ μΌλ‘ μλ°μ΄νΈ μλ£λμμ΅λλ€." + "ππ»");
		} else {
			out.println("νμμ λ³΄λ₯Ό μλ°μ΄νΈνμ§ λͺ»νμμ΅λλ€. λ€μ μλν΄μ£ΌμΈμ.");
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
