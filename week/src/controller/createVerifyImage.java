package controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CreateImage;

@WebServlet(urlPatterns ="/creatVerifyImage.do")
public class createVerifyImage extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CreateImage createImage = new CreateImage();
		
		String vCode = createImage.createCode();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("verifyCode",vCode);
		
		response.setContentType("img/jpeg");
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control", "no-cache");
		
		BufferedImage image = createImage.CreateImage(vCode);
		
		ServletOutputStream out = response.getOutputStream();
		
		ImageIO.write(image, "JPEG", out);
		
		out.flush();
		out.close();
	}

}
