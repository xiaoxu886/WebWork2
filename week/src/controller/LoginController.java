package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.User;
import dao.UserDao;

@WebServlet(urlPatterns = "/login.do")
public class LoginController extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String vcode = request.getParameter("vcode");
		
		HttpSession session = request.getSession();
		String saveVcode = (String )session.getAttribute("verifyCode");
		
		String forwardPath = "";
		
		if(!vcode.equalsIgnoreCase(saveVcode)){
			request.setAttribute("info", "验证码不对");
			forwardPath = "/error.jsp";
		}
		else{//用户名存在
			UserDao userDao = new UserDao();
			
			if(userDao.get(userName) == null){
				request.setAttribute("info", "您输入的用户名不存在");
				forwardPath = "/error.jsp";
			}
			else{
				
				if(!userDao.get(userName).getPassword().equals(password)){//密码不正确
					session.setAttribute("info", "您输入的密码不正确");
					forwardPath = "/error.jsp";
				}
				else{//用户名密码正确
					if("on".equalsIgnoreCase(auto)){
						Cookie cookie=new Cookie("username",userName);
						cookie.setPath("/");
						cookie.setMaxAge(60*60*12*7);
						response.addCookie(cookie);
					}
					session.setAttribute("currentUser", userDao.get(userName));
					forwardPath = "/main.jsp";
				}
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
		
		rd.forward(request, response);
	}

}
