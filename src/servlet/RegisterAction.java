package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import db.DBStudent;

/**
 * Servlet implementation class RegisterAction
 */
@WebServlet("/RegisterAction")
public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBStudent db_stu = new DBStudent();
		
		if (!db_stu.checkusername(request.getParameter("username"))) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String usermail = request.getParameter("usermail");
			String usertel = request.getParameter("usertel");
			String address = request.getParameter("address");
			
			Student student = new Student();
			student.setUsername(username);
			student.setPassword(password);
			student.setUsermail(usermail);
			student.setUsertel(usertel);
			student.setAddress(address);
			
			db_stu.register(student);
			/**
			 * 注册成功跳转
			 */
		}else {
			/**
			 * 注册失败跳转
			 */
		}
		
	}

}