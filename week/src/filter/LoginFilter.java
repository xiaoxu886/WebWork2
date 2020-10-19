package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*") 

public class LoginFilter implements Filter {


	public void destroy() {
		// TODO Auto-generated method stub

	}

	
	public void doFilter(ServletRequest req, ServletResponse reqs,
			FilterChain chain) throws IOException, ServletException {
		//0.强制转换 
			HttpServletRequest request = (HttpServletRequest) req;
		
		//1.获取资源请求
			String uri = request.getRequestURI();
		//2.判断是否包含登录相关资源路径
			if(uri.contains("/login.html") || uri.contains("/creatVerifyImage.do")  || uri.contains("/css/") 
					|| uri.contains("/js/") || uri.contains("/images/") || uri.contains("/login.do"))
			{
				//包含,用户就是想登录。放行
				chain.doFilter(req, reqs);
			}else{
				//不包含，需要验证用户是否登录
				//3.从获取session中获取user
		  		Object user = request.getSession().getAttribute("user");
		  		if(user != null){
		  			//登录了，放行
		  			chain.doFilter(req, reqs);
		  		}else{
		  			//没有登录，跳转登录页面
		  			
		  			request.setAttribute("info","您尚未登录，请登录");
		  			request.getRequestDispatcher("/error.jsp").forward(request, reqs);
		  		}
		  		
			}
			

	}

	
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

}
