package web_member_mgn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_member_mgn.dto.Member;
import web_member_mgn.service.MemberService;

@WebServlet("/AddMember")
public class AddMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Member addMember = getMember(request);
			service.joinMember(addMember);
			request.getRequestDispatcher("memberList").forward(request, response);
		}catch (RuntimeException e) {
			request.getRequestDispatcher("joinForm.jsp").forward(request, response);
		}
		
	}

	private Member getMember(HttpServletRequest request) throws ServletException, IOException {
		Member member = null;
		try {
			String id = request.getParameter("id").trim();
			String passwd = request.getParameter("pass").trim();
			String name = request.getParameter("name").trim();
			int age = Integer.parseInt(request.getParameter("age").trim());
			String gender = request.getParameter("gender").trim();
			String email = request.getParameter("email").trim();
			member = new Member(id, passwd, name, age, gender, email);
		}catch (Exception e) {
			throw new RuntimeException();
		}
		return member;
		
	}

}