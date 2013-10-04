package blog.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.model.Blog;
import blog.service.IBlogService;
import blog.common.base.BaseServlet;

public class IndexServlet extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5515712711515582568L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		IBlogService blogService = (IBlogService) this
				.getServiceBean("blogService");
		List<Blog> blogs = blogService.getBlogsForIndex(10);
		request.setAttribute("blogs", blogs);
		RequestDispatcher dp = request.getRequestDispatcher("index.jsp");
		dp.forward(request, response);
	}
}
