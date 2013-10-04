package blog.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.model.Blog;

import blog.service.IBlogService;

import blog.common.base.BaseServlet;

public class GetBlogDetailServlet extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4157676510083899928L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		IBlogService blogService = (IBlogService) this
				.getServiceBean("blogService");
		Blog blog = new Blog();
		blog.setBlogId(Long.parseLong(request.getParameter("blogId")));
		Blog reBlog = blogService.getBlog(blog);
		response.getWriter().print(reBlog.getContent());
	}
}
